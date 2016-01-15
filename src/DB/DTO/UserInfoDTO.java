package DB.DTO;

/**
 * Created by ParkBeomChan-PC-W1 on 2016-01-09.
 */
public class UserInfoDTO {
    private String id=null;
    private String pw= null;

    public UserInfoDTO(String id, String pw) {
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
}
