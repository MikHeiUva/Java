package Harkkatyo;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.io.PrintWriter;
import java.io.FileOutputStream;
/**
 * 
 * Created Mar 10, 2017
 * @author Mikael Heininen y104491 <a href="mailto:mikael.heininen@student.uwasa.fi">mikael.heininen@student.uwasa.fi</a>
 */
public class RentList 
{
	/**
	 * ArrayList called list saving Car objects.
	 */
	private ArrayList<Car> list;
		
	/**
	 * Constructor is for creating ArrayList called list which saves Car objects.
	 */
	public RentList()
	{
		list = new ArrayList<Car>();
	}
	
	/**
	 * Adds e to RentList
	 * @param e the e to add to RentList.
	 */
	public void Add(Car e)
	{
		list.add(e);
	}
	
	/**
	 * Removes e from RentList.
	 * @param b the b to remove from RentList.
	 */
	public void Remove(Car b)
	{
		list.remove(b);		
	}
	
	/**
	 * 
	 * Checks if RentList is empty, if so notes user from that.
	 * If RentList is not empty then prints it.
	 */
	public void PrintRentList()
	{
		if(list.isEmpty())
		{
			JOptionPane.showMessageDialog(null, "Ei varattuja autoja!");
		}
		
		for(Car u: list)
		{
			JOptionPane.showMessageDialog(null, u);
		}
	}
	
	
	/**
	*Method for saving RentList to a text file called SavedRentList
	*/
	public void save2()
	{
		PrintWriter v = null;
		try{
		v = new PrintWriter(new FileOutputStream("SavedRentList.txt"));
		}
		catch(Exception b)
		{
		JOptionPane.showMessageDialog(null, "Virhe luonnissa");
		}
		for(Car h: list)
		{
		v.println(h);
		}
		v.close();
	}
	
}
