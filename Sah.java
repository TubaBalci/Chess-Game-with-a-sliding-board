public class Sah extends Item{
    public Sah(char t) {
        super(t);
        setPrint('S');
        if (t == 'b') {
            setPrint('s');
            Game.white.getRocks().add(this);
        }
        else
            Game.black.getRocks().add(this);
    }

    public boolean movable(String from,String to){
        int fl= alphabet.indexOf(from.charAt(0));
        int fi= numbers.indexOf(from.charAt(1));
        int ll= alphabet.indexOf(to.charAt(0));
        int li= numbers.indexOf(to.charAt(1));

        return (Math.abs(fl-ll)==1&& fi==li || Math.abs(fi-li)==1&& fl==ll)&&(Game.board.board[ll][li].getPrint())=='-';
    }
    public boolean edible(String from,String to){
        int fl= alphabet.indexOf(from.charAt(0));
        int fi= numbers.indexOf(from.charAt(1));
        int ll= alphabet.indexOf(to.charAt(0));
        int li= numbers.indexOf(to.charAt(1));

        return (Math.abs(fl-ll)==1&& fi==li || Math.abs(fi-li)==1&& fl==ll)&&(Game.board.board[ll][li].getTeam())!=Game.board.board[fl][fi].getTeam();
    }

    public boolean pathIsClear(String from,String to){
        return true;
    }
}
