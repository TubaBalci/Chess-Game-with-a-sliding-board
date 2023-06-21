public class Piyon extends Item {
    public Piyon(char t) {
        super(t);
        setPrint('P');
        if (t == 'b') {
            setPrint('p');
            Game.white.getRocks().add(this);
        }
        else
            Game.black.getRocks().add(this);
        setPoint(1);
    }

    public boolean movable(String from, String to) {
        int fl = alphabet.indexOf(from.charAt(0));
        int fi = numbers.indexOf(from.charAt(1));
        int ll = alphabet.indexOf(to.charAt(0));
        int li = numbers.indexOf(to.charAt(1));
        if (Game.board.board[ll][li].getPrint() != '-')
            return false;
        if (getPrint() == 'P' && fl == ll && fi + 1 == li)
            return true;
        return getPrint() == 'p' && fl == ll && fi - 1 == li;
    }

    public boolean edible(String from, String to) {
        int fl = alphabet.indexOf(from.charAt(0));
        int fi = numbers.indexOf(from.charAt(1));
        int ll = alphabet.indexOf(to.charAt(0));
        int li = numbers.indexOf(to.charAt(1));
        if (Game.board.board[fl][fi].getTeam() == Game.board.board[ll][li].getTeam())
            return false;
        if (getPrint() == 'P' && fl + 1 == ll && (fi + 1 == li || fi - 1 == li))
            return true;
        return getPrint() == 'p' && fl - 1 == ll && (fi + 1 == li || fi - 1 == li);
    }

    public boolean pathIsClear(String from, String to) {
        return true;
    }

}
