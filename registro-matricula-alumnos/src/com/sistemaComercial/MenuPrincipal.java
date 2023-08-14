package com.sistemaComercial;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import com.items.*;
import com.arreglos.*;

import java.awt.BorderLayout;
import javax.swing.JDesktopPane;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import java.awt.event.InputEvent;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class MenuPrincipal {

	private JFrame frameMenuPrincipal;
	public static JDesktopPane escritorioPrincipal;
	public static ArregloAlumnos arregloAlumnos = new ArregloAlumnos();
	public static ArregloCursos arregloCursos = new ArregloCursos();
	public static ArregloMatriculas arregloMatriculas = new ArregloMatriculas();
	public static ArregloRetiros arregloRetiros = new ArregloRetiros();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuPrincipal window = new MenuPrincipal();
					window.frameMenuPrincipal.setVisible(true);
					//window.frameMenuPrincipal.setExtendedState(window.frameMenuPrincipal.MAXIMIZED_BOTH);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MenuPrincipal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frameMenuPrincipal = new JFrame();
		frameMenuPrincipal.setResizable(false);
		frameMenuPrincipal.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				salir();
			}
		});
		frameMenuPrincipal.setTitle("SISTEMA DE MATRICULA Y RETIRO");
		frameMenuPrincipal.setBounds(100, 100, 1520, 880);
		frameMenuPrincipal.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frameMenuPrincipal.setLocationRelativeTo(null);
		
		JMenuBar menuBar = new JMenuBar();
		frameMenuPrincipal.setJMenuBar(menuBar);
		
		JMenu menuInventario = new JMenu("MANTENIMIENTO");
		menuInventario.setFont(new Font("Tahoma", Font.BOLD, 12));
		menuBar.add(menuInventario);
		
		JMenuItem ItemConsultar = new JMenuItem("Alumno");
		ItemConsultar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_K, InputEvent.CTRL_DOWN_MASK));
		ItemConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmMantenimientoAlumnos a = new frmMantenimientoAlumnos();
				escritorioPrincipal.add(a);
				a.setVisible(true);
			}
		});
		menuInventario.add(ItemConsultar);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Curso");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmMantenimientoCursos c = new frmMantenimientoCursos();
				escritorioPrincipal.add(c);
				c.setVisible(true);
			}
		});
		menuInventario.add(mntmNewMenuItem);
		
		JMenu menuVentas = new JMenu("REGISTRO");
		menuVentas.setFont(new Font("Tahoma", Font.BOLD, 12));
		menuBar.add(menuVentas);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Matricula");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmRegistroMatricula c = new frmRegistroMatricula();
				escritorioPrincipal.add(c);
				c.setVisible(true);
			}
		});
		menuVentas.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Retiro");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmRegistroRetiro c = new frmRegistroRetiro();
				escritorioPrincipal.add(c);
				c.setVisible(true);
			}
		});
		menuVentas.add(mntmNewMenuItem_2);
		
		JMenu menuConfiguracion = new JMenu("CONSULTA");
		menuConfiguracion.setFont(new Font("Tahoma", Font.BOLD, 12));
		menuBar.add(menuConfiguracion);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Alumnos y Cursos");
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmConsultaAluCur c = new frmConsultaAluCur();
				escritorioPrincipal.add(c);
				c.setVisible(true);
			}
		});
		menuConfiguracion.add(mntmNewMenuItem_3);
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("Matriculas y Retiros");
		mntmNewMenuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmConsultaMatRet c = new frmConsultaMatRet();
				escritorioPrincipal.add(c);
				c.setVisible(true);
			}
		});
		menuConfiguracion.add(mntmNewMenuItem_4);
		
		JMenu mnNewMenu = new JMenu("RETIRO");
		mnNewMenu.setFont(new Font("Tahoma", Font.BOLD, 12));
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem_5 = new JMenuItem("Reporte Alumnos");
		mntmNewMenuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmReporteAluMat c = new frmReporteAluMat();
				escritorioPrincipal.add(c);
				c.setVisible(true);
			}
		});
		mnNewMenu.add(mntmNewMenuItem_5);
		
		JMenuItem mntmNewMenuItem_7 = new JMenuItem("Alumnos por curso");
		mntmNewMenuItem_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmAluMatCur c = new frmAluMatCur();
				escritorioPrincipal.add(c);
				c.setVisible(true);
			}
		});
		mnNewMenu.add(mntmNewMenuItem_7);
				
		JMenu menuAyuda = new JMenu("AYUDA");
		menuAyuda.setFont(new Font("Tahoma", Font.BOLD, 12));
		menuBar.add(menuAyuda);
		
		JMenuItem itemAcercaDe = new JMenuItem("ACERCA DE ..");
		itemAcercaDe.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, InputEvent.ALT_DOWN_MASK));
		itemAcercaDe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmAcercaDe a = new frmAcercaDe();
				escritorioPrincipal.add(a);
				a.setVisible(true);
			}
		});
		menuAyuda.add(itemAcercaDe);
		frameMenuPrincipal.getContentPane().setLayout(new BorderLayout(0, 0));
		
		escritorioPrincipal = new JDesktopPane();
		escritorioPrincipal.setBackground(new Color(128, 128, 255));
		frameMenuPrincipal.getContentPane().add(escritorioPrincipal, BorderLayout.CENTER);
		
		JLabel background = new JLabel("");
		background.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/com/recursos/bgCibertec.jpg")));
		background.setBounds(0, 0, 1579, 820);
		escritorioPrincipal.add(background);

	}
	
	private void salir() {
		int resp = javax.swing.JOptionPane.showConfirmDialog(frameMenuPrincipal, "¿Quiere salir de la aplicación?", "Confirmar salida", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
		if(resp == 0) {
			System.exit(0);
		}
	}

	public void setVisible(boolean b) {
		// TODO Auto-generated method stub
		frameMenuPrincipal.setVisible(true);
	}
}
