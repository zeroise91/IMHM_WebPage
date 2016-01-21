package DB.DAO;

import Config.Config;
import DB.DTO.HistroyDTO;
import DB.DTO.mobileHistoryDTO;
import DB.DTO.searchOffsetDTO;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * Created by ParkBeomChan-PC-W1 on 2016-01-20.
 */
public class MobileHistoryDAO {

    private SqlSessionFactory sessionfactory=null;
    private SqlSession session = null;
    private InputStream inputStream = null;

    public MobileHistoryDAO(){

    }

    public List<mobileHistoryDTO> getHistroyList(String id /*,int limit, int offset*/){

        List<mobileHistoryDTO> list=null;

        getSession();
        SqlSession session=sessionfactory.openSession(false);

        list=session.selectList("searchmobileHistory",id);

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
            SqlSession session=sessionfactory.openSession(false);
        }
        return session;
    }

    private void closeSession(){
        if(session!=null) session.close();
        if(inputStream!=null) {
            try {
                inputStream.close();
                inputStream=null;
                session=null;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
