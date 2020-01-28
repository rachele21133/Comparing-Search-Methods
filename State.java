import java.util.ArrayList;
import java.util.List;
import java.util.Comparator;

/* State class which represents which side robots and power pack are on */

public class State {
	
	public int depth;
	public String start;
	public String home;
	public int g;
	public int f;
	
	private State parentState;
	
	public State(int depth, String start, String home, int g, int f) {
		this.depth = depth;
		this.start = start;
		this.home = home;
		this.g = g;
		this.f = f;
	}
	
	/** returns true if state is goal state; returns false if state is not goal state */
	public boolean isGoal() {
		return (home == "ABCDP");
	}
	
	/** takes in state and generates a list of all possible successor states */
	public List<State> generateSuccessors() {
		List<State> successors = new ArrayList<State>();
		State initialState = new State (depth, start, home, g, f);
		State successor;
		
		if (start == "ABCDP") {
			successor = initialState.ABgoHome(initialState);
			successor.setParentState(this);
			successor.g = 2;
			successor.f = successor.g + 1;
			successors.add(successor);
			successor = initialState.ACgoHome(initialState);
			successor.setParentState(this);
			successor.g = 5;
			successor.f = successor.g + 1;
			successors.add(successor);
			successor = initialState.ADgoHome(initialState);
			successor.setParentState(this);
			successor.g = 10;
			successor.f = successor.g + 1;
			successors.add(successor);
			successor = initialState.BCgoHome(initialState);
			successor.setParentState(this);
			successor.g = 5;
			successor.f = successor.g + 2;
			successors.add(successor);
			successor = initialState.BDgoHome(initialState);
			successor.setParentState(this);
			successor.g = 10;
			successor.f = successor.g + 2;
			successors.add(successor);
			successor = initialState.CDgoHome(initialState);
			successor.setParentState(this);
			successor.g = 10;
			successor.f = successor.g + 5;
			successors.add(successor);
		}
		
		else if (start == "ABP") {
			successor = initialState.ABgoHome(initialState);
			successor.setParentState(this);
			successor.g = 2;
			successor.f = successor.g + 1;
			successors.add(successor);
		}
		
		else if (start == "ACP") {
			successor = initialState.ACgoHome(initialState);
			successor.setParentState(this);
			successor.g = 5;
			successor.f = successor.g + 1;
			successors.add(successor);
		}
		
		else if (start == "ADP") {
			successor = initialState.ADgoHome(initialState);
			successor.setParentState(this);
			successor.g = 10;
			successor.f = successor.g + 1;
			successors.add(successor);
		}
		
		else if (start == "BCP") {
			successor = initialState.BCgoHome(initialState);
			successor.setParentState(this);
			successor.g = 5;
			successor.f = successor.g + 2;
			successors.add(successor);
		}
		
		else if (start == "BDP") {
			successor = initialState.BDgoHome(initialState);
			successor.setParentState(this);
			successor.g = 10;
			successor.f = successor.g + 2;
			successors.add(successor);
		}
		
		else if (start == "CDP") {
			successor = initialState.CDgoHome(initialState);
			successor.setParentState(this);
			successor.g = 10;
			successor.f = successor.g + 5;
			successors.add(successor);
		}
		
		else if (start == "ABCP") {
			successor = initialState.ABgoHome(initialState);
			successor.setParentState(this);
			successor.g = 2;
			successor.f = successor.g + 1;
			successors.add(successor);
			successor = initialState.ACgoHome(initialState);
			successor.setParentState(this);
			successor.g = 5;
			successor.f = successor.g + 1;
			successors.add(successor);
		}
		
		else if (start == "ABDP") {
			successor = initialState.ABgoHome(initialState);
			successor.setParentState(this);
			successor.g = 2;
			successor.f = successor.g + 1;
			successors.add(successor);
			successor = initialState.ADgoHome(initialState);
			successor.setParentState(this);
			successor.g = 10;
			successor.f = successor.g + 1;
			successors.add(successor);
		}
		
		else if (start == "ACDP") {
			successor = initialState.ACgoHome(initialState);
			successor.setParentState(this);
			successor.g = 5;
			successor.f = successor.g + 1;
			successors.add(successor);
			successor = initialState.ADgoHome(initialState);
			successor.setParentState(this);
			successor.g = 10;
			successor.f = successor.g + 1;
			successors.add(successor);
		}
		
		else if (start == "BCDP") {
			successor = initialState.BCgoHome(initialState);
			successor.setParentState(this);
			successor.g = 5;
			successor.f = successor.g + 2;
			successors.add(successor);
			successor = initialState.BDgoHome(initialState);
			successor.setParentState(this);
			successor.g = 10;
			successor.f = successor.g + 2;
			successors.add(successor);
		}
		
		else if (home == "BCDP") {
			successor = initialState.BgoStart(initialState);
			successor.setParentState(this);
			successor.g = 2;
			successor.f = successor.g + 2;
			successors.add(successor);
			successor = initialState.CgoStart(initialState);
			successor.setParentState(this);
			successor.g = 5;
			successor.f = successor.g + 5;
			successors.add(successor);
			successor = initialState.DgoStart(initialState);
			successor.setParentState(this);
			successor.g = 10;
			successor.f = successor.g + 10;
			successors.add(successor);
		}
		
		else if (home == "ACDP") {
			successor = initialState.AgoStart(initialState);
			successor.setParentState(this);
			successor.g = 1;
			successor.f = successor.g + 1;
			successors.add(successor);
			successor = initialState.CgoStart(initialState);
			successor.setParentState(this);
			successor.g = 5;
			successor.f = successor.g + 5;
			successors.add(successor);
			successor = initialState.DgoStart(initialState);
			successor.setParentState(this);
			successor.g = 10;
			successor.f = successor.g + 10;
			successors.add(successor);
		}
		
		else if (home == "ABDP") {
			successor = initialState.AgoStart(initialState);
			successor.setParentState(this);
			successor.g = 1;
			successor.f = successor.g + 1;
			successors.add(successor);
			successor = initialState.BgoStart(initialState);
			successor.setParentState(this);
			successor.g = 2;
			successor.f = successor.g + 2;
			successors.add(successor);
			successor = initialState.DgoStart(initialState);
			successor.setParentState(this);
			successor.g = 10;
			successor.f = successor.g + 10;
			successors.add(successor);
		}
		
		else if (home == "ABCP") {
			successor = initialState.AgoStart(initialState);
			successor.setParentState(this);
			successor.g = 1;
			successor.f = successor.g + 1;
			successors.add(successor);
			successor = initialState.BgoStart(initialState);
			successor.setParentState(this);
			successor.g = 2;
			successor.f = successor.g + 2;
			successors.add(successor);
			successor = initialState.CgoStart(initialState);
			successor.setParentState(this);
			successor.g = 5;
			successor.f = successor.g + 5;
			successors.add(successor);
		}
		
		else if (home == "CDP") {
			successor = initialState.CgoStart(initialState);
			successor.setParentState(this);
			successor.g = 5;
			successor.f = successor.g + 5;
			successors.add(successor);
			successor = initialState.DgoStart(initialState);
			successor.setParentState(this);
			successor.g = 10;
			successor.f = successor.g + 10;
			successors.add(successor);
		}
		
		else if (home == "BDP") {
			successor = initialState.BgoStart(initialState);
			successor.setParentState(this);
			successor.g = 2;
			successor.f = successor.g + 2;
			successors.add(successor);
			successor = initialState.DgoStart(initialState);
			successor.setParentState(this);
			successor.g = 10;
			successor.f = successor.g + 10;
			successors.add(successor);
		}
		
		else if (home == "BCP") {
			successor = initialState.BgoStart(initialState);
			successor.setParentState(this);
			successor.g = 2;
			successor.f = successor.g + 2;
			successors.add(successor);
			successor = initialState.CgoStart(initialState);
			successor.setParentState(this);
			successor.g = 5;
			successor.f = successor.g + 5;
			successors.add(successor);
		}
		
		else if (home == "ADP") {
			successor = initialState.AgoStart(initialState);
			successor.setParentState(this);
			successor.g = 1;
			successor.f = successor.g + 1;
			successors.add(successor);
			successor = initialState.DgoStart(initialState);
			successor.setParentState(this);
			successor.g = 10;
			successor.f = successor.g + 10;
			successors.add(successor);
		}
		
		else if (home == "ACP") {
			successor = initialState.AgoStart(initialState);
			successor.setParentState(this);
			successor.g = 1;
			successor.f = successor.g + 1;
			successors.add(successor);
			successor = initialState.CgoStart(initialState);
			successor.setParentState(this);
			successor.g = 5;
			successor.f = successor.g + 5;
			successors.add(successor);
		}
		
		else if (home == "ABP") {
			successor = initialState.AgoStart(initialState);
			successor.setParentState(this);
			successor.g = 1;
			successor.f = successor.g + 1;
			successors.add(successor);
			successor = initialState.BgoStart(initialState);
			successor.setParentState(this);
			successor.g = 2;
			successor.f = successor.g + 2;
			successors.add(successor);
		}
		
		else if (home == "AP") {
			successor = initialState.AgoStart(initialState);
			successor.setParentState(this);
			successor.g = 1;
			successor.f = successor.g + 1;
			successors.add(successor);
		}
		
		else if (home == "BP") {
			successor = initialState.BgoStart(initialState);
			successor.setParentState(this);
			successor.g = 2;
			successor.f = successor.g + 2;
			successors.add(successor);
		}
		
		else if (home == "CP") {
			successor = initialState.CgoStart(initialState);
			successor.setParentState(this);
			successor.g = 5;
			successor.f = successor.g + 5;
			successors.add(successor);
		}
		
		else if (home == "DP") {
			successor = initialState.DgoStart(initialState);
			successor.setParentState(this);
			successor.g = 10;
			successor.f = successor.g + 10;
			successors.add(successor);
		}
		
		return successors;
	}
	
	/** crosses A and B to home side */
	public State ABgoHome(State initialState) {
		
		State state = new State (depth, start, home, g, f);
		
		if (start == "ABCDP" && home == "" ) {
			state.start = "CD";
			state.home = "ABP";
		}
		
		else if (start == "ABCP" && home == "D" ) {
			state.start = "C";
			state.home = "ABDP";
		}
		
		else if (start == "ABDP" && home == "C" ) {
			state.start = "D";
			state.home = "ABCP";
		}
		
		else if (start == "ABP" && home == "CD" ) {
			state.start = "";
			state.home = "ABCDP";
		}
		return state;
	}
	
	/** crosses A and C to home side */
	public State ACgoHome(State initialState) {
		
		State state = new State (depth, start, home, g, f);
		
		if (start == "ABCDP" && home == "" ) {
			state.start = "BD";
			state.home = "ACP";
		}
		
		else if (start == "ABCP" && home == "D" ) {
			state.start = "B";
			state.home = "ACDP";
		}
		
		else if (start == "ACDP" && home == "B" ) {
			state.start = "D";
			state.home = "ABCP";
		}
		
		else if (start == "ACP" && home == "BD" ) {
			state.start = "";
			state.home = "ABCDP";
		}
		return state;
	}
	
	/** crosses A and D to home side */
	public State ADgoHome(State initialState) {
		
		State state = new State (depth, start, home, g, f);
		
		if (start == "ABCDP" && home == "" ) {
			state.start = "BC";
			state.home = "ADP";
		}
		
		else if (start == "ABDP" && home == "C" ) {
			state.start = "B";
			state.home = "ACDP";
		}
		
		else if (start == "ACDP" && home == "B" ) {
			state.start = "C";
			state.home = "ABDP";
		}
		
		else if (start == "ADP" && home == "BC" ) {
			state.start = "";
			state.home = "ABCDP";
		}
		return state;
	}
	
	/** crosses B and C to home side */
	public State BCgoHome(State initialState) {
		
		State state = new State (depth, start, home, g, f);
		
		if (start == "ABCDP" && home == "" ) {
			state.start = "AD";
			state.home = "BCP";
		}
		
		else if (start == "ABCP" && home == "D" ) {
			state.start = "A";
			state.home = "BCDP";
		}
		
		else if (start == "BCDP" && home == "A" ) {
			state.start = "D";
			state.home = "ABCP";
		}
		
		else if (start == "BCP" && home == "AD" ) {
			state.start = "";
			state.home = "ABCDP";
		}
		return state;
	}
	
	/** crosses B and D to home side */
	public State BDgoHome(State initialState) {
		
		State state = new State (depth, start, home, g, f);
		
		if (start == "ABCDP" && home == "" ) {
			state.start = "AC";
			state.home = "BDP";
		}
		
		else if (start == "ABDP" && home == "C" ) {
			state.start = "A";
			state.home = "BCDP";
		}
		
		else if (start == "BCDP" && home == "A" ) {
			state.start = "C";
			state.home = "ABDP";
		}
		
		else if (start == "BDP" && home == "AC" ) {
			state.start = "";
			state.home = "ABCDP";
		}
		return state;
	}
	
	/** crosses C and D to home side */
	public State CDgoHome(State initialState) {
		
		State state = new State (depth, start, home, g, f);
		
		if (start == "ABCDP" && home == "" ) {
			state.start = "AB";
			state.home = "CDP";
		}
		
		else if (start == "ACDP" && home == "B" ) {
			state.start = "A";
			state.home = "BCDP";
		}
		
		else if (start == "BCDP" && home == "A" ) {
			state.start = "B";
			state.home = "ACDP";
		}
		
		else if (start == "CDP" && home == "AB" ) {
			state.start = "";
			state.home = "ABCDP";
		}
		return state;
	}
	
  /** crosses A to start side */	
	public State AgoStart(State initialState) {
		
		State state = new State (depth, start, home, g, f);
		
		if (start == "B" && home == "ACDP" ) {
			state.start = "ABP";
			state.home = "CD";
		}
		
		else if (start == "C" && home == "ABDP" ) {
			state.start = "ACP";
			state.home = "BD";
		}
		
		else if (start == "D" && home == "ABCP" ) {
			state.start = "ADP";
			state.home = "BC";
		}
		
		else if (start == "BC" && home == "ADP" ) {
			state.start = "ABCP";
			state.home = "D";
		}
		
		else if (start == "BD" && home == "ACP" ) {
			state.start = "ABDP";
			state.home = "C";
		}
		
		else if (start == "CD" && home == "ABP" ) {
			state.start = "ACDP";
			state.home = "B";
		}
		return state;
	}
	
	/** crosses B to start side */
	public State BgoStart(State initialState) {
		
		State state = new State (depth, start, home, g, f);
		
		if (start == "A" && home == "BCDP" ) {
			state.start = "ABP";
			state.home = "CD";
		}
		
		else if (start == "C" && home == "ABDP" ) {
			state.start = "BCP";
			state.home = "AD";
		}
		
		else if (start == "D" && home == "ABCP" ) {
			state.start = "BDP";
			state.home = "AC";
		}
		
		else if (start == "AC" && home == "BDP" ) {
			state.start = "ABCP";
			state.home = "D";
		}
		
		else if (start == "AD" && home == "BCP" ) {
			state.start = "ABDP";
			state.home = "C";
		}
		
		else if (start == "CD" && home == "ABP" ) {
			state.start = "BCDP";
			state.home = "A";
		}
		return state;
	}
	
	/** crosses C to start side */
	public State CgoStart(State initialState) {
		
		State state = new State (depth, start, home, g, f);
		
		if (start == "A" && home == "BCDP" ) {
			state.start = "ACP";
			state.home = "BD";
		}
		
		else if (start == "B" && home == "ACDP" ) {
			state.start = "BCP";
			state.home = "AD";
		}
		
		else if (start == "D" && home == "ABCP" ) {
			state.start = "CDP";
			state.home = "AB";
		}
		
		else if (start == "AB" && home == "CDP" ) {
			state.start = "ABCP";
			state.home = "D";
		}
		
		else if (start == "AD" && home == "BCP" ) {
			state.start = "ACDP";
			state.home = "B";
		}
		
		else if (start == "BD" && home == "ACP" ) {
			state.start = "BCDP";
			state.home = "A";
		}
		return state;
	}
	
	/** crosses D to start side */
	public State DgoStart(State initialState) {
		
		State state = new State (depth, start, home, g, f);
		
		if (start == "A" && home == "BCDP" ) {
			state.start = "ADP";
			state.home = "BC";
		}
		
		else if (start == "B" && home == "ACDP" ) {
			state.start = "BDP";
			state.home = "AC";
		}
		
		else if (start == "C" && home == "ABDP" ) {
			state.start = "CDP";
			state.home = "AB";
		}
		
		else if (start == "AB" && home == "CDP" ) {
			state.start = "ABDP";
			state.home = "C";
		}
		
		else if (start == "AC" && home == "BDP" ) {
			state.start = "ACDP";
			state.home = "B";
		}
		
		else if (start == "BC" && home == "ADP" ) {
			state.start = "BCDP";
			state.home = "A";
		}
		return state;
	}
	
	/** returns parent state of state given */
	public State getParentState() {
		return parentState;
	}

  /** sets parent state of state given */
	public void setParentState(State parentState) {
		this.parentState = parentState;
	}
}