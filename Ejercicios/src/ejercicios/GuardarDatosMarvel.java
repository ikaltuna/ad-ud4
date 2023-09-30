package ejercicios;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class GuardarDatosMarvel {
	public static void main(String[] args) throws IOException { 
		final int long_registro = 168; //Longitud del registro 
		File fichero = new File("Marvel.dat");
		if(fichero.exists()){
			fichero.delete();
		}
		RandomAccessFile file = new RandomAccessFile(fichero, "rw");
        int[] ids = {1, 2, 3, 4, 5, 6, 7};
        String[] dnis = {"01010101A", "03030303C", "05050505E", "07070707G", "02020202B", "04040404D", "06060606F"};
        String[] noms = {"Spiderman", "Green Goblin", "Storm", "Wolverine", "Mystique", "IronMan", "Mandarin"};
        String[] identidades = {"Peter Parker", "Norman Osborn", "Ororo Munroe", "James Howlett", "Raven Darkholme", "Tony Stark", "Zhang Tong"};
        String[] tipos = {"heroe", "villano", "heroe", "heroe", "villano", "heroe", "villano"};
        int[] pesos = {76, 84, 66, 136, 78, 102, 70};
        int[] alturas = {178, 183, 156, 152, 177, 182, 188};

		StringBuffer bufferDnis = null;
		StringBuffer bufferNoms = null;
		StringBuffer bufferIdentidades = null;
		StringBuffer bufferTipos = null;
		int cuantos=ids.length;
		int posicion = 0;
				
		for (int i=0;i<cuantos; i++){
			posicion=i*long_registro;
			file.seek(posicion);
			
			file.writeInt(ids[i]);
			
			bufferDnis = new StringBuffer( dnis[i] );      //Dnis
			bufferDnis.setLength(20); 
			file.writeChars(bufferDnis.toString());
			
			bufferNoms = new StringBuffer( noms[i] );      //Nombres
			bufferNoms.setLength(20); 
			file.writeChars(bufferNoms.toString());
			
			bufferIdentidades = new StringBuffer( identidades[i] );      //Identidades
			bufferIdentidades.setLength(20); 
			file.writeChars(bufferIdentidades.toString());
			
			bufferTipos = new StringBuffer( tipos[i] );      //Tipos
			bufferTipos.setLength(20); 
			file.writeChars(bufferTipos.toString());
			
			file.writeInt(pesos[i]);
			
			
			file.writeInt(alturas[i]);
		 }     
		file.close();
		System.out.println("La carga de los personajes ha terminado correctamente.");			
	 }
}
