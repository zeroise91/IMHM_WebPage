package AccessManager;

import DB.DAO.UserDAO;
import DB.DTO.UserDTO;
import DB.DTO.UserInfoDTO;
import org.json.simple.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by ParkBeomChan-PC-W1 on 2016-01-03.
 */
@WebServlet(name = "RegisterServlet",urlPatterns = {"/register"})
public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");

        JSONObject obj= new JSONObject();

       String id    = request.getParameter("id");
       String pw    = request.getParameter("pw");
       String nick  = request.getParameter("nick");

        UserDAO dao=new UserDAO();
        try {
            if(dao.canInsertId(id)==false){
                obj.put("status", "IdExists");

            }
            else{
                int res= dao.registerUser(new UserDTO(id,pw,nick));

                switch (res) {
                    case 1: {
                        obj.put("status", "accepted");
                        obj.put("id", id);
                        break;
                    }
                    default:
                        obj.put("status", "IdExists");
                        break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            obj.clear();
            obj.put("status", "error");
        }finally {
            response.getWriter().write(obj.toJSONString());
            System.out.println(obj.toJSONString());
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

}
