package daos;

import java.io.IOException;
import java.util.ArrayList;

import com.opencsv.exceptions.CsvValidationException;

import Datos.Fichero;
import interfaces.IVideojuegoDAO;
import model.Videojuego;

public class VideojuegoDAO implements IVideojuegoDAO {
	
	
	Fichero fichero = new Fichero();

	@Override
	public void addVideojuego(Videojuego videojuego) {
				
		try {
			
			ArrayList<String[]> ficheroActual = fichero.leerCSV();
			
			String[] atributosVideojuego = new String[6];
		
			
			atributosVideojuego[0] = Integer.toString(videojuego.getRank());
			atributosVideojuego[1] = videojuego.getName();
			atributosVideojuego[2] = videojuego.getPlatform();
			atributosVideojuego[3] = Integer.toString(videojuego.getYear());
			atributosVideojuego[4] = videojuego.getGenre();
			atributosVideojuego[5] = videojuego.getPublisher();
			
			ficheroActual.add(atributosVideojuego);
			
			fichero.escribirCSV(ficheroActual);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}

		
	}

	@Override
	public ArrayList<String[]> listado() throws CsvValidationException, IOException {
		
		
		return fichero.leerCSV();
	}
	
	
	


}
