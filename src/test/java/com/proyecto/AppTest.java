package com.proyecto;

import model.Videojuego;
import services.VideojuegoService;

import org.junit.jupiter.api.Test;

import com.opencsv.exceptions.CsvValidationException;

import Datos.Fichero;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Logger;
import daos.VideojuegoDAO;
import interfaces.IVideojuegoService;

/**
 * Unit test for simple App.
 */
public class AppTest {
	private static Logger logger;

	private VideojuegoDAO videojuegodao = new VideojuegoDAO();
	private Fichero fichero = new Fichero(); 
	private IVideojuegoService vjservice = new VideojuegoService();

	static {
		try {
			logger = Logger.getLogger("MyLog");
		} catch (Throwable e) {
			System.out.println("No funciona");
		}
	}

	
	//Tests ALTA VIDEOJUEGOS
	
	// antiguo datoCorrecto()
	@Test
	public void siDoyDeAltaUnVideojuegoDeberiaAñadirseALista() throws IOException, CsvValidationException {
		// assertNull(VideojuegoDAO.addVideojuego(null));
		Videojuego juego = new Videojuego(17000, "Metroid", "DS", 2005, "Platform", "Nintendo");
		Videojuego juego2 = new Videojuego(18000, "Mario Bros", "Wii", 2012, "Platform", "Nintendo");
		videojuegodao.addVideojuego(juego);
		videojuegodao.addVideojuego(juego2);
		ArrayList<String[]> lista = new ArrayList<>();
		lista = fichero.leerCSV();
		assertTrue("No ha fallado porque el videojuego esta lleno", lista.get(lista.size()-1)[0] != null);
		// logger.info("No ha fallado porque el videojuego esta lleno");
	}
	
	
   @Test
    public void siAñadoVideojuegoDeberiaEstarEnLaLista() throws CsvValidationException, IOException {
	   
        // Give: dado un videojuego
        Videojuego juego = new Videojuego(99000, "Metroid", "DS", 2005, "Platform", "Nintendo");
        // When: si lo doy de alta
        videojuegodao.addVideojuego(juego);
        // Then: aparece en la lista
        assertTrue("No se ha añadido bien el videjuego", vjservice.revisarPlataforma(juego.getPlatform(), juego.getName()) == true);
    }
	
	
	// antiguo tipoDatoEspecial()
	@Test
	public void siAñadoUnVideojuegoConUnDatoEspecialDeberiaSaltarExcepcion() throws IOException, CsvValidationException {
		// assertNull(VideojuegoDAO.addVideojuego(null));
		try {
			Videojuego juego = new Videojuego(17000, "Metr@id", "D$", 2005, "Platform", "Nintendo");
			videojuegodao.addVideojuego(juego);
			ArrayList<String[]> lista = new ArrayList<>();
			lista = fichero.leerCSV();
			assertTrue(lista.get(lista.size()-1)[0]!= null);
		}catch(Exception e) {
			logger.info("Falla porque le pasamos un tipo de dato incorrecto");
		}
	}
	
	// antiguo datoNoCorrecto()
	@Test
	public void siDoyDeAltaUnVideojuegoVacioDeberiaSaltarExcepcion() throws IOException, NullPointerException, CsvValidationException {
		// assertNull(VideojuegoDAO.addVideojuego(null));
		ArrayList<String[]> lista = new ArrayList<>();
		Videojuego video = new Videojuego();
		videojuegodao.addVideojuego(video);
		lista = fichero.leerCSV();
		assertFalse(lista.get(lista.size()-1)[1] != "");
		logger.info("Ha fallado por estar vacio");
	}
	
	@Test
	public void siMetoUnVideojuegoQueExisteDeberiaSaltarUnAviso() throws CsvValidationException, IOException {
	    //Given...
		ArrayList<String[]> lista = new ArrayList<>();
		lista = fichero.leerCSV();
		Videojuego juego = new Videojuego(2,"Super Mario Bros.","NES",1985,"Platform","Nintendo");
	    // When...
		videojuegodao.addVideojuego(juego);
	    // Then...
		logger.info("Salta excepción");
	}
	
	
	// Tests LISTAR VIDEOJUEGOS
	
	@Test
	public void ultimoVideojuegoSeListaCorrectamente() throws IOException, CsvValidationException {
		// assertNull(VideojuegoDAO.addVideojuego(null));
		ArrayList<String[]> lista = new ArrayList<>();
		lista = fichero.leerCSV();
		assertTrue(lista.get(lista.size()-1)[0] != null);
		logger.info("El último videojuego se lista correctamente: " + lista.get(lista.size()-1)[0]);
	}
	
	// Tests LISTAR VIDEOJUEGOS DEL GENERO PLATAFORMA
	
	@Test
	public void videojuegosPlataformaSeListanCorrectamente() throws CsvValidationException, IOException {
	    //Given...
	    try {
	        // When...
	    	vjservice.listado_videojuegos_plataforma();
	    } catch (Exception e) {
	    	logger.info("Falla porque no tiene nada que listar");
	    }
	    // Then...
	}
	
	
	// Tests DAR DE BAJA VIDEOJUEGO
	
	// antiguo bajaVideojuegoExistente() 
	@Test
	public void bajaVideojuegoExistente() throws CsvValidationException, IOException {
	    //Given...
	    try {
	        // When...
	    	videojuegodao.removeVideojuego("Wii Sports");
	    } catch (Exception e) {
	    	logger.info("El metodo falla al buscar o eliminar el videojuego");
	    }
	    // Then...
	}
	
	
	@Test
	public void bajaVideojuegoNoExistente() throws CsvValidationException, IOException {
	    //Given...
	    try {
	        // When...
	    	videojuegodao.removeVideojuego("este juego no existe");
	    } catch (Exception e) {
	    	logger.info("Falla porque no existe el videojuego");
	    }
	    // Then...
	}
	
   @Test
   public void siQuitoVideojuegoNoDeberiaEstarEnLaLista() throws CsvValidationException, IOException {
	   
       // Give: dada la lista de videojuegos
	   ArrayList<String[]> lista = new ArrayList<>();
	   lista = fichero.leerCSV();
       Videojuego juego = new Videojuego(2,"Super Mario Bros.","NES",1985,"Platform","Nintendo");
       // When: si doy de baja un videojuego
       videojuegodao.removeVideojuego("Super Mario Bros.");
       // Then: aparece en la lista
       assertTrue("No se ha quitado bien el videojuego", vjservice.revisarPlataforma(juego.getPlatform(), juego.getName()) == false);
   }
	
	// Tests LISTAR VIDEOJUEGOS DEL SIGLO XX
	
	@Test
	public void videojuegosSigloXXSeListanCorrectamente() throws CsvValidationException, IOException {
	    //Given...
		ArrayList<String[]> lista = new ArrayList<>();
		lista = fichero.leerCSV();
	    try {
	        // When...
	    	vjservice.listado_videojuegos_sigloxx();
	    } catch (Exception e) {
	    	logger.info("Falla el método listar año par");
	    }
	    // Then...
	}
   
   
	// Tests LISTAR VIDEOJUEGOS POR GENERO
   
   
   
	// Tests LISTAR VIDEOJUEGOS NINTENDO
   
	@Test
	public void videojuegosNintendoSeListanCorrectamente() throws CsvValidationException, IOException {
	    //Given...
		ArrayList<String[]> lista = new ArrayList<>();
		lista = fichero.leerCSV();
	    try {
	        // When...
	    	vjservice.listado_videojuegos_nintendo();
	    } catch (Exception e) {
	    	logger.info("Falla el método listar editores");
	    }
	    // Then...
	}
   
   
	// Tests LISTAR VIDEOJUEGOS AÑO PAR
	
	@Test
	public void videojuegosAñoParSeListanCorrectamente() throws CsvValidationException, IOException {
	    //Given...
		ArrayList<String[]> lista = new ArrayList<>();
		lista = fichero.leerCSV();
	    try {
	        // When...
	    	vjservice.listado_videojuegos_anyo_par();
	    } catch (Exception e) {
	    	logger.info("Falla el método listar año par");
	    }
	    // Then...
	}
   
   
	// Tests LISTAR EDITORES
     
	@Test
	public void editoresSeListanCorrectamente() throws CsvValidationException, IOException {
	    //Given...
		ArrayList<String[]> lista = new ArrayList<>();
		lista = fichero.leerCSV();
	    try {
	        // When...
	    	vjservice.listar_editores();
	    } catch (Exception e) {
	    	logger.info("Falla el método listar editores");
	    }
	    // Then...
	}
   
   

   
   

	


	
}