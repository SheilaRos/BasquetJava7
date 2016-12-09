package com.mycompany.dambasquet;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Consultas {
    public static List<Jugador> buscarJugadoresPorNombre(List<Equipo> todosEquipos, String nombre) {
        List<Jugador> jugadores = new ArrayList<>();
        for (Equipo e : todosEquipos) {
            for (Jugador j : e.getListaJugadores().getListaJugadores()) {
                // Problema de Mayúsculas y minúsculas
                String nombreCompleto = j.getNombre().toLowerCase();
                String nombreMinusculas = nombre.toLowerCase();
                // Miramos si contiene una parte del nombre
                if (nombreCompleto.contains(nombreMinusculas)) {
                    jugadores.add(j);
                }
            }
        }
        return jugadores;
    }
    public static List<Jugador> buscarJugadoresPorCanastas(List<Equipo> todosEquipos, int canastas) {
        List<Jugador> jugadores = new ArrayList<>();
        for (Equipo e : todosEquipos) {
            for (Jugador j : e.getListaJugadores().getListaJugadores()) {
                if (j.getCanastas() >= canastas){
                    jugadores.add(j);
                }
            }
        }
        return jugadores;
    }
    public static List<Jugador> buscarJugadoresEntreAsistencias(List <Equipo> todosEquipos, int asistenciasMin, int asistenciasMax){
        List<Jugador> jugadoresAsistencias = new ArrayList<>();
        for (Equipo e : todosEquipos){
            for (Jugador j : e.getListaJugadores().getListaJugadores()){
                if(j.getAsistencias()>= asistenciasMin && j.getAsistencias() <= asistenciasMax ){
                    jugadoresAsistencias.add(j);
                }
            }
        }
        return jugadoresAsistencias;
    }
    public static List<Jugador> buscarJugadoresDeUnaPosicion(List<Equipo> todosEquipos, String posicion){
         List<Jugador> jugadoresPosicion = new ArrayList<>();
        for (Equipo e : todosEquipos){
            for (Jugador j : e.getListaJugadores().getListaJugadores()){
                if(j.getPosicion().equalsIgnoreCase(posicion) ){
                    jugadoresPosicion.add(j);
                }
            }
        }
        return jugadoresPosicion;
    }
    public static List<Jugador> buscarJugadoresDeUnEquipo(List<Equipo> todosEquipos, String equipo){
         List<Jugador> jugadoresDeUnEquipo = new ArrayList<>();
        for (Equipo e : todosEquipos){
            if(e.getNombre().equalsIgnoreCase(equipo)){
                for (Jugador j : e.getListaJugadores().getListaJugadores()){
                        jugadoresDeUnEquipo.add(j);
                }
            }
        }
        return jugadoresDeUnEquipo;
    }
    public static List<Equipo> buscarEquipoLocalidad(List<Equipo> todosEquipos, String localidad){
        System.out.println(localidad);
        List<Equipo> equiposLocalidad = new ArrayList<>();
        for (Equipo e : todosEquipos){
            if(e.getLocalidad().equalsIgnoreCase(localidad)){
                equiposLocalidad.add(e);
            }
        }
        return equiposLocalidad;
    }
    public static List<Jugador> buscarJugadoresDeUnEquipoYPosicion(List<Equipo> todosEquipos, String equipo, String posicion){
         List<Jugador> jugadoresEquipoPosicion = new ArrayList<>();
        for (Equipo e : todosEquipos){
            if(e.getNombre().equalsIgnoreCase(equipo)){
                for (Jugador j : e.getListaJugadores().getListaJugadores()){
                    if(j.getPosicion().equalsIgnoreCase(posicion) ){
                        jugadoresEquipoPosicion.add(j);
                    }
                }
            }
        }
        return jugadoresEquipoPosicion;
    }
    public static List<Jugador> buscarJugadoresMaxCanastasEquipo(List<Equipo> todosEquipos, String equipo){
        List<Jugador> jugadoresMaxCanastas = new ArrayList<>();
        int max = 0;
        for (Equipo e : todosEquipos){
            if(e.getNombre().equalsIgnoreCase(equipo)){
                for (Jugador j : e.getListaJugadores().getListaJugadores()){
                    if(j.getCanastas()>max){
                        max = j.getCanastas();
                    }
                }
                for (Jugador j : e.getListaJugadores().getListaJugadores()){
                    if(j.getCanastas()==max){
                       jugadoresMaxCanastas.add(j);
                    }
                }
            }
        }
        return jugadoresMaxCanastas;
    }
    public static List<Jugador> buscarJugadoresNacimiento(List<Equipo> todosEquipos, Date nacimiento){
        List<Jugador> jugadoresNacimiento= new ArrayList<>();
        for (Equipo e : todosEquipos){
            for (Jugador j : e.getListaJugadores().getListaJugadores()){
                if(j.getNacimiento().before(nacimiento)){
                    jugadoresNacimiento.add(j);
                }
            }   
        }
        return jugadoresNacimiento;
    }
    //Como utilizo una clase, para las 2 ultimas consultas me sirve está
    public static List<Estadisticas> avgMaxMinJugadoresPosicion(List<Equipo> todosEquipos){
        List<Estadisticas> avgPosicion = new ArrayList<>(); 
       for(Equipo e : todosEquipos){
           for(Jugador j: e.getListaJugadores().getListaJugadores()){
               for(Estadisticas posicion : avgPosicion){
                   if(!posicion.getPosicion().equals(j.getPosicion())){
                       Estadisticas nueva = new Estadisticas(j.getPosicion(), j.getCanastas(), j.getAsistencias(), j.getRebote());
                   }else{
                       modificarEstadisticas(posicion, j.getCanastas(), j.getAsistencias(), j.getRebote());
                   }
               }
           }
       }
       return avgPosicion;
    }
    
    public static void modificarEstadisticas(Estadisticas posicion, int canastas, int asist, int rebotes){
        posicion.setTotal(posicion.getTotal()+1);
        
        posicion.setSumaCanastas(posicion.getSumaCanastas()+canastas);
        posicion.setSumaAsistencias(posicion.getSumaAsistencias()+asist);
        posicion.setSumaRebotes(posicion.getSumaRebotes()+rebotes);
        
        if(posicion.getMaxCanastas()<canastas){
            posicion.setMaxCanastas(canastas);
        }else if(posicion.getMinCanastas()>canastas){
            posicion.setMinCanastas(canastas);
        }
        
        if(posicion.getMaxAsistencias()<asist){
            posicion.setMaxAsistencias(asist);
        }else if(posicion.getMinAsistencias()>asist){
            posicion.setMinAsistencias(asist);
        }
        
        if(posicion.getMaxRebotes()<rebotes){
            posicion.setMaxRebotes(rebotes);
        }else if(posicion.getMinRebotes()>rebotes){
            posicion.setMinRebotes(rebotes);
        }
        posicion.setAvgCanastas(posicion.getSumaCanastas()/posicion.getTotal());
        posicion.setAvgAsistencias(posicion.getSumaAsistencias()/posicion.getTotal());
        posicion.setAvgRebotes(posicion.getTotal());
    }
    
}
