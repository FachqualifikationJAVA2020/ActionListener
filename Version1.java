package actionlistener;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Version1 implements ActionListener{
	/*
	 * Unsere GUI soll drei Elemente haben
	 * in der Mitte ein JLabel als Z�hleranzeige
	 * links einen Minus-Button, der runterz�hlt
	 * rechts einen Plus-Button, der raufz�hlt
	 * 
	 * Version1 wie am Dienstag:
	 * die Klasse selber implementiert ActionListener,
	 * ein ActionListener f�r beide Buttons
	 * Vorteile:
	 *  nur eine Klasse, �bersichtlich, leicht zu verstehen
	 * Nachteile:
	 *  wird gro� (und langsam) bei vielen Buttons  
	 */
	private JFrame frame;
	private JLabel anzeige;
	private JButton plus;
	private JButton minus;
	
	public Version1() {
		frame = new JFrame();
		anzeige = new JLabel("0");
		//zwei Stellen, damit genug Platz bleibt
		plus = new JButton("+");
		minus = new JButton("-");
		
		frame.setLayout(new FlowLayout());
		frame.add(minus);
		frame.add(anzeige);
		frame.add(plus);
		
		plus.addActionListener(this);
		minus.addActionListener(this);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae) {
		/*
		 * weil die Methode jetzt von zwei Buttons ausgel�st werden
		 * kann, m�ssen wir das unterscheiden.
		 * Dazu werten wir das ActionEvent aus:
		 * getSource() gibt mir an, welches Objekt die Aktion ausgel�st hat
		 */
		if(ae.getSource() == plus) {
			String s = anzeige.getText();
			int i = Integer.parseInt(s);
			i = i + 1;
			anzeige.setText(String.valueOf(i));
		} else {
			String s = anzeige.getText();
			int i = Integer.parseInt(s);
			i = i - 1;
			anzeige.setText(String.valueOf(i));
		}
	}
	
	public static void main(String[] args) {
		new Version1();
	}
}
