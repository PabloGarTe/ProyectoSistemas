package mx.uv;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.Route;
import java.util.HashMap;
import java.util.Map;
public class ObtenerProducForm implements Route{
    // TODO Auto-generated method stub
    @Override
    public Object handle(Request request, Response response) throws Exception {
        Map<String, Object> modelo = new HashMap<>();
        // TODO Auto-generated method stub
        response.redirect("/VerComentariosPage");
        return null;
    }
}
