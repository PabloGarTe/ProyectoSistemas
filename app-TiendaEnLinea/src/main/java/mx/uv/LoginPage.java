package mx.uv;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.Route;

public class LoginPage implements Route{
    @Override
    public Object handle(Request request, Response response) throws Exception {
        String correo =request.queryParams("correo");
        String clave =request.queryParams("clave");
        response.removeCookie("User");  
        
        
        Usuario_DAO controlValidar =new Usuario_DAO();
        try{
            boolean correcto=controlValidar.validarUsuario(correo,clave);
            if(correcto){
                response.cookie("User", correo);
                
                response.redirect("/");
            }
            else{
                response.redirect("/LoginForm");
            }
        }catch(Exception e){
               e.printStackTrace(); 
        }
        
        return null;
    }
}
