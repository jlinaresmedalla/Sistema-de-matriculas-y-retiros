package com.entidades;

public class Matricula {

	private int numMatricula;
	private int codAlumno;
	private int codCurso;
	private String fecha;
	private String hora;
	public static int correlativo = 100001;

	
	
	public Matricula(int codAlumno, int codCurso, String fecha, String hora) {
		this.numMatricula = correlativo;
		this.codAlumno = codAlumno;
		this.codCurso = codCurso;
		this.fecha = fecha;
		this.hora = hora;
		correlativo++;
	}

	public Matricula(int numMatricula, int codAlumno, int codCurso, String fecha, String hora, int correlativo) {
		this.numMatricula = numMatricula;
		this.codAlumno = codAlumno;
		this.codCurso = codCurso;
		this.fecha = fecha;
		this.hora = hora;
		this.correlativo = correlativo;
	}

	public Matricula() {
		this.numMatricula = correlativo;
		correlativo++;
	}
	
	public int getCodAlumno() {
		return codAlumno;
	}

	public void setCodAlumno(int codAlumno) {
		this.codAlumno = codAlumno;
	}

	public int getCodCurso() {
		return codCurso;
	}

	public void setCodCurso(int codCurso) {
		this.codCurso = codCurso;
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

	public int getNumMatricula() {
		return numMatricula;
	}
	
	
}