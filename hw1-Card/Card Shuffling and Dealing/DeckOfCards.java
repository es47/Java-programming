import java.security.SecureRandom;

public class DeckOfCards
{
	private Card[] deck;
	private int currentCard;
	private static final int NUMBER_OF_CARDS = 52;
	
	private static final SecureRandom randomNumbers = new SecureRandom();
	
	public DeckOfCards()
	{
		String[] faces = {"Ace", "Deuce", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King"};
		String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
		
		deck = new Card[NUMBER_OF_CARDS];
		currentCard = 0;
		
		for (int count = 0; count < deck.length; count++)
			deck[count] = new Card(faces[count % 13], suits[count / 13]);
	}
	
	public void shuffle()
	{
		currentCard = 0;
		
		for (int first = 0; first < deck.length; first++)
		{
			int second = randomNumbers.nextInt(NUMBER_OF_CARDS);
			
			Card temp = deck[first];
			deck[first] = deck[second];
			deck[second] = temp;
		}

	}
	
	public Card dealCard()
	{
		if (currentCard < deck.length)
			return deck[currentCard++];
		else
			return null;
	}
	
	public int handContain(Card fiveCard[])
	{
		int[] table = new int[13];
		int[] number = new int[4];
		String[] faces = {"Ace", "Deuce", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King"};
		int flush_flag = 1, consecutive_flag = 0, combine;
		
		for (int i = 0; i < 13; i++)
			table[i] = 0;
		
		for (int i = 0; i < 4; i++)
			number[i] = 0;
		
		for (int i = 0; i < 5; i++)
		{
			System.out.printf("%-19s  ",fiveCard[i]);
			for (int j = 0; j < 13; j++)
			{
				if (fiveCard[i].getFace() == faces[j])
					table[j]++;
			}
			
			if (i < 4 && flush_flag == 1)
			{
				if (fiveCard[i].getSuit() != fiveCard[i + 1].getSuit())
					flush_flag = 0;
			}
		}
		System.out.println();
		
		for (int i = 0; i < 13; i++)
		{
			for (int j = 1; j <= 4; j++)
			{
				if (table[i] == j)
					number[j - 1]++;
			}
			
			if (table[i] == 1 && i < 12 && consecutive_flag < 5)
			{
				if (consecutive_flag == 0)
					consecutive_flag = 1;
				if (table[i + 1] == 1)
					consecutive_flag++;
				else
					consecutive_flag = 1;
			}
			else if (table[i] == 0 && consecutive_flag < 5)
				consecutive_flag = 0;
		}
		
		if (table[0] == 1 && table[12] == 1)
		{
			if(table[11] == 1 && table[10] == 1)
				if (table[9] == 1)
					consecutive_flag = 5;
		}
		
		if (number[1] == 1 && number[0] == 3)
		{
			System.out.println("Card type : one pair");
			combine = 2;
			return combine;
		}
		else if (number[1] == 2 && number[0] == 1)
		{
			System.out.println("Card type : two pairs");
			combine = 3;
			return combine;
		}
		else if (number[2] == 1 && number[0] == 2)
		{
			System.out.println("Card type : three of a kind");
			combine = 4;
			return combine;
		}
		else if (number[2] == 1 && number[1] == 1)
		{
			System.out.println("Card type : a full house");
			combine = 7;
			return combine;
		}
		else if (number[3] == 1 && number[0] == 1)
		{
			System.out.println("Card type : four of a kind");
			combine = 8;
			return combine;
		}
		else
		{
			if (flush_flag == 1)
			{
				System.out.println("Card type : a flush");
				combine = 6;
				return combine;
			}
			else if (consecutive_flag == 5)
			{
				System.out.println("Card type : a straight");
				combine = 5;
				return combine;
			}
			else
			{
				System.out.println("Card type : high card");
				combine = 1;
				return combine;
			}
		}
	}
}
	