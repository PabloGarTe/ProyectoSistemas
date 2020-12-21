package mx.uv;
import spark.TemplateViewRoute;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.Spark.*;
import java.util.HashMap;
import java.util.Map;

public class RegistroProdPage implements TemplateViewRoute{
    @Override
    public ModelAndView handle(Request request, Response response) throws Exception {
        Map<String, Object> modelo = new HashMap<>();
       
            
        return new ModelAndView(modelo, "velocity/AgregarProducto.vm");
    }
}