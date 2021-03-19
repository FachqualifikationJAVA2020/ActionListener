package actionlistener;

import java.awt.FlowLayout;
import java.awt.event.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Version5 {
	/*
	 * Version4 hat mit inneren Klassen alles gut gemacht,
	 * aber wir können die Funktionalität noch näher an
	 * die Button-Instanz heranholen:
	 * Anonyme Innere Klassen
	 */
	private JFrame frame;
	private JLabel anzeige;
	//Nur andere Klasenbestandteile sollen zugreifen
	private JButton plus;
	private JButton minus;
	
	public Version5() {
		frame = new JFrame();
		anzeige = new JLabel("0");
		plus = new JButton("+");
		minus = new JButton("-");
		
		frame.setLayout(new FlowLayout());
		frame.add(minus);
		frame.add(anzeige);
		frame.add(plus);
		/*
		 * Die Funktionalität des ActionListener
		 * soll nicht so weit weg sein
		 * 
		 * Ich implementiere das ActionListener-Interface
		 * als Anonyme Innere Klasse (anonymous inner class)
		 * Direkt hinter dem Interfacenamen gebe ich in
		 * geschweiften Klammern die Implementierung der
		 * Methoden an
		 * 
		 * Anonyme Innere Klasse:
		 */
		plus.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				String s = anzeige.getText();
				int i = Integer.parseInt(s);
				i++;
				anzeige.setText(String.valueOf(i));
			}
		});
		
		minus.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				String s = anzeige.getText();
				int i = Integer.parseInt(s);
				i--;
				anzeige.setText(String.valueOf(i));
			}
		});
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
	
	public static void main(String[] args) {
		new Version5();
	}
}
