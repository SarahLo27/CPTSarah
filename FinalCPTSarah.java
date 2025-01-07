import arc.*;
import java.awt.image.*;

public class FinalCPTSarah{
	public static void main(String[] args){
		
		// Title Screen
		Console console = new Console(1280, 720);
		BufferedImage imgtitle = console.loadImage("connect4title.jpg");		
		console.drawImage(imgtitle, 0, -15);
		console.clear();
		console.println("Loading...");
		console.sleep(3000);
		console.closeWindow();
		
		// Create Default Variables
		boolean blnPlay = false;
		boolean blnChoice = true;
		char chrChoice = '1';
		
		// Main Menu
		Console con = new Console();
		
		while(blnPlay == false){
			// Show Menu Screen
			while(blnChoice == true){
				con.clear();
				mainMenu(con);
				blnChoice = false;
			// Menu Choice
			}while(blnChoice == false) {
				// (P)lay
				if(chrChoice == 'P' || chrChoice == 'p'){
					con.clear();
					con.println("PLAY");
					blnPlay = true;
					break;
				// (V)iew Highscores
				}else if(chrChoice == 'V' || chrChoice == 'v'){
					con.clear();
					con.println("VIEW HIGHSCORES");
					// **INSERT HIGH SCORE COMMAND LATER
					while(blnChoice == false){
						if (chrChoice == 'M' || chrChoice == 'm'){
							blnChoice = true;
						}else{
							chrChoice = 'V';
							chrChoice = con.getChar();
						}
					}
				// (T)heme
				}else if(chrChoice == 'T' || chrChoice == 't'){
					con.clear();
					con.println("THEME");
					// **ADD THEME COMMAND LATER 
					while(blnChoice == false){
						if (chrChoice == 'M' || chrChoice == 'm'){
							blnChoice = true;
						}else{
							chrChoice = 'T';
							chrChoice = con.getChar();
						}
					}
				// (H)elp Menu
				}else if(chrChoice == 'H' || chrChoice == 'h'){
					con.clear();
					con.println("HELP MENU");
					helpMenu(con);
					while(blnChoice == false){
						if (chrChoice == 'M' || chrChoice == 'm'){
							blnChoice = true;
						}else{
							chrChoice = 'H';
							chrChoice = con.getChar();
						}
					}
				// (Q)uit
				}else if(chrChoice == 'Q' || chrChoice == 'q'){
					con.clear();
					con.println("QUIT");
					con.sleep(1000);
					con.closeConsole();
				// Choose Menu Option
				}else{
					chrChoice = con.getChar();
					con.println(chrChoice);
				}
			}
		}
		
		// Set Default Variables
		while(blnPlay == true){
			// add board command
			con.println("TEST YAY");
			// add board
			// add players
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
	
	// Help Menu
	public static void helpMenu(Console con){
		con.println("How To Play--------------------------------------------------------------------");
		con.println("1. Player 1 goes first and types in the number of the column they want to");
		con.println("place their chip in");
		con.println("2. Player 2 then types in the number of the column they want to place");
		con.println("their chip in");
		con.println("3. Whoever gets 4 connecting in a row first wins! It can be diagnoally,");
		con.println("vertically, or horizontally.");
		con.println("                                                            --> (M)ain Menu");
	}
	
	// Board Chip Choice
	

}
