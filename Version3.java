package actionlistener;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Version3 {
	/*
	 * Nicht mehr für jeden Button eine eigene Klasse im package,
	 * die beiden Hilfsklassen Plus und Minus liegen in der
	 * selben Datei, das geht solange sie nicht public sind
	 * Vorteil:
	 *  nicht mehr so viele Dateien
	 * Nachteile
	 *  Kapselung immer noch durchbrochen
	 *  immer noch bezüge zur aufrufenden GUI-Klasse notwendig 
	 * 
	 */
	private JFrame frame;
	protected JLabel anzeige;
	private JButton plus;
	private JButton minus;
	
	public Version3() {
		frame = new JFrame();
		anzeige = new JLabel("0");
		plus = new JButton("+");
		minus = new JButton("-");
		
		frame.setLayout(new FlowLayout());
		frame.add(minus);
		frame.add(anzeige);
		frame.add(plus);
		
		plus.addActionListener(new Plus3(this));
		//eine Instanz meiner Plus-Klasse
		minus.addActionListener(new Minus3(this));
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
	
	public static void main(String[] args) {
		new Version3();
	}
}

/*
 * Ich habe die Klasse Plus in meine Java-Datei übernommen.
 * Wenn ich Sie nicht public mache, ist das okay.
 */

class Plus3 implements ActionListener{
	private Version3 bezug;

	public Plus3(Version3 bezug) {
		this.bezug = bezug;
	}
	
	/*
	 * reagiert auf den Klick auf den Plus-Button
	 */
	@Override
	public void actionPerformed(ActionEvent ae) {
		/*
		 * Hier kommt jetzt die Funktionalität rein
		 */
		String s = bezug.anzeige.getText();
		int i = Integer.parseInt(s);
		i++;
		bezug.anzeige.setText(String.valueOf(i));
	}
}

class Minus3 implements ActionListener {
	Version3 bezug;
	
	public Minus3(Version3 bezug) {
		this.bezug = bezug;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String s = bezug.anzeige.getText();
		int i = Integer.parseInt(s);
		i--;
		bezug.anzeige.setText(String.valueOf(i));
	}
}
