package com.items;

import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JInternalFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.entidades.Alumno;
import com.entidades.Curso;
import com.entidades.Matricula;
import com.sistemaComercial.MenuPrincipal;

import javax.swing.JScrollPane;
import java.awt.Component;
import java.awt.Desktop;

import javax.swing.ScrollPaneConstants;
import java.awt.Font;
import javax.swing.ListSelectionModel;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.SwingConstants;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class frmMantenimientoCursos extends JInternalFrame {
	private JTable tablaCursos;
	public static DefaultTableModel modeloTabla;
	private JScrollPane scrollPane;
	private JTextField ctAsignatura;
	private JTextField ctCiclo;
	private JTextField ctCreditos;
	private JTextField ctHoras;
	private JTextField ctCodigo;
	private JButton btnAdicionar;
	private JButton btnConsultar;
	private JButton btnModificar;
	private JButton btnEliminar;
	private JButton btnGuardarCambios;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmMantenimientoCursos frame1 = new frmMantenimientoCursos();
					frame1.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public frmMantenimientoCursos() {
		setTitle("Mantenimiento Cursos");
		setClosable(true);
		setBounds(100, 100, 625, 542);
		getContentPane().setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setFont(new Font("Tahoma", Font.PLAIN, 11));
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(21, 211, 569, 289);
		getContentPane().add(scrollPane);
		
		tablaCursos = new JTable();
		tablaCursos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					navegar();
				} catch (Exception e1) {
				// TODO Auto-generated catch block
				}
			}
		});
		scrollPane.setViewportView(tablaCursos);
		tablaCursos.setBorder(null);
		tablaCursos.setFillsViewportHeight(true);
		tablaCursos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tablaCursos.setFont(new Font("Tahoma", Font.PLAIN, 11));
		tablaCursos.setRowHeight(17);
		modeloTabla = new DefaultTableModel();
		modeloTabla.addColumn("Codigo");
		modeloTabla.addColumn("Asignatura");
		modeloTabla.addColumn("Ciclo");
		modeloTabla.addColumn("Creditos");
		modeloTabla.addColumn("Horas");
		tablaCursos.setModel(modeloTabla);
		
		JLabel etiquetaAsignatura = new JLabel("ASIGNATURA:");
		etiquetaAsignatura.setFont(new Font("Tahoma", Font.BOLD, 13));
		etiquetaAsignatura.setBounds(30, 83, 88, 21);
		getContentPane().add(etiquetaAsignatura);
		
		JLabel etiquetaCiclo = new JLabel("CICLO:");
		etiquetaCiclo.setFont(new Font("Tahoma", Font.BOLD, 13));
		etiquetaCiclo.setBounds(30, 115, 76, 21);
		getContentPane().add(etiquetaCiclo);
		
		JLabel etiquetaCreditos = new JLabel("CREDITOS:");
		etiquetaCreditos.setFont(new Font("Tahoma", Font.BOLD, 13));
		etiquetaCreditos.setBounds(30, 147, 76, 21);
		getContentPane().add(etiquetaCreditos);
		
		JLabel etiquetaHoras = new JLabel("HORAS:");
		etiquetaHoras.setFont(new Font("Tahoma", Font.BOLD, 13));
		etiquetaHoras.setBounds(30, 179, 65, 21);
		getContentPane().add(etiquetaHoras);
		
		ctAsignatura = new JTextField();
		ctAsignatura.setHorizontalAlignment(SwingConstants.CENTER);
		ctAsignatura.setBounds(124, 83, 172, 21);
		getContentPane().add(ctAsignatura);
		ctAsignatura.setColumns(10);
		
		ctCiclo = new JTextField();
		ctCiclo.setHorizontalAlignment(SwingConstants.CENTER);
		ctCiclo.setColumns(10);
		ctCiclo.setBounds(124, 115, 172, 20);
		getContentPane().add(ctCiclo);
		
		ctCreditos = new JTextField();
		ctCreditos.setHorizontalAlignment(SwingConstants.CENTER);
		ctCreditos.setColumns(10);
		ctCreditos.setBounds(124, 147, 129, 20);
		getContentPane().add(ctCreditos);
		
		ctHoras = new JTextField();
		ctHoras.setHorizontalAlignment(SwingConstants.CENTER);
		ctHoras.setColumns(10);
		ctHoras.setBounds(124, 179, 65, 20);
		getContentPane().add(ctHoras);

		btnConsultar = new JButton("CONSULTAR");
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				consultarTabla();
			}
		});
		btnConsultar.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnConsultar.setBounds(467, 57, 123, 38);
		getContentPane().add(btnConsultar);
		
		btnEliminar = new JButton("ELIMINAR");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
						eliminarItem();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(desktopIcon, "Selecciona la fila a eliminar");
				}
			}
		});
		btnEliminar.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnEliminar.setBounds(467, 98, 123, 38);
		getContentPane().add(btnEliminar);
		
		btnAdicionar = new JButton("ADICIONAR");
		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (MenuPrincipal.arregloCursos.buscarAsignatura(ctCreditos.getText())==null) {
						agregarItem();
					}
					else {
						mensaje("Curso ingresado ya existe!");
					}
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					mensaje("Ingresa valores correctos");
				}
			}
		});
		btnAdicionar.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnAdicionar.setBounds(334, 57, 123, 38);
		getContentPane().add(btnAdicionar);
		
		JLabel etiquetaTitulo = new JLabel("MANTENIMIENTO DE CURSOS");
		etiquetaTitulo.setForeground(new Color(255, 0, 0));
		etiquetaTitulo.setFont(new Font("Arial Black", Font.BOLD, 18));
		etiquetaTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		etiquetaTitulo.setBounds(10, 11, 596, 21);
		getContentPane().add(etiquetaTitulo);
		
		btnModificar = new JButton("MODIFICAR");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (MenuPrincipal.arregloCursos.buscar(Integer.parseInt(ctCodigo.getText()))==null) {
						mensaje("El curso solicitado no existe");
					}
					else {
						modificarItem(Integer.parseInt(ctCodigo.getText()));
					}
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					mensaje("Ingresa valores correctos");
				}
			}
		});
		btnModificar.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnModificar.setBounds(334, 98, 123, 38);
		getContentPane().add(btnModificar);
		
		JLabel etiquetaCodigo = new JLabel("CODIGO");
		etiquetaCodigo.setFont(new Font("Tahoma", Font.BOLD, 13));
		etiquetaCodigo.setBounds(30, 53, 65, 21);
		getContentPane().add(etiquetaCodigo);
		
		btnGuardarCambios = new JButton("GUARDAR CAMBIOS");
		btnGuardarCambios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuPrincipal.arregloCursos.grabar();
			}
		});
		btnGuardarCambios.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnGuardarCambios.setBounds(334, 162, 255, 38);
		getContentPane().add(btnGuardarCambios);
		
		ctCodigo = new JTextField();
		ctCodigo.setDisabledTextColor(new Color(0, 0, 0));
		ctCodigo.setEnabled(false);
		ctCodigo.setHorizontalAlignment(SwingConstants.CENTER);
		ctCodigo.setColumns(10);
		ctCodigo.setBounds(124, 53, 129, 20);
		getContentPane().add(ctCodigo);
	}
	
	public void eliminarItem() {
		int fila = tablaCursos.getSelectedRow();
		int codCurso = MenuPrincipal.arregloCursos.obtener(fila).getCodCurso();
		Matricula codCurMat = MenuPrincipal.arregloMatriculas.buscarCur(codCurso);
		if (codCurMat == null) {
			int resp = javax.swing.JOptionPane.showInternalConfirmDialog(tablaCursos, "¿Quiere eliminar la fila seleccionada?", "Confirmar eliminación", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
			if(resp == 0) {
				MenuPrincipal.arregloCursos.getCurso().remove(fila);
			}
		}else {
			mensaje("No debe haber alumnos maltriculado en este curso");
		}
		consultarTabla();
	}

	public void agregarItem(){
	    String asignatura = ctAsignatura.getText();
	    int ciclo = Integer.parseInt(ctCiclo.getText());
	    int creditos = Integer.parseInt(ctCreditos.getText());
	    int horas = Integer.parseInt(ctHoras.getText());
	    Curso array= new Curso(asignatura, ciclo, creditos, horas);
	    MenuPrincipal.arregloCursos.getCurso().add(array);
	    consultarTabla();
    }
      
	public void modificarItem(int cod){
		Curso a = MenuPrincipal.arregloCursos.buscar(cod);
	    a.setAsignatura(ctAsignatura.getText());
	    a.setCiclo(Integer.parseInt(ctCiclo.getText()));
	    a.setCreditos(Integer.parseInt(ctCreditos.getText()));;
	    a.setHoras(Integer.parseInt(ctHoras.getText())); ;
	    consultarTabla();
    }
	
	public static void consultarTabla(){
		if(modeloTabla.getRowCount() == 0) {
			llenarTabla();
		}else {
			modeloTabla.setRowCount(0);
			llenarTabla();
		}
	}

	private static void llenarTabla() {
		modeloTabla.setRowCount(0);
		for(Curso a : MenuPrincipal.arregloCursos.getCurso()) {
			Object[] ob = {a.getCodCurso(),a.getAsignatura(),a.getCiclo(),a.getCreditos(),a.getHoras()};
			modeloTabla.addRow(ob);
		}
	}
	
	void navegar(){
		int fila = tablaCursos.getSelectedRow();
		ctCodigo.setText("" +tablaCursos.getValueAt(fila, 0));
		ctAsignatura.setText("" +tablaCursos.getValueAt(fila, 1));
		ctCiclo.setText("" +tablaCursos.getValueAt(fila,2));
		ctCreditos.setText("" +tablaCursos.getValueAt(fila, 3));
		ctHoras.setText("" +tablaCursos.getValueAt(fila, 4));
	}
	
	void mensaje(String s) {
		JOptionPane.showMessageDialog(this, s);
	}

}

