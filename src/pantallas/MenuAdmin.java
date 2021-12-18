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
		lblAadirDatos.setBounds(34, 38, 98, 20);
		contentPane.add(lblAadirDatos);
		
		JList list = new JList();
		list.setBounds(34, 84, 187, 142);
		contentPane.add(list);
		DefaultListModel<String>model=new DefaultListModel<String>();
		String a=new String("A�adir noticias");
		String b=new String("A�adir partidos");
		String c=new String("A�adir jugadores");
		String d=new String("A�adir torneos");
		model.addElement(a);
		model.addElement(b);
		model.addElement(c);
		model.addElement(d);
		list.setModel(model);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(240, 197, 115, 29);
		contentPane.add(btnAceptar);
		btnAceptar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				if (list.getSelectedValue().equals("A�adir noticias")){
					A�adirNoticias pantalla=new A�adirNoticias();
					pantalla.setVisible(true);
				}
				if(list.getSelectedValue().equals("A�adir partidos")){
					A�adirPartidos pantalla=new A�adirPartidos();
					pantalla.setVisible(true);
				}if (list.getSelectedValue().equals("A�adir jugadores")){
					A�adirJugadores pantalla=new A�adirJugadores();
					pantalla.setVisible(true);
				}if (list.getSelectedValue().equals("A�adir torneos")){
					A�adirTorneos pantalla=new A�adirTorneos();
					pantalla.setVisible(true);
				}MenuAdmin.this.dispose();
				
			}
		});
	}
}
