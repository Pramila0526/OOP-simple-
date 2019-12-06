package com.bridgelabz.deckofcards;

import java.util.Arrays;

import com.bridgelabz.utility.Utility;

/**
 * @author Pramila0526
 *
 */

public class DeckOfCardsUsingLinkedQueue
{

	static String rank[] = { "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace" };

	static String cards[] = { "Clubs", "Diamonds", "Hearts", "Spades" };

	static int n1 = cards.length;
	static int n2 = rank.length;

	static int size = n1 * n2;

	static String deck[] = new String[size];

	static int p = 0;

	static String[][] deckIn2D = new String[n1][n2];
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
			//LinkedQueue.insert(deck[i]+ "-->");
			System.out.println(" " +deck[i]);
			
			System.out.println("--------------------|");
		}
		//LinkedQueue.display();
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
	
	
	
	
	public void distributingOfCards(int n1,int n2)
	{
		try{
			
            for(int i=0;i<n1;i++)
		
		   {
			System.out.println();
			System.out.println("====Cards of Player" +(i+1)+ "====");
			System.out.println();
			for(int j=0;j<n2;j++)
			
			{
				//deckIn2D[i][j]=deck[i+j*4];
			
			System.out.println(" "+deck[i+j*n1]);
			System.out.println("--------------------|");
			}
			
			
			System.out.println();
		}
			
			//LinkedQueue.display1();
	}
	catch(ArrayIndexOutOfBoundsException e)   
		{
		System.out.println("Exception Occurs" +e);
		}
	}
	
	/*public static void sortTheCards(int n1)
	{
		int player[]=new int[n1];
		for(int i=0;i<4;i++)
		{
			player[i]=0;
			for(int j=0;j<10;j++)
			{
				for(int k=0;k<10-i;k++)
				{
					
				}
			}
		}
	}*/
	
	
	public void sorting()
	{
		String[] sortedCards = new String[9];
		char[] last1 = new char[2];
		char[] last2 = new char[2];
		
		String temp1, temp2, temp3, temp4;
		for (int i = 0; i < 4; i++) 
		{
			for (int j = 0; j < 9; j++) 
			{
				sortedCards[j] = deck[i+j*4];
				

			}
    //			System.out.println(Arrays.toString(arr));
//			System.out.println();
			for (int k= 0; k < sortedCards.length - 1; k++) {
				for (int j = 0; j < sortedCards.length - i - 1; j++) {
					temp1 = sortedCards[j];
					temp2 = sortedCards[j + 1];

					last1[0] = temp1.charAt(temp1.length() - 2);
					last1[1] = temp1.charAt(temp1.length() - 1);
					last2[0] = temp2.charAt(temp2.length() - 2);
					last2[1] = temp2.charAt(temp2.length() - 1);
					
					if (Arrays.compare(last1, last2) > 0) {
						temp3 = sortedCards[j];
						sortedCards[j] = sortedCards[j + 1];
						sortedCards[j + 1] = temp3;

					}

				}	}
			LinkedQueue.insert("For Player " + (i+1)+ " : \n");
			for (int j = 0; j < 9; j++) 
			{
				temp4 = sortedCards[j];//.substring(0, sortedCards[j].length());
				//System.out.print(temp4+"-->");
				LinkedQueue.insert(temp4 + "-->");
			}
			 //System.out.println();
			LinkedQueue.insert("\n");
		}
		// printing the queue
		LinkedQueue.display();

	}


	
 
	public static void main(String[] args) {

		DeckOfCardsUsingLinkedQueue doc = new DeckOfCardsUsingLinkedQueue();

		 doc.cardsCombinations();
		 doc.shufflingOfCards();
		 
		 System.out.println();
		 
		 System.out.println("Enter the number of Players");
		 int noOfPlayers=Utility.integerInput();
		 
		 System.out.println("Enter the number cards for each player");
		 int noOfCards=Utility.integerInput();
		 
		 doc.distributingOfCards(noOfPlayers, noOfCards);
		 
		 doc.sorting();
	}
}