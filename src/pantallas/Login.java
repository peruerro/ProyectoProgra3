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
import db.SelectData;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNombreDeUsuario = new JLabel("Nombre de usuario:");
		lblNombreDeUsuario.setBounds(50, 60, 148, 20);
		contentPane.add(lblNombreDeUsuario);
		
		textField = new JTextField();
		textField.setBounds(50, 84, 146, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a:");
		lblContrasea.setBounds(50, 126, 112, 20);
		contentPane.add(lblContrasea);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(50, 162, 148, 26);
		contentPane.add(passwordField);
		
		JButton btnCrearNuevoUsuario = new JButton("Crear nuevo usuario");
		btnCrearNuevoUsuario.setBounds(227, 97, 186, 29);
		contentPane.add(btnCrearNuevoUsuario);
		
		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.setBounds(264, 142, 115, 29);
		btnEntrar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				boolean UsuarioValido=false;
				ArrayList<Usuario> u=SelectData.seleccionarUsuario();
				String nombreUsuario=textField.getText();
				String contrasenya=passwordField.getText();
				for(Usuario a:u){
					if(nombreUsuario.equals(a.getNombreUsuario())&&contrasenya.equals(a.getContrasenya())){
						MenuPrincipal pantalla=new MenuPrincipal();
						pantalla.setVisible(true);	
						dispose();
					}else{
						JOptionPane.showMessageDialog(Login.this, "Usuario o contraseña incorrecta");
					}
				}
				
			   
			}
		});
		contentPane.add(btnEntrar);
	
	}
}
