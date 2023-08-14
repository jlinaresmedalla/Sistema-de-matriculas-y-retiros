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
import com.entidades.Retiro;
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
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class frmRegistroRetiro extends JInternalFrame {
	private JTable tablaRetiros;
	public static DefaultTableModel modeloTabla;
	private JScrollPane scrollPane;
	private JTextField ctFecha;
	private JTextField ctHora;
	private JTextField ctNumMat;
	private JTextField ctCodigo;
	private JComboBox cbMatricula;
	private JButton btnAdicionar;
	private JButton btnConsultar;
	private JButton btnModificar;
	private JButton btnEliminar;
	private JButton btnGuardarCambios;
    DateTimeFormatter formatterDate = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    DateTimeFormatter formatterTime = DateTimeFormatter.ofPattern("hh:mm:ss");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmRegistroRetiro frame1 = new frmRegistroRetiro();
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
	public frmRegistroRetiro() {
		setTitle("Registro de Retiros");
		setClosable(true);
		setBounds(100, 100, 625, 540);
		getContentPane().setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setFont(new Font("Tahoma", Font.PLAIN, 11));
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(21, 211, 569, 289);
		getContentPane().add(scrollPane);
		
		tablaRetiros = new JTable();
		tablaRetiros.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					navegar();
				} catch (Exception e1) {
				// TODO Auto-generated catch block
				}
			}
		});
		scrollPane.setViewportView(tablaRetiros);
		tablaRetiros.setBorder(null);
		tablaRetiros.setFillsViewportHeight(true);
		tablaRetiros.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tablaRetiros.setFont(new Font("Tahoma", Font.PLAIN, 11));
		tablaRetiros.setRowHeight(17);
		modeloTabla = new DefaultTableModel();
		modeloTabla.addColumn("NumRetiro");
		modeloTabla.addColumn("NumMatricula");
		modeloTabla.addColumn("Fecha");
		modeloTabla.addColumn("Hora");
		tablaRetiros.setModel(modeloTabla);
		
		JLabel etiquetaFecha = new JLabel("FECHA:");
		etiquetaFecha.setFont(new Font("Tahoma", Font.BOLD, 13));
		etiquetaFecha.setBounds(30, 83, 65, 21);
		getContentPane().add(etiquetaFecha);
		
		JLabel etiquetaHora = new JLabel("HORA:");
		etiquetaHora.setFont(new Font("Tahoma", Font.BOLD, 13));
		etiquetaHora.setBounds(30, 115, 76, 21);
		getContentPane().add(etiquetaHora);
		
		JLabel etiquetaMatricula = new JLabel("N. MATRICULA:");
		etiquetaMatricula.setFont(new Font("Tahoma", Font.BOLD, 13));
		etiquetaMatricula.setBounds(30, 147, 96, 21);
		getContentPane().add(etiquetaMatricula);
		
		JLabel etiquetaNombreAlumno = new JLabel("MATRICULA:");
		etiquetaNombreAlumno.setFont(new Font("Tahoma", Font.BOLD, 13));
		etiquetaNombreAlumno.setBounds(30, 179, 96, 21);
		getContentPane().add(etiquetaNombreAlumno);
		
		ctFecha = new JTextField();
		ctFecha.setEnabled(false);
		ctFecha.setHorizontalAlignment(SwingConstants.CENTER);
		ctFecha.setBounds(136, 83, 172, 21);
		getContentPane().add(ctFecha);
		ctFecha.setColumns(10);
		
		ctHora = new JTextField();
		ctHora.setEnabled(false);
		ctHora.setHorizontalAlignment(SwingConstants.CENTER);
		ctHora.setColumns(10);
		ctHora.setBounds(136, 115, 172, 20);
		getContentPane().add(ctHora);
		
		ctNumMat = new JTextField();
		ctNumMat.setDisabledTextColor(new Color(0, 0, 0));
		ctNumMat.setEnabled(false);
		ctNumMat.setHorizontalAlignment(SwingConstants.CENTER);
		ctNumMat.setColumns(10);
		ctNumMat.setBounds(136, 179, 104, 20);
		getContentPane().add(ctNumMat);

		btnConsultar = new JButton("CONSULTAR");
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				consultarTabla();
			}
		});
		btnConsultar.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnConsultar.setBounds(467, 53, 123, 38);
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
		btnEliminar.setBounds(467, 94, 123, 38);
		getContentPane().add(btnEliminar);
		
		btnAdicionar = new JButton("ADICIONAR");
		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (MenuPrincipal.arregloRetiros.buscarNumMat(Integer.parseInt(cbMatricula.getSelectedItem().toString()))==null) {
						agregarItem();
					}
					else {
						mensaje("El Retiro solicitado ya existe!");
					}
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					mensaje("Ingresa valores correctos");
				}
			}
		});
		btnAdicionar.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnAdicionar.setBounds(334, 53, 123, 38);
		getContentPane().add(btnAdicionar);
		
		JLabel etiquetaTitulo = new JLabel("REGISTRO DE RETIROS");
		etiquetaTitulo.setForeground(new Color(255, 0, 0));
		etiquetaTitulo.setFont(new Font("Arial Black", Font.BOLD, 18));
		etiquetaTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		etiquetaTitulo.setBounds(10, 11, 596, 21);
		getContentPane().add(etiquetaTitulo);
		
		cbMatricula = new JComboBox();
		cbMatricula.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int numMat = MenuPrincipal.arregloMatriculas.buscarNumMat(Integer.parseInt(cbMatricula.getSelectedItem().toString()) ).getNumMatricula();
				ctNumMat.setText(""+numMat);;
			}
		});
		cbMatricula.setModel(new DefaultComboBoxModel(codMatriculas()));
		cbMatricula.setBounds(136, 146, 172, 22);
		getContentPane().add(cbMatricula);
		
		btnModificar = new JButton("MODIFICAR");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (MenuPrincipal.arregloRetiros.buscarCod(Integer.parseInt(ctCodigo.getText()))==null) {
						mensaje("El retiro solicitado no existe");
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
		btnModificar.setBounds(334, 94, 123, 38);
		getContentPane().add(btnModificar);
		
		JLabel etiquetaCodigo = new JLabel("CODIGO:");
		etiquetaCodigo.setFont(new Font("Tahoma", Font.BOLD, 13));
		etiquetaCodigo.setBounds(30, 53, 65, 21);
		getContentPane().add(etiquetaCodigo);
		
		btnGuardarCambios = new JButton("GUARDAR CAMBIOS");
		btnGuardarCambios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuPrincipal.arregloRetiros.grabar();
			}
		});
		btnGuardarCambios.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnGuardarCambios.setBounds(334, 158, 255, 38);
		getContentPane().add(btnGuardarCambios);
		
		ctCodigo = new JTextField();
		ctCodigo.setDisabledTextColor(new Color(0, 0, 0));
		ctCodigo.setEnabled(false);
		ctCodigo.setHorizontalAlignment(SwingConstants.CENTER);
		ctCodigo.setColumns(10);
		ctCodigo.setBounds(136, 53, 129, 20);
		getContentPane().add(ctCodigo);
	}
	
	
	public void eliminarItem() {
		int fila = tablaRetiros.getSelectedRow();
		int numMat = MenuPrincipal.arregloRetiros.obtener(fila).getNumMatricula();
		int codAlumno = MenuPrincipal.arregloMatriculas.buscarNumMat(numMat).getCodAlumno();
		int estado = MenuPrincipal.arregloAlumnos.buscar(codAlumno).getEstado();
		if (estado == 2) {
			int resp = javax.swing.JOptionPane.showInternalConfirmDialog(tablaRetiros, "¿Quiere eliminar la fila seleccionada?", "Confirmar eliminación", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
			if(resp == 0) {
				MenuPrincipal.arregloRetiros.getRetiros().remove(fila);
				MenuPrincipal.arregloAlumnos.buscar(codAlumno).setEstado(1);
			}
		}else {
			mensaje("El estado del alumno debe ser 2");
		}
		consultarTabla();
	}

	public void agregarItem(){
	    LocalDateTime now = LocalDateTime.now();
	    int codMatricula = Integer.parseInt(cbMatricula.getSelectedItem().toString());
	    String fecha = formatterDate.format(now);
	    String hora = formatterTime.format(now);
	    int codAlumno = MenuPrincipal.arregloMatriculas.buscarNumMat(codMatricula).getCodAlumno();
	    MenuPrincipal.arregloAlumnos.buscar(codAlumno).setEstado(2);
	    Retiro array= new Retiro(codMatricula, fecha, hora);
	    MenuPrincipal.arregloRetiros.getRetiros().add(array);
	    consultarTabla();
    }
      
	public void modificarItem(int cod){
		Retiro a = MenuPrincipal.arregloRetiros.buscarCod(cod);
	    a.setNumMatricula(Integer.parseInt(cbMatricula.getSelectedItem().toString()));
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
		for(Retiro a : MenuPrincipal.arregloRetiros.getRetiros()) {
			Object[] ob = {a.getNumRetiro(),a.getNumMatricula(),a.getFecha(),a.getHora()};
			modeloTabla.addRow(ob);
		}
	}
	
	void navegar(){
		int fila = tablaRetiros.getSelectedRow();
		ctCodigo.setText("" +tablaRetiros.getValueAt(fila, 0));
		ctFecha.setText("" +tablaRetiros.getValueAt(fila, 1));
		ctHora.setText("" +tablaRetiros.getValueAt(fila,2));
		ctNumMat.setText("" +tablaRetiros.getValueAt(fila, 3));
	}
	
	void mensaje(String s) {
		JOptionPane.showMessageDialog(this, s);
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

}


