import java.util.Scanner;

public class YahtzeeDriver
{
	/*
	1. Creates a new instance of the YahtzeeGame class
	2. Calls the playGame method on the Yahtzee object
	3. Asks user if they would like to play again
	4. When the user is done playing, prints the number of games played, min, max, and average score
	*/
	public static void main(String [] args)
	{	boolean keepPlaying = true;
		Scanner s = new Scanner(System.in);
		int highScore = 0;
		int lowScore = 0;
		int sum = 0;
		int numGames = 0;
		double average = 0;

		do {
			int score;
			YahtzeeGame myGame = new YahtzeeGame();
			System.out.println("Welcome to Emily's APCSA Yahtzee Game!");
			score = myGame.playGame();
			System.out.println("Play another game? (y/n)");
			char choice = s.nextLine().charAt(0);
			keepPlaying = choice == 'y';
			if(score > highScore){
				highScore = score;
			} else if(score < lowScore){
				lowScore = score;
			}
			sum += score;
			numGames++;
			average = (sum*1.0)/numGames;

			System.out.println("HIGH SCORE: " + highScore + " LOW SCORE: " + lowScore + " AVERAGE SCORE: " + average);

		} while(keepPlaying);
	}
}
