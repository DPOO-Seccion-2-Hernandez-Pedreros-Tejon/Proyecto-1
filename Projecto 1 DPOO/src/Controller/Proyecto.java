package Controller;

public class Proyecto {
	
	public String nombre;
	
	public String descripcion;
	
	public String fechaInicio;
	
	public String fechaEstimada;
	
	public void Proyecto(String nombre, String descripcion, String fechaInicio, String fechaEstimada)
	{
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.fechaInicio = fechaInicio;
		this.fechaEstimada = fechaEstimada;
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
	
	public Participante[] darMiembros()
	{
		
	}
	
	public Participante darDueño()
	{
		
	}
	
	public Actividad[] darActividades()
	{
		
	}
}
