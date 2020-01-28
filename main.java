// Rachel Nock  //
// CSE 3521     //
// Lab 1        //
// May 31, 2017 //

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.PriorityQueue;
import java.util.Comparator;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/** takes in intial state of robots and performs users search selection on it
	and then prints solution to screen */

public class main {
	
	public static void main(String[] args) {
		try {
			String start = "ABCDP";
			String home = "";
			int depth = 0;
			int g = 0;
			int f = 0;
			
			/** initializes initial state */
			State initialState = new State (depth, start, home, g, f);
			
			while (true) {
				System.out.println("\nChoose a search option:");
				System.out.println("Enter 1 for Breadth first search");
				System.out.println("Enter 2 for Depth first search");
				System.out.println("Enter 3 for Uniform-Cost Search");
				System.out.println("Enter 4 for A* Search");
				System.out.println("Enter 5 to exit program");
			
				int option;
			
				BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
				option = Integer.parseInt(in.readLine());
			  
			  /** executes a search option based on user input */
				switch(option) {
					case 1:
						executeBFS(initialState);
						break;
					case 2:
						executeDFS(initialState);
						break;
					case 3:
						executeUCS(initialState);
						break;
					case 4:
						executeAS(initialState);
						break;
					case 5:
						System.exit(1);
					default:
						System.out.println("ERROR - Option chosen is invalid.");
						break;
				}
			}			
		}
		
		/** handles case where exception occurs */
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/** executes breadth first search */
	private static void executeBFS(State initialState) {
		PriorityQueue<State> solution = new PriorityQueue<State>();
		BFS search = new BFS();
		solution = search.exec(initialState);
		System.out.println("breadth first search solution:");
		printSolution(solution);
	}

  /** executes depth first search */
	private static void executeDFS(State initialState) {
		PriorityQueue<State> solution = new PriorityQueue<State>();
		DFS search = new DFS();
		solution = search.exec(initialState);
		System.out.println("depth first search solution:");
		
		Comparator<State> comparator = new CompareByDepthAscend();
		
		/** new queue to hold solution being printed to screen */
		PriorityQueue<State> output = new PriorityQueue<State>(comparator);
		
		/** loops until solution queue is empty */
		while (solution.size() > 0) {
			State s = solution.poll();
			output.add(s);
		}
		
		/** prints solution to screen in correct format */		
		while (output.size() > 0) {
			State st = output.poll();
			System.out.print("<\"");
			System.out.print(st.start);
			System.out.print("\",\"");
			System.out.print(st.home);
			System.out.print("\",\"");
			System.out.print(st.depth);
			System.out.println("\">");
		}
	}
	
	/** executes uniform cost search */
	private static void executeUCS(State initialState) {
		PriorityQueue<State> solution = new PriorityQueue<State>();
		UCS search = new UCS();
		solution = search.exec(initialState);
		System.out.println("uniform cost search solution:");
		printSolution(solution);
	}
  
  /** executes A* search */
	private static void executeAS(State initialState) {
		PriorityQueue<State> solution = new PriorityQueue<State>();
		AS search = new AS();
		solution = search.exec(initialState);
		System.out.println("A* search solution:");
		printSolution(solution);
	}
	
	/** prints solution to screen */
	private static void printSolution(PriorityQueue<State> solution) {
		State soln = solution.poll();
		
		/** gets final/goal state value in queue */
		while (solution.size() >= 1) {
			soln = solution.poll();
	  }
		
		int j = soln.depth;
		State soln2 = soln;
		State s = soln;
		Comparator<State> comparator = new CompareByDepthAscend();
		
		/** new queue to hold solution being printed to screen */
		PriorityQueue<State> output = new PriorityQueue<State>(comparator);
		output.add(soln2);
		
		/** gets all parent states of final state (i.e. the set of states that is solution) */	
		while (j > 0) {
			s = s.getParentState();
			output.add(s);
			j--;
		}
		
		/** prints solution to screen in correct format */		
		while (output.size() > 0) {
			State st = output.poll();
			System.out.print("<\"");
			System.out.print(st.start);
			System.out.print("\",\"");
			System.out.print(st.home);
			System.out.print("\",\"");
			System.out.print(st.depth);
			System.out.println("\">");
		}
	}
}