import java.util.Random;

public class GambleSimulation 
{
	static int initialAmount = 100;
	static int betPlaced = 1;
	static int stopOfDayLoss=50;
	static int stopOfDayWin=150;

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

	public static void resignOfTheDay()
	{

		while(initialAmount > 50 && initialAmount < 150)
		{
			int random=generateRandomNo();

			if(random == 0)
				initialAmount--;

			else
				initialAmount++;
		}
		if(initialAmount == stopOfDayLoss)
			System.out.println("He LOST for a day----> $"+initialAmount);

		else
			System.out.println("He WON for the day----> $"+(initialAmount-100));
	}

	public static void main(String[] args)
	{
		WelcomeMessage();
		resignOfTheDay();

	}
}

