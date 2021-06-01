package t2psp;

public class Camello {
	
	private int nombre;
	private int posicionCamello;

	//Getters y setters
	
	public Camello()
	{
		nombre = 0;
		posicionCamello = 0;
	}

	public int getNombreCamellos()
	{
		return nombre;
	}

	public void setNombreCamellos(int nC)
	{
		nombre = nC;
	}

	public int getPosicionCamellos()
	{
		return posicionCamello;
	}

	public void setPosicionCamellos(int pC)
	{
		posicionCamello = pC;
	}
}