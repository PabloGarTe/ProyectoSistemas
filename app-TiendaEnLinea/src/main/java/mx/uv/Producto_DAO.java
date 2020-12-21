package mx.uv;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.jdbc.exceptions.CommunicationsException;

import java.sql.SQLException;

public class Producto_DAO {
    public boolean crearUsuario(Producto producto){
        Statement stm = null;
        Connection con = null;
        boolean resultado=false;
        Conexion cc=new Conexion();
        
        try{
            
            String sql="INSERT INTO producto values ('"+producto.getNombre()+"','"+producto.getDescripcionProducto()+"','"+producto.getPrecioProducto()+"','"+producto.getImagenProducto()+"')";
            System.out.println(sql);
            con = cc.conectarMySQL();
            stm = con.createStatement();
            stm.execute(sql);
            resultado = true;
            System.out.println("Creacion Realizada");
            stm.close();
            con.close();
            

        }catch(Exception e){
            e.printStackTrace();

        }
        return resultado;
    }
    public boolean validarUsuario(String correo, String clave){
        Statement stm = null;
        Connection con = null;
        boolean resultado=false;
        ResultSet rs = null;
        Conexion cc=new Conexion();
        
        try{
            String sql="select * from Usuario where correo='"+correo +"'and contrasena='"+clave+"';";
            System.out.println(sql);
            con = new Conexion().conectarMySQL();
            stm = con.createStatement();
            rs = stm.executeQuery(sql);
            
            while (rs.next()) {
                resultado=true;
            }
            

            System.out.println("Validación hecha");
            stm.close();
            con.close();

        }catch(Exception e){
            e.printStackTrace();

        }

        return resultado;
    }
    public Producto read(String nombre) throws Exception {
        Connection con = null;
        Statement stm = null;
        ResultSet rs = null;
        String sql = "select * from producto where nombreProducto='" + nombre+"';";
        System.out.println(sql);
        Producto producto = new Producto();

        try {
            con = new Conexion().conectarMySQL();//cambiar aquí la conexión
            stm = con.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                //CAMBIAR AQUI SI LOS MÉTODOS VAREAN
                producto.setNombre(rs.getString(1));
                producto.setPrecioProducto(rs.getFloat(2));
                producto.setDescripcionProducto(rs.getString(3));
                producto.setImagenProducto(rs.getString(4));
                
            }
            stm.close();
            rs.close();
            con.close();
        } catch (CommunicationsException e) {
            throw new Exception("Error en read ComunicationsException de usuario: " + e.getCause().toString());
        } catch (SQLException e){
            throw new Exception("Error en read SQLException de usuario: " + e.getCause().toString());
        }catch(Exception e){
            throw new Exception("Error en read Exception de usuario: " + e.getMessage());
        }
        return producto;
    }
    public List<Producto> readAll() throws Exception {
        Connection con = null;
        Statement stm = null;
        ResultSet rs = null;
        String sql = "select * from Producto ";
        System.out.println(sql);
        List<Producto> listaProyectos = new ArrayList<Producto>();

        try {
            con = new Conexion().conectarMySQL();
            stm = con.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                Producto c = new Producto(rs.getString(1),
                rs.getFloat(2),rs.getString(3),rs.getString(4));
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
    public boolean eliminarUsuarios(String nombrePorducto){
        Statement stm = null;
        Connection con = null;
        boolean resultado=false;
        Conexion cc=new Conexion();
        try{
            
            String sql="DELETE FROM producto WHERE nombrePorducto = '"+nombrePorducto + "'";
            System.out.println(sql);
            con = cc.conectarMySQL();
            stm = con.createStatement();
            stm.execute(sql);
            resultado = true;
            System.out.println("Creacion Realizada");
            stm.close();
            con.close();
            

        }catch(Exception e){
            e.printStackTrace();

        }
        return resultado;
    
    }
}
