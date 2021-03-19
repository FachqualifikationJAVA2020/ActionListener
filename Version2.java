package actionlistener;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Version2 {//implementiert nicht ActionListener
	/*
	 * Verschiedene Objekte, die jeweils ActionListener
	 * implementieren und einem Button zugeordnet sind
	 * 
	 * Damit die Felder zugreifbar sind
	 * dürfen sie nicht mehr private sein :(
	 * 
	 * Vorteil:
	 *  actionPerformed muss nicht prüfen, wer sie ausgelöst hat
	 *  
	 * Nachteile:
	 *  Kapselung aufgebrochen (Feld nicht mehr private)
	 *  Viele Extra-Klassen im package, also unübersichtlich
	 *  Jeder ActionListener muss einen bezug zur aufrufenden Klasse haben
	 * 
	 */
	private JFrame frame;
	protected JLabel anzeige;
	private JButton plus;
	private JButton minus;
	
	public Version2() {
		frame = new JFrame();
		anzeige = new JLabel("0");
		plus = new JButton("+");
		minus = new JButton("-");
		
		frame.setLayout(new FlowLayout());
		frame.add(minus);
		frame.add(anzeige);
		frame.add(plus);
		
		/*
		 * Die Plus-Instanz muss wissen zu welcher 
		 * GUI-Instanz sie gehört
		 * darum gebe ich dem Konstruktor eine
		 * Referenz auf diese Instanz mit:
		 */
		plus.addActionListener(new Plus(this));
		//eine Instanz meiner Plus-Klasse
		minus.addActionListener(new Minus(this));
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
	
	public static void main(String[] args) {
		new Version2();
	}

}
