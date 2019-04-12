package towers;
import java.util.*;

public class MyProgram
{
    public static int[][] towers;
    public static int[][] temp;
    public static int[][] end;
    public static Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args)
    {
        gameSize(readInt("How many disks do you want? "));
        testTowers();
        setEnd();
        play();
        
    }
    
    public static void play()
    {
        boolean won = false;
        while(won == false)
        {
            move();
            if(won())
            {
                break;
            }
        }
        System.out.println("YOU HAVE WON!!!!!");
    }
    
    public static boolean won()
    {
        for(int i = 0; i < towers.length; i++)
        {
            for(int j = 0; j < towers[0].length; j++)
            {
                if(towers[i][j] == end[i][j])
                {
                	
                }
                else
                {
                	return false;
                }
            }
        }
        return true;
    }
    
    
    public static void move()
    {
        int towerFrom = readInt("What tower are you moving from? ");
        int towerTo = readInt("What tower are you moving to? ");
        int movingNum = 0;
        int level = 0;
        towerFrom --;
        towerTo--;
        for(int i = towers[level][towerFrom]; i < towers.length; i++)
        {
            i = towers[level][towerFrom]; 
            if(i == 0)
            {
                level++;
            }
            else
            {
                movingNum = i;
                break;
            }
        }
        temp = towers;
        int open = findSpot(towerTo, movingNum);
        if(open == -1)
        {
            System.out.println("That is an illegal move try again");
            move();
        }
        towers[open][towerTo] = movingNum;
        towers[level][towerFrom] = 0;
        testTowers();
    }
    public static int findSpot(int tower, int moving)
    {
        for(int i = towers.length -1; i <= towers.length; i--)
        {
            if(towers[i][tower] == 0)
            {
                return towers.length - 1;
            }
            else
            {
                if(temp[i - 1][tower] == 0)
                {
                    if(temp[i][tower] < moving)
                    {
                    
                        return -1;
                    }
                    else
                    {
                        return i - 1;
                    }
                }
                else
                {
                    
                }
            }
        }
        return -1;

        
    }
    
    public static void testTowers()
    {
        for(int i = 0; i < towers.length; i++)
        {
            for(int j = 0; j < towers[0].length; j++)
            {
                System.out.print(towers[i][j] + " \t ");
            }
            System.out.println();
        }
        
    }
    
    
    
    
    public static void gameSize(int rows)
    {
        towers = new int[rows][3];
        end = new int[rows][3];
        if(rows < 3)
        {
            System.out.println("You need at least 3 disks");
            gameSize(readInt("Please choose again "));
        }
        if(rows > 8)
        {
            System.out.println("You can't play with more then 8 disks");
            gameSize(readInt("Please choose again "));
        }
        setTowers();
        setEnd();
        
    }
    
    public static void setTowers()
    {
        for(int i = towers.length; i > 0; i--)
        {
            towers[i - 1][0] = i;
        }
    
    }
    
    public static void setEnd()
    {
        for(int i = towers.length; i > 0; i--)
        {
            end[i - 1][2] = i;
        }
    
    }
    
    
    
    
    
    
    
    
    
    
    public static String readLine(String prompt)
    {
        System.out.print(prompt);
        return scanner.nextLine();
    }
    
    
    public static int readInt(String prompt)
    {

        while(true)
        {
            String input = readLine(prompt);
            try 
            {
                int n = Integer.parseInt(input);
                return n;
            } 
            catch (NumberFormatException e)
            {

            }
        }
    }
    
    
    
}