package Harkkatyo;


import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.*;
import javax.swing.*;

/**
 * 
 * Created Mar 10, 2017
 * @author Mikael Heininen y104491 <a href="mailto:mikael.heininen@student.uwasa.fi">mikael.heininen@student.uwasa.fi</a>
 */
@SuppressWarnings("serial")
public class Checking extends JFrame
{
	
	private JRadioButton siirryVaraus;
	private JRadioButton siirryAlkuikkuna;
	private ImageIcon logo10;
	private JLabel kuva10;
	private JPanel paneeli;
	private JPanel paneeli2;
	private JLabel teksti;
	/**
	 * For receiving RentList objects.
	 */
	private RentList w;
	/**
	 * For receiving HomeList objects.
	 */
	private HomeList s;
	
	/**
	 * For receiving Money objects.
	 */
	private Money l;
	
	/**
	 * Constructor is for transferring already earlier created Money, RentList and HomeList objects and creating graphical interface.
	 * @param y places it's value to Money variable l.
	 * @param h places it's value to RentList variable w.
	 * @param f places it's value to HomeList variable s.
	 */
	public Checking(Money y, RentList h, HomeList f) 
	{
		s=f;
		w = h;
		l = y;
		siirryVaraus = new JRadioButton("Kylla");
		siirryAlkuikkuna = new JRadioButton("En");
		
		teksti = new JLabel("Varmistitko selaamalla vapaita autoja että auto on vapaana?");
		
		teksti.setFont(new Font("Serif", Font.PLAIN, 15));
		siirryVaraus.setFont(new Font("Serif", Font.PLAIN, 15));
		siirryAlkuikkuna.setFont(new Font("Serif", Font.PLAIN, 15));
		
		
		logo10 = new ImageIcon(getClass().getResource("hifis.jpg"));
		kuva10 = new JLabel(logo10);
		
		ButtonGroup namiskat = new ButtonGroup();
		namiskat.add(siirryVaraus);
		namiskat.add(siirryAlkuikkuna);
		
		siirryVaraus.addActionListener(new varausKuuntelija());
		siirryAlkuikkuna.addActionListener(new alkuikkunaKuuntelija());
		
		paneeli = new JPanel(new FlowLayout());
		paneeli.add(teksti);
		
		paneeli.add(siirryVaraus);
		paneeli.add(siirryAlkuikkuna);
		
	
		paneeli2 = new JPanel(new FlowLayout());
		paneeli2.add(kuva10);
		
		this.setLayout(new BorderLayout());
		this.add(paneeli, BorderLayout.SOUTH);
		this.add(paneeli2, BorderLayout.NORTH);
		
		setTitle("Tarkistus");
		setSize(1300, 700);
		setLocation(50, 20);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	/**
	 * varausKuuntelija
	 * Created Mar 10, 2017
	 * @author Mikael Heininen y104491 <a href="mailto:mikael.heininen@student.uwasa.fi">mikael.heininen@student.uwasa.fi</a>
	 */
	private class varausKuuntelija implements ActionListener
	{
		/**
		 * If button is pressed.
		 * @param e
		 */
		public void actionPerformed(ActionEvent e)
		{
			if(e.getActionCommand().equals("Kylla"))
			{
			@SuppressWarnings("unused")
			Transactions g = new Transactions(l, w, s);
			setVisible(false);
			}
			
		}
	}
	
	/**
	 * alkuikkunaKuuntelija
	 * Created Mar 10, 2017
	 * @author Mikael Heininen y104491 <a href="mailto:mikael.heininen@student.uwasa.fi">mikael.heininen@student.uwasa.fi</a>
	 */
	private class alkuikkunaKuuntelija implements ActionListener
	{
		/**
		 * If button is pressed.
		 * @param e
		 */
		public void actionPerformed(ActionEvent e)
		{	
			if(e.getActionCommand().equals("En"))
			{
			JOptionPane.showMessageDialog(null, "Selaa seuraavasta valikosta vapaita autoja!");		
			
			@SuppressWarnings("unused")
			OptionMenu a = new OptionMenu(l, w, s);
			setVisible(false);
			
			}
		
		}
	}
	
}
