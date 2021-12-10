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
/**
 * Pantalla de Login donde los usuarios podran entrar o crear un nuevo usuario
 * @author Peru Erro Arrue
 * @version 1.0
 *
 */
public class Login extends JFrame {
	/**
	 * El JPanel
	 */
	private JPanel contentPane;
	/**
	 * El JTextField donde se escribira el nombreUsuario
	 */
	private JTextField textField;
	/**
	 * El JPasswordField donde se escribira la contrasenya
	 */
	private JPasswordField passwordField;

	/**
	 * Hace funcionar la ventana
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
	 * Creacion del JFrame del Login
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
		btnCrearNuevoUsuario.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				Registro pantalla=new Registro ();
				pantalla.setVisible(true);
				dispose();
			}
		});
		contentPane.add(btnCrearNuevoUsuario);
		
		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.setBounds(264, 142, 115, 29);
		btnEntrar.addActionListener(new ActionListener(){
			/**
			 * Acciona el boton Entrar. Cuando es pulsado se comprueba si el usuario se encuentra en la BD
			 */
			public void actionPerformed(ActionEvent e) {
				boolean UsuarioValido=false;
				ArrayList<Usuario> u=SelectData.seleccionarUsuario();
				String nombreUsuario=textField.getText();
				String contrasenya=passwordField.getText();
				boolean usuarioValido=false;
				boolean eresEditor=false;
				for(Usuario a:u){
					if(nombreUsuario.equals(a.getNombreUsuario())&&contrasenya.equals(a.getContrasenya())&&(a.getAdmin())==0){
						usuarioValido=true;
						
						
					}else if(nombreUsuario.equals(a.getNombreUsuario())&&contrasenya.equals(a.getContrasenya())&&(a.getAdmin())==1){
						usuarioValido=true;
						eresEditor=true;
						
					}
				}if (usuarioValido){
					JOptionPane.showMessageDialog(Login.this, "Bienvenido");
					MenuPrincipal pantalla=new MenuPrincipal();
					pantalla.setVisible(true);	
					dispose();
				}else if(usuarioValido && eresEditor){
					JOptionPane.showMessageDialog(Login.this, "Bienvenido");
					MenuAdmin pantalla=new MenuAdmin();
					pantalla.setVisible(true);
				}else{
					JOptionPane.showMessageDialog(Login.this, "Usuario o contraseña incorrecta");
				}
				
			   
			}
		});
		contentPane.add(btnEntrar);
	
	}
}
