package triangulo;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.UIManager;

public class Interfaz {

	private JFrame frame;
	private JTextField lado1;
	private JTextField lado2;
	private JTextField lado3;
	private JLabel lblLado_2;
	private JTextField resultado;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Throwable e) {
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Interfaz window = new Interfaz();
					window.frame.setTitle("Triangulos");
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Interfaz() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 277, 187);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblLado = new JLabel("Lado 1");
		lblLado.setBounds(10, 11, 46, 14);
		frame.getContentPane().add(lblLado);

		lado1 = new JTextField();

		lado1.setBounds(66, 8, 185, 20);
		frame.getContentPane().add(lado1);
		lado1.setColumns(10);

		lado2 = new JTextField();
		lado2.setColumns(10);
		lado2.setBounds(66, 36, 185, 20);
		frame.getContentPane().add(lado2);

		JLabel lblLado_1 = new JLabel("Lado 2");
		lblLado_1.setBounds(10, 39, 46, 14);
		frame.getContentPane().add(lblLado_1);

		lado3 = new JTextField();
		lado3.setColumns(10);
		lado3.setBounds(66, 64, 185, 20);
		frame.getContentPane().add(lado3);

		lblLado_2 = new JLabel("Lado 3");
		lblLado_2.setBounds(10, 67, 46, 14);
		frame.getContentPane().add(lblLado_2);

		resultado = new JTextField();
		resultado.setEditable(false);
		resultado.setBounds(10, 93, 241, 44);
		frame.getContentPane().add(resultado);
		resultado.setColumns(10);

		KeyAdapter keyAdapter = new KeyAdapter() {
			public void keyReleased(KeyEvent arg0) {
				try {
					resultado.setText("");
					resultado.setText(new Triangulo(lado1.getText(), lado2.getText(), lado3.getText()).print());
				} catch (Exception e) {
				}
			}
		};
		lado1.addKeyListener(keyAdapter);
		lado2.addKeyListener(keyAdapter);
		lado3.addKeyListener(keyAdapter);
	}
}
