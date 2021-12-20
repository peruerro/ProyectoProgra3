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
import clases.Partido;
import clases.Torneo;
import db.InsertData;
import db.SelectData;
import db.UpdateData;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JSpinner;
import javax.swing.JLabel;
/**
 * Pantalla de Añadir partidos donde se insertan partidos
 * @author Peru Erro Arrue
 * @version 1.0
 *
 */
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
	 * Metodo para conseguir el id del ganador
	 * @param list un JList
	 * @return el idGanador
	 */
	public static int devolverIdGanador(JList list){
		String lista="SELECT idJugador, nombre, edad, nacionalidad, pala, manoHabil, posicion, puntosRanking from Jugador";
		ArrayList <Jugador> listaJug=SelectData.seleccionarJugador(lista);
		int idGanador=0;
		for(Jugador jug:listaJug){
			if(list.getSelectedValue().equals(jug.getNombre())){
				idGanador=jug.getIdJugador();
				
			}
		}
		return idGanador;
	}
	/**
	 * Metodo para conseguir el id del perdedor
	 * @param list un JList
	 * @return el idPerdedor
	 */
	public static int devolverIdPerdedor(JList list){
		String lista="SELECT idJugador, nombre, edad, nacionalidad, pala, manoHabil, posicion, puntosRanking from Jugador";
		ArrayList <Jugador> listaJug=SelectData.seleccionarJugador(lista);
		int idPerdedor=0;
		for(Jugador jug:listaJug){
			if(list.getSelectedValue().equals(jug.getNombre())){
				idPerdedor=jug.getIdJugador();
				
			}
		}
		return idPerdedor;
	}
	/**
	 * Consigue el id del torneo
	 * @param combo un JComboBox
	 * @return el id del torneo
	 */
	public static int devolverIdTorneo(JComboBox combo){
		String lista="SELECT idTorneo, nombre, idGanador from Torneo";
		ArrayList <Torneo> listaTor =SelectData.seleccionarTorneo(lista);
		int idTorneo=0;
		for(Torneo tor:listaTor){
			if(combo.getSelectedItem().toString().equals(tor.getNombreTorneo())){
				idTorneo=tor.getIdTorneo();
			}
		}

		return idTorneo;
	}
	public static int devolverIdFase(JComboBox combo){
		String lista="SELECT idFase, nombre, puntosGanador, puntosPerdedor from Fase";
		ArrayList <Fase> listaFas =SelectData.seleccionarFase(lista);
		int idFase=0;
		for(Fase fas:listaFas){
			if(combo.getSelectedItem().toString().equals(fas.getNombre())){
				idFase=fas.getIdFase();
			}
		}

		return idFase;
	}

	/**
	 * Create the frame.
	 */
	public AnadirPartidos() {
		getContentPane().setLayout(null);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 620, 687);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		

		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(65, 57, 406, 60);
		DefaultComboBoxModel<String>model=new DefaultComboBoxModel<String>();
		String lista="SELECT idTorneo, nombre, idGanador from Torneo";
		ArrayList <Torneo> listaTor=SelectData.seleccionarTorneo(lista);
		for(Torneo t: listaTor){
			model.addElement(t.getNombreTorneo());
		}
		comboBox.setModel(model);
		contentPane.add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(65, 148, 406, 43);
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
		
		JSpinner spinner = new JSpinner();
		spinner.setBounds(187, 232, 32, 26);
		contentPane.add(spinner);
		
		JSpinner spinner_1 = new JSpinner();
		spinner_1.setBounds(476, 232, 32, 26);
		contentPane.add(spinner_1);
		
		JLabel lblResultadoGanador = new JLabel("Resultado ganador:");
		lblResultadoGanador.setBounds(45, 238, 138, 20);
		contentPane.add(lblResultadoGanador);
		
		JLabel lblResultadoPerdedor = new JLabel("Resultado Perdedor:");
		lblResultadoPerdedor.setBounds(319, 235, 152, 20);
		contentPane.add(lblResultadoPerdedor);
		
		
		
		JButton btnAadirPartido = new JButton("A\u00F1adir Partido");
		btnAadirPartido.setBounds(400, 560, 152, 29);
		/**
		 * Acciona el boton añadir partido
		 */
		btnAadirPartido.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				InsertData insertar=new InsertData();
				
				String lista="SELECT idJugador, nombre, edad, nacionalidad, pala, manoHabil, posicion, puntosRanking from Jugador";
				ArrayList <Jugador> listaJug=SelectData.seleccionarJugador(lista);
				String lista1="SELECT idPartido, idGanador, idPerdedor, resultGanador, resultPerdedor, idFase, idTorneo from Partido";
				ArrayList <Partido> listaPar=SelectData.seleccionarPartido(lista1);
				int count=(int) listaPar.stream().count();
				int idPartido=count+1;
				int idGanador=devolverIdGanador(list);
				int idPerdedor=devolverIdPerdedor(list_1);
				int idTorneo=devolverIdTorneo(comboBox);
				int idFase=devolverIdFase(comboBox_1);
				int resultGan=(int) spinner.getValue();
				int resultPer=(int) spinner_1.getValue();
				insertar.insertPartido(idPartido, idGanador, idPerdedor, resultGan, resultPer, idFase, idTorneo);
				
				JOptionPane.showMessageDialog(AnadirPartidos.this, "Partido añadido con exito");
			
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
							UpdateData.updateJugador(puntosActual,j.getIdJugador());
						}else{
							JOptionPane.showMessageDialog(AnadirPartidos.this, "Selecciona un jugador");

						}
					}
				}else if (comboBox_1.getSelectedItem().toString().equals("Final")){
					for(Jugador j:listaJug){
						if (j.getNombre().equals(list.getSelectedValue())){
							Jugador j1=j;
							j1.sumarPuntos(1700);
							int puntosActual=j1.getPuntosRanking();
							UpdateData.updateJugador(puntosActual,j1.getIdJugador());
						}else{
							JOptionPane.showMessageDialog(AnadirPartidos.this, "Selecciona un jugador");

						}
					}
					for(Jugador j:listaJug){
						if (j.getNombre().equals(list_1.getSelectedValue())){
							j.sumarPuntos(1020);
							int puntosActual=j.getPuntosRanking();
							UpdateData.updateJugador(puntosActual,j.getIdJugador());
						}
					}
				}else{
					JOptionPane.showMessageDialog(AnadirPartidos.this, "Selecciona una fase");
				}
				
			}
		});
		contentPane.add(btnAadirPartido);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.setBounds(425, 602, 115, 29);
		/**
		 * Acciona el boton volver
		 */
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
