package pantallas;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import clases.Jugador;
import db.SelectData;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JMenuBar;
import javax.swing.JMenu;

public class Jugadores extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Jugadores frame = new Jugadores();
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
	public Jugadores() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 629, 419);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTop = new JLabel("Top 10");
		lblTop.setBounds(15, 57, 69, 20);
		contentPane.add(lblTop);
		
		JList list = new JList();
		list.setBounds(15, 113, 234, 158);
		DefaultListModel<Jugador>model=new DefaultListModel<Jugador>();
		String lista="SELECT idJugador, nombre, edad, nacionalidad,pala, manoHabil, posicion, puntosRanking from Jugador";
		ArrayList <Jugador> listaJug=SelectData.seleccionarJugador(lista);
		for(Jugador j: listaJug){
			model.addElement(j);
		}
		list.setModel(model);
		contentPane.add(list);
		
		JLabel lblFiltrarJugadores = new JLabel("Filtrar jugadores:");
		lblFiltrarJugadores.setBounds(367, 57, 130, 20);
		contentPane.add(lblFiltrarJugadores);
		
		
		DefaultComboBoxModel <Jugador> model2 = new DefaultComboBoxModel <Jugador>();
		String lista2="SELECT idJugador, nombre, edad, nacionalidad,pala, manoHabil, posicion, puntosRanking from Jugador";
		ArrayList <Jugador> listaJug2=SelectData.seleccionarJugador(lista);
		for(Jugador j:listaJug2){
			model2.addElement(j);
		}
	}
}
