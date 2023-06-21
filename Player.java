import java.util.ArrayList;

public class Player {

    private String name;
    private ArrayList<Item> rocks=new ArrayList<>();
    private int score;

    public Player(String ad){
        name=ad;
    }
    public ArrayList<Item> getRocks() {
        return rocks;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    public void setRocks(ArrayList<Item> rocks) {
        this.rocks = rocks;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }


}
