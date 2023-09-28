package numberGame;


public class Main {
    public static void main(String[] args) {
        NumberGame game = new NumberGame();
        if (game.confirmGame) {
            game.playGame();
        }
    }
}
