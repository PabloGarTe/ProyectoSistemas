package mx.uv;

public class Comentario {
    private int id;
    private String NombreCliente;
    private String correoCliente;
    private String descripcion;

    public Comentario(String nombreCliente, String correoCliente, String descripcion) {
        setNombreCliente(nombreCliente);
        this.setCorreoCliente(correoCliente);
        this.setDescripcion(descripcion);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Comentario() {
	}

	public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCorreoCliente() {
        return correoCliente;
    }

    public void setCorreoCliente(String correoCliente) {
        this.correoCliente = correoCliente;
    }

    public String getNombreCliente() {
        return NombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.NombreCliente = nombreCliente;
    }
    @Override
    public String toString() {
        return "ProyectoVO{" + "correo=" + correoCliente + ", nombre=" + NombreCliente + ", comentario=" + descripcion + '}';
    }

    public Comentario(int id, String nombreCliente, String correoCliente, String descripcion) {
        this.id = id;
        NombreCliente = nombreCliente;
        this.correoCliente = correoCliente;
        this.descripcion = descripcion;
    }
    
    
}