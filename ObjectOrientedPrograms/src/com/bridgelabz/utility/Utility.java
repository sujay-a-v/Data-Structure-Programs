package com.bridgelabz.utility;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;



public class Utility {

	public void inventory(String[] name)
	{
		Scanner scan=new Scanner(System.in);
		JSONObject obj=new JSONObject();
		for(int i=0; i<name.length; i++)
		{
			System.out.println("enter the types of "+name[i]);
			int count=scan.nextInt();
			JSONArray jarray=new JSONArray();
			for(int j=0; j<count; j++)
			{
				JSONObject jobj=new JSONObject();
				System.out.println("enter the name ");
				jobj.put("name", scan.next());
				System.out.println("enter the weight");
				jobj.put("weight", scan.nextInt());
				System.out.println("enter the price");
				jobj.put("price", scan.nextInt());
				jarray.add(jobj);
			}
			obj.put(name[i], jarray);
		}
		String path="//home//bridgeit//Documents//Sujay//ioprm//json.txt";
		
		PrintWriter pw=null;
		try
		{
			pw=new PrintWriter(path);
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		pw.write(obj.toJSONString());
		pw.close();
	}
	public static void readData()
	{
		String path="//home//bridgeit//Documents//Sujay//ioprm//json.txt";

		JSONArray arr=new JSONArray();
		JSONParser jpar=new JSONParser();
		JSONObject obj1;
		try
		{
			obj1=(JSONObject) jpar.parse(new FileReader(path));
			arr=(JSONArray) obj1.get("Rice");
			System.out.println("Rice inventory value is :" + getValue(arr));
			arr=(JSONArray) obj1.get("Wheat");
			System.out.println("Wheat inventory value is :" + getValue(arr));
			arr=(JSONArray) obj1.get("Pulses");
			System.out.println("Pulses inventory value is :" + getValue(arr));
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	
	public static long getValue(JSONArray a)
	{
		long value=0;
		Iterator itr=a.iterator();
		while(itr.hasNext())
		{
			JSONObject ob=(JSONObject)itr.next();
			long weight=(long)ob.get("weight");
			long price=(long)ob.get("price");
			value=value+(price*weight);
		}
		
		return value;
	}
	public void regular_Expression(String fname, String lname, String number) {
		String msg1="Hello <<name>>";
		String msg2="We have your full name as <<full name>> in our system.";
		String msg3="your contact number is 91-xxxxxxxxxx.";
		String msg4="Please,let us know in case of any clarification Thank you BridgeLabz ";
		
		msg1=change(msg1,fname);
		msg2=change(msg2,lname);
		if(number.matches("[0-9]{10}")==true)
	     {
			msg3=change(msg3,number);
		    //System.out.println(msg3);
	     }
	     else
	     {
	         System.out.println("the number is not in a correct format. ");
	     }
		
		SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
	    Date date = new Date();
	    
	    System.out.println("\n"+msg1+"  "+msg2+" "+msg3+" \n"+msg4+" "+sdf.format(date));
		
	}
	public String change(String str,String ptrn) {
        Pattern patt = Pattern.compile("<<name>>|<<full name>>|x{10}");
        Matcher m = patt.matcher(str);
        return m.replaceAll(ptrn);
      }
	
	
	/**
	 * @param name
	 * @param stock
	 * @param price
	 * @return
	 */
	public static int stoke(String name,int stock,int price)
	{
		int value;
		value=stock*price;
		System.out.println("the value of the "+name +" is "+value);
		return value;
	}
	
	
	
	
	static Scanner sc=new Scanner(System.in);
	static int n=0;
	Node head;
	class Node
	{
		int share;
		Node link;
		
		public Node(int s)
		{
			share=s;
			link=null;
		}
	}
	
	public int add()
	{
		System.out.println("enter the company share");
		int share=sc.nextInt();
		Node nd=new Node(share);
		
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
			n++;
		}
		
		return n;
	}
	
	public int remove(int pos)
	{
		Node temp=head;
		if(head==null)
		{
			System.out.println("Remove not possible");
		}
		else if(pos==0)
		{
			System.out.println("Removed share is :"+head.share);
			head=temp.link;
		}
		else
		{
			for(int i=0; i<pos-1; i++)
			{
				temp=temp.link;
			}
			
			System.out.println("Removed share is :"+temp.link.share);
			Node next=temp.link.link;
			temp.link=next;
			n--;
		}
		return n;
	}
	
	public void disp()
	{
		if(head==null)
		{
			System.out.println("Display not possible not possible");
		}
		else if(head.link==null)
		{
			System.out.println(head.share);
		}
		else
		{
			Node temp=head;
			while(temp!=null)
			{
				System.out.print(temp.share+" ");
				temp=temp.link;
			}
			temp=null;
		}
		System.out.println();
	}
	
	
	public Stack<String> added=new Stack<String>();
    public Stack<String> removed=new Stack<String>();
    Scanner scan=new Scanner(System.in);
    public Stack add (Stack ll){
        System.out.println("enter the name to add");
        String name=scan.nextLine();
        ll.add(name);
        added.add(name);
        SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy hh-mm-ss");
        Date date = new Date();
        added.push(sdf.format(date));
        //System.out.println(ll);
        return ll;
    }
    public Stack remove (Stack ll){
        System.out.println("enter the name to remove");
        String name=scan.nextLine();
        ll.remove(name);
        removed.add(name);
        SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy hh-mm-ss");
        Date date = new Date();
        removed.push(sdf.format(date));
        //System.out.println(ll);
        return ll;
    }
	public void deckOfCards(String[] suits, String[] ranks) {
		
		String Deck[]=new String[suits.length*ranks.length];
		int n=Deck.length;
		
		for(int i=0; i<ranks.length; i++)
		{
			for(int j=0; j<suits.length; j++)
			{
				Deck[4*i+j]=ranks[i]+" of "+suits[j];
			}
			
		}
		//shuffle the cards
		int r;
		for(int i=0; i<n; i++)
		{
			r=(int)(Math.random()*(n));
			String temp=Deck[i];
			Deck[i]=Deck[r];
			Deck[r]=temp;
		
		}
		
		System.out.println("enter the no of players ");
		int player=sc.nextInt();
		System.out.println("enter the no of cards");
		int card=sc.nextInt();
		String arr[][]=new String[player][card];
		
		//distribute the cards to players
		for(int i=0; i<player; i++)
		{
			//System.out.println("Player "+(i+1));
			for(int j=0; j<card; j++)
			{
				arr[i][j]=Deck[4*j+i];
				//System.out.print(arr[i][j]+", ");
			}
			System.out.println();
		}
		
		
		for(int i=0; i<player; i++)
		{
			System.out.println("Player "+(i+1));
			for(int j=0; j<card; j++)
			{
				System.out.println(arr[i][j]+", ");
			}
			System.out.println();
		}

		
	}
	public void clinic() throws FileNotFoundException {
		
String path2="//home//bridgeit//Documents//Sujay//ioprm//clinic.json";
		
		FileReader fr;
		
		JSONParser parser=new JSONParser();
		JSONObject obj=new JSONObject();
		
		JSONArray docArray=new JSONArray();
		JSONArray patArray=new JSONArray();
		
		/*
		System.out.println("enter the number of Doctors");
		int numDoctor=sc.nextInt();
		for(int i=0; i<numDoctor; i++)
		{
			JSONObject doctors=new JSONObject();
			System.out.println("enter the name of the doctor");
			String name=sc.next();
			doctors.put("Name", name);
			System.out.println("enter the doctor's ID");
			//int id=sc.nextInt();
			doctors.put("id",sc.next());
			System.out.println("enter the doctor Specialization");
			//String Specialization=sc.next();
			doctors.put("Specialization", sc.next());
			System.out.println("enter the doctor's availability");
			//int mob=sc.nextInt();
			doctors.put("availability", sc.next());
			System.out.println("enter the booked patients");
			doctors.put("booked", sc.nextInt());
			
			docArray.add(doctors);		
			
		}*/
		
		//int numDoctor=3
		String path3="//home//bridgeit//Documents//Sujay//ioprm//doctor.txt";

		Scanner scan=new Scanner(new File(path3));
		
		while(scan.hasNextLine())
		{
			JSONObject doctors=new JSONObject();

			doctors.put("Name", scan.nextLine());
			doctors.put("id",scan.nextLine());
			doctors.put("Specialization", scan.nextLine());
			doctors.put("availability", scan.nextLine());
			int booked=Integer.parseInt(scan.nextLine());
			doctors.put("booked",booked );

			docArray.add(doctors);		
		}
		
		/*
		System.out.println("enter the number of patients");
		int numPatient=sc.nextInt();
		for(int i=0; i<numPatient; i++)
		{
			JSONObject patients=new JSONObject();
			System.out.println("enter the patient name");
			patients.put("name", sc.next());
			System.out.println("enter the patient ID");
			patients.put("id", sc.next());
			System.out.println("enter the patient mobile number");
			patients.put("Mob", sc.nextInt());
			System.out.println("enter the patient Age");
			patients.put("Age", sc.nextInt());
			
			patArray.add(patients);
		}*/
		
		String path4="//home//bridgeit//Documents//Sujay//ioprm//patients.txt";

		Scanner scan2=new Scanner(new File(path4));
		
		while(scan2.hasNextLine())
		{
			JSONObject patients=new JSONObject();

			patients.put("Name", scan2.nextLine());
			patients.put("id",scan2.nextLine());
			patients.put("Mob", scan2.nextLine());
			patients.put("Age", scan2.nextLine());
			

			patArray.add(patients);		
		}
		
		
		obj.put("Doctor", docArray);
		//obj.put("Patient",patArray);
		try
		{
			PrintWriter pw=new PrintWriter(path2);
			pw.print(obj.toJSONString());
			pw.flush();
			//pw.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		obj.put("Patient",patArray);
		try
		{
			PrintWriter pw=new PrintWriter(path2);
			pw.print(obj.toJSONString());
			pw.flush();
			pw.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
			int k=0,m;
		while(true)
		{
			System.out.println("\n press 1 to search doctor by name");
			System.out.println(" press 2 to search doctor by ID");
			System.out.println(" press 3 to search doctor by Specialization");
			
			int docSearch=sc.nextInt();
			if(docSearch==1)
			{
				System.out.println("enter the name");
				String keyName=sc.next();
				
				for(int i=0; i<docArray.size(); i++)
				{
					JSONObject dataObj=(JSONObject) docArray.get(i);
					if(dataObj.get("Name").equals(keyName))
					{
						k=1;
						found(dataObj,docArray,obj,patArray);
					}
				}
			}
			
			if(docSearch==2)
			{
				System.out.println("enter the id");
				String keyID=sc.next();
				
				for(int i=0;i<docArray.size();i++){
					JSONObject dataObj = (JSONObject) docArray.get(i);
					//System.out.println(dataObj.get("id"));
					
					if(dataObj.get("id").equals(keyID)){
						k=1;
						found(dataObj,docArray,obj,patArray);
						//break;
					}
				}
				
				/*Iterator itr2=docArray.iterator();
				while(itr2.hasNext())
				{
					JSONObject copy=(JSONObject)itr2.next();
					/*if(copy.get("id").equals(keyID))
					{
						k=1;
						found(copy,docArray,obj,patArray);
						break;
					}
				}*/
			}
			
			if(docSearch==3)
			{
				System.out.println("enter the Specialization");
				String keySpecialization=sc.next();
				
				//System.out.println(docArray.get(0));
				for(int i=0;i<docArray.size();i++){
					JSONObject dataObj = (JSONObject) docArray.get(i);
					//System.out.println(dataObj.get("Specialization"));
					
					if(dataObj.get("Specialization").equals(keySpecialization)){
						k=1;
						found(dataObj,docArray,obj,patArray);
						//break;
					}
				}
				/*Iterator itr3=docArray.iterator();
				while(itr3.hasNext())
				{
					JSONObject copy=(JSONObject)itr3.next();
					if(copy.get("Specialization").equals(keySpecialization))
					{
						k=1;
						found(copy,docArray,obj,patArray);
						break;
					}
				}*/
			}
			
			if(k==0)
			{
				System.out.println("Doctor not available");
			}
			System.out.println("press 1 to continue else press 0");
			m=sc.nextInt();
			if(m==0)
			{
				break;
			}
		}
	}

	/**
	 * @param copy
	 * @param docArray
	 * @param obj
	 * @param patArray
	 * 
	 * 
	 */
	private static void found(JSONObject copy,JSONArray docArray,JSONObject obj,JSONArray patArray) 
	{
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Doctor is found");
		System.out.println("Name : "+copy.get("Name"));
		System.out.println("ID : "+copy.get("id"));
		System.out.println("Specialization : "+copy.get("Specialization"));
		System.out.println("availability : "+copy.get("availability"));
		System.out.println("booked patients : "+copy.get("booked"));

		System.out.println("press 1 for take the Doctor's appointment");
		int appointment=sc.nextInt();
		if(appointment==1)
		{
			//long value;
			int value=(int) copy.get("booked");
			System.out.println("enter the number of patients");
			int numPatient=sc.nextInt();
			int total=(int)value+numPatient;
			if(total<=5)
			{
				copy.put("booked",total);
				docArray.add(copy);
				obj.put("Doctor", docArray);
				
				for(int i=0; i<numPatient; i++)
				{
					JSONObject patients1=new JSONObject();
					System.out.println("enter the patient name");
					patients1.put("name", sc.next());
					System.out.println("enter the patient ID");
					patients1.put("id", sc.next());
					System.out.println("enter the patient mobile number");
					patients1.put("Mob", sc.nextInt());
					System.out.println("enter the patient Age");
					patients1.put("Age", sc.nextInt());
					
					patArray.add(patients1);
				}
				obj.put("Patient",patArray);
				
				String path2="//home//bridgeit//Documents//Sujay//ioprm//clinic.json";

				try
				{
					PrintWriter pw=new PrintWriter(path2);
					pw.print(obj.toJSONString());
					pw.flush();
					pw.close();
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			}
			else
			{
				System.out.println("Doctor allows only 5 patients");
			}
		}
		return;
		
	}
	public void address_Book() {
		
		JSONParser parser=new JSONParser();
		Scanner scan=new Scanner(System.in);
		int k,num,x=0;
		String path="//home//bridgeit//Documents//Sujay//ioprm//addBook.json";
		
		JSONArray arr=new JSONArray();
		while(true)
		{
			System.out.println("press 1 to add the details else press 0");
			num=scan.nextInt();
			if(num==0)
			{
				break;
			}
			JSONObject jobj=new JSONObject();
			System.out.println("enter the firstName");
			String firstName=scan.next();
			jobj.put("firstName", firstName);
			System.out.println("enter the lastName");
			String lastName=scan.next();
			jobj.put("lastName", lastName);
			System.out.println("enter the city");
			String city=scan.next();
			jobj.put("city", city);
			System.out.println("enter the state");
			String state=scan.next();
			jobj.put("state", state);
			System.out.println("enter the pin code");
			int pin=scan.nextInt();
			jobj.put("pin", pin);
			System.out.println("enter the moblile num");
			long mob=scan.nextLong();
			jobj.put("mobile", mob);
			//System.out.println("enter the state");
			// state=scan.next();
			//jobj.remove("state");
			//jobj.put("state", state);
			
			arr.add(jobj);
		}
		
		try
		{
			PrintWriter pw=new PrintWriter(path);
			pw.print(arr.toJSONString());
			pw.flush();
			pw.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		Iterator itr=arr.iterator();
		while(itr.hasNext())
		{
			JSONObject temp=(JSONObject)itr.next();
			
			System.out.println("Name : "+temp.get("firstName") +" "+temp.get("lastName"));
			System.out.println("city : "+temp.get("city"));
			System.out.println("State : "+temp.get("state"));
			System.out.println("pin code: "+temp.get("pin"));
			System.out.println("Mobile num : "+temp.get("mobile"));
			System.out.println();
		}
		
		while(true)
		{
			System.out.println("press 1 for search");
			System.out.println("press 2 for edit");
			System.out.println("press 0 for exit");
			k=scan.nextInt();
			if(k==0)
			{
				break;
			}
	
			if(k==1)
			{
				System.out.println("enter the name to be search");
				String keyName=scan.next();
				
				Iterator itr1=arr.iterator();
				while(itr1.hasNext())
				{
					JSONObject object=(JSONObject)itr1.next();
				
					if(keyName.equals(object.get("firstName")))
					{
						x=1;
						System.out.println("Name : "+object.get("firstName"));
						System.out.println("city : "+object.get("city"));
						System.out.println("State : "+object.get("state"));
						System.out.println("pin code: "+object.get("pin"));
						System.out.println("Mobile num : "+object.get("mobile"));
					}
				}
			}
			
			else if(k==2)
			{
				System.out.println("enter the name to be edit");
				String keyName=scan.next();
				
				for(int i=0;i<arr.size();i++){
					JSONObject dataObj = (JSONObject) arr.get(i);
					//System.out.println(dataObj.get("Specialization"));
					
					if(dataObj.get("firstName").equals(keyName)){
						System.out.println("HELLO");
						arr.remove(i);
						//x=1;
						//arr.remove(itr2);
						JSONObject json=new JSONObject();
						json.put("name", keyName);
						System.out.println("enter the city");
						String city=scan.next();
						json.put("city", city);
						System.out.println("enter the state");
						String state=scan.next();
						json.put("state", state);
						System.out.println("enter the pin code");
						int pin=scan.nextInt();
						json.put("pin", pin);
						System.out.println("enter the moblile num");
						long mob=scan.nextLong();
						json.put("mobile", mob);
						
						arr.add(json);
						break;
					}
				}
				
				
					try
					{
						PrintWriter pw=new PrintWriter(path);
						pw.print(arr.toJSONString());
						pw.flush();
						pw.close();
					}
					catch(Exception e)
					{
						e.printStackTrace();
					}
				}
					
			}
				if(x==0)
				{
					System.out.println("Name not found ");
				}
				
				if(k>2)
				{
					System.out.println("enter the correct input");
				}
		
	}
}
