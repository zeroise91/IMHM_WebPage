package DB.DAO;

import Config.Config;
import DB.DTO.UserDTO;
import DB.DTO.UserInfoDTO;
import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * Created by ParkBeomChan-PC-W1 on 2016-01-04.
 */
public class UserDAO {
    SqlSessionFactory sessionfactory=null;
    SqlSession session = null;
    InputStream inputStream = null;

    public List<UserDTO> checkLogin(String id,String pw)throws Exception{

        inputStream = inputStream==null? Resources.getResourceAsStream(Config.mybatispath):inputStream;
        sessionfactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session=sessionfactory.openSession(false);
        List<UserDTO> reslist;
        reslist= session.selectList("login", new UserInfoDTO(id, pw));

        session.close();
        closeSession();
        return reslist;
    }

    public boolean canInsertId(String id){
        boolean exist = false;
        SqlSession session = null;
        try {

            inputStream = inputStream==null? Resources.getResourceAsStream(Config.mybatispath):inputStream;
            sessionfactory = new SqlSessionFactoryBuilder().build(inputStream);
            session=sessionfactory.openSession(false);

            List<String> list=session.selectList("getIdList",id);
            if(list==null||list.isEmpty())
                exist=true;
            closeSession();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
            exist = false;
        }finally {
            session.close();
            return exist;
        }

    }

    public int registerUser(UserDTO dto){
        int x =-1;
        SqlSession session = null;
        try {
            inputStream = inputStream==null? Resources.getResourceAsStream(Config.mybatispath):inputStream;
            sessionfactory = new SqlSessionFactoryBuilder().build(inputStream);
             session=sessionfactory.openSession(false);

            x=session.insert("register",dto);
            if(x==1){
                session.commit();
            }
            else{
                session.rollback();
            }

        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
        finally {
            session.close();
            return x;
        }

    }



    private void closeSession(){
        if(inputStream!=null) {
            try {
                inputStream.close();
                inputStream=null;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
