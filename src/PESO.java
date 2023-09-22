import java.awt.Color;

import java.awt.EventQueue;



import javax.swing.JFrame;

import javax.swing.JLabel;

import javax.swing.JTextField;

import javax.swing.JButton;

import javax.swing.SwingConstants;

import java.awt.Toolkit;

import javax.swing.ImageIcon;

import java.awt.event.ActionListener;

import java.text.DecimalFormat;

import java.awt.event.ActionEvent;



public class PESO {



	private JFrame frmImc;

	private JTextField txtPeso;

	private JTextField txtAltura;

	private JLabel lblIMC;

	private JLabel lblStatus;



	/**

	 * Launch the application.

	 */

	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {

			public void run() {

				try {

					PESO window = new PESO();

					window.frmImc.setVisible(true);

				} catch (Exception e) {

					e.printStackTrace();

				}

			}

		});

	}



	/**

	 * Create the application.

	 */

	public PESO() {

		initialize();

	}



	/**

	 * Initialize the contents of the frame.

	 */

	private void initialize() {

		frmImc = new JFrame();

		frmImc.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Alumno.EQUIPO42\\Pictures\\IMC.jpeg"));

		frmImc.setTitle("IMC");

		frmImc.setBounds(100, 100, 642, 365);

		frmImc.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frmImc.getContentPane().setLayout(null);

		

		JLabel lblpeso = new JLabel("PESO(kg)");

		lblpeso.setBounds(25, 30, 66, 21);

		frmImc.getContentPane().add(lblpeso);

		

		JLabel lblaltura = new JLabel("ALTURA(m)");

		lblaltura.setBounds(25, 67, 66, 21);

		frmImc.getContentPane().add(lblaltura);

		

		txtPeso = new JTextField();

		txtPeso.setBounds(88, 30, 86, 20);

		frmImc.getContentPane().add(txtPeso);

		txtPeso.setColumns(10);

		

		txtAltura = new JTextField();

		txtAltura.setColumns(10);

		txtAltura.setBounds(88, 67, 86, 20);

		frmImc.getContentPane().add(txtAltura);

		

		JButton btncalcular = new JButton("CALCULAR");

		btncalcular.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				try {

					double peso=Double.parseDouble(txtPeso.getText());

					double Altura=Double.parseDouble(txtAltura.getText());

					CalcularIMC(peso,Altura);

				}catch (Exception e1) {

					

				}

			}

		});

		btncalcular.setBounds(10, 122, 89, 23);

		frmImc.getContentPane().add(btncalcular);

		

		JButton btnborrar = new JButton("BORRAR");

		btnborrar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				txtPeso.setText("");

				txtAltura.setText("");

				lblIMC.setText("");

				lblStatus.setText("");





			}

		});

		btnborrar.setBounds(137, 122, 89, 23);

		frmImc.getContentPane().add(btnborrar);

		

		lblIMC = new JLabel("IMC:");

		lblIMC.setOpaque(true);

		lblIMC.setHorizontalAlignment(SwingConstants.CENTER);

		lblIMC.setHorizontalTextPosition(SwingConstants.CENTER);

		lblIMC.setBounds(25, 171, 205, 34);

		frmImc.getContentPane().add(lblIMC);

		

		lblStatus = new JLabel("STATUS:");

		lblStatus.setOpaque(true);

		lblStatus.setHorizontalTextPosition(SwingConstants.CENTER);

		lblStatus.setHorizontalAlignment(SwingConstants.CENTER);

		lblStatus.setBounds(21, 223, 205, 34);

		frmImc.getContentPane().add(lblStatus);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(406, 146, 46, 14);
		frmImc.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\Alumno\\Desktop\\descarga.png"));
		lblNewLabel_1.setBounds(294, 11, 306, 304);
		frmImc.getContentPane().add(lblNewLabel_1);

	}

	public void CalcularIMC (double peso,double Altura) {

		double imc= peso/(Altura*Altura);

		DecimalFormat df = new DecimalFormat("#.00");

		lblIMC.setText("IMC: "+df.format(imc));

		if(imc<18.5) {

			lblStatus.setText("bajo peso");

			lblStatus.setBackground( new Color(0, 162, 232));

			lblIMC.setBackground( new Color(0, 162, 232));

		}else if (imc>=18.5 && imc<25) {

			lblStatus.setText("peso normal");

			lblStatus.setBackground( new Color(181, 230, 29));

			lblIMC.setBackground( new Color(181, 230, 29));

		}else if (imc>=25 && imc<30) {

			lblStatus.setText("sobre peso");

			lblStatus.setBackground( new Color(234,197,82));

			lblIMC.setBackground( new Color(234,197,82));

		}else if (imc>=30 && imc<35) {

			lblStatus.setText("obesidad 1");

			lblStatus.setBackground( new Color(231,230,29));

			lblIMC.setBackground( new Color(231,230,29));

		}else if (imc>=35 && imc<40) {

			lblStatus.setText("obesidad 2");

			lblStatus.setBackground( new Color(181,230,29));

			lblIMC.setBackground( new Color(181,230,29));

		}else

			lblStatus.setText("obesidad 3");

			lblStatus.setBackground( new Color(225,8,19));

			lblIMC.setBackground( new Color(225,8,19));

	}
}
