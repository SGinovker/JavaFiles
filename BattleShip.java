
import java.util.Scanner;
public class BattleShip{
  
  private int[][] board;
  private String[][] corresponding;
  private int wonone;
  private int wontwo;
  
  public BattleShip(){
    instructions();
    game();
  }
  
  public void instructions(){
    System.out.println("Battleship is a two player game. Each player takes turns setting up 5 ships on a grid. "
        + "The 5 ships have lengths of 2, 3, 4, 4, and 5. The ships can be set horizontally or vertically on the"
        + "10 by 10 grid. (Not diagonally) The players do not tell each other where their ships are; this is kept"
        + "a secret. After the set up, the players will take turns shooting spots on the grid to try to sink the other"
        + "person's ships. If they fire at a spot in the grid with the other person's ship, the program will print"
        + " \"Hit\". If you hit all the spots on a ship, it will print \"Sunk\". If you miss and hit nothing, it will"
        + "print \"Miss\". You cannot hit your own ships. Also, do not hit the same spot twice. The first player to "
        + "sink all the other person's ships wins.");
  }
  public void game(){
    int[][] game = new int[10][10];                     //all game boards are 10 by 10
    board = game;
    String[][] corr = new String[10][10];
    corresponding = corr;
    for(int row = 0;row<board.length;row++){
      for(int col = 0;col<board[0].length;col++){          //set all values to zero on the board
        board[row][col] = 0;
      }
    }
  }
  
  public void setBoat(Scanner kboard){
    System.out.println("Enter your player number (one or two): ");     
    String l = kboard.nextLine();
    while( l.isEmpty())
    {
      l = kboard.nextLine();
    }
    int x = 0;
    if(l.equals("one"))
      x = 1;
    else
      x = 2;
    
    System.out.println(" Enter your boat type(either patrol, destroyer, submarine, battleship, or aircraft): ");
    String m = kboard.nextLine();
    
    int count = 0;
    if(m.toLowerCase().equals("patrol"))
      count = 2;
    if(m.toLowerCase().equals("destroyer"))
      count = 3;
    if(m.toLowerCase().equals("submarine"))
      count = 4;
    if(m.toLowerCase().equals("battleship"))
      count = 4;
    if(m.toLowerCase().equals("aircraft"))
      count = 5;
    int h = 0;
    while(h<count){
      System.out.println("Enter row number of spot of boat: ");
      int row = kboard.nextInt();
      System.out.println("Enter column number of spot of boat: ");
      int col = kboard.nextInt();
      board[row][col] += x;
      corresponding[row][col] = m;
      h++;
    }
    
    
     }
  
  public String playerOneShoot(int row, int col){             //player one shooting player two
    if(board[row][col]==2||board[row][col]==3){                        //if player 1 hits one of player 2's boats
      corresponding[row][col] += " hit";
      int count = 0;
      if(corresponding[row][col].equals("patrol hit"))
        count = 2;
      if(corresponding[row][col].equals("destroyer hit"))
        count = 3;
      if(corresponding[row][col].equals("submarine hit"))
        count = 4;
      if(corresponding[row][col].equals("battleship hit"))
        count = 4;
      if(corresponding[row][col].equals("aircraft hit"))
        count = 5;
      int num = 0;
      for(int r = 0;r<corresponding.length;r++){
        for(int c = 0;c<corresponding[0].length;c++){
          if(corresponding[r][c].equals(corresponding[row][col]))
            num++;
        }
      }
      if(num==count){
        wonone++;
        if(wonone == 5)
          return "Player one has sunken all of player two's boats; player one wins!";
        return "Sunk!";
      }
      return "Hit!";                               //return hit
    }
    return "Miss!";                              //otherwise return miss
  }
  public String playerTwoShoot(int row, int col){             //player one shooting player two
    if(board[row][col]==1||board[row][col]==3){                        //if player 1 hits one of player 2's boats
      corresponding[row][col] += " hit";
      int count = 0;
      if(corresponding[row][col].equals("patrol hit"))
        count = 2;
      if(corresponding[row][col].equals("destroyer hit"))
        count = 3;
      if(corresponding[row][col].equals("submarine hit"))
        count = 4;
      if(corresponding[row][col].equals("battleship hit"))
        count = 4;
      if(corresponding[row][col].equals("aircraft hit"))
        count = 5;
      int num = 0;
      for(int r = 0;r<corresponding.length;r++){
        for(int c = 0;c<corresponding[0].length;c++){
          if(corresponding[r][c].equals(corresponding[row][col]))
            num++;
        }
      }
      if(num==count){
        wontwo++;
        if(wontwo == 5)
          return "Player two has sunken all of player one's boats; player two wins!";
        return "Sunk!";
        
      }
      return "Hit!";                               //return hit
    }
    return "Miss!";                              //otherwise return miss
  }
}
