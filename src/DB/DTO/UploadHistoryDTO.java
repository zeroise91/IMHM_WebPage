package DB.DTO;

/**
 * Created by ParkBeomChan-PC-W1 on 2016-01-21.
 */
public class UploadHistoryDTO {
    private String id = null;
    private  Double latitude = null;
    private  Double longitude= null;
    private  Integer musicIdx = null;

    public UploadHistoryDTO(String id, Double latitude, Double longitude, Integer musicIdx) {
        this.id = id;
        this.latitude = latitude;
        this.longitude = longitude;
        this.musicIdx = musicIdx;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Integer getMusicIdx() {
        return musicIdx;
    }

    public void setMusicIdx(Integer musicIdx) {
        this.musicIdx = musicIdx;
    }
}
