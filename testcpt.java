import arc.*;
import java.awt.*;

public class testcpt{
	public static void main(String[] args){
	
		Console con = new Console();
	
        
        String strTheme[][];
		strTheme = new String[3][4]; //[font name][font colour]
		
		//String strPlayer1;
		//String strPlayer2;
		//String strBoard;
		String strThemeChoice = "";
		
		TextInputFile theme = new TextInputFile("themes.txt");
		con.println("Please choose a theme----------------------------------------------------------");
		
		while(theme.eof() == false){
			for(int intCount = 0; intCount < 3; intCount++){
				strTheme[intCount][0] = theme.readLine();
				con.println(strTheme[intCount][0]);
				strTheme[intCount][1] = theme.readLine();
				strTheme[intCount][2] = theme.readLine();
				strTheme[intCount][3] = theme.readLine();
			}
		}
		
		while(!strThemeChoice.equalsIgnoreCase(strTheme[0][0])){
			if(strThemeChoice.equalsIgnoreCase(strTheme[0][0])){
				con.println(strTheme[0][0]);
				//Color Player1 = new Color(strTheme[0][1]);
				//Color Player2 = new Color(strTheme[0][2]);
				Color Board = new Color(Integer.parseInt(strTheme[0][3]));
				con.setTextColor(Board);
				break;
			}else if(strThemeChoice.equalsIgnoreCase(strTheme[1][0])){
				//con.println(strTheme[1][0]);
				//Color Player1 = new Color(strTheme[1][1]);
				//con.setTextColor(Player1);
				Color Player2 = new Color(strTheme[1][2]);
				//con.setTextColor(Player2);
				//Color Board = new Color(Integer.parseInt(strTheme[1][3]));
				//con.setTextColor(Board);
				break;
			}else if(strThemeChoice.equalsIgnoreCase(strTheme[2][0])){
				//con.println(strTheme[2][0]);
				//Color Player1 = new Color(strTheme[2][1]);
				//con.setTextColor(Player1);
				//Color Player2 = new Color(strTheme[2][2]);
				//con.setTextColor(Player2);
				Color Board = new Color(Integer.parseInt(strTheme[2][3]));
				con.setTextColor(Board);
				break;
			}else{
				con.println("Please Choose a Theme:");
				strThemeChoice = con.readLine();
			}
		}
		theme.close();
		con.setTextColor(Board);
		con.println("Hello World");
		
	}
	

}
