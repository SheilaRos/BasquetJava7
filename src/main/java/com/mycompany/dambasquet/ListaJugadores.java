package com.mycompany.dambasquet;

import java.util.ArrayList;
import java.util.List;

public class ListaJugadores {
    
    private ArrayList<Jugador> listaJugadores;

    public ListaJugadores() {
        listaJugadores = new ArrayList<>();
    }
    public ArrayList<Jugador> getListaJugadores() {
        return listaJugadores;
    }
    public void setListaJugadores(ArrayList<Jugador> listaJugadores) {
        this.listaJugadores = listaJugadores;
    }
    public void altaJugador(Jugador j){
        listaJugadores.add(j);
    }
    public Jugador obtenerJugadorId(int id){
	Jugador ju = null;
        for(Jugador j : listaJugadores){
            if(j.getId()==id){
              ju = j;
            }
        }	
        return ju;
    }
}
