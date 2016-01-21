package DB.DAO;

import Config.Config;
import DB.DTO.HistroyDTO;
import DB.DTO.UploadHistoryDTO;
import DB.DTO.searchOffsetDTO;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by ParkBeomChan-PC-W1 on 2016-01-04.
 */
public class HistoryDAO {
   private SqlSessionFactory sessionfactory=null;
   private SqlSession session = null;
   private InputStream  inputStream = null;

    public HistoryDAO(){

    }

    public List<HistroyDTO> getHistroyList(String id, int limit, int offset){
//        int localoffset=0;
//        if(limit<0)limit=0;
//        if(offset>1)localoffset=offset;
//        else offset=1;
        List<HistroyDTO> list=null;

        getSession();
        SqlSession session=sessionfactory.openSession(false);

        list=session.selectList("searchHistory",new searchOffsetDTO(id,limit,offset));
//        if(localoffset==0)list.clear();
        closeSession();

        return list;

    }

    public int addHistory(String id, Double longitude, Double latitude, Integer musicIdx){
        getSession();
        SqlSession session=sessionfactory.openSession(false);

        int res=  session.insert("uploadHistory", new UploadHistoryDTO(id, longitude, latitude, musicIdx));

        if(res==1){
            session.commit();
        }else{
            session.rollback();
        }
        res= res==1 ? res : 0;
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
