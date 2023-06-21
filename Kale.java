public class Kale extends Item{
    public Kale(char t) {
        super(t);
        setPrint('K');
        if (t == 'b') {
            setPrint('k');
            Game.white.getRocks().add(this);
        }
        else
            Game.black.getRocks().add(this);
        setPoint(5);
    }

    public boolean movable(String from,String to){
        int fl= alphabet.indexOf(from.charAt(0));
        int fi= numbers.indexOf(from.charAt(1));
        int ll= alphabet.indexOf(to.charAt(0));
        int li= numbers.indexOf(to.charAt(1));

        return ((fl == ll && Math.abs(fi-li)>0)||(fi == li && Math.abs(fl-ll)>0))&& Game.board.board[ll][li].getPrint()=='-';
    }

    public boolean edible(String from,String to){
        int fl= alphabet.indexOf(from.charAt(0));
        int fi= numbers.indexOf(from.charAt(1));
        int ll= alphabet.indexOf(to.charAt(0));
        int li= numbers.indexOf(to.charAt(1));

        return  (Game.board.board[ll][li].getTeam())!=Game.board.board[fl][fi].getTeam();//((fl == ll && Math.abs(fi-li)>0)||(fi == li && Math.abs(fl-ll)>0))&&
    }

     public boolean pathIsClear(String from,String to) {
        int fl = alphabet.indexOf(from.charAt(0));
        int fi = numbers.indexOf(from.charAt(1));
        int ll = alphabet.indexOf(to.charAt(0));
        int li = numbers.indexOf(to.charAt(1));

        for(int i=1; i<Math.abs((fl-ll)+(fi-li));i++) {
            if ((ll == fl ) && (li - fi > 0) && (Game.board.board[fl][fi+i].getPrint() == '-')) {
            }
            else if ((ll == fl ) && (li - fi < 0) && (Game.board.board[fl][fi-i].getPrint() == '-')) {
            }
            else if ((li == fi ) && (ll - fl > 0) && (Game.board.board[fl+i][fi].getPrint() == '-')) {
            }
            else if ((li == fi ) && (ll - fl < 0) && (Game.board.board[fl-i][fi].getPrint() == '-')) {
            }
            else
                return false;
        }
        return true;
    }
}
