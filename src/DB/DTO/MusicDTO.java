package DB.DTO;

/**
 * Created by ParkBeomChan-PC-W1 on 2016-01-22.
 */
public class MusicDTO {
    private String title =null;
    private String artist =null;
    private String albumname =null;

    public MusicDTO(String title, String artist, String albumname) {
        this.title = title;
        this.artist = artist;
        this.albumname = albumname;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getAlbum() {
        return albumname;
    }

    public void setAlbum(String album) {
        this.albumname = album;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "{" +
                " \"title\":\"" + title + '\"' +
                ", \"album\":\"" + albumname + '\"' +
                ", \"artist\":\"" + artist + '\"' +
               '}';
    }
}
