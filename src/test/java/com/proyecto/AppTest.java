package com.proyecto;

import model.Videojuego;
import services.VideojuegoService;

import org.junit.jupiter.api.Test;

import com.opencsv.exceptions.CsvValidationException;

import Datos.Fichero;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Logger;
import daos.VideojuegoDAO;
import interfaces.IVideojuegoService;
import junit.framework.Assert;

/**
 * Unit test for simple App.
 */
public class AppTest {
	private static Logger logger;

	private VideojuegoDAO videojuegodao = new VideojuegoDAO();
	private Fichero fichero = new Fichero(); 

	static {
		try {
			logger = Logger.getLogger("MyLog");
		} catch (Throwable e) {
			System.out.println("No funciona");
		}
	}

	@Test
	public void altaVideojuegoVacio() throws IOException, NullPointerException, CsvValidationException {
		// assertNull(VideojuegoDAO.addVideojuego(null));
		ArrayList<String[]> lista = new ArrayList<>();
		Videojuego video = new Videojuego();
		System.out.println(video);
		videojuegodao.addVideojuego(video);
		lista = fichero.leerCSV();
		assertFalse(lista.get(lista.size()-1)[0] != null);
		logger.info("Ha fallado por que el videojuego está vacio");
	}

	@Test
	public void altaVideojuegoDatosCorrectos() throws IOException, CsvValidationException {
		// assertNull(VideojuegoDAO.addVideojuego(null));
		Videojuego juego = new Videojuego(17000, "Metroid", "DS", 2005, "Platform", "Nintendo");
		Videojuego juego2 = new Videojuego(18000, "Mario Bros", "Wii", 2012, "Platform", "Nintendo");
		videojuegodao.addVideojuego(juego);
		videojuegodao.addVideojuego(juego2);
		ArrayList<String[]> lista = new ArrayList<>();
		lista = fichero.leerCSV();
		assertTrue(lista.get(lista.size()-1)[0] != null);
		logger.info("No ha fallado porque el videojuego esta lleno");
	}

	
	@Test
	public void ultimoVideojuegoSeListaCorrectamente() throws IOException, CsvValidationException {
		// assertNull(VideojuegoDAO.addVideojuego(null));
		ArrayList<String[]> lista = new ArrayList<>();
		lista = fichero.leerCSV();
		assertTrue(lista.get(lista.size()-1)[0] != null);
		logger.info("El último videojuego se lista correctamente: " + lista.get(lista.size()-1)[0]);
	}
	
	
	@SuppressWarnings("deprecation")
	@Test
	public void bajaVideojuegoExistente() {
	    //Given...
		ArrayList<String[]> lista = new ArrayList<>();
		lista = fichero.leerCSV();
		IVideojuegoService vjservice = new VideojuegoService();
	    try {
	        // When...
	    	vjservice.darDeBajaVideojuego("Wii Sports");
	    } catch (Exception e) {
	        Assert.fail();
	    }
	    // Then...
	}
	
	
	@SuppressWarnings("deprecation")
	@Test
	public void bajaVideojuegoNoExistente() {
	    //Given...
		ArrayList<String[]> lista = new ArrayList<>();
		lista = fichero.leerCSV();
		IVideojuegoService vjservice = new VideojuegoService();
	    try {
	        // When...
	    	vjservice.darDeBajaVideojuego("este juego no existe");
	    } catch (Exception e) {
	        Assert.fail();
	    }
	    // Then...
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void videojuegosPlataformaSeListanCorrectamente() {
	    //Given...
		ArrayList<String[]> lista = new ArrayList<>();
		lista = fichero.leerCSV();
		IVideojuegoService vjservice = new VideojuegoService();
	    try {
	        // When...
	    	vjservice.listarPorPlataforma();
	    } catch (Exception e) {
	        Assert.fail();
	    }
	    // Then...
	}
	

	@SuppressWarnings("deprecation")
	@Test
	public void editoresNintendoSeListanCorrectamente() {
	    //Given...
		ArrayList<String[]> lista = new ArrayList<>();
		lista = fichero.leerCSV();
		IVideojuegoService vjservice = new VideojuegoService();
	    try {
	        // When...
	    	vjservice.listarNintendo();
	    } catch (Exception e) {
	        Assert.fail();
	    }
	    // Then...
	}
	

	
	
}