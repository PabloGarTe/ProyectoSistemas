package mx.uv;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Comentario_DAO {
    public boolean crearComentario(Comentario comentario){
        Statement stm = null;
        Connection con = null;
        boolean resultado=false;
        Conexion cc=new Conexion();
        
        try{
            
            String sql="INSERT INTO comentario values (NULL,'"+comentario.getCorreoCliente()+"','"+comentario.getNombreCliente()+"','"+comentario.getDescripcion()+"');";
            System.out.println(sql);
            con = cc.conectarMySQL();
            stm = con.createStatement();
            stm.execute(sql);
            resultado = true;
            System.out.println("Comentario guardado en la base de datos");
            stm.close();
            con.close();
            

        }catch(Exception e){
            e.printStackTrace();

        }
        return resultado;
    }
    public List<Comentario> readAll() throws Exception {
        Connection con = null;
        Statement stm = null;
        ResultSet rs = null;
        String sql = "select * from comentario ";
        System.out.println(sql);
        List<Comentario> listaProyectos = new ArrayList<Comentario>();

        try {
            con = new Conexion().conectarMySQL();
            stm = con.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                Comentario c = new Comentario(rs.getInt(1),
                        rs.getString(2),rs.getString(3), rs.getString(4));
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
