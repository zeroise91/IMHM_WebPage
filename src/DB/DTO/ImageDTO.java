package DB.DTO;

import java.sql.Timestamp;

/**
 * Created by ParkBeomChan-PC-W1 on 2016-01-09.
 */
public class ImageDTO {

    private byte[] Albumimage=null;

    public byte[] getAlbumimage() {
        return Albumimage;
    }

    public void setAlbumimage(byte[] albumimage) {
        Albumimage = albumimage;
    }

    public ImageDTO(byte[] albumimage) {

        Albumimage = albumimage;
    }
}
