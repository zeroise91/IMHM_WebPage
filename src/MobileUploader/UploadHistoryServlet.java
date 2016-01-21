package MobileUploader;

import DB.DAO.HistoryDAO;
import org.json.simple.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by ParkBeomChan-PC-W1 on 2016-01-21.
 */
@WebServlet(name = "UploadHistoryServlet" ,urlPatterns = "/mobile/uploadhistory")
public class UploadHistoryServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HistoryDAO dao= new HistoryDAO();
        String id =request.getParameter("id");
        Double longitude= Double.parseDouble(request.getParameter("longitude"));
        Double latitude= Double.parseDouble(request.getParameter("latitude"));
        Integer musicidx = Integer.parseInt(request.getParameter("musicidx"));

        int res=dao.addHistory(id,longitude,latitude,musicidx);

        JSONObject obj= new JSONObject();
        try {
            if(res==1){
                obj.put("upload","accepted");

            }else {
                obj.put("upload","db error");

            }
        }catch (Exception e){
            obj.put("upload","json error");
        }
        finally {
            response.getWriter().write(obj.toJSONString());
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
