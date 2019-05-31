package servlets.start;

import database.AddPlayer;
import database.CheckInformation;
import database.UpdateInformation;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/api/registration")
public class servletRegistration extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletOutputStream os = resp.getOutputStream();
        String login = req.getParameter("login");
        System.out.println("login: "+login);
        String password = req.getParameter("password");
        System.out.println("password: "+password);
        int id = 0;
        try {
            id = CheckInformation.checkLogin(login);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (id !=-1) {
            try {
                AddPlayer.main(login, password);
                id = CheckInformation.checkPlayer(login, password);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        try {
            UpdateInformation.updateOnline(id, 1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        os.print(id);

    }

}
