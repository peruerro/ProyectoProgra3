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

import clases.Fase;
import clases.Jugador;
import clases.Torneo;
import db.SelectData;
import db.UpdateData;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JButton;

public class AnadirPartidos extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AnadirPartidos frame = new AnadirPartidos();
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
	public AnadirPartidos() {
		getContentPane().setLayout(null);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 611, 674);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(65, 97, 406, 60);
		DefaultComboBoxModel<String>model=new DefaultComboBoxModel<String>();
		String lista="SELECT idTorneo, nombre, idGanador from Torneo";
		ArrayList <Torneo> listaTor=SelectData.seleccionarTorneo(lista);
		for(Torneo t: listaTor){
			model.addElement(t.getNombreTorneo());
		}
		comboBox.setModel(model);
		contentPane.add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(65, 176, 406, 43);
		DefaultComboBoxModel<String>model2=new DefaultComboBoxModel<String>();
		String lista2="SELECT idFase, nombre, puntosGanador, puntosPerdedor from Fase";
		ArrayList <Fase> listaFas=SelectData.seleccionarFase(lista2);
		for(Fase f: listaFas){
			model2.addElement(f.getNombre());
		}
		comboBox_1.setModel(model2);
		contentPane.add(comboBox_1);
		
		JList list = new JList();
		list.setBounds(319, 274, 221, 208);
		DefaultListModel <String> model3=new DefaultListModel<String>();
		String lista3="SELECT idJugador, nombre, edad, nacionalidad, pala, manoHabil, posicion, puntosRanking from Jugador";
		ArrayList <Jugador> listaJug=SelectData.seleccionarJugador(lista3);
		for(Jugador j:listaJug){
			model3.addElement(j.getNombre());
		}
		list.setModel(model3);
		contentPane.add(list);
		
		JList list_1 = new JList();
		list_1.setBounds(319, 274, 221, 208);
		DefaultListModel <String> model4=new DefaultListModel<String>();
		String lista4="SELECT idJugador, nombre, edad, nacionalidad, pala, manoHabil, posicion, puntosRanking from Jugador";
		ArrayList <Jugador> listaJug2=SelectData.seleccionarJugador(lista4);
		for(Jugador jug:listaJug2){
			model4.addElement(jug.getNombre());
		}
		list_1.setModel(model4);
		contentPane.add(list_1);
				
		JScrollPane scroll = new JScrollPane(list);
		scroll.setBounds(30, 274, 221, 208);
		contentPane.add(scroll);
		
		JScrollPane scroll2 = new JScrollPane(list_1);
		scroll2.setBounds(319, 274, 221, 208);
		contentPane.add(scroll2);
		
		JButton btnAadirPartido = new JButton("A\u00F1adir Partido");
		btnAadirPartido.setBounds(400, 560, 152, 29);
		btnAadirPartido.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				String lista="SELECT idJugador, nombre, edad, nacionalidad, pala, manoHabil, posicion, puntosRanking from Jugador";
				ArrayList <Jugador> listaJug=SelectData.seleccionarJugador(lista);
				if(comboBox_1.getSelectedItem().toString().equals("Cuartos de Final")){
					for(Jugador j:listaJug){
						if (j.getNombre().equals(list.getSelectedValue())){
							Jugador j1=j;
							j1.sumarPuntos(0);
							int puntosActual=j1.getPuntosRanking();
							UpdateData.updateJugador(puntosActual,j1.getIdJugador());
						}
					}
					for(Jugador j:listaJug){
						if (j.getNombre().equals(list_1.getSelectedValue())){
							j.sumarPuntos(310);
							int puntosActual=j.getPuntosRanking();
							System.out.println(puntosActual);
							UpdateData.updateJugador(puntosActual,j.getIdJugador());
							
						}
					}
				}else if(comboBox_1.getSelectedItem().toString().equals("Semifinales")){
					for(Jugador j:listaJug){
						if (j.getNombre().equals(list.getSelectedValue())){
							Jugador j1=j;
							j1.sumarPuntos(0);
							int puntosActual=j1.getPuntosRanking();
							UpdateData.updateJugador(puntosActual,j1.getIdJugador());
						}
					}
					for(Jugador j:listaJug){
						if (j.getNombre().equals(list_1.getSelectedValue())){
							j.sumarPuntos(610);
							int puntosActual=j.getPuntosRanking();
							System.out.println(puntosActual);
							UpdateData.updateJugador(puntosActual,j.getIdJugador());
						}
					}
				}else if (comboBox_1.getSelectedItem().toString().equals("Final")){
					for(Jugador j:listaJug){
						if (j.getNombre().equals(list.getSelectedValue())){
							Jugador j1=j;
							j1.sumarPuntos(1700);
							int puntosActual=j1.getPuntosRanking();
							UpdateData.updateJugador(puntosActual,j1.getIdJugador());
						}
					}
					for(Jugador j:listaJug){
						if (j.getNombre().equals(list_1.getSelectedValue())){
							j.sumarPuntos(1020);
							int puntosActual=j.getPuntosRanking();
							System.out.println(puntosActual);
							UpdateData.updateJugador(puntosActual,j.getIdJugador());
						}
					}
				}
				
			}
		});
		contentPane.add(btnAadirPartido);
		
		
		
		
	}
}
