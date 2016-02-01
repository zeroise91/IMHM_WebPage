package MetadataLoader;

import DB.DAO.ImageDAO;
import DB.DAO.TestDAO;
import DB.DTO.ImageDTO;
import DB.DTO.testDTO;
import sun.misc.BASE64Decoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

/**
 * Created by ParkBeomChan-PC-W1 on 2016-01-09.
 */
@WebServlet(name = "ImageLoadServlet" , urlPatterns = {"/loadimage"})
public class ImageLoadServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


//        response.setContentType("image/jpg");
        Integer idx= Integer.parseInt(request.getParameter("idx"));

        response.sendRedirect("http://evancho.ery.wo.tc:28273/music/image/"+idx);
//        ImageDAO dao = new ImageDAO();
//
//        List<ImageDTO> dto= dao.getImage(idx);
//        OutputStream os= response.getOutputStream();
//
//        try{
//            byte[] binaryimage=dto.get(0).getAlbumimage();
//            binaryimage= new BASE64Decoder().decodeBuffer(new String(binaryimage));
//            System.out.println(new String(binaryimage).substring(0,30));
//            os.write(binaryimage);
//            os.flush();
//        }
//        catch (Exception e){
//            e.printStackTrace();
//            response.sendRedirect("http://dummyimage.com/300/000000/ffffff.png&text=dummy_test");
//
//        }
//        finally {
//            os.close();
//        }
    }
}
