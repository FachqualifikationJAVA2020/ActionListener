package actionlistener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Minus implements ActionListener {
	Version2 bezug;
	
	public Minus(Version2 bezug) {
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
