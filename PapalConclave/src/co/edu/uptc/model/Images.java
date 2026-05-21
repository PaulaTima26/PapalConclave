package co.edu.uptc.model;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Images {
	private ImageIcon cardinalIcon;
	private ImageIcon cardinalsIcon;
	private ImageIcon urnaIcon;

	public Images() {
		cardinalIcon= new ImageIcon(getClass().getResource("/co/edu/uptc/model/Icono usuario.png"));
		cardinalsIcon= new ImageIcon(getClass().getResource("/co/edu/uptc/model/IconoUniversidad.png"));
		urnaIcon=new ImageIcon(getClass().getResource("/co/edu/uptc/model/GifPregunta.gif"));
	}
	public ImageIcon getcardinalIcon() {
		return cardinalIcon;
	}
	
	public ImageIcon getCardinalsIcon() {
		return cardinalsIcon;
	}
	
	
	public ImageIcon getUrnaIcon() {
		return urnaIcon;
	}
}
