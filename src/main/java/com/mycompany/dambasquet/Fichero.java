package com.mycompany.dambasquet;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/*
 * Clase que escribe y lee en ficheros XML
 * Funciona cuando las clases están definidas como JavaBeans
 * es decir: atributos privados, stters y getters,
 * constructor vacio y serializable
 * 
 */
public class Fichero {
	private String nombre;

	public Fichero(String nombre) {
		this.nombre = nombre;
	}
	public void grabar(Object o){
		try {
			XMLEncoder codificador = new XMLEncoder(new FileOutputStream(new File(nombre))); //codificador que generará el XML
			codificador.writeObject(o);//escribimos
			codificador.close();//cerramos
		} catch (FileNotFoundException ex) {
			ex.printStackTrace();
		}	
	}
	public Object leer(){
		try {
			XMLDecoder decodificador = new XMLDecoder(new FileInputStream(new File(nombre)));
			Object o=decodificador.readObject();
			return o;
		} catch (FileNotFoundException ex) {
//			ex.printStackTrace();
//			System.out.println("Error al leer "+ ex.getMessage());
			return null;
		}
		
	}
}

