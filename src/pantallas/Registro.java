package pantallas;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import clases.Usuario;
import db.InsertData;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

public class Registro extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Registro frame = new Registro();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Creacion del JFrame del Registro de usuarios
	 */
	public Registro() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 596, 465);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(36, 49, 69, 20);
		contentPane.add(lblNombre);
		
		textField = new JTextField();
		textField.setBounds(33, 85, 146, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNombreDeUsuario = new JLabel("Nombre de usuario:");
		lblNombreDeUsuario.setBounds(36, 127, 156, 20);
		contentPane.add(lblNombreDeUsuario);
		
		textField_1 = new JTextField();
		textField_1.setBounds(33, 163, 146, 26);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a:");
		lblContrasea.setBounds(36, 206, 107, 20);
		contentPane.add(lblContrasea);
		
		JLabel lblRepetirContrasea = new JLabel("Repetir contrase\u00F1a:");
		lblRepetirContrasea.setBounds(36, 286, 146, 20);
		contentPane.add(lblRepetirContrasea);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(36, 242, 143, 26);
		contentPane.add(passwordField);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(36, 329, 146, 26);
		contentPane.add(passwordField_1);
		
		JButton btnCrearUsuario = new JButton("Crear Usuario");
		btnCrearUsuario.setBounds(413, 251, 134, 29);
		btnCrearUsuario.addActionListener(new ActionListener(){
			/**
			 * Acciona el botón Crear Usuario. Para ello comprueba que las dos contrasenyas sean iguales y 
			 * si son iguales añade los datos del usuario a la base de datos
			 */
			public void actionPerformed (ActionEvent e){
				InsertData insertar= new InsertData();
				
				String pass=passwordField.getText();
				String pass2=passwordField_1.getText();
				if (pass.equals(pass2)){
					insertar.insertUsuario(textField.getText(), textField_1.getText(), passwordField.getText(), 0);
					JOptionPane.showMessageDialog(null, "¡Usuario creado!, ahora inicie sesión");
				}else{
					JOptionPane.showMessageDialog(null, "Las contraseñas no coinciden");
				}
				
			}
		});
		contentPane.add(btnCrearUsuario);
		
		JButton btnIniciarSesin = new JButton("Iniciar Sesi\u00F3n");
		btnIniciarSesin.setBounds(413, 310, 134, 29);
		btnIniciarSesin.addActionListener(new ActionListener(){
			/**
			 * Acciona el boton Iniciar Sesion. Te lleva al la pestaña Login y cierra Registro.
			 */
			public void actionPerformed (ActionEvent e){
				Login pantalla=new Login();
				pantalla.setVisible(true);
				dispose();
			}
		});
		contentPane.add(btnIniciarSesin);
	}
}
