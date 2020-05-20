import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Benvenuto nel gioco della Battaglia navale!");
        int numberOfShips = 0;
        Battleship battleship = new Battleship();
        System.out.println(battleship.toString());
        do {
            Scanner scan = new Scanner(System.in);
            System.out.println("Inserisci le navi da battaglia");
            System.out.println("Inserisci la riga: ");
            int row = scan.nextInt();
            System.out.println("Inserisci la colonna: ");
            int column = scan.nextInt();
            System.out.println("Inserisci il tipo di nave");
            System.out.println("premi 1 per Carrier (lunghezza 5)");
            System.out.println("premi 2 per BattleShip (lunghezza 4)");
            System.out.println("premi 3 per Cruiser(lunghezza 3)");
            System.out.println("premi 4 per SubMarine (lunghezza 3)");
            System.out.println("premi 5 per Destroyer (lunghezza 2)");
            int typeOfShip = scan.nextInt();
            System.out.println("Inserisci la direzione: ");
            System.out.println("Inserisci 1 per basso\nInserisci 2 per alto\nInserisci 3 per sinistra\nInserisci 4 per destra");
            int direction = scan.nextInt();
            switch (typeOfShip) {
                case 1:
                    switch(direction){
                        case 1: battleship.addShipBottom(battleship.battleGround, row, column, battleship.buildCarrier());
                        break;
                        case 2: battleship.addShipUp(battleship.battleGround, row, column, battleship.buildCarrier());
                        break;
                        case 3: battleship.addShipLeft(battleship.battleGround, row, column, battleship.buildCarrier());
                        break;
                        case 4: battleship.addShipRight(battleship.battleGround, row, column, battleship.buildCarrier());
                        break;
                    }
                case 2: switch(direction){
                    case 1: battleship.addShipBottom(battleship.battleGround, row, column, battleship.buildBattleShip());
                        break;
                    case 2: battleship.addShipUp(battleship.battleGround, row, column, battleship.buildBattleShip());
                        break;
                    case 3: battleship.addShipLeft(battleship.battleGround, row, column, battleship.buildBattleShip());
                        break;
                    case 4: battleship.addShipRight(battleship.battleGround, row, column, battleship.buildBattleShip());
                        break;
                }
                case 3: switch(direction){
                    case 1: battleship.addShipBottom(battleship.battleGround, row, column, battleship.buildCruiser());
                        break;
                    case 2: battleship.addShipUp(battleship.battleGround, row, column, battleship.buildCruiser());
                        break;
                    case 3: battleship.addShipLeft(battleship.battleGround, row, column, battleship.buildCruiser());
                        break;
                    case 4: battleship.addShipRight(battleship.battleGround, row, column, battleship.buildCruiser());
                        break;
                }
                case 4: switch(direction){
                    case 1: battleship.addShipBottom(battleship.battleGround, row, column, battleship.buildSubMarine());
                        break;
                    case 2: battleship.addShipUp(battleship.battleGround, row, column, battleship.buildSubMarine());
                        break;
                    case 3: battleship.addShipLeft(battleship.battleGround, row, column, battleship.buildSubMarine());
                        break;
                    case 4: battleship.addShipRight(battleship.battleGround, row, column, battleship.buildSubMarine());
                        break;
                }
                case 5: switch(direction){
                    case 1: battleship.addShipBottom(battleship.battleGround, row, column, battleship.buildDestroyer());
                        break;
                    case 2: battleship.addShipUp(battleship.battleGround, row, column, battleship.buildDestroyer());
                        break;
                    case 3: battleship.addShipLeft(battleship.battleGround, row, column, battleship.buildDestroyer());
                        break;
                    case 4: battleship.addShipRight(battleship.battleGround, row, column, battleship.buildDestroyer());
                        break;
                }
            }
            System.out.println(battleship.toString());
            numberOfShips++;
        }while(numberOfShips < 5);
    }
}
