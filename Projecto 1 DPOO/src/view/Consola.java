package view;
import Controller.Actividad;
import Controller.ManejadorProyectos;
import Controller.Participante;
import Controller.PersistenciaException;
import Controller.Proyecto;
import Controller.Cronometro;
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
	
	public static void cargarDatosM() throws PersistenciaException
	{
		String archivoProyectos = "datosProyectos";
		String archivoUsuarios = "datosUsuarios";
		manejadorProyectos = new ManejadorProyectos(usuarioActual, archivoProyectos, archivoUsuarios);
		cargarProyectos();
		cargarUsuarios();
	}
	
	public static ArrayList<Proyecto> cargarProyectos() throws PersistenciaException 
	{
		manejadorProyectos.cargarProyectos();
		return null;
	}
	
	public static ArrayList<Participante> cargarUsuarios() throws PersistenciaException 
	{
		manejadorProyectos.cargarUsuarios(); 
		return null;
	}
	
	public void mostrarMenuInicio()
	{
		boolean seguir = true;
		while (seguir)
		{
			try
			{
				int opcion_seleccionada = Integer.parseInt(input("Bienvenid@ " + usuarioActual.getNombre() 
				+ ", Elige una de las opciones: \n "
				+ "1. Abrir un proyecto antiguo \n "
				+ "2. Crear un nuevo proyecto \n "
				+ "3. Dar reporte usuario \n "
				+ "4. Cambiar usuario \n 0. "
				+ "Salir \n Opción"));
				if (opcion_seleccionada == 1) 
				{
					ArrayList<Proyecto> proyectosP = manejadorProyectos.proyectosCargados;
				
					if (!proyectosP.isEmpty())
					{
						System.out.println("Lista de proyectos:");
						int i = 1;
						for (Proyecto p: proyectosP)
						{
							String indice = String.valueOf(i);
							System.out.println(indice + ". " + p.nombre );
							i ++;
						}
					
						int inputP =  Integer.parseInt(input("Elige el número proyecto que deseas abrir"));
					
						Proyecto proyectoActual = proyectosP.get(inputP - 1);
						manejadorProyectos.proyectoActual = proyectoActual;
						mostrarMenuProyecto(proyectoActual);
					}
					else
					{
						System.out.println("No hay ningún proyecto cargado.\n");
					}
				}
				else if (opcion_seleccionada == 2) 
				{	
					String nombre = input("Ingresa el nombre de tu nuevo proyecto");
				
					String descripcion = input("Escribe una breve descripción de tu nuevo proyecto");
				
					String fechaInicio = getCurrentDate();
				
					String fechaEstimada = input("Ingresa la fecha estimada de finalización del proyecto en formato dd/MM/yyyy");

					Proyecto proyectoActual = new Proyecto(nombre, descripcion, fechaInicio, fechaEstimada, usuarioActual);
				
					manejadorProyectos.proyectosCargados.add(proyectoActual);
				
					manejadorProyectos.proyectoActual = proyectoActual;
					
					manejadorProyectos.salvarDatos();
				
					mostrarMenuProyecto(proyectoActual);
				}
				else if (opcion_seleccionada == 3) 
				{
					String usuario = input("Ingresa el nombre del usuario");
					for (Participante o: manejadorProyectos.usuarios)
					{
						if (usuario.equals(o.getNombre()))
						{
							System.out.println();
							System.out.println("EL usuario " 
										+ o.getNombre()
										+ " ha trabajado un tiempo total de "
										+ o.getTiempoTotal()
										+ " y ha invertido en promedio"
										+ " por actividad un tiempo de "
										+ o.getTiempoProm());
						}
					}
					
				}
				
					
				else if (opcion_seleccionada == 4) 
				{
					iniciarSesion();
					//cra7 47 23
					//431 403
				}
				else if (opcion_seleccionada == 0) 
				{
					System.out.println("Sesión cerrada.");
					seguir = false;
				}
				
			}
			catch (Exception e)
			{
				System.out.println("Ha habido un error leyendo el input :c ");
				e.printStackTrace();
			}
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
			String stringMiembros = "(";
			for (Participante n: proyectoActual.miembros)
			{
				stringMiembros += (" " + n.getNombre() + ",");
			}
			int ln = stringMiembros.length();
			stringMiembros = stringMiembros.substring(0, ln - 1);
			stringMiembros += " )";
			
			int opcion_seleccionada = Integer.parseInt(input(
					"INFORMACIÓN DEL PROYECTO: \n"
					+ "NOMBRE: " + proyectoActual.getNombre()
					+ "\n DESCRIPCIÓN: " + proyectoActual.getDescripcion()
					+ "\n FECHA DE INICIO: " + proyectoActual.getFechaInicio()
					+ "\n FECHA ESTIMADA DE FINALIZACIÓN: " + proyectoActual.getFechaEstimada()
					+ "\n DUEÑO: " + proyectoActual.getDuenio().getNombre()
					+ "\n PARTICIPANTES: " + stringMiembros
					+ "\n \nElige una de las opciones: \n "
					+ "1. Subir una nueva actividad \n "
					+ "2. Ver las actividades \n 0. Volver\nOpción"));
			if (opcion_seleccionada == 1) 
			{
				String nombre = input("Ingresa el nombre de tu nueva actividad");
				
				String tipo = input("Ingresa el tipo de tu nueva actividad");
				
				String descripcion = input("Ingresa una descripción para tu nueva actividad");
				
				String fechaInicio = getCurrentDate();
				
				String horaInicio = getCurrentHour();
				
				Participante usuario = usuarioActual;
				
				
				int opcion_selec = Integer.parseInt(input(
						"¿Desea cambiar el realizador de la actividad?\n"
						+ "1. No.\n"
						+ "2. Sí.\n Opción"));
				
				if (opcion_selec == 1)
				{
					Actividad actividad = new Actividad(nombre,tipo,fechaInicio,				
							horaInicio,descripcion, usuario);
					
					
					
					proyectoActual.actividades.add(actividad);
					usuario.actividadesParticipante.add(actividad);
					int last = proyectoActual.actividades.size() - 1;
					proyectoActual.actividades.get(last).finalizada = false;
					
					long begin = System.currentTimeMillis();
					long end = System.currentTimeMillis();
					Cronometro cronometro = new Cronometro(begin, end);
					cronometro.start();
					
					String estado = "C";
					do {
						
						int continuar = Integer.parseInt(Consola.input(
								"¿Qué desea que haga el cronómetro?, "
								+ "¿Desea pausarlo, que siga corriendo o finalizar la actividad?"
								+ " \n1. Pausar \n2. Seguir corriendo \n3. Finalizar la actividad\n"));
						if (continuar == 1 && estado.equals("C"))
						{
							cronometro.stop();
							estado = "P";
							System.out.println("El cronómetro se ha detenido");
						}
						else if (continuar == 1 && estado.equals("P"))
						{
							System.out.println("El cronómetro ya está detenido");
							
						}
						else if (continuar == 2 && estado.equals("P")) 
						{
							cronometro.start();
							System.out.println("El cronómetro seguirá corriendo...");
						}
						else if (continuar == 2 && estado.equals("C")) 
						{
							System.out.println("El cronómetro ya está corriendo");
						}
						else if (continuar == 3) 
						{
							if (estado.equals("C")) {
								cronometro.stop();
							}	
							
							actividad.finalizarActividad(actividad, cronometro.getTotal());
						}
					} while (actividad.finalizada == false);
					manejadorProyectos.salvarDatos();
					System.out.println("La actividad se demoró: " + cronometro.getTotal() + " segundos");
					
					proyectoActual.actividades.get(last).fechasPausa.add(getCurrentDate());
					proyectoActual.actividades.get(last).horaFinal = getCurrentHour();
					//usuarioActual.actividadesParticipante.add(proyectoActual.actividades.get(last));
					System.out.println("La actividad " + actividad.nombre 
							+ " ha sido finalizada en la fecha " + getCurrentDate()
							+ " a las " + getCurrentHour());
					mostrarMenuProyecto(proyectoActual);
				}
				if (opcion_selec == 2)
				{
					
					String nombreUsuario = input("Ingrese el nombre del usuario realizador");
					boolean aux = true;
					for (Participante p: manejadorProyectos.usuarios) 
					{
						if (p.getNombre().equals(nombreUsuario)) 
						{
							usuario = p;
							aux = false;
						}
					}
					if (!aux)
					{
						Actividad actividad = new Actividad(nombre,tipo,fechaInicio,				
								horaInicio,descripcion, usuario);
						
						long begin = System.currentTimeMillis();
						long end = System.currentTimeMillis();
						Cronometro cronometro = new Cronometro(begin, end);
						cronometro.start();
						
						String estado = "C";
						do {
							
							int continuar = Integer.parseInt(Consola.input(
									"¿Qué desea que haga el cronómetro?, "
									+ "¿Desea pausarlo, que siga corriendo o finalizar la actividad?"
									+ " \n1. Pausar \n2. Seguir corriendo \n3. Finalizar la actividad\n"));
							if (continuar == 1 && estado.equals("C"))
							{
								cronometro.stop();
								estado = "P";
								System.out.println("El cronómetro se ha detenido");
							}
							else if (continuar == 1 && estado.equals("P"))
							{
								System.out.println("El cronómetro ya está detenido");
								
							}
							else if (continuar == 2 && estado.equals("P")) 
							{
								cronometro.start();
								System.out.println("El cronómetro seguirá corriendo...");
							}
							else if (continuar == 2 && estado.equals("C")) 
							{
								System.out.println("El cronómetro ya está corriendo");
							}
							else if (continuar == 3) 
							{
								if (estado.equals("C")) {
									cronometro.stop();
								}	
								
								actividad.finalizarActividad(actividad, cronometro.getTotal());
							}
						} while (actividad.finalizada == false);
						manejadorProyectos.salvarDatos();
						System.out.println("La actividad se demoró: " + cronometro.getTotal() + " segundos");
						
						
						proyectoActual.actividades.add(actividad);
						usuario.actividadesParticipante.add(actividad);
						System.out.println("La actividad " + actividad.nombre 
								+ " ha sido finalizada en la fecha " + getCurrentDate()
								+ " a las " + getCurrentHour());
						mostrarMenuProyecto(proyectoActual);
					}
					else
					{
						System.out.println("No se encontr� un usuario registrado con ese nombre. No se pudo crear la actividad.");
					}
				}
			}
			else if (opcion_seleccionada == 2) 
			{
				ArrayList<Actividad> actividades = proyectoActual.getActividades();
				
				if (!actividades.isEmpty())
				{
					System.out.println("Lista de actividades");
					int i = 1;
					for (Actividad p: actividades)
					{
						String indice = String.valueOf(i);
						System.out.println("Actividad " + indice + ".");
						System.out.println("NOMBRE: " + p.getNombre()
						+ "\n DESCRIPCIÓN: " + p.getDescripcion()
						+ "\n TIPO: " + p.getTipo()
						+ "\n FECHA DE REALIZACIÓN: " + p.getFecha()
						+ "\n HORA DE INICIO: " + p.getHoraInicio()
						+ "\n HORA DE FINALIZACIÓN: " + p.getHoraFinal()
						+ "\n REALIZADOR: " + p.getMiembro().getNombre() + "\n");
						i ++;
					}
				
					int inputP =  Integer.parseInt(input("Escoja el número de actividad a modificar (para volver marque 0)"));
					inputP -= 1;
					if (inputP != (-1))
					{
						modificarActividad(inputP, proyectoActual);
					}
				}
				else
				{
					System.out.println("No hay ningúna actividad cargada.\n");
				}
				mostrarMenuProyecto(proyectoActual);
			}
		}
		catch (Exception e)
		{
			System.out.println("Ha habido un error leyendo el input D:");
			e.printStackTrace();
		}
	}
	
	public void modificarActividad (int no, Proyecto proyectoActual) throws PersistenciaException
	{
		Actividad actividad = proyectoActual.actividades.get(no);
		int opcion = Integer.parseInt(input("Escoja el campo a modificar: "
		+ "\n 1. DESCRIPCIÓN "
		+ "\n 2. TIPO"
		+ "\n 3. FECHA DE REALIZACIÓN"
		+ "\n 4. HORA DE INICIO"
		+ "\n 5. HORA DE FINALIZACIÓN"
		+ "\n Opción"));
		
		if (opcion == 1)
		{
			String valor = input("Escriba la nueva descripción");
			actividad.setDescripcion(valor);
			System.out.println("Se modificó la actividad con éxito.");
		}
		else if (opcion == 2)
		{
			String valor = input("Escriba el nuevo tipo");
			actividad.setTipo(valor);
			System.out.println("Se modificó la actividad con éxito.");	
		}
		else if (opcion == 3)
		{
			String valor = input("Escriba la nueva fecha (dd/mm/yyyy)");
			actividad.setFecha(valor);
			System.out.println("Se modificó la actividad con éxito.");	
		}
		else if (opcion == 4)
		{
			String valor = input("Escriba la nueva hora de inicio (hh:mm:ss)");
			actividad.setHoraInicio(valor);
			System.out.println("Se modificó la actividad con éxito.");	
		}
		else if (opcion == 5)
		{
			String valor = input("Escriba la nueva hora final (hh:mm:ss)");
			actividad.setHoraFinal(valor);
			System.out.println("Se modificó la actividad con éxito.");	
		}
		manejadorProyectos.salvarDatos();
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
	
	public static void main(String[] args) throws PersistenciaException 
	{
		cargarDatosM();
		System.out.println("Bienvenido al Project Manager");
		iniciarSesion();
	}
	
	public static void iniciarSesion() throws PersistenciaException
	{
		int opcion_seleccionada = Integer.parseInt(input(
				"\nElige una de las opciones: \n "
				+ "1. Iniciar sesión con un usuario existente \n "
				+ "2. Crear un nuevo usuario \nOpción"));
		if (opcion_seleccionada == 1) 
		{
			String nombre = input("Ingrese su nombre de usuario");
			boolean aux = false;
			for (Participante p: manejadorProyectos.usuarios)
			{
				if (nombre.equals(p.getNombre()))
				{
					aux = true;
					usuarioActual = p;
				}
			}
			if (aux)
			{
				Consola consola = new Consola();
				consola.mostrarMenuInicio();
			}
			else
			{
				System.out.println("No existe un usuario con ese nombre, vuelva a intentarlo. \n");
				main(null);
			}
		}
		else if (opcion_seleccionada == 2) 
		{
			String nombre = input("Ingrese su nombre de usuario");
			String correo = input("Ingrese su correo");
			boolean aux = false;
			for (Participante p: manejadorProyectos.usuarios)
			{
				if (nombre.equals(p.getNombre()) || correo.equals(p.getCorreo()))
				{
					aux = true;
				}
			}
			if (aux)
			{
				System.out.println("Ya existe un usuario con el mismo nombre o el mismo correo. \n");
				main(null);
			}
			else
			{
				usuarioActual = new Participante(nombre, correo);
				manejadorProyectos.usuarios.add(usuarioActual);
				manejadorProyectos.salvarDatos();
				Consola consola = new Consola();
				consola.mostrarMenuInicio();
			}
		}
		else
		{
			System.out.println("Escoja una opción válida.");
		}
	}
}