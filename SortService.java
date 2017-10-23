package services;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import analyzer.Analyzer;

public class SortService {
	
	Scanner sc;
	public SortService()
	{
		sc=new Scanner(System.in);
	}
	
	public void showSortServiceMenu()
	{
		Analyzer analyzer= new Analyzer();
		sc=new Scanner(System.in);
		char ch;
		do
		{
			System.out.println("1. Bubble Sort");
			System.out.println("Press b to go back to previous menu");
			System.out.println("Press q to quit.");
			System.out.println("Enter your choice: ");
			
				ch=sc.next().charAt(0);
				switch(ch)
				{
					case '1': System.out.println("Bubble"); break;
					
					case 'q' : System.exit(0);
					
					case 'b': analyzer.showMenu(); ch='q'; break;
					
					default : System.out.println("Invalid Entry");break;
				}	
		}while(ch!='q');
	}
	public  List<Integer> loadData(List<Integer> dataList)
	{
		int entry=0;
		boolean stop=false;
		String input;
		System.out.println("Enter an integer or 00 to stop input");
		
		
		while(!stop)
		{
			
			input= sc.nextLine();
			if(input.equals("00"))
			{
				stop=true;
				
			}
			else
			{
				
				dataList.add(Integer.valueOf(input));
				input=null;
				
				
			}
			
		}
		
		return dataList;
	}
	public static void main(String[] args) {
		List<Integer> dataList= new ArrayList<Integer>();
		SortService sortService = new SortService();
		System.out.println(sortService.loadData(dataList));
	}
	
}
