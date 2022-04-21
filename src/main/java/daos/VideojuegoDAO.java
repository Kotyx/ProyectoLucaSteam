package daos;

import java.io.IOException;
import java.util.ArrayList;

import com.opencsv.exceptions.CsvValidationException;

import Datos.Fichero;
import interfaces.IVideojuegoDAO;
import model.Videojuego;

public class VideojuegoDAO implements IVideojuegoDAO {
	
	Fichero fichero = new Fichero();

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
	
	public ArrayList<String[]> listado() throws CsvValidationException, IOException{
		
		return fichero.leerCSV();
	}

	public void removeVideojuego(String nombre) throws CsvValidationException, IOException {
		// TODO Auto-generated method stub
		ArrayList<String[]> lista=listado();

			for(String[] juego : lista) {
				if(juego[1].equals(nombre)) {
					lista.remove(juego);
					fichero.escribirCSV(lista);
					break;
					}
				}
			}
}