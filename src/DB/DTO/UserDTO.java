package DB.DTO;

import java.sql.Timestamp;

/**
 * Created by ParkBeomChan-PC-W1 on 2016-01-04.
 */
public class UserDTO {

    private String id =null;
    private String pw =null;
    private String nick=null;


    public UserDTO(String id, String pw, String nick) {
        this.id = id;
        this.pw = pw;
        this.nick = nick;
    }

    public UserDTO(String id, String pw) {
        this.id = id;
        this.pw = pw;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPw() {
        return pw;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }
}
