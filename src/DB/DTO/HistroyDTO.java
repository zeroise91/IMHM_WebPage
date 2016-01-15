package DB.DTO;

import Config.DateFormatter;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

/**
 * Created by ParkBeomChan-PC-W1 on 2016-01-04.
 */
public class HistroyDTO {

    private String title= null;
    private String albumname = null;
    private String artist= null;
    private Timestamp search_date= null;
    private Double Longtitude =null;
    private Double Latitude =null;
    private Integer musicIdx=null;

    public HistroyDTO(String title, String albumname, String artist, Timestamp search_date, Double longtitude, Double latitude, Integer musicIdx) {
        this.title = title;
        this.albumname = albumname;
        this.artist = artist;
        this.search_date = search_date;
        Longtitude = longtitude;
        Latitude = latitude;
        this.musicIdx = musicIdx;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAlbumname() {
        return albumname;
    }

    public void setAlbumname(String albumname) {
        this.albumname = albumname;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public Timestamp getSearch_date() {
        return search_date;
    }

    public void setSearch_date(Timestamp search_date) {
        this.search_date = search_date;
    }

    public Double getLongtitude() {
        return Longtitude;
    }

    public void setLongtitude(Double longtitude) {
        Longtitude = longtitude;
    }

    public Double getLatitude() {
        return Latitude;
    }

    public void setLatitude(Double latitude) {
        Latitude = latitude;
    }

    public Integer getMusicIdx() {
        return musicIdx;
    }

    public void setMusicIdx(Integer musicIdx) {
        this.musicIdx = musicIdx;
    }

    @Override
    public String toString() {
        return "{" +
                "\"title\":\"" + title + '\"' +
                ", \"albumname\":\"" + albumname + '\"' +
                ", \"artist\":\"" + artist + '\"' +
                ", \"search_date\":\"" + DateFormatter.getInstance().format(search_date)+ '\"' +
                ", \"Longtitude\":" + Longtitude +
                ", \"Latitude\":" + Latitude +
                ", \"musicIdx\":" + musicIdx +
                '}';
    }
}
