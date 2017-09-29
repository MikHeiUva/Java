package Harkkatyo;

/**
 * 
 * Created Mar 10, 2017
 * @author Mikael Heininen y104491 <a href="mailto:mikael.heininen@student.uwasa.fi">mikael.heininen@student.uwasa.fi</a>
 */


public class Money 
{
	/**
	 * The total cost for customer.
	 */
	private double total = 0;
	
	/**
	 * 'Money' constructor for creating Money object
	 */
	public Money()
	{
		
	}
	
	/**Adds r to total
	 * @param r the r to add to total.
	 */
	public void addMoney(double r)
	{
		total = total + r;
	}
	
	
	/**Returns the variable 'total'.
	 * @return total.
	 */
	public double returnMoney()
	{
		return total;
	}
}
