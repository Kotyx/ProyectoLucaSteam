package interfaces;

import java.io.IOException;
import java.util.ArrayList;

import com.opencsv.exceptions.CsvValidationException;

import model.Videojuego;

public interface IVideojuegoDAO {
	
	// contiene los metodos del DAO

	public void addVideojuego(Videojuego videojuego);
	public ArrayList<String[]> listado() throws CsvValidationException, IOException;
	public void removeVideojuego(String nombre) throws CsvValidationException, IOException;

}