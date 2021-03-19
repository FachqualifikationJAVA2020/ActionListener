package actionlistener;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Version1 implements ActionListener{
	/*
	 * Unsere GUI soll drei Elemente haben
	 * in der Mitte ein JLabel als Zähleranzeige
	 * links einen Minus-Button, der runterzählt
	 * rechts einen Plus-Button, der raufzählt
	 * 
	 * Version1 wie am Dienstag:
	 * die Klasse selber implementiert ActionListener,
	 * ein ActionListener für beide Buttons
	 * Vorteile:
	 *  nur eine Klasse, übersichtlich, leicht zu verstehen
	 * Nachteile:
	 *  wird groß (und langsam) bei vielen Buttons  
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
		 * weil die Methode jetzt von zwei Buttons ausgelöst werden
		 * kann, müssen wir das unterscheiden.
		 * Dazu werten wir das ActionEvent aus:
		 * getSource() gibt mir an, welches Objekt die Aktion ausgelöst hat
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
