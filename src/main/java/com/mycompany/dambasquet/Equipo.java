package com.mycompany.dambasquet;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

public class Equipo implements Serializable{
    private int id;
    private String nombre;
    private String localidad;
    private Date creacion;
    private ListaJugadores listaJugadores;

    public Equipo() {
    }
    public Equipo(int numEquipo, String nombre, String localidad, Date creacion) {
        this.id = numEquipo;
        this.nombre = nombre;
        this.localidad = localidad;
        this.creacion = creacion;
        listaJugadores = new ListaJugadores();
    }
    public ListaJugadores getListaJugadores() {
        return listaJugadores;
    }
    public void setListaJugadores(ListaJugadores listaJugadores) {
        this.listaJugadores = listaJugadores;
    }   
    public Date getCreacion() {
        return creacion;
    }

    public void setCreacion(Date creacion) {
        this.creacion = creacion;
    }

    public String getLocalidad() {
        return localidad;
    }
    public void setLocalidad(String localidad) {this.localidad = localidad;}
    public String getNombre() {return nombre;}
    public void setNombre(String nombre) {this.nombre = nombre; }
    public void setId(int id) {this.id = id;}
    public int getId() {return id;}

    @Override
    public String toString() {
        return "Equipo{" + "id=" + id + ", nombre=" + nombre + ", localidad=" + localidad + ", creacion=" + creacion + '}'+"\n";
    }
}
