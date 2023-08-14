package com.arreglos;

import com.entidades.Alumno;
import com.entidades.Curso;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

public class ArregloCursos {
	
	private ArrayList<Curso> curso;
	
	//Constructor
    public ArregloCursos() {
    	curso = new ArrayList<Curso>();
    	cargarCursos();
    }
    
	public void adicionar(Curso x) {
		curso.add(x);
	}	
	
	public int tamanio() {
		return curso.size();
	}
	
	public Curso obtener(int i) {
		return curso.get(i);
	}
	
	public Curso buscar(int codigo) {
		Curso x;
		for (int i=0; i<tamanio(); i++) {
			x = obtener(i);
			if (x.getCodCurso() == codigo) return x;
		}
		return null;
	}
	
	public Curso buscarAsignatura(String asig) {
		Curso x;
		for (int i=0; i<tamanio(); i++) {
			x = obtener(i);
			if (x.getAsignatura() == asig) return x;
		}
		return null;
	}
	
	public ArrayList<Curso> getCurso() {
		return curso;
	}

	public void setCurso(ArrayList<Curso> curso) {
		this.curso = curso;
	}
	
	private void grabarCursos() {
		try {
			PrintWriter pw;
			String linea;
			Curso x;
			pw = new PrintWriter(new FileWriter("cursos.txt"));
			for (int i=0; i<tamanio(); i++) {
				x = obtener(i);
				linea = x.getCodCurso() + ";" +
					    x.getAsignatura() + ";" +
						x.getCiclo() + ";" +
						x.getCreditos() + ";" +
						x.getHoras() + ";" +
						x.correlativo;
				pw.println(linea);
			}
			pw.close();
		}
		catch (Exception e) {
			System.out.println("para de grabar");
		}
	}
	
	private void cargarCursos() {
		try {
			BufferedReader br;
			String linea, asignatura;
			String[] s;
			int codigo, ciclo, creditos, horas, correlativo;
			br = new BufferedReader(new FileReader("cursos.txt"));
			while ((linea = br.readLine()) != null) {
				s = linea.split(";");
				codigo = Integer.parseInt(s[0].trim());
				asignatura = s[1].trim();
				ciclo = Integer.parseInt(s[2].trim());
				creditos = Integer.parseInt(s[3].trim());
				horas = Integer.parseInt(s[4].trim());
				correlativo = Integer.parseInt(s[5].trim());
				adicionar(new Curso(codigo, asignatura,ciclo, creditos, horas,correlativo));
			}
			br.close();
		}
		catch (Exception e) {
		}
	}
	
	public void grabar() {
		grabarCursos();
	}
	
	public void cargar() {
		cargarCursos();
	}
	
	
}
