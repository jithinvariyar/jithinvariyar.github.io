package learnjava;

public class Main {

    public static void main(String[] args) {
        int highScore = calculateResult(true, 800, 5, 100);
        System.out.println("Rani's final score was " + highScore);
        highScore = calculateResult(true, 10000, 8, 200);
        System.out.println("Raju's final score was " + highScore);
        displayHighScorePosition("Raju" ,  calculateHighScorePosition(1500));
        displayHighScorePosition("Rani" ,  calculateHighScorePosition(900));
        displayHighScorePosition("Ramu" ,  calculateHighScorePosition(400));
        displayHighScorePosition("Ramya" , calculateHighScorePosition(50));
    }

    public static int calculateResult(boolean gameOver, int score, int levelCompleted, int bonus) {
        if (gameOver) {
            int finalScore = score + (levelCompleted * bonus);
            finalScore += 200;
            return finalScore;
        }
        else
            return -1 ;
    }
    public static void displayHighScorePosition(String name , int position){
        System.out.println(name + " managed to get in to position " + position + " on the high score table.");
    }
    public static int calculateHighScorePosition(int score){
        int hold = 4;
        if(score >= 1000){
            hold = 1;
        }
        else if(score >= 500){
            hold = 2;
        }
        else if(score >= 100){
            hold = 3;
        }
        return hold;
    }

}
