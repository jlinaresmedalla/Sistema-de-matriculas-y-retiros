package com.entidades;

public class Retiro {
	
	private int numRetiro;
	private int numMatricula;
	private String fecha;
	private String hora;
	
	public static int correlativo = 200001;

	public Retiro(int numMatricula, String fecha, String hora) {
		this.numRetiro = correlativo;
		this.numMatricula = numMatricula;
		this.fecha = fecha;
		this.hora = hora;
		correlativo++;
	}

	public Retiro(int numRetiro, int numMatricula, String fecha, String hora, int correlativo) {
		this.numRetiro = numRetiro;
		this.numMatricula = numMatricula;
		this.fecha = fecha;
		this.hora = hora;
		this.correlativo = correlativo;
	}

	public Retiro() {
		this.numRetiro = correlativo;
		correlativo++;
	}
	
	public int getNumMatricula() {
		return numMatricula;
	}

	public void setNumMatricula(int numMatricula) {
		this.numMatricula = numMatricula;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public int getNumRetiro() {
		return numRetiro;
	}
	
}
