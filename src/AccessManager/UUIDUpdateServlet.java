package AccessManager;

import Config.Config;
import DB.DTO.MusicDTO;
import DB.DTO.uuidDTO;
import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.json.simple.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;

/**
 * Created by ParkBeomChan-PC-W1 on 2016-02-02.
 */
@WebServlet(name = "UUIDUpdateServlet",urlPatterns = "/mobile/updateuuid")
public class UUIDUpdateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("utf-8");
        request.setCharacterEncoding("utf-8");

            String uuid = request.getParameter("uuid");
            String id= request.getParameter("id");

        System.out.println(id+"  "+uuid);

        InputStream inputStream=null;
        SqlSession session =null;
        SqlSessionFactory sessionfactory=null;
        MusicDTO dto=null;
        int res=-1;
        JSONObject obj = new JSONObject();
        try {
            inputStream =  Resources.getResourceAsStream(Config.mybatispath);
            sessionfactory = new SqlSessionFactoryBuilder().build(inputStream);
            session=sessionfactory.openSession(false);

            res=session.update("updateuuid",new uuidDTO(id,uuid));
            if(res==1){
                session.commit();
                obj.put("updateuuid","ok");
            }
            else{
                session.rollback();
                obj.put("updateuuid","no");

            }
        } catch (IOException|PersistenceException e) {
            e.printStackTrace();
            session.rollback();
            obj.clear();
            obj.put("updateuuid","db error");
        }
        finally {
            session.close();
            inputStream.close();
            response.getWriter().write(obj.toJSONString());
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
