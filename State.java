public class State implements Comparable<State>
{
	private String name;
	private int population;
	private int seats = 1;

	public State(String name, int population)
	{
		this.name = name;
		this.population = population;
	}
	
	public double getPriority()
	{
		return (population/(Math.sqrt(seats*(seats+1))));
	}
	
	public String getName()
	{
		return name;
	}
	
	public int getSeats()
	{
		return seats;
	}
	
	public int compareTo(State other)
	{
		return (int)Math.round(other.getPriority() - getPriority());
	}
	
	public void incrementSeats()
	{
		seats++;
	}
}