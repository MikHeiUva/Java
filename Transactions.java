package Harkkatyo;


import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.PrintWriter;
import java.io.FileOutputStream;
import java.awt.*;
import javax.swing.*;
import java.io.BufferedReader;
import java.util.Date;

/**
 * 
 * Created Mar 10, 2017
 * @author Mikael Heininen y104491 <a href="mailto:mikael.heininen@student.uwasa.fi">mikael.heininen@student.uwasa.fi</a>
 */
@SuppressWarnings("serial")
public class Transactions extends JFrame
{
	
	
	
	/**
	 * for the total cost of AudiA3.
	 */
	double hintaAudiA3 = 33.00; //per day
	/**
	 * for the total cost of Peugeot 407.
	 */
	double hintaPeugeot407 = 27.00; //per day
	/**
	 * for the total cost of VW Golf.
	 */
	double hintaVWGolf = 24.00;		//per day
	
	private JLabel tiedot;
	private JLabel tiedot2;
	private JLabel Aika;
	private JLabel nimi;
	
	private JTextField txtTiedot;
	private JTextField txtAika;
	private JTextField txtNimi;
	
	
	private JButton lisays;
	private JButton poisto;
	
	private ImageIcon logo4;
	private JLabel kuva4;
	
	private JPanel paneeli;
	private JPanel paneeli2;
	/**
	 * For receiving RentList objects.
	 */
	private RentList k;
	/**
	 * For receiving HomeList objects.
	 */
	private HomeList x;
	
	/**
	 * to get the Date.
	 */
	Date date = new Date();
	
	
	/**
	 * For receiving Money objects.
	 */
	private Money w;
	
	/**
	 * Constructor is for transferring already earlier created Money, RentList and HomeList objects and creating graphical interface.
	 * @param p places it's value to Money variable w.
	 * @param j places it's value to RentList variable k.
	 * @param c places it's value to HomeList variable x.
	 */
	public Transactions(Money p, RentList j, HomeList c)
	{
		x=c;
		k=j;
		w=p;
		
		tiedot = new JLabel("Anna merkki ja malli:");
		Aika = new JLabel("Anna varausaika paivina:");
		nimi = new JLabel("Anna tyonumerosi:");
		tiedot2 = new JLabel("Automme: Peugeot 407, Audi A3, VW Golf");
		tiedot2.setFont(new Font("Calibri", Font.PLAIN, 15));
		
		tiedot.setFont(new Font("Serif", Font.PLAIN, 15));
		Aika.setFont(new Font("Serif", Font.PLAIN, 15));
		nimi.setFont(new Font("Serif", Font.PLAIN, 15));
		
		txtTiedot = new JTextField(10);
		txtAika = new JTextField(10);
		txtNimi = new JTextField(10);
		
		
		
		lisays = new JButton("Palauta auto");
		poisto = new JButton("Varaa auto");
		
		lisays.setFont(new Font("Serif", Font.PLAIN, 15));
		poisto.setFont(new Font("Serif", Font.PLAIN, 15));
		
		logo4 = new ImageIcon(getClass().getResource("hifis.jpg"));
		kuva4 = new JLabel(logo4);
		
		lisays.addActionListener(new ValintaNappiKuuntelija());
		poisto.addActionListener(new poistoNappiKuuntelija());
		
		paneeli = new JPanel(new FlowLayout());
		paneeli.add(tiedot2);
		paneeli.add(nimi);
		paneeli.add(txtNimi);
		paneeli.add(tiedot);
		paneeli.add(txtTiedot);
		paneeli.add(lisays);
		
		paneeli.add(Aika);
		paneeli.add(txtAika);
		paneeli.add(poisto);
	
		paneeli2 = new JPanel(new FlowLayout());
		paneeli2.add(kuva4);
		
		this.setLayout(new BorderLayout());
		this.add(paneeli, BorderLayout.SOUTH);
		this.add(paneeli2, BorderLayout.NORTH);
		
		
		
		
		setTitle("Anna tiedot");
		setSize(1300, 700);
		setLocation(50, 20);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	
	/**
	 * ValintaNappiKuuntelija
	 * Created Mar 10, 2017
	 * @author Mikael Heininen y104491 <a href="mailto:mikael.heininen@student.uwasa.fi">mikael.heininen@student.uwasa.fi</a>
	 */
	private class ValintaNappiKuuntelija implements ActionListener			
	{
			
		/**
		 * If button is pressed.
		 * @param e
		 */
		public void actionPerformed(ActionEvent e)
		{
				
			
			
			
			PrintWriter a = null;
			@SuppressWarnings("unused")
			BufferedReader b = null;
			String tiedot2 = (txtTiedot.getText());
			
			/**
			*Check if typing is correct.
			*/
			if((tiedot2.equals("Peugeot 407")) || (tiedot2.equals("Audi A3")) || (tiedot2.equals("VW Golf")))
			{
			Car d = new Car(txtTiedot.getText());
			
			/**
			*Check if car d is in HomeList.
			*/
			int c = x.CheckPrintHomeList(d);
			/**
			*If car d is not in HomeList 
			*/
			if(c==0)
			{
				k.Remove(d);		//k = RentList olio
				x.Add(d);			//x = HomeList olio
			}
			/**
			*If car d is in HomeList
			*/
			else
			{
				JOptionPane.showMessageDialog(null, "Auto on palautettuna!");
				return;
			}
			
			
			
			try
			{
			
				
				a = new PrintWriter(new FileOutputStream("PalautetutAutot.txt", true));
				 
			}
						
			catch(Exception o)
			{
			JOptionPane.showMessageDialog(null, "Virhe luonnissa");	
			System.exit(0);
			}
			
			
			
			
			a.print("Palautuksen hallinnoija: " + " " + txtNimi.getText() + " " +"Auto:"+ tiedot2 +" "+ "Palautettu: " + date.toString());
			a.println();

			a.close();
			JOptionPane.showMessageDialog(null, "Palautit auton" +" " + tiedot2);
			@SuppressWarnings("unused")
			OptionMenu ikkuna = new OptionMenu(w, k, x);
			setVisible(false);
			}
			
			
			/**
			*If typing is incorrect.
			*/
			else
			{
				JOptionPane.showMessageDialog(null, "Meillä ei edes ole kyseistä autoa!");
				
			}
			
			
		}
	}
	
	/**
	 * poistoNappiKuuntelija
	 * Created Mar 10, 2017
	 * @author Mikael Heininen y104491 <a href="mailto:mikael.heininen@student.uwasa.fi">mikael.heininen@student.uwasa.fi</a>
	 */
	private class poistoNappiKuuntelija implements ActionListener			
	{
		/**
		 * If button is pressed.
		 * @param e
		 */
		public void actionPerformed(ActionEvent e)
		{
	
	
	PrintWriter a = null;
	@SuppressWarnings("unused")
	BufferedReader b = null;
	String tiedot2 = (txtTiedot.getText());
	
	/**
	*Check if typing is correct.
	*/
	if((tiedot2.equals("Peugeot 407")) || (tiedot2.equals("Audi A3")) || (tiedot2.equals("VW Golf")))
	{
	
	Car y = new Car(txtTiedot.getText());
	
	/**
	*Check if car y is in HomeList
	*/
	int r = x.CheckPrintHomeList(y);
	/**
	*If car y is not in HomeList.
	*/
	if(r == 1)
	{
	k.Add(y);			//k = RentList olio
	x.Remove(y);		//x = HomeList olio
	}
	/**
	*If car y is in HomeList
	*/
	if(r==0)
	{
		JOptionPane.showMessageDialog(null, "Auto on varattuna!");
		return;
	}
	
	try
	{
	
		
		a = new PrintWriter(new FileOutputStream("VaratutAutot.txt", true));
		 
	}
				
	catch(Exception o)
	{
	JOptionPane.showMessageDialog(null, "Virhe luonnissa");	
	System.exit(0);
	}
	
	
	
	if(tiedot2.equals("Audi A3"))
	{
		double d = Double.parseDouble(txtAika.getText());
		double hinta1 = hintaAudiA3*d;
		w.addMoney(hinta1);
		a.print("Varauksen hallinnoija:" + " " + txtNimi.getText() + " " +"Auto:"+ tiedot2 + " " + "Varattu: "+ date.toString() +  " "+txtAika.getText() +". " + "Paivan ajaksi" +" "+ "Hinta:" + hinta1 + "Euroa" );
		a.println();
		a.close();
		
		JOptionPane.showMessageDialog(null, "Varasit asiakkaalle auton:" +" " + tiedot2+" "+ txtAika.getText() +  "paivan ajaksi" +" "+ "Hinnaksi tuli:" + hinta1 + "Euroa.");
		@SuppressWarnings("unused")
		OptionMenu ikkuna = new OptionMenu(w, k, x);
		setVisible(false);
	}	
	
	
	else if(tiedot2.equals("Peugeot 407"))
	{
		double d2 = Double.parseDouble(txtAika.getText());
		double hinta2 = hintaPeugeot407*d2;
		w.addMoney(hinta2);
		a.print("Varauksen hallinnoija:" + " " + txtNimi.getText() + " " +"Auto:"+ tiedot2 + " " + "Varattu: "+ date.toString() +  " "+txtAika.getText() +". " + "Paivan ajaksi" +" "+ "Hinta:" + hinta2 + "Euroa");
		a.println();
		a.close();
		
		JOptionPane.showMessageDialog(null, "Varasit asiakkaalle auton:" +" " + tiedot2+" "+ txtAika.getText() +  "paivan ajaksi" +" "+ "Hinnaksi tuli: " + hinta2 + "Euroa");
		@SuppressWarnings("unused")
		OptionMenu ikkuna = new OptionMenu(w, k, x);
		setVisible(false);
	}
	
	
	else if(tiedot2.equals("VW Golf"))
	{
		double d3 = Double.parseDouble(txtAika.getText());
		double hinta3 = hintaVWGolf*d3;
		w.addMoney(hinta3);
		a.print("Varauksen hallinnoija:" + " " + txtNimi.getText() + " " +"Auto:"+ tiedot2 + " " + "Varattu: "+ date.toString() +  " "+txtAika.getText() +". " + "Paivan ajaksi"+" "+ "Hinta:" + hinta3 + "Euroa");
		a.println();
		a.close();
		
		JOptionPane.showMessageDialog(null, "Varasit asiakkaalle auton:" +" " + tiedot2+" "+ txtAika.getText() +  "paivan ajaksi" +" "+ "Hinnaksi tuli: " + hinta3 + "Euroa");
		@SuppressWarnings("unused")
		OptionMenu ikkuna = new OptionMenu(w, k, x);
		setVisible(false);
	}

	else
	{
		JOptionPane.showMessageDialog(null, "Kirjoititko oikein?");
	}
	
	
	
	}
	
	/**
	*If typing is incorrect.
	*/
	else
	{
		JOptionPane.showMessageDialog(null, "Meillä ei edes ole kyseistä autoa!");
	}
	
	}
	}
	
	
}
