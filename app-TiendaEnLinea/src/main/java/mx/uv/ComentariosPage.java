package mx.uv;

import java.util.HashMap;
import java.util.Map;

import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.TemplateViewRoute;

public class ComentariosPage implements TemplateViewRoute {

    @Override
    public ModelAndView handle(Request request, Response response) throws Exception {
        Map<String, Object> modelo = new HashMap<>();      
        return new ModelAndView(modelo, "velocity/comentarios.vm");
    }
    
}
