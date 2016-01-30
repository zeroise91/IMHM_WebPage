package AccessManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by ParkBeomChan-PC-W1 on 2016-01-14.
 */
@WebServlet(name = "LogoutServlet",urlPatterns = "/logout")
public class LogoutServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("SessionID: "+request.getSession().getId());

        request.getSession().invalidate();
        System.out.println("SessionID: "+request.getSession().getId());

        response.sendRedirect("index.jsp");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("SessionID: "+request.getSession().getId()+" remove");

        request.getSession().invalidate();
        System.out.println("SessionID: "+request.getSession().getId()+" created");

        response.sendRedirect("index.jsp");
    }
}
