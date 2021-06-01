package t2psp;

import java.util.Random;

public class Hilos implements Runnable {

	private Camello camello;
	private int nombre;
	private static int listaCamellos[] = new int[Main.nCamellos];
	private boolean ganador = false;
	private static boolean Final = false;
	
	
	public Hilos(int n, Camello c)
	{
		nombre = n;
		camello = c;
	}

	// Función para sacar por pantalla los perdedores de la carrera y para que empiece la carrera
	
	public void run() 
	{
		while(Final == false)
		{
			Carrera();
		}
		if(Final && ganador == false)
		{
			// Integer z = (Main.recorrido - camello.getPosicionCamellos());
			System.out.println("El camello " + nombre + " se ha quedado a " + (Main.recorrido - camello.getPosicionCamellos()) + " posiciones de la meta");
			Thread.interrupted();
		}
	}

	// Movimiento de los camellos
	
	public static int avance()
	{
		int movimiento = 0;
		Random r = new Random();
		int probabilidad = r.nextInt(100);
		// 30% 
		if(probabilidad >= 0 && probabilidad < 30)
		{
			movimiento = 0;
		}
		// Amarillo
		else if(probabilidad >= 30 && probabilidad < 70)
		{
			movimiento = 1;
		}
		// Azul
		else if(probabilidad >= 70 && probabilidad < 90)
		{
			movimiento = 2;
		}
		// Rojo
		else
		{
			movimiento = 3;
		}

		return movimiento;
	}
	
	// Obtiene el movimiento y lo aplica
	
	public int avanceCamello(int movimiento)
	{
		int posicion = camello.getPosicionCamellos();
		int movimientoCamello = posicion + movimiento;
		camello.setPosicionCamellos(movimientoCamello);
		return movimientoCamello;
	}
	
	// Función para saber que camello va en primera posición
	
	public int Camello1()
	{
		int lider = 0;
		for(int i=0; i<listaCamellos.length; i++)
		{
			if(listaCamellos[i] > lider)
			{
				lider = listaCamellos[i];
			}
		}
		return lider;
	}

	// Saca por consola la información de la carrera
	
	public synchronized void Carrera()
	{
		int av = avance();
		listaCamellos[nombre - 1] = avanceCamello(av);
		System.out.println("El camello " + nombre + " avanza " + av + " posiciones, lleva " + camello.getPosicionCamellos() + " posiciones y va a " + (Camello1() - camello.getPosicionCamellos()) + " posiciones del líder");
		if(camello.getPosicionCamellos() >= Main.recorrido)
		{					
			Final = true;
			ganador = true;
			try 
			{			
				Thread.sleep(500);			
				System.out.println("\nUN CAMELLO HA ALCANZADO LA META");
				System.out.println("El Camello " + nombre + " ha ganado la carrera.");
				System.out.println("\nEl ranking ha quedado del siguiente modo:");				
				Thread.interrupted();
			} 
			catch (InterruptedException e) 
			{
				e.printStackTrace();
			}			
		}
		try 
		{
			Thread.sleep(1000);							
		} 
		catch (InterruptedException e) 
		{
			e.printStackTrace();
		}
	}
}