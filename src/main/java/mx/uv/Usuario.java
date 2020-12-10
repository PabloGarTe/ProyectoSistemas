package mx.uv;

public class Usuario {
    private String nombre;
    private String apellidos;
    private String direccion;
    private String correo;
    private String contrasena;
    private String ciudad;
    private String codigoPostal;

    

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public void setNombre(String nombre) {
		this.nombre = nombre;
	}

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public Usuario() {
    }

    public Usuario(String nombre, String apellidos, String direccion, String correo, String contrasena, String ciudad,
            String codigoPostal) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.direccion = direccion;
        this.correo = correo;
        this.contrasena = contrasena;
        this.ciudad = ciudad;
        this.codigoPostal = codigoPostal;
    }
     

}

