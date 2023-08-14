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
import com.sistemaComercial.MenuPrincipal;

import javax.swing.JButton;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class frmConsultaAluCur extends JInternalFrame {
	private JTextArea textAreaConsulta;
	private JComboBox cbAlumno;
	private JComboBox cbCurso;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmConsultaMatRet frame = new frmConsultaMatRet();
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
	public frmConsultaAluCur() {
		setClosable(true);
		setTitle("Consulta de Alumnos y Cursos");
		setBounds(100, 100, 450, 600);
		getContentPane().setLayout(null);
		
		textAreaConsulta = new JTextArea();
		textAreaConsulta.setFont(new Font("Monospaced", Font.PLAIN, 13));
		textAreaConsulta.setBounds(29, 175, 378, 384);
		getContentPane().add(textAreaConsulta);
		
		JLabel etiquetaCodAlu = new JLabel("CODIGO");
		etiquetaCodAlu.setFont(new Font("Tahoma", Font.BOLD, 13));
		etiquetaCodAlu.setBounds(65, 43, 65, 21);
		getContentPane().add(etiquetaCodAlu);
		
		JLabel lblConsultarAlumno = new JLabel("CONSULTAR ALUMNO");
		lblConsultarAlumno.setHorizontalAlignment(SwingConstants.CENTER);
		lblConsultarAlumno.setForeground(Color.RED);
		lblConsultarAlumno.setFont(new Font("Arial Black", Font.BOLD, 18));
		lblConsultarAlumno.setBounds(10, 11, 412, 21);
		getContentPane().add(lblConsultarAlumno);
		
		JLabel lblConsultarCurso = new JLabel("CONSULTAR CURSO");
		lblConsultarCurso.setHorizontalAlignment(SwingConstants.CENTER);
		lblConsultarCurso.setForeground(Color.RED);
		lblConsultarCurso.setFont(new Font("Arial Black", Font.BOLD, 18));
		lblConsultarCurso.setBounds(10, 95, 412, 21);
		getContentPane().add(lblConsultarCurso);
		
		JLabel etiquetaCodCur = new JLabel("CODIGO");
		etiquetaCodCur.setFont(new Font("Tahoma", Font.BOLD, 13));
		etiquetaCodCur.setBounds(65, 130, 65, 21);
		getContentPane().add(etiquetaCodCur);
		
		JButton btnConAlumno = new JButton("CONSULTAR");
		btnConAlumno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					listarAlumno();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(desktopIcon,"Alumno no existe en la base de datos");
				}
			}
		});
		btnConAlumno.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnConAlumno.setBounds(275, 37, 114, 32);
		getContentPane().add(btnConAlumno);
		
		JButton btnConAlumno_1 = new JButton("CONSULTAR");
		btnConAlumno_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					listarCurso();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(desktopIcon,"Alumno no existe en la base de datos");
				}
			}
		});
		btnConAlumno_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnConAlumno_1.setBounds(275, 124, 114, 32);
		getContentPane().add(btnConAlumno_1);
		
		Component horizontalStrut = Box.createHorizontalStrut(20);
		horizontalStrut.setBounds(29, 75, 378, 20);
		getContentPane().add(horizontalStrut);
		
		cbAlumno = new JComboBox();
		cbAlumno.setModel(new DefaultComboBoxModel(codAlumnos()));
		cbAlumno.setBounds(134, 43, 131, 22);
		getContentPane().add(cbAlumno);
		
		cbCurso = new JComboBox();
		cbCurso.setModel(new DefaultComboBoxModel(codCursos()));
		cbCurso.setBounds(134, 130, 131, 22);
		getContentPane().add(cbCurso);

	}
	
	String[] codAlumnos() {
		int m = MenuPrincipal.arregloAlumnos.tamanio();
		int i = 0;
		String[] ca = new String[m];
		for(Alumno a : MenuPrincipal.arregloAlumnos.getAlum()) {
			ca[i] = String.valueOf(a.getCodAlumno());
			i++;
		}
		return ca;
	}
	
	String[] codCursos() {
		int m = MenuPrincipal.arregloCursos.tamanio();
		int i = 0;
		String[] ca = new String[m];
		for(Curso a : MenuPrincipal.arregloCursos.getCurso()) {
			ca[i] = String.valueOf(a.getCodCurso());
			i++;
		}
		return ca;
	}
	
	void listarAlumno() {
		int codAlu = Integer.parseInt(cbAlumno.getSelectedItem().toString());
		Alumno a = MenuPrincipal.arregloAlumnos.buscar(codAlu);
		
		textAreaConsulta.setText("");
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
		if(a.getEstado() == 1) {
			int codCur = MenuPrincipal.arregloMatriculas.buscarAlu(codAlu).getCodCurso();
			Curso c = MenuPrincipal.arregloCursos.buscar(codCur);
			imprimir(" ===========================");
			imprimir(" CURSO");
			imprimir(" ---------------------------");
			imprimir(" Cod. Curso  : " + c.getCodCurso());
			imprimir(" Asignatura  : " + c.getAsignatura());
			imprimir(" Ciclo       : " + c.getCiclo());
			imprimir(" Creditos    : " + c.getCreditos());
			imprimir(" Horas       : " + c.getHoras());
		}

	}
	
	void listarCurso() {
		int codCur = Integer.parseInt(cbCurso.getSelectedItem().toString());
		Curso c = MenuPrincipal.arregloCursos.buscar(codCur);
		textAreaConsulta.setText("");
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
