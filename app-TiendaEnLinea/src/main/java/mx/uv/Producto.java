package mx.uv;

public class Producto {
    private String nombre;
    private float precioProducto;
    private String descripcionProducto;
    private String imagenProducto;

    public Producto() {

    }
    public Producto(String nombre, float precioProducto, String descripcionProducto, String imagenProducto) {
        this.setNombre(nombre);
        this.setPrecioProducto(precioProducto);
        this.setDescripcionProducto(descripcionProducto);
        this.setImagenProducto(imagenProducto);
    }

    public String getImagenProducto() {
        return imagenProducto;
    }

    public void setImagenProducto(String imagenProducto) {
        this.imagenProducto = imagenProducto;
    }

    public String getDescripcionProducto() {
        return descripcionProducto;
    }

    public void setDescripcionProducto(String descripcionProducto) {
        this.descripcionProducto = descripcionProducto;
    }

    public float getPrecioProducto() {
        return precioProducto;
    }

    public void setPrecioProducto(float precioProducto) {
        this.precioProducto = precioProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    
    

}
