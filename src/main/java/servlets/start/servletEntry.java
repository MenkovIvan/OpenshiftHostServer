package servlets.start;

import database.CheckInformation;
import database.GetInformation;
import database.UpdateInformation;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/api/login")
public class servletEntry extends HttpServlet {
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
            System.out.println("login: "+login);
            String password = req.getParameter("password");
            System.out.println("password: "+password);

            int id = 0;
            try {
                id = CheckInformation.checkPlayer(login, password);
                int online = GetInformation.getOnline(CheckInformation.nameToId(login));

            if (id < 0){
                System.out.println("Not found player. Try again");
                os.print("-1");
            }
            else {
                if (online == 1) {
                    System.out.println("This player is online");
                    os.print("0");
                } else {
                    System.out.println("player id: " + id);
                    UpdateInformation.updateOnline(id, 1);
                    os.print(id);
                }
            }
            } catch (Exception e) {
                e.printStackTrace();
            }
            //resp.setContentType(String.valueOf(id));

        }


}
