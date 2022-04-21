package services;

import java.io.IOException;
import java.util.ArrayList;

import java.util.Scanner;

import com.opencsv.exceptions.CsvValidationException;

import interfaces.IVideojuegoDAO;
import interfaces.IVideojuegoService;
import model.Videojuego;
import Datos.Fichero;
import daos.VideojuegoDAO;

public class VideojuegoService implements IVideojuegoService {

	VideojuegoDAO videojuegodao = new VideojuegoDAO();
	
	@Override
	public void darDeAltaVideojuego() {
		
		
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
	
		Videojuego videojuego = new Videojuego(17000,nombre_videojuego,plataforma,anyo_lanzamiento,genero,publisher);
		
		
		videojuegodao.addVideojuego(videojuego);
		
		


	}


	@Override
	public ArrayList<String[]> listado_videojuegos() {
		
		return null;
	}

	@Override
	public void listado_videojuegos_plataforma() throws CsvValidationException, IOException {
		
		for ( String[] juego : videojuegodao.listado() ) {
		
			if(juego[4].equals("Platform")) {
				System.out.println(juego[0] + " "+ juego[1] + " "+ juego[2] + " "+ juego[3] + " "+ juego[4] + " "+juego[5]);
			}
		}
			
		
	}
	
	

}