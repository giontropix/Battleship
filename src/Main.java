import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Benvenuto nel gioco della Battaglia navale!");
        int numberOfShips = 0;
        int numberOfPlayers = 0;
        Battleship battleship = new Battleship();
        Battleship enemyBattleShip = new Battleship();
        System.out.println(battleship.toString());
        do{
            do {
                Scanner scan = new Scanner(System.in);
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
                System.out.println("Inserisci 1 per basso\nInserisci 2 per alto\nInserisci 3 per sinistra\nInserisci 4 per destra");
                int direction = scan.nextInt();
                Multiplayer multi = new Multiplayer();
                if(numberOfPlayers < 2) {
                    multi.multiplayer(battleship, row, column, direction, typeOfShip);
                    System.out.println(battleship.toString());
                }
                else{
                    multi.multiplayer(enemyBattleShip, row, column, direction, typeOfShip);
                    System.out.println(enemyBattleShip.toString());
                }

                numberOfShips++;
            } while (numberOfShips < 5);
            numberOfPlayers++;
            numberOfShips = 0;
            System.out.println("Giocatore 2");
        }while(numberOfPlayers < 2);
        do{
            System.out.println("Seleziona le coordinate da distruggere");
            System.out.println("Seleziona la riga:");
            Scanner scan2 = new Scanner(System.in);
            int row = scan2.nextInt();
            System.out.println("Selezione la colonna: ");
            int column = scan2.nextInt();

            if(battleship.setOnFire(battleship.battleGround, row, column))
                System.out.println("COLPITO!");
            else System.out.println("MANCATO!");
        }while(battleship.isWin());
    }
}
