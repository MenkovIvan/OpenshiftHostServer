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

@WebServlet("/api/checknumber")
//0 - number=1 //pervyi hod, pervogo igroka
//1 - number=2 //pervyi hod, vtorogo igroka
//-1 - endturn=0 //ne tvoi hod
//2 - number=-1 //ostalnie hodi
public class servletCheckNumber  extends HttpServlet {
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
            if (GetInformation.getEndTurn(CheckInformation.nameToId(login)) == 0) {
                os.print("-1");
            }
            else if (GetInformation.getNumber(CheckInformation.nameToId(login)) == -1){
                os.print("2");
            }
            else if(GetInformation.getNumber(CheckInformation.nameToId(login)) == 2){
                os.print("1");
                System.out.println("    pervyi hod, vtorogo igroka");
            }
            else if(GetInformation.getNumber(CheckInformation.nameToId(login)) == 1){
                os.print("0");
                System.out.println("    pervyi hod, pervogo igroka");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}