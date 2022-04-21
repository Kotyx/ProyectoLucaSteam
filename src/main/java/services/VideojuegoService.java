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

	@Override
	public void darDeAltaVideojuego()  {
		
		//ESCANER PARA LEER POR 
		Scanner sc = new Scanner(System.in);
		Fichero fichero=new Fichero();
		ArrayList<String[]> lista = new ArrayList<>();
		
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
	
		//lista=fichero.leerCSV();
		
		Videojuego videojuego = new Videojuego(17000,nombre_videojuego,plataforma,anyo_lanzamiento,genero,publisher);
		VideojuegoDAO videojuegodao = new VideojuegoDAO();
		
		videojuegodao.addVideojuego(videojuego);
		
		


	}

	@Override
	public ArrayList<Videojuego> listado_videojuegos() {
		
		return null;
	}

	@Override
	public void darDeBajaVideojuego() throws IOException, CsvValidationException {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		Fichero fichero=new Fichero();
		ArrayList<String[]> lista = new ArrayList<>();
		
		System.out.println("Introduzca el nombre del videojuego: ");
		String nombre_videojuego = sc.next();
		
		VideojuegoDAO videojuegodao = new VideojuegoDAO();
		
		videojuegodao.removeVideojuego(nombre_videojuego);
		
		
	}

}