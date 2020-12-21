package mx.uv;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.Route;

public class Borrar implements Route{

    @Override
    public Object handle(Request request, Response response) throws Exception {
        // TODO Auto-generated method stub
        response.redirect("/BorrarProducto");
        return null;
    }
    
}