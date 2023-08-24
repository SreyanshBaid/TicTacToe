import java.util.*;
class tictactoe
{
    static char[][] board = new char[3][3];
    
    static void initialise(char[][] board)
    {
        for(int i=0;i<3;i++)
        {
            for(int j=0;j<3;j++)
            {
                board[i][j]=' ';
            }
        }
    }
    static void x_input()
    {
        tictactoe t = new tictactoe();
        System.out.println("Player 1");
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter x coordinate");
        int x= sc.nextInt();
        System.out.println("Enter y coordinate");
        int y= sc.nextInt();
        if(board[x][y]==' ')
        {
            board[x][y]='X';
        }
        else
        {
            System.out.println("square already filled!");
            System.out.println("choose a new square");
            x_input();
        }
        System.out.print("\033[H\033[2J");
        System.out.flush();
        t.display(board);
        if(t.check(board,x,y)==true)
        {
            t.victory();
            System.exit(0);
        }
    }

    static void o_input()
    {
        tictactoe t = new tictactoe();
        System.out.println("Player 2");
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter x coordinate");
        int x= sc.nextInt();
        System.out.println("Enter y coordinate");
        int y= sc.nextInt();
        if(board[x][y]==' ')
        {
            board[x][y]='O';
        }
        else
        {
            System.out.println("square already filled!");
            System.out.println("choose a new square");
            o_input();
        }
        System.out.print("\033[H\033[2J");
        System.out.flush();
        t.display(board);
        if(t.check(board,x,y)==true)
        {
            t.victory();
            System.exit(0);
        }
    }



    static void display(char[][] board)
    {
        String art =
            "___________.__     ___________           ___________            \n" +
            "\\__    ___/|__| ___\\__    ___/____    ___\\__    ___/___   ____  \n" +
            "  |    |   |  |/ ___\\|    |  \\__  \\ _/ ___\\|    | /  _ \\_/ __ \\ \n" +
            "  |    |   |  \\  \\___|    |   / __ \\\\  \\___|    |(  <_> )  ___/ \n" +
            "  |____|   |__|\\___  >____|  (____  /\\___  >____| \\____/ \\___  >\n" +
            "                   \\/             \\/     \\/                  \\/ ";
        System.out.println(art);
        System.out.print("  "+board[0][0]+"  "+"|  "+board[0][1]+"  |"+"  "+board[0][2]+"  \n");
        System.out.print("-----+-----+-----\n");
        System.out.print("  "+board[1][0]+"  "+"|  "+board[1][1]+"  |"+"  "+board[1][2]+"  \n");
        System.out.print("-----+-----+-----\n");
        System.out.print("  "+board[2][0]+"  "+"|  "+board[2][1]+"  |"+"  "+board[2][2]+"  \n");
    }

    static boolean check(char[][] board,int x,int y)
    {
        int flag=0;
        for(int i=0;i<3;i++)
        {
            if(board[x][y]!=board[x][i])
            {
                flag=1;
                break;
            }
        }
        if(flag==0)
        {
            return true;
        }
        flag=0;
        for(int i=0;i<3;i++)
        {
            if(board[x][y]!=board[i][y])
            {
                flag=1;
                break;
            }
        }
        if(flag==0)
        {
            return true;
        }
        flag=0;
        for(int i=0;i<3;i++)
        {
            if(board[x][y]!=board[i][i])
            {
                flag=1;
                break;
            }
        }
        if(flag==0)
        {
            return true;
        }
        flag=0;
        for(int i=0;i<3;i++)
        {
            for(int j=0;j<3;j++)
            {
                if((i+j)==2)
                {
                    if(board[x][y]!=board[i][j])
                    {
                        flag=1;
                        break;
                    }
                }
            }
        }
        if(flag==0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }


    static void victory()
    {
         String art =
                "____   ____.__        __                       \n" +
                "\\   \\ /   /|__| _____/  |_  ___________ ___.__.\n" +
                " \\   Y   / |  |/ ___\\   __\\/  _ \\_  __ <   |  |\n" +
                "  \\     /  |  \\  \\___|  | (  <_> )  | \\/\\___  |\n" +
                "   \\___/   |__|\\___  >__|  \\____/|__|   / ____|\n" +
                "                   \\/                   \\/      ";
            
            System.out.println(art);
    }
    

    public static void main(String[]args)
    {
        tictactoe t = new tictactoe();
        System.out.print("\033[H\033[2J");
        System.out.flush();
        String art =
            "___________.__     ___________           ___________            \n" +
            "\\__    ___/|__| ___\\__    ___/____    ___\\__    ___/___   ____  \n" +
            "  |    |   |  |/ ___\\|    |  \\__  \\ _/ ___\\|    | /  _ \\_/ __ \\ \n" +
            "  |    |   |  \\  \\___|    |   / __ \\\\  \\___|    |(  <_> )  ___/ \n" +
            "  |____|   |__|\\___  >____|  (____  /\\___  >____| \\____/ \\___  >\n" +
            "                   \\/             \\/     \\/                  \\/ ";
        
        System.out.println(art);
        System.out.print("     |     |     \n");
        System.out.print("-----+-----+-----\n");
        System.out.print("     |     |     \n");
        System.out.print("-----+-----+-----\n");
        System.out.print("     |     |     \n");
        t.initialise(board);
        for(int i=0;i<9;i++)
        {
            if(i%2==0)
            {
                t.x_input();
            }
            else
            {
                t.o_input();
            }
        }
        System.out.println("________                       ");
        System.out.println("\\______ \\____________ __  _  __");
        System.out.println(" |    |  \\_  __ \\__  \\\\ \\/ \\/ /");
        System.out.println(" |    `   \\  | \\/ __ \\\\     / ");
        System.out.println("/_______  /__|  (____  /\\/\\_/  ");
        System.out.println("        \\/           \\/         ");
    }
}