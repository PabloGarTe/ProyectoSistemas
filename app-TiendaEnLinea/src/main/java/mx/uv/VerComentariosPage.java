package mx.uv;

import spark.TemplateViewRoute;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import java.util.HashMap;
import java.util.List;
import java.util.Iterator;
import java.util.Arrays;
import java.util.Map;
import com.google.gson.Gson;
public class VerComentariosPage implements TemplateViewRoute{

    @Override
    public ModelAndView handle(Request request, Response response) throws Exception {
        Map<String, Object> modelo = new HashMap<>();
      
       Comentario_DAO implem =new Comentario_DAO();
       //List listaConsulta=Arrays.asList(implem.readAll());
       /*Iterator iter = listaConsulta.iterator();
       while (iter.hasNext()){
        System.out.println(iter.next().toString());
       }*/
      
       List listaConsulta=implem.readAll();  
          
      // String json = new Gson().toJson(listaConsulta);
      // System.out.println(json);
       modelo.put("comentarios",listaConsulta);
        return new ModelAndView(modelo, "velocity/VerComentarios.vm");
        
    }
    
}
