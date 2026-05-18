package co.edu.uptc.view;

import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import co.edu.uptc.model.Cardinal;

public class IOManager {

	public String input(String message) {
		String data=JOptionPane.showInputDialog(message);
		return data;
	}
	public String show(String message) {
		JOptionPane.showMessageDialog(null, message);
		return message;
	}
	public int optionsInput(String message, ImageIcon icon, Object[] options) {
		int option= JOptionPane.showOptionDialog(null, message,"MENÚ", 0, 0,icon, options, "");
		return option;
	}
	public void showList(ArrayList<Cardinal> listTwo){
		ArrayList <Cardinal>list=listTwo;
		String message="";
		for(Cardinal objectCardinal : list) {
			message+=objectCardinal+"\n";
	    }
		JOptionPane.showMessageDialog(null, message);
	}
}
