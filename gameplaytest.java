import arc.*;

public class gameplaytest {
	public static void main(String[] args){
		Console con = new Console();
		
		// Set Default Player Names
		String strPlayerInfo[][];
		strPlayerInfo = new String[2][2]; // [number of info][number of players] 
		strPlayerInfo[0][0] = "";
		
		// Set Default Turns
		int intPlayerTurn = 0;
		String strPlayAgain;
		
		// Set Default Choice & Variables
		int intColumnChoice = 0;
		boolean blnPlay = false;
		String strPlayerPiece;
		boolean blnGameplay = true;
		
		// Set Default Wins
		int intPlayer1Wins;
		int intPlayer2Wins;
		
		// Ask for Name
		con.print("Player 1, please enter your name: ");
		strPlayerInfo[0][0] = con.readLine();
		con.print("Player 2, please enter your name: ");
		strPlayerInfo[0][1] = con.readLine();
		con.println(" ");		
		// Set Default Wins
		intPlayer1Wins = 0;
		intPlayer2Wins = 0;
		blnPlay = true;
		
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
			
			while(blnPlay == true){
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
						blnPlay = false;
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
						blnPlay = false;
					}else{
						// Update Player Turn
						intPlayerTurn -= 1;
					}
				}			
			}		
			
			// Display Wins
			con.println(strPlayerInfo[0][0] + " has " + intPlayer1Wins + " wins.");
			con.println(strPlayerInfo[0][1] + " has " + intPlayer2Wins + " wins.");
			
			con.println("Do you want to play again?");
			strPlayAgain = con.readLine();
			
			if(strPlayAgain.equalsIgnoreCase("yes")){
				blnPlay = true;
			}else{
				blnGameplay = false;
				TextOutputFile highscores = newTextOutpl
			}
		}
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
}
