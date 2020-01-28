import java.util.Comparator;

/** compares depth of two states and 
	returns 1 if state 1 has greater depth than state 2
	0 if state 1 and state 2 depths are equal
	and -1 if state 1 has less depth than state 2 */

public class CompareByDepthAscend implements Comparator<State> {

    public int compare(State state1, State state2) {
        return (state1.depth - state2.depth);
    }
}