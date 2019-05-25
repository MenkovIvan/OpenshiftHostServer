package servlets;

import filebase.PlayerSearch;
import filebase.ReadFile;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/api/status")
public class servletStatus extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletOutputStream os = resp.getOutputStream();
        String login = req.getParameter("loginnew");
        System.out.println("login_new: "+login);
        ReadFile rf = new ReadFile();
        ArrayList players = new ArrayList();
        PlayerSearch playerSearch = new PlayerSearch();
        try {
            rf.read(players);
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        int id = playerSearch.checkLogin(players,login);
        if (id==-1){
            os.print("yes");
        }
        else os.print("no");
    }
}
