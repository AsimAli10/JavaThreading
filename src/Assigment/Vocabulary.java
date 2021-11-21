package Assigment;

import java.io.*;
import java.util.*;

public class Vocabulary extends Thread {
	String Name,Path;
	Vocabulary(String s)
	{
		Path="src/";
		Path+=s;
		Name=s;
	}
	BinarySearchTree Tree=new BinarySearchTree();
	public void run()
	{
		try {
		File readData=new File(Path);
		BufferedReader temp=new BufferedReader(new FileReader(readData));
		String TempString;
		System.out.println("Reading...."+Path);
		while((TempString=temp.readLine())!=null)
		{
			StringTokenizer S= new StringTokenizer(TempString," ");
			while (S.hasMoreTokens()) 
			{  
				Tree.insert(S.nextToken()); 
			}	
		}
		temp.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public void print()
	{
		Tree.inorder();
		System.out.println();
	}
}
