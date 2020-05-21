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
                buildedCarrier = true;
                break;
            case 2:
                chooseDirection(battleship, row, column, direction, battleship.buildBattleShip());
                buildedBattleShip = true;
                break;
            case 3:
                chooseDirection(battleship, row, column, direction, battleship.buildCruiser());
                buildedCruiser = true;
                break;
            case 4:
                chooseDirection(battleship, row, column, direction, battleship.buildSubMarine());
                buildedSubMarine = true;
                break;
            case 5:
                chooseDirection(battleship, row, column, direction, battleship.buildDestroyer());
                buildedDestroyer = true;
                break;
        }
    }
    public void chooseDirection(Battleship battleship, int row, int column, int direction, Ship typeOfShip) {
        switch(direction) {
            case 2: battleship.addShipBottom(battleship.battleGround, row, column, typeOfShip);
                break;
            case 8: battleship.addShipUp(battleship.battleGround, row, column, typeOfShip);
                break;
            case 4: battleship.addShipLeft(battleship.battleGround, row, column, typeOfShip);
                break;
            case 6: battleship.addShipRight(battleship.battleGround, row, column, typeOfShip);
                break;
        }
    }

    public boolean isBuildedCarrier() {
        return buildedCarrier;
    }

    public boolean isBuildedBattleShip() {
        return buildedBattleShip;
    }

    public boolean isBuildedCruiser() {
        return buildedCruiser;
    }

    public boolean isBuildedSubMarine() {
        return buildedSubMarine;
    }

    public boolean isBuildedDestroyer() {
        return buildedDestroyer;
    }
}
