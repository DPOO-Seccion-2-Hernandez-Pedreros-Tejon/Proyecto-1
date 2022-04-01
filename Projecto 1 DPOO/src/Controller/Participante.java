package Controller;

import java.util.ArrayList;

public class Participante {
	public String nombre;
	public String correo;
	public float tiempoTotal;
	public float tiempoProm;
	public float tiempoDia;
	public ArrayList<Actividad> actividadesParticipante;
	public ArrayList<Proyecto> protectosParticipante;
	public int numActividades;
	
	
	
	public int getNumActividades() {
		return numActividades;
	}
	public void sumarActividad() {
		this.numActividades += 1;
	}
	public void setTiempoTotal(float tiempoTotal) {
		this.tiempoTotal = tiempoTotal;
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
		this.tiempoProm = (this.tiempoProm + tiempoActividad)/getNumActividades()+1;
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
	}
	
	public void actualizarInfo()
	{
		
	}
	
	public Proyecto[] darProyectosParticipante()
	{
		
	}
	
	public Actividad[] darActividadesParticipante()
	{
	
	}
	
	public Reporte darReporte(){
		{
			Reporte reporte = new Reporte(getTiempoTotal(), getTiempoProm(), getTiempoDia());
			return reporte;
		}
	}
	
	public void subirActividad(String nombre, String tipo, String fecha, String horaInicio, String horaFinal, String descripcion, String tiempoUsado)
	{
		Actividad actividad = new Actividad(nombre, tipo, fecha, horaInicio, horaFinal, descripcion);
		actividadesParticipante.add(actividad);
		
	}
	
	public void pausarCronometro(Actividad actividad, String fecha)
	{
		Actividad.
	}
	
	
	
}
