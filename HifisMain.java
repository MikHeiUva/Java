package Harkkatyo;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.awt.*;
import javax.swing.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 * 
 * Created Mar 10, 2017
 * @author Mikael Heininen y104491 <a href="mailto:mikael.heininen@student.uwasa.fi">mikael.heininen@student.uwasa.fi</a>
 */
@SuppressWarnings("serial")
public class HifisMain extends JFrame

{
	
	private JButton OkNappi;
	private JLabel EkaLause;
	private JLabel TokaLause;
	private JLabel kuva;
	private ImageIcon logo;
	private JPanel paneeli;
	private JPanel paneeli2;
	private JButton maksu;
	private JButton maksu2;
	
	/**
	 * For receiving Money objects.
	 */
	private Money h;
	/**
	 * For receiving RentList objects.
	 */
	private RentList b;
	/**
	 * For receiving HomeList objects.
	 */
	private HomeList q;
	
	
	/**
	 * Constructor is for transferring already earlier created Money, RentList and HomeList objects and creating graphical interface.
	 * @param w places it's value to Money variable h.
	 * @param f places it's value to RentList variable b.
	 * @param n places it's value to HomeList variable q.
	 */
	public HifisMain(Money w, RentList f, HomeList n)
	{ 
		h = w;
		b = f;
		q = n;
	
		OkNappi = new JButton("Jatka");
		EkaLause = new JLabel("Tervetuloa Hifis autonvuokrausjarjestelmaan.");
		TokaLause = new JLabel("Seuraa nayton ohjeita! Asiakas voi maksaa myos tilisiirrolla: " + " ");
		logo = new ImageIcon(getClass().getResource("hifis.jpg"));
		kuva = new JLabel(logo);
		maksu = new JButton("Siirry osuuspankkiin");
		maksu2 = new JButton("Siirry nordeaan");
		
		EkaLause.setFont(new Font("Serif", Font.PLAIN, 15));
		TokaLause.setFont(new Font("Serif", Font.PLAIN, 15));
		OkNappi.setFont(new Font("Serif", Font.PLAIN, 15));
		maksu.setFont(new Font("Serif", Font.PLAIN, 15));
		maksu2.setFont(new Font("Serif", Font.PLAIN, 15));
		
		
		OkNappi.addActionListener(new OkNappiKuuntelija());
		maksu.addActionListener(new maksuNappiKuuntelija());
		maksu2.addActionListener(new maksu2NappiKuuntelija());
		
		paneeli = new JPanel(new FlowLayout());
		
		paneeli.add(EkaLause);
		paneeli.add(TokaLause);
		paneeli.add(OkNappi);
		paneeli.add(maksu);
		paneeli.add(maksu2);
	
		paneeli2 = new JPanel(new FlowLayout());
		paneeli2.add(kuva);
		
		this.setLayout(new BorderLayout());
		this.add(paneeli, BorderLayout.SOUTH);
		this.add(paneeli2, BorderLayout.NORTH);
		
		setTitle("Hifis autonvuokrausjarjestelma");
		setSize(1300, 700);
		setLocation(50, 20);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
	
	}
	
	/**
	 * maksuNappiKuuntelija
	 * Created Mar 10, 2017
	 * @author Mikael Heininen y104491 <a href="mailto:mikael.heininen@student.uwasa.fi">mikael.heininen@student.uwasa.fi</a>
	 */
	private class maksuNappiKuuntelija implements ActionListener			
	{
		/**
		 * If button is pressed.
		 * @param e
		 */
		public void actionPerformed(ActionEvent e)
		{
			if(e.getActionCommand().equals("Siirry osuuspankkiin"))
			{
				Desktop d = Desktop.getDesktop();
				try {
					d.browse(new URI("https://www.op.fi/op"));
				} catch (IOException e1) {
					
					e1.printStackTrace();
				} catch (URISyntaxException e1) {
					
					e1.printStackTrace();
				}
			}
		}
	}	
	
	/**
	 * maksu2NappiKuuntelija
	 * Created Mar 10, 2017
	 * @author Mikael Heininen y104491 <a href="mailto:mikael.heininen@student.uwasa.fi">mikael.heininen@student.uwasa.fi</a>
	 */
	private class maksu2NappiKuuntelija implements ActionListener			
	{
		/**
		 * If button is pressed.
		 * @param e
		 */
		public void actionPerformed(ActionEvent e)
		{
			if(e.getActionCommand().equals("Siirry nordeaan"))
			{
				Desktop d = Desktop.getDesktop();
				try {
					d.browse(new URI("https://www.nordea.fi/"));
				} catch (IOException e1) {
					
					e1.printStackTrace();
				} catch (URISyntaxException e1) {
					
					e1.printStackTrace();
				}
			}
		}
	}	
	
	/**
	 * OkNappiKuuntelija
	 * Created Mar 10, 2017
	 * @author Mikael Heininen y104491 <a href="mailto:mikael.heininen@student.uwasa.fi">mikael.heininen@student.uwasa.fi</a>
	 */
	private class OkNappiKuuntelija implements ActionListener			
	{
		/**
		 * If button is pressed.
		 * @param e
		 */
		public void actionPerformed(ActionEvent e)
		{
			if(e.getActionCommand().equals("Jatka"))
			{
			
			
			
			
			@SuppressWarnings("unused")
			OptionMenu va = new OptionMenu(h, b, q);
			setVisible(false);
			}
		}
	}
	
	

	public static void main(String args[]) throws Exception
	{
		
	/**
	 * Creating ArrayLists for keeping track of reserved and not-reserved cars. Object v holds the information about the customer's bill.	
	 */
	Money v = new Money();
	RentList u = new RentList();
	HomeList z = new HomeList();
	
	/**
	*Uploading cars from text file SavedHomeList to HomeList
	*/
	BufferedReader lukija = null;
	
			
		try
			{
				lukija = new BufferedReader(new FileReader("SavedHomeList.txt"));
				
					String rivi = lukija.readLine();
					while(rivi != null)
					{
						Car q = new Car(rivi);
						z.Add(q);
						rivi = lukija.readLine();
					}
						lukija.close();
			}
			/**
			*if program is started the first time, adding company's cars to HomeList
			*/
					catch(FileNotFoundException o)
					{
						Car p = new Car("Peugeot 407");
						Car j = new Car("VW Golf");
						Car t = new Car("Audi A3");
						z.Add(p);
						z.Add(j);
						z.Add(t);
						
					}
			
					catch(IOException ioe)
					{
						JOptionPane.showMessageDialog(null, "Virhe I/O");
					}
		

	/**
	*Uploading cars from text file SavedRentList to RentList
	*/	
	BufferedReader lukija2 = null;
	
			
		try
			{
				lukija2 = new BufferedReader(new FileReader("SavedRentList.txt"));
				
					String rivi2 = lukija2.readLine();
					while(rivi2 != null)
					{
						Car m = new Car(rivi2);
						u.Add(m);
						rivi2 = lukija2.readLine();
					}
						lukija2.close();
			}
					
					/**
					*if program is started the first time
					*/
					catch(FileNotFoundException o)
					{
						JOptionPane.showMessageDialog(null, "Ohjelma avataan ensimmaista kertaa...");
						
					}
			
					catch(IOException ioe)
					{
						JOptionPane.showMessageDialog(null, "Virhe I/O");
					}				
					
			
	
		
	new HifisMain(v, u, z);
	
	}	
	
	
}
