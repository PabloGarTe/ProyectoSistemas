package mx.uv;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class Usuario_DAO {
    

        public boolean crearUsuario(Usuario usuario){
            Statement stm = null;
            Connection con = null;
            boolean resultado=false;
            Conexion cc=new Conexion();
            
            try{
                
                String sql="INSERT INTO Usuario values ('"+usuario.getCorreo()+"','"+usuario.getNombre()+"','"+usuario.getApellidos()+"','"+usuario.getDireccion()+"','"+usuario.getContrasena()+"','"+usuario.getCiudad()+"','"+usuario.getCodigoPostal()+"')";
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

    

}