package Controller;

public class Actividad 
{
	public String nombre;
	public String tipo;
	public String fecha;
	public String horaInicio;
	public String horaFinal;
	public String descripcion;
	public String tiempoUsado;
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public String getHoraInicio() {
		return horaInicio;
	}
	public void setHoraInicio(String horaInicio) {
		this.horaInicio = horaInicio;
	}
	public String getHoraFinal() {
		return horaFinal;
	}
	public void setHoraFinal(String horaFinal) {
		this.horaFinal = horaFinal;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getTiempoUsado() {
		return tiempoUsado;
	}
	public void setTiempoUsado(String tiempoUsado) {
		this.tiempoUsado = tiempoUsado;
	}
	public Actividad(String nombre, String tipo, String fecha, String horaInicio, String horaFinal, String descripcion,
			String tiempoUsado) 
	{
		this.nombre = nombre;
		this.tipo = tipo;
		this.fecha = fecha;
		this.horaInicio = horaInicio;
		this.horaFinal = horaFinal;
		this.descripcion = descripcion;
		this.tiempoUsado = tiempoUsado;
	}
	
	
	
}
