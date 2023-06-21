public class Fil extends Item{
    public Fil(char t) {
        super(t);
        setPrint('F');
        if (t == 'b') {
            setPrint('f');
            Game.white.getRocks().add(this);
        }
        else
            Game.black.getRocks().add(this);
        setPoint(3);
    }


    public boolean movable(String from,String to){
        int fl= alphabet.indexOf(from.charAt(0));
        int fi= numbers.indexOf(from.charAt(1));
        int ll= alphabet.indexOf(to.charAt(0));
        int li= numbers.indexOf(to.charAt(1));

        return (Math.abs(fl-ll)==Math.abs(fi-li)&&(Game.board.board[ll][li].getPrint())=='-');
    }

    public boolean edible(String from,String to){
        int fl= alphabet.indexOf(from.charAt(0));
        int fi= numbers.indexOf(from.charAt(1));
        int ll= alphabet.indexOf(to.charAt(0));
        int li= numbers.indexOf(to.charAt(1));

        return (Math.abs(fl-ll)==Math.abs(fi-li)&&(Game.board.board[ll][li].getTeam())!=Game.board.board[fl][fi].getTeam());
    }
    public boolean pathIsClear(String from,String to) {
        int fl = alphabet.indexOf(from.charAt(0));
        int fi = numbers.indexOf(from.charAt(1));
        int ll = alphabet.indexOf(to.charAt(0));
        int li = numbers.indexOf(to.charAt(1));

            for(int i=1; i<Math.abs(fl-ll);i++) {
                if ((ll - fl > 0) && (li - fi > 0) && (Game.board.board[fl + i][fi + i].getPrint() == '-')) {
                }
                else if ((ll - fl > 0) && (li - fi < 0) && (Game.board.board[fl + i][fi - i].getPrint() == '-')) {
                }
                else if ((ll - fl < 0) && (li - fi > 0) && (Game.board.board[fl - i][fi + i].getPrint() == '-')) {
                }
                else if ((ll - fl < 0) && (li - fi < 0) && (Game.board.board[fl - i][fi - i].getPrint() == '-')) {
                }
                else
                    return false;
            }
        return true;
    }
}
