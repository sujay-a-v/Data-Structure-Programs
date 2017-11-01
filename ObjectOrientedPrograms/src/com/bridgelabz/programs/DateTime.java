package com.bridgelabz.programs;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.Stack;

import com.bridgelabz.utility.Utility;

public class DateTime {

    public static void main(String []args){

    	Utility utility=new Utility();
    	
        Scanner scan=new Scanner(System.in);
        Stack ll=new Stack();
        int value=0;
        while(value!=5)
        {
        System.out.println("enter 1 to add .");
        System.out.println("enter 2 to remove .");
        System.out.println("enter 3 to transactionsdone .");
        System.out.println("enter 4 to check present stacks");
        System.out.println("enter 5 to exit .");
        value=scan.nextInt();
        if(value==1)
        {
            ll=utility.add(ll);
        }
        else if(value==2)
        {
            ll=utility.remove(ll);
        }
        else if(value==3)
        {
            System.out.println("stocks added till now");
            System.out.println(utility.added);
            System.out.println("stocks removed till now");
            System.out.println(utility.removed);
        }
        else if(value==4)
        {
            System.out.println(ll);
        }
        else if(value==5)
        {
            System.out.println(" bye ");
            System.exit(0);
        }
        else
        {
            System.out.println("enter a valid input .");
        }
        }
    }
}
