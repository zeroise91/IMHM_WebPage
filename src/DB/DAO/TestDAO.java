package DB.DAO;

import Config.Config;
import DB.DTO.testDTO;
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
public class TestDAO {

    SqlSessionFactory sessionfactory=null;
    SqlSession session = null;
    InputStream inputStream = null;

    public TestDAO() {

    }

    public List<testDTO> getAlbumnames(String Title){
        getSession();
        List<testDTO> res= session.selectList("test",Title);
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
