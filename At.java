public class At extends Item{

    public At(char t){
        super(t);
        setPrint('A');
        if (t == 'b') {
            setPrint('a');
            Game.white.getRocks().add(this);
        }
        else
            Game.black.getRocks().add(this);
        setPoint(3);
    }

    @Override
    public boolean movable(String from, String to) {
        int fl = alphabet.indexOf(from.charAt(0));
        int fi = numbers.indexOf(from.charAt(1));
        int ll = alphabet.indexOf(to.charAt(0));
        int li = numbers.indexOf(to.charAt(1));

        return (Math.pow(fl-ll,2)+Math.pow(fi-li,2)==5)&&Game.board.board[ll][li].getPrint()=='-';
    }

        @Override
    public boolean edible(String from, String to){
        int fl = alphabet.indexOf(from.charAt(0));
        int fi = numbers.indexOf(from.charAt(1));
        int ll = alphabet.indexOf(to.charAt(0));
        int li = numbers.indexOf(to.charAt(1));

        return (Math.pow(fl-ll,2)+Math.pow(fi-li,2)==5)&&(Game.board.board[ll][li].getTeam())!=Game.board.board[fl][fi].getTeam();
}

    @Override
    public boolean pathIsClear(String from, String to) {
        return true;
    }
}
