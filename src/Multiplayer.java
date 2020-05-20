public class Multiplayer {
    private boolean buildedCarrier = false;
    private boolean buildedBattleShip = false;
    private boolean buildedCruiser = false;
    private boolean buildedSubMarine = false;
    private boolean buildedDestroyer = false;

    public void chooseTypeOfShip(Battleship battleship, int row, int column, int direction, int typeOfShip) {
        switch (typeOfShip) {
            case 1:
                chooseDirection(battleship, row, column, direction, battleship.buildCarrier());
            case 2:
                chooseDirection(battleship, row, column, direction, battleship.buildBattleShip());
            case 3:
                chooseDirection(battleship, row, column, direction, battleship.buildCruiser());
            case 4:
                chooseDirection(battleship, row, column, direction, battleship.buildSubMarine());
            case 5:
                chooseDirection(battleship, row, column, direction, battleship.buildDestroyer());
        }
    }
    public void chooseDirection(Battleship battleship, int row, int column, int direction, Ship typeOfShip) {
        switch(direction) {
            case 1: battleship.addShipBottom(battleship.battleGround, row, column, typeOfShip);
                break;
            case 2: battleship.addShipUp(battleship.battleGround, row, column, typeOfShip);
                break;
            case 3: battleship.addShipLeft(battleship.battleGround, row, column, typeOfShip);
                break;
            case 4: battleship.addShipRight(battleship.battleGround, row, column, typeOfShip);
                break;
        }
    }
}
