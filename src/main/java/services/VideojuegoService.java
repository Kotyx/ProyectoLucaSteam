package services;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import com.opencsv.exceptions.CsvValidationException;

import interfaces.IVideojuegoService;
import model.Videojuego;
import daos.VideojuegoDAO;

public class VideojuegoService implements IVideojuegoService {

	VideojuegoDAO videojuegodao = new VideojuegoDAO();
	
	@Override
	public void darDeAltaVideojuego() throws CsvValidationException, IOException {
		
		//ESCANER PARA LEER POR 
		Scanner sc = new Scanner(System.in);
		
		
		System.out.println("Introduzca el nombre del videojuego: ");
		String nombre_videojuego = sc.next();
		System.out.println("Introduzca la plataforma: ");
		String plataforma = sc.next();
		System.out.println("Introduza el año de lanzamiento: ");
		int anyo_lanzamiento = sc.nextInt();
		System.out.println("Introduzca el genero: ");
		String genero = sc.next();
		System.out.println("Introduzca el nombre de la compañia: ");
		String publisher = sc.next();
		
		ArrayList<String[]> fich = videojuegodao.listado();
		int rank=Integer.parseInt(fich.get(fich.size()-1)[0])+1;
	
		Videojuego videojuego = new Videojuego(rank,nombre_videojuego,plataforma,anyo_lanzamiento,genero,publisher);
		
		videojuegodao.addVideojuego(videojuego);
		
	}

	@Override
	public void listado_videojuegos() throws CsvValidationException, IOException {
		
		try {
			for (String[] juego : videojuegodao.listado()) {
				  System.out.println(juego[0]+ " " +juego[1]+ " " +juego[2]+ " " +juego[3]+ " " +juego[4]+ " " + juego[5]);
				}
		} catch (CsvValidationException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void listado_videojuegos_plataforma() throws CsvValidationException, IOException {
		
		for ( String[] juego : videojuegodao.listado() ) {
		
			if(juego[4].equals("Platform")) {
				System.out.println(juego[0] + " "+ juego[1] + " "+ juego[2] + " "+ juego[3] + " "+ juego[4] + " "+juego[5]);
			}
		}
	}
	
	public void listado_videojuegos_nintendo() throws CsvValidationException, IOException {
		
		for ( String[] juego : videojuegodao.listado() ) {
		
			if(juego[5].equals("Nintendo")) {
				System.out.println(juego[0] + " "+ juego[1] + " "+ juego[2] + " "+ juego[3] + " "+ juego[4] + " "+juego[5]);
			}
		}
	}
	
	public void darDeBajaVideojuego() throws IOException, CsvValidationException {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduzca el nombre del videojuego: ");
		String nombre_videojuego = sc.next();
		videojuegodao.removeVideojuego(nombre_videojuego);
		
		
	}
	
	
}