package Controller;

public class Reporte 
{
	public float tiempoTotal;
	public float tiempoProm;
	public float tiempoDia;
	public float getTiempoTotal() {
		return tiempoTotal;
	}
	public void setTiempoTotal(float tiempoTotal) {
		this.tiempoTotal = tiempoTotal;
	}
	public float getTiempoProm() {
		return tiempoProm;
	}
	public void setTiempoProm(float tiempoProm) {
		this.tiempoProm = tiempoProm;
	}
	public float getTiempoDia() {
		return tiempoDia;
	}
	public void setTiempoDia(float tiempoDia) {
		this.tiempoDia = tiempoDia;
	}
	
	public Reporte(float tiempoTotal, float tiempoProm, float tiempoDia) 
	{
		this.tiempoTotal = tiempoTotal;
		this.tiempoProm = tiempoProm;
		this.tiempoDia = tiempoDia;
	}
	
}
