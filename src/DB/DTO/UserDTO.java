package DB.DTO;

import java.sql.Timestamp;

/**
 * Created by ParkBeomChan-PC-W1 on 2016-01-04.
 */
public class UserDTO {

    private String id =null;
    private String pw =null;
    private String nick=null;
    private Timestamp timestamp= null;
    private String uuid = null;
    private Integer idx = null;

    public UserDTO(String id, String pw, String nick) {
        this.id = id;
        this.pw = pw;
        this.nick = nick;
    }

    public UserDTO(Integer idx,String id, String pw, String uuid, Timestamp timestamp, String nick) {
        this.id = id;
        this.pw = pw;
        this.nick = nick;
        this.timestamp = timestamp;
        this.uuid = uuid;
        this.idx = idx;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
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
