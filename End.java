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
public class End extends JFrame
{
	private JButton Lopetus;
	private JLabel LoppuLause;
	private JLabel LoppuLause2;
	private ImageIcon logo2;
	private JLabel kuva2;
	private JPanel paneeli;
	private JPanel paneeli2;
	
	/**
	 * Constructor is for creating graphical interface.
	 */
	public End()
	{
		Lopetus = new JButton("Ok");
		LoppuLause = new JLabel("Muutokset tehty.");
		LoppuLause2 = new JLabel("Sammuta painamalla Ok.");
		logo2 = new ImageIcon(getClass().getResource("hifis.jpg"));
		kuva2 = new JLabel(logo2);
		
		LoppuLause.setFont(new Font("Serif", Font.PLAIN, 15));
		LoppuLause2.setFont(new Font("Serif", Font.PLAIN, 15));
		Lopetus.setFont(new Font("Serif", Font.PLAIN, 15));
		
		Lopetus.addActionListener(new LopetusNappiKuuntelija());
		
		paneeli = new JPanel(new FlowLayout());
		paneeli.add(Lopetus);
		paneeli.add(LoppuLause);
		paneeli.add(LoppuLause2);
		
		
		paneeli2 = new JPanel(new FlowLayout());
		paneeli2.add(kuva2);
		
		this.setLayout(new BorderLayout());
		this.add(paneeli, BorderLayout.SOUTH);
		this.add(paneeli2, BorderLayout.NORTH);
		
		setTitle("Lopetus");
		setSize(1300, 700);
		setLocation(50, 20);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	/**
	 * LopetusNappiKuuntelija
	 * Created Mar 10, 2017
	 * @author Mikael Heininen y104491 <a href="mailto:mikael.heininen@student.uwasa.fi">mikael.heininen@student.uwasa.fi</a>
	 */
	private class LopetusNappiKuuntelija implements ActionListener			
	{
		/**
		 * If button is pressed.
		 * @param e
		 */
		public void actionPerformed(ActionEvent e)
		{
			if(e.getActionCommand().equals("Ok"))
			System.exit(0);
		}
	}
	
}
