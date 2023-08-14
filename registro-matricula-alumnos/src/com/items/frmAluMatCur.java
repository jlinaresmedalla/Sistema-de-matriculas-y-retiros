package com.items;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;

import com.entidades.Alumno;
import com.entidades.Curso;
import com.entidades.Matricula;
import com.sistemaComercial.MenuPrincipal;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class frmAluMatCur extends JInternalFrame {
	private JTextArea textAreaReporte;
	private JButton btnNewButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmAluMatCur frame = new frmAluMatCur();
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
	public frmAluMatCur() {
		setClosable(true);
		setTitle("Reporte Alumnos por Curso");
		setBounds(100, 100, 410, 638);
		getContentPane().setLayout(null);
		
		textAreaReporte = new JTextArea();
		textAreaReporte.setFont(new Font("Monospaced", Font.PLAIN, 13));
		textAreaReporte.setBounds(10, 99, 374, 498);
		getContentPane().add(textAreaReporte);
		
		btnNewButton = new JButton("CONSULTAR");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					listar();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(desktopIcon,"Error");
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton.setBounds(146, 55, 107, 33);
		getContentPane().add(btnNewButton);
		
		JLabel lblAlumnosPorCurso = new JLabel("ALUMNOS POR CURSO");
		lblAlumnosPorCurso.setHorizontalAlignment(SwingConstants.CENTER);
		lblAlumnosPorCurso.setForeground(Color.RED);
		lblAlumnosPorCurso.setFont(new Font("Arial Black", Font.BOLD, 18));
		lblAlumnosPorCurso.setBounds(0, 11, 394, 33);
		getContentPane().add(lblAlumnosPorCurso);

	}

	void listar() {
		textAreaReporte.setText("");
		for(Curso c : MenuPrincipal.arregloCursos.getCurso()) {
			imprimir("  ===========================");
			imprimir("  CURSO  : " + c.getAsignatura());
			imprimir("  ---------------------------");
			for(Matricula m : MenuPrincipal.arregloMatriculas.getMatricula()) {
				if(m.getCodCurso() == c.getCodCurso()) {
					Alumno a = MenuPrincipal.arregloAlumnos.buscar(m.getCodAlumno());
					imprimir("  - " + a.getNombres() + " " +  a.getApellidos());
				};
			}
		}
	}
	
	//  M�todos tipo void (sin par�metros)
	void imprimir() {
		imprimir("");
	}
	//  M�todos tipo void (con par�metros)
	void imprimir(String s) {
		textAreaReporte.append(s + "\n");
	}
}
