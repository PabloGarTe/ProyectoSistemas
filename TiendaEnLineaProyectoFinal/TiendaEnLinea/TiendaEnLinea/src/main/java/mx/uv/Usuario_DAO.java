package mx.uv;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.jdbc.exceptions.CommunicationsException;


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
        public Usuario read(String correo) throws Exception {
            Connection con = null;
            Statement stm = null;
            ResultSet rs = null;
            String sql = "select * from Usuario where correo='" + correo+"';";
            System.out.println(sql);
            Usuario usuario= new Usuario();    
            try {
                con = new Conexion().conectarMySQL();//cambiar aquí la conexión
                stm = con.createStatement();
                rs = stm.executeQuery(sql);
                while (rs.next()) {
                    //CAMBIAR AQUI SI LOS MÉTODOS VAREAN
                    usuario.setCorreo(rs.getString(1));
                    usuario.setNombre(rs.getString(2));
                    usuario.setApellidos(rs.getString(3));
                    usuario.setDireccion(rs.getString(4));
                    usuario.setContrasena(rs.getString(5));
                    usuario.setCiudad(rs.getString(6));
                    usuario.setCodigoPostal(rs.getString(7));
                               
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
            return usuario;
        }

    

}