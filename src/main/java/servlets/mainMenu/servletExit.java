package servlets.mainMenu;

import database.CheckInformation;
import database.UpdateInformation;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/api/exit")
public class servletExit extends HttpServlet {
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
        System.out.println("login: " + login);

        try {
            UpdateInformation.updateOnline(CheckInformation.nameToId(login),0);
            UpdateInformation.updateI_Invite(login,-1);
            UpdateInformation.updateMe_Invite(-1,login);
            UpdateInformation.updatePlay(login,0);
            UpdateInformation.updateEndTurn(login,0);
            UpdateInformation.updatePower(login,1);
            UpdateInformation.updateLvl(login,1);
            UpdateInformation.updateDoors(login,"-1");
            UpdateInformation.updateTrs(login,"-1");
            UpdateInformation.updateNumber(login,1);
            System.out.println("exit - " + login);
        } catch (Exception e) {
            e.printStackTrace();
        }
        os.print("0");
    }
}
