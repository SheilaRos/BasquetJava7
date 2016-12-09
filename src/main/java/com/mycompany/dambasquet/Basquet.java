package com.mycompany.dambasquet;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Basquet {
    private static ListaEquipos misEquipos;
    private static Fichero miFicheroEquipos;
    public static void main(String[] args) {
            miFicheroEquipos =new Fichero("basket.xml");
            misEquipos =(ListaEquipos) miFicheroEquipos.leer();	 
            
            if(misEquipos == null){
		misEquipos = new ListaEquipos();
            }
           String nombreE = "";
           String nombreJ ="";
           String nombreP = "";
            int opcion=-1; 
		 do{
                    menu1();
                    opcion= EntradaDatos.pedirEntero("Escoge una opción");
                    switch(opcion){
			case 1:
                            altaEquipo();
			break;
			case 2:
                            altaJugador();
			break;
			case 3:
                           int opcion2 = 0;
                           do{ 
                            menu2();
                            opcion2= EntradaDatos.pedirEntero("Escoge una opción");
                            switch(opcion2){
                                case 1:
                                    nombreE= pedirCadenaNoVacia("Introduce el nombre de la localidad");
                                    System.out.println(Consultas.buscarEquipoLocalidad(misEquipos.getListaEquipo(), nombreE));
                                break;
                                case 2:
                                    nombreE = pedirCadenaNoVacia("Introduce el nombre de equipo.");
                                    System.out.println(Consultas.buscarJugadoresDeUnEquipo(misEquipos.getListaEquipo(), nombreE));
                                break;
                                case 3:
                                    nombreE = pedirCadenaNoVacia("Introduce el nombre de equipo.");
                                    nombreP = pedirCadenaNoVacia("Introduce el nombre de la posicion.");
                                    System.out.println(Consultas.buscarJugadoresDeUnEquipoYPosicion(misEquipos.getListaEquipo(), nombreE, nombreP));
                                break;
                                case 4:
                                    nombreE = pedirCadenaNoVacia("Introduce el nombre del equipo.");
                                    System.out.println(Consultas.buscarJugadoresMaxCanastasEquipo(misEquipos.getListaEquipo(), nombreE));
                                break;
                                default: System.out.println("opción incorrecta.");
                            }
                           }while(opcion2!=1 || opcion2!=2 || opcion2!=3 || opcion2!=4);
			break;
			case 4:
                            int opcion3 = 0;
                           do{ 
                            menu3();
                            opcion3= EntradaDatos.pedirEntero("Escoge una opción");
                            switch(opcion3){
                                case 1:
                                   nombreJ = pedirCadenaNoVacia("Introduce el nombre del jugador que quieres buscar.");
                                   System.out.println(Consultas.buscarJugadoresPorNombre(misEquipos.getListaEquipo(), nombreJ));
                                break;
                                case 2:
                                   int canastas = EntradaDatos.pedirEntero("Introduce el número de canastas mínimas:");
                                   System.out.println(Consultas.buscarJugadoresPorCanastas(misEquipos.getListaEquipo(), canastas));
                                break;
                                case 3:
                                    int asisMin = EntradaDatos.pedirEntero("Introduce el número de asistencias mínimas:");
                                    int asisMax = EntradaDatos.pedirEntero("Introduce el número de asistencias máximas:");
                                   System.out.println(Consultas.buscarJugadoresEntreAsistencias(misEquipos.getListaEquipo(), asisMin, asisMax));
                                break;
                                case 4:
                                   nombreP = pedirCadenaNoVacia("Introduce la posición.");
                                   System.out.println(Consultas.buscarJugadoresDeUnaPosicion(misEquipos.getListaEquipo(), nombreP));
                                break;
                                case 5:
                                   Date nacimiento = devolverDate("Introduce la fecha.");
                                   System.out.println(Consultas.buscarJugadoresNacimiento(misEquipos.getListaEquipo(), nacimiento));
                                break;
                                case 6:
                                    mostrarAVG(Consultas.avgMaxMinJugadoresPosicion(misEquipos.getListaEquipo()), 6);
                                break;
                                case 7:
                                    
                                break;
                                default: System.out.println("opción incorrecta.");
                            }
                           }while(opcion3!=1 || opcion3!=2 || opcion3!=3 || opcion3!=4 || opcion3!=5 || opcion3!=6 || opcion3!=7);
			break;
			case 5:
                            System.out.println("Hasta luego :D");
                            break;
			default: System.out.println("opción incorrecta.");
                    }
		 }while(opcion!=5);
        
    }
    public static void mostrarAVG(List<Estadisticas> estadisticas, int numeroConsulta){
        for(Estadisticas e: estadisticas){
            System.out.println("Posicion: "+e.getPosicion());
            System.out.println("AVG Canastas: "+e.getAvgCanastas());
            System.out.println("AVG Asistencias: "+e.getAvgAsistencias());
            System.out.println("AVG Rebotes: "+e.getAvgRebotes());
            if(numeroConsulta == 7){
                System.out.println("Máximo Canastas: "+e.getMaxCanastas());
                System.out.println("Máximo Asistencias: "+e.getMaxAsistencias());
                System.out.println("Máximo Rebotes: "+e.getMaxRebotes());
                System.out.println("Mínimo Canastas: "+e.getMinCanastas());
                System.out.println("Mínimo Asistencias: "+e.getMinAsistencias());
                System.out.println("Mínimo Rebotes: "+e.getMinRebotes());
            }
        }
    }
    public static void menu1(){
        System.out.println("<~~ Menú ~~>");
        System.out.println("[1]~ Dar de alta a un equipo.");
        System.out.println("[2]~ Dar de alta a un jugador.");
        System.out.println("[3]~ Menú de consultas de equipo.");
        System.out.println("[4]~ Menú de consultas de jugador.");
        System.out.println("[5]~ Salir.");
    }
    public static void menu2(){
        System.out.println("<~~ Menú Consultas de Equipo ~~>");
        System.out.println("[1]~ Consultar los equipos que hay en una localidad determinada.");
        System.out.println("[2]~ Devolver todos los jugadores de un equipo a partir del nombre del equipo.");
        System.out.println("[3]~ Devolver todos los jugadores de un equipo, a partir del nombre de este, que jueguen en la misma posición.");
        System.out.println("[4]~ Devuelve el jugador que más canastas ha realizado de un equipo determinado.");
    }
    public static void menu3(){
        System.out.println("<~~ Menú Consultas de Jugadores ~~>");
        System.out.println("[1]~ Buscar Jugador por nombre(no necesita introducir el nombre completo).");
        System.out.println("[2]~ Buscar el número de jugadores que hayan realizado un numero de canastas mayor o igual que el indicado.");
        System.out.println("[3]~ Buscar el número de jugadores que hayan efectuado un número de asistencias comprendido en un rango.");
        System.out.println("[4]~ Buscar jugadores que pertenezcan a una posición especifica.");
        System.out.println("[5]~ Buscar jugadores que hayan nacido en una fecha anterior a la especificada.");
        System.out.println("[6]~ Agrupar a los jugadores por una posición en el campo y devolver la media de asistencias, canastas y rebotes");
        System.out.println("[7]~ Agrupar a los jugadores por una posición en el campo y devolver la media, el máximo y el mínimo de asistencias, canastas y rebotes");
    }
    public static void altaEquipo(){
        int id = pedirID("Introduce la id de equipo:", "equipo");
        String nombre = pedirCadenaNoVacia("Introduce el nombre del equipo:");
        String localidad = pedirCadenaNoVacia("Introduce la localidad del equipo:");
        Date creacion =  devolverDate("Introduce la fecha de creación:");
        System.out.println(creacion);
        Equipo e = new Equipo(id, nombre, localidad, creacion);
        misEquipos.altaEquipo(e);
        miFicheroEquipos.grabar(misEquipos);
        System.out.println("Equipo dado de alta.");
    }
    public static Date devolverDate(String msg){
        System.out.println(msg);
        int dia = pedirFecha("Introduce el dia");
        int mes = pedirFecha("Introduce el mes");
        int anyo = pedirFecha("Introduce el año");
        Date fecha = new Date (anyo, mes, dia);
        return fecha;
    }
    public static int pedirFecha(String msg){
        int entero = 0;
        if(msg.contains("dia")){
           do{
               entero = EntradaDatos.pedirEntero(msg);
           }while(entero<0 || entero>31);
           
        }else if(msg.contains("mes")){
             do{
               entero = EntradaDatos.pedirEntero(msg);
           }while(entero<0 || entero>12);
            
        }else if(msg.contains("año")){
             do{
               entero = EntradaDatos.pedirEntero(msg);
           }while(entero<0);
            
        }
        return entero;
    }
    public static void altaJugador(){
        String nombreEquipo = pedirCadenaNoVacia("Introduce el nombre de tu equipo:");
        Equipo e = comprobarExistEquipo(nombreEquipo);
        if(e == null){
            System.out.println("El equipo no está registrado.");
        }else{
            int id = pedirID("Introduce la id de jugador:", "jugador");
            String nombre = pedirCadenaNoVacia("Introduce tu nombre:");
            String posicion = pedirCadenaNoVacia("Introduce tu posición:");
            Date nacimiento =  devolverDate("Introduce tu fecha de nacimiento:");
            Jugador j = new Jugador(id, nombre, nacimiento,(int)(Math.random()*40) ,(int)(Math.random()*40) ,(int)(Math.random()*40) ,posicion);
            e.getListaJugadores().altaJugador(j);
            miFicheroEquipos.grabar(misEquipos);
            System.out.println("Jugador dado de alta.");
        }
    }
    public static int pedirID(String msg, String tipo){
        int entero;
        boolean salir=false;
        do{
            entero=EntradaDatos.pedirEntero(msg);
            if(entero<=0){
		System.out.println("No se puede dejar en blanco.");
            }
            if(tipo.equalsIgnoreCase("jugador")){
                if(comprobarIDJugador(entero)){
                    System.out.println("Ya existe un jugador con está id, introduce otro id.");
                }else{
                    salir=true;
                }
            }else{
                if(comprobarIDEquipo(entero)){
                    System.out.println("Ya existe un equipo con está id, introduce otro id.");
                }else{
                    salir=true;
                }
            }
	}while(entero<=0 || !salir);
	return entero;
    }
    public static Boolean comprobarIDJugador(int num){
        Jugador j = null;
        for (Equipo e : misEquipos.getListaEquipo()) {
            j = e.getListaJugadores().obtenerJugadorId(num);
        }
        if(j==null){
            return false;
        }
        return true;
    }
    public static Boolean comprobarIDEquipo(int num){
        Equipo equipo = null;
        equipo = misEquipos.obtenerEquipoId(num);
        if(equipo == null){
            return false;
        }else{
            return true;
        }
    }
     public static String pedirCadenaNoVacia(String msg){
        String cadena;
	do{
            cadena=EntradaDatos.pedirCadena(msg);
            if(cadena.equals("")){
                System.out.println("No se puede dejar en blanco");
            }
	}while(cadena.equals(""));
	return cadena;
    }
    public static Equipo comprobarExistEquipo(String equipo){
        for(Equipo e : misEquipos.getListaEquipo()){
            if(e.getNombre().equalsIgnoreCase(equipo)){
                return e;
            }
        }
        return null;
    }
}