package com.arreglos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;


import com.entidades.Alumno;

public class ArregloAlumnos {
//  Atributo privado
	private ArrayList <Alumno> alum;
	//  Constructor
    public ArregloAlumnos() {
    	alum = new ArrayList<Alumno>();
    	cargarAlumnos();
    }
	//  Operaciones publicas basicas
	public void adicionar(Alumno x) {
		alum.add(x);
	}
	
	public int tamanio() {
		return alum.size();
	}
	
	public Alumno obtener(int i) {
		return alum.get(i);
	}
	
	public Alumno buscar(int codigo) {
		Alumno x;
		for (int i=0; i<tamanio(); i++) {
			x = obtener(i);
			if (x.getCodAlumno() == codigo) return x;
		}
		return null;
	}
	
	public Alumno buscar(String dni) {
		Alumno x;
		for (int i=0; i<tamanio(); i++) {
			x = obtener(i);
			if (x.getDni().equals(dni))	return x;
		}
		return null;
	}
		
	public void eliminar(Alumno x) {
		alum.remove(x);
	}
	public ArrayList<Alumno> getAlum() {
		return alum;
	}
	public void setAlum(ArrayList<Alumno> alum) {
		this.alum = alum;
	}

	private void grabarAlumnos() {
		try {
			PrintWriter pw;
			String linea;
			Alumno x;
			pw = new PrintWriter(new FileWriter("alumno.txt"));
			for (int i=0; i<tamanio(); i++) {
				x = obtener(i);
				linea = x.getCodAlumno() + ";" +
					    x.getNombres() + ";" +
						x.getApellidos() + ";" +
						x.getDni() + ";" +
						x.getEdad() + ";" +
						x.getCelular() + ";" +
						x.getEstado()+ ";" +
						x.correlativo;
				pw.println(linea);
			}
			pw.close();
		}
		catch (Exception e) {
			System.out.println("para de grabar");
		}
	}
	
	private void cargarAlumnos() {
		try {
			BufferedReader br;
			String linea, nombres, apellidos, dni;
			String[] s;
			int codigo, edad, celular, estado, correlativo;
			br = new BufferedReader(new FileReader("alumno.txt"));
			while ((linea = br.readLine()) != null) {
				s = linea.split(";");
				codigo = Integer.parseInt(s[0].trim());
				nombres = s[1].trim();
				apellidos = s[2].trim();
				dni = s[3].trim();
				edad = Integer.parseInt(s[4].trim());
				celular = Integer.parseInt(s[5].trim());
				estado = Integer.parseInt(s[6].trim());
				correlativo = Integer.parseInt(s[7].trim());
				adicionar(new Alumno(codigo, nombres,apellidos, dni, edad, celular, estado,correlativo));
			}
			br.close();
		}
		catch (Exception e) {
		}
	}
	
	public void grabar() {
		grabarAlumnos();
	}
	
	public void cargar() {
		cargarAlumnos();
	}
	
}
