package interfaces;

import java.io.IOException;
import java.util.ArrayList;

import model.Videojuego;

public interface IVideojuegoService {
	
	public void darDeAltaVideojuego() throws IOException;
	public ArrayList<Videojuego> listado_videojuegos(); 

}
