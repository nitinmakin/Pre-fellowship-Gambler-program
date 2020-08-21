import java.util.Random;
public class GambleSimulation 
{
	static int initialAmount = 100;
	static int betPlaced = 1;
	static int stopOfDayLoss = 50;
	static int stopOfDayWin = 150;
	static int twentyDayloss = 0;
	static int twentyDayWin = 0;
	static int day = 0;
	public static void WelcomeMessage()

	{
		System.out.println("Gambler is starting bet from $100");
		System.out.println("He putting $1 in every bet so he win or loss $1 at a time");
		System.out.println("------------------------------");
	}

	public static int generateRandomNo()
	{
		Random random=new Random();
		return random.nextInt(2);
	}

	public static void getTwentyDaysReport()
	{
		while(day < 20)
		{
			initialAmount = 100;
			while(initialAmount > 50 && initialAmount < 150)//per day report start
			{
				int random = generateRandomNo();

				if(random == 0)
					initialAmount--;

				else
					initialAmount++;
			}//per day report end
			if(initialAmount == stopOfDayLoss)
			{
				System.out.println("He LOST for a day"+(day+1)+" is $"+initialAmount);
				twentyDayloss = twentyDayloss+50;
				day++;

			}
			else {
				System.out.println("He win for day "+(day+1)+" is $"+initialAmount);
				twentyDayWin = twentyDayWin+50;
				day++;
			}
		}

		System.out.println();
		System.out.println("20 days loss is $"+twentyDayloss);
		System.out.println("20 days wins is $"+twentyDayWin);
		if(twentyDayloss > twentyDayWin)//to calculate 20 days loss
		{
			twentyDayloss = twentyDayloss-twentyDayWin;
			System.out.println();
			System.out.println("overall loss in 20 days  is $"+twentyDayloss);
		}

		else {//to calculate 20 days win
			twentyDayWin = twentyDayWin-twentyDayloss;
			System.out.println();
			System.out.println("overall profit in a 20 days  is $"+twentyDayWin);
		}
	}

	public static void main(String[] args)
	{
		WelcomeMessage();
		getTwentyDaysReport();

	}
}

