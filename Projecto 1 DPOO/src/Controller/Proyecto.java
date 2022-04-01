package Controller;

import java.util.ArrayList;

public class Proyecto {
	
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

	public void actualizarInfo()
	{
		
	}
	
	public String darNombre() 
	{
		return this.nombre;
	}
	
	public String darDescripcion() 
	{
		return this.descripcion;
	}

	public String darFechaInicio() 
	{
		return this.fechaInicio;
	}
	
	public String darFechaEstimada() 
	{
		return this.fechaEstimada;
	}
	

}
