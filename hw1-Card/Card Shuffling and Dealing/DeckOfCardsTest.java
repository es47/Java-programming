public class DeckOfCardsTest
{
	public static void main(String[] args)
	{
		Card[] player1 = new Card[5];
		Card[] player2 = new Card[5];
		int[] table1 = new int[13];
		int[] table2 = new int[13];
		String[] faces = {"Deuce", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King", "Ace"};
		String[] suits = {"Diamonds", "Clubs", "Hearts", "Spades"};
		int type1, type2, suit1, suit2, same_point, same_face, face1 = 0, face2 = 0, single1 = 0, single2 = 0, x;
		DeckOfCards myDeckOfCards = new DeckOfCards();
		myDeckOfCards.shuffle();
		
		for (int i = 0; i < 5; i++)
		{
			player1[i] = myDeckOfCards.dealCard();
			player2[i] = myDeckOfCards.dealCard();
		}
		
		System.out.println("player1's card :");
		type1 = myDeckOfCards.handContain(player1);
		System.out.println(type1);
		System.out.println();
		System.out.println("player2's card :");
		type2 = myDeckOfCards.handContain(player2);
		System.out.println(type2);
		
		for (int i = 0; i < 13; i++)
		{
			table1[i] = 0;
			table2[i] = 0;
		}
		
		for (int i = 0; i < 5; i++)
		{
			for (int j = 0; j < 13; j++)
			{
				if (player1[i].getFace() == faces[j])
					table1[j]++;
				if (player2[i].getFace() == faces[j])
					table2[j]++;
			}
		}
		
		if (type1 != type2)
		{
			if (type1 > type2)
				System.out.println("player1 win!!!");
			else
				System.out.println("player2 win!!!");
		}
		else
		{
			if (type1 == 1)			//high card
			{
				same_point = 0;
				same_face = 0;
				for (int i = 12; i >= 0; i--)
				{
					if (table1[i] == 1 && table2[i] == 1)
					{
						if (same_point == 0)
							same_face = i;
						same_point = 1;
					}
					else if (table1[i] == 1 && table2[i] != 1)
					{
						System.out.println("player1 win!!!");
						same_point = 0;
						break;
					}
					else if (table1[i] != 1 && table2[i] == 1)
					{
						System.out.println("player2 win!!!");
						same_point = 0;
						break;
					}
				}
				
				if (same_point == 1)
				{
					for (int i = 0; i < 5; i++)
					{
						if (player1[i].getFace() == faces[same_face])
							face1 = i;
						if (player2[i].getFace() == faces[same_face])
							face2 = i;
					}
					for (int i = 3; i >= 1; i--)
					{
						if (player1[face1].getSuit() == suits[i])
						{
							System.out.println("player1 win!!!");
							break;
						}
						if (player2[face2].getSuit() == suits[i])
						{
							System.out.println("player2 win!!!");
							break;
						}
					}
				}
			}
			else if (type1 == 2 || type1 == 3)		//one pair, two pairs
			{
				same_point = 0;
				same_face = 0;
				for (int i = 12; i >= 0; i--)
				{
					if (table1[i] == 2 && table2[i] == 2)
					{
						if (same_point == 0)
							same_face = i;
						same_point = 1;
					}
					else if (table1[i] == 2 && table2[i] != 2)
					{
						System.out.println("player1 win!!!");
						same_point = 0;
						break;
					}
					else if (table1[i] != 2 && table2[i] == 2)
					{
						System.out.println("player2 win!!!");
						same_point = 0;
						break;
					}
				}
				
				if (same_point == 1)
				{
					for (int i = 12; i >= 0; i--)
					{
						if (table1[i] == 1 && table2[i] != 1)
						{
							System.out.println("player1 win!!!");
							same_point = 0;
							break;
						}
						else if (table1[i] != 1 && table2[i] == 1)
						{
							System.out.println("player2 win!!!");
							same_point = 0;
							break;
						}
					}
					
					if (same_point == 1)
					{
						for (int i = 0; i < 5; i++)
						{
							if (player1[i].getFace() == faces[same_face])
							{
								if (player1[i].getSuit() == suits[3])
								{
									System.out.println("player1 win!!!");
									break;
								}
							}
							if (player2[i].getFace() == faces[same_face])
							{
								if (player2[i].getSuit() == suits[3])
								{
									System.out.println("player2 win!!!");
									break;
								}
							}
						}
					}
				}
			}
			else if (type1 == 4 || type1 == 7 || type1 == 8)		//three of a kind, a full house, four of a kind
			{
				if (type1 == 8)
					x = 4;
				else
					x = 3;
				for (int i = 12; i >= 0; i--)
				{
					if (table1[i] == x)
					{
						System.out.println("player1 win!!!");
						break;
					}
					if (table2[i] == x)
					{
						System.out.println("player2 win!!!");
						break;
					}
				}
			}
			else if (type1 == 5)		//a straight
			{
				same_point = 0;
				same_face = 0;
				for (int i = 11; i >= 0; i--)
				{
					if (table1[i] == 1 && table2[i] == 1)
					{
						same_face = i;
						same_point = 1;
						break;
					}
					else if (table1[i] == 1 && table2[i] != 1)
					{
						System.out.println("player1 win!!!");
						break;
					}
					else if (table1[i] != 1 && table2[i] == 1)
					{
						System.out.println("player2 win!!!");
						break;
					}
				}
				
				if (same_point == 1)
				{
					if (table1[12] == 1 && table1[11] == 1)
						same_face = 12;
					
					for (int i = 0; i < 5; i++)
					{
						if (player1[i].getFace() == faces[same_face])
							face1 = i;
						if (player2[i].getFace() == faces[same_face])
							face2 = i;
					}
					for (int i = 3; i >= 1; i--)
					{
						if (player1[face1].getSuit() == suits[i])
						{
							System.out.println("player1 win!!!");
							break;
						}
						if (player2[face2].getSuit() == suits[i])
						{
							System.out.println("player2 win!!!");
							break;
						}
					}
				}
			}
			else if (type1 == 6)		//a flush
			{
				same_point = 1;
				for (int i = 12; i >= 0; i--)
				{
					if (table1[i] == 1 && table2[i] != 1)
					{
						System.out.println("player1 win!!!");
						same_point = 0;
						break;
					}
					else if (table1[i] != 1 && table2[i] == 1)
					{
						System.out.println("player2 win!!!");
						same_point = 0;
						break;
					}
				}
				
				if (same_point == 1)
				{
					for (int i = 3; i >= 1; i--)
					{
						if (player1[0].getSuit() == suits[i])
						{
							System.out.println("player1 win!!!");
							break;
						}
						if (player2[0].getSuit() == suits[i])
						{
							System.out.println("player2 win!!!");
							break;
						}
					}
				}
			}
		}
	}
}