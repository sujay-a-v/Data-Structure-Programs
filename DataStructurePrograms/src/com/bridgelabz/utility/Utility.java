package com.bridgelabz.utility;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;



public class Utility {
	Scanner scan=new Scanner(System.in);

	public void unOrdered_List() throws IOException {
		String string1,string2="";
        String path="//home//bridgeit//Documents//Sujay//ioprm//file.txt";
        
        LinkedList list=new LinkedList();
        
		try
		{
			FileReader fr=new FileReader(path);
			BufferedReader br=new BufferedReader(fr);
			while((string2=br.readLine())!=null)
			{
				System.out.println(string2);
				
				StringTokenizer str=new StringTokenizer(string2," ");
				while(str.hasMoreTokens())
				{
					String token=str.nextToken();
					list.add(token);
				}
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("enter the word tobe search");
		string1=scan.nextLine();
		
		int i,position=-1;
		for(i=0; i<list.size(); i++)
		{
			if(list.get(i).equals(string1))
			{
				position=i;
				break;
			}
			
		}
		
		if(position==-1)
		{
			System.out.println("\n word not found ");
			list.add(string1);
			System.out.println("new list is ");
			System.out.println(list);
		}
		else
		{
			System.out.println("\n word found at "+position);
			list.remove(position);
			System.out.println("new list is ");
			
			System.out.println(list);
		}
		
		//System.out.println("\n"+arr.size());
		String temp="";
		for(i=0; i<list.size(); i++)
		{
			temp=temp+list.get(i)+" ";
		}
		
		BufferedWriter bw=null;
		FileWriter fw=null;
		try
		{
			fw=new FileWriter(path);
			bw=new BufferedWriter(fw);
			bw.write(temp);
			bw.flush();
			System.out.println("\n Done");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			bw.close();
			fw.close();
		}
		
	}
	
	/**
	 * @param list
	 * @return
	 */
	public LinkedList ordered_list_sort(LinkedList list)
	{
		String array[]=new String[list.size()];
		for(int i=0; i<array.length; i++)
		{
			array[i]=(String) list.get(i);
		}
		
		for(int i=0; i<array.length; i++)
		{
			for(int j=0; j<array.length; j++)
			{
				if(array[j].compareToIgnoreCase(array[i])>0)
				{
					String t1=array[j];
					array[j]=array[i];
					array[i]=t1;
				}
			}
		}
		list.clear();
		for(int i=0; i<array.length; i++)
		{
			//System.out.print(array[i]+" ");
			list.add(array[i]);
		}
		System.out.println("\nAfter sorting ");
		System.out.println(list);
		
		System.out.println("enter the element to be search ");
		String key=scan.next();
		
		for(int i=0; i<array.length; i++)
		{
			if(key.compareToIgnoreCase(array[i])==0)
			{
				System.out.println("number is found");
				list.remove(i);
				break;
			}
			if(key.compareToIgnoreCase(array[i])>0)
			{
				continue;
			}
			else
			{
				list.add(i, key);
				break;
			}
		}
		
		return list;
	}
	
	
	public boolean balanced_Parentheses(String expression)throws Exception
	{
		Stack sk=new Stack();
		
		for(int i=0; i<expression.length(); i++)
		{
			char c=expression.charAt(i);
			if(c=='(')
			{
				sk.push(c);
			}
			if(c==')')
			{
				if(sk.size()==0)
				{
					return false;
				}
				sk.pop();
			}
		}
		if(sk.size()==0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	public void cash_Counter(int people) {
		Queue<String> q=new LinkedList<String>();
		int accnum,bal;
		String name;
		for(int i=0; i<people; i++)
		{
			System.out.println("enter the name");
			name=scan.next();
			q.add(name);
			System.out.println("enter the Account num");
			accnum=scan.nextInt();
			q.add(Integer.toString(accnum));
			System.out.println("enter the Balance");
			bal=scan.nextInt();
			q.add(Integer.toString(bal));
		}
		
		while(q.size()>0)
		{
			System.out.println(q.peek()+ " Your turn\n" );
			
			StateBank sb=new StateBank(q.poll(),Integer.parseInt(q.poll()),Integer.parseInt(q.poll()));
			sb.bankActivity();
		}
		
		
	}

	

	public boolean deque_Palindrome(String string) {
		int n=string.length();
		string=string.toLowerCase();
		
		Deque dq=new LinkedList<String>();
		for(int i=0; i<n; i++)
		{
			char c=string.charAt(i);
			dq.addFirst(c);
		}
		
		int size=dq.size();
		int i=0,j=size-1;;
		while(size>0)
		{
			
			Object first=dq.getFirst();
			Object last=dq.getLast();
			
			if(first==last)
			{
				//dq.pollFirst();
				//dq.pollLast();
				dq.remove(i);
				dq.remove(j);
			}
			else
			{
				//System.out.println("false");
				return false;
				//System.exit(0);
			}
			i++;
			j--;
			size--;
		}
		//System.out.println("true");
		return true;
	}

	public void hashing_Function() throws NumberFormatException, IOException {
		HashMap<Integer,LinkedList> hm=new HashMap<Integer,LinkedList>();
		int ht[]=new int[11];
		char c;
		
		String path3="//home//bridgeit//Documents//Sujay//ioprm//file3.txt";
		
		LinkedList<Integer> arr=new LinkedList<Integer>();
		String string;
		int values,n=0;
		int [] intValue=new int[100];
        
		try
		{
			String string1="";
			FileReader fr=new FileReader(path3);
			BufferedReader br=new BufferedReader(fr);
			while((string=br.readLine())!=null)
			{
				String [] str =string.split(" ");
				for(int i=0;i < str.length;i++){
					intValue[i]=Integer.parseInt(str[i]);
				n++;
				
				}
			}
			for(int j=0; j<n; j++)
			{
				System.out.print(intValue[j]+" ");
			}
			
			for(int j=0; j<=10; j++)
			{
				LinkedList<Integer> ls=new LinkedList<Integer>();
				hm.put(j, ls);
			}
			
			for(int j=0; j<n; j++)
			{
				int x=intValue[j]%11;
				arr=hm.get(x);
				arr.add(intValue[j]);
			}
			
			System.out.println("\n"+hm);
			System.out.println("enter the value to be search");
			int key=scan.nextInt();
			int x=key%11;
			arr=hm.get(x);
            if(arr.contains(key)==true)
            {
            System.out.println("key found and removed");
            int index=arr.indexOf(key);
            arr.remove(index);
            System.out.println(arr);
            }
            else
            {
                System.out.println("key not found");
                arr.add(key);
                System.out.println(hm.get(x));
            }
			
		}
		finally
		{
			System.out.println("\n"+hm);
		}
		
	}

	/**
	 * @param n
	 * @return
	 */
	public static int numTree(int n)
	{
		int trees[]=new int[n+1];
		for(int i=0; i<=n; i++)
		{
			trees[i]=-1;
		}
		int ans=computeBST(n,trees);
		return ans;
	}
	public static int computeBST(int n, int[] trees)
	{
		if(n<0)
		{
			return 0;
		}
		else if(n==1 || n==0)
		{
			return 1;
		}
		else
		{
			int totalTrees=0;
			for(int i=1; i<=n; i++)
			{
				if(trees[i-1]==-1)
				{
					trees[i-1]=computeBST(i-1,trees);
				}
				if(trees[n-i]==-1)
				{
					trees[n-i]=computeBST(n-i,trees);
				}
				totalTrees+=trees[i-1]*trees[n-i];
			}
			return totalTrees;
		}
	}

	public void calendar(int month, int year, int date) {
		
int count,end=0;
		
		int y1=year-(14-month)/12;
		int x=y1+(y1/4)-(y1/100)+(y1/400);
		int m1=month+12*((14-month)/12)-2;
		int d0=(date+x+(31*m1)/12)%7;
		int start=d0;
		
		int lastDate=0;
		if(month==1||month==3 || month==5 || month==7 || month==8 || month==10 || month==12)
		{
			lastDate=31;
		}
		if(month==4 || month==6 || month==9 || month==11)
		{
			lastDate=30;
		}
		if(month==2)
		{
			if(year%4==0)
			{
				lastDate=29;
			}
			else
			{
				lastDate=28;
			}
		}
		
		//Display month and year
		String mon[]={"JAN","FEB","MAR","APR","MAY","JUN","JLY","AUG","SEP","OCT","NOV","DEC"};
		System.out.println("\n          "+mon[month-1]+" "+year+"\n");
		//Display days
		String[] day={"S","M","T","w","TH","F","S"};
		for(int i=0; i<7; i++)
		{
			System.out.print(" "+day[i]+" ");
		}
		
		System.out.println();
		int t=0;
		for(int i=0; i<5; i++)
		{
			if(t==0)
			{
				for(int j=0; j<start; j++)
				{
					System.out.print("   ");
					end++;
				}
				t=1;
			}
			for(int k=end; k<7; k++)
			{
				if(date<10){
					System.out.print("  "+date);
				}
				else
				{
					System.out.print(" "+date);
				}
				if(date==lastDate)
				{
					System.exit(0);
				}
				date++;
				
			}
			end=0;
			System.out.println();
		}

	}

	public void daysOfWeek(int m, int y, int d) {
		
		int y1=y-(14-m)/12;
        int x=y1+(y1/4)-(y1/100)+(y1/400);
        int m1=m+12*((14-m)/12)-2;
        int d1=(d+x+(31*m1)/12)%7;
        int start=d1;
        
        int count=1,lastdate=0;
		int arr[][]=new int[6][7];
		String mnt[]={"JAN","FEB","MAR","APR","MAY","JUN","JLY","AUG","SEP","OCT","NOV","DEC"};
		System.out.println();
		System.out.println(mnt[m-1]+"    "+y);
		days();
		System.out.println();
		
		if(m==1||m==3||m==5||m==7||m==8||m==10||m==12)
		{
			lastdate=31;
		}
		if(m==4||m==6||m==9||m==11)
		{
			lastdate=30;
		}
		if(m==2)
		{
			if(y%4==0)
			{
				lastdate=29;
			}
			else
			{
				lastdate=28;
			}
		}
		
		int start1=start;
		for(int i=0;i<=5;i++)
        {
            for(int j=0;j<7;j++)
            {
                if(start>0)
                {
                    arr[i][j]=0;
                    start-=1;
                }
                else
                {
                    if(count<=lastdate)
                    {
                        arr[i][j]=count;
                        count++;
                    }
                    else
                    {
                        arr[i][j]=0;
                    }
                }
            }
        }
        int c=start1+9;
        display(arr,c);    		
	}
	
	public static void days()
	{
		Queue<Character> q=new LinkedList<Character>();
		q.add('S');
		q.add('M');
		q.add('T');
		q.add('W');
		q.add('T');
		q.add('F');
		q.add('S');
		
		while(q.size()>0)
		{
			System.out.print(" "+q.poll()+"  ");
		}
	}
	
	 static void display(int arr[][],int c)
     {
         int count=0,b=c-9;
         System.out.println(" ");
         for(int i=0;i<=5;i++)
         {
             for(int j=0;j<=6;j++)
             {
                 if(count<c)
                 {
                     if(count<b)
                     {
                         System.out.print("    ");
                         count++;
                     }
                     else
                     {
                     System.out.print(" 0"+arr[i][j]+" ");
                     count++;
                     }
                 }
	             else
	             {
	                 if(arr[i][j]==0)
	                 {
	                     System.out.print("    ");
	                 }
		             else
		             {
		                 System.out.print(" "+arr[i][j]+" ");
		             }
	             }
		     }
		     System.out.println(" ");    
		 }
	}

	public void primeNumber() {
int a[][]=new int[10][];
		
		int start=1,end=100;
		
		for(int i=0; i<10; i++)
		{
			int size=0;
			for(int j=start; j<end; j++)
			{
				
				boolean flag=true;
				for(int k=2; k<j; k++)
				{
					if(j%k==0)
					{
						flag=false;
						break;
					}
					
				}
				if(flag==true)
				{
					size++;
				}
				
			}
			a[i]=new int[size];
			
			int j=0;
			
			for(int p=start; p<end; p++)
			{
				boolean b=true;
				for(int q=2; q<p; q++)
				{
					if(p%q==0)
					{
						b=false;
						break;
					}
				}
				if(b==true)
				{
					a[i][j]=p;
					
					System.out.print(a[i][j]+" ");
					
					j++;
				}
			}
			System.out.println();
			
			start=end;
			end=end+100;
			
		}

		
	}

}




class StateBank
{
	public String name;
	static private  int AccNum;
	static private int Balance;
	static public int BankBalance=10000;
	
	static Scanner scan=new Scanner(System.in);
	
	StateBank(String name, int AccNum, int Balance )
	{
		this.name=name;
		this.AccNum=AccNum;
		this.Balance=Balance;
	}
	
	void bankActivity()
	{
		int amount,ch=1;
		
		while(ch!=4)
		{
			System.out.println("1. Deposit");
			System.out.println("2. Cash withDraw");
			System.out.println("3. Check Balance");
			System.out.println("4. Exit");
			
			System.out.println("enter your choice");
			ch=scan.nextInt();
			
			switch(ch)
			{
				case 1: deposit();
				break;
				case 2: withdraw();
				break;
				case 3: balance();
				break;
				case 4: System.out.println("thank you for banking");;
				break;
				default: System.out.println("Invalid input, Enter the correct input");
			
			}
		}
		
	}
	
	public static void deposit()
	{
		System.out.println("enter the deposit amount");
		int amount=scan.nextInt();
		Balance+=amount;
		BankBalance+=amount;
		System.out.println("Amount "+amount+" added to the AccNum "+AccNum+" balance is "+Balance);
	}
	
	public static void withdraw()
	{
		System.out.println("enter the amount to draw");
		int draw=scan.nextInt();
		if(Balance>draw)
		{
			Balance-=draw;
			BankBalance-=draw;
			if(BankBalance<=0)
			{
				System.out.println("insuficient balance in Bank");
				System.exit(0);
			}
			
			System.out.println("Amount "+draw+" is draw from acnum "+AccNum+" amount left "+Balance);
		}
		else
		{
			System.out.println("in-sufficient balance in your account");
		}
	}
	
	public static void balance()
	{
		System.out.println("your balance is "+Balance);
	}
	
	
}
