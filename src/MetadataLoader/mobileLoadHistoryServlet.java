package MetadataLoader;

import DB.DAO.HistoryDAO;
import DB.DAO.MobileHistoryDAO;
import DB.DTO.HistroyDTO;
import DB.DTO.mobileHistoryDTO;
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
 * Created by ParkBeomChan-PC-W1 on 2016-01-19.
 */
@WebServlet(name = "mobileLoadHistoryServlet", urlPatterns = "/mobile/loadhistory")
public class mobileLoadHistoryServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");

        String id    = request.getParameter("id");
//       int limit    = Integer.parseInt( request.getParameter("limit"));
//       int offset   = Integer.parseInt( request.getParameter("offset"));

        MobileHistoryDAO dao= new MobileHistoryDAO();
        List<mobileHistoryDTO> res= dao.getHistroyList(id);
        JSONObject object= new JSONObject();

        object.put("arraysize",res.size());
        JSONArray array=new JSONArray();
        for (mobileHistoryDTO dto:res) {
            array.add(dto);
        }
        object.put("result",array);

        response.getWriter().write(object.toString());

        }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
