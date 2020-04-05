/***
*	CSC Competition Question:	Week 6
*
*	Open until March 30 11pm
*
*	Description:
*
*	Given a sentence and either the word "encrypt" or "decrypt", encrypt or 
*	decrpyt the given sentence. The following is the encryption scheme.
*
*		1)	Remove the spaces from the sentence
*
*		2)	Create a grid. If the length of the sentence, L, is 54 characters long. 
*			The square root of 54 is between 7 and 8, so it is written in the form of 
*			a grid with 7 rows and 8 columns. Ensure that number of rows multiplied by 
*			the number of columns >= L If multiple grids satisfy the above conditions, 
*			choose the one with the minimum area.
*
*		3)	The encoded message is obtained by displaying the characters in a column, 
*			inserting a space, and then displaying the next column and inserting a space, 
*			and so on.
*
*	Sample Input:	Ohana means family encrypt
*
*					grid is 4 x 4 -> Ohan amea nsfa mily
*
*	Sample Output:	Oanm hmsi aefl naay
*
*
*	Sample Input:	Oanm hmsi aefl naay decrypt
*
*	Sample Output:	Ohanameansfamily 
*
*	Note: The spaces do not have to be added in after decryption
*
*	Algorithm:
*
*	1: Take String and instruction from user input.
*
* 	2: Determine instruction command.
*
*	3: Execute Command:
*
*			A)	Encryption Algorithm:
*
*				i: 		Remove whitespace from the input String.
*
*				ii:		Find the size of the encryption grid.
*				
*				iii:		Create and fill the encryption grid:
*
*						a)	A nested for-loop iterates through the String and add's the character at position zero to a 2D array.
*							This charcter is then removed from the String.
*
*				iv:		Print the encrypted message
*
*			B)	Decryption Method:
*
*				i: 		Remove whitespace from the encrypted String for part ii.
*
*				ii:		Find the size of the decryption grid.
*
*				iii:		Create and fill the decryption grid:
*
*						Note:	I have used the .split() method to separate the encrypted String into individual words and then added 
*								a single word to a single column. This process prevents characters being misplaced as will occur if a
*								traditional nested-loop approach is used.
*
*				iv:		Print the encrypted message
*
***/

import java.util.Scanner;

public class CSCCompW6
{
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		
		// 1:
		String input = scan.nextLine();
		String command = scan.nextLine();
		command = command.toLowerCase();
		scan.close();
		
		// 2:
		if(command.equals("encrypt"))
		{	
			encrypt(input);
		}
		else if(command.equals("decrypt"))
		{	
			decrypt(input);
		}
		else
		{	
			System.out.println("Invalid command - Try again");
		}
		
	}	//End main()
	
	
	public static void encrypt(String input)	// A)
	{	// i:
		String x = new String("");
		for(String y: input.split(" "))
		{
			x += y;
		}
		
		// ii:
		int length = x.length();
		int rows = (int)Math.sqrt(length);
		int cols = rows;
		while(length > (rows * cols))
		{
			cols++;
		}
		
		// iii:
		String[][] encrypt = new String[rows][cols];
		for(int i = 0; i < rows; i++)
		{	// a)
			for(int j = 0; j < cols; j++)
			{
				if(x.length() > 1)
				{	
					encrypt[i][j] = x.substring(0, 1);
					x = x.substring(1);
				}
				else if(x.length() == 1)
				{	
					encrypt[i][j] = x; break;
				}
			}
		}	//End nested loop
		
		// iv:
		for(int i = 0; i < cols; i++)
		{
			for(int j = 0; j < rows; j++)
			{
				if(encrypt[j][i] != null)
				{
					System.out.print(encrypt[j][i]);
				}
			}
			System.out.print(" ");
		}
		
	}	//End encrypt()
	
	
	public static void decrypt(String input)	// B)
	{
		// i:
		String x = new String("");
		for(String y: input.split(" "))
		{
			x += y;
		}
		
		// ii:
		int length = x.length();
		int rows = (int)Math.sqrt(length);
		int cols = rows;
		while(length > (rows * cols))
		{
			cols++;
		}
		
		// iii:
		String[][] decrypt = new String[rows][cols];
		int pos = 0;
		for(String y: input.split(" "))
		{
			String z = y;
			for(int i = 0; i < rows; i++)
			{
				if(z.length() > 1)
				{
					decrypt[i][pos] = z.substring(0, 1);
					z = z.substring(1);
				}
				else if(z.length() == 1)
				{
					decrypt[i][pos] = z; break;
				}
			}
			pos++;
		}
		
		// iv:
		for(int i = 0; i < rows; i++)
		{
			for(int j = 0; j < cols; j++)
			{
				if(decrypt[i][j] != null)
				{
					System.out.print(decrypt[i][j]);
				}
			}
		}
	}	//End decrypt()
	
}	//End class
