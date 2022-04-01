package Controller;

public class Reporte 
{
	public float tiempoTotal;
	public float tiempoProm;
	public float tiempoDia;
	public String getTiempoTotal() {
		return tiempoTotal;
	}
	public void setTiempoTotal(String tiempoTotal) {
		this.tiempoTotal = tiempoTotal;
	}
	public String getTiempoProm() {
		return tiempoProm;
	}
	public void setTiempoProm(String tiempoProm) {
		this.tiempoProm = tiempoProm;
	}
	public String getTiempoDia() {
		return tiempoDia;
	}
	public void setTiempoDia(String tiempoDia) {
		this.tiempoDia = tiempoDia;
	}
	
	public Reporte(float tiempoTotal, float tiempoProm, float tiempoDia) 
	{
		this.tiempoTotal = tiempoTotal;
		this.tiempoProm = tiempoProm;
		this.tiempoDia = tiempoDia;
	}
	
}
