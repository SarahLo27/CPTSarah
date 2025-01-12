import arc.*;

public class gameplaytest {
	public static void main(String[] args){
		Console con = new Console();
		
		// Set Default Player Names
		String strPlayerInfo[][];
		strPlayerInfo = new String[2][2]; // [number of info][number of players] 
		strPlayerInfo[0][0] = "";
		
		// Set Default Turns
		int intPlayerTurn = 1;
		
		// Set Default Wins
		String strPlayerWins[];
		strPlayerWins = new String[2];
		
		// 
		int intColumnChoice = 0;
		boolean blnPlay = false;
		
		// Ask for Name if do not already have a name
		if(strPlayerInfo[0][0].equals(""));{
			// Ask for Name
			con.print("Player 1, please enter your name: ");
			strPlayerInfo[0][0] = con.readLine();
			con.print("Player 2, please enter your name: ");
			strPlayerInfo[0][1] = con.readLine();
			con.println(" ");
			// Set Default Wins
			strPlayerWins[0] = "0";
			strPlayerWins[1] = "0";
			blnPlay = true;
		}
		
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
			con.println("---------------");
		}
		con.println(" 1 2 3 4 5 6 7");
		
		boolean blnInteraction = true;
		
		while(blnPlay == true){
			// Display Score @ Top
			con.println(" ");
			con.println("SCORE--------------------------------------------------------------------------");
			con.println(strPlayerInfo[0][0] + ": " + strPlayerWins[0]);
			con.println(strPlayerInfo[0][1] + ": " + strPlayerWins[1]);
			con.println(" ");
			
			// Determine whether 1 or 2 goes - 1 go if ODD
			if(intPlayerTurn % 2 == 1){ 
				blnInteraction = true;
				con.println(strPlayerInfo[0][0]+"'s (1) turn ---------------------------------------");
				con.print("Please choose a column (type the number): ");
				intColumnChoice = con.readInt();
				while(blnInteraction = true){ 
					if(intColumnChoice >= 8 || intColumnChoice <= 0){
						con.print("Invalid. Please choose a column (type the number): ");
						intColumnChoice = con.readInt();
					}else{
						break;
					}
				}if(intColumnChoice <= 7 && intColumnChoice >= 1){
					intColumnChoice -= 1;
					con.println("");
					for(intRow = 0; intRow < 6; intRow++){
						for(intColumn = 0; intColumn < 7; intColumn++){
							if(intColumnChoice == intColumn){
								if(intRow == 5){
									if(strBoard[5][intColumn] == "| "){
										strBoard[5][intColumn] = "|O";					
										con.print(strBoard[intRow][intColumn]);
									}else{
										con.print(strBoard[intRow][intColumn]);
									}
								}else{
									if(strBoard[intRow+1][intColumn] == "| "){
										con.print(strBoard[intRow][intColumn]);
									}else{
										strBoard[intRow][intColumn] = "|O";		
										con.print(strBoard[intRow][intColumn]);
									}
									//if(strBoard[intRow+1][intColumn] == "|O" || strBoard[intRow+1][intColumn] == "|X"){
										//strBoard[intRow][intColumn] = "|O";
										//con.print(strBoard[intRow][intColumn]);
									//}else{
										//strBoard[intRow][intColumn] = "| ";
										//con.print(strBoard[intRow][intColumn]);
									//}
								}
							}else{
								//strBoard[intRow][intColumn] = "| ";
								con.print(strBoard[intRow][intColumn]);
							}
						}
						con.println("|");
						con.println("---------------");
					}
					con.println(" 1 2 3 4 5 6 7");
					intPlayerTurn += 1;
				}			
			}else{
				blnInteraction = true;
				con.println(strPlayerInfo[0][1]+"'s (2) turn");
				con.print("Please choose a column (type the number): ");
				intColumnChoice = con.readInt();
				while(blnInteraction = true){ 
					if(intColumnChoice >= 8 || intColumnChoice <= 0){
						con.print("Invalid. Please choose a column (type the number): ");
						intColumnChoice = con.readInt();
					}else{
						break;
					}
				}if(intColumnChoice <= 7 && intColumnChoice >= 1){
					intColumnChoice -= 1;
					con.println("");
					for(intRow = 0; intRow < 6; intRow++){
						for(intColumn = 0; intColumn < 7; intColumn++){
							if(intColumnChoice == intColumn){
								if(intRow == 5){
									if(strBoard[5][intColumn] == "| "){
										strBoard[5][intColumn] = "|X";					
										con.print(strBoard[intRow][intColumn]);
									}else{									
										con.print(strBoard[intRow][intColumn]);
									}
								}else{
									if(strBoard[intRow+1][intColumn] == "| "){
										con.print(strBoard[intRow][intColumn]);
									}else{
										strBoard[intRow][intColumn] = "|X";
										con.print(strBoard[intRow][intColumn]);
									}
									//if(strBoard[intRow+1][intColumn] == "|O" || strBoard[intRow+1][intColumn] == "|X"){
										//strBoard[intRow][intColumn] = "|X";
										//con.print(strBoard[intRow][intColumn]);
									//}else{
										//strBoard[intRow][intColumn] = "| ";
										//con.print(strBoard[intRow][intColumn]);
									//}
								}
							}else{
								//strBoard[intRow][intColumn] = "| ";
								con.print(strBoard[intRow][intColumn]);
							}
						}
						con.println("|");
						con.println("---------------");
					}
					con.println(" 1 2 3 4 5 6 7");
					intPlayerTurn += 1;
				}
			}	
		}
		
		
		// Display Wins
		//con.println(strPlayerInfo[0][0] + " has " + strPlayerWins[0] + " wins.");
		//con.println(strPlayerInfo[0][1] + " has " + strPlayerWins[1] + " wins.");
			// add board command
			// add board
			// add players
		
	}
}
