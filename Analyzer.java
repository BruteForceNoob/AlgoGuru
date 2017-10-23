package analyzer;

import java.util.Scanner;

import services.SortService;

public class Analyzer {
	Scanner sc;
	SortService sortService;
	
	public Analyzer()
	{
		sc=new Scanner(System.in);
		sortService= new SortService();
	}
 
	
	
	public void showMenu()
	{
		char ch;
		do
		{
			System.out.println("1. Sorting Algorithms");
			System.out.println("2. Searching Algorithms");
			System.out.println("Press q to quit.");
			System.out.println("Enter your choice: ");
			
				ch=sc.next().charAt(0);
				
			switch(ch)
			{
				case '1': sortService.showSortServiceMenu();break;
				case '2' : System.out.println("search");break;
				case 'q' : System.exit(0);
				default : System.out.println("Invalid entry");
			}
			

		}
		while(ch!='q');
	}
	
	public static void main(String[] args) 
	{
		Analyzer analyzer=new Analyzer();
		analyzer.showMenu();
    }
}
