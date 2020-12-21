package mx.uv;

import spark.TemplateViewRoute;
import spark.Service.StaticFiles;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.Spark.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class ProductoDetPage implements TemplateViewRoute{

    //staticFiles.location("/public");

    @Override
    public ModelAndView handle(Request request, Response response) throws Exception {
        Map<String, Object> modelo = new HashMap<>();
        String listaConsulta= request.params("producSelec");
        
        System.out.println((listaConsulta));
        // TODO Auto-generated method stub
        

        return new ModelAndView(modelo, "velocity/DetallesProduc.vm");
    }
    
}
