package Controller;

import java.io.Serializable;
import java.util.ArrayList;

public class Participante implements Serializable{
	private String nombre;
	private String correo;
	private float tiempoTotal = 0;
	private float tiempoProm = 0;
	private float tiempoDia = 0;
	public ArrayList<Actividad> actividadesParticipante;
	public ArrayList<Proyecto> proyectosParticipante;
	public int numActividades = 0;
	
	
	
	public ArrayList<Actividad> getActividadesParticipante() {
		return actividadesParticipante;
	}
	public ArrayList<Proyecto> getProyectosParticipante() {
		return proyectosParticipante;
	}
	public int getNumActividades() {
		return numActividades;
	}
	public void sumarActividad() {
		this.numActividades += 1;
	}

	public float getTiempoTotal() {
		return tiempoTotal;
	}
	public void sumarTiempoTotal(float tiempoActividad) {
		this.tiempoTotal += tiempoActividad;
	}
	public float getTiempoProm() {
		return tiempoProm;
	}
	public void setTiempoProm(float tiempoActividad) {
		if (getNumActividades() != 0)
		{
			this.tiempoProm = ((this.tiempoProm + tiempoActividad/getNumActividades())*getNumActividades())/getNumActividades()+1;
		}
		else
		{
			this.tiempoProm = tiempoActividad;
		}
		sumarActividad();
	}
	public float getTiempoDia() {
		return tiempoDia;
	}
	public void sumarTiempoDia(float tiempoDia) 
	{
		this.tiempoDia = tiempoDia;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public Participante(String nombre, String correo)
	{
		this.nombre = nombre;
		this.correo = correo;
		this.actividadesParticipante = new ArrayList<Actividad>();
		this.proyectosParticipante = new ArrayList<Proyecto>();
	}
	
	public void actualizarInfo()
	{
		
	}
	
	
	public Reporte darReporte(){
		{
			Reporte reporte = new Reporte(getTiempoTotal(), getTiempoProm(), getTiempoDia());
			return reporte;
		}
	}
	
	
	public void pausarCronometro(Actividad actividad, String fecha)
	{
		
	}
	
	
	
}
