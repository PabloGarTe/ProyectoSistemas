package mx.uv;
import spark.TemplateViewRoute;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.Spark.*;
import java.util.HashMap;
import java.util.Map;
public class ProductoDetPage implements TemplateViewRoute{

    @Override
    public ModelAndView handle(Request request, Response response) throws Exception {
        
        // TODO Auto-generated method stub
        Map<String, Object> modelo = new HashMap<>();

        return new ModelAndView(modelo, "velocity/DetallesProduc.vm");
    }
    
}
