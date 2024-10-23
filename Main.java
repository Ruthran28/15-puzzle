import java.util.*;;
public class Main extends Board{

    public static void main(String[] args) {
        Scanner io=new Scanner(System.in);
        Boolean loop=true;
        Board.Gamestart();
        while (loop) {
            System.out.println("1.Swap to Empty\n2.Exit Game");
            int choice=io.nextInt();
            switch (choice) 
            {
                case 1:
                System.out.println("enter row position");
                int row=io.nextInt();
                System.out.println("enter coloumn position");
                int col=io.nextInt();

                   if(Board.swap(row, col)){
                    System.out.println("invalid positions give correct position");
                    Board.printBoard();
                    break;
                   }

                   if(Board.wincheck()){
                    System.out.println("You  Won the gamee !!!!!");
                    loop=false;
                    Board.printBoard();
                    break;
                   }
                   
                   Board.printBoard();
                    break;
                case 2:
                 System.out.println("Thank youuu  !!!!!");  
                 loop=false;
                 break;  
                default:
                    break;
            }
            
        }
    
    }
}