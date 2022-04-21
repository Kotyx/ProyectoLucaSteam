package controller;

import java.io.IOException;
import java.util.Scanner;

import com.opencsv.exceptions.CsvValidationException;

import interfaces.IVideojuegoService;
import services.VideojuegoService;


public class Controlador {
	public static void main(String[] args) {
		
		IVideojuegoService vjservice=new VideojuegoService();
		Scanner sc = new Scanner(System.in);
		
		//MENU DEL CATALOGO DE VIDEOJUEGOS LUCASTEAM
		System.out.println("PLATAFORMA LUCASTEAM: MENU PRINCIPAL");
		boolean seguir=true;
		while(seguir) {
			System.out.println("***************************************");
			System.out.println("1--A�ADIR UN VIDEOJUEGO AL CATALOGO");
			System.out.println("2--LISTA DE VIDEOJUEGOS GENERAL");
			System.out.println("3--LISTA DE VIDEOJUEGOS: GENERO -PLATAFORMAS-");
			System.out.println("4--ELIMINAR UN VIDEOJUEGO DEL CATALOGO");
			System.out.println("5--MODIFICAR UN VIDEOJUEGO DE LA LISTA");
			System.out.println("6--LISTA DE VIDEOJUEGOS: SIGLO XX");
			System.out.println("7--LISTA DE VIDEOJUEGOS POR GENERO");
			System.out.println("8--LISTA DE VIDEOJUEGOS: SOPORTE NINTENDO");
			System.out.println("9--LISTA DE VIDEOJUEGOS: A�OS PARES");
			System.out.println("10-VER LA LISTA DE EDITORES");
			System.out.println("0--SALIR");
			System.out.println("***************************************");
			int opcion=sc.nextInt();
			switch(opcion)
			{
				case 1 :
					try {
						vjservice.darDeAltaVideojuego();
					} catch(Exception e) {
						System.out.println("No se ha podido a�adir el videojuego.");
					}
					break; 
				case 2 :
					try {
						vjservice.listado_videojuegos();
					} catch (CsvValidationException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					break; 
				case 3 :
					try {
						vjservice.listado_videojuegos_plataforma();
					} catch (CsvValidationException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					break; 
				case 4:
					try {
						vjservice.darDeBajaVideojuego();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					break;
				case 5:
					System.out.println("Opcion en mantenimiento...");
					break;
				case 6:
					System.out.println("Opcion en mantenimiento...");
					break;
				case 7:
					System.out.println("Opcion en mantenimiento...");
					break;
				case 8:
					try {
						vjservice.listado_videojuegos_nintendo();
					} catch (CsvValidationException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					break;
				case 9 :
					System.out.println("Opcion en mantenimiento...");
					break; 
				case 10:
					System.out.println("Opcion en mantenimiento...");
					break;
				case 0:
					seguir=false;
				break;
				default :
					System.out.println("Seleccione una opcion valida");
			}
		}
		System.out.println("***************************************");
		System.out.println("Fin del servicio");
		sc.close();
	}
}
