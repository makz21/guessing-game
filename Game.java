import java.util.Random;
import java.util.Scanner;


public class Game {
    private final int N;
    private int randomNumber;
    private int givenNumer;
    private int attempts;

    Random rand = new Random();
    Scanner in = new Scanner(System.in);


    public Game(int N) {
        this.N = N;
    }

    public void startGame() {
        getRandomNumber();
        try {
            while (givenNumer != randomNumber) {
                getNumberFromUser();
                ++attempts;
                if (givenNumer < randomNumber) {
                    DisplayMessageTooLess();
                } else if (givenNumer > randomNumber) {
                    DisplayMessageTooMuch();
                } else {
                    DisplayEndGameMessage();
                    attempts = 0;
                    givenNumer = 0;
                    if (exitGame()) {
                        System.exit(0);
                    }
                }
            }
        } catch (Exception d) {
            System.out.println("Unexpected program error" + d);
        }
    }

    private void getRandomNumber() {
        randomNumber = rand.nextInt(N) + 1;
       // System.out.println("wylosowana liczba:" + randomNumber);
    }

    private void getNumberFromUser() {
        System.out.println("Give a numer:");
        while (!in.hasNextInt()) {
            System.out.println("You have to enter an integer:");
            in.next();
        }
        givenNumer = in.nextInt();
    }

    private void DisplayEndGameMessage() {
        System.out.println("Correct answer: " + attempts);

    }

    private boolean exitGame() {
        String c;
        do {
            System.out.println("Would you like end game? [Y]/[N]");
            c = in.next();
            if (c.equalsIgnoreCase("N")) {
                getRandomNumber();
                return false;
            }
        } while (!c.equalsIgnoreCase("Y"));
        return true;
    }

    private void DisplayMessageTooLess() {
        System.out.println("Enter a larger number");
    }

    private void DisplayMessageTooMuch() {
        System.out.println("Enter a smaller number");
    }

}
