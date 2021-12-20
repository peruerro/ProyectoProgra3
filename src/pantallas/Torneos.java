package pantallas;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import clases.Jugador;
import clases.Partido;
import clases.Torneo;
import db.SelectData;

import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import java.awt.Font;

public class Torneos extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Torneos frame = new Torneos();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public static int devolverIdTorneo(JList list){
		String lista="SELECT idTorneo, nombre, idGanador from Torneo";
		ArrayList <Torneo> listaTor =SelectData.seleccionarTorneo(lista);
		int idTorneo=0;
		for(Torneo tor:listaTor){
			if(list.getSelectedValue().equals(tor.getNombreTorneo())){
				idTorneo=tor.getIdTorneo();
			}
		}

		return idTorneo;
	}

	/**
	 * Create the frame.
	 */
	public Torneos() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 583, 527);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JList list = new JList();
		list.setFont(new Font("Tahoma", Font.PLAIN, 20));
		list.setBounds(56, 120, 308, 228);
		
		DefaultListModel<String>model=new DefaultListModel<String>();
		String lista="SELECT idTorneo, nombre, idGanador from Torneo";
		ArrayList <Torneo> listaTor=SelectData.seleccionarTorneo(lista);
		for(Torneo  t: listaTor){
			model.addElement(t.getNombreTorneo());
		}
		list.setModel(model);
		contentPane.add(list);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(405, 319, 115, 29);
		btnAceptar.addActionListener(e -> {
			if(list.getSelectedValue().toString().equals("Adeslas Madrid Open")){
				String lista1="SELECT idPartido, idGanador, idPerdedor, resultGanador, resultPerdedor, idFase, idTorneo from Partido where idTorneo=1";
				ArrayList<Partido> p= SelectData.seleccionarPartido(lista1);
				JList listaA = new JList();
				DefaultListModel <Partido> model1=new DefaultListModel <Partido>();
				for(Partido a:p){
					model1.addElement(a);
					listaA.setModel(model1);		
				}
				listaA.setBounds(34, 169, 406, 53);
				contentPane.add(listaA);
				JOptionPane.showMessageDialog(Torneos.this, listaA,"1",-1);
				

		
			}
			
		});
		contentPane.add(btnAceptar);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.setBounds(405, 414, 115, 29);
		btnVolver.addActionListener(e -> {
			MenuPrincipal pantalla=new MenuPrincipal();
			pantalla.setVisible(true);
			dispose();
		
		});
		contentPane.add(btnVolver);
		
		JLabel lblTorneos = new JLabel("Torneos");
		lblTorneos.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblTorneos.setBounds(56, 63, 174, 20);
		contentPane.add(lblTorneos);
		
	}

}
