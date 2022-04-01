package Controller;

import java.util.ArrayList;

public class Actividad 
{
	public String nombre;
	public String tipo;
	public String fecha;
	public String horaInicio;
	public String horaFinal;
	public String descripcion;
	public float tiempoUsado;
	public boolean finalizada;
	public ArrayList<String> fechasPausa;
	public ArrayList<String>  fechasReanudar;
	public String getNombre() {
		return nombre;
	}
	public String getTipo() {
		return tipo;
	}
	public String getFecha() {
		return fecha;
	}
	public String getHoraInicio() {
		return horaInicio;
	}
	public String getHoraFinal() {
		return horaFinal;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public float getTiempoUsado() {
		return tiempoUsado;
	}
	public boolean isFinalizada() {
		return finalizada;
	}
	public String[] getFechasPausa() {
		return fechasPausa;
	}
	public String[] getFechasReanudar() {
		return fechasReanudar;
	}
	public Actividad(String nombre, String tipo, String fecha, String horaInicio, String horaFinal, String descripcion) 
	{
		this.nombre = nombre;
		this.tipo = tipo;
		this.fecha = fecha;
		this.horaInicio = horaInicio;
		this.horaFinal = horaFinal;
		this.descripcion = descripcion;
		this.tiempoUsado = 0;
		this.finalizada = false;
	}
	
	public void finalizarActividad(Actividad actividad)
	{
		actividad.finalizada = true;
	}
	
	
	
	
	
	
	
}
