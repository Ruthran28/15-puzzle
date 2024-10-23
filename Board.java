/**
 * Board
 */
public class Board {

    private static int[][] gameBoard=new int[4][4];
    private static int[] zeropos=new int[2];
    private static int boardlength=Board.gameBoard.length;
    private static int[][] actualnumber=new int[Board.boardlength][Board.boardlength];

    public static void actualnumber(){
        int count=1;
        for(int i=0;i<Board.boardlength;i++){
            for(int j=0;j<Board.boardlength;j++){
                Board.actualnumber[i][j]=count++;
            }
        }
        Board.actualnumber[Board.boardlength-1][Board.boardlength-1]=0;
    }

    public static void createBoard(){
        int count=1;
        while(count<=Board.boardlength*Board.boardlength-1){
            int rows=(int)(Math.random()*Board.gameBoard.length);
            int column=(int)(Math.random()*Board.gameBoard.length);
            if(Board.gameBoard[rows][column]==0){
                Board.gameBoard[rows][column]=count;
                count++;
            }
        }

    }
    public static void printBoard()
    {
        for(int i=0;i<4;i++)
         System.out.print("\t"+i);
         System.out.println();
        System.out.println("---------------------------------");
        for(int i=0;i<Board.boardlength;i++)
        {
            System.out.print(i+"|\t");
            for(int j=0;j<Board.boardlength;j++)
            {
                System.out.print(Board.gameBoard[i][j]+"\t");
            }
            System.out.println();
        }
        System.out.println("---------------------------------");
    }



 public static void findzero()
 {
    for(int i=0;i<Board.boardlength;i++)
    {
        for(int j=0;j<Board.boardlength;j++)
        {
            if(Board.gameBoard[i][j]==0)
            {
                Board.zeropos[0]=i;
                Board.zeropos[1]=j;
                break;
            }

        }
        
    }
 }   

 public static boolean checkboundary(int i,int j)
 {
    if(i>=0 && j>=0 && i<Board.boardlength&& j<Board.boardlength)
    {
        if(i==Board.zeropos[0] && j==Board.zeropos[1]+1 || j==Board.zeropos[1]-1)
        {
            return true;
        }
        else if(j==Board.zeropos[1] && i==Board.zeropos[0]+1 || i==Board.zeropos[0]-1)
        {
            return true;
        }else
        {
            return false;
        }
    }
    
    return false;
 }

public static Boolean swap(int i,int j)
{

    if(Board.checkboundary(i, j))
    {
  Board.gameBoard[Board.zeropos[0]][Board.zeropos[1]]=Board.gameBoard[i][j];
  Board.gameBoard[i][j]=0;
  Board.zeropos[0]=i;
  Board.zeropos[1]=j;
  return false;
    }
    return true;
}

public static boolean wincheck()
{
    if(Board.gameBoard[Board.boardlength-1][Board.boardlength-1]==0){
        for(int i=0;i<Board.boardlength;i++){
            for(int j=0;j<Board.boardlength;j++){
                if(Board.gameBoard[i][j]!=Board.actualnumber[i][j]){
                    return false;
                }
            }
        }
        return true;
    }
    
return false;
}
public static void Gamestart()
{
    Board.createBoard();
    Board.findzero();
    Board.actualnumber();
    Board.printBoard();
}

}