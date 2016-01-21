//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package AccessManager;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DB.DAO.UserDAO;
import DB.DTO.UserDTO;
import org.json.simple.JSONObject;

@WebServlet(
        name = "LoginServlet",
        urlPatterns = {"/login"}
)
public class LoginServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("utf-8");
        String id = request.getParameter("id");
        String pw = (request.getParameter("pw"));
        JSONObject obj = new JSONObject();

        UserDAO dao= new UserDAO();

        try{
            List<UserDTO> reslist = dao.checkLogin(id,pw);
            if(reslist.size()==1) {
                obj.put("status", "ok");
                obj.put("id",id);
                obj.put("nick",reslist.get(0).getNick());
                request.getSession().setAttribute("id",id);
                request.getSession().setAttribute("nick",reslist.get(0).getNick());
            }
            else{
                obj.put("status","no");
            }
        }catch (Exception e){
            obj.put("status","no");
            e.printStackTrace();
        }finally {
            response.getWriter().write(obj.toJSONString());
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

}
