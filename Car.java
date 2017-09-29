package Harkkatyo;

import java.util.Objects;

/**
 * 
 * Created Mar 10, 2017
 * @author Mikael Heininen y104491 <a href="mailto:mikael.heininen@student.uwasa.fi">mikael.heininen@student.uwasa.fi</a>
 */
public class Car 
{
	
	/**
	 * Holding information about the type of the Car object.
	 */
	String type;
	
	/**
	 * Constructor is for creating Car objects.
	 * @param b places it's value to String variable type.
	 */
	public Car(String b)
	{
		this.type = b;
	}
	/**
	*Method for returning name.
	*@return type
	*/
	public String getName()
	{
		return type;
	}
	
	/**
	 * Override toString method.
	 * @return type
	 */
	@Override public String toString()
	{
		return type;
	}
	
	/**
	 * Override equals method.
	 * @return type.equals(other.type)
	 */
	public boolean equals(Object o) {
		  if (!(o instanceof Car)) {
		    return false;
		  }
		  Car other = (Car) o;
		  return type.equals(other.type);
		}

	/**
	 * Override hashCode.
	 * @return hash
	 */
	@Override 
	public int hashCode()
	{
		int hash = 7;
		hash = 31 * hash + Objects.hashCode(this.type);
		return hash;
	}
	
}
