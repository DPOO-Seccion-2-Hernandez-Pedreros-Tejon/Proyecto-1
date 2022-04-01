package Controller;

import java.util.ArrayList;

public class ManejadorProyectos {
	public Participante usuarioActual;
	public ArrayList<Proyecto> proyectosCargados;
	public Proyecto proyectoActual;
	public ArrayList<Participante> usuarios;
	
	public Participante getUsuarioActual() {
		return usuarioActual;
	}

	public ArrayList<Proyecto> getProyectosCargados() {
		return proyectosCargados;
	}

	public Proyecto getProyectoActual() {
		return proyectoActual;
	}

	
	public void nuevoProyecto(String nombre, String descripcion,
			String fechaInicio, String fechaEstimada,
			Participante duenio)
	{
		proyectoActual = new Proyecto(nombre,descripcion,
				fechaInicio, fechaEstimada,
				 duenio);
		
		proyectosCargados.add(proyectoActual);
	}

	
	public void añadirParticipante(Proyecto proyectoActual)
	{
		
	}
	
	public void generarReporte()
	{
		
	}
	
	public void addActividadProyecto()
	{
		
	}
	
	public void addActividadParticipante()
	{
		
	}
	
	public float calcularTiempoActividad()
	{
		return 1;
		//REEMPLAZAR POR METODO VERDADERO
		//REEMPLAZAR POR METODO VERDADERO
		//REEMPLAZAR POR METODO VERDADERO
		//REEMPLAZAR POR METODO VERDADERO
	}

	public ManejadorProyectos(Participante usuarioActual, ArrayList<Proyecto> proyectosCargados,
			ArrayList<Participante> usuarios) 
	{
		this.usuarioActual = usuarioActual;
		this.proyectosCargados = proyectosCargados;
		this.usuarios = usuarios;
	}

	
	
	
}
