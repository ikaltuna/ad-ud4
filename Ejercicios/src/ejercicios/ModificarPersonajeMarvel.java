package ejercicios;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class ModificarPersonajeMarvel {
    public static void main(String[] args) throws IOException {
    	final int long_registro = 168; //Longitud del registro 
    	
		try	{
			File fichero = new File("marvel.dat");
			RandomAccessFile file = new RandomAccessFile(fichero, "rw");
			String dniConsola;
			int idFichero,pesoConsola, posicion, peso;
			String dniFichero, nomsFichero, identidadesFichero, tiposFichero;
			Boolean existe = false;
		
			
			System.out.println("Introduzca el DNI (con letra) del personaje para control de peso:");
			dniConsola = Consola.readString();
			
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
				file.readInt();
	
				if (dniFichero.substring(0,9).equals(dniConsola)) {
					existe = true;
					System.out.println("Introduzca su peso actual");
					pesoConsola = Consola.readInt();
					if (pesoConsola < peso ) {
						int pesoAct = peso-pesoConsola;
						System.out.println(nomsFichero.trim() + " ha adelgazado " + pesoAct + " kilos.");
					}
					if (pesoConsola > peso ) {
						int pesoAct = pesoConsola-peso;
						System.out.println(nomsFichero.trim() + " ha engordado " + pesoAct + " kilos.");
					}
					if (pesoConsola == peso ) {
						System.out.println(nomsFichero.trim() + " se mantene en su peso anterior");
					}
					
				}


			}
			file.close();
			if(!existe)
				System.out.println("El género introducido no existe.");
			
		} 
		catch (FileNotFoundException e){}
		
	}
}