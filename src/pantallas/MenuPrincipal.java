package pantallas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.JButton;
/**
 * El menu principal donde se podra acceder al resto de funcionalidades de la app
 * @author Peru Erro Arrue
 * @version 1.0
 *
 */
public class MenuPrincipal extends JFrame {

	private JPanel contentPane;

	/**
	 * Hace funcionar la ventana
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuPrincipal frame = new MenuPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Crea el JFrame del menu principal
	 */
	public MenuPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 461, 353);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JList list = new JList();
		list.setFont(new Font("Tahoma", Font.PLAIN, 20));
		list.setBounds(25, 108, 207, 118);
		contentPane.add(list);
		
		
		DefaultListModel<String>model=new DefaultListModel<String>();
		
		String b=new String("Jugadores");
		String c=new String("Clasificación");
		String d=new String("Torneos");
		
		
		model.addElement(b);
		model.addElement(c);
		model.addElement(d);
		
		list.setModel(model);
		
		JLabel lblMen = new JLabel("MEN\u00DA");
		lblMen.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblMen.setBounds(25, 60, 80, 32);
		contentPane.add(lblMen);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(259, 197, 115, 29);
		contentPane.add(btnAceptar);
		btnAceptar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				if (list.getSelectedValue().equals("Noticias")){
					Noticias pantalla=new Noticias();
					pantalla.setVisible(true);
				}
				if(list.getSelectedValue().equals("Jugadores")){
					Jugadores pantalla=new Jugadores();
					pantalla.setVisible(true);
				}if (list.getSelectedValue().equals("Clasificación")){
					Clasificacion pantalla=new Clasificacion();
					pantalla.setVisible(true);
				}if (list.getSelectedValue().equals("Torneos")){
					Torneos pantalla=new Torneos();
					pantalla.setVisible(true);
				}MenuPrincipal.this.dispose();
				
			}
		
		
		
		});
		
	}
}
