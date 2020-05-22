public class Battleship {
    Ship[][] battleGround = new Ship[10][10];
    private int point;
    private boolean intoBoard = false;
    private boolean isNull = true;

    public Ship buildCarrier(){
        return new Ship(Ship.ClassOfShip.Carrier, 5);
    }

    public Ship buildBattleShip(){
        return new Ship(Ship.ClassOfShip.Battleship, 4);
    }

    public Ship buildCruiser(){
        return new Ship(Ship.ClassOfShip.Cruiser, 3);
    }

    public Ship buildSubMarine(){
        return new Ship(Ship.ClassOfShip.Submarine, 3);
    }

    public Ship buildDestroyer(){
        return new Ship(Ship.ClassOfShip.Destroyer, 2);
    }

    public void addShipRight(Ship[][] board, int row, int column, Ship ship){
        for (int k = 0; k < ship.getLenght(); k++) {
            if (checkCoordinatesHorizontal(board, row, column + ship.getLenght()) && board[row][column + k] != null)
                this.isNull = false;
            if (checkCoordinatesHorizontal(board, row, column + ship.getLenght()) && board[row][column + k] == null)
                this.isNull = true;
        }
        if (this.isNull){
            for (int k = 0; k < ship.getLenght(); k++) {
                if (checkCoordinatesHorizontal(board, row, column + ship.getLenght()))
                    board[row][column + k] = ship;
            }
        }
    }

    public void addShipLeft(Ship[][] board, int row, int column, Ship ship){
        for (int k = 0; k < ship.getLenght(); k++) {
            if(checkCoordinatesHorizontal(board, row, column - ship.getLenght()) && board[row][column - k] != null)
                this.isNull = false;
            if(checkCoordinatesHorizontal(board, row, column - ship.getLenght()) && board[row][column - k] == null)
                this.isNull = true;
        }
        if (this.isNull){
            for (int k = 0; k < ship.getLenght(); k++) {
                if(checkCoordinatesHorizontal(board, row, column - ship.getLenght()))
                    board[row][column - k] = ship;
            }
        }
    }

    public void addShipUp(Ship[][] board, int row, int column, Ship ship){
        for (int k = 0; k < ship.getLenght(); k++) {
            if (checkCoordinatesVertical(board, row - ship.getLenght()) && board[row - k][column] != null)
                this.isNull = false;
            if (checkCoordinatesVertical(board, row - ship.getLenght()) && board[row - k][column] == null)
                this.isNull = true;
        }
        if (this.isNull){
            for (int k = 0; k < ship.getLenght(); k++) {
                if (checkCoordinatesVertical(board, row - ship.getLenght()))
                    board[row - k][column] = ship;
            }
        }
    }

    public void addShipBottom(Ship[][] board, int row, int column, Ship ship){
        for (int k = 0; k < ship.getLenght(); k++) {
            if(checkCoordinatesVertical(board, row + ship.getLenght()) && board[row + k][column] != null)
                this.isNull = false;
            if(checkCoordinatesVertical(board, row + ship.getLenght()) && board[row + k][column] == null)
                this.isNull = true;
        }
        if (this.isNull){
            for (int k = 0; k < ship.getLenght(); k++) {
                if(checkCoordinatesVertical(board, row + ship.getLenght()))
                    board[row + k][column] = ship;
            }
        }
    }

    public boolean setOnFire(Ship[][] board, int row, int column){
        Ship destroyedShip = new Ship(Ship.ClassOfShip.Destroyed, 1);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if(row == i && column == j) {
                    if (board[i][j] != null) {
                        getWhichShipWasHitted(board, row, column);
                        board[i][j] = destroyedShip;
                        destroyedShip.setIcon("\u001B[31m\uD83D\uDD25\u001B[0m");
                        this.point++;
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

    public Ship.ClassOfShip getWhichShipWasHitted(Ship[][] board, int row, int column){
        return board[row][column].getShip();
    }

    public boolean isWin(){
        return point == 17;
    }

    public boolean checkCoordinatesVertical(Ship[][] board, int row){
        if(row > board.length || row < 0) {
            this.intoBoard = false;
            return false;
        }
        else {
            this.intoBoard = true;
            return true;
        }
    }

    public boolean checkCoordinatesHorizontal(Ship[][] board, int row, int column){
        if(column > board[row].length || column < 0) {
            this.intoBoard = false;
            return false;
        }
        else {
            this.intoBoard = true;
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
