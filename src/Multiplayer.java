public class Multiplayer {
    public void multiplayer(Battleship battleship, int row, int column, int direction, int typeOfShip){
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
    }
}
