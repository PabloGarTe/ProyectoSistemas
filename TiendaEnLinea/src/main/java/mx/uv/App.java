package mx.uv;

import static spark.Spark.*;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        port(80);
        // root is 'src/main/resources', so put files in 'src/main/resources/public'
        staticFiles.location("/public"); // Static files
        get("/", (req, res) -> {
            Map<String, Object> modelo = new HashMap<>();
            Date fecha=new Date();
            modelo.put("fecha", fecha);
            // The vm files are located under the resources directory
            System.out.println("Hola ha entrado");
            return new ModelAndView(modelo, "velocity/index.vm");
        }, new VelocityTemplateEngine());

        
    }
}
