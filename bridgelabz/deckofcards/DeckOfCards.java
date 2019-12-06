package com.bridgelabz.deckofcards;

import com.bridgelabz.utility.Utility;

public class DeckOfCards implements Comparable<DeckOfCards> {

	static String rank[] = { "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace" };

	static String cards[] = { "Clubs", "Diamonds", "Hearts", "Spades" };

	static int n1 = cards.length;
	static int n2 = rank.length;

	static int size = n1 * n2;

	static String deck[] = new String[size];

	static int p = 0;

	//Printing all Cards with its all combinations 
	
	public void cardsCombinations() {
		for (int i = 0; i < n1; i++) {

			for (int j = 0; j < n2; j++) {

				deck[p] = cards[i] + " of " + rank[j];
				p++;
			}

		}
		System.out.println("======All Cards======");
		for (int i = 0; i < size; i++) {
			
			System.out.println(" " + deck[i]);
			
			System.out.println("--------------------|");
		}
		System.out.println("Total cards are:- " +p);

	}

	//Code for shuffling the cards
	
	public void shufflingOfCards() {

		for (int i = 0; i < size; i++) {
			int shuffle = (int)  (Math.random() * size);
			String temp = deck[shuffle];
			deck[shuffle] = deck[i];
			deck[i] = temp;
		}
		System.out.println();
		System.out.println("===After Shuffling of Cards===");
		System.out.println();
		for (int i = 0; i < size; i++) 
		{
			
			System.out.println(" "+deck[i]);
			System.out.println("--------------------|");
		}
	}
	
	
	//code for distributing the cards to playes
	
	public void distributingOfCards(int n1,int n2)
	{
		try{
			String deckIn2D[][] = new String[n1][n2];

          
			for(int i=0;i<n1;i++)
		
		   {
			System.out.println();
			System.out.println("====Cards of Player" +(i+1)+ "====");
			System.out.println();
			for(int j=0;j<n2;j++)
			
			{
				deckIn2D[i][j]=deck[i+j*4];
				
				System.out.println(" "+deck[i+j*4]);
				System.out.println("--------------------|");
			}
			
			System.out.println();
		}
			
	}
	catch(ArrayIndexOutOfBoundsException e)   
		{
		System.out.println("Exception Occurs" +e);
		}
	}
	
	
 
	public static void main(String[] args) {

		DeckOfCards doc = new DeckOfCards();

		 doc.cardsCombinations();
		 doc.shufflingOfCards();
		 
		 System.out.println();
		 System.out.println("Enter the number of Players");
		 int noOfPlayers=Utility.integerInput();
		 
		 System.out.println("Enter the number cards for each player");
		 int noOfCards=Utility.integerInput();
		 
		 doc.distributingOfCards(noOfPlayers, noOfCards);
		 
		 
	}

	@Override
	public int compareTo(DeckOfCards arg0) {
		// TODO Auto-generated method stub
		return 0;
	}
}