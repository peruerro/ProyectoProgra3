package pantallas;

import java.awt.BorderLayout;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JButton;
import java.awt.Font;

/**
 * El menu de los administradores donde podran editar datos
 * @author Peru Erro Arrue
 * @version 1.0
 *
 */
public class MenuAdmin extends JFrame {

	private JPanel contentPane;

	/**
	 * Hace funcionar la ventana
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuAdmin frame = new MenuAdmin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Creacion del JFrame del menu de los administradores
	 */
	public MenuAdmin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 405, 321);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAadirDatos = new JLabel("A\u00F1adir datos");
		lblAadirDatos.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblAadirDatos.setBounds(34, 38, 141, 20);
		contentPane.add(lblAadirDatos);
		
		JList list = new JList();
		list.setFont(new Font("Tahoma", Font.PLAIN, 20));
		list.setBounds(34, 84, 183, 118);
		contentPane.add(list);
		DefaultListModel<String>model=new DefaultListModel<String>();
		
		String b=new String("Añadir partidos");
		String c=new String("Añadir jugadores");
		String d=new String("Añadir torneos");
		
		model.addElement(b);
		model.addElement(c);
		model.addElement(d);
		list.setModel(model);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(253, 168, 115, 29);
		contentPane.add(btnAceptar);
		btnAceptar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				if (list.getSelectedValue().equals("Añadir noticias")){
					AnadirNoticias pantalla=new AnadirNoticias();
					pantalla.setVisible(true);
				}
				if(list.getSelectedValue().equals("Añadir partidos")){
					AnadirPartidos pantalla=new AnadirPartidos();
					pantalla.setVisible(true);
				}if (list.getSelectedValue().equals("Añadir jugadores")){
					AnadirJugadores pantalla=new AnadirJugadores();
					pantalla.setVisible(true);
				}if (list.getSelectedValue().equals("Añadir torneos")){
					AnadirTorneos pantalla=new AnadirTorneos();
					pantalla.setVisible(true);
				}MenuAdmin.this.dispose();
				
			}
		});
	}
}
