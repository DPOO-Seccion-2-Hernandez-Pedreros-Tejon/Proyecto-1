package Controller;

import java.io.Serializable;
import java.util.ArrayList;

public class Proyecto implements Serializable{
	
	public String nombre;	
	public String descripcion;	
	public String fechaInicio;	
	public String fechaEstimada;
	public Participante duenio;
	public ArrayList<Participante> miembros;
	public ArrayList<Actividad> actividades;
	
	public String getNombre() {
		return nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public String getFechaInicio() {
		return fechaInicio;
	}
	public String getFechaEstimada() {
		return fechaEstimada;
	}
	public Participante getDuenio() {
		return duenio;
	}
	public ArrayList<Participante> getMiembros() {
		return miembros;
	}
	public ArrayList<Actividad> getActividades() {
		return actividades;
	}
	

	public Proyecto(String nombre, String descripcion, String fechaInicio, 
			String fechaEstimada, Participante duenio) 
	{
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.fechaInicio = fechaInicio;
		this.fechaEstimada = fechaEstimada;
		this.duenio = duenio;
		this.miembros = new ArrayList<Participante>();
		this.actividades = new ArrayList<Actividad>();
		this.miembros.add(duenio);
	}	

}
