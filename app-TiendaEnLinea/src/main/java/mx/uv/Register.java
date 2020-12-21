package mx.uv;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.Route;

public class Register implements Route{

    @Override
    public Object handle(Request request, Response response) throws Exception {
        // TODO Auto-generated method stub
        response.redirect("/RegistroPage");
        return null;
    }
    
}
