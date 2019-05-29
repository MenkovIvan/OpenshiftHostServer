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

@WebServlet("/api/checkinvite")
public class servletCheckInvite extends HttpServlet {
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
        System.out.println("servletCheckInvite start");
        System.out.println("  prinyl login: " + login);
        try {
            int id = CheckInformation.getMeInvite(CheckInformation.nameToId(login));

            if (id > 0 && CheckInformation.getIInvite(CheckInformation.nameToId(login)) == -1 && CheckInformation.getMeInvite(id) == -1 ){
                String temp = CheckInformation.idToName(id);
                System.out.println("  idddddddddddddddddddddddddddddddddd =  >" + id + "<");
                os.print(temp);
                System.out.println("  resssssssssssssssssssssssssssssssssssssssssss = >" + temp + "<");
            } else {
                os.print("0");
                System.out.println("  res =  0");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("servletCheckInvite end");
    }
}
