package vista;

import dao.DerivadaDAO;
import logica.CalculadoraDerivadas;
import modelo.Derivada;

import javax.swing.*;
import java.awt.*;

public class FrmPrincipal extends JFrame {

    private JTextField txtFuncion;
    private JTextArea txtResultado;

    private JButton btnDerivar;
    private JButton btnGuardar;
    private JButton btnLimpiar;
    private JButton btnSalir;

    private CalculadoraDerivadas calculadora;
    private DerivadaDAO dao;

    public FrmPrincipal() {

        calculadora = new CalculadoraDerivadas();
        dao = new DerivadaDAO();

        inicializarComponentes();
        eventos();
    }

    private void inicializarComponentes() {

        setTitle("Factorización de Derivadas");
        setSize(700, 350);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10,10));

        JPanel panelSuperior = new JPanel(new BorderLayout(5,5));

        JLabel lblFuncion = new JLabel("Función:");

        txtFuncion = new JTextField();

        panelSuperior.add(lblFuncion, BorderLayout.WEST);
        panelSuperior.add(txtFuncion, BorderLayout.CENTER);

        add(panelSuperior, BorderLayout.NORTH);

        txtResultado = new JTextArea();
        txtResultado.setEditable(false);
        txtResultado.setFont(new Font("Monospaced", Font.PLAIN, 14));

        JScrollPane scroll = new JScrollPane(txtResultado);

        add(scroll, BorderLayout.CENTER);

        JPanel panelBotones = new JPanel(new FlowLayout());

        btnDerivar = new JButton("Derivar");
        btnGuardar = new JButton("Guardar");
        btnLimpiar = new JButton("Limpiar");
        btnSalir = new JButton("Salir");

        panelBotones.add(btnDerivar);
        panelBotones.add(btnGuardar);
        panelBotones.add(btnLimpiar);
        panelBotones.add(btnSalir);

        add(panelBotones, BorderLayout.SOUTH);
    }

    private void eventos() {

        btnDerivar.addActionListener(e -> calcular());

        btnGuardar.addActionListener(e -> guardar());

        btnLimpiar.addActionListener(e -> limpiar());

        btnSalir.addActionListener(e -> System.exit(0));

    }

    private void calcular() {

        String funcion = txtFuncion.getText().trim();

        if (funcion.isEmpty()) {

            JOptionPane.showMessageDialog(
                    this,
                    "Ingrese una función.",
                    "Aviso",
                    JOptionPane.WARNING_MESSAGE);

            txtFuncion.requestFocus();
            return;
        }

        String derivada = calculadora.derivar(funcion);

        String factorizacion = calculadora.factorizar(derivada);

        txtResultado.setText("");

        txtResultado.append("FUNCIÓN\n");
        txtResultado.append("---------------------------------------------\n");
        txtResultado.append(funcion + "\n\n");

        txtResultado.append("DERIVADA\n");
        txtResultado.append("---------------------------------------------\n");
        txtResultado.append(derivada + "\n\n");

        txtResultado.append("FACTORIZACIÓN\n");
        txtResultado.append("---------------------------------------------\n");
        txtResultado.append(factorizacion);
    }

    private void guardar() {

        String funcion = txtFuncion.getText().trim();

        if (funcion.isEmpty()) {

            JOptionPane.showMessageDialog(
                    this,
                    "Primero calcule una derivada.");

            return;
        }

        String derivada = calculadora.derivar(funcion);

        String factorizacion = calculadora.factorizar(derivada);

        Derivada d = new Derivada();

        d.setFuncion(funcion);
        d.setDerivada(derivada);
        d.setFactorizacion(factorizacion);

        if (dao.guardar(d)) {

            JOptionPane.showMessageDialog(
                    this,
                    "Registro almacenado correctamente.");

        } else {

            JOptionPane.showMessageDialog(
                    this,
                    "No fue posible guardar la información.");

        }

    }

    private void limpiar() {

        txtFuncion.setText("");
        txtResultado.setText("");
        txtFuncion.requestFocus();

    }
}