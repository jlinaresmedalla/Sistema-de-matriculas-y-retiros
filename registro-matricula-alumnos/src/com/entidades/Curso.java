package com.entidades;

public class Curso {
	
	private int codCurso;
	private String asignatura;
	private int ciclo;
	private int creditos;
	private int horas;
	
	public static int correlativo = 3001;
	
	public Curso(String asignatura, int ciclo, int creditos, int horas) {
		this.codCurso = correlativo;
		this.asignatura = asignatura;
		this.ciclo = ciclo;
		this.creditos = creditos;
		this.horas = horas;
		correlativo++;
	}
	
	public Curso() {
		this.codCurso = correlativo;
		correlativo++;
	}



	public Curso(int codCurso, String asignatura, int ciclo, int creditos, int horas,int correlativo) {
		this.codCurso = codCurso;
		this.asignatura = asignatura;
		this.ciclo = ciclo;
		this.creditos = creditos;
		this.horas = horas;
		this.correlativo = correlativo;
	}

	public String getAsignatura() {
		return asignatura;
	}

	public void setAsignatura(String asignatura) {
		this.asignatura = asignatura;
	}

	public int getCiclo() {
		return ciclo;
	}

	public void setCiclo(int ciclo) {
		this.ciclo = ciclo;
	}

	public int getCreditos() {
		return creditos;
	}

	public void setCreditos(int creditos) {
		this.creditos = creditos;
	}

	public int getHoras() {
		return horas;
	}

	public void setHoras(int horas) {
		this.horas = horas;
	}

	public int getCodCurso() {
		return codCurso;
	}
	
	public String obtenerCicloActual() {
		switch (this.ciclo){
			case 0: return "primero";
			case 1: return "segundo";
			case 2: return "tercero";
			case 3: return "cuarto";
			case 4: return "quinto";
			case 5: return "sexto";
			default: return "no registrado";
		}
	}
}
