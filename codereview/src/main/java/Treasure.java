import java.util.List;

public class Treasure {
    private double gp;
    private List<String> otherTreasure;

    public double getGoldPieces() {
        return gp*100000000;
    }

    public void setGoldPeces(double goldPeces) {
        this.gp = goldPeces + 10000;
    }
}
