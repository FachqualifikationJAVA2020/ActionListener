package actionlistener;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Version4 {
	/*
	 * Die Kapselung soll wieder her!
	 * Wenn Plus und Minus Innere Klassen sind.
	 * können Sie auch auf Klassenbestandteile zugreifen,
	 * die private sind.
	 * Vorteile:
	 *  Kapselung
	 *  kein Bezugsvariable mehr nötig
	 * Nachteile:
	 *  meine Funktionalität ist so weit vom Button :( 
	 */
	private JFrame frame;
	private JLabel anzeige;
	//Nur andere Klasenbestandteile sollen zugreifen
	private JButton plus;
	private JButton minus;
	
	public Version4() {
		frame = new JFrame();
		anzeige = new JLabel("0");
		plus = new JButton("+");
		minus = new JButton("-");
		
		frame.setLayout(new FlowLayout());
		frame.add(minus);
		frame.add(anzeige);
		frame.add(plus);
		
		plus.addActionListener(new Plus());
		//eine Instanz meiner Plus-Klasse
		minus.addActionListener(new Minus());
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
	
	public static void main(String[] args) {
		new Version4();
	}
	/*
	 * Jetzt ist die Klasse Plus3 (als Plus)
	 * in der Klasse Version4 drin!
	 * Sie ist jetzt ein Klassenbestandteil!
	 * So etwas nennen wir eine "Innere Klasse",
	 * eine Klasse, die in eine andere Klasse verschachtelt ist. 
	 */
	class Plus implements ActionListener{
		/*
		 * Es ist klar, dass Plus zu der umgebenden äußeren GUI-Klasse
		 * gehört, es muss nicht extra mehr ein Bezug übergeben werden
		 */
		@Override
		public void actionPerformed(ActionEvent ae) {
			String s = anzeige.getText();
			int i = Integer.parseInt(s);
			i++;
			anzeige.setText(String.valueOf(i));
		}
	}
	
	class Minus implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			String s = anzeige.getText();
			int i = Integer.parseInt(s);
			i--;
			anzeige.setText(String.valueOf(i));
		}
	}
	
}
