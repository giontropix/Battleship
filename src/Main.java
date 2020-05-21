import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Benvenuto nel gioco della Battaglia navale!");
        int numberOfShips = 0;
        int numberOfPlayers = 0;
        int totalShip = 2;
        Battleship battleship = new Battleship();
        Battleship enemyBattleShip = new Battleship();
        System.out.println(battleship.toString());
        /*battleship.addShipRight(battleship.battleGround, 0,0, battleship.buildCruiser());
        System.out.println(battleship.toString());
        battleship.addShipBottom(battleship.battleGround, 1, 0, battleship.buildSubMarine());
        System.out.println(battleship.toString());
        battleship.addShipUp(battleship.battleGround, 5, 5, battleship.buildCarrier());
        System.out.println(battleship.toString());*/
        do {
            do {
                Scanner scan = new Scanner(System.in);
                if(numberOfPlayers == 0)
                    System.out.println("Giocatore 1");
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
                System.out.println("Inserisci 2 per basso\nInserisci 8 per alto\nInserisci 4 per sinistra\nInserisci 6 per destra");
                int direction = scan.nextInt();
                Multiplayer multi = new Multiplayer();
                if (numberOfPlayers == 0) {
                    multi.chooseTypeOfShip(battleship, row, column, direction, typeOfShip);
                    numberOfShips++;
                    System.out.println(battleship.toString());
                    System.out.println("Mancano " + (totalShip - numberOfShips) + " navi da disporre");
                    if(!battleship.isIntoBoard())
                        System.out.println("ATTENZIONE, COORDINATE ERRATE!");
                }
                else {
                    multi.chooseTypeOfShip(enemyBattleShip, row, column, direction, typeOfShip);
                    numberOfShips++;
                    System.out.println(enemyBattleShip.toString());
                    System.out.println("Mancano " + (totalShip - numberOfShips) + " navi da disporre");
                    if(!battleship.isIntoBoard())
                        System.out.println("ATTENZIONE, COORDINATE ERRATE!");
                }
            } while (numberOfShips < totalShip);
            numberOfPlayers++;
            numberOfShips = 0;
            System.out.println("Giocatore 2");
            System.out.println(enemyBattleShip.toString());
        } while(numberOfPlayers < 2);

        do {
            System.out.println("INIZIA IL GIOCATORE 1");
            System.out.println("Seleziona le coordinate da distruggere");
            System.out.println("Seleziona la riga:");
            Scanner scan2 = new Scanner(System.in);
            int row = scan2.nextInt();
            System.out.println("Selezione la colonna: ");
            int column = scan2.nextInt();
            if(battleship.setOnFire(battleship.battleGround, row, column))
                System.out.println("COLPITO!");
            else System.out.println("MANCATO!");
            System.out.println(battleship.toString());
            System.out.println("Punti Giocatore 1: " + battleship.getPoint() + "\n");

            System.out.println("INIZIA IL GIOCATORE 2");
            System.out.println("Seleziona le coordinate da distruggere");
            System.out.println("Seleziona la riga:");
            int rowEnemy = scan2.nextInt();
            System.out.println("Selezione la colonna: ");
            int columnEnemy = scan2.nextInt();

            if(battleship.setOnFire(enemyBattleShip.battleGround, rowEnemy, columnEnemy))
                System.out.println("COLPITO!");
            else System.out.println("MANCATO!");
            System.out.println(enemyBattleShip.toString());
            System.out.println("Punti Giocatore 2: " + battleship.getPoint() + "\n");
        } while(battleship.isWin() || enemyBattleShip.isWin());
    }
}
