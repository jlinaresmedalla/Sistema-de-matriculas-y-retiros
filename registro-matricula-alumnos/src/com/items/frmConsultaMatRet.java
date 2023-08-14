package com.items;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;

import com.entidades.Alumno;
import com.entidades.Curso;
import com.entidades.Matricula;
import com.entidades.Retiro;
import com.sistemaComercial.MenuPrincipal;

import javax.swing.JButton;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class frmConsultaMatRet extends JInternalFrame {
	private JTextArea textAreaConsulta;
	private JComboBox cbMatricula;
	private JComboBox cbRetiro;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmConsultaAluCur frame = new frmConsultaAluCur();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public frmConsultaMatRet() {
		setClosable(true);
		setTitle("Consulta de Alumnos y Cursos");
		setBounds(100, 100, 450, 660);
		getContentPane().setLayout(null);
		
		textAreaConsulta = new JTextArea();
		textAreaConsulta.setFont(new Font("Monospaced", Font.PLAIN, 13));
		textAreaConsulta.setBounds(29, 175, 378, 444);
		getContentPane().add(textAreaConsulta);
		
		JLabel etiquetaCodAlu = new JLabel("CODIGO");
		etiquetaCodAlu.setFont(new Font("Tahoma", Font.BOLD, 13));
		etiquetaCodAlu.setBounds(65, 43, 65, 21);
		getContentPane().add(etiquetaCodAlu);
		
		JLabel lblConsultarAlumno = new JLabel("CONSULTAR MATRICULA");
		lblConsultarAlumno.setHorizontalAlignment(SwingConstants.CENTER);
		lblConsultarAlumno.setForeground(Color.RED);
		lblConsultarAlumno.setFont(new Font("Arial Black", Font.BOLD, 18));
		lblConsultarAlumno.setBounds(10, 11, 412, 21);
		getContentPane().add(lblConsultarAlumno);
		
		JLabel lblConsultarCurso = new JLabel("CONSULTAR RETIRO");
		lblConsultarCurso.setHorizontalAlignment(SwingConstants.CENTER);
		lblConsultarCurso.setForeground(Color.RED);
		lblConsultarCurso.setFont(new Font("Arial Black", Font.BOLD, 18));
		lblConsultarCurso.setBounds(10, 95, 412, 21);
		getContentPane().add(lblConsultarCurso);
		
		JLabel etiquetaCodCur = new JLabel("CODIGO");
		etiquetaCodCur.setFont(new Font("Tahoma", Font.BOLD, 13));
		etiquetaCodCur.setBounds(65, 130, 65, 21);
		getContentPane().add(etiquetaCodCur);
		
		JButton btnConMatricula = new JButton("CONSULTAR");
		btnConMatricula.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					listarMatricula();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(desktopIcon,"Matricula no existe en la base de datos");
				}
		
			}
		});
		btnConMatricula.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnConMatricula.setBounds(275, 37, 114, 32);
		getContentPane().add(btnConMatricula);
		
		JButton btnConRetiro = new JButton("CONSULTAR");
		btnConRetiro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					listarRetiro();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(desktopIcon, "Retiro no existe en la base de datos");
				}
			}
		});
		btnConRetiro.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnConRetiro.setBounds(275, 124, 114, 32);
		getContentPane().add(btnConRetiro);
		
		Component horizontalStrut = Box.createHorizontalStrut(20);
		horizontalStrut.setBounds(29, 75, 378, 20);
		getContentPane().add(horizontalStrut);
		
		cbMatricula = new JComboBox();
		cbMatricula.setModel(new DefaultComboBoxModel(codMatriculas()));
		cbMatricula.setBounds(134, 43, 131, 22);
		getContentPane().add(cbMatricula);
		
		cbRetiro = new JComboBox();
		cbRetiro.setModel(new DefaultComboBoxModel(codRetiros()));
		cbRetiro.setBounds(134, 130, 131, 22);
		getContentPane().add(cbRetiro);

	}
	
	String[] codMatriculas() {
		int m = MenuPrincipal.arregloMatriculas.tamanio();
		int i = 0;
		String[] ca = new String[m];
		for(Matricula a : MenuPrincipal.arregloMatriculas.getMatricula()) {
			ca[i] = String.valueOf(a.getNumMatricula());
			i++;
		}
		return ca;
	}
	
	String[] codRetiros() {
		int m = MenuPrincipal.arregloRetiros.tamanio();
		int i = 0;
		String[] ca = new String[m];
		for(Retiro a : MenuPrincipal.arregloRetiros.getRetiros()) {
			ca[i] = String.valueOf(a.getNumRetiro());
			i++;
		}
		return ca;
	}
	
	void listarMatricula() {
		int codMat = Integer.parseInt(cbMatricula.getSelectedItem().toString());
		Matricula m = MenuPrincipal.arregloMatriculas.buscarNumMat(codMat);
		int codAlu = m.getCodAlumno();
		Alumno a = MenuPrincipal.arregloAlumnos.buscar(codAlu);
		int codCur = m.getCodCurso();
		Curso c = MenuPrincipal.arregloCursos.buscar(codCur);
		
		textAreaConsulta.setText("");
		imprimir(" ===========================");
		imprimir(" Matricula");
		imprimir(" ---------------------------");
		imprimir(" Cod. Matricula : " + m.getNumMatricula());
		imprimir(" Fecha          : " + m.getFecha());
		imprimir(" Hora           : " + m.getHora());
		imprimir(" ===========================");
		imprimir(" Alumno");
		imprimir(" ---------------------------");
		imprimir(" Cod. Alumno : " + a.getCodAlumno());
		imprimir(" Nombres     : " + a.getNombres());
		imprimir(" Apellidos   : " + a.getApellidos());
		imprimir(" DNI         : " + a.getDni());
		imprimir(" Edad        : " + a.getEdad());
		imprimir(" Celular     : " + a.getCelular());
		String ms;
		switch(a.getEstado()) {
			case 0:	ms = "Registrado"; break;
			case 1: ms = "Matriculado"; break;
			case 2: ms = "Retirado"; break;
			default: ms="";
		}
		imprimir(" Estado      : " + ms);
		imprimir(" ===========================");
		imprimir(" CURSO");
		imprimir(" ---------------------------");
		imprimir(" Cod. Curso  : " + c.getCodCurso());
		imprimir(" Asignatura  : " + c.getAsignatura());
		imprimir(" Ciclo       : " + c.getCiclo());
		imprimir(" Creditos    : " + c.getCreditos());
		imprimir(" Horas       : " + c.getHoras());
	}
	
	void listarRetiro() {
		int codRet = Integer.parseInt(cbRetiro.getSelectedItem().toString());
		Retiro r = MenuPrincipal.arregloRetiros.buscarCod(codRet);
		int numMat = r.getNumMatricula();
		Matricula m = MenuPrincipal.arregloMatriculas.buscarNumMat(numMat);
		int codAlu = m.getCodAlumno();
		int codCur = m.getCodCurso();
		Alumno a = MenuPrincipal.arregloAlumnos.buscar(codAlu);
		Curso c = MenuPrincipal.arregloCursos.buscar(codCur);

		textAreaConsulta.setText("");
		imprimir(" ===========================");
		imprimir(" RETIRO");
		imprimir(" ---------------------------");
		imprimir(" Cod. Retiro    : " + r.getNumRetiro());
		imprimir(" Cod. Matricula : " + m.getNumMatricula());
		imprimir(" Fecha          : " + r.getFecha());
		imprimir(" Hora           : " + r.getHora());
		imprimir(" ===========================");
		imprimir(" ALUMNO");
		imprimir(" ---------------------------");
		imprimir(" Cod. Alumno : " + a.getCodAlumno());
		imprimir(" Nombres     : " + a.getNombres());
		imprimir(" Apellidos   : " + a.getApellidos());
		imprimir(" DNI         : " + a.getDni());
		imprimir(" Edad        : " + a.getEdad());
		imprimir(" Celular     : " + a.getCelular());
		String ms;
		switch(a.getEstado()) {
			case 0:	ms = "Registrado"; break;
			case 1: ms = "Matriculado"; break;
			case 2: ms = "Retirado"; break;
			default: ms="";
		}
		imprimir(" Estado      : " + ms);
		imprimir(" ===========================");
		imprimir(" CURSO");
		imprimir(" ---------------------------");
		imprimir(" Cod. Curso  : " + c.getCodCurso());
		imprimir(" Asignatura  : " + c.getAsignatura());
		imprimir(" Ciclo       : " + c.getCiclo());
		imprimir(" Creditos    : " + c.getCreditos());
		imprimir(" Horas       : " + c.getHoras());
	}
	
	//  M�todos tipo void (sin par�metros)
	void imprimir() {
		imprimir("");
	}
	//  M�todos tipo void (con par�metros)
	void imprimir(String s) {
		textAreaConsulta.append(s + "\n");
	}
}
