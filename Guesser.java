
import java.util.*;

public class Guesser {
    
    static Scanner input = new Scanner(System.in);
    static int choice = options();
    static final int turns = 7;
    
    public static void main(String[] args) {
        while (choice != 0){
            if ( choice == 1){
                humanGuesser();
            } else if (choice == 2){
                computerGuesser();
            }else{
                System.out.println("\nThat isn't one of the options\nTry Again\n");
            }
            choice = options();
        }
    }
    
    public static int options(){
        System.out.println("0) exit\n1) Human Guesser\n2) Computer Guesser\n");
        int selection = Integer.parseInt(input.nextLine().trim());
        return selection;
    }
    
    public static void humanGuesser(){
        boolean humanWin = false;
        int correctNum = (int) (Math.random() * 100) + 1;
        for (int i = 0; i < turns; i++){
            System.out.println("Please enter a whole number 1-100: ");
            int guess = Integer.parseInt(input.nextLine().trim());
            if (guess > 0 && guess < 101){
                if (guess < correctNum){
                    System.out.println("Too Low");
                }else if (guess > correctNum){
                    System.out.println("Too High");
                }else{
                    System.out.println("\nYou Got It!\n");
                    i = turns;
                    humanWin = true;
                }
            } else{
                System.out.println("That Number isn't within the parameters");
                i--;
            }
        }
        if (humanWin == false){
            System.out.println("Don't you know its mathematically impossible for you to lose?\nDo Better Next Time\n");
        }
    }
    
    public static void computerGuesser(){
        boolean computerWin = false;
        final int defaultGuess = 50;
        int computerGuess = defaultGuess;
        int maxGuess = 100;
        int minGuess = 1;
        System.out.println("Think of a whole number 1-100, enter 1 when ready");
        int start = 0;
        while (start != 1){
            start = Integer.parseInt(input.nextLine().trim());
        }
        for (int i = 0; i < turns; i++){
            System.out.print("The computer has guessed ");
            System.out.print(computerGuess);
            System.out.print("\n");
            System.out.println("Too (H)igh, too (L)ow, or (C)orrect? ");
            String human = input.nextLine();
            if (human.toUpperCase().equals("H")){
                maxGuess = computerGuess - 1;
                computerGuess = computerGuess +((minGuess - computerGuess - 1) / 2);
            } else if (human.toUpperCase().equals("L")){
                minGuess = computerGuess + 1;
                computerGuess = computerGuess + ((maxGuess - computerGuess + 1) / 2);
            } else if (human.toUpperCase().equals("C")){
               System.out.println("\nThe Computer is happy with its victory\nIt has decided to spare you\n\n");
               computerWin = true;
               i = turns;
            }else{
                System.out.println("\nThat isn't one of the options\nTry Again\n");
                i--;
            }
        }
        if (computerWin == false){
            System.out.println("\nThe Computer is displeased with your lies\nIt has decided to begin the AI uprising and take over the world\nYOU'VE DOOMED US ALL!!!");
        }
    }
}