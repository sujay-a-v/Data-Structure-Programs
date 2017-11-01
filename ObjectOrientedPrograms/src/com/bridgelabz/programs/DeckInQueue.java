package com.bridgelabz.programs;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class DeckInQueue {
	
	 
    Node head;
    class Node
    {
    	String card;
    	Node link;
    	
    	public Node(String c)
    	{
    		card=c;
    		link=null;
    	}
    }
    
    public void insert(String newCard)
    {
    	Node nd=new Node(newCard);
    	
    	if(head==null)
    	{
    		nd.link=head;
    		head=nd;
    	}
    	else
    	{
    		Node temp=head;
    		while(temp.link!=null)
    		{
    			temp=temp.link;
    		}
    		temp.link=nd;
    	}
    }
    
    
    public void disp()
    {
    	if(head==null)
    	{
    		System.out.println("Display not possible");
    	}
    	else if(head.link==null)
    	{
    		System.out.println(head.card);
    	}
    	else
    	{
	    	Node temp=head;
	    	while(temp!=null)
	    	{
	    		System.out.println(temp.card+", ");
	    		temp=temp.link;
	    	}
    	}
    }
    
    
	public void player(String deck[])
	{
		HashMap<Integer,Queue> hm=new HashMap<Integer,Queue>();
		Queue<Integer> q=new LinkedList<Integer>();
		
		for(int i=0; i<deck.length; i++)
		{
			for(int j=i+1; j<deck.length; j++)
			{
				if(deck[j].compareToIgnoreCase(deck[i])<0)
				{
					String temp=deck[i];
					deck[i]=deck[j];
					deck[j]=temp;
				}
			}
			insert(deck[i]);
		}
		//System.out.println(q);
		disp();
		
		for(int i=0; i<4; i++)
		{
			Queue<Integer> enque=new LinkedList<Integer>();
			hm.put(i, enque);
		}
		System.out.println("\n\n");
		System.out.println(q);

		}
	
	
	
	public static void main(String[] args) {
		
		DeckInQueue diq=new DeckInQueue();
		String suits[]={"clubs","Diamonds","Hearts","spades"};
		String ranks[]={"2","3","4","5","6","7","8","9","10",
				"Jack","King","Queen","Ace"};
		String Deck[]=new String[suits.length*ranks.length];
		int length=Deck.length;
		
		for(int i=0; i<ranks.length; i++)
		{
			for(int j=0; j<suits.length; j++)
			{
				Deck[4*i+j]=ranks[i]+" of "+suits[j];
			}
			
		}
		
		diq.player(Deck);

	}

}
