import java.util.Comparator;
import java.util.PriorityQueue;

public class Congress
{
	public static void main(String[] args)
	{
		String[] strings = new In(args[0]).readAll().split("\\n");					//We accumulate a string array containing each seperate line in the file.
		
		int stateAmount = Integer.parseInt(strings[0]);								//According to proper syntax of the input file, the first line is the amount of states
		int seatsLeft = Integer.parseInt(strings[1]);								//According to proper syntax of the input file, the first line is the amount of seats
		PriorityQueue<State> pq = new PriorityQueue<>();							//We initialize the priority queue, containing the custom class state
		
		Stopwatch timer = new Stopwatch();											//We begin our stopwatch
		
		for(int i=2; i<strings.length; i+=2)
		{
			pq.add(new State(strings[i], Integer.parseInt(strings[i+1])));			//According to proper syntax of the input file, each pair of lines represent the name of and the population of the state respetively
		}
		
		seatsLeft -= stateAmount;													//We withdraw the amount of states from the amount of seats (all states are initialized with 1 seat
		
		//We now allocate the remaining amount of seats
		while(seatsLeft > 0)
		{			
			State currState = pq.poll();											//We pull the state with the highest priority
			currState.incrementSeats();												//We add one seat to the state
			seatsLeft--;															//We subtract 1 from the total amount of seats left
			pq.add(currState);														//We re-add the state to the queue, in order to reorder the queue according to the new priority of the state
		}
		
		//We now print out all the states
		while(pq.size() > 0)
		{
			State currState = pq.poll();
			StdOut.println(currState.getName()+" "+currState.getSeats());			//We print the state name and its seats according to proper syntax
		}
		
		StdOut.println("elapsed time = " + timer.elapsedTime());					//We print out the total amount of time the processing took
	}
}