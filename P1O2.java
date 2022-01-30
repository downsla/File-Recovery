//Liam Downs
//CPSC 4363

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class P1O2 {

	public static void main(String[] args) {
		
		ArrayList<ArrayList<Integer>> inputLines = new ArrayList<ArrayList<Integer>>(); //stores input

		Scanner input = new Scanner(System.in); //parse input with scanner
		while(true) { //loop input
			System.out.println("Input:");
			int c = 0; //counter for lines
			while(c < 3 && input.hasNextLine()) { //loops lines
				inputLines.add(new ArrayList<Integer>()); //add line to input
				for(String s : input.nextLine().trim().split("\\s+")) { //loops through line
					inputLines.get(c).add(Integer.valueOf(s)); //stores integers in list
				}
				c++;
			}
			if(c != 3 || inputLines.get(1).size() != inputLines.get(2).size()) { //input validation
				System.out.println("Invalid Input\n");
				input.next();
				continue;
			} else {
				break; //exit input loop
			}
		}
		input.close();
		
		for(int i = 0; i < inputLines.get(0).size(); i++) { //loops through first clusters
			int cluster = inputLines.get(0).get(i); //set to first cluster
			while(cluster > 0) { //loop until end cluster
				int index = inputLines.get(1).indexOf(cluster); //set to index of cluster
				cluster = inputLines.get(2).get(index); //set to next cluster
				inputLines.get(1).remove(index); //remove column from FAT
				inputLines.get(2).remove(index);
			}
		}

		ArrayList<ArrayList<Integer>> output = new ArrayList<ArrayList<Integer>>(); //clusters of deleted file(s)
		
		while(true) { //loop deleted files
			int index = inputLines.get(2).indexOf(0); //set to first end cluster index that has no associated file
			if(index != -1) { //add deleted file to output if applicable
				output.add(new ArrayList<Integer>());
			} else {
				break; //exit when no more deleted files
			}
			while(index > -1) { //loop until first cluster
				int cluster = inputLines.get(1).get(index); //sets to cluster at index
				output.get(output.size() - 1).add(cluster); //store cluster of deleted file
				inputLines.get(1).remove(index); //remove column from FAT
				inputLines.get(2).remove(index);
				index = inputLines.get(2).indexOf(cluster); //set to previous cluster
			}
		}
		
		System.out.println("Output:");
		for(ArrayList<Integer> file : output) { //loops deleted file(s)
			Collections.reverse(file); //reverses order because backtrack
			for(Integer cluster : file) { //loops clusters
				System.out.print(cluster + " ");
			}
			System.out.println();
		}
		
	}
	
}
