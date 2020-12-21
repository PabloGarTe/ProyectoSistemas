package mx.uv;

import static spark.Spark.*;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import spark.Spark;
import spark.ModelAndView;
import spark.template.mustache.MustacheTemplateEngine;
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
        //root is 'src/main/resources', so put files in 'src/main/resources/public'
        staticFiles.location("/public"); // Static files
        
        //INICIO DE LA PÁGINA,   
        Spark.get("/",new Principal(),new VelocityTemplateEngine());

        //RUTAS DEL ÁREA DE REGISTRO
        Spark.post("/Register", new Register()); 
        Spark.get("/RegistroPage",new RegistroPage(),new VelocityTemplateEngine());
        Spark.post("/FormRegister", new FormRegister());
        
        //RUTAS DEL ÁREA DE INICIO DE SESIÓN
        Spark.get("/LoginForm", new LoginForm(),new VelocityTemplateEngine()); 
        Spark.post("/LoginPage", new LoginPage());
        //Spark.get("/ProductoDetPage/:producSelec", new ProductoDetPage(),new VelocityTemplateEngine());

        //RUTAS DEL ÁREA DE COMENTARIOS
        Spark.post("/Comentarios",new Comentarios());
        Spark.get("/ComentariosPage", new ComentariosPage(), new VelocityTemplateEngine());
        Spark.post("/ComentarioForm", new ComentarioForm());

        //RUTAS DEL ÁREA ACERCA DE NOSOTROS
        Spark.post("/AcercaDeNosotros",new AcercaDeNosotros());
        Spark.get("/AcercaDeNosotrosPage", new AcercaDeNosotrosPage(), new VelocityTemplateEngine());

        //RUTAS DEL REGISTRO DE PRODUCTO
        Spark.post("/RegisterProd", new RegisterProd());
        Spark.get("/RegistroProdPage",new RegistroProdPage(),new VelocityTemplateEngine());
        Spark.post("/FormRegisterProd", new FormRegisterProd());

        //RUTAS DE BORRAR PRODUCTO
        Spark.get("/BorrarProducto",new BorrarProducto(),new VelocityTemplateEngine());
        Spark.post("/Borrar", new Borrar());
        Spark.post("/FormBorrarProducto", new FormBorrarProducto());

        //RUTA DE VER COMENTARIOS DEL CLIENTE 
        Spark.get("/VerComentariosPage", new VerComentariosPage(), new VelocityTemplateEngine());

        //RUTA DE VER REPORTE DEVENTAS REALIZADAS, 
        Spark.get("/VerVentasPage", new VerVentasPage(), new VelocityTemplateEngine());
        
        //RUTA PARA ACCEDER A LA VISUALIZACIÓN DE PRODUCTO EN ESPECÍFICO 
        get("/ProductoDetPage/:producSelec",(request, response) -> {
            //staticFiles.location("/public");
            Map<String, Object> modelo = new HashMap<>();

            String produc= request.params("producSelec");
           
            //response.cookie("nombreProduc", produc);
            Producto_DAO imple = new Producto_DAO();
            Producto proDeta=imple.read(produc);
            System.out.println((produc));
            modelo.put("productoDet", proDeta);
            return new ModelAndView(modelo, "velocity/DetallesProduc.vm");
        },new VelocityTemplateEngine());

        //RUTA PARA OBTENER DATOS Y REALIZAR COMPRA DEL PRODUCTO
        Spark.post("/ObtenerProducForm",new  ObtenerProducForm());
        post("/compraForm", (request, response) -> {
            Venta_DAO imp=new Venta_DAO();
            Venta vent=new Venta(request.cookie("User"),request.queryParams("numTarjeta"),request.queryParams("codigoSeguridad"));
            imp.crearVenta(vent);
            System.out.println("Request: " + request.queryParams());
            System.out.println("Request: " + request.queryParams("numTarjeta"));
            System.out.println("Request: " + request.queryParams("codigoSeguridad"));
            System.out.println("Request: " + request.body()); // pendiente ver como llenar el body
            System.out.println("Request: " + request.contentType());
           
            return "Comprar Realiza por" + request.cookie("User") + request.cookie("nombreProduc");
        });

        //RUTA PARA OBTENER Y ENVÍAR LOS DATOS DEL USUARIO A LA PÁGINA CORRESPONDIENTE 
        get("/DatosUsuario", (request, response) -> {
            Map<String, String> model = new HashMap<>();
            Usuario_DAO imp=new Usuario_DAO();
            Usuario usu=imp.read(request.cookie("User"));
            model.put("nombre",usu.getNombre());
            model.put("apellidos", usu.getApellidos());
            model.put("direccion", usu.getDireccion());
            model.put("ciudad",usu.getCiudad());
            model.put("codigoPostal",usu.getCodigoPostal());
            return new ModelAndView(model, "verMiInformacion.mustache");// hello.mustache file is in resources/templates directory
        }, new MustacheTemplateEngine()); 
        
        
    }
    static int getHerokuAssignedPort() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        if (processBuilder.environment().get("PORT") != null) {
            return Integer.parseInt(processBuilder.environment().get("PORT"));
        }
        return 4567; //return default port if heroku-port isn't set (i.e. on localhost)
    }
}
