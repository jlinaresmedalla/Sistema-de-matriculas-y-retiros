package com.arreglos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

import com.entidades.Retiro;

public class ArregloRetiros {
	private ArrayList<Retiro> retiros;
	
	//Constructor
    public ArregloRetiros() {
    	retiros = new ArrayList<Retiro>();
    	cargarRetiro();
    }
    
	public void adicionar(Retiro x) {
		retiros.add(x);
	}	
	
	public int tamanio() {
		return retiros.size();
	}
	
	public Retiro obtener(int i) {
		return retiros.get(i);
	}
	
	public Retiro buscarCod(int codigo) {
		Retiro x;
		for (int i=0; i<tamanio(); i++) {
			x = obtener(i);
			if (x.getNumRetiro() == codigo) return x;
		}
		return null;
	}

	public Retiro buscarNumMat(int codigo) {
		Retiro x;
		for (int i=0; i<tamanio(); i++) {
			x = obtener(i);
			if (x.getNumMatricula() == codigo) return x;
		}
		return null;
	}
	
	public ArrayList<Retiro> getRetiros() {
		return retiros;
	}

	public void setRetiros(ArrayList<Retiro> retiros) {
		this.retiros = retiros;
	}
	
	private void grabarRetiro() {
		try {
			PrintWriter pw;
			String linea;
			Retiro x;
			pw = new PrintWriter(new FileWriter("retiros.txt"));
			for (int i=0; i<tamanio(); i++) {
				x = obtener(i);
				linea = x.getNumRetiro() + ";" +
					    x.getNumMatricula() + ";" +
						x.getFecha() + ";" +
						x.getHora() + ";" +
						x.correlativo;
				pw.println(linea);
			}
			pw.close();
		}
		catch (Exception e) {
			System.out.println("para de grabar");
		}
	}
	
	private void cargarRetiro() {
		try {
			BufferedReader br;
			String linea, fecha, hora;
			String[] s;
			int numRet, numMat, correlativo;
			br = new BufferedReader(new FileReader("retiros.txt"));
			while ((linea = br.readLine()) != null) {
				s = linea.split(";");
				numRet = Integer.parseInt(s[0].trim());
				numMat = Integer.parseInt(s[1].trim());
				fecha = s[2].trim();
				hora = s[3].trim();
				correlativo = Integer.parseInt(s[4].trim());
				adicionar(new Retiro(numRet, numMat, fecha, hora, correlativo));
			}
			br.close();
		}
		catch (Exception e) {
		}
	}
	
	public void grabar() {
		grabarRetiro();
	}
	
	public void cargar() {
		cargarRetiro();
	}
	
	
	
}
