package interfaces;

import java.io.IOException;
import java.util.ArrayList;

import com.opencsv.exceptions.CsvValidationException;

import model.Videojuego;

public interface IVideojuegoService {
	
	public void darDeAltaVideojuego() throws IOException;
	public ArrayList<String[]> listado_videojuegos();
	public void listado_videojuegos_plataforma() throws CsvValidationException, IOException;

}
