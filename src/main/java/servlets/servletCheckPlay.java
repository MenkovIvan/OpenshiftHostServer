package servlets;

import database.CheckInformation;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/api/checkplay")
public class servletCheckPlay extends HttpServlet {
    public void init(ServletConfig servletConfig) {
        try {
            super.init(servletConfig);
        } catch (ServletException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletOutputStream os = resp.getOutputStream();
        String login = req.getParameter("login");
        //System.out.println("login: " + login);

        //esli u igroka me_invite == 0 togda uznaem s kem igraem i check play u oboix

        try {
            if(CheckInformation.getPlay(CheckInformation.nameToId(login)) == 0) {
                os.print("0");
            }
            else
            if (CheckInformation.getMeInvite(CheckInformation.nameToId(login)) == 0){
                int id = CheckInformation.getIInvite(CheckInformation.nameToId(login));
                if (CheckInformation.getPlay(id) == 1){
                    os.print("1");
                }
                else os.print("0");
            }
            else if (CheckInformation.getIInvite(CheckInformation.nameToId(login)) == 0){
                int id = CheckInformation.getMeInvite(CheckInformation.nameToId(login));
                if (CheckInformation.getPlay(id) == 1){
                    os.print("1");
                }
                else os.print("0");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
