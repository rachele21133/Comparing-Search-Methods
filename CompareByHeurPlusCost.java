import java.util.Comparator;

/** compares path cost + heuristics of two states and 
	returns 1 if state 1 has greater path cost + heuristics than state 2
	0 if state 1 and state 2 path cost + heuristics are equal
	and -1 if state 1 has less path cost + heuristics than state 2 */

public class CompareByHeurPlusCost implements Comparator<State> {

    public int compare(State state1, State state2) {
        return (state1.f - state2.f);
    }
}