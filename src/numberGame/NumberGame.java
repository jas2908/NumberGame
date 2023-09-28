package numberGame;

import static javax.swing.JOptionPane.*;

class NumberGame {
    public boolean confirmGame = true;
    int total = 0;
    public int newNumber() {
        int randomNumber;
        randomNumber = (int) (Math.random() * 201);
        return randomNumber;
    }
    private void tooSmall(int number) {

        int tooSmall= showConfirmDialog(null,number + " is too small! Try Again!","Number too Small",YES_NO_OPTION,QUESTION_MESSAGE,null);
        if (tooSmall==NO_OPTION) {
            confirmGame = false;
            System.exit(0);
        } else if (tooSmall == CLOSED_OPTION) {
            confirmGame = false;
            System.exit(0);
        }
        else {
            confirmGame = true;
        }
    }
    private void tooLarge(int number) {
        int tooLarge= showConfirmDialog(null,number + " is too large! Try Again!","Number too Large",YES_NO_OPTION,QUESTION_MESSAGE,null);
        if (tooLarge==NO_OPTION) {
            confirmGame = false;
            System.exit(0);
        } else if (tooLarge == CLOSED_OPTION) {
            confirmGame = false;
            System.exit(0);
        }
        else {
            confirmGame = true;
        }
    }
    public void stopRound(int noOfAttempts, int guess) {
        int newRound= showConfirmDialog(null,guess+" is right! \nYou guessed it right in "+ noOfAttempts + " attempts.\n Do you want to play another round?","New Round",YES_NO_OPTION,QUESTION_MESSAGE,null);
        if (newRound==NO_OPTION) {
            confirmGame = false;
            System.exit(0);
        } else if (newRound == CLOSED_OPTION) {
            confirmGame = false;
            System.exit(0);
        }
        else {
            total=0;
            confirmGame = true;
            playGame();

        }
    }
    public void playGame() {
        int number = 0;
        int randomNumber = newNumber();
        String enterNumber;

        do {
            enterNumber = showInputDialog("I am thinking of a number between 0 and 200.\n Try guessing the number: ");
            if (enterNumber==null){
                return;
            } else if (enterNumber == "") {
                return;
            }
            try {
                number = Integer.parseInt(enterNumber);

                total++;
            } catch (Exception e) {
                int tryAgain = showConfirmDialog(null, "Invalid Input. Do you wish to continue?", "Click a Button", YES_NO_OPTION, QUESTION_MESSAGE, null);
                if (tryAgain == NO_OPTION) {
                    confirmGame = false;
                    return;
                } else if (tryAgain == CLOSED_OPTION) {
                    confirmGame = false;
                    return;
                }
                else {
                    confirmGame = true;
                    continue;
                }
            }
            if (number < randomNumber) {
                tooSmall(number);
            } else if (number > randomNumber) {
                tooLarge(number);
            }
        }
        while (number != randomNumber) ;
        if (number == randomNumber) {
            stopRound(total, number);
        }
    }

}
