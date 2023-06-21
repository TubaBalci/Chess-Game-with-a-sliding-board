import java.util.Scanner;

public class Game {

    private int moveNo;
    static Board board;
    static Player white, black;

    public Game(){
        white=new Player("Beyaz");
        black=new Player("Siyah");
        board=new Board();
        for (int i=0;i<8;i++) {
            board.board[0][i] = new Piyon('w');
            board.board[7][i] = new Piyon('b');
        }
        board.board[1]= new Item[]{new Kale('w'), new At('w'), new Fil('w'), new Vezir('w'), new Sah('w'), new Fil('w'), new At('w'), new Kale('w')};
        board.board[6]= new Item[]{new Kale('b'), new At('b'), new Fil('b'), new Vezir('b'), new Sah('b'), new Fil('b'), new At('b'), new Kale('b')};

    }
    public void changeCoordination(String former,String latter,Player player){
        String alphabet="abcdefgh";
        String numbers="12345678";
        int fl= alphabet.indexOf(former.charAt(0));
        int fi= numbers.indexOf(former.charAt(1));
        int ll= alphabet.indexOf(latter.charAt(0));
        int li= numbers.indexOf(latter.charAt(1));

        if (!(board.board[fl][fi].getTeam()=='w'&&player.getName().equals("Beyaz")||board.board[fl][fi].getTeam()=='b'&&player.getName().equals("Siyah"))||(board.board[fl][fi].getTeam()==board.board[ll][li].getTeam()))
        {
            System.out.println("Hatalı Hareket");
            moveNo--;
        }
        else if (board.board[fl][fi].getPrint()!='-'&& board.board[fl][fi].pathIsClear(former,latter))
        {
            if(board.board[fl][fi].edible(former,latter))
            {
                Item took = board.board[fl][fi];
                player.setScore(player.getScore()+ board.board[ll][li].getPoint());
                if (player.getName().equals("White"))
                {
                    black.getRocks().remove(board.board[ll][li]);
                    if (black.getRocks().size()==0||white.getRocks().size()==0)
                        System.out.println("Karsi takimin tasi kalmadi. Kazanan: " + player.getName());
                }
                else
                    white.getRocks().remove(board.board[ll][li]);

                if (board.board[ll][li].getClass().getName().equals("Sah")) {
                    System.out.println(player.getName() + " karsi takimin sahini yedi. Kazanan: " + player.getName());
                    System.exit(0);
                }

                board.board[fl][fi]= new Item() {
                    @Override
                    public boolean movable(String from, String to) {
                        return false;
                    }

                    @Override
                    public boolean edible(String from, String to) {
                        return false;
                    }

                    @Override
                    public boolean pathIsClear(String from, String to) {
                        return false;
                    }
                };
                board.board[ll][li] = took;
                board.kaydir();

            }
            else if(board.board[fl][fi].movable(former,latter))
            {
                Item took = board.board[fl][fi];
                board.board[fl][fi]= new Item() {
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
                board.board[ll][li] = took;
                board.kaydir();
            }
        }
        else
        {
            System.out.println("Hatalı Hareket");
            moveNo--;
        }
    }

    public void start(){
        System.out.println(board);
        Scanner kb= new Scanner(System.in);
        for (moveNo=0; true;moveNo++) {
            if (moveNo%2==0)
            System.out.println("Sira Beyazda. Oynamak istediginiz tasin koordinatini ve tasi koymak istediginiz koordinati giriniz");
            else
                System.out.println("Sira Siyahta. Oynamak istediginiz tasin koordinatini ve tasi koymak istediginiz koordinati giriniz");
            String in, former,latter;
            in=kb.nextLine();
            if (in.equals("exit"))
            {
                System.out.println("Beyaz: "+ white.getScore()+"\t Siyah: "+black.getScore());
                System.exit(0);
            }
            former= in.substring(0,in.indexOf(' '));
            latter=in.substring(in.indexOf(' ')+1);

            if (moveNo%2==0)
                changeCoordination(former,latter,white);
            else
                changeCoordination(former,latter,black);

            System.out.println(board);
        }
    }
}
