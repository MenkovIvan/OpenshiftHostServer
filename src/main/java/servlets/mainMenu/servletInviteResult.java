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

@WebServlet("/api/inviteresult")
public class servletInviteResult extends HttpServlet {
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
        System.out.println("servletInviteResult - start");
        //System.out.println("  prinyl login: " + login);
        String result = req.getParameter("result");
        //System.out.println("  prinyl result: " + result);

        try {

            int who_id = CheckInformation.searchWhoInvite(CheckInformation.nameToId(login));

            if (result.equals("yes")){

                UpdateInformation.updateI_Invite(login, 0 );

                UpdateInformation.updateMe_Invite(0,CheckInformation.idToName(who_id));
            } else if (result.equals("no")){


                UpdateInformation.updateMe_Invite(-1, login);
                UpdateInformation.updateI_Invite(login, -1);

                UpdateInformation.updateMe_Invite(-1, CheckInformation.idToName(who_id));
                UpdateInformation.updateI_Invite(CheckInformation.idToName(who_id), -1);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        os.print("0");
        System.out.println("servletInviteResult - end");
    }
}
