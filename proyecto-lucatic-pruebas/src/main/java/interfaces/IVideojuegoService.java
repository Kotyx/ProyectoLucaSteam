package interfaces;

import java.io.IOException;
import java.util.ArrayList;

import com.opencsv.exceptions.CsvValidationException;

import model.Videojuego;

public interface IVideojuegoService {
	
	public void darDeAltaVideojuego() throws IOException;
	public ArrayList<Videojuego> listado_videojuegos(); 
	public void darDeBajaVideojuego() throws IOException, CsvValidationException;

}
