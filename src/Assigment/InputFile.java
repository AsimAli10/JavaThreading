package Assigment;

import java.io.*;
import java.util.*;

public class InputFile extends Thread {
	Vector<String> vec = new Vector<String>();
	String Name,Path;
	InputFile(String s)
	{
		Path="src/";
		Name=s;
		Path+=s;
	}
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
					vec.addElement(S.nextToken()); 
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
		System.out.println("Elements in File "+Name+vec);
	}
	public void checkWords(Vocabulary Vocab)
	{
		System.out.println("Vocabulary Matches in "+Name);
		BinarySearchTree.Node Current,Past;
		if(Vocab.Tree.root==null)
		{
			return;
		}
		Current=Vocab.Tree.root;
		while(Current!=null)
		{
			if(Current.left==null)
			{
				Search(Current.key);
				Current=Current.right;
			}
			else
			{
				Past=Current.left;
				while(Past.right!=null&&Past.right!=Current)
				{
					Past=Past.right;
				}
				if(Past.right==null)
				{
					Past.right=Current;
					Current=Current.left;
				}
				else
				{
					Past.right=null;
					Search(Current.key);
					Current=Current.right;
				}
			}
		}
	}
	public void Search(String s)
	{
		Word W=new Word(s);
		for(int i=0;i<vec.size();i++)
		{
			if(s.equals(vec.get(i)))
			{
				W.increaseCount();
			}
		}
		System.out.println(s+" : "+W.getCount());    
	}
	public void Query(String query)
	{
		System.out.println("Query Matches in "+Name);
			StringTokenizer S= new StringTokenizer(query," ");
			while (S.hasMoreTokens()) 
			{  
				Search(S.nextToken()); 
			}
	}
}
