package mx.uv;

import spark.Request;
import spark.Response;
import spark.Route;

public class Comentarios implements Route {

    @Override
    public Object handle(Request request, Response response) throws Exception {
        // TODO Auto-generated method stub
        response.redirect("/ComentariosPage");
        return null;
    }
    
}
