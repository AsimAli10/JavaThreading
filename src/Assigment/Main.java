package Assigment;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		int i=3,j=0;
		if(args[2]==null)
		{
			throw new NoInputFiles("No Vocabulary File is Entered");
		}
		int numOfFiles=args.length-3;
		if(numOfFiles<=0)
		{
			throw new NoInputFiles("No Input File is Entered");
		}
		Vocabulary V=new Vocabulary(args[2]);
		InputFile[] thread=new InputFile[numOfFiles];
		 System.out.println("Total Number of input files are "+numOfFiles);
		 while(i<args.length)
		 {
			 thread[j] =new InputFile(args[i]);
			 System.out.println(args[i]);
			 i++;
			 j++;
		 }
		 V.start();
		 i=0;
		 while(i<numOfFiles)
		 {
			 thread[i].start();
			 i++;
		 }
		
		 
		 
		int choice;
		Scanner myObj = new Scanner(System.in);
		while(true)
		{
			System.out.println("-------------------Menu----------------------");
			System.out.println("1) Displaying BST build from Vocabulary File.");
			System.out.println("2) Displaying Vectors build from Input files.");
			System.out.println("3) Viewing Match words and its frequency");
			System.out.println("4) Searching a query->It should display all the files query found in.");
			System.out.println("5) Enter 5 for Exiting");
			System.out.println("--------------------------------------------");
			choice=myObj.nextInt();
			if(choice==1) {
				V.print();
			}
			else if(choice==2)
			{
				i=0;
				 while(i<numOfFiles)
				 {
					 thread[i].print();
					 i++;
				 }
			}
			else if(choice==3)
			{
				i=0;
				while(i<numOfFiles)
				{
					thread[i].checkWords(V);
					i++;
				}
			}
			else if(choice==4)
			{
				System.out.println("Enter your Query");
				myObj.nextLine();
				String q=myObj.nextLine();
				
				i=0;
				while(i<numOfFiles)
				{
					thread[i].Query(q);
					i++;
				}
			}
			else if(choice==5)
			{
				System.out.println("exiting the system...");
				return;
			}
			else
			{
				throw new InvalidMenuChoice("Invalid Option Entered!");
			}
		}
		
	}

}
