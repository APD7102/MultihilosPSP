package t2psp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static int nCamellos, recorrido = 0;
	public static void main(String[] args) throws IOException 
	{	
		// Pregunta el número de camellos y el recorrido de la carrera
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("¿Cuántos camellos van a correr?");
		
		nCamellos = Integer.parseInt(br.readLine());
		
		
		System.out.println("¿Cuántas casillas son necesarias recorrer para alcanzar la meta?");
		
		recorrido = Integer.parseInt(br.readLine());
		
		
		// Crea un hilo por cada camello
		
		for(int i=0; i<nCamellos; i++) 
			
			{	
				new Thread(new Hilos(i+1, new Camello())).start();
			}
		
		br.close();
	}
} 