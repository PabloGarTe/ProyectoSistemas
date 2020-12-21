package mx.uv;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;



import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.TemplateViewRoute;

public class VerVentasPage implements TemplateViewRoute {

    @Override
    public ModelAndView handle(Request request, Response response) throws Exception {
        Map<String, Object> modelo = new HashMap<>();
        Venta_DAO ventaImp= new Venta_DAO();
        List listaConsulta=Arrays.asList(ventaImp.readAll());
        Iterator iter = listaConsulta.iterator();
        while (iter.hasNext()){
            System.out.println(iter.next().toString());
        }
        List listaVentas=ventaImp.readAll();
        modelo.put("ventas", listaVentas);
        
        return new ModelAndView(modelo, "velocity/VerReporteVentas.vm");
    }
    
}
