package filebase;

import player.Player;

import java.io.*;
import java.util.ArrayList;

public class ReadFile {

    public void read(ArrayList<Player> players) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("src\\main\\java\\filebase\\Players"));
        String line;
        while ((line=reader.readLine()) != null){
            String[] parts = line.split(" ",3);
            Player p = new Player(parts[1], parts[2], Integer.parseInt(parts[0]));
            players.add(p);
        }
        reader.close();

    }

    public void input(int id, String login, String password) throws IOException{
        FileWriter writer = new FileWriter("src\\main\\java\\filebase\\Players",true);
        String line=Integer.toString(id)+" "+login+" "+password;
        writer.write(line);
        writer.append("\n");
        writer.close();
    }
}