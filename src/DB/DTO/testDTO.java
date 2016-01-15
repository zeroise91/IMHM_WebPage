package DB.DTO;

/**
 * Created by ParkBeomChan-PC-W1 on 2016-01-09.
 */
public class testDTO {

    private String Title=null;
    private String albumname=null;

    public testDTO(String title, String albumname) {
        this.Title = title;
        this.albumname = albumname;
    }

    public testDTO(String albumname) {
        this.albumname = albumname;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getAlbumname() {
        return albumname;
    }

    public void setAlbumname(String albumname) {
        this.albumname = albumname;
    }

    @Override
    public String toString() {
        return "testDTO{" +
                "Title='" + Title + '\'' +
                ", albumname='" + albumname + '\'' +
                '}';
    }
}
