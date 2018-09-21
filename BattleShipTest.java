import java.util.Scanner;

public class BattleShipTest{
  public static void main(String[]args){
    BattleShip b = new BattleShip();
    Scanner kboard = new Scanner(System.in);
    int x = 0;
    while(x<10){
      b.setBoat(kboard);
    }
    
    kboard.close();
  }
}
