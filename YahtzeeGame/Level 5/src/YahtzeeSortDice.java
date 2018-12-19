public class YahtzeeSortDice
{
	int first;
	int second;
	int third;
	int fourth;
	int fifth;
	String allInts;

	/* constructor: initializes the private data by sorting the order of the dice */
	public YahtzeeSortDice(int a, int b, int c, int d, int e)
	{
		allInts = "" + a + b + c + d + e;
		int oldFirst = 0;
		int oldSecond = 0;
		int oldThird = 0;
		int oldFourth = 0;
		int oldFifth = 0;

		for(int i = 0; i < allInts.length(); i++){
			if(i == 0){
					first = allInts.charAt(i)- '0';
			} else if(i == 1){
				if(first > allInts.charAt(i)- '0'){
					second = first;
					first = allInts.charAt(i)- '0';
				} else{
					second = allInts.charAt(i)- '0';

				}
			} else if(i == 2){
				if(second > allInts.charAt(i)- '0'){
					if(first > allInts.charAt(i)- '0'){
						third = second;
						second = first;
						first = allInts.charAt(i)- '0';
					} else{
						third = second;
						second = allInts.charAt(i)- '0';

					}
				} else{
					third = allInts.charAt(i)- '0';

				}
			} else if(i == 3){
				if(third > allInts.charAt(i)- '0'){
					if(second > allInts.charAt(i)- '0'){
						if(first > allInts.charAt(i)- '0'){
							fourth = third;
							third = second;
							second = first;
							first = allInts.charAt(i)- '0';
						} else{
							fourth = third;
							third = second;
							second = allInts.charAt(i)- '0';
						}
					} else{
						fourth = third;
						third = allInts.charAt(i)- '0';
					}
				} else {
					fourth = allInts.charAt(i)- '0';
				}
			} else if(i == 4){
				if(fourth > allInts.charAt(i)- '0'){
					if(third > allInts.charAt(i)- '0'){
						if(second > allInts.charAt(i)- '0'){
							if(first > allInts.charAt(i)- '0'){
								fifth = fourth;
								fourth = third;
								third = second;
								second = first;
								first = allInts.charAt(i)- '0';
							} else{
								fourth = third;
								third = second;
								second = allInts.charAt(i)- '0';
							}
						} else{
							fifth = fourth;
							fourth = third;
							third = allInts.charAt(i)- '0';
						}
					} else{
						fifth = fourth;
						fourth = allInts.charAt(i)- '0';

					}
				} else{
					fifth = allInts.charAt(i)- '0';
				}
			}









		}





	}

	/* returns the minimum of the five numbers */
	public int getFirst()
	{
		//your code here
		return first;
	}

	/* returns the b smallest of the five number */
	public int getSecond()
	{
		//your code here
		return second;
	}

	/* returns the middle of the five numbers */
	public int getThird()
	{
		//your code here
		return third;
	}

	/* returns the b largest of the five numbers */
	public int getFourth()
	{
		//your code here
		return fourth;
	}

	/* returns the biggest of the five numbers */
	public int getFifth()
	{
		//your code here
		return fifth;
	}
}