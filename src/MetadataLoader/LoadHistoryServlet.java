package MetadataLoader;

import DB.DAO.HistoryDAO;
import DB.DTO.HistroyDTO;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by ParkBeomChan-PC-W1 on 2016-01-12.
 */
@WebServlet(name = "LoadHistoryServlet",urlPatterns = "/loadhistory")
public class LoadHistoryServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");

        String id= (String)request.getSession().getAttribute("id");
        Integer offset=Integer.parseInt(request.getParameter("offset"));
        Integer limit= Integer.parseInt(request.getParameter("limit"));

        HistoryDAO dao= new HistoryDAO();
        List<HistroyDTO> res= dao.getHistroyList(id,limit,offset);
        JSONObject object= new JSONObject();
        object.put("arraysize",res.size());
        JSONArray array=new JSONArray();
        for (HistroyDTO dto:res) {
            array.add(dto);
        }
        object.put("result",array);
        System.out.println(object);
        response.getWriter().write(object.toJSONString());
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
