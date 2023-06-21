public abstract class Item {


    protected String alphabet="abcdefgh";
    protected String numbers="12345678";
    private char team;
    private char print;

    public char getTeam() {
        return team;
    }

    public void setTeam(char team) {
        this.team = team;
    }

    public char getPrint() {
        return print;
    }

    public void setPrint(char print) {
        this.print = print;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    int point;
    public Item(){
        print='-';
    }

    public Item(char t){
        team=t;
    }

    public String toString(){
        String s="";
        s+=print;
        return s;
    }

    public boolean isEmpty(String to){
        int ll = alphabet.indexOf(to.charAt(0));
        int li = numbers.indexOf(to.charAt(1));
        return Game.board.board[ll][li].print=='-';
    }


    public abstract boolean movable(String from,String to);
    public abstract boolean edible(String from,String to);
    public abstract boolean pathIsClear(String from,String to);
}