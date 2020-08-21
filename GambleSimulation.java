import java.util.Random;
public class GambleSimulation 
{
	static int initialAmount = 100;
	static int betPlaced = 1;
	static int stopOfDayLoss = 50;
	static int stopOfDayWin = 150;
	static int monthLoss = 0;
	static int monthWin = 0;
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

	public static void getMonthReport()
	{
		while(day < 30)
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
				System.out.println("He LOST for a day "+(day+1)+" is $"+initialAmount);
				monthLoss = monthLoss+50;
				day++;

			}
			else {
				System.out.println("He WON for day "+(day+1)+" is $"+initialAmount);
				monthWin = monthWin+50;
				day++;
			}
		}

		System.out.println();
		System.out.println("month loss is $"+monthLoss);
		System.out.println("month wins is $"+monthWin);
		if(monthLoss > monthWin)//to calculate 30 days loss
		{
			monthLoss = monthLoss-monthWin;
			System.out.println();
			System.out.println("overall loss in a month  is $"+monthLoss);
		}

		else {//to calculate 30 days win
			monthWin = monthWin-monthLoss;
			System.out.println();
			System.out.println("overall profit in a month  is $"+monthWin);
		}
	}

	public static void main(String[] args)
	{
		WelcomeMessage();
		getMonthReport();

	}
}

