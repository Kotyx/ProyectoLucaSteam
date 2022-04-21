package Datos;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvValidationException;

public class Fichero {

	String csvFile = "C:\\Users\\Guille\\Desktop\\Curso\\parte2\\vgsales - copia.csv";

public ArrayList<String[]> leerCSV() throws IOException, CsvValidationException{
	
	ArrayList<String[]> fichero = new ArrayList<>();
	
	try {
		CSVReader csvReader = new CSVReader(new FileReader(csvFile));
		String[] values = null;
		while ((values = csvReader.readNext()) != null) {
			fichero.add(values);
	    }
		csvReader.close();
	} catch (FileNotFoundException e) {
	    e.printStackTrace();
	} 
	return fichero;
}

public void escribirCSV(ArrayList<String[]> fichero) throws IOException {	
	try {
		CSVWriter writer = new CSVWriter(new FileWriter(csvFile));
		writer.writeAll(fichero);
		writer.close();
	}catch (FileNotFoundException e) {
	    e.printStackTrace();
	} 
}
}