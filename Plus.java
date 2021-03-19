package actionlistener;

import java.awt.event.*;

public class Plus implements ActionListener{
	private Version2 bezug;

	public Plus(Version2 bezug) {
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
