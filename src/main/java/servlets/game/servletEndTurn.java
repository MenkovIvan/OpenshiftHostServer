package servlets.game;

import database.UpdateInformation;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/api/endturn")
public class servletEndTurn  extends HttpServlet {
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
        System.out.println("servletEndTurn - start");
        String login = req.getParameter("login");
        String whoPlay = req.getParameter("whoplay");
        int lvl = Integer.parseInt(req.getParameter("lvl"));
        int power = Integer.parseInt(req.getParameter("power"));
        //int ndoors = Integer.parseInt(req.getParameter("ndoors"));
        //int ntrs = Integer.parseInt(req.getParameter("ntrs"));
        String trs = req.getParameter("doors");
        String doors = req.getParameter("trs");
        System.out.println("  from login: " + login);
        //System.out.println("  trs: " + trs);
        //System.out.println("  doors: " + doors);
        //System.out.println("  ntrs: " + ntrs);
        //System.out.println("  ndoors: " + ndoors);
        System.out.println("  power: " + power);
        System.out.println("  lvl: " + lvl);
        System.out.println("servletEndTurn - end");

        try {
            UpdateInformation.updateTrs(login,trs);
            UpdateInformation.updateDoors(login,doors);
            //UpdateInformation.updateNDoors(login,ndoors);
            //UpdateInformation.updateNTrs(login,ntrs);
            UpdateInformation.updateLvl(login,lvl);
            UpdateInformation.updatePower(login,power);
            UpdateInformation.updateEndTurn(login,0);
            UpdateInformation.updateEndTurn(whoPlay,1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        os.print("0");
    }
}
