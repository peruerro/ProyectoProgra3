package pantallas;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import clases.Jugador;
import db.SelectData;

import javax.swing.JList;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
/**
 * Pantalla de Clasificacion donde se podrá ver la clasificacion ordenada por puntos
 * @author Peru Erro Arrue
 * @version 1.0
 *
 */
public class Clasificacion extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Clasificacion frame = new Clasificacion();
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
	public Clasificacion() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 571, 511);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JList list = new JList();
		list.setBounds(54, 116, 413, 273);
		
		DefaultListModel <String> model=new DefaultListModel<String>();
		String lista="SELECT idJugador, nombre, edad, nacionalidad, pala, manoHabil, posicion, puntosRanking from Jugador order by puntosRanking desc";
		ArrayList <Jugador> listaJug=SelectData.seleccionarJugador(lista);
		int contador=0;
		for(Jugador j:listaJug){
			contador=contador+1;
			model.addElement(contador+".- "+j.getNombre()+" --> "+j.getPuntosRanking()+" puntos");
		}
		list.setModel(model);
		contentPane.add(list);
		
		JScrollPane scroll = new JScrollPane(list);
		scroll.setBounds(54, 116, 413, 273);
		contentPane.add(scroll);
		
		JLabel lblClasificacin = new JLabel("Clasificaci\u00F3n:");
		lblClasificacin.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblClasificacin.setBounds(54, 54, 184, 25);
		contentPane.add(lblClasificacin);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.setBounds(401, 410, 115, 29);
		btnVolver.addActionListener(e -> {
			MenuPrincipal pantalla=new MenuPrincipal();
			pantalla.setVisible(true);
			dispose();
		
		});
		contentPane.add(btnVolver);
		
		
	}
}
