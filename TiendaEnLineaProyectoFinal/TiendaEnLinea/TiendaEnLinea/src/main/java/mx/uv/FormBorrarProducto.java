package mx.uv;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.Route;

public class FormBorrarProducto implements Route{
   
    @Override
    public Object handle(Request request, Response response) throws Exception {
        String nombreProducto =request.queryParams("nombreProducto");
        System.out.println(nombreProducto);

        Producto producto = new Producto();
        Producto_DAO imple =new Producto_DAO();
        imple.eliminarUsuarios(nombreProducto);

        response.redirect("/");
        return null;
    }
}