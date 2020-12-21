package mx.uv;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.Route;
public class FormRegister implements Route{
   
    @Override
    public Object handle(Request request, Response response) throws Exception {
        String nombre =request.queryParams("nombre");
        String apellido=request.queryParams("apellido");
        String email=request.queryParams("correo");
        String clave=request.queryParams("clave");
        String direccion=request.queryParams("direccion");
        String ciudad=request.queryParams("ciudad");
        String cp=request.queryParams("codigo");
        /*System.out.println(nombre);
        System.out.println(apellido);
        System.out.println(clave);
        System.out.println(direccion);
        System.out.println(ciudad);
        System.out.println(email);
        System.out.println(cp);*/
        Usuario usuario=new Usuario(nombre,apellido,direccion,email,clave,ciudad,cp);
        Usuario_DAO imple =new Usuario_DAO();
        imple.crearUsuario(usuario);

        
        response.redirect("/LoginForm");
        return null;
    }
}
