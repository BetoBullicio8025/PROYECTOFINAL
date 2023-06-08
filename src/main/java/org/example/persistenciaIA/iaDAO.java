package org.example.persistenciaIA;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.example.modelo.modeloIA;


public class iaDAO implements interfazIA{

    @Override
    public boolean insertar(Object obj) throws SQLException {
        String sqlInsert = "INSERT INTO tablaIA(url, nombre, desarrollador, tipo, fecha) VALUES(?, ?, ?, ?, ?)";
        int rowCount = 0;
        PreparedStatement pstm = ConexionSingleton.getInstance("BaseDatosIA.db").getConnection().prepareStatement(sqlInsert);
        pstm.setString(1, ((modeloIA)obj).getURL());
        pstm.setString(2, ((modeloIA) obj).getNombre());
        pstm.setString(3, ((modeloIA) obj).getDesarrollador());
        pstm.setString(4, ((modeloIA) obj).getTipoDeIA());
        pstm.setString(5, ((modeloIA) obj).getFechaDeCreacion());
        rowCount = pstm.executeUpdate();

        return rowCount>0;
    }

    @Override
    public boolean update(Object obj) throws SQLException {
        String sqlUpdate = "UPDATE tablaIA SET url = ?, nombre = ?, desarrollador = ?, tipo = ?, fecha = ? WHERE id = ? ; ";
        int rowCount = 0;
        PreparedStatement pstm = ConexionSingleton.getInstance("BaseDatosIA.db").getConnection().prepareStatement(sqlUpdate);
        pstm.setString(1, ((modeloIA)obj).getURL());
        pstm.setString(2, ((modeloIA) obj).getNombre());
        pstm.setString(3, ((modeloIA) obj).getDesarrollador());
        pstm.setString(4, ((modeloIA) obj).getTipoDeIA());
        pstm.setString(5, ((modeloIA) obj).getFechaDeCreacion());
        pstm.setInt(6, ((modeloIA) obj).getId());
        rowCount = pstm.executeUpdate();

        return rowCount>0;
    }

    @Override
    public boolean delete(String id) throws SQLException {
        String sqlDelete = "DELETE FROM tablaIA WHERE id= ? ; ";
        int rowCount = 0;
        PreparedStatement pstm = ConexionSingleton.getInstance("BaseDatosIA.db").getConnection().prepareStatement(sqlDelete);
        pstm.setInt(1, Integer.parseInt(id));
        rowCount = pstm.executeUpdate();

        return rowCount>0;
    }

    @Override
    public ArrayList obtenerTodo() throws SQLException {
        String sql = "SELECT * FROM tablaIA; ";
        ArrayList<modeloIA> resultado = new ArrayList<>();
        Statement stm = ConexionSingleton.getInstance("BaseDatosIA.db").getConnection().createStatement();
        ResultSet rst = stm.executeQuery(sql);
        while (rst.next()){
            resultado.add(new modeloIA(rst.getInt(1),
                    rst.getString(2), rst.getString(3),
                    rst.getString(4), rst.getString(5),
                    rst.getString(6)));
        }
        return resultado;
    }

    @Override
    public Object buscarPorId(String id) throws SQLException {
        String sql = "SELECT * FROM tablaIA WHERE id = ? ;";
        modeloIA modeloia = null;
        PreparedStatement pstm = ConexionSingleton.getInstance("BaseDatosIA.db").getConnection().prepareStatement(sql);
        pstm.setInt(1,Integer.parseInt(id));
        ResultSet rst = pstm.executeQuery();
        if (rst.next()){
            modeloia = new modeloIA(rst.getInt(1),
                    rst.getString(2), rst.getString(3),
                    rst.getString(4), rst.getString(5),
                    rst.getString(6));
            return modeloia;
        }
        return null;
    }
}
