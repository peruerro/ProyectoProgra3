package pantallas;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import javax.swing.JOptionPane;
import javax.swing.JMenu;
import javax.swing.JButton;

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
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(360, 111, 202, 104);
		DefaultComboBoxModel <String> model3 = new DefaultComboBoxModel<String>();
		String a="Filtrar por edad";
		String b="Filtrar por posicion";
		String c="Filtrar por nacionalidad";
		String d="Filtrar por pala";
		model3.addElement(a);
		model3.addElement(b);
		model3.addElement(c);
		model3.addElement(d);
		comboBox.setModel(model3);
		contentPane.add(comboBox);
		
		JButton btnFiltrar = new JButton("Filtrar");
		btnFiltrar.setBounds(448, 230, 115, 29);
		btnFiltrar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(comboBox.getSelectedItem().toString().equals("Filtrar por edad")){
					String edad= JOptionPane.showInputDialog(Jugadores.this,"Introduce una edad:");
					String sql="Select idJugador, nombre, edad, nacionalidad, pala, manoHabil, posicion, puntosRanking from Jugador";
					ArrayList<Jugador> j= SelectData.seleccionarJugador(sql);
					JList lista = new JList();
					DefaultListModel <Jugador> model=new DefaultListModel <Jugador>();
					for (Jugador a:j){
						String años=Integer.toString(a.getEdad());
						
						if(edad.equals(años)){
							model.addElement(a);
							lista.setModel(model);		
						}
					
					}
					lista.setBounds(34, 169, 406, 53);
					contentPane.add(lista);
					JOptionPane.showMessageDialog(Jugadores.this, lista,"Jugadores de "+edad+" años",-1);
	
				}if(comboBox.getSelectedItem().toString().equals("Filtrar por posicion")){
					String[] botones = {"Revés", "Derecha"};
					int ventanaPosiciones = JOptionPane.showOptionDialog(Jugadores.this, "Selecciona la posicion por la que quieres buscar", "Posición" , JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE,null,botones, botones[0]);
					String sql="Select idJugador, nombre, edad, nacionalidad, pala, manoHabil, posicion, puntosRanking from Jugador";
					ArrayList<Jugador> j= SelectData.seleccionarJugador(sql);
					if(ventanaPosiciones==0){
						JList listaRev = new JList();
						DefaultListModel <Jugador> model=new DefaultListModel <Jugador>();
						for(Jugador a:j){
							if(botones[0].equals(a.getPosicion())){
								model.addElement(a);
								listaRev.setModel(model);		
							}
						}listaRev.setBounds(34, 169, 406, 53);
						contentPane.add(listaRev);
						JOptionPane.showMessageDialog(Jugadores.this, listaRev,"Revés",-1);
						
					}if(ventanaPosiciones==1){
						JList listaDer = new JList();
						DefaultListModel <Jugador> model=new DefaultListModel <Jugador>();
						for(Jugador a:j){
							if(botones[1].equals(a.getPosicion())){
								model.addElement(a);
								listaDer.setModel(model);		
							}
						}listaDer.setBounds(34, 169, 406, 53);
						contentPane.add(listaDer);
						JOptionPane.showMessageDialog(Jugadores.this, listaDer,"Derecha",-1);
				
					}
				}
			}
		});
		contentPane.add(btnFiltrar);
		
		
		
		DefaultComboBoxModel <Jugador> model2 = new DefaultComboBoxModel <Jugador>();
		String lista2="SELECT idJugador, nombre, edad, nacionalidad,pala, manoHabil, posicion, puntosRanking from Jugador";
		ArrayList <Jugador> listaJug2=SelectData.seleccionarJugador(lista);
		for(Jugador j:listaJug2){
			model2.addElement(j);
		}
	}
}
