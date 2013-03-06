import java.util.Comparator;
import java.util.PriorityQueue;

public class Congress
{
	public int compare(State s1, State s2)
	{
		return s1.compareTo(s2);
	}

	public static void main(String[] args)
	{
		String[] strings = new In(args[0]).readAll().split("\\n");					//We accumulate a string array containing each seperate line in the file.
		
		int stateAmount = Integer.parseInt(strings[0]);
		int seatsLeft = Integer.parseInt(strings[1]);
		PriorityQueue<State> pq = new PriorityQueue<>();
		
		Stopwatch timer = new Stopwatch();
		
		for(int i=2; i<strings.length; i+=2)
		{
			pq.add(new State(strings[i], Integer.parseInt(strings[i+1])));
		}
		
		seatsLeft -= stateAmount;
		
		while(seatsLeft > 0)
		{			
			State currState = pq.poll();
			currState.incrementSeats();
			seatsLeft--;
			pq.add(currState);
		}
		
		while(pq.size() > 0)
		{
			State currState = pq.poll();
		
			StdOut.println(currState.getName()+" "+currState.getSeats());
		}
		
		StdOut.println("elapsed time = " + timer.elapsedTime());	
	}
}