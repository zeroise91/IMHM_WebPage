package DB.DTO;

import java.sql.Timestamp;

/**
 * Created by ParkBeomChan-PC-W1 on 2016-01-09.
 */
public class ImageDTO {
//   private Integer idx = null;
//    private String Title = null;
//    private String Artist = null;
//    private String Albumname=null;
//    private Integer Length= null;
//    private String Genre= null;
    private byte[] Albumimage=null;
//    private byte[] MetaData;
//    private Timestamp ReleaseDate=null;

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
