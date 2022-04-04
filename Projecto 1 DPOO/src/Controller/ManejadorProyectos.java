package Controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class ManejadorProyectos implements Serializable{
	public Participante usuarioActual;
	public ArrayList<Proyecto> proyectosCargados;
	public Proyecto proyectoActual;
	public ArrayList<Participante> usuarios;
	private static final String LOG_FILE = "error.log";
	private String archivoProyectos;
	private String archivoUsuarios;
	
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

	public ManejadorProyectos(Participante pusuarioActual, String parchivoProyectos, String parchivoUsuarios)
	{
	   this.usuarioActual = pusuarioActual;
	   this.archivoProyectos = parchivoProyectos;
	   this.archivoUsuarios = parchivoUsuarios;
	}
	
	public void cargarProyectos() throws PersistenciaException
	{
		// Cargar Proyectos
		   File archivo = new File( archivoProyectos );
		   if( archivo.exists( ) )
		   {
		       // El archivo existe: se debe recuperar de allí el estado del modelo del mundo
			   try
		       {
		           ObjectInputStream ois = new ObjectInputStream( new FileInputStream( archivo ) );
		           proyectosCargados = ( ArrayList<Proyecto> )ois.readObject( );
		           ois.close( );
		       }
		       catch( Exception e )
		       {
		           // Se atrapan en este bloque todos los tipos de excepción
		           registrarError( e );
		           throw new PersistenciaException( "Error fatal: imposible restaurar el estado del programa (" + e.getMessage( ) + ")" );
		        }
	       }
		   else
		   {
		       // El archivo no existe: es la primera vez que se ejecuta el programa
		       proyectosCargados = new ArrayList<Proyecto>( );
		   }
	}
	
	public void cargarUsuarios() throws PersistenciaException
	{
		//Cargar Usuarios
		   File archivo = new File( archivoUsuarios );
		   if( archivo.exists( ) )
		   {
		       // El archivo existe: se debe recuperar de allí el estado del modelo del mundo
			   try
		       {
		           ObjectInputStream ois2 = new ObjectInputStream( new FileInputStream( archivo ) );
		           usuarios = ( ArrayList<Participante> )ois2.readObject( );
		           ois2.close( );
		       }
		       catch( Exception e )
		       {
		           // Se atrapan en este bloque todos los tipos de excepción
		           registrarError( e );
		           throw new PersistenciaException( "Error fatal: imposible restaurar el estado del programa (" + e.getMessage( ) + ")" );
		        }
	       }
		   else
		   {
		       // El archivo no existe: es la primera vez que se ejecuta el programa
		       usuarios = new ArrayList<Participante>( );
		   }
	}
	
	public void salvarDatos( ) throws PersistenciaException
    {
        try
        {
            ObjectOutputStream oos = new ObjectOutputStream( new FileOutputStream( archivoProyectos ) );
            oos.writeObject( proyectosCargados );
            oos.close( );
        }
        catch( IOException e )
        {
            registrarError( e );
            throw new PersistenciaException( "Error al salvar: " + e.getMessage( ) );
        }
        
        try
        {
            ObjectOutputStream oos = new ObjectOutputStream( new FileOutputStream( archivoUsuarios ) );
            oos.writeObject( usuarios );
            oos.close( );
        }
        catch( IOException e )
        {
            registrarError( e );
            throw new PersistenciaException( "Error al salvar: " + e.getMessage( ) );
        }
    }
	
	
	public void registrarError( Exception excepcion )
    {
        try
        {
            FileWriter out = new FileWriter( LOG_FILE, true );
            PrintWriter log = new PrintWriter( out );
            log.println( "---------------------------------------" );
            log.println( "ManejadorProyectos.java :" + new Date( ).toString( ) );
            log.println( "---------------------------------------" );
            excepcion.printStackTrace( log );
            log.close( );
            out.close( );
        }
        catch( IOException e )
        {
            excepcion.printStackTrace( );
            e.printStackTrace( );
        }
    }
}
