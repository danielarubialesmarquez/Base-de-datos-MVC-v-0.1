/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.model;
import view.view;

/**
 *
 * @author Dani
 */
public class controllers {
    
    model model;
    view view;
    /**
     * Objeto de tipo ActionListener para atrapar los eventos actionPerformed y
     * llamar a los metodos para ver los registros almacenados en la bd.
     */
    ActionListener actionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == view.jbtn_primero) {
                try {
                    jbtn_primero_actionPerformed();
                } catch (SQLException ex) {
                    Logger.getLogger(controllers.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else if (e.getSource() == view.jbtn_anterior) {
                try {
                    jbtn_anterior_actionPerformed();
                } catch (SQLException ex) {
                    Logger.getLogger(controllers.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else if (e.getSource() == view.jbtn_siguiente) {
                try {
                    jbtn_siguiente_actionPerformed();
                } catch (SQLException ex) {
                    Logger.getLogger(controllers.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else if (e.getSource() == view.jbtn_ultimo) {
                try {
                    jbtn_ultimo_actionPerformed();
                } catch (SQLException ex) {
                    Logger.getLogger(controllers.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            }

        

    };

    /**
     * Constructor de Controlador para unir el ModelAgenda y ViewAgenda
     *
     * @param model objeto de tipo Model
     * @param view objeto de tipo View
     */
    public controllers(model model, view view) {
        this.model = model;
        this.view = view;
        initComponents();
        setActionListener();
        initDB();
    }

    /**
     * Método que llama al método conectarBD del modelo y muestra el nombre y
     * email del primer registro en las cajas de texto de ViewAgenda.
     */
    public void initDB(){
        model.conectarDB();
        view.jtf_nombre.setText(model.getNombre());
        view.jtf_email.setText(model.getEmail());
    }
    /**
     * Metodo para inicializar la ViewAgenda
     */
    public void initComponents() {
        view.setLocationRelativeTo(null);
        view.setTitle("Agenda que conecta a la base de datos MVC");
        view.setVisible(true);
    }

    /**
     * Método para agregar el actionListener a cada boton de la vista
     */
    public void setActionListener() {
        view.jbtn_primero.addActionListener(actionListener);
        view.jbtn_anterior.addActionListener(actionListener);
        view.jbtn_siguiente.addActionListener(actionListener);
        view.jbtn_ultimo.addActionListener(actionListener);
    }

    /**
     * Método para ver el primer registro de la tabla contactos
     */
    private void jbtn_primero_actionPerformed() throws SQLException {
        System.out.println("Action del boton jbtn_primero");
        model.moverPrimerRegistro();//invocar al metodo moverPrimerRegistro
        view.jtf_nombre.setText(model.getNombre());//mostrar nombre en la vista
        view.jtf_email.setText(model.getEmail());//mostar email en la vista
    }

    /**
     * Método para ver el registro anterior de la tabla contactos
     */
    private void jbtn_anterior_actionPerformed() throws SQLException {
        System.out.println("Action del boton jbtn_anterior");
         model.moverAnteriorRegistro();//invocar al metodo moverPrimerRegistro
        view.jtf_nombre.setText(model.getNombre());//mostrar nombre en la vista
        view.jtf_email.setText(model.getEmail());//mostar email en la vista
    }

    /**
     * Método para ver el último registro de la tabla contactos
     */
    private void jbtn_ultimo_actionPerformed() throws SQLException {
         model.moverUltimoRegistro();//invocar al metodo moverPrimerRegistro
        view.jtf_nombre.setText(model.getNombre());//mostrar nombre en la vista
        view.jtf_email.setText(model.getEmail());//mostar email en la vista
    }

    /**
     * Método para ver el siguiente registro de la tabla contactos
     */
    private void jbtn_siguiente_actionPerformed() throws SQLException {
        System.out.println("Action del boton jbtn_siguiente");
         model.moverSiguienteRegistro();//invocar al metodo moverPrimerRegistro
        view.jtf_nombre.setText(model.getNombre());//mostrar nombre en la vista
        view.jtf_email.setText(model.getEmail());//mostar email en la vista
    }
    
   
}
