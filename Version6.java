package actionlistener;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Version6 {
	/*
	 * Jetzt machen wir die Anonymen Inneren Klassen
	 * noch kürzer
	 */
	private JFrame frame;
	private JLabel anzeige;
	private JButton plus;
	private JButton minus;
	
	public Version6() {
		frame = new JFrame();
		anzeige = new JLabel("0");
		plus = new JButton("+");
		minus = new JButton("-");
		
		frame.setLayout(new FlowLayout());
		frame.add(minus);
		frame.add(anzeige);
		frame.add(plus);
		/*
		 * Anonyme Innere Klasse enthält viele Dinge,
		 * die der Compiler schon weiß,
		 * die können weg
		 */
		plus.addActionListener(
			/*
			 * alles was wegkonnte wird durch den Pfeil ersetzt,
			 * das nennt man einen Lambda-Ausdruck (lambda expression)
			 * häufig "ein Lambda"
			 * 
			 * Ein Lambda geht nur bei Interfaces mit genau einer 
			 * Methode (Funktionale Interfaces)
			 */
			ae -> {
				String s = anzeige.getText();
				int i = Integer.parseInt(s);
				i++;
				anzeige.setText(String.valueOf(i));
			}
		);
		/*
		 * Lambdas sehen am Besten aus, wenn die
		 * Methode nur eine Zeile hat, dann kann
		 * die letzte geschweifte Klammer auch noch weg
		 * (leider kriege ich das hier nicht hin :(
		 */
		minus.addActionListener(  ae -> {
				int i = Integer.parseInt(anzeige.getText());
				anzeige.setText(String.valueOf(--i));
			}
		);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
	
	public static void main(String[] args) {
		new Version6();
	}
}
