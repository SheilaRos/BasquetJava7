package com.mycompany.dambasquet;

import java.time.LocalDate;

public class Equipo {
    private static int numEquipo = 0;
    private int id;
    private String nombre;
    private String localidad;
    private LocalDate creacion;
    private ListaJugadores listaJugadores;

    public Equipo() {
    }

    
    public Equipo(String nombre, String localidad, LocalDate creacion) {
        numEquipo++;
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
    public LocalDate getCreacion() {
        return creacion;
    }

    public void setCreacion(LocalDate creacion) {
        this.creacion = creacion;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setId(int id) {
        this.id = id;
    }
    public int getId() {
        return id;
    }

}
