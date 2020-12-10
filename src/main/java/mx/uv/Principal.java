package mx.uv;

import spark.TemplateViewRoute;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.Spark.*;
import java.util.HashMap;
import java.util.Map;

public class Principal implements TemplateViewRoute {

    @Override
    public ModelAndView handle(Request request, Response response) throws Exception {
        Map<String, Object> modelo = new HashMap<>();
        Producto_DAO imple=new Producto_DAO();
        Producto produc= imple.read("Mascarilla");
        request.session().attribute("nombreProduc", produc.getNombre());
        request.session().attribute("url", produc.getImagenProducto());
        if(request.cookie("User")!=null){
            System.out.println("cookies"+request.cookie("User"));
            modelo.put("UsuarioActual",request.cookie("User"));

       }
       modelo.put("session", request.session());
            
        return new ModelAndView(modelo, "velocity/index.vm");
    }
    
}
