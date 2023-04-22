/*  CANDY LAND BOARD
    CandyLandBoard.java
    Tiara Imani Logan
    Logan
    tilogan
    Section (1) */
import java.io.*;
public class CandyLandBoard {
    
  public static void boardCreation (String [][] board) { 
    int rows = 25;
    int columbs = 15;
    for (int r = 0; r < rows; r++){
      for (int c = 0; c < columbs; c++) {
        //  BOARDERS FOR THE BOARD & START/FINISH  -------------------------------------------------->
        if ( r == 0) {board [r][c] = "*****";}
        else if ( r == 24) {board [r][c] = "*****";}
        else if ( r == 22  && c == 0) {board [r][c] = "START";}
        else if ( r == 2  && c > 11 && c < 13) {board [r][c] = "CANDY";}
        else if ( r == 2  && c > 12 && c < 14) {board [r][c] = "LAND";}
        //  Colors On The Board  -------------------------------------------------------------------->
          //  HORIZONTAL LINES  --------------------------------------------------------------------->
        else if ( r == 2 && c > 1 && c < 12  ) {board [r][c] = "  c  ";}
        else if ( r == 5 && c > 1 && c < 5   ) {board [r][c] = "  c  ";}
        else if ( r == 5 && c > 8 && c < 13  ) {board [r][c] = "  c  ";}
        else if ( r == 8 && c > 0 && c < 4   ) {board [r][c] = "  c  ";}
        else if ( r == 12 && c > 3 && c < 10 ) {board [r][c] = "  c  ";}
        else if ( r == 15 && c > 2 && c < 13 ) {board [r][c] = "  c  ";}
        else if ( r == 18 && c > 0 && c < 14 ) {board [r][c] = "  c  ";}
        else if ( r == 22 && c > 1 && c < 14 ) {board [r][c] = "  c  ";}
          //  Vertical Lines  ------------------------------------------------------------------------>
        else if ( c == 1 && r > 8 && r < 18   ) {board [r][c] = "  c  ";}
        else if ( c == 2 && r > 2 && r < 5    ) {board [r][c] = "  c  ";}
        else if ( c == 3 && r > 8 && r < 15   ) {board [r][c] = "  c  ";}
        else if ( c == 4 && r > 5 && r < 12   ) {board [r][c] = "  c  ";}
        else if ( c == 9 && r > 5 && r < 12   ) {board [r][c] = "  c  ";}
        else if ( c == 12 && r > 5 && r < 15  ) {board [r][c] = "  c  ";} 
        else if ( c == 13 && r > 18 && r < 22 ) {board [r][c] = "  c  ";}
          //  EVERYTHING ELSE  ----------------------------------------------------------------------->
        else {board [r][c] = "     ";}
      }  }  
 }// END BROARDCREATION
 
  public static void colorsOnTheBoard (String [] colors) { 
    for (int col = 0; col < 102; col++) {
      colors [col] = "RED  "; col++;
      colors [col] = "BLU  "; col++;
      colors [col] = "GRN  "; col++;
      colors [col] = "ORG  "; col++;
      colors [col] = "PUR  "; col++;
      colors [col] = "PNK  ";  }
    int col = 0;
  }  //  END COLORINGTHEBOARD
  
 public static void boardColor (String [][] board, String [] colors, int x) throws IOException{ 
    PrintWriter outputFile = new PrintWriter ("Locations.txt");
    String location = "";
      for (int y = 0; y > -1 && y < 15; y++) {
        if (board [22][y] == "  c  ")  {
        board [22][y] = colors [x++]; 
        location = "" + "22 "+ y;
        outputFile.println (location);} }       
      for (int y = 24; y > -1 && y < 25; y--) {
        if (board [y][13] == "  c  ") {
        board [y][13] = colors [x++];
        location = "" + y +" 13";
        outputFile.println (location);} }
      for (int y = 14; y > -1 && y < 15; y--) {
        if (board [18][y] == "  c  ") {
        board [18][y] = colors [x++];  
        location = "" + "18 "+ y;
        outputFile.println (location); } }
      for (int y = 24; y > -1 && y < 25; y--) {
        if (board [y][1] == "  c  ") {
        board [y][1] = colors [x++]; 
        location = "" + y +" 1";
        outputFile.println (location);  } }
      for (int y = 3; y > 1 && y < 4; y--) {
        if (board [8][y] == "  c  ") {
        board [8][y] = colors [x++];  
        location = "" + "8 "+ y;
        outputFile.println (location);  } } 
      for (int y = 9; y > 8 && y < 15; y++) {
        if (board [y][3] == "  c  ") {
        board [y][3] = colors [x++]; 
        location = "" + y +" 3";
        outputFile.println (location);  } }
      for (int y = 3; y > 2 && y < 13; y++) {
        if (board [15][y] == "  c  ") {
        board [15][y] = colors [x++];  
        location = "" + "15 "+ y;
        outputFile.println (location);  } }
      for (int y = 14; y > 5 && y < 15; y--) {
        if (board [y][12] == "  c  ") {
        board [y][12] = colors [x++];  
        location = "" + y +" 12";
        outputFile.println (location);  } }
      for (int y = 12; y > 8 && y < 13; y--) {
        if (board [5][y] == "  c  ") {
        board [5][y] = colors [x++];  
        location = "" + "5 "+ y;
        outputFile.println (location);  } }
      for (int y = 6; y > 5 && y < 12; y++) {
        if (board [y][9] == "  c  ") {
        board [y][9] = colors [x++];  
        location = "" + y +" 9";
        outputFile.println (location);  } }
      for (int y = 9; y > 3 && y < 10; y--) {
        if (board [12][y] == "  c  ") {
        board [12][y] = colors [x++];  
        location = "" + "12 "+ y;
        outputFile.println (location);  } }
      for (int y = 11; y > 5 && y < 12; y--) {
        if (board [y][4] == "  c  ") {
        board [y][4] = colors [x++];  
        location = "" + y +" 4";
        outputFile.println (location); } }
      for (int y = 4; y > 1 && y < 5; y--) {
        if (board [5][y] == "  c  ") {
        board [5][y] = colors [x++]; 
        location = "" + "5 "+ y;
        outputFile.println (location);  } }
      for (int y = 4; y > 2 && y < 5; y--) {
        if (board [y][2] == "  c  ") {
        board [y][2] = colors [x++]; 
        location = "" + y +" 2";
        outputFile.println (location);  } }
      for (int y = 2; y > 1 && y < 12; y++) {
        if (board [2][y] == "  c  ") {
        board [2][y] = colors [x++];  
        location = "" + "2 "+ y;
        outputFile.println (location);  } }
      
        location = "2 " + "12";
        outputFile.println (location); 
      
      outputFile.close ();
  }  //  END BOARDCOLOR
}  //  END OF CLASS