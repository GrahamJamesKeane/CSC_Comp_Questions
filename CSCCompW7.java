/***
*	CSC Competition Question:	Week 7
*
*	Open until April 6 2020 11pm
*
*	Description:
*	Write a Java program sums all the non-negative numbers less than or equal to a given 
*	number which there are not two consecutive ones in the binary representation of the 
*	number. Your program should then print the sum to the screen.
*
*	Hint: You must take the number in with user input.
*
*   Example: 	5 
*
*    			0 : 0
*    			1 : 1
*   			2 : 10
*   		 	3 : 11
*    			4 : 100
*    			5 : 101
*
*    			3 has two consecutive ones so it is not counted.
*
*    			Total to be printed is 0 + 1 + 2 + 4 + 5 = 12
*
*				Sample Input:	5
*
*				Sample Output:	12
*
*
*	Algorithm:
*
*	Step 1:	Take parameter from user.
*
*	Step 2: Determine binary respresentation of each non-negative integer <= input. -> toBinary() method
*
*	Step 3: Filter any binary numbers which have repeating 1's.
*
*	Step 4: Add these numbers to an array.
*
*	Step 5:	Add the remaining numbers to an accumulator.
*
*	Step 6: Print the value of the accumulator.
*
***/

import java.util.Scanner;

public class CSCCompW7
{
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		
		int input = scan.nextInt();	//Step 1:
		
		toBinary(input);
		
	}	//End main()
	
	
	public static void toBinary(int input)
	{
		int[] num = new int[input];
		int sum = 0;
		
		for(int i = input; i > 0; i--)
		{	//Step 2:
			String b = new String("");
			
			for(int j = i; j > 0; j = j / 2)
			{
				b = (j % 2) + b;
			}
			
			if(b.length() == 1)
			{
				num[i - 1] = i;
			}
			else
			{
				boolean flag = false;
				
				for(int k = 0; k < b.length() - 1; k++)
				{	//Step 3:
					String s1 = "" + b.charAt(k);
					String s2 = "" + b.charAt(k + 1);
					
					if(s1.matches("1"))
					{
						if(s2.matches("1"))
						{
							flag = false; break;
						}
						else
						{
							flag = true;
						}
					}
					else
					{
						flag = true;
					}
				}	//End inner loop 2
				
				if(flag)
				{	//Step 4:
					num[i - 1] = i;
				}
			}	//End else
				
		}	//End nested loop
		
		for(int i = 0; i < num.length; i++)
		{	//Step 5:
			sum += num[i];
		}
		
		System.out.println(sum);	//Step 6:
		
	}	//End toBinary()
	
}	//End class