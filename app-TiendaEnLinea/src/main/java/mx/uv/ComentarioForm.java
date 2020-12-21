package mx.uv;

import spark.Request;
import spark.Response;
import spark.Route;

public class ComentarioForm implements Route {

    @Override
    public Object handle(Request request, Response response) throws Exception {
        String nombreCliente= request.queryParams("nombreCliente");
        String correoCliente= request.queryParams("correoCliente");
        String descripCliente= request.queryParams("descripCliente");
        System.out.println(nombreCliente);
        System.out.println(correoCliente);
        System.out.println(descripCliente);
        Comentario nuevo= new Comentario(nombreCliente, correoCliente, descripCliente);
        Comentario_DAO conexionCreate= new Comentario_DAO();
        if (conexionCreate.crearComentario(nuevo)){
            response.redirect("/");
        }else{
            System.out.println("NO SE PUDO AGREGARA COMENTARIO");
        }

        return null;
    }
    
}
