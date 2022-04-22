package services;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

import org.apache.commons.collections.bag.SynchronizedSortedBag;

import com.opencsv.exceptions.CsvValidationException;

import interfaces.IVideojuegoService;
import model.Videojuego;
import daos.VideojuegoDAO;

public class VideojuegoService implements IVideojuegoService {

	VideojuegoDAO videojuegodao = new VideojuegoDAO();
	
	
	public void darDeAltaVideojuego() throws CsvValidationException, IOException {
		
		//ESCANER PARA LEER POR 
		Scanner sc = new Scanner(System.in);
		
		ArrayList<String[]> fich = videojuegodao.listado();
		
		System.out.println("Introduzca el nombre del videojuego: ");
		String nombre_videojuego = sc.next();
		System.out.println("Introduzca la plataforma: ");
		String plataforma = sc.next();
		
		if(revisarPlataforma(nombre_videojuego,plataforma)==true) {
			System.out.println("El videojuego ya existe en esa plataforma");
		}else {
				System.out.println("Introduza el año de lanzamiento: ");
				int anyo_lanzamiento = sc.nextInt();
				System.out.println("Introduzca el genero: ");
				String genero = sc.next();
				System.out.println("Introduzca el nombre de la compañia: ");
				String publisher = sc.next();
					
					int rank=Integer.parseInt(fich.get(fich.size()-1)[0])+1;
				
					Videojuego videojuego = new Videojuego(rank,nombre_videojuego,plataforma,anyo_lanzamiento,genero,publisher);
					
					videojuegodao.addVideojuego(videojuego);
			}
		}
	
	public boolean revisarPlataforma(String plataforma, String nombre) throws CsvValidationException, IOException {
		
		for ( String[] juego : videojuegodao.listado()) {		
			if(juego[1].equals(nombre) && juego[4].equals(plataforma)) {
						return true;
					}
				}
		return false;
	}
	
	public String mostrarDatos(String[] juego) {
		String datos=juego[0]+ " " +juego[1]+ " " +juego[2]+ " " +juego[3]+ " " +juego[4]+ " " + juego[5];
		return datos;
	}

	public void listado_videojuegos() throws CsvValidationException, IOException {
		
		try {
			for (String[] juego : videojuegodao.listado()) {
				  System.out.println(mostrarDatos(juego));
				}
		} catch (CsvValidationException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void listado_videojuegos_plataforma() throws CsvValidationException, IOException {
		
		for ( String[] juego : videojuegodao.listado() ) {
		
			if(juego[4].equals("Platform")) {
				System.out.println(mostrarDatos(juego));
			}
		}
	}
	
	public void listado_videojuegos_nintendo() throws CsvValidationException, IOException {
		
	
		for ( String[] juego : videojuegodao.listado() ) {
		
			if(juego[5].equals("Nintendo")) {
				System.out.println(mostrarDatos(juego));
			}
		}
	}
	
	public void listar_editores() throws CsvValidationException, IOException{
		
		ArrayList<String> editores = new ArrayList();
		
		for ( String[] juego : videojuegodao.listado() ) {
			
			if(!editores.contains(juego[5])) {
				editores.add(juego[5]);
			}
		}
		System.out.println(editores);
	}
	
	public void darDeBajaVideojuego() throws IOException, CsvValidationException {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduzca el nombre del videojuego: ");
		String nombre_videojuego = sc.next();
		if(videojuegodao.removeVideojuego(nombre_videojuego)==true) {
			System.out.println("videojuego borrado");
		}else {
			System.out.println("no hay videojuegos con ese nombre");
		}
		
	}
	
	
}