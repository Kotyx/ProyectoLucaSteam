package services;

import java.io.IOException;
import java.util.ArrayList;

import java.util.Scanner;

import interfaces.IVideojuegoDAO;
import interfaces.IVideojuegoService;
import model.Videojuego;
import Datos.Fichero;

public class VideojuegoService implements IVideojuegoService {

	Fichero fichero=new Fichero();
	
	@Override
	public void darDeAltaVideojuego() throws IOException {
		
		//ESCANER PARA LEER POR 
		Scanner sc = new Scanner(System.in);
		ArrayList<String[]> lista=fichero.leerCSV();
		
		System.out.println("Introduzca el nombre del videojuego: ");
		String nombre_videojuego = sc.next();
		System.out.println("Introduzca la plataforma: ");
		String plataforma = sc.next();
		System.out.println("Introduza el a�o de lanzamiento: ");
		int anyo_lanzamiento = sc.nextInt();
		System.out.println("Introduzca el genero: ");
		String genero = sc.next();
		System.out.println("Introduzca el nombre de la compa�ia: ");
		String publisher = sc.next();
		
		
		Videojuego videojuego = new Videojuego(Integer.parseInt(lista.get(-1)[0])+1,nombre_videojuego,plataforma,anyo_lanzamiento,genero,publisher);
		IVideojuegoDAO videojuegodao = (IVideojuegoDAO) videojuego;
		
		videojuegodao.addVideojuego(videojuego);
		
		sc.close();


	}

	@Override
	public ArrayList<Videojuego> listado_videojuegos() {
		
		return null;
	}

}