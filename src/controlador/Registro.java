
package controlador;

import sql.Conexion;
import java.sql.*;
import java.util.ArrayList;
import modelo.Encomienda;

public class Registro {
    public static boolean Agregar(Encomienda enc){
        try{
            Connection conexion = Conexion.getConexion();
            String query ="INSERT INTO encomienda(en_id,en_destinatario,en_direccion,en_tipo,en_entregadomicilio,en_tamano,en_remitente) VALUE (?,?,?,?,?,?,?)";
            PreparedStatement insertar = conexion.prepareStatement(query);
            insertar.setInt(1,enc.getId());
            insertar.setString(2,enc.getDestinatario());
            insertar.setString(3,enc.getDireccion());
            insertar.setString(4,enc.getTipo());
            insertar.setBoolean(5,enc.isEntregaDomicilio());
            insertar.setString(6,enc.getTamano());
            insertar.setString(7,enc.getRemitente());
            insertar.execute();
            insertar.close();
            conexion.close();
            return true;
        }catch(SQLException s){
            System.out.println("Error SQL al agregar encomienda "+s.getMessage());
            return false;
        }catch(Exception e){
            System.out.println("Error al agregar encomienda"+e.getMessage());
            return false;
        }
    }
    
    public static boolean Editar(Encomienda enc){
            try {
                 Connection conexion = Conexion.getConexion();
            String query = "UPDATE encomienda SET "
                    + " en_destinatario=?, "
                    + " en_direccion=?, "
                    + " en_tipo=?, "
                    + " en_entregadomicilio=?,"
                    + " en_tamano=?,"
                    + " en_remitente=? "
                    + " WHERE en_id=?";
            PreparedStatement insertar = conexion.prepareStatement(query);
            insertar.setString(1, enc.getDestinatario());
            insertar.setString(2, enc.getDireccion());
            insertar.setString(3, enc.getTipo());
            insertar.setBoolean(4, enc.isEntregaDomicilio());
            insertar.setString(5, enc.getTamano());
            insertar.setString(6, enc.getRemitente());
            insertar.setInt(7, enc.getId());
            insertar.execute();
            insertar.close();
            conexion.close();
            return true;
        }catch(SQLException s){
            System.out.println("Error SQL al editar encomienda"+s.getMessage());
            return false;
        } catch (Exception e) {
            System.out.println("Error al editar encomienda"+e.getMessage());
            return false;
        }
    }
    
    public static boolean Eliminar(int encomiendaId){
        try {
            Connection conexion = Conexion.getConexion();
            String query = "DELETE FROM encomienda WHERE en_id=?";
            PreparedStatement eliminar = conexion.prepareStatement(query);
            eliminar.setInt(1, encomiendaId);
            eliminar.execute();
            eliminar.close();
            conexion.close();
            return true;
        } catch(SQLException s){
            System.out.println("Error SQL al eliminar encomienda"+s.getMessage());
            return false;
        } catch(Exception e) {
            System.out.println("Error al eliminar encomienda "+e.getMessage());
            return false;
        }
    }
    
    public static ArrayList<Encomienda> mostrarEncomiendas(){
        ArrayList<Encomienda> listaEncomiendas = new ArrayList<Encomienda>();
        try {
            Connection conexion = Conexion.getConexion();
            String query = "SELECT * FROM encomienda";
            PreparedStatement listarTodos = conexion.prepareStatement(query);
            ResultSet rs = listarTodos.executeQuery();
            while(rs.next()){
                Encomienda enc = new Encomienda();
                enc.setId(rs.getInt("en_id"));
                enc.setDestinatario(rs.getString("en_destinatario"));
                enc.setDireccion(rs.getString("en_direccion"));
                enc.setTipo(rs.getString("en_tipo"));
                enc.setEntregaDomicilio(rs.getBoolean("en_entregadomicilio"));
                enc.setTamano(rs.getString("en_tamano"));
                enc.setRemitente(rs.getString("en_remitente"));
                listaEncomiendas.add(enc);
            }
        } catch(SQLException s){
            System.out.println("Error SQL al listar encomiendas "+s.getMessage());
        } catch (Exception e) {
            System.out.println("Error al listar encomiendas "+e.getMessage());
        }
        return listaEncomiendas;
    }
    
    public static Encomienda buscarPorEncomienda(int encomiendaId){
        ArrayList<Encomienda> listaEncomiendas = new ArrayList<Encomienda>();
        Encomienda encomiendaBuscada = null;
        try {
            Connection conexion = Conexion.getConexion();
            String query = "SELECT en_id,en_destinatario,en_direccion,en_tipo,en_entregadomicilio,en_tamano,en_remitente FROM encomienda WHERE en_id=?";
            PreparedStatement buscarPorEncomienda = conexion.prepareStatement(query);
            buscarPorEncomienda.setInt(1,encomiendaId);
            ResultSet rs = buscarPorEncomienda.executeQuery();
            while(rs.next()){
                Encomienda encomEncontrada = new Encomienda();
                encomEncontrada.setId(rs.getInt("en_id"));
                encomEncontrada.setDestinatario(rs.getString("en_destinatario"));
                encomEncontrada.setDireccion(rs.getString("en_direccion"));
                encomEncontrada.setTipo(rs.getString("en_tipo"));
                encomEncontrada.setEntregaDomicilio(rs.getBoolean("en_entregadomicilio"));
                encomEncontrada.setTamano(rs.getString("en_tamano"));
                encomEncontrada.setRemitente(rs.getString("en_remitente"));
                encomiendaBuscada = encomEncontrada;
                return encomiendaBuscada;
            }
        } catch (SQLException s){
            System.out.println("Error SQL al listar encomienda"+s.getMessage());
        }catch (Exception e) {
            System.out.println("Error al listar encomienda "+e.getMessage());
        }
        return null;
    }
    
     public static  ArrayList<Encomienda> buscarListaEncomienda(int encomiendaId){
        ArrayList<Encomienda> listaEncomiendas = new ArrayList<Encomienda>();
        try {
            Connection conexion = Conexion.getConexion();
            String query = "SELECT en_id,en_destinatario,en_direccion,en_tipo,en_entregadomicilio,en_tamano,en_remitente FROM encomienda WHERE en_id=?";
            PreparedStatement buscarPorEncomienda = conexion.prepareStatement(query);
            buscarPorEncomienda.setInt(1,encomiendaId);
            ResultSet rs = buscarPorEncomienda.executeQuery();
            while(rs.next()){
                Encomienda encomEncontrada = new Encomienda();
                encomEncontrada.setId(rs.getInt("en_id"));
                encomEncontrada.setDestinatario(rs.getString("en_destinatario"));
                encomEncontrada.setDireccion(rs.getString("en_direccion"));
                encomEncontrada.setTipo(rs.getString("en_tipo"));
                encomEncontrada.setEntregaDomicilio(rs.getBoolean("en_entregadomicilio"));
                encomEncontrada.setTamano(rs.getString("en_tamano"));
                encomEncontrada.setRemitente(rs.getString("en_remitente"));
                listaEncomiendas.add(encomEncontrada);
            }
            return listaEncomiendas;
        } catch (SQLException s){
            System.out.println("Error SQL al listar encomienda"+s.getMessage());
        }catch (Exception e) {
            System.out.println("Error al listar encomienda "+e.getMessage());
        }
        return null;
    }
}
