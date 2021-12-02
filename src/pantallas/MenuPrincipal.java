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
import javax.swing.JLabel;
import javax.swing.JTextPane;
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
		setBounds(100, 100, 688, 454);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JList list = new JList();
		list.setBounds(15, 96, 106, 84);
		contentPane.add(list);
		
		
		DefaultListModel<String>model=new DefaultListModel<String>();
		String a=new String("Noticias");
		String b=new String("Jugadores");
		String c=new String("Clasificación");
		String d=new String("Torneos");
		String e=new String("Cartas");
		model.addElement(a);
		model.addElement(b);
		model.addElement(c);
		model.addElement(d);
		model.addElement(e);
		list.setModel(model);
		
		JLabel lblMen = new JLabel("MEN\u00DA");
		lblMen.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblMen.setBounds(25, 60, 80, 32);
		contentPane.add(lblMen);
		
		JLabel lblNoticias = new JLabel("NOTICIAS");
		lblNoticias.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNoticias.setBounds(493, 67, 124, 20);
		contentPane.add(lblNoticias);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(462, 98, 177, 249);
		contentPane.add(textPane);
		
		JLabel lblPrximosTorneos = new JLabel("PR\u00D3XIMOS TORNEOS");
		lblPrximosTorneos.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblPrximosTorneos.setBounds(25, 218, 221, 20);
		contentPane.add(lblPrximosTorneos);
		
		JList list_1 = new JList();
		list_1.setBounds(45, 254, 192, 84);
		contentPane.add(list_1);
		
		
	}
}
