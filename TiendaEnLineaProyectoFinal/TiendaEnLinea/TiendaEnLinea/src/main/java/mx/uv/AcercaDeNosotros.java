package mx.uv;

import spark.Request;
import spark.Response;
import spark.Route;

public class AcercaDeNosotros implements Route {

    @Override
    public Object handle(Request request, Response response) throws Exception {
        // TODO Auto-generated method stub
        response.redirect("/AcercaDeNosotrosPage");
        return null;
    }
    
}
