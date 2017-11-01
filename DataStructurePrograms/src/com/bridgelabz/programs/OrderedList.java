package com.bridgelabz.programs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collection;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.StringTokenizer;

import com.bridgelabz.utility.Utility;

public class OrderedList {
	

	public static void main(String[] args) throws IOException {
		
		String path="//home//bridgeit//Documents//Sujay//ioprm//file2.txt";
		
		LinkedList list=new LinkedList();
		String string;
		
		Utility utility=new Utility();
        
		try
		{
			String string1="";
			FileReader fr=new FileReader(path);
			BufferedReader br=new BufferedReader(fr);
			while((string=br.readLine())!=null)
			{
				StringTokenizer str=new StringTokenizer(string,",");
				while(str.hasMoreTokens())
				{
					String token=str.nextToken();
					list.add(token);
				}System.out.println(list);
				list=utility.ordered_list_sort(list);
				string1=String.valueOf(list);
				
			}
			
			FileWriter fw=new FileWriter(path);
			BufferedWriter bw=new BufferedWriter(fw);
			
			bw.write(string1);
			bw.flush();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println(list);

	}

}
