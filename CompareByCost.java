import java.util.Comparator;

/** compares path cost of two states and 
	returns 1 if state 1 has greater path cost than state 2
	0 if state 1 and state 2 path costs are equal
	and -1 if state 1 has less path cost than state 2 */

public class CompareByCost implements Comparator<State> {

    public int compare(State state1, State state2) {
        return (state1.g - state2.g);
    }
}