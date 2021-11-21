package Assigment;
public class Word {
public
	String word;
	int number=0;
	Word(String w)
	{
		word=w;
	}
	public void increaseCount()
	{
		number++;
	}
	public int getCount()
	{
		return number;
	}
}
