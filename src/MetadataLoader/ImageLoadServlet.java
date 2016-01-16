package MetadataLoader;

import DB.DAO.ImageDAO;
import DB.DAO.TestDAO;
import DB.DTO.ImageDTO;
import DB.DTO.testDTO;

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

        response.setContentType("image/png");
        String title= request.getParameter("idx");
        ImageDAO dao = new ImageDAO();

        List<ImageDTO> dto= dao.getImage(title);
        byte[] binaryimage=dto.get(0).getAlbumimage();
        OutputStream os= response.getOutputStream();
        os.write(binaryimage);
        os.flush();

    }
}
