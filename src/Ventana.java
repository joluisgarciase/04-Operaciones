import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 * 
 * @author Luis Garcia
 * @version 1.0
 * Clase donde se crea la ventana de la calculadora
 *
 */
public class Ventana extends JFrame implements ActionListener{
	private JTextField txtN1= new JTextField();
	private JTextField txtN2= new JTextField();
	
	private JLabel lbN1= new JLabel("Numero 1:");
	private JLabel lbN2= new JLabel("Numero 2:");
	private JLabel lbResultado= new JLabel("El resultado es:");
	
	private JButton btnSuma= new JButton("+");
	private JButton btnResta= new JButton("-");
	private JButton btnMultiplicacion= new JButton("*");
	private JButton btnDivision= new JButton("/");
	
	private Container c = getContentPane();
	
	private Operaciones op = new Operaciones();

	public Ventana(){
		super.setTitle("Operaciones");
		super.setSize(320, 480);
		super.setDefaultCloseOperation(EXIT_ON_CLOSE);
		cargarControles();
	}
	
	private void cargarControles() {
		c.setLayout(null);
		lbN1.setBounds(10,10, 280, 30);
		txtN1.setBounds(10, 40, 280, 30);

		lbN2.setBounds(10,80, 280, 30);
		txtN2.setBounds(10, 120, 280, 30);

		btnSuma.setBounds(10, 160, 70, 30);
		btnResta.setBounds(80, 160, 70, 30);
		btnMultiplicacion.setBounds(160, 160, 70, 30);
		btnDivision.setBounds(230, 160, 70, 30);
		lbResultado.setBounds(10,200, 280,30);
		
		c.add(lbN1);
		c.add(txtN1);
		c.add(lbN2);
		c.add(txtN2);
		c.add(btnSuma);
		c.add(btnResta);
		c.add(btnMultiplicacion);
		c.add(btnDivision);
		c.add(lbResultado);
		
		btnSuma.addActionListener(this);
		btnResta.addActionListener(this);
		btnMultiplicacion.addActionListener(this);
		btnDivision.addActionListener(this);
	}

	/**
	 * 
	 * @param e
	 */
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object boton = e.getSource();
		if(boton==btnSuma){
			int r = op.sumar(Integer.parseInt(txtN1.getText()), Integer.parseInt(txtN2.getText()));
			lbResultado.setText(String.format("%s + %s = %d", txtN1.getText(), txtN2.getText(), r));
		}
		if(boton==btnResta){
			int s = op.restar(Integer.parseInt(txtN1.getText()), Integer.parseInt(txtN2.getText()));
			lbResultado.setText(String.format("%s - %s = %d", txtN1.getText(), txtN2.getText(), s));
		}
		if(boton==btnMultiplicacion){
			int t = op.multiplicar(Integer.parseInt(txtN1.getText()), Integer.parseInt(txtN2.getText()));
			lbResultado.setText(String.format("%s * %s = %d", txtN1.getText(), txtN2.getText(), t));
		}
		if(boton==btnDivision){
			int u = op.dividir(Integer.parseInt(txtN1.getText()), Integer.parseInt(txtN2.getText()));
			lbResultado.setText(String.format("%s / %s = %d", txtN1.getText(), txtN2.getText(), u));
		}	
	}
	
	
}
