import arc.*;
import java.awt.*;

public class themestest {
    public static void main(String[] args) {
        Console con = new Console();

        // Define themes array (name, RGB for Player 1, Player 2, Board)
        int intThemeColors[][];
        intThemeColors = new int[3][9]; 
        
        String strThemeNames[];
        strThemeNames = new String[3];
        String strThemeChoice = "";

        // Load themes from file
        TextInputFile theme = new TextInputFile("themes.txt");
        con.println("Please choose a theme:");
        int intCount = 0;

        while(theme.eof() == false && intCount < 3) {
            strThemeNames[intCount] = theme.readLine();
            intThemeColors[intCount][0] = theme.readInt(); 
            intThemeColors[intCount][1] = theme.readInt(); 
            intThemeColors[intCount][2] = theme.readInt(); 
            intThemeColors[intCount][3] = theme.readInt(); 
            intThemeColors[intCount][4] = theme.readInt(); 
            intThemeColors[intCount][5] = theme.readInt(); 
            intThemeColors[intCount][6] = theme.readInt();
            intThemeColors[intCount][7] = theme.readInt(); 
            intThemeColors[intCount][8] = theme.readInt();

            // Display Theme Name
            con.println(strThemeNames[intCount]);
            intCount++;
        }
        theme.close();

   }
   
}
