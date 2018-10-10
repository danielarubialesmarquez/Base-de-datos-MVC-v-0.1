/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
/**
 *
 * @author Dani
 */
public class model {
    
    private Connection conexion;
    private Statement st;
    private ResultSet rs;

    private String nombre;
    private String email;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Método que realiza las siguietnes acciones:
     * 1.- Conecta con la base agenda_mvc.
     * 2.- Consulta todo los registros de la tabla contactos.
     * 3.- Obtiene el nombre y el email y los guarda en las variables globales
     * nombre y email.
     */
    public void conectarDB() {
        try {
            conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/agenda_mvc", "user_mvc", "pass_mvc.2018");
            st = conexion.createStatement();
            rs = st.executeQuery("SELECT * FROM contactos;");
            rs.next();
            nombre = rs.getString("nombre");
            email = rs.getString("email");
        } catch (SQLException err) {
            JOptionPane.showMessageDialog(null, "Error en el model de conexion: " + err.getMessage());
        }

    }
    
    
    public void moverPrimerRegistro() throws SQLException{
        System.out.print("Amigo tu boton primer registro funciona");
        rs.first();
        this.setNombre(rs.getString("nombre"));
        this.setEmail(rs.getString("email"));
    }
    
   
    public void moverSiguienteRegistro() throws SQLException{
        System.out.print("Amigo tu boton siguiente registro funciona");
        rs.first();{
            rs.next();
    }this.setNombre(rs.getString("nombre"));
        this.setEmail(rs.getString("email"));
    }
    
  
    public void moverAnteriorRegistro() throws SQLException{
        System.out.print("Amigo tu boton anterior registro funciona");
        rs.first();{
            rs.previous();}
            this.setNombre(rs.getString("nombre"));
            this.setEmail(rs.getString("email"));
    }
    
    public void moverUltimoRegistro() throws SQLException{
        System.out.print("Programa accion moverUltimoRegistro");
        rs.last();
            this.setNombre(rs.getString("nombre"));
            this.setEmail(rs.getString("email"));
    }
  
}
