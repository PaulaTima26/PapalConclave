package co.edu.uptc.view;
/* Names: Sebastian Felipe Rodríguez Sánchez y Paula Estefanía Timarán Amezquita
 * Date: 23/05/26
 * Description: Proyecto Final
 */
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import co.edu.uptc.model.Cardinal;

public class IOManager {
	public int optionsInput(String message, ImageIcon icon, Object[] options) {
		int option= JOptionPane.showOptionDialog(null, message,"MENÚ", 0, 0,icon, options, "");
		return option;
	}

	public void showList(ArrayList<Cardinal> listTwo, ImageIcon icon){
		ArrayList <Cardinal>list=listTwo;
		String message="";
		for(Cardinal objectCardinal : list) {
			message+=objectCardinal+"\n";
		}
		JOptionPane.showMessageDialog(null, message, "ROLES", 0, icon);
	}
	public String inputMessageIcon(String message, String string, ImageIcon icon) {
		String data=(String) JOptionPane.showInputDialog(null, message, string ,JOptionPane.INFORMATION_MESSAGE, icon, null, "");
		return data;
	}
	public String showMessageIcon(String message, String string, ImageIcon icon) {
		JOptionPane.showMessageDialog(null, message, string, 0, icon);
		return "";
	}
	public String showMessageIconError(String message, ImageIcon icon) {
		JOptionPane.showMessageDialog(null, message, "ERROR", 0, icon);
		return "";
	}
	
}
