import java.util.*;

public class CharPermu {
	
	public static void printPermu(char[][] ori) {
		int level=0,position[]=new int[ori.length];
		char[] line = new char[position.length];
		while(level!=-1) {
			while(level<ori.length) {
				line[level] = ori[level][position[level]];
				level++;
			}
			
			System.out.println(line);
			level--;
			
			while(level!=-1) {
				position[level]=position[level]+1;
				if(position[level]!=ori[level].length) {				
					break;
				}
				
				else {
					position[level]=0;
					level--;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner userInput = new Scanner(System.in);
		int rows,columns,rowIndex,columnIndex;
		char[][] ary = new char[1][1];
		System.out.println("Please tell me how many rows your ary[][] will have");
		

		while(userInput.hasNextInt()) {
			rows = userInput.nextInt();
			if(rows>0) {
				ary = new char[rows][];
				rowIndex = 0;
				System.out.printf("Please tell me the length of your arr[%d] \n",rowIndex);
				while(rowIndex<rows && userInput.hasNextInt()) {
					columns = userInput.nextInt();
					if(columns>0) {
						ary[rowIndex] = new char[columns];
						columnIndex=0;
						System.out.printf("Please tell me the values of arr[%d] at index[%d] \n",rowIndex,columnIndex);
						
						while(columnIndex<ary[rowIndex].length && userInput.hasNext()) {
							ary[rowIndex][columnIndex++] = userInput.next().charAt(0);
							System.out.printf("Please tell me the values of arr[%d] at index[%d] \n",rowIndex,columnIndex);
						}
						
						if(columnIndex == ary[rowIndex].length) {
							rowIndex++;
						}
					}
					
					else {
						System.out.printf("%s is invalid row size, please enter the correct row number-->", columns);
					}

				}
				
				if(rowIndex == rows) {
					System.out.println("\n here is your ouput \n\n");
					printPermu(ary);
				}
			}
			else {
				System.out.printf("%s is invalid row size, please enter the correct row number-->", rows);
			}
		}
		userInput.close();
		System.out.println("Program halted!");
		System.exit(0);
	}
}

