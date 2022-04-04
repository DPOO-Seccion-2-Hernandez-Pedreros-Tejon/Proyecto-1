package Controller;

import java.io.Serializable;
import java.util.ArrayList;

public class Actividad implements Serializable 
{
	public String nombre;
	public Participante miembro;
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
	public Participante getMiembro() {
		return miembro;
	}
	public void setMiembro(Participante miembro) {
		this.miembro = miembro;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public void setHoraInicio(String horaInicio) {
		this.horaInicio = horaInicio;
	}
	public void setHoraFinal(String horaFinal) {
		this.horaFinal = horaFinal;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public ArrayList<String> getFechasPausa() {
		return fechasPausa;
	}
	public ArrayList<String> getFechasReanudar() {
		return fechasReanudar;
	}
	
	public Actividad(String nombre, String tipo, String fecha, 
			String horaInicio, String descripcion, Participante miembro) 
	{
		this.nombre = nombre;
		this.tipo = tipo;
		this.fecha = fecha;
		this.horaInicio = horaInicio;
		this.fechasReanudar = new ArrayList<String>();
		this.fechasPausa = new ArrayList<String>();
		this.fechasReanudar.add(fecha);
		this.descripcion = descripcion;
		this.tiempoUsado = 0;
		this.finalizada = false;
		this.miembro = miembro;
	}
	
	public void finalizarActividad(Actividad actividad)
	{
		actividad.finalizada = true;
	}
	
	
	
	
	
	
	
}
