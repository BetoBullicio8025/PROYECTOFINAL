package org.example.modelo;
import org.example.persistenciaIA.iaDAO;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import java.sql.SQLException;
import java.sql.SQLOutput;
import java.util.ArrayList;
import org.example.persistenciaIA.iaDAO;


public class modeloTablaIA implements TableModel {
    private ArrayList<modeloIA> datos;
    private static final int COLUMNAS = 6;
    private iaDAO iadao2;
    public modeloTablaIA() {
        iadao2 = new iaDAO();
        datos = new ArrayList<>();
    }

    public modeloTablaIA(ArrayList<modeloIA> datos) {
        this.datos = datos;
        iadao2 = new iaDAO();

    }


    @Override
    public int getRowCount() {
        return datos.size();
    }

    @Override
    public int getColumnCount() {
        return COLUMNAS;
    }

    @Override
    public String getColumnName(int rowIndex) {
        switch (rowIndex){
            case 0:
                return "Id";
            case 1:
                return "Nombre";
            case 2:
                return "Desarrollador";
            case 3:
                return "Tipo";
            case 4:
                return "Fecha";
            case 5:
                return "URL";

        }
        return null;
    }

    @Override
    public Class<?> getColumnClass(int rowIndex) {
        switch (rowIndex){
            case 0:
                return Integer.class;
            case 1:
                return String.class;
            case 2:
                return String.class;
            case 3:
                return String.class;
            case 4:
                return String.class;
            case 5:
                return String.class;

        }
        return null;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return true;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        modeloIA tmp = datos.get(rowIndex);
        switch (columnIndex){
            case 0:
                return tmp.getId();
            case 1:
                return tmp.getNombre();
            case 2:
                return tmp.getDesarrollador();
            case 3:
                return tmp.getTipoDeIA();
            case 4:
                return tmp.getFechaDeCreacion();
            case 5:
                return tmp.getURL();

        }
        return null;
    }

    @Override
    public void setValueAt(Object o, int rowIndex, int columnIndex) {
        switch (columnIndex){
            case 0:
                //datos.get(rowIndex).setId(0);
                break;
            case 1:
                datos.get(rowIndex).setNombre((String) o);
                break;
            case 2:
                datos.get(rowIndex).setDesarrollador((String) o);
                break;
            case 3:
                datos.get(rowIndex).setTipoDeIA((String) o);
                break;
            case 4:
                datos.get(rowIndex).setFechaDeCreacion((String) o);
                break;
            case 5:
                datos.get(rowIndex).setURL((String) o);
                break;
            default:
                System.out.println("no se modifica nada");

        }
    }

    @Override
    public void addTableModelListener(TableModelListener l) {

    }

    @Override
    public void removeTableModelListener(TableModelListener l) {

    }

    public void cargarDatos(){
        try {

            datos = iadao2.obtenerTodo();
        }catch (SQLException sqle){
            System.out.println(sqle.getMessage());
        }
    }

    public boolean agregarIA(modeloIA IA) {
        boolean resultado = false;

        try {
            if (iadao2.insertar(IA)) {
                datos.add(IA);
                resultado = true;
            }else {
                resultado = false;
            }
            }catch(SQLException sqle){
                System.out.println(sqle.getMessage());
            }
        return resultado;
        }

        public boolean modificarTabla(modeloIA IA){
            boolean resultado = false;
            try {
                if (iadao2.update(IA)){
                    datos.add(IA);
                    resultado=true;
                }else {
                    resultado=false;
                }
            }catch (SQLException sqle){
                System.out.println(sqle.getMessage());
            }
            return resultado;
        }

    public modeloIA obtenerCampo(int rowIndex){
        return datos.get(rowIndex);
    }



}