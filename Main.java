public class Main {

    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Enter correct number of args!(Exactly one)");
            return;
        }
        int N = 0;
        try {
            N = Integer.parseInt(args[0]);
            if(N == 1){
              System.out.println("N must be bigger than 1! Enter correct argument!");
              System.exit(1);
            }
            Game game = new Game(N);
            game.startGame();

        } catch (NumberFormatException e) {
            System.out.println("Arg must be a integer! " + e);
        }
    }
}
