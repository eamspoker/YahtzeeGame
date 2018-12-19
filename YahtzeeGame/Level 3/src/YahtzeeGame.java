import java.util.Scanner;

public class YahtzeeGame
{
	/* instance data should include the five yahtzee dice, a scoreboard, and a CONSTANT (static final) variable NUM_SIDES
	which should be set to six (the number of sides on a yahtzee die) */
	private YahtzeeDie die1;
	private YahtzeeDie die2;
	private YahtzeeDie die3;
	private YahtzeeDie die4;
	private YahtzeeDie die5;
	private YahtzeeScorecard scorecard;
	private final static int NUM_SIDES = 6;
	private Scanner s = new Scanner(System.in);



	/* initializes the dice and scoreboard */
	public YahtzeeGame()
	{
		/* your code here */
		scorecard = new YahtzeeScorecard();
		die1 = new YahtzeeDie(NUM_SIDES);
		die2 = new YahtzeeDie(NUM_SIDES);
		die3 = new YahtzeeDie(NUM_SIDES);
		die4 = new YahtzeeDie(NUM_SIDES);
		die5 = new YahtzeeDie(NUM_SIDES);

	}

	/* check to see if the game is over, and while the game is not over call the method takeTurn()
	once the game ends (hint: there are 13 turns in a game of Yahtzee), the method should print a
	final scorecard and return the grand total */
	public int playGame()
	{
		/* your code here */
		for(int i = 0; i < 13; i++){
			takeTurn();
		}
		System.out.println(scorecard);
		return 0;
	}

	/* 	1. call rollDice()
		2. call printDice()
		3. Ask the user if they are satisfied with their roll, or if they would like to roll again.
		   If they are not satisfied continue, otherwise call markScore()
		4. call chooseFrozen()
		5. call rollDice()
		6. call printDice()
		7. Ask the user if they are satisfied with their roll, or if they would like to roll again.
		   If they are not satisfied continue, otherwise call markScore()
		8. call chooseFrozen()
		9. call rollDice()
		10. call printDice()
		11. call markScore()
	*/
	private void takeTurn()
	{
		/* your code here */
		rollDice();
		printDice();
		System.out.println("Are you: \n[1] satisfied with your roll\n[2] or would you like to freeze dice and roll again");
		int userChoice = s.nextInt();
		if(userChoice == 2){
			chooseFrozen();
			rollDice();
			printDice();
			System.out.println("Are you: \n[1] satisfied with your roll\n[2] or would you like to freeze dice and roll again");
			userChoice = s.nextInt();
			if(userChoice == 2){
				chooseFrozen();
				rollDice();
				printDice();
				System.out.println("Hit enter to continue...");
				s.nextLine();
				s.nextLine();
				markScore();
			} else{
				System.out.println("Hit enter to continue...");
				s.nextLine();
				s.nextLine();
				markScore();
			}
		} else{
			System.out.println("Hit enter to continue...");
			s.nextLine();
			s.nextLine();
			markScore();
		}
	}

	/* Rolls all unfrozen dice.  Also resets all dice to the unfrozen state after the roll */
	private void rollDice()
	{
		/* your code here */
		if(!die1.isFrozen()){
			die1.rollDie();
		}
		if(!die2.isFrozen()){
			die2.rollDie();
		}
		if(!die3.isFrozen()){
			die3.rollDie();
		}
		if(!die4.isFrozen()){
			die4.rollDie();
		}

		if(!die5.isFrozen()) {
			die5.rollDie();
		}
		die1.unfreezeDie();
		die2.unfreezeDie();
		die3.unfreezeDie();
		die4.unfreezeDie();
		die5.unfreezeDie();
	}

	/* Asks the user which dice should be frozen 1-5 (should be read in in one line) */
	private void chooseFrozen()
	{
		/* your code here */
		System.out.println("Which dice would you like to freeze? (1-5, no spaces in between)");
		s.nextLine();
		String userFreeze = s.nextLine();
		for(int i = 0; i <  userFreeze.length(); i++){
			switch(userFreeze.charAt(i)){
				case '1':
					die1.freezeDie();
					break;
				case '2':
					die2.freezeDie();
					break;
				case '3':
					die3.freezeDie();
					break;
				case '4':
					die4.freezeDie();
					break;
				case '5':
					die5.freezeDie();
					break;
				default:
					System.out.println("Number at spot number : " + (i+1) + " is invalid");
			}
		}
	}

	/* Should print the value of all five dice separated by a tab (\t) to the console */
	private void printDice()
	{
		/* your code here */
		System.out.println(die1.getValue() + "\t" + die2.getValue() + "\t" + die3.getValue() + "\t" + die4.getValue() + "\t" + die5.getValue());
	}

	/* 1. Print a scoreboard
	   2. Ask the user where they would like to mark their score.
	   3. Call appropriate function
	   4. If false is returned the user entered an invalid number, so ask the user to try again	*/
	private void markScore()
	{
		/* your code here */
		scorecard.printScoreCard();
		System.out.println("Where would you like to mark your score? ");
		System.out.println("[1] Aces" + "\t[7] Three of a kind" + "\n[2] Twos" + "\t[8] Four of a kind" + "\n[3] Threes" + "\t[9] Full House" + "\n[4] Fours" + "\t[10] Small Straight" + "\n[5] Fives" + "\t[11] Large Straight" + "\n[6] Sixes" + "\t[12] Chance" + "\n\t[13] Yahtzee");
		int choice = s.nextInt();
		switch(choice){
			case 1:
				if(!scorecard.markOnes(die1.getValue(), die2.getValue(), die3.getValue(), die4.getValue(), die5.getValue())){
					System.out.println("Not a valid value, try again");
					markScore();
				}
				break;
			case 2:
				if(!scorecard.markTwos(die1.getValue(), die2.getValue(), die3.getValue(), die4.getValue(), die5.getValue())){
					System.out.println("Not a valid value, try again");
					markScore();
				}
				break;
			case 3:
				if(!scorecard.markThrees(die1.getValue(), die2.getValue(), die3.getValue(), die4.getValue(), die5.getValue())){
					System.out.println("Not a valid value, try again");
					markScore();
				}
				break;
			case 4:
				if(!scorecard.markFours(die1.getValue(), die2.getValue(), die3.getValue(), die4.getValue(), die5.getValue())){
					System.out.println("Not a valid value, try again");
					markScore();
				}
				break;
			case 5:
				if(!scorecard.markFives(die1.getValue(), die2.getValue(), die3.getValue(), die4.getValue(), die5.getValue())){
					System.out.println("Not a valid value, try again");
					markScore();
				}
				break;
			case 6:
				if(!scorecard.markSixes(die1.getValue(), die2.getValue(), die3.getValue(), die4.getValue(), die5.getValue())){
					System.out.println("Not a valid value, try again");
					markScore();
				}
				break;
			case 7:
				if(!scorecard.markThreeOfAKind(die1.getValue(), die2.getValue(), die3.getValue(), die4.getValue(), die5.getValue())){
					System.out.println("Not a valid value, try again");
					markScore();
				}
				break;
			case 8:
				if(!scorecard.markFourOfAKind(die1.getValue(), die2.getValue(), die3.getValue(), die4.getValue(), die5.getValue())){
					System.out.println("Not a valid value, try again");
					markScore();
				}
				break;
			case 9:
				if(!scorecard.markFullHouse(die1.getValue(), die2.getValue(), die3.getValue(), die4.getValue(), die5.getValue())){
					System.out.println("Not a valid value, try again");
					markScore();
				}
				break;
			case 10:
				if(!scorecard.markSmallStraight(die1.getValue(), die2.getValue(), die3.getValue(), die4.getValue(), die5.getValue())){
					System.out.println("Not a valid value, try again");
					markScore();
				}
				break;
			case 11:
				if(!scorecard.markLargeStraight(die1.getValue(), die2.getValue(), die3.getValue(), die4.getValue(), die5.getValue())){
					System.out.println("Not a valid value, try again");
					markScore();
				}
				break;
			case 12:
				if(!scorecard.markChance(die1.getValue(), die2.getValue(), die3.getValue(), die4.getValue(), die5.getValue())){
					System.out.println("Not a valid value, try again");
					markScore();
				}
				break;
			case 13:
				if(!scorecard.markYahtzee(die1.getValue(), die2.getValue(), die3.getValue(), die4.getValue(), die5.getValue())){
					System.out.println("Not a valid value, try again");
					markScore();
				}
				break;
			default:
				System.out.println("Not a valid value, try again");
				markScore();
				break;
		}

	}
}