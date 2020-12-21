package mx.uv;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
public class Venta_DAO {
    public boolean crearVenta(Venta comentario){
        Statement stm = null;
        Connection con = null;
        boolean resultado=false;
        Conexion cc=new Conexion();
        
        try{
            
            String sql="INSERT INTO Venta values ('"+comentario.getNombreCliente()+"','"+comentario.getTarjeta()+"','"+comentario.getClave()+"');";
            System.out.println(sql);
            con = cc.conectarMySQL();
            stm = con.createStatement();
            stm.execute(sql);
            resultado = true;
            System.out.println("Venta guardado en la base de datos");
            stm.close();
            con.close();
            

        }catch(Exception e){
            e.printStackTrace();

        }
        return resultado;
    }
    public List<Venta> readAll() throws Exception {
        Connection con = null;
        Statement stm = null;
        ResultSet rs = null;
        String sql = "select * from Comentario ";
        System.out.println(sql);
        List<Venta> listaProyectos = new ArrayList<Venta>();

        try {
            con = new Conexion().conectarMySQL();
            stm = con.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                Venta c = new Venta(rs.getString(1),
                        rs.getString(2),rs.getString(3));
                listaProyectos.add(c);
            }
            stm.close();
            rs.close();
            con.close();
        
        }catch(Exception e){
            throw new Exception("Error en readAll: " + e.getCause().toString());
        }

        return listaProyectos;
    }
}
