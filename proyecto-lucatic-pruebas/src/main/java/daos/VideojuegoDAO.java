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
	public void removeVideojuego(String nombre) throws CsvValidationException, IOException {
		// TODO Auto-generated method stub
		ArrayList<String[]> ficheroActual = fichero.leerCSV();
		boolean salida=true;
		
		while(salida) {
			for(int i=0;i<ficheroActual.size();i++) {
				if(ficheroActual.get(i)[1].equals(nombre)) {
					ficheroActual.remove(i);
					fichero.escribirCSV(ficheroActual);
					salida=false;
				}
			}
		}
		
		
	}
	
	

//	@Override
//	public void addVideojuego(String[] videojuego) {
//		fichero.add(videojuego);
//		int lastIdx = fichero.size() - 1;
//		System.out.println(fichero.get(lastIdx));
//		
//	}
	
	// videojuego.setName(String name);
//	
	
//	@Override
//	public void addVideojuego(Videojuego videojuego) {
//		fichero.add(videojuego);
//		for (Videojuego vid : fichero) {
//			if (vid.getRank() == fichero.size() - 1) {
//				System.out.println(vid);
//			}		
//		}
//
//	}
	


}
