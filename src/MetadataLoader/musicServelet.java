package MetadataLoader;

import Config.Config;
import DB.DTO.MusicDTO;
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

/**
 * Created by ParkBeomChan-PC-W1 on 2016-01-22.
 */
@WebServlet(name = "musicServelet",urlPatterns = "/mobile/searchmusic")
public class musicServelet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("utf-8");
        Integer musicIdx= Integer.parseInt(request.getParameter("musicidx"));
        InputStream inputStream=null;
        SqlSession session =null;
        SqlSessionFactory sessionfactory=null;
        JSONObject obj= new JSONObject();
        MusicDTO dto=null;
        try {
            inputStream =  Resources.getResourceAsStream(Config.mybatispath);
             sessionfactory = new SqlSessionFactoryBuilder().build(inputStream);
            session=sessionfactory.openSession(false);

             dto = session.selectOne("searchMusicByIdx",musicIdx);

        } catch (IOException e) {
            e.printStackTrace();
            obj.clear();
        }finally {
            session.close();
            inputStream.close();
            response.getWriter().write(dto.toString());
        }
    }

}
