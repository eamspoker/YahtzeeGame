public class YahtzeeScorecard {
	/* instance data given */
	private int ones;
	private int twos;
	private int threes;
	private int fours;
	private int fives;
	private int sixes;
	private int threeKind;
	private int fourKind;
	private int fiveKind;
	private int chance;
	private int fullHouse;
	private int smStraight;
	private int lgStraight;
	private boolean bonus;
	private YahtzeeSortDice sorter;

	/* Sets up a new game.  Sets all instance data to incomplete (-1). Sets bonus to false */
	public YahtzeeScorecard()
	{
		/* your code here */
		ones = -1;
		twos = -1;
		threes = -1;
		fours = -1;
		fives = -1;
		sixes = -1;
		threeKind = -1;
		fourKind = -1;
		fiveKind = -1;
		chance = -1;
		fullHouse = -1;
		smStraight = -1;
		lgStraight = -1;
		bonus = false;

	}

	/* 1. If the field is already full, return false
	   2. Set data value ones equal to number of ones rolled multiplied by one.
	   3. Update the bonus (call updateBonus())
	   4. Return true   */
	public boolean markOnes(int die1, int die2, int die3, int die4, int die5)
	{
		/* your code here */
		if(ones == -1){
		int counter = 0;
		if(die1 == 1){
			counter++;
		}

		if(die2 == 1){
			counter++;
		}

		if(die3 == 1){
			counter++;
		}

		if(die4 == 1){
			counter++;
		}

		if(die5 == 1){
			counter++;
		}

		this.ones = counter;

		updateBonus();
		return true;

	} else {
		return false;
	}
	}

	/* 1. If the field is already full, return false
	   2. Set data value twos equal to number of twos rolled multiplied by two.
	   3. Update the bonus (call updateBonus())
	   4. Return true   */
	public boolean markTwos(int die1, int die2, int die3, int die4, int die5)
	{
		/* your code here */
		if(twos == -1){
			int counter = 0;
			if(die1 == 2){
				counter += 2;
			}

			if(die2 == 2){
				counter += 2;
			}

			if(die3 == 2){
				counter += 2;
			}

			if(die4 == 2){
				counter += 2;
			}

			if(die5 == 2){
				counter += 2;
			}

			this.twos = counter;
			updateBonus();
			return true;

		} else {
			return false;
		}
	}

	/* 1. If the field is already full, return false
	   2. Set data value threes equal to number of threes rolled multiplied by three.
	   3. Update the bonus (call updateBonus())
	   4. Return true  */
	public boolean markThrees(int die1, int die2, int die3, int die4, int die5)
	{
		/* your code here */
		if(threes == -1){
			int counter = 0;
			if(die1 == 3){
				counter += 3;
			}

			if(die2 == 3){
				counter += 3;
			}

			if(die3 == 3){
				counter += 3;
			}

			if(die4 == 3){
				counter +=3;
			}

			if(die5 == 3){
				counter += 3;
			}

			this.threes = counter;
			updateBonus();
			return true;

		} else {
			return false;
		}

	}

	/* 1. If the field is already full, the method returns false
	   2. Sets data value fours equal to number of fours rolled multiplied by four.
	   3. Update the bonus (call updateBonus())
	   4. Returns true   */
	public boolean markFours(int die1, int die2, int die3, int die4, int die5)
	{
		/* your code here */
		if(fours == -1){
			int counter = 0;
			if(die1 == 4){
				counter += 4;
			}

			if(die2 == 4){
				counter += 4;
			}

			if(die3 == 4){
				counter += 4;
			}

			if(die4 == 4){
				counter +=4;
			}

			if(die5 == 4){
				counter += 4;
			}

			this.fours = counter;
			updateBonus();
			return true;

		} else {
			return false;
		}
	}

	/* 1. If the field is already full, the method returns false
	   2. Sets data value fives equal to number of fives rolled multiplied by five.
	   3. Update the bonus (call updateBonus())
	   4. Returns true   */
	public boolean markFives(int die1, int die2, int die3, int die4, int die5)
	{
		/* your code here */
		if(fives == -1){
			int counter = 0;
			if(die1 == 5){
				counter += 5;
			}

			if(die2 == 5){
				counter += 5;
			}

			if(die3 == 5){
				counter += 5;
			}

			if(die4 == 5){
				counter +=5;
			}

			if(die5 == 5){
				counter += 5;
			}

			this.fives = counter;
			updateBonus();
			return true;

		} else {
			return false;
		}
	}

	/* 1. If the field is already full, the method returns false
	   2. Sets data value sixes equal to number of sixes rolled multiplied by six.
	   3. Update the bonus (call updateBonus())
	   4. Returns true */
	public boolean markSixes(int die1, int die2, int die3, int die4, int die5)
	{
		/* your code here */
		if(sixes == -1){
			int counter = 0;
			if(die1 == 6){
				counter += 6;
			}

			if(die2 == 6){
				counter += 6;
			}

			if(die3 == 6){
				counter += 6;
			}

			if(die4 == 6){
				counter += 6;
			}

			if(die5 == 6){
				counter += 6;
			}

			this.sixes = counter;
			updateBonus();
			return true;

		} else {
			return false;
		}
	}

	/* 	1. If the field is already full, return false
		2. Check to see if there are actually three of the same value.
		   If there are, set the data value threeKind to the value of all five dice.
		   If there aren�t set the value to 0.
	   	   (Hint: use YahtzeeSortDice class!)
	   	4. Return true   */
	public boolean markThreeOfAKind(int die1, int die2, int die3, int die4, int die5) {
		/* your code here */
		sorter = new YahtzeeSortDice(die1, die2, die3, die4, die5);
		if (threeKind == -1) {
			if (sorter.getFirst() == sorter.getSecond() && sorter.getSecond() == sorter.getThird()) {
				threeKind = die1 + die2 + die3 + die4 + die5;
				return true;
			} else if (sorter.getSecond() == sorter.getThird() && sorter.getThird() == sorter.getFourth()) {
				threeKind = die1 + die2 + die3 + die4 + die5;
				return true;
			} else if (sorter.getThird() == sorter.getFourth() && sorter.getFourth() == sorter.getFifth()) {
				threeKind = die1 + die2 + die3 + die4 + die5;
				return true;
			} else{
				threeKind = 0;
				return true;
			}

		} else {
			return false;
		}

	}

	/* 	1. If the field is already full, return false
		2. Check to see if there are actually four of the same value.
		   If there are, set the data value fourKind to the value of all five dice.
		   If there aren�t set the value to 0;
		   (Hint: use YahtzeeSortDice class!)
		4. Return true  */
	public boolean markFourOfAKind(int die1, int die2, int die3, int die4, int die5)
	{
		/* your code here */
		sorter = new YahtzeeSortDice(die1, die2, die3, die4, die5);
		if(fourKind == -1) {
			if (sorter.getFirst() == sorter.getSecond() && sorter.getSecond() == sorter.getThird() && sorter.getThird() == sorter.getFourth()) {
				fourKind = die1 + die2 + die3 + die4 + die5;
				return true;
			} else if(sorter.getSecond() == sorter.getThird() && sorter.getThird() == sorter.getFourth() && sorter.getFourth() == sorter.getFifth()){
				fourKind = die1 + die2 + die3 + die4 + die5;
				return true;
			} else{
				fourKind = 0;
				return true;
			}

		} else {
			return false;
		}
	}

	/* 1. If the field is already full, return false
	   2. Check to see if there are actually three die with the same value, and two with another value.
	      If there are, set the data value fullHouse to 25.
	      If there aren�t set the value to 0.
	      (Hint: Use YahtzeeSortedDice class!)
       3. Return true   */
	public boolean markFullHouse(int die1, int die2, int die3, int die4, int die5)
	{
		/* your code here */
		sorter = new YahtzeeSortDice(die1, die2, die3, die4, die5);
		if (fullHouse == -1) {
			if (sorter.getFirst() == sorter.getSecond() && sorter.getSecond() == sorter.getThird()) {
				if (sorter.getFourth() == sorter.getFifth()) {
					fullHouse = 25;
					return true;
				} else {
					fullHouse = 0;
					return true;
				}

			} else if (sorter.getThird() == sorter.getFourth() && sorter.getFourth() == sorter.getFifth()) {
				if (sorter.getFirst() == sorter.getSecond()) {
					fullHouse = 25;
					return true;
				} else {
					fullHouse = 0;
					return true;
				}
			} else{
				fullHouse = 0;
				return true;
			}

		} else {
			return false;
		}
	}

	/* 	1. If the field is already full, return false
		2. Check to see if there are actually four consecutive dice numbers.
		   If there are, set the data value smStraight to 30.
		   If there aren�t set the value to 0.
		   (Hint: Use YahtzeeSortedDice class)
		4. Return true  */
	public boolean markSmallStraight(int die1, int die2, int die3, int die4, int die5)
	{
		/* your code here */
		sorter = new YahtzeeSortDice(die1, die2, die3, die4, die5);

		if(smStraight == -1){
			if(sorter.getFourth() - sorter.getThird() == 1 && sorter.getThird() - sorter.getSecond() == 1 && sorter.getSecond() - sorter.getFirst() == 1){
				smStraight = 30;
				return true;
			} else if(sorter.getFifth() - sorter.getFourth() == 1 && sorter.getFourth() - sorter.getThird() == 1 && sorter.getThird() - sorter.getSecond() == 1){
				smStraight = 30;
				return true;
			} else{
				smStraight = 0;
				return true;
			}
		} else{
			return false;
		}
	}

	/* 	1. If the field is already full, return false
		2. Check to see if there are actually five consecutive dice numbers.
		   If there are, set the data value lgStraight to 40.
		   If there aren�t set the value to 0;
		   (Hint: use YahtzeeSortDice class!)
		3. Return true  */
	public boolean markLargeStraight(int die1, int die2, int die3, int die4, int die5)
	{
		/* your code here */
		sorter = new YahtzeeSortDice(die1, die2, die3, die4, die5);
		if(sorter.getFifth() - sorter.getFourth() == 1 && sorter.getFourth() - sorter.getThird() == 1 && sorter.getThird() - sorter.getSecond() == 1 && sorter.getSecond() - sorter.getFirst() ==1){
			lgStraight = 40;
			return  true;
		} else{
			lgStraight = 0;
			return true;
		}
	}

	/* 1. If the field is already full, return false
	   2. Checks to see if there are actually five of the same value.  If there are, set the data value fiveKind to 50.  If there aren�t set the value to 0;
       3. Return true   */
	public boolean markYahtzee(int die1, int die2, int die3, int die4, int die5)
	{
		/* your code here */
		if(fiveKind == -1) {
			if (die1 == die2 && die2 == die3 && die3 == die4 && die4 == die5) {
				fiveKind = 50;
				return true;
			} else {
				fiveKind = 0;
				return true;
			}
		} else{
			return false;
		}
	}

	/* 1. If the field is already full, return false
	   2. Set the data value chance to the value of all five dice.
	   3. Return true  */
	public boolean markChance(int die1, int die2, int die3, int die4, int die5)
	{
		/* your code here */
		if(chance == -1){
			chance = die1 + die2 + die3 + die4+ die5;
			return true;
		} else {
			return false;
		}
	}

	/* 	1. If the bonus has already been assigned, do nothing
		2. If the upper section�s total is 63 or greater, set the data value bonus to true */
	private void updateBonus()
	{
		/* your code here */
		if(!bonus) {
			if (getUpperTotal() >= 63) {
				bonus = true;
			}
		}
	}

	/* 	returns the upper total, remember incompletes (-1s) should not be factored in! */
	public int getUpperTotal()
	{
		int upTotal = 0;
		if(ones != -1){
			upTotal += ones;
		}

		if(twos != -1){
			upTotal += twos;
		}

		if(threes != -1){
			upTotal += threes;
		}

		if(fours != -1){
			upTotal += fours;
		}

		if(fives != -1){
			upTotal += fives;
		}

		if(sixes != -1){
			upTotal += sixes;
		}

		if(bonus){
			upTotal += 35;
		}

		return upTotal;

	}

	/* 	returns the lower total, remember incompletes (-1s) should not be factored in! */
	public int getLowerTotal()
	{
		int lowTotal = 0;

		if(threeKind != -1){
			lowTotal += threeKind;
		}

		if(fourKind != -1){
			lowTotal += fourKind;
		}

		if(fullHouse != -1){
			lowTotal += fullHouse;
		}

		if(smStraight != -1){
			lowTotal += smStraight;
		}

		if(lgStraight != -1){
			lowTotal += lgStraight;
		}

		if(chance != -1){
			lowTotal += chance;
		}

		if(fiveKind != -1){
			lowTotal += fiveKind;
		}


		return lowTotal;
	}

	/* 	returns the grand total, remember incompletes (-1s) should not be factored in! */
	public int getGrandTotal()
	{
		return getLowerTotal() + getUpperTotal();
	}

	/*	Prints a scorecard with the current total, using "__" to mark uncompleted fields and a number to mark filled fields
		Sample:
		**********************************
		*  	    Yahtzee Score Card		 *
		*  					`		  	 *
		* 	Ones:				__		 *
		* 	Twos:				__		 *
		* 	Threes:				__		 *
		* 	Fours:				__		 *
		* 	Fives:				25		 *
		* 	Sixes:				__		 *
		*								 *
		*	Upper Bonus:		 0		 *
		* 	Upper Total:   		25		 *
		*								 *
		*	3 of Kind:			__		 *
		* 	4 of Kind:			__		 *
		* 	Full House:			25		 *
		* 	Sm Straight:		__		 *
		* 	Lg  Straight:		__		 *
		* 	Yahtzee:	  		 0		 *
		* 	Chance:				__		 *
		*								 *
		* 	Lower Total:		25		 *
		*								 *
		* 	Grand Total:		50		 *
		**********************************
		already implemented
	*/
	public void printScoreCard()
	{
		System.out.println();
		System.out.println("*********************************");
		System.out.println("*      Yahtzee Score Card       *");
		System.out.println("*                               *");
		System.out.print("*  Ones:\t\t");
		if(ones==-1)System.out.print("__");
		else System.out.print(ones);
		System.out.println("\t\t\t\t*");
		System.out.print("*  Twos:\t\t");
		if(twos==-1)System.out.print("__");
		else System.out.print(twos);
		System.out.println("\t\t\t\t*");
		System.out.print("*  Threes:\t\t");
		if(threes==-1)System.out.print("__");
		else System.out.print(threes);
		System.out.println("\t\t\t\t*");
		System.out.print("*  Fours:\t\t");
		if(fours==-1)System.out.print("__");
		else System.out.print(fours);
		System.out.println("\t\t\t\t*");
		System.out.print("*  Fives:\t\t");
		if(fives==-1)System.out.print("__");
		else System.out.print(fives);
		System.out.println("\t\t\t\t*");
		System.out.print("*  Sixes:\t\t");
		if(sixes==-1)System.out.print("__");
		else System.out.print(sixes);
		System.out.println("\t\t\t\t*");
		System.out.println("*\t\t\t\t\t\t\t\t*");
		System.out.print("*  Upper Bonus:\t\t");
		if(bonus)System.out.print("35");
		else System.out.print("0");
		System.out.println("\t\t\t*");
		System.out.print("*  Upper Total:\t\t");
		System.out.print(this.getUpperTotal());
		System.out.println("\t\t\t*");
		System.out.println("*                               *");
		System.out.print("*  3 of Kind:\t\t");
		if(threeKind==-1)System.out.print("__");
		else System.out.print(threeKind);
		System.out.println("\t\t\t*");
		System.out.print("*  4 of Kind:\t\t");
		if(fourKind==-1)System.out.print("__");
		else System.out.print(fourKind);
		System.out.println("\t\t\t*");
		System.out.print("*  Full House:\t\t");
		if(fullHouse==-1)System.out.print("__");
		else System.out.print(fullHouse);
		System.out.println("\t\t\t*");
		System.out.print("*  Sm Straight:\t\t");
		if(smStraight==-1)System.out.print("__");
		else System.out.print(smStraight);
		System.out.println("\t\t\t*");
		System.out.print("*  Lg Straight:\t\t");
		if(lgStraight==-1)System.out.print("__");
		else System.out.print(lgStraight);
		System.out.println("\t\t\t*");
		System.out.print("*  Yahtzee:\t\t");
		if(fiveKind==-1)System.out.print("__");
		else System.out.print(fiveKind);
		System.out.println("\t\t\t\t*");
		System.out.print("*  Chance:\t\t");
		if(chance==-1)System.out.print("__");
		else System.out.print(chance);
		System.out.println("\t\t\t\t*");
		System.out.println("*                               *");
		System.out.print("*  Lower Total:\t\t");
		System.out.print(this.getLowerTotal());
		System.out.println("\t\t\t*");
		System.out.println("*                               *");
		System.out.print("*  Grand Total:\t\t");
		System.out.print(this.getGrandTotal());
		System.out.println("\t\t\t*");
		System.out.println("**********************************");
		System.out.println();
	}


}