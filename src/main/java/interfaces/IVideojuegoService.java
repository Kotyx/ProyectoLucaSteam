package interfaces;

import java.io.IOException;
import java.util.ArrayList;

import com.opencsv.exceptions.CsvValidationException;

import model.Videojuego;

public interface IVideojuegoService {
	
	public void darDeAltaVideojuego() throws IOException, CsvValidationException;
	public void listado_videojuegos() throws CsvValidationException, IOException;
	public void listado_videojuegos_plataforma() throws CsvValidationException, IOException;
	public void listado_videojuegos_nintendo() throws CsvValidationException, IOException;
	public void darDeBajaVideojuego() throws IOException, CsvValidationException;

}