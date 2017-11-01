package com.bridgelabz.programs;

import java.util.Scanner;

import com.bridgelabz.utility.Utility;

public class DeckOfCards {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		Utility utility=new Utility();
		
		String suits[]={"clubs","Diamonds","Hearts","spades"};
		String ranks[]={"2","3","4","5","6","7","8","9","10",
				"Jack","King","Queen","Ace"};
		
		utility.deckOfCards(suits,ranks);
		
	}

}
