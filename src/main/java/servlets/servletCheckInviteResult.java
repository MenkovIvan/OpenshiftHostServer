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

@WebServlet("/api/checkinviteresult")
public class servletCheckInviteResult extends HttpServlet {
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
        int id = Integer.parseInt(req.getParameter("id"));
        System.out.println("servletCheckInviteResult start");
        System.out.println("  prinyl id: " + id);

        try {

            if(CheckInformation.getMeInvite(id) == -1 && CheckInformation.getIInvite(id) >0) {
                os.print("-1");
                System.out.println("  res = -1");
            }

            else if (CheckInformation.getMeInvite(id) == 0 && CheckInformation.getIInvite(id) > 0){
                String temp = CheckInformation.idToName(CheckInformation.getIInvite(id));
                os.print(temp);
                System.out.println("  res = " + temp);
            }

            else if (CheckInformation.getMeInvite(id) == -1 && CheckInformation.getIInvite(id) == -1) {
                os.print("0");
                System.out.println("  res = 0");
            } else {os.print("-2"); System.out.println("  res = -2");}

        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("servletCheckInviteResult end");
    }
}

