import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Benvenuto nel gioco della Battaglia navale!");
        int numberOfShips = 0;
        int numberOfPlayers = 0;
        int totalShip = 2;
        Battleship battleship = new Battleship();
        Battleship enemyBattleShip = new Battleship();
        Multiplayer multi = new Multiplayer();
        System.out.println(battleship.toString());
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

                if(!multi.isBuildedCarrier()) {
                    System.out.println("premi 1 per Carrier (lunghezza 5)");

                }
                if(!multi.isBuildedBattleShip()) {
                    System.out.println("premi 2 per BattleShip (lunghezza 4)");

                }
                if(!multi.isBuildedCruiser()) {
                    System.out.println("premi 3 per Cruiser(lunghezza 3)");

                }
                if(!multi.isBuildedSubMarine()) {
                    System.out.println("premi 4 per SubMarine (lunghezza 3)");

                }
                if(!multi.isBuildedDestroyer()) {
                    System.out.println("premi 5 per Destroyer (lunghezza 2)");

                }
                int typeOfShip = scan.nextInt();
                System.out.println("Inserisci la direzione: ");
                System.out.println("Inserisci 2 per basso\nInserisci 8 per alto\nInserisci 4 per sinistra\nInserisci 6 per destra");
                int direction = scan.nextInt();
                if (numberOfPlayers == 0) {
                    multi.chooseTypeOfShip(battleship, row, column, direction, typeOfShip);
                    System.out.println(battleship.toString());
                    if(!battleship.isIntoBoard()) {
                        System.out.println("ATTENZIONE, COORDINATE ERRATE!");
                        System.out.println("Mancano " + (totalShip - numberOfShips) + " navi da disporre");
                        if(multi.getCheck() == 1)
                            multi.setBuildedCarrier(false);
                        if(multi.getCheck() == 2)
                            multi.setBuildedBattleShip(false);
                        if(multi.getCheck() == 3)
                            multi.setBuildedCruiser(false);
                        if(multi.getCheck() == 4)
                            multi.setBuildedSubMarine(false);
                        if(multi.getCheck() == 5)
                            multi.setBuildedDestroyer(false);
                    }
                    else if(!battleship.isNull()) {
                        System.out.println("ATTENZIONE, LE NAVI RISCHIANO DI SOVRAPPORSI");
                        System.out.println("Mancano " + (totalShip - numberOfShips) + " navi da disporre");
                        if(multi.getCheck() == 1)
                            multi.setBuildedCarrier(false);
                        if(multi.getCheck() == 2)
                            multi.setBuildedBattleShip(false);
                        if(multi.getCheck() == 3)
                            multi.setBuildedCruiser(false);
                        if(multi.getCheck() == 4)
                            multi.setBuildedSubMarine(false);
                        if(multi.getCheck() == 5)
                            multi.setBuildedDestroyer(false);
                    }
                    else {
                        numberOfShips++;
                        System.out.println("Mancano " + (totalShip - numberOfShips) + " navi da disporre");
                    }
                }
                else {
                    multi.chooseTypeOfShip(enemyBattleShip, row, column, direction, typeOfShip);
                    System.out.println(enemyBattleShip.toString());

                    if(!enemyBattleShip.isIntoBoard()) {
                        System.out.println("ATTENZIONE, COORDINATE ERRATE!");
                        System.out.println("Mancano " + (totalShip - numberOfShips) + " navi da disporre");
                    }
                    else if(!enemyBattleShip.isNull()) {
                        System.out.println("ATTENZIONE, LE NAVI RISCHIANO DI SOVRAPPORSI");
                        System.out.println("Mancano " + (totalShip - numberOfShips) + " navi da disporre");
                    }
                    else {
                        numberOfShips++;
                        System.out.println("Mancano " + (totalShip - numberOfShips) + " navi da disporre");
                    }
                }
            } while (numberOfShips < totalShip);
            multi.setBuildedCarrier(false);
            multi.setBuildedBattleShip(false);
            multi.setBuildedCruiser(false);
            multi.setBuildedSubMarine(false);
            multi.setBuildedDestroyer(false);
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
            if (battleship.setOnFire(enemyBattleShip.battleGround, row, column)) {
                System.out.println("\nMAPPA GIOCATORE 2 ⬇️⬇️⬇️⬇️⬇️⬇️⬇️⬇️⬇️⬇️⬇️⬇️⬇️⬇️⬇️⬇️⬇");
                System.out.println(enemyBattleShip.toString());
                System.out.println(enemyBattleShip.getWhichShipWasHitted(battleship.battleGround, row, column) + "-------> GIOCATORE 1 HA COLPITO!");
            }
            else {
                System.out.println(battleship.toString());
                System.out.println("-------> GIOCATORE 1 HA MANCATO!");
            }
            System.out.println("Punti Giocatore 1: " + battleship.getPoint() + "\n");

            System.out.println("INIZIA IL GIOCATORE 2");
            System.out.println("Seleziona le coordinate da distruggere");
            System.out.println("Seleziona la riga:");
            int rowEnemy = scan2.nextInt();
            System.out.println("Selezione la colonna: ");
            int columnEnemy = scan2.nextInt();

            if (battleship.setOnFire(battleship.battleGround, rowEnemy, columnEnemy)){
                System.out.println("\nMAPPA GIOCATORE 1 ⬇️⬇️⬇️⬇️⬇️⬇️⬇️⬇️⬇️⬇️⬇️⬇️⬇️⬇️⬇️⬇️⬇️");
                System.out.println(battleship.toString());
                System.out.println(battleship.getWhichShipWasHitted(enemyBattleShip.battleGround, row, column) + "-------> GIOCATORE 2 HA COLPITO!");
            }
            else {
                System.out.println(enemyBattleShip.toString());
                System.out.println("-------> GIOCATORE 2 HA MANCATO!");
            }
            System.out.println("Punti Giocatore 2: " + battleship.getPoint() + "\n");
            if (battleship.isWin())
                System.out.println("IL GIOCATORE 1 HA VINTO!!!");
            if (enemyBattleShip.isWin())
                System.out.println("IL GIOCATORE 2 HA VINTO!!!");
        } while (!battleship.isWin() || !enemyBattleShip.isWin());
    }
}
