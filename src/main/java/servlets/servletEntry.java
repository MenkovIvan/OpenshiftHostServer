package servlets;

import filebase.PlayerSearch;
import filebase.ReadFile;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

@WebServlet("/api/login")
public class servletEntry extends javax.servlet.http.HttpServlet{
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
            ReadFile rf = new ReadFile();
            ArrayList players = new ArrayList();
            try {
                rf.read(players);
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            PlayerSearch playerSearch = new PlayerSearch();
            int id = playerSearch.checkPlayer(players,login,password);
            resp.getWriter().print("<br> No such id");
            os.print(id);
        }
}
