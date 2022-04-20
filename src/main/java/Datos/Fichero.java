package Datos;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import com.opencsv.CSVWriter;

public class Fichero {

		String csvFile = "vgsales.csv";
		BufferedReader br = null;
		String line = "";
		String split = ",";
		ArrayList<String[]> fichero = new ArrayList<>();

	public ArrayList<String[]> leerCSV() throws IOException{
		try {
		    br = new BufferedReader(new FileReader(csvFile));
		    while ((line = br.readLine()) != null) {
			    fichero.add(line.split(split));
			}
		} catch (FileNotFoundException e) {
		    e.printStackTrace();
		} finally {
		    if (br != null) {
		        try {
		            br.close();
		        } catch (IOException e) {
		            e.printStackTrace();
		        }
		    }
		}
		return fichero;
	}
	
	public void escribirCSV(ArrayList<String[]> fichero) throws IOException {	
		try {
			CSVWriter writer = new CSVWriter(new FileWriter("vgsales.csv"));
			writer.writeAll(fichero);
			writer.close();
		}catch (FileNotFoundException e) {
		    e.printStackTrace();
		} finally {
		    if (br != null) {
		        try {
		            br.close();
		        } catch (IOException e) {
		            e.printStackTrace();
		        }
		    }
		}
	}

}
