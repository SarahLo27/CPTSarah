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
					viewHighScores(con);
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
		String strPlayer1Name = "";
		String strPlayer2Name = "";
		while(blnPlay == true){
			if(strPlayer1Name.equals(""));{
				con.println("Player 1, please enter your name:");
				strPlayer1Name = con.readLine();
				con.println("Player 2, please enter your name:");
				strPlayer2Name = con.readLine();
			}
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
		con.println("MENU---------------------------------------------------------------------------");
		con.println("(P)lay");
		con.println("(V)iew Highscores");
		con.println("(T)heme");
		con.println("(H)elp");
		con.println("(Q)uit");	
	}
	
	// Help Menu
	public static void helpMenu(Console con){
		// Display Instructions
		con.println("HOW TO PLAY--------------------------------------------------------------------");
		con.println("1. Player 1 goes first and types in the number of the column they want to");
		con.println("place their chip in");
		con.println("2. Player 2 then types in the number of the column they want to place");
		con.println("their chip in");
		con.println("3. Whoever gets 4 connecting in a row first wins! It can be diagnoally,");
		con.println("vertically, or horizontally.");
		
		// Return Back to Homescreen
		con.println("                                                            --> (M)ain Menu");
	}
	
	// View High Scores
	public static void viewHighScores(Console con){
		con.println("HIGH SCORES--------------------------------------------------------------------");
		
		// Open Highscores File
		TextInputFile highscore = new TextInputFile("highscores.txt");
		
		// Calculate the Number of Players
		String strPlayerName;
		int intNumber = 0;
		String strScore = "";
		
		while(highscore.eof() == false){
			strPlayerName = highscore.readLine();
			intNumber = intNumber + 1;
			strScore = highscore.readLine();
		}
		highscore.close();
		
		// Assign Names & Scores to Players
		String strData[][];
		strData = new String[intNumber][2];
		highscore = new TextInputFile("highscores.txt");
		
		while(highscore.eof() == false){
			for(int intCount = 0; intCount < intNumber; intCount++){
				strData[intCount][0] = highscore.readLine(); 
				strData[intCount][1] = highscore.readLine(); 
			}
		}
		highscore.close();
		
		// Bubble Sort
		String strTempName;
		String strTempWins;
		
		for(int intRow2 = 0; intRow2 < intNumber-1; intRow2++){
			for(int intRow = 0; intRow < intNumber-1-intRow2; intRow++){
				if(Integer.parseInt(strData[intRow][1]) < Integer.parseInt(strData[intRow+1][1])){
					strTempName = strData[intRow][0]; 
					strTempWins = strData[intRow][1];
					strData[intRow][0] = strData[intRow + 1][0]; 
					strData[intRow][1] = strData[intRow + 1][1];
					strData[intRow + 1][0] = strTempName; 
					strData[intRow + 1][1] = strTempWins;
				}
			}
		}
		
		for(int intRow = 0; intRow < 10; intRow++){
			con.println(strData[intRow][0] + " | " + strData[intRow][1]);
			con.sleep(500);
		}
		
		//Return Back to Homescreen
		con.println("                                                            --> (M)ain Menu");
	}
	
	// Board Chip Choice
	
	// Themes
	
}
