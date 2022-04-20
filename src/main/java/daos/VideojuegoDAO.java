package daos;

import java.util.ArrayList;

import Datos.Fichero;
import interfaces.IVideojuegoDAO;
import model.Videojuego;

public class VideojuegoDAO implements IVideojuegoDAO {
	
	
	Fichero fichero = new Fichero();

	@Override
	public void addVideojuego(Videojuego videojuego) {
				
		try {
			
			ArrayList<String[]> ficheroActual = fichero.leerCSV();
			
			String[] atributosVideojuego = new String[10];
		
			
			atributosVideojuego[0] = Integer.toString(videojuego.getRank());
			atributosVideojuego[1] = videojuego.getName();
			atributosVideojuego[2] = videojuego.getPlatform();
			atributosVideojuego[3] = Integer.toString(videojuego.getYear());
			atributosVideojuego[4] = videojuego.getGenre();
			atributosVideojuego[5] = videojuego.getPublisher();
			atributosVideojuego[6] = "0";
			atributosVideojuego[7] = "0";
			atributosVideojuego[8] = "0";
			atributosVideojuego[9] = "0";
			
			ficheroActual.add(atributosVideojuego);
			
			fichero.escribirCSV(ficheroActual);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e);
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
