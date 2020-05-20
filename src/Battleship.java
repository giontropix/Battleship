public class Battleship {
    Ship[][] battleGround = new Ship[10][10];
    private boolean buildedCarrier = false;
    private boolean buildedBattleShip = false;
    private boolean buildedCruiser = false;
    private boolean buildedSubMarine = false;
    private boolean buildedDestroyer = false;
    private int point;

    public Ship buildCarrier(){
        if(buildedCarrier == false) {
            Ship carrier = new Ship(Ship.ClassOfShip.Carrier, 5);
            this.buildedCarrier = true;
            return carrier;
        }
        else return null;
    }

    public Ship buildBattleShip(){
        if(buildedBattleShip == false) {
            Ship battleShip = new Ship(Ship.ClassOfShip.Battleship, 4);
            this.buildedBattleShip = true;
            return battleShip;
        }
        else return null;
    }

    public Ship buildCruiser(){
        if(buildedCruiser == false) {
            Ship cruiser = new Ship(Ship.ClassOfShip.Cruiser, 3);
            buildedCruiser = true;
            return cruiser;
        }
        return null;
    }

    public Ship buildSubMarine(){
        if(buildedSubMarine == false) {
            Ship submarine = new Ship(Ship.ClassOfShip.Submarine, 3);
            buildedSubMarine = true;
            return submarine;
        }
        return null;
    }

    public Ship buildDestroyer(){
        if(buildedDestroyer == false) {
            Ship destroyer = new Ship(Ship.ClassOfShip.Destroyer, 2);
            buildedDestroyer = true;
            return destroyer;
        }
        return null;
    }

    public void addShipRight(Ship[][] board, int row, int column, Ship ship){
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if(row == i && column == j) {
                    for (int k = 0; k < ship.getLenght(); k++) {
                        board[i][j + k] = ship;
                    }
                }
            }
        }
    }

    public void addShipLeft(Ship[][] board, int row, int column, Ship ship){
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if(row == i && column == j) {
                    for (int k = 0; k < ship.getLenght(); k++) {
                        board[i][j - k] = ship;
                    }
                }
            }
        }
    }

    public void addShipUp(Ship[][] board, int row, int column, Ship ship){
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if(row == i && column == j) {
                    for (int k = 0; k < ship.getLenght(); k++) {
                        board[i - k][j] = ship;
                    }
                }
            }
        }
    }

    public void addShipBottom(Ship[][] board, int row, int column, Ship ship){
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if(row == i && column == j) {
                    for (int k = 0; k < ship.getLenght(); k++) {
                        board[i + k][j] = ship;
                    }
                }
            }
        }
    }

    public boolean setOnFire(Ship[][] board, int row, int column){
        Ship destroyedShip = new Ship(Ship.ClassOfShip.Destroyed, 1);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if(row == i && column == j) {
                    if (board[i][j] != null) {
                        board[i][j] = destroyedShip;
                        destroyedShip.setIcon("\u001B[31m\uD83D\uDD25\u001B[0m");
                        point++;
                        return true;
                    }
                    else {
                        board[i][j] = destroyedShip;
                        destroyedShip.setIcon("\u001B[37m\uD83C\uDF2A️\u001B[0m");
                    }
                    return false;
                }
            }
        } return false;
    }

    public String toString() {
        String result = "";
        System.out.println("\n\tA\tB\tC\tD\tE\tF\tG\tH\tI\tL");
        for (int x = 0; x < this.battleGround.length; x++) {
            result += x + "\t" + "[";
            for(int y = 0; y < this.battleGround[x].length; y++) {
                if(battleGround[x][y] == null)
                    result += "[" + "\u001B[34m\uD83C\uDF0A\u001B[0m" + "]";
                else result += "[" + battleGround[x][y] + "]";
            }
            result += "]\n";
        }
        return result;
    }
}
