package DB.DAO;

import Config.Config;
import DB.DTO.HistroyDTO;
import DB.DTO.ImageDTO;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * Created by ParkBeomChan-PC-W1 on 2016-01-09.
 */
public class ImageDAO {
    SqlSessionFactory sessionfactory=null;
    SqlSession session = null;
    InputStream inputStream = null;

    public ImageDAO(){

    }

    public List<ImageDTO> getImage(String id ){

        List<ImageDTO> res=null;
//        System.out.println(id);
        getSession();
        res=session.selectList("searchImage",id);

//        System.out.println("ImageDTO from "+res+"is"+(res==null?true:false)+"count"+res.size());
        closeSession();
        return res;
    }

    private SqlSession getSession(){
        if(session == null){
            try {
                inputStream = inputStream==null? Resources.getResourceAsStream(Config.mybatispath):inputStream;
            } catch (IOException e) {
                e.printStackTrace();
            }
            sessionfactory = new SqlSessionFactoryBuilder().build(inputStream);
            session=sessionfactory.openSession(false);
        }
        return session;
    }

    private void closeSession(){
        if(session!=null) session.close();
        if(inputStream!=null) {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
