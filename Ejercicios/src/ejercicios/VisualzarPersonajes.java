package ejercicios;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class VisualzarPersonajes {
    public static void main(String[] args) throws IOException {
    	final int long_registro = 168; //Longitud del registro 
    	int tipos = 0;
    	String[] dnis = new String[100];
    	String[] noms = new String[100];
        String[] identidades = new String[100];
        String[] tiposA = new String[100];
        int[] pesos = new int[100];
        int[] alturas = new int[100];
		try	{
			File fichero = new File("marvel.dat");
			RandomAccessFile file = new RandomAccessFile(fichero, "rw");
			String tiposConsola;
			int idFichero,pesoConsola, posicion, peso, altura;
			String dniFichero, nomsFichero, identidadesFichero, tiposFichero;
		
			
			System.out.println("Introduzca un tipo de personaje");
			tiposConsola = Consola.readString();
			
			posicion = 0;
			
			for(int p=0;p<file.length()-168;p+=long_registro){
			
				char  dni[] = new char[20], aux;
				char  nom[] = new char[20], aux1;
				char  identidad[] = new char[20], aux2;
				char  tipo[] = new char[20], aux3;
				file.seek(p);
				idFichero=file.readInt();


				
				//Recorre el dni
				
				for (int i=0; i < dni.length; i++) {
					aux =  file.readChar();
					dni[i] = aux;
				}
				
				//Convierto el string en array del dni
				
				dniFichero = new String (dni);
			
				//Recorre el nombre
				
				for (int i=0; i < nom.length; i++) {
					aux1 =  file.readChar();
					nom[i] = aux1;
				}
				
				//Convierto el string en array del nombre
				
				nomsFichero = new String (nom);
				
				//Recorre las identidades
				
				for (int i=0; i < identidad.length; i++) {
					aux2 =  file.readChar();
					identidad[i] = aux2;
				}
				
				//Convierto el string en array del nombre
				
				identidadesFichero = new String (identidad);
				
				//Recorre los tipos
				
				for (int i=0; i < tipo.length; i++) {
					aux3 =  file.readChar();
					tipo[i] = aux3;
				}
				
				//Convierto el string en array del nombre
				
				tiposFichero = new String (tipo);
				
				peso=file.readInt();
				
				altura=file.readInt();
	
				if (tiposFichero.trim().equals(tiposConsola)) {
					dnis[tipos]=dniFichero;
					noms[tipos]=nomsFichero;
			        identidades[tipos]=identidadesFichero;
			        tiposA[tipos]=tiposFichero;
			        pesos[tipos]=peso;
			        alturas[tipos]=altura;
					tipos++;
					
					
				}

				
			}
			if (tipos > 0 ) {
				System.out.println("Se han encontrado " + tipos + " " +  tiposConsola + "s");
				for (int i=0; i < tipos; i++) {
					System.out.println("Personaje [dni=" + dnis[i].trim() + ", nombre=" + noms[i].trim() + ", identidad=" + identidades[i].trim() + ", tipo=" + tiposA[i].trim() + ", peso=" + pesos[i] + ", altura =" +  alturas[i] + "]");
	
				}

			}
			else{
				System.out.println("No existen " + tiposConsola + "s en el fichero");
			}
			file.close();
			
			
			
		} 
		catch (FileNotFoundException e){}
		
	}
}