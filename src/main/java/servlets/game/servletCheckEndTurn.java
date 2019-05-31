package servlets.game;

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

@WebServlet("/api/checkendturn")
public class servletCheckEndTurn  extends HttpServlet {
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

        String whoPlay = req.getParameter("whoplay");



        try {
            if (GetInformation.getEndTurn(CheckInformation.nameToId(login)) == 1 && GetInformation.getEndTurn(CheckInformation.nameToId(whoPlay)) == 0){
                String trs = GetInformation.getTrs(CheckInformation.nameToId(whoPlay));
                String doors = GetInformation.getDoors(CheckInformation.nameToId(whoPlay));
                String power = String.valueOf(GetInformation.getPower(CheckInformation.nameToId(whoPlay)));
                String lvl = String.valueOf(GetInformation.getLvl(CheckInformation.nameToId(whoPlay)));
                //String ntrs = String.valueOf(GetInformation.getNTrs(CheckInformation.nameToId(whoPlay)));
                //String ndoors = String.valueOf(GetInformation.getNDoors(CheckInformation.nameToId(whoPlay)));
                if (!doors.equals("-1") && !trs.equals("-1") && !power.equals("-1") && !lvl.equals("-1")){
                    System.out.println("servletCheckEndTurn - start");
                    //System.out.println("  trs: " + trs);
                    //System.out.println("  doors" + doors);
                    System.out.println("  lvl: " + lvl);
                    System.out.println("  power: " + power);
                    //System.out.println("  ntrs: " + ntrs);
                    //System.out.println("  ndoors: " + ndoors);
                    os.print(lvl + " " + power + " " + trs + "| " + doors);
                    System.out.println("servletCheckEndTurn - end");
                    //UpdateInformation.updateEndTurn(whoPlay,0);
                    UpdateInformation.updateNumber(login,-1);
                }
                else os.print("-1");
            }
            else os.print("-1");
        } catch (Exception e) {
            e.printStackTrace();
        }
        os.print("0");
    }
}
