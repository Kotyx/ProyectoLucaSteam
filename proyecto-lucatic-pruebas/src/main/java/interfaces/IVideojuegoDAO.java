package interfaces;

import java.io.IOException;

import com.opencsv.exceptions.CsvValidationException;

import model.Videojuego;

public interface IVideojuegoDAO {
	
	// contiene los metodos del DAO
	
	// public void addVideojuego(Videojuego videojuego);
	public void addVideojuego(Videojuego videojuego);
	public void removeVideojuego(String nombre) throws CsvValidationException, IOException;

}