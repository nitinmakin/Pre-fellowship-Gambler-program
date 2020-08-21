import java.util.Arrays;
import java.util.Random;
public class GambleSimulation
{
	static int initialAmount = 100;
	static int betPlaced = 1;
	static int stopOfDayLoss = 50;
	static int stopOfDayWin = 150;
	static int monthLoss = 0;
	static int monthWin = 0;
	static int day = 1;
	static int luckyDay = 0;
	static int unluckyDay = 0;
	static int luckyUnluckyDayAmount = 0;

	public static void WelcomeMessage()

	{
		System.out.println("GAMBLER IS STARTING BET FROM $100 EVERY DAY");
		System.out.println("HE IS PUTTING $1 IN EVERY BET SO HE WIN OR LOSS $1 IN EVERY BET");
		System.out.println("------------------------------");
	}

	public static int generateRandomNo()
	{
		Random random=new Random();
		return random.nextInt(2);
	}

	public static void getMonthReport()
	{
		int arr[]=new int[30];
		while(day <= 30)
		{

			initialAmount = 100;
			while(initialAmount > 50 && initialAmount < 150)//per day report start
			{
				int random = generateRandomNo();

				if(random == 0) 
				{
					initialAmount--;
				}
				else
				{
					initialAmount++;
				}
			}//per day report end
			if(initialAmount == stopOfDayLoss)
			{
				System.out.println("day "+day+" He LOST--->$"+50);
				monthLoss = monthLoss+50;
				luckyUnluckyDayAmount = luckyUnluckyDayAmount-50;
				arr[day-1] = luckyUnluckyDayAmount;
			}
			else 
			{
				System.out.println("day "+day+" He WON---->$"+50);
				monthWin = monthWin+50;
				luckyUnluckyDayAmount = luckyUnluckyDayAmount+50;
				arr[day-1] = luckyUnluckyDayAmount;
			}
			day++;
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


		System.out.println();

		//System.out.println(Arrays.toString(arr));
		getLuckyUnluckyDay(arr);

	}

	public static void getLuckyUnluckyDay(int arr[])
	{


		int high = arr[0];
		int low = arr[0];
		for (int i = 0; i < arr.length; i++) 
		{
			if(high < arr[i])
			{
				high = arr[i];
				luckyDay = i+1;
			}
			if(low > arr[i])
			{
				low = arr[i];
				unluckyDay = i+1;
			}


		}
		System.out.println("lucky day was day "+luckyDay+" he was in $"+high);
		System.out.println("Unlucky day was day "+unluckyDay+" he was in $"+low);

	}


	public static void main(String[] args)
	{
		WelcomeMessage();
		getMonthReport();
	}
}






