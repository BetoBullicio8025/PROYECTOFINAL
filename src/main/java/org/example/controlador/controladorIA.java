package org.example.controlador;

import java.awt.event.MouseAdapter;

import org.example.persistenciaIA.ConexionSingleton;
import org.example.vista.ventanaIA;
import org.example.modelo.modeloTablaIA;
import org.example.modelo.modeloIA;
import org.example.persistenciaIA.iaDAO;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class controladorIA extends MouseAdapter {
    private ventanaIA view;
    private modeloTablaIA modelo;

    public controladorIA(ventanaIA view) {
        this.view = view;
        modelo = new modeloTablaIA();
        this.view.getTblTablaIA().setModel(modelo);
        this.view.getBtnActualizar().addMouseListener(this);
        this.view.getBtnAgregar().addMouseListener(this);
        this.view.getBtnEliminar4().addMouseListener(this);
        this.view.getBtnActualizar4().addMouseListener(this);
        this.view.getTblTablaIA().addMouseListener(this);



    }

//Actualizar base de datos
    @Override
    public void mouseClicked(MouseEvent e) {

        if (e.getSource()==this.view.getBtnActualizar()){
            modelo.cargarDatos();
            this.view.getTblTablaIA().setModel(modelo);
            this.view.getTblTablaIA().updateUI();
        }
//Agregar informacion a base de datos
        if (e.getSource()==this.view.getBtnAgregar()) {
            modeloIA campos = new modeloIA();
            campos.setId(0);
            campos.setNombre(this.view.getTxtNombre().getText());
            campos.setDesarrollador(this.view.getTxtDesarrollador().getText());
            campos.setTipoDeIA(this.view.getTxtTipo().getText());
            campos.setFechaDeCreacion(this.view.getTxtFecha().getText());
            campos.setURL(this.view.getTxtURL().getText());
            if (modelo.agregarIA(campos)) {
                JOptionPane.showMessageDialog(view, "Se agrego correctamente", "Aviso", JOptionPane.INFORMATION_MESSAGE);
                this.view.getTblTablaIA().updateUI();
            } else {
                JOptionPane.showMessageDialog(view, "No se pudo agregar a la base de datos," +
                                " intentalo de nuevo más tarde",
                        "Error al insertar", JOptionPane.ERROR_MESSAGE);
            }
            this.view.limpiar();

        }
        //Eliminar informacion de la tabla
        if(e.getSource() == this.view.getBtnEliminar4()){
            int respuesta = JOptionPane.showConfirmDialog(view, "¿Eliminar campo?", "Eliminar", JOptionPane.YES_NO_OPTION);
            if (respuesta == 0){
                String sqlDelete = "DELETE FROM tablaIA WHERE id= ? ;";
                PreparedStatement pstm =null;
                try {
                    pstm = ConexionSingleton.getInstance("BaseDatosIA").getConnection().prepareStatement(sqlDelete);
                }catch (SQLException sqle){
                    System.out.println("No se pudo eliminar el campo" +  sqle.getMessage());

                }
                try {
                    pstm.setInt(1, Integer.parseInt(this.view.getTxtElimID().getText()));
                    this.view.getTblTablaIA().updateUI();
                    JOptionPane.showMessageDialog(view, "Eliminacion exitosa", "Aviso", JOptionPane.INFORMATION_MESSAGE);
                }catch (NumberFormatException nfe){
                    System.out.println(nfe.getMessage());
                }catch (SQLException sqle){
                    System.out.println(sqle.getMessage());
                }
                try {
                    pstm.executeUpdate();

                }catch (SQLException sqle){
                    System.out.println(sqle.getMessage());
                    throw new RuntimeException();
                }finally {
                    this.view.limpiarPanel4();
                }

            }
            //Modificar campos de la tabla
        }
        if (e.getSource() == this.view.getBtnActualizar4()){
            int respuesta = JOptionPane.showConfirmDialog(view,"¿Modificar linea?","Modificar tabla",JOptionPane.YES_NO_OPTION);
            if (respuesta == 0){
                modeloIA campos = new modeloIA();
                campos.setId(Integer.parseInt((String)this.view.getTxtID4().getText()));
                campos.setNombre(this.view.getTxtNombre4().getText());
                campos.setDesarrollador(this.view.getTxtDesarrollador4().getText());
                campos.setTipoDeIA(this.view.getTxtTipo4().getText());
                campos.setFechaDeCreacion(this.view.getTxtFecha4().getText());
                campos.setURL(this.view.getTxtURL4().getText());
                this.view.getTblTablaIA().updateUI();
                if (modelo.modificarTabla(campos)){
                    JOptionPane.showMessageDialog(view,"Se modifico correctamente","Modificar",JOptionPane.INFORMATION_MESSAGE);
                    this.view.getTblTablaIA().updateUI();
                }else {
                    JOptionPane.showMessageDialog(view,"Error al modificar","Modificar",JOptionPane.ERROR_MESSAGE);
                }
                this.view.limpiarPanel4();
            }else {
                this.view.limpiarPanel4();
            }

            //Ingresar imagen por url
        }
        if (e.getSource()== this.view.getTblTablaIA()){
            int rowIndex = this.view.getTblTablaIA().getSelectedRow();
            modelo.obtenerCampo(rowIndex);
            modeloIA temp = modelo.obtenerCampo(rowIndex);
            this.view.getLblIcono().setText("");
            this.view.getLblIcono().setIcon(temp.crearIcono());

        }
    }

}
