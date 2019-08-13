
/*
Maze game puzzle. Find your way out!
The maze has a start entrance position and an exit or finishing position.
Author @Elena Voinu
* */
package Lab7;
import java.util.Scanner;

public class Maze {

    static Scanner sc = new Scanner(System.in);
    // maze movements
    static char myMove = '\0';
    // cell position
    static int currentCell = 0;
    static String position = " ";
    static int score = 0;
    static boolean advance = true;
    static boolean checkThis = false;


    public static void main(String args[])
    {
        // the local variables declared and initialized
        char answer = 'Y';

        displayMenu();

        while(answer == 'Y' || answer == 'y')
        {
            displayMovement();
            makeYourMove();
            checkThis = checkYourMove();
            mazeStatus();

            System.out.println("Move again(Y or N)?");
            answer = sc.next().charAt(0);

        }
        System.out.println("***************************");

    }// end main() method

    static void displayMenu()
    {
        System.out.println("");
        System.out.println("***************************");
        System.out.println("----The Maze Strategy---");
        System.out.println("");
    }// end method

    static void displayMovement()
    {
        if(currentCell == 0)
        {
            System.out.println("You have entered the maze!!");
            System.out.println("There is no turning back!!");
            currentCell = 1;
            mazeStatus();
            advance = true;
        }
        System.out.println("Make your move (W, A, S, D)");
        System.out.println("W = up, A = left, S = down, D = right)");

    }// end method

    static void makeYourMove()
    {
        myMove = sc.next().charAt(0);
        //Count the number of moves in each cell it takes to escape the maze
        score++;
        switch(myMove)
        {
            case 'W': { MoveUp(); break; }
            case 'A': { MoveLeft(); break; }
            case 'S': { MoveDown(); break; }
            case 'D': { MoveRight(); break; }
        }
        // end program menu
    }// end method

    static boolean checkYourMove()
    {
        if(currentCell == 1 && advance == true)
        {
            if (myMove == 'W')
            {
                advance = false;
                System.out.println("Try again");
                return advance;
            }
            if (myMove == 'A')
            {
                advance = false;
                System.out.println("SORRY, there is no return");
                return advance;
            }
            if (myMove == 'D')
            {
                currentCell = 2;
                advance = true;
                System.out.println("Continue through the maze");
                return advance;

            }
            if (myMove == 'S')
            {
                advance = true;
                System.out.println("Continue through the maze");
                return advance;
            }
        }

        if(currentCell == 2 && advance == true)
        {
            if (myMove == 'W')
            {
                advance = false;
                System.out.println("try again");
                return advance;
            }
            if (myMove == 'A')
            {
                advance = false;
                System.out.println("SORRY, there is no return");
                return advance;
            }
            if (myMove == 'D')
            {
                advance = false;
                System.out.println("Continue through the maze");
                return advance;
            }
            if (myMove == 'S') {
                currentCell = 5;
                advance = true;
                System.out.println("Continue through the maze");
                return advance;
            }
        }
/*
* Cells 3 through 9 were added to this starter code as instructed. Cell number 9 contains the
* exit from the maze. The score variable holds the amount of moves the user makes in  each cell
* and updates in the end the total moves it took to find the finish point*/

        if(currentCell == 3 && advance == true)
        {
            // if user goes the wrong way, advance is set to true to avoid getting stuck in the cell
            if (myMove == 'W')
            {
                //Update cell number the user is in
                currentCell = 3;
                advance = true;
                System.out.println("Can not go that way, the wall is blocking you \nchoose your move again");
                return advance;
            }

            // if user goes the wrong way, advance is set to true to avoid getting stuck in the cell
            if (myMove == 'A')
            {
                //Update cell number the user is in
                currentCell = 3;
                advance = true;
                System.out.println("Can not go that way, the wall is blocking you \nchoose your move again");
                return advance;
            }

            // if user goes the wrong way, advance is set to true to avoid getting stuck in the cell
            if (myMove == 'D')
            {
                //Update cell number the user is in
                currentCell = 3;
                advance = true;
                System.out.println("Can not go that way, the wall is blocking you \nChoose your move again");
                return advance;
            }

            //user goes down - the right way, ends up in cell 6
            if (myMove == 'S')
            {
                //Update cell number the user is in
                currentCell = 6;
                advance = true;
                System.out.println("Continue through the maze");
                return advance;
            }
        }
        //cell 4 has only one exit -> to cell 7
        if(currentCell == 4 && advance == true)
        {
            // if user goes the wrong way, advance is set to true to avoid getting stuck in the cell
            if (myMove == 'W')
            {
                //Update cell number the user is in
                currentCell = 4;
                advance = true;
                System.out.println("Can not go that way, the wall is blocking you \nChoose your move again");
                return advance;
            }
            if (myMove == 'A')
            {
                //Update cell number the user is in after each move
                currentCell = 4;
                advance = true;
                System.out.println("Can not go that way, the wall is blocking you \nChoose your move again");
                return advance;
            }
            if (myMove == 'D')
            {
                //Update the cell number the user is in after each move
                currentCell = 4;
                advance = true;
                System.out.println("Can not go that way, the wall is blocking you \nChoose your move again");
                return advance;
            }
            if (myMove == 'S')
            {
                //Update the cell number the user is in after the user finally moves the right way
                currentCell = 7;
                advance = true;
                System.out.println("Continue through the maze");
                return advance;
            }
        }

        if(currentCell == 5 && advance == true)
        {
            //From cell 5 user ends up back in cell 2 by going up
            if (myMove == 'W')
            {
               //Update cell number the user is in after each move
                currentCell = 2;
                advance = true;
                System.out.println("Continue through the maze");
                return advance;
            }
            // wrong move, can't pass the wall
            if (myMove == 'A')
            {
                // user still in cell 5
                currentCell = 5;
                // advance is set to true to avoid getting stuck in a cell
                advance = true;
                System.out.println("Can not go that way, the wall is blocking you \nchoose your move again");
                return advance;
            }
            // right move!
            if (myMove == 'D')
            {
                // user enters cell 6
                currentCell = 6;
                advance = true;
                System.out.println("Continue through the maze");
                return advance;
            }
            if (myMove == 'S')
            {
                currentCell = 5;
                advance = true;
                System.out.println("Can not go that way, the wall is blocking you \nchoose your move again");
                return advance;
            }
        }
        //cell 6 has 3 exits and only one wall. From here user can go up, down or left.
        if(currentCell == 6 && advance == true)
        {
            if (myMove == 'W')
            {
                currentCell = 3;
                advance = true;
                System.out.println("Continue through the maze");
                return advance;
            }
            if (myMove == 'A')
            {
                currentCell = 5;
                advance = true;
                System.out.println("Continue through the maze");
                return advance;
            }
            if (myMove == 'D')
            {
                advance = true;
                System.out.println("Can not go that way, the wall is blocking you\nChoose your move again");
                return advance;
            }
            if (myMove == 'S')
            {
                currentCell = 9;
                advance = true;
                System.out.println("Continue through the maze");
                return advance;
            }

        }
        //cell 7 has two exits and two walls
        if(currentCell == 7 && advance == true)
        {
            if (myMove == 'W')
            {
                currentCell = 4;
                advance = true;
                System.out.println("Continue through the maze");
                return advance;
            }

            if (myMove == 'A')
            {
                //user is still in cell 7
                currentCell = 7;
                // advance is set to true to avoid getting stuck
                advance = true;
                System.out.println("Can not go that way, the wall is blocking you\nChoose your move again");
                return advance;
            }
            if (myMove == 'D')
            {
                currentCell = 8;
                advance = true;
                System.out.println("Continue through the maze");
                return advance;
            }
            if (myMove == 'S')
            {
                currentCell = 8;
                advance = true;
                System.out.println("Can not go that way, the wall is blocking you\nChoose your move again");
                return advance;
            }

        }
        //cell 8 has two exit ways
        if(currentCell == 8 && advance == true){
            // if user moves up - wrong way; advance is true to let the user try again and not get stuck in the cell
            if (myMove == 'W')
            {
                currentCell = 8;
                advance = true;
                System.out.println("Can not go that way, the wall is blocking you\nMove again");
                return advance;
            }
            //if user goes left, he ends up in cell 7
            if (myMove == 'A')
            {
                currentCell = 7;
                advance = true;
                System.out.println("Continue through the maze");
                return advance;
            }
            // if user goes right, he ends up in cell 9
            if (myMove == 'D')
            {
                currentCell = 9;
                advance = true;
                System.out.println("Continue through the maze");
                return advance;
            }
            // if user goes the wrong way, advance is set to true to avoid getting stuck in the cell
            if (myMove == 'S')
            {
                currentCell = 8;
                advance = true;
                System.out.println("Can not go that way, the wall is blocking you\nMove again");
                return advance;
            }

        }
        // cell 9 has 3 eixts: one that goes to cell 6, one that goes to cell 8
        //and one that gets the user outside the maze
        if(currentCell == 9 && advance == true)
        {
            if (myMove == 'W')
            {
                currentCell = 6;
                advance = true;
                System.out.println("Continue through the maze");
                return advance;
            }
            if (myMove == 'A')
            {
                currentCell = 8;
                advance = true;
                System.out.println("Continue through the maze");
                return advance;
            }
            if (myMove == 'D')
            {
                // if user goes the wrong way, advance is set to true to avoid getting stuck in the cell
                advance = true;
                System.out.println("Can not go that way, the wall is blocking you\nChoose your move again");
                return advance;
            }
            if(myMove == 'S') {

                advance = false;
                System.out.println("============================================");
                return advance;

            }
        }
        return advance;
        // end program menu
    }// end method

    static void MoveLeft()
    {
        System.out.println("You move to the left");

    }//end method
    static void MoveRight()
    {
        System.out.println("You move to the right");


    }//end method
    static void MoveUp()
    {
        System.out.println("You move up (forward)");

    }//end method
    static void MoveDown()
    {
        System.out.println("You move down (downward)");

    }//end method
    static void mazeStatus()
    {

        if (currentCell == 9 && myMove == 'S' && advance == false) {

            System.out.println("Congratulations! You Have Found The Exit!");
            advance = false;
            position = "Outside The Maze";
            System.out.println("Current position: " + position);
            System.out.println("============================================");
            System.out.println();
            System.out.println("Total moves it took you to escape the maze: " + score);
            System.out.println("_______________________________________________");

            System.exit(0);
        }
        else
            System.out.println("current position: cell " + currentCell);


    }//end method

}// end class
