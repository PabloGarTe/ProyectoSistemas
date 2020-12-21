package mx.uv;

public class Venta {
    private String NombreCliente;
    private String tarjeta;
    private String clave;

    public Venta() {
    }

    public String getNombreCliente() {
        return NombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.NombreCliente = nombreCliente;
    }

    public String getTarjeta() {
        return tarjeta;
    }

    public void setTarjeta(String tarjeta) {
        this.tarjeta = tarjeta;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public Venta(String nombreCliente, String tarjeta, String clave) {
        NombreCliente = nombreCliente;
        this.tarjeta = tarjeta;
        this.clave = clave;
    }

    

  
    

    
}
