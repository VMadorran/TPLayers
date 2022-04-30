package ar.unrn.tp3.ui;

import java.awt.ComponentOrientation;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import ar.unrn.tp3.modelo.Participante;
import ar.unrn.tp3.modelo.Participantes;
import ar.unrn.tp3.modelo.Persistencia;
import ar.unrn.tp3.modelo.Region;
import ar.unrn.tp3.modelo.Telefono;
import ar.unrn.tp3.modelo.UI;

public class AgregarUI extends JFrame implements UI{
//
	private JTextField nombre;
	private JTextField telefono;
	private JTextField region;
	private Persistencia persistencia;
	private Participantes interfaz;
	
	public AgregarUI(Participantes interfaz) throws SQLException {

		setupUIComponents();
		this.interfaz = interfaz;
	}

	//@Override
	public void setupUIComponents() {

		setTitle("Add Participant");
		setSize(400, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.nombre = new JTextField(10);
		this.telefono = new JTextField(10);
		this.region = new JTextField(10);
		this.nombre.setText("");
		this.telefono.setText("");
		this.region.setText("China");
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new FlowLayout());
		contentPane.add(new JLabel("Nombre: "));
		contentPane.add(nombre);
		contentPane.add(new JLabel("Telefono: "));
		contentPane.add(telefono);
		contentPane.add(new JLabel("Region: "));
		contentPane.add(region);
		JButton botonCargar = new JButton("Cargar");
		System.out.println("Boton");
		botonCargar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				onBotonCargar();
			}
		});
		contentPane.add(botonCargar);
		setContentPane(contentPane);
		contentPane.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		pack();
		setVisible(true);
	}

	//@Override
	public void onBotonCargar() {
		
		try {
			interfaz.crearParticipante(nombre.getText(), region.getText(), telefono.getText());
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, e.getMessage());
		}
		dispose();
	}
}
