import arc.*;
import java.awt.image.*;

public class FinalCPTSarah{
	public static void main(String[] args){
		Console con = new Console();
		
		boolean blnChoice = true;
		char chrChoice = '1';
		
		// Title Screen
		con.println(" ");
		BufferedImage imgtitle = con.loadImage("Connect4Title.png");		
		con.drawImage(imgtitle, -180, -100);
		con.clear();
		con.println("Loading...");
		con.sleep(3000);
		
		
		while(blnChoice = true){
			con.clear();
			mainMenu(con);
			blnChoice = false;
			break;
		}
	}
	// Main Menu
	public static void mainMenu(Console con){
		con.println("CONNECT 4");
		//con.sleep(1000);
		con.println("MENU-----------------------------------------------------");
		con.println("(P)lay");
		con.println("(V)iew Highscores");
		con.println("(T)heme");
		con.println("(H)elp");
		con.println("(Q)uit");	
		//boolean blnChoice = false;
	}
}
