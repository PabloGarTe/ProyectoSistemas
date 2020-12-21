package mx.uv;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.Route;

public class FormRegisterProd implements Route{
   
    @Override
    
    public Object handle(Request request, Response response) throws Exception {
        String nombreProducto =request.queryParams("nombreProducto");
        String precioProducto=request.queryParams("precioProducto");
        String descripcionProducto=request.queryParams("descripcionProducto");
        String imagenProducto=request.queryParams("imagenProducto");

        System.out.println(nombreProducto);
        System.out.println(precioProducto);
        System.out.println(descripcionProducto);
        System.out.println(imagenProducto);
        float precio = Float.parseFloat(precioProducto);
        
       
       
        Producto producto=new Producto(nombreProducto,precio,descripcionProducto,imagenProducto);
        Producto_DAO imple =new Producto_DAO();
        imple.crearUsuario(producto);

        
        response.redirect("/LoginForm");
        return null;
    }
}