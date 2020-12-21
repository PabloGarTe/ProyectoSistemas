package mx.uv;

import spark.TemplateViewRoute;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.Spark.*;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.jetty.io.Connection.Listener;

import java.util.Iterator;
import java.util.List;
import java.util.Arrays;

public class Principal implements TemplateViewRoute {

    @Override
    public ModelAndView handle(Request request, Response response) throws Exception {
        Map<String, Object> modelo = new HashMap<>();
        Producto_DAO imple = new Producto_DAO();
        List listaConsulta = imple.readAll();
        response.cookie("productoSelec","Nada");
        
        request.session().attribute("url","");
        if(request.cookie("User")!=null){
            System.out.println("cookies + "+request.cookie("User"));
             modelo.put("UsuarioActual",request.cookie("User"));
            //modelo.put("sesion",request.session());
            //modelo.put("UsuarioActual",request.cookie("User"));

       }
       modelo.put("producto", listaConsulta);
            
        return new ModelAndView(modelo, "velocity/index.vm");
    }
    
}
