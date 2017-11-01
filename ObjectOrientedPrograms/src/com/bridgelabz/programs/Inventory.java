package com.bridgelabz.programs;

import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.bridgelabz.utility.Utility;

public class Inventory {
	
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		String[] name={"Rice","Wheat","Pulses"};
		
		Utility utility=new Utility();
		utility.inventory(name);
		utility.readData();
	}

}
