package DB.DAO;

import Config.Config;
import DB.DTO.HistroyDTO;
import DB.DTO.searchOffsetDTO;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * Created by ParkBeomChan-PC-W1 on 2016-01-04.
 */
public class HistoryDAO {
    SqlSessionFactory sessionfactory=null;
    SqlSession session = null;
    InputStream inputStream = null;

    public HistoryDAO(){

    }

    public List<HistroyDTO> getHistroyList(String id, int limit, int offset){

        List<HistroyDTO> list=null;

        getSession();
        list=session.selectList("searchHistory",new searchOffsetDTO(id,limit,offset));
        closeSession();
        return list;
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
