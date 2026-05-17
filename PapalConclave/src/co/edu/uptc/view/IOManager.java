package co.edu.uptc.view;

import javax.swing.JOptionPane;

public class IOManager {

	public String input(String message) {
		String data=JOptionPane.showInputDialog(message);
		return data;
	}
	public String show(String message) {
		JOptionPane.showMessageDialog(null, message);
		return message;
	}
}
