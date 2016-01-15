package DB.DTO;

/**
 * Created by ParkBeomChan-PC-W1 on 2016-01-12.
 */
public class searchOffsetDTO {
    private String id=null;
    private Integer limit = null;
    private Integer offset=null;

    public searchOffsetDTO(String id, Integer limit, Integer offset) {
        this.id = id;
        this.limit = limit;
        this.offset = offset;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer getOffset() {
        return offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }
}
