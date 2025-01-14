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
		
		// Set Default Player Names
		String strPlayerInfo[][];
		strPlayerInfo = new String[2][2]; 
		strPlayerInfo[0][0] = "";
		
		// Set Default Turns
		int intPlayerTurn = 0;
		String strPlayAgain;
		
		// Set Default Choice & Gameplay Variables
		int intColumnChoice = 0;
		boolean blnPlay2;
		String strPlayerPiece;
		boolean blnGameplay = true;
		
		// Set Default Wins
		int intPlayer1Wins;
		int intPlayer2Wins;
		
		// Set Default Wins
		intPlayer1Wins = 0;
		intPlayer2Wins = 0;
		blnPlay2 = true;
		
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
					
					// Ask for Name
					con.print("Player 1, please enter your name: ");
					strPlayerInfo[0][0] = con.readLine();
					con.print("Player 2, please enter your name: ");
					strPlayerInfo[0][1] = con.readLine();
					con.println(" ");
					
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
		
		while(blnGameplay == true){
			// Set Default Board
			String strBoard[][];
			strBoard = new String[6][7]; 
			int intRow = 0;
			int intColumn = 0;
			
			for(intRow = 0; intRow < 6; intRow++){
				for(intColumn = 0; intColumn < 7; intColumn++){
					strBoard[intRow][intColumn] = "| ";
					con.print(strBoard[intRow][intColumn]);
				}
				con.println("|");
			}
			con.println("---------------");
			con.println(" 1 2 3 4 5 6 7");
			
			boolean blnInteraction;
			
			while(blnPlay2 == true){
				// Display Score @ Top
				con.println(" ");
				con.println("SCORE--------------------------------------------------------------------------");
				con.println(strPlayerInfo[0][0] + ": " + intPlayer1Wins);
				con.println(strPlayerInfo[0][1] + ": " + intPlayer2Wins);
				con.println(" ");
				
				// Determine whether 1 or 2 goes - 1 go if ODD
				if(intPlayerTurn % 2 != 1){ 
					strPlayerPiece = "|O";
					blnInteraction = true;
					con.println(strPlayerInfo[0][intPlayerTurn]+"'s (1) turn ---------------------------------------");
					while(blnInteraction == true){
						con.print("Please choose a column (type the number): ");
						intColumnChoice = con.readInt();
						// Validate Column Choice
						if(intColumnChoice < 1 || intColumnChoice > 7){
							con.println("Invalid column. Please choose a column between 1 & 7.");
						}else if(!strBoard[0][intColumnChoice - 1].equals("| ")) {
							con.println("Column is full. Please choose another column.");
						}else{
							// Valid Column Choice
							blnInteraction = false;
							intColumnChoice -= 1;
						}
					}
					con.println("");
					// Add Piece to Board
					for(intRow = 5; intRow >= 0; intRow--){
						if(strBoard[intRow][intColumnChoice].equals("| ")){ 
							strBoard[intRow][intColumnChoice] = strPlayerPiece;
							break;
						}
					}
					// Redraw Entire Board
					for(intRow = 0; intRow < 6; intRow++){
						for(intColumn = 0; intColumn < 7; intColumn++){
							con.print(strBoard[intRow][intColumn]);
						}
						con.println("|"); 
					}
					con.println("---------------");
					con.println(" 1 2 3 4 5 6 7");
					
					// Check Connect 4
					if(checkConnect4(strBoard, strPlayerPiece)){
						con.println(strPlayerInfo[0][0] + " wins!");
						intPlayer1Wins += 1;
						blnPlay2 = false;
					}else{
						// Update Player Turn
						intPlayerTurn += 1;
					}
				}else{
					strPlayerPiece = "|X";
					blnInteraction = true;
					con.println(strPlayerInfo[0][1]+"'s (2) turn");
					while(blnInteraction == true){
						con.print("Please choose a column (type the number): ");
						intColumnChoice = con.readInt();
						// Validate Column Choice
						if(intColumnChoice < 1 || intColumnChoice > 7){
							con.println("Invalid column. Please choose a column between 1 & 7.");
						}else if(!strBoard[0][intColumnChoice - 1].equals("| ")) {
							con.println("Column is full. Please choose another column.");
						}else{
							// Valid Column Choice
							blnInteraction = false;
							intColumnChoice -= 1;
						}
					}
					con.println("");
					// Add Piece to Board
					for(intRow = 5; intRow >= 0; intRow--){
						if(strBoard[intRow][intColumnChoice].equals("| ")){ 
							strBoard[intRow][intColumnChoice] = strPlayerPiece;
							break;
						}
					}
					// Redraw Entire Board
					for(intRow = 0; intRow < 6; intRow++){
						for(intColumn = 0; intColumn < 7; intColumn++){
							con.print(strBoard[intRow][intColumn]);
						}
						con.println("|"); 
					}
					con.println("---------------");
					con.println(" 1 2 3 4 5 6 7");
					
					// Check Connect 4
					if(checkConnect4(strBoard, strPlayerPiece)){
						con.println(strPlayerInfo[0][1] + " wins!");
						intPlayer2Wins += 1;
						blnPlay2 = false;
					}else{
						// Update Player Turn
						intPlayerTurn -= 1;
					}
				}			
			}		
			
			// Display Wins
			con.println(" ");
			con.println(strPlayerInfo[0][0] + " has " + intPlayer1Wins + " wins.");
			con.println(strPlayerInfo[0][1] + " has " + intPlayer2Wins + " wins.");
			
			con.println("Do you want to play again?");
			strPlayAgain = con.readLine();
			
			if(strPlayAgain.equalsIgnoreCase("yes")){
				blnPlay2 = true;
			}else{
				blnGameplay = false;
				
				// Add to Highscores **CHECK FILE LATER
				TextOutputFile highscore = new TextOutputFile("highscores.txt", true);
				highscore.println(strPlayerInfo[0][0]);
				highscore.println(intPlayer1Wins);
				highscore.println(strPlayerInfo[0][1]);
				highscore.println(intPlayer2Wins);
				highscore.close();
			}
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
			intNumber += 1;
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
	
	// Check for Connect 4
	public static boolean checkConnect4(String[][] strBoard, String strPlayerPiece){
		int intR;
		int intC;
		// Check Horizontal
		for(intR = 0; intR < 6; intR++){
			for(intC = 0; intC < 4; intC++){
				if(strBoard[intR][intC].equals(strPlayerPiece) && strBoard[intR][intC+1].equals(strPlayerPiece) && strBoard[intR][intC+2].equals(strPlayerPiece) && strBoard[intR][intC+3].equals(strPlayerPiece)){
					return true;
				}
			}
		}
		// Check Vertical
		for(intR = 0; intR < 3; intR++){
			for(intC = 0; intC < 7; intC++){
				 if(strBoard[intR][intC].equals(strPlayerPiece) && strBoard[intR+1][intC].equals(strPlayerPiece) && strBoard[intR+2][intC].equals(strPlayerPiece) && strBoard[intR+3][intC].equals(strPlayerPiece)){
                    return true;
				}
			}
		}
		// Check Diagnal 1 (\)
		for(intR = 0; intR < 3; intR++){
			for(intC = 0; intC < 7; intC++){
				 if(strBoard[intR][intC].equals(strPlayerPiece) && strBoard[intR+1][intC+1].equals(strPlayerPiece) && strBoard[intR+2][intC+2].equals(strPlayerPiece) && strBoard[intR+3][intC+3].equals(strPlayerPiece)){
                    return true;
				}
			}
		}
		// Check Diagnal 2 (/)
		for(intR = 0; intR < 6; intR++){
			for(intC = 0; intC < 4; intC++){
				if(strBoard[intR][intC].equals(strPlayerPiece) && strBoard[intR-1][intC+1].equals(strPlayerPiece) && strBoard[intR-2][intC+2].equals(strPlayerPiece) && strBoard[intR-3][intC+3].equals(strPlayerPiece)){
					return true;
				}
			}
		}
		// No Connect 4
		return false;
	}	
	
	// Themes
	
}
