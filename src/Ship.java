public class Ship {
    public enum ClassOfShip {Carrier, Battleship, Cruiser, Submarine, Destroyer, Destroyed}
    private final ClassOfShip ship;
    private final int lenght;
    private String icon;

    public Ship(ClassOfShip ship, int lenght) {
        this.ship = ship;
        this.lenght = lenght;
        this.icon = "\u001B[32m\uD83D\uDEA2\u001B[0m";
    }
    public int getLenght() {
        return lenght;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String toString(){
        return this.icon;
    }


}
