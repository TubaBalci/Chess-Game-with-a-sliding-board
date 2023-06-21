public class Board {
    public Item[][] board;

    public Board(){
        board= new Item[8][8];
        for(int i=0; i<board.length; i++) {
            for (int j = 0; j < board[0].length; j++)
                board[i][j] = new Item() {
                    public boolean movable(String from, String to) {
                        return false;
                    }

                    public boolean edible(String from, String to) {
                        return false;
                    }

                    @Override
                    public boolean pathIsClear(String from, String to) {
                        return false;
                    }
                };
        }
    }

    public void kaydir(){
        for(int i=0; i<board.length; i++) {
            Item first = board[i][0];
            for (int j = 0; j+1 < board[0].length; j++)
                board[i][j] = board[i][ j + 1];
            board[i][board[0].length-1]=first;
        }
    }

    public String toString(){
        String toReturn="";
        char[] alphabet= {'a','b','c','d','e','f','g','h'};
        toReturn+=" ";
        for(int i=1; i<9;i++)
           toReturn+="\t"+i;
        toReturn+="\n";
        for(int i=0; i<board.length; i++) {
            toReturn+= alphabet[i];
            for (int j = 0; j < board[0].length; j++)
                toReturn+="\t"+board[i][j];
            toReturn+="\n";
        }


        return toReturn;
    }

}
