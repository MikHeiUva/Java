

package Harkkatyo;



import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.*;
import javax.swing.*;
import java.io.IOException;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.FileOutputStream;

/**
 * 
 * Created Mar 10, 2017
 * @author Mikael Heininen y104491 <a href="mailto:mikael.heininen@student.uwasa.fi">mikael.heininen@student.uwasa.fi</a>
 */
@SuppressWarnings("serial")
public class OptionMenu extends JFrame
{

		
		
		private JRadioButton tulostaVapaatAutot;
		private JRadioButton selaaVaraushistoriaa;
		private JRadioButton lisaaAuto;
		private JRadioButton liikevaihto;
		private JRadioButton lopetus;
		private JRadioButton PrintVapaat;
		private JRadioButton PrintVaratut;
		
		private ImageIcon logo10;
		private JLabel kuva10;
		private JPanel paneeli;
		private JPanel paneeli2;
		private JRadioButton siirryMaksamaan;
		
		/**
		 * For receiving Money objects.
		 */
		private Money n;
		/**
		 * For receiving RentList objects.
		 */
		private RentList r;
		/**
		 * For receiving HomeList objects.
		 */
		private HomeList u;
		
		
		/**
		 * Constructor is for transferring already earlier created Money, RentList and HomeList objects and creating graphical interface.
		 * @param b places it's value to Money variable n.
		 * @param g places it's value to RentList variable r.
		 * @param o places it's value to HomeList variable u.
		 */
		public OptionMenu(Money b, RentList g, HomeList o)
		{
			u=o;
			r = g;
			n = b;
			tulostaVapaatAutot = new JRadioButton("Selaa palautushistoriaa");
			selaaVaraushistoriaa = new JRadioButton("Selaa varaushistoriaa");
			lisaaAuto = new JRadioButton("Varaa/Palauta auto");
			liikevaihto = new JRadioButton("Näytä asiakkaan lasku");
			lopetus = new JRadioButton("Lopeta");
			PrintVapaat = new JRadioButton("Tulosta vapaat autot");
			PrintVaratut = new JRadioButton("Tulosta varatut autot");
			logo10 = new ImageIcon(getClass().getResource("hifis.jpg"));			
			kuva10 = new JLabel(logo10);	
			siirryMaksamaan = new JRadioButton("Siirry maksamaan");
		
			
			tulostaVapaatAutot.setFont(new Font("Serif", Font.PLAIN, 15));
			selaaVaraushistoriaa.setFont(new Font("Serif", Font.PLAIN, 15));
			lisaaAuto.setFont(new Font("Serif", Font.PLAIN, 15));
			liikevaihto.setFont(new Font("Serif", Font.PLAIN, 15));
			lopetus.setFont(new Font("Serif", Font.PLAIN, 15));
			siirryMaksamaan.setFont(new Font("Serif", Font.PLAIN, 15));
			PrintVapaat.setFont(new Font("Serif", Font.PLAIN, 15));
			PrintVaratut.setFont(new Font("Serif", Font.PLAIN, 15));
			
			ButtonGroup namiskat = new ButtonGroup();
			
			namiskat.add(tulostaVapaatAutot);
			namiskat.add(selaaVaraushistoriaa);
			namiskat.add(lisaaAuto);
			namiskat.add(liikevaihto);
			namiskat.add(lopetus);
			namiskat.add(siirryMaksamaan);
			namiskat.add(PrintVapaat);
			namiskat.add(PrintVaratut);
			
			
			tulostaVapaatAutot.addActionListener(new tulostusNappiKuuntelija());
			selaaVaraushistoriaa.addActionListener(new selaaNappiKuuntelija());	
			lisaaAuto.addActionListener(new lisaaNappiKuuntelija());
			liikevaihto.addActionListener(new liikevaihtoKuuntelija());
			lopetus.addActionListener(new lopetusNappiKuuntelija());
			siirryMaksamaan.addActionListener(new maksamaanNappiKuuntelija());
			PrintVapaat.addActionListener(new PrintNappiKuuntelija());
			PrintVaratut.addActionListener(new Print2NappiKuuntelija());
			
			paneeli = new JPanel(new FlowLayout());
			paneeli.add(siirryMaksamaan);
			paneeli.add(tulostaVapaatAutot);
			paneeli.add(selaaVaraushistoriaa);
			paneeli.add(PrintVapaat);
			paneeli.add(PrintVaratut);
			paneeli.add(lisaaAuto);
			paneeli.add(liikevaihto);
		
			paneeli.add(lopetus);
			
			
			
			paneeli2 = new JPanel(new FlowLayout());
			paneeli2.add(kuva10);
			
			this.setLayout(new BorderLayout());
			this.add(paneeli, BorderLayout.SOUTH);
			this.add(paneeli2, BorderLayout.NORTH);
			
			setTitle("Valikko");
			setSize(1300, 700);
			setLocation(50, 20);
			this.setDefaultCloseOperation(EXIT_ON_CLOSE);
			this.setVisible(true);
		}
		
		/**
		 * Print2NappiKuuntelija
		 * Created Mar 10, 2017
		 * @author Mikael Heininen y104491 <a href="mailto:mikael.heininen@student.uwasa.fi">mikael.heininen@student.uwasa.fi</a>
		 */
		private class Print2NappiKuuntelija implements ActionListener
		{
			/**
			 * If button is pressed.
			 * @param e
			 */
			public void actionPerformed(ActionEvent e)
			{
				r.PrintRentList();
				//OptionMenu t = new OptionMenu(n, r, u);
			}
		}	
		
		/**
		 * PrintNappiKuuntelija
		 * Created Mar 10, 2017
		 * @author Mikael Heininen y104491 <a href="mailto:mikael.heininen@student.uwasa.fi">mikael.heininen@student.uwasa.fi</a>
		 */
		private class PrintNappiKuuntelija implements ActionListener
		{
			/**
			 * If button is pressed.
			 * @param e
			 */
			public void actionPerformed(ActionEvent e)
			{
				
				u.PrintHomeList();
				
			}
		}	
		
		/**
		 * maksamaanNappiKuuntelija
		 * Created Mar 10, 2017
		 * @author Mikael Heininen y104491 <a href="mailto:mikael.heininen@student.uwasa.fi">mikael.heininen@student.uwasa.fi</a>
		 */
		private class maksamaanNappiKuuntelija implements ActionListener
		{
			/**
			 * If button is pressed.
			 * @param e
			 */
			public void actionPerformed(ActionEvent e)
			{
				if(e.getActionCommand().equals("Siirry maksamaan"))
				{
				@SuppressWarnings("unused")
				HifisMain b = new HifisMain(n, r, u);
				setVisible(false);
				}
			}
		}	
		
		/**
		 * tulostusNappiKuuntelija
		 * Created Mar 10, 2017
		 * @author Mikael Heininen y104491 <a href="mailto:mikael.heininen@student.uwasa.fi">mikael.heininen@student.uwasa.fi</a>
		 * 
		 *
		 */
		private class tulostusNappiKuuntelija implements ActionListener
		{
			/**
			 * If button is pressed, printing text file.
			 * @param e
			 */
			public void actionPerformed(ActionEvent e)
			{
				if(e.getActionCommand().equals("Selaa palautushistoriaa"));
				{
					BufferedReader lukija = null;
			
					try
					{
						lukija = new BufferedReader(new FileReader("PalautetutAutot.txt"));
				
						String rivi = lukija.readLine();
						while(rivi != null)
						{
							JOptionPane.showMessageDialog(null, rivi);
							rivi = lukija.readLine();
						}
						lukija.close();
					}
			
					catch(FileNotFoundException o)
					{
						JOptionPane.showMessageDialog(null, "Ei palautettuja autoja, katso onko varauksia");
						
					}
			
					catch(IOException ioe)
					{
						JOptionPane.showMessageDialog(null, "Virhe I/O");
					}
					
					
				}	
			}
		}
		
		/**
		 * selaaNappiKuuntelija
		 * Created Mar 10, 2017
		 * @author Mikael Heininen y104491 <a href="mailto:mikael.heininen@student.uwasa.fi">mikael.heininen@student.uwasa.fi</a>
		 */
		private class selaaNappiKuuntelija implements ActionListener
		{
			/**
			 * If button is pressed, printing text file.
			 * @param e
			 */
			public void actionPerformed(ActionEvent e)
			{
				if(e.getActionCommand().equals("Selaa varaushistoriaa"));
				{
					BufferedReader lukija2 = null;
			
					try
					{
						lukija2 = new BufferedReader(new FileReader("VaratutAutot.txt"));
				
						String rivi = lukija2.readLine();
						while(rivi != null)
						{
							JOptionPane.showMessageDialog(null, rivi);
							rivi = lukija2.readLine();
						}
						lukija2.close();
					}
			
					catch(FileNotFoundException o)
					{
						JOptionPane.showMessageDialog(null, "Ei varattuja autoja, kaikki autot varattavissa");
						
					}
			
					catch(IOException ioe)
					{
						JOptionPane.showMessageDialog(null, "Virhe I/O");
					}
					
					
				}	
			}
			
		}	
		

		/**
		 * lisaaNappiKuuntelija
		 * Created Mar 10, 2017
		 * @author Mikael Heininen y104491 <a href="mailto:mikael.heininen@student.uwasa.fi">mikael.heininen@student.uwasa.fi</a>
		 */
		private class lisaaNappiKuuntelija implements ActionListener
		{
			/**
			 * If button is pressed.
			 * @param e
			 */
			public void actionPerformed(ActionEvent e)
			{
				if(e.getActionCommand().equals("Varaa/Palauta auto"))
				{
				@SuppressWarnings("unused")
				Checking t = new Checking(n, r, u);	
				
				setVisible(false);
				}
			}
		}
		
		/**
		 * liikevaihtoKuuntelija
		 * Created Mar 10, 2017
		 * @author Mikael Heininen y104491 <a href="mailto:mikael.heininen@student.uwasa.fi">mikael.heininen@student.uwasa.fi</a>
		 */
		private class liikevaihtoKuuntelija implements ActionListener
		{
			/**
			 * If button is pressed.
			 * @param e
			 */
			public void actionPerformed(ActionEvent e)
			{
				if(e.getActionCommand().equals("Näytä asiakkaan lasku"))
				{
					
					double m = n.returnMoney();
					JOptionPane.showMessageDialog(null, "Lasku:" + m + "Euroa");
					
					@SuppressWarnings("unused")
					OptionMenu z = new OptionMenu(n, r, u);
					setVisible(false);
					
					
				}
			}
		}	
		
		/**
		 * lopetusNappiKuuntelija
		 * Created Mar 10, 2017
		 * @author Mikael Heininen y104491 <a href="mailto:mikael.heininen@student.uwasa.fi">mikael.heininen@student.uwasa.fi</a>
		 */
		private class lopetusNappiKuuntelija implements ActionListener
		{
			/**
			 * If button is pressed.
			 * @param e
			 */
			public void actionPerformed(ActionEvent e)
			{
				
				
				if(e.getActionCommand().equals("Lopeta"))
				{
				u.save();
				r.save2();
				@SuppressWarnings("unused")
				End l = new End();
				setVisible(false);
				}
			}
		}

	
}
