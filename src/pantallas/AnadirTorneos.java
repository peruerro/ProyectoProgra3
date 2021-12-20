package pantallas;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import clases.Jugador;
import clases.Partido;
import clases.Torneo;
import db.InsertData;
import db.SelectData;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
/**
 * Pantalla de Añadir torneos donde se insertan torneos
 * @author Peru Erro Arrue
 * @version 1.0
 *
 */
public class AnadirTorneos extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AnadirTorneos frame = new AnadirTorneos();
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
	public AnadirTorneos() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 480, 474);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNombreDelTorneo = new JLabel("Nombre del torneo:");
		lblNombreDelTorneo.setBounds(33, 76, 149, 20);
		contentPane.add(lblNombreDelTorneo);
		
		textField = new JTextField();
		textField.setBounds(33, 112, 146, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JList list = new JList();
		list.setBounds(28, 179, 221, 208);
		DefaultListModel <String> model=new DefaultListModel<String>();
		String lista3="SELECT idJugador, nombre, edad, nacionalidad, pala, manoHabil, posicion, puntosRanking from Jugador";
		ArrayList <Jugador> listaJug=SelectData.seleccionarJugador(lista3);
		for(Jugador j:listaJug){
			model.addElement(j.getNombre());
		}
		list.setModel(model);
		contentPane.add(list);
		
		JScrollPane scroll = new JScrollPane(list);
		scroll.setBounds(28, 179, 221, 208);
		contentPane.add(scroll);
		
		JButton btnAadirTorneo = new JButton("A\u00F1adir torneo");
		btnAadirTorneo.setBounds(308, 336, 131, 29);
		/**
		 * Acciona el boton añadir torneo
		 */
		btnAadirTorneo.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				String lista="SELECT idTorneo, nombre, idGanador from Torneo";
				ArrayList <Torneo> listaTor=SelectData.seleccionarTorneo(lista);
				int count=(int) listaTor.stream().count();
				int idTorneo=count+1;
				String nombre=textField.getText();
				String id=textField.getText();
				for(Jugador j:listaJug){
					if(j.getNombre().equals(list.getSelectedValue())){
						int idGanador=j.getIdJugador();
						InsertData insertar= new InsertData();
						insertar.insertTorneo(idTorneo, nombre, idGanador);
					}
				}
				
			}
		});
		contentPane.add(btnAadirTorneo);
		
		JLabel lblGanadorDelTorneo = new JLabel("Ganador del torneo:");
		lblGanadorDelTorneo.setBounds(33, 157, 155, 20);
		contentPane.add(lblGanadorDelTorneo);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.setBounds(318, 373, 115, 29);
		btnVolver.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				MenuAdmin pantalla=new MenuAdmin();
				pantalla.setVisible(true);
				dispose();
			}
		});
		contentPane.add(btnVolver);
	}
}
