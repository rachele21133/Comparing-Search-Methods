import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.PriorityQueue;
import java.util.Comparator;

/** implements Uniform Cost Search */

public class UCS {
	
	public PriorityQueue<State> exec(State initialState) {
		
		Comparator<State> comparator = new CompareByCost();
		
		/** FIFO queues ordered by ascending path cost */
		PriorityQueue<State> fringe = new PriorityQueue<State>(comparator);
		PriorityQueue<State> expanded = new PriorityQueue<State>(comparator);
		
		State currentState;
		
		/** checks if initial state is goal state */
		if (initialState.isGoal()) {
			fringe.add(initialState);
			return fringe;
		}
		
		fringe.add(initialState);
		
		/** loops until no more states to look at in queue */
		while (fringe.size() > 0) {
			currentState = fringe.poll();
			expanded.add(currentState);
			
			/** returns explanded states queue if current state is goal */
			if (currentState.isGoal()) {
				return expanded;
			}
			
			/** gets successors of current state */
			List<State> successors = currentState.generateSuccessors();
			State successor;
			int i = 0;
			
			/** loops until all list of successor states is empty */
			while (i < successors.size()) {
				successor = successors.get(i);
				
				/** sets depth of successor state */
				successor.depth = currentState.depth + 1;
				
				/** adds successor state to fringe queue */
				fringe.add(successor);
				i++;
			}
			
		}
		return expanded;
	}
}