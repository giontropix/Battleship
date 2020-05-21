public class Battleship {
    Ship[][] battleGround = new Ship[10][10];
    private int point;
    private boolean intoBoard = false;
    private boolean isNull = true;

    public Ship buildCarrier(){
        Ship carrier = new Ship(Ship.ClassOfShip.Carrier, 5);
        return carrier;
    }

    public Ship buildBattleShip(){
        Ship battleShip = new Ship(Ship.ClassOfShip.Battleship, 4);
        return battleShip;
    }

    public Ship buildCruiser(){
        Ship cruiser = new Ship(Ship.ClassOfShip.Cruiser, 3);
        return cruiser;
    }

    public Ship buildSubMarine(){
        Ship submarine = new Ship(Ship.ClassOfShip.Submarine, 3);
        return submarine;
    }

    public Ship buildDestroyer(){
        Ship destroyer = new Ship(Ship.ClassOfShip.Destroyer, 2);
        return destroyer;
    }


    public void addShipRight(Ship[][] board, int row, int column, Ship ship){
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if(row == i && column == j && board[i][j] == null) {
                    for (int k = 0; k < ship.getLenght(); k++) {
                        if (checkCoordinatesHorizontal(board, row, column + ship.getLenght()) && board[row][column + k] != null)
                            isNull = false;
                    }
                    if (isNull){
                        for (int k = 0; k < ship.getLenght(); k++) {
                            if (checkCoordinatesHorizontal(board, row, column + ship.getLenght()))
                                board[row][column + k] = ship;
                        }
                    }
                }
            }
        }
    }

    public void addShipLeft(Ship[][] board, int row, int column, Ship ship){
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if(row == i && column == j && board[i][j] == null) {
                    for (int k = 0; k < ship.getLenght(); k++) {
                        if(checkCoordinatesHorizontal(board, row, column - ship.getLenght()) && board[row][column - k] != null)
                            isNull = false;
                    }
                    if (isNull){
                        for (int k = 0; k < ship.getLenght(); k++) {
                            if(checkCoordinatesHorizontal(board, row, column - ship.getLenght()))
                                board[row][column - k] = ship;
                        }
                    }
                }
            }
        }
    }

    public void addShipUp(Ship[][] board, int row, int column, Ship ship){
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if(row == i && column == j && board[i][j] == null) {
                    for (int k = 0; k < ship.getLenght(); k++) {
                        if (checkCoordinatesVertical(board, row - ship.getLenght()) && board[row - k][column] != null)
                            isNull = false;
                    }
                    if (isNull){
                        for (int k = 0; k < ship.getLenght(); k++) {
                            if (checkCoordinatesVertical(board, row - ship.getLenght()))
                                board[row - k][column] = ship;
                        }
                    }
                }
            }
        }
    }

    public void addShipBottom(Ship[][] board, int row, int column, Ship ship){
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if(row == i && column == j && board[row][column] == null) {
                    for (int k = 0; k < ship.getLenght(); k++) {
                        if(checkCoordinatesVertical(board, row + ship.getLenght()) && board[row + k][column] != null)
                            isNull = false;
                    }
                    if (isNull){
                        for (int k = 0; k < ship.getLenght(); k++) {
                            if(checkCoordinatesVertical(board, row + ship.getLenght()))
                                board[row + k][column] = ship;
                        }
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

    public boolean isWin(){
        if(point != 17)
            return false;
        return true;
    }

    public boolean checkCoordinatesVertical(Ship[][] board, int row){
        if(row > board.length || row < 0) {
            intoBoard = false;
            return false;
        }
        else {
            intoBoard = true;
            return true;
        }
    }

    public boolean checkCoordinatesHorizontal(Ship[][] board, int row, int column){
        if(column > board[row].length || column < 0) {
            intoBoard = false;
            return false;
        }
        else {
            intoBoard = true;
            return true;
        }
    }

    public boolean isIntoBoard() {
        return this.intoBoard;
    }

    public boolean isNull() {
        return isNull;
    }

    public int getPoint() {
        return point;
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
