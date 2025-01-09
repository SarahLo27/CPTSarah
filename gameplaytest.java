import arc.*;

public class gameplaytest {
	public static void main(String[] args){
		Console con = new Console();
		
		// Get Information About Player
		
		// Set Default Names
		String strPlayerInfo[][];
		strPlayerInfo = new String[2][2]; // [number of info][number of players] 
		strPlayerInfo[0][0] = "";
		
		// Turns & Wins
		String strPlayerTurn[][];
		strPlayerTurn = new String[2][2];
		strPlayerTurn[1][0] = "1";
		strPlayerTurn[1][1] = "0";
		
		//
		int intColumnChoice = 0;
		
		// Set Default Board
		String strBoard[][];
		strBoard = new String[6][7]; 
		for(int intRow = 0; intRow < 6; intRow++){
			for(int intColumn = 0; intColumn < 7; intColumn++){
				strBoard[intRow][intColumn] = "| ";
				con.print(strBoard[intRow][intColumn]);
			}
			con.println("|");
			con.println("---------------");
		}
		con.println(" 1 2 3 4 5 6 7");
		
		// Ask for Name if do not already have a name
		if(strPlayerInfo[0][0].equals(""));{
			// Ask for Name
			con.print("Player 1, please enter your name: ");
			strPlayerInfo[0][0] = con.readLine();
			con.print("Player 2, please enter your name: ");
			strPlayerInfo[0][1] = con.readLine();
			// Set Default Wins
			strPlayerTurn[0][0] = "0";
			strPlayerTurn[0][1] = "0";
		}
		
		// Display Score @ Top
		con.println(strPlayerInfo[0][0] + ": " + strPlayerTurn[0][0]);
		con.println(strPlayerInfo[0][1] + ": " + strPlayerTurn[0][1]);
		
		//
		if(Integer.parseInt(strPlayerTurn[1][0]) % 2 == 1){
			con.println(strPlayerInfo[0][0]+"'s turn");
			con.print("Please choose a column (type the number): ");
			intColumnChoice = con.readInt();
		}else{
			con.println(strPlayerInfo[0][1]+"'s turn");
			con.print("Please choose a column (type the number): ");
			intColumnChoice = con.readInt();
		}
		
		
		// Display Wins
		//con.println(strPlayerInfo[0][0] + " has " + strPlayerWins[0] + " wins.");
		//con.println(strPlayerInfo[0][1] + " has " + strPlayerWins[1] + " wins.");
			// add board command
			// add board
			// add players
			
		

	}
}
