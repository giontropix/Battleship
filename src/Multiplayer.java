public class Multiplayer {
    private boolean buildedCarrier = false;
    private boolean buildedBattleShip = false;
    private boolean buildedCruiser = false;
    private boolean buildedSubMarine = false;
    private boolean buildedDestroyer = false;
    private int check = 0;

    public void chooseTypeOfShip(Battleship battleship, int row, int column, int direction, int typeOfShip) {
        switch (typeOfShip) {
            case 1:
                this.buildedCarrier = true;
                this.check = 1;
                chooseDirection(battleship, row, column, direction, battleship.buildCarrier());
                break;
            case 2:
                this.buildedBattleShip = true;
                this.check = 2;
                chooseDirection(battleship, row, column, direction, battleship.buildBattleShip());
                break;
            case 3:
                this.buildedCruiser = true;
                this.check = 3;
                chooseDirection(battleship, row, column, direction, battleship.buildCruiser());
                break;
            case 4:
                this.buildedSubMarine = true;
                this.check = 4;
                chooseDirection(battleship, row, column, direction, battleship.buildSubMarine());
                break;
            case 5:
                this.buildedDestroyer = true;
                this.check = 5;
                chooseDirection(battleship, row, column, direction, battleship.buildDestroyer());
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
        return this.buildedCarrier;
    }

    public boolean isBuildedBattleShip() {
        return this.buildedBattleShip;
    }

    public boolean isBuildedCruiser() {
        return this.buildedCruiser;
    }

    public boolean isBuildedSubMarine() {
        return this.buildedSubMarine;
    }

    public boolean isBuildedDestroyer() {
        return this.buildedDestroyer;
    }

    public void setBuildedCarrier(boolean buildedCarrier) {
        this.buildedCarrier = buildedCarrier;
    }

    public void setBuildedBattleShip(boolean buildedBattleShip) {
        this.buildedBattleShip = buildedBattleShip;
    }

    public void setBuildedCruiser(boolean buildedCruiser) {
        this.buildedCruiser = buildedCruiser;
    }

    public void setBuildedSubMarine(boolean buildedSubMarine) {
        this.buildedSubMarine = buildedSubMarine;
    }

    public void setBuildedDestroyer(boolean buildedDestroyer) {
        this.buildedDestroyer = buildedDestroyer;
    }

    public int getCheck() {
        return check;
    }
}
