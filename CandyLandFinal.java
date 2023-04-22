/*  CANDY LAND FINAL
    CandyLandFinal.java
    Tiara Imani Logan
    Logan
    tilogan
    Section (1) */

import java.io.*;
import java.util.Scanner;
import java.util.Random;
import javax.swing.JOptionPane;

public class CandyLandFinal {
  public static void main (String [] args) throws IOException {
    Scanner scan = new Scanner (System.in);             //  SCANNER
    heading ();                                         //  MEATHOD THAT CREATES THE HEADING

    //  THE USERS ENTER THEIR NAMES
    String playerOne = JOptionPane.showInputDialog ("                    Player One\nEnter first two initials:");
    playerOne = playerOne.charAt(0) + "" + playerOne.charAt(1);
    String playerTwo = JOptionPane.showInputDialog ("                    Player Two\nEnter first two initials:");
    playerTwo = playerTwo.charAt(0) + "" + playerTwo.charAt(1);
    
    //  CREATING THE DECK OF CARDS  
    String [] cardColor = new String [60];              //  Color Of Card From Deck
    int [] cardNumber = new int [60];                   //  Amount Of That Color  
    
    //  READING CARDS FROM THE FILE
    File cardDeck = new File ("CandyLandCards.txt");    //  NEW FILE
    Scanner fileReader = new Scanner (cardDeck);        //  SCANNER
    readFromFile (fileReader, cardColor, cardNumber);

    CandyLandBoard cLB = new CandyLandBoard ();         //  CALLING ANOTHER CLASS
    
    //  CREATING THE CARDS
    String [] colors = new String [102];
    cLB.colorsOnTheBoard (colors);
    
    //  CREATING THE BOARD
    int rows = 25;
    int columbs = 15;
    String [][] board = new String [rows][columbs];
    cLB.boardCreation (board);                 
    cLB.boardColor (board, colors, 0);

    printTheBoard (board, rows, columbs);               //  PRINTING THE BOARD  
    Random gen = new Random ();                         //  CREATING A RANDOM NUMBER GENERATOR

    //  NEW FILE THATS BEING READ TOO IN THE OTHER CLASS
    File cardLocation = new File ("Locations.txt");     //  NEW FILE 
    Scanner fileReader2 = new Scanner (cardLocation);   //  SCANNER

     // PLAYING THE GAME  .........................................................................   
    int position = 0;
    int position2 = 0;
    int returnedValue2 = 0;
    
    for (int l = 0; l < 30; l++) {
      //  PLAYER ONE
      System.out.println ("Player One");
      System.out.println ("please hit enter to pick a card");
      scan.nextLine ();
      int cardPicked = gen.nextInt (59);
      System.out.println ("Your card color: " + cardColor [cardPicked]);
      System.out.println ("Your card number: " + cardNumber [cardPicked]);
      int returnedValue = movingOnBoard (fileReader2, cardPicked, cardColor, cardNumber, position, board, playerOne, position2, playerTwo);
      position = position + returnedValue;

      System.out.println ();
      System.out.println (); 

      cLB.boardCreation (board);
      cLB.boardColor (board, colors, 0);

      if (returnedValue == 1000) {
        System.out.println ("GAME OVER");
        JOptionPane.showMessageDialog (null, "Player One: Winner");
      break;}

      //  PLAYER TWO
      System.out.println ("Player Two");
      System.out.println ("please hit enter to pick a card");
      scan.nextLine ();
      cardPicked = gen.nextInt (59);
      System.out.println ("Your card color: " + cardColor [cardPicked]);
      System.out.println ("Your card number: " + cardNumber [cardPicked]);
      returnedValue2 = movingOnBoard (fileReader2, cardPicked, cardColor, cardNumber, position2, board, playerTwo, position, playerOne);
      position2 = position2 + returnedValue2;

      System.out.println ();
      System.out.println ();  
     
      cLB.boardCreation (board);
      cLB.boardColor (board, colors, 0);
      
      if (returnedValue2 == 1000) {
        System.out.println ("GAME OVER");
        JOptionPane.showMessageDialog (null, "Player Two: Winner");
      break;} 
    }
  }  // END MAIN  

  
  public static int movingOnBoard (Scanner fileReader, int cardPicked, String []list1, int []list2, int position, String [][]list3, String player, int place2, String player2) throws IOException{
    //  READING FROM THE FILE OVE LOCATIONS 
    File cardLocation = new File ("Locations.txt");
    fileReader = new Scanner (cardLocation);
    String cC = list1 [cardPicked];
    int cN = list2 [cardPicked];
    boolean found = false;
    int counter = 0;
      
    int w = 0;
    int e = 0;
    for (int t = 0; t < (place2); t++) {
      w = fileReader.nextInt ();
      e = fileReader.nextInt ();
      fileReader.nextLine (); } 
    
    fileReader.close ();
    fileReader = new Scanner (cardLocation);

    //  SEARCHING FOR THE NEXT POSITION 
    int y = 0;
    int z = 0;
    for (int x = 0; x < cN; x++) {
      do  {
        if (x == 0) {
        for (int t = 0; t < (position); t++) {
          y = fileReader.nextInt ();
          z = fileReader.nextInt ();
          fileReader.nextLine (); } }

        while (fileReader.hasNext ()) {
        
          y = fileReader.nextInt ();
          z = fileReader.nextInt ();
          fileReader.nextLine ();
          counter = counter + 1;

          if (list3 [y] [z].equals ( cC )) {
            if (x == cN - 1) {
              list3 [y] [z] = player + "   ";  }
            found = true; 
            break;  }  
          else if (y == 2 && z == 12)
            return 1000;
         }  
      } while (found == false);    
    }
    
    list3 [w] [e] = player2 + "   ";
    if (w == y && e == z) {
      list3 [y] [z] = player + " " + player2;}  
    
    printTheBoard (list3, 25, 15);
   
    fileReader.close ();
    return counter;  }  // END MOVINGONBOARD

  public static void readFromFile (Scanner fileReader, String [] cardColor, int [] cardNumber) {
    int x = 0;
    while (fileReader.hasNext () && x < 60){
      cardColor [x] = fileReader.next () + "  ";
      cardNumber [x] = fileReader.nextInt ();
      fileReader.nextLine ();
      x++;  } fileReader.close (); }  //  END READTOFILE
  
  public static void heading () {
    //  Heading  
    String heading = "              Candy Land";
    String heading2 = "Welcome to the land of candy!";
    JOptionPane.showMessageDialog (null, heading + "\n" + heading2);   
    //  Instructions 
    String instructions = "Instructions";
    String instructions1 = "1. Choose player names";
    String instructions2 = "2. Choose player colors";
    String instructions3 = "3. Each player will take turns picking a card";
    String instructions4 = "4. Follow the colors on the card";
    String instructions5 = "The first person to reach Cand Land is the winner!";
    JOptionPane.showMessageDialog (null, instructions + "\n" + "\n" + instructions1 +
                                   "\n" +instructions2 + "\n" + instructions3 + "\n" 
                                   + instructions4 + "\n" + "\n" + instructions5 );
  } //  END HEADING

  public static void printTheBoard (String [][] board, int rows, int columbs) {
    for (int r = 0; r < rows; r++){
      for (int c = 0; c < columbs; c++) 
        System.out.print (board [r][c]);
      System.out.println (); 
  } } //  END PRINTTHEBOARD 
  
} //  END PROGRAM



