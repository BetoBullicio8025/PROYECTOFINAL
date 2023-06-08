package org.example.modelo;

import javax.swing.*;
import java.awt.*;
import java.net.MalformedURLException;
import java.net.URL;

public class modeloIA {
    private int id;
    private String URL;
    private String nombre;
    private String desarrollador;
    private String tipoDeIA;
    private String fechaDeCreacion;

    @Override
    public String toString() {
        return "modeloIA{" +
                "id=" + id +
                ", URL='" + URL + '\'' +
                ", nombre='" + nombre + '\'' +
                ", desarrollador='" + desarrollador + '\'' +
                ", tipoDeIA='" + tipoDeIA + '\'' +
                ", fechaDeCreacion='" + fechaDeCreacion + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDesarrollador() {
        return desarrollador;
    }

    public void setDesarrollador(String desarrollador) {
        this.desarrollador = desarrollador;
    }

    public String getTipoDeIA() {
        return tipoDeIA;
    }

    public void setTipoDeIA(String tipoDeIA) {
        this.tipoDeIA = tipoDeIA;
    }

    public String getFechaDeCreacion() {
        return fechaDeCreacion;
    }

    public void setFechaDeCreacion(String fechaDeCreacion) {
        this.fechaDeCreacion = fechaDeCreacion;
    }

    public modeloIA() {
    }

    public modeloIA(int id, String URL, String nombre, String desarrollador, String tipoDeIA, String fechaDeCreacion) {
        this.id = id;
        this.URL = URL;
        this.nombre = nombre;
        this.desarrollador = desarrollador;
        this.tipoDeIA = tipoDeIA;
        this.fechaDeCreacion = fechaDeCreacion;
    }
    public ImageIcon crearIcono(){
        ImageIcon resultado = null;
        try {
            URL urlIcono = new URL(this.URL);
            resultado = new ImageIcon(urlIcono);
        }catch (MalformedURLException me){
            System.out.println(me.toString());
        }
        return resultado;
    }
}
