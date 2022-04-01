package view;
import Controller.Actividad;
import Controller.ManejadorProyectos;
import Controller.Participante;
import Controller.Proyecto;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.time.LocalDateTime; // Import the LocalDateTime class
import java.time.format.DateTimeFormatter; // Import the DateTimeFormatter class 
import java.time.LocalTime; // import the LocalTime class

public class Consola {

	static ManejadorProyectos manejadorProyectos;
	static Participante usuarioActual;
	
	public static void cargarDatosM()
	{
		ArrayList<Proyecto> proyectosCargados = cargarProyectos();
		ArrayList<Participante> usuariosCargados = cargarUsuarios();
		manejadorProyectos = new ManejadorProyectos(usuarioActual, proyectosCargados, usuariosCargados);
	}
	
	public static ArrayList<Proyecto> cargarProyectos() 
	{
		
		//REEMPLAZAR POR CARGA DE PROYECTOS VERDADERA
		//REEMPLAZAR POR CARGA DE PROYECTOS VERDADERA
		//REEMPLAZAR POR CARGA DE PROYECTOS VERDADERA
		//REEMPLAZAR POR CARGA DE PROYECTOS VERDADERA
		ArrayList<Proyecto> proyectosCargados = new ArrayList<Proyecto>(); 
		return proyectosCargados;
	}
	
	public static ArrayList<Participante> cargarUsuarios() 
	{
		
		//REEMPLAZAR POR CARGA DE PROYECTOS VERDADERA
		//REEMPLAZAR POR CARGA DE PROYECTOS VERDADERA
		//REEMPLAZAR POR CARGA DE PROYECTOS VERDADERA
		//REEMPLAZAR POR CARGA DE PROYECTOS VERDADERA
		ArrayList<Participante> usuariosCargados= new ArrayList<Participante>(); 
		return usuariosCargados;
	}
	
	public void mostrarMenuInicio()
	{
		try
		{
			int opcion_seleccionada = Integer.parseInt(input("Elige una de las opciones: \n 1. Abrir un proyecto antiguo \n 2. Crear un nuevo proyecto \n"));
			if (opcion_seleccionada == 1) 
			{
				ArrayList<Proyecto> proyectosP = manejadorProyectos.proyectosCargados;
				
				if (!proyectosP.isEmpty())
				{
					System.out.println("Lista de proyectos");
					int i = 1;
					for (Proyecto p: proyectosP)
					{
						String indice = String.valueOf(i);
						System.out.println(indice + "." + p.nombre );
						i ++;
					}
					
					int inputP =  Integer.parseInt(input("Elige el numero proyecto que deseas abrir "));
					
					Proyecto proyectoActual = proyectosP.get(inputP - 1);
					manejadorProyectos.proyectoActual = proyectoActual;
				}
				else
				{
					System.out.println("No hay ningún proyecto cargado.\n");
					mostrarMenuInicio();
				}
			}
			else if (opcion_seleccionada == 2) 
			{
				String nombre = input("Ingresa el nombre de tu nuevo proyecto");
				
				String descripcion = input("Escribe una breve descripción de tu nuevo proyecto");
				
				String fechaInicio = getCurrentDate();
				
				String fechaEstimada = input("Ingresa la fecha estimada de finalización del proyecto");

				Proyecto proyectoActual = new Proyecto(nombre, descripcion, fechaInicio, fechaEstimada, usuarioActual);
				
				manejadorProyectos.proyectosCargados.add(proyectoActual);
				
				manejadorProyectos.proyectoActual = proyectoActual;
				
				mostrarMenuProyecto(proyectoActual);
			}
		}
		catch (Exception e)
		{
			System.out.println("Ha habido un error leyendo el input D:");
			e.printStackTrace();
		}
		
	}
	
	public static String getCurrentDate() {
		LocalDateTime date = LocalDateTime.now();
		DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	    String strDate = date.format(myFormatObj);
		return strDate;
	}
	
	public static String getCurrentHour() 
	{
		LocalTime horaActual = LocalTime.now();
		DateTimeFormatter horaAct = DateTimeFormatter.ofPattern("HH:mm:ss");
		String fHour = horaActual.format(horaAct);
		return fHour;
	}

	public void pedirMenu()
	{
		
	}
	
	public void cambiarUsuario()
	{
		
	}
	
	public void mostrarMenuProyecto(Proyecto proyectoActual)
	{
		try
		{
			int opcion_seleccionada = Integer.parseInt(input(
					"Elige una de las opciones: \n "
					+ "1. Subir una nueva actividad \n "
					+ "2. Finalizar una actividad \n"));
			if (opcion_seleccionada == 1) 
			{
				String nombre = input("Ingresa el nombre de tu nueva actividad");
				
				String tipo = input("Ingresa el tipo de tu nueva actividad");
				
				String descripcion = input("Ingresa una descripcion para tu nueva actividad");
				
				String fechaInicio = getCurrentDate();
				
				String horaInicio = getCurrentHour();
				
				Actividad actividad = new Actividad(nombre,tipo,fechaInicio,				
						horaInicio,descripcion, usuarioActual);
				
				proyectoActual.actividades.add(actividad);
				usuarioActual.actividadesParticipante.add(actividad);
				
				int opcion_selec = Integer.parseInt(input(
						"Se ha subido la actividad correctamente "
						+ "¿Desea darla por finalizada?\n"
						+ "1. Si.\n"
						+ "2. No.\n"));
				
				if (opcion_selec == 1)
				{
					int last = proyectoActual.actividades.size() - 1;
					proyectoActual.actividades.get(last).finalizada = false;
					proyectoActual.actividades.get(last).fechasPausa.add(getCurrentDate());
					proyectoActual.actividades.get(last).horaFinal = getCurrentHour();
					usuarioActual.actividadesParticipante.add(proyectoActual.actividades.get(last));
					System.out.println("La actividad " + actividad.nombre 
							+ " ha sido finalizada en la fecha " + getCurrentDate()
							+ " a las " + getCurrentHour());
				}
				
				mostrarMenuProyecto(proyectoActual);
			}
			else if (opcion_seleccionada == 2) 
			{
				
			}
		}
		catch (Exception e)
		{
			System.out.println("Ha habido un error leyendo el input D:");
			e.printStackTrace();
		}
	}
	
	public static String input(String mensaje)
	{
		try
		{
			System.out.print(mensaje + ": ");
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			return reader.readLine();
		}
		catch (IOException e)
		{
			System.out.println("Error leyendo de la consola");
			e.printStackTrace();
		}
		return null;
	}
	
	public static void main(String[] args) 
	{
		
		System.out.println("Bienvenido al Project Manager");
		String nombre = input("Ingrese su nombre de usuario");
		String correo = input("Ingrese su correo");
		usuarioActual = new Participante(nombre, correo);
		cargarDatosM();
		
		Consola consola = new Consola();
		consola.mostrarMenuInicio();
		
		
		

	}
}