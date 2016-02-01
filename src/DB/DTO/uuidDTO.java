package DB.DTO;

/**
 * Created by ParkBeomChan-PC-W1 on 2016-02-02.
 */
public class uuidDTO {

    private String id= null;
    private String uuid= null;

    public uuidDTO(String id, String uuid) {
        this.id = id;
        this.uuid = uuid;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }
}
