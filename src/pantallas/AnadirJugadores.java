package pantallas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;

public class AnadirJugadores extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AnadirJugadores frame = new AnadirJugadores();
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
	public AnadirJugadores() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 426, 629);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAadirJugador = new JLabel("A\u00F1adir Jugador");
		lblAadirJugador.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblAadirJugador.setBounds(25, 32, 167, 25);
		contentPane.add(lblAadirJugador);
		
		JLabel lblIdjugador = new JLabel("IdJugador:");
		lblIdjugador.setBounds(25, 73, 87, 20);
		contentPane.add(lblIdjugador);
		
		textField = new JTextField();
		textField.setBounds(25, 100, 146, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(25, 142, 69, 20);
		contentPane.add(lblNombre);
		
		textField_1 = new JTextField();
		textField_1.setBounds(25, 170, 146, 26);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblEdad = new JLabel("Edad:");
		lblEdad.setBounds(25, 212, 69, 20);
		contentPane.add(lblEdad);
		
		textField_2 = new JTextField();
		textField_2.setBounds(25, 248, 146, 26);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNacionalidad = new JLabel("Nacionalidad:");
		lblNacionalidad.setBounds(25, 290, 112, 20);
		contentPane.add(lblNacionalidad);
		
		textField_3 = new JTextField();
		textField_3.setBounds(25, 320, 146, 26);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblPala = new JLabel("Pala:");
		lblPala.setBounds(25, 362, 69, 20);
		contentPane.add(lblPala);
		
		textField_4 = new JTextField();
		textField_4.setBounds(25, 392, 146, 26);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblManoHbil = new JLabel("Mano H\u00E1bil:");
		lblManoHbil.setBounds(25, 434, 112, 20);
		contentPane.add(lblManoHbil);
		
		textField_5 = new JTextField();
		textField_5.setBounds(25, 463, 146, 26);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		JLabel lblPosicin = new JLabel("Posici\u00F3n:");
		lblPosicin.setBounds(25, 505, 69, 20);
		contentPane.add(lblPosicin);
		
		textField_6 = new JTextField();
		textField_6.setBounds(25, 531, 146, 26);
		contentPane.add(textField_6);
		textField_6.setColumns(10);
		
		JButton btnAadirJugador = new JButton("A\u00F1adir Jugador");
		btnAadirJugador.setBounds(231, 517, 146, 29);
		contentPane.add(btnAadirJugador);
	}
}
