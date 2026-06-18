package vista;

import dao.DerivadaDAO;
import logica.CalculadoraDerivadas;
import modelo.Derivada;

import javax.swing.*;
import java.awt.*;

public class FrmPrincipal extends JFrame {

    private JTextField txtFuncion;
    private JTextField txtDerivada;
    private JButton btnCalcular;
    private JButton btnLimpiar;
    private JButton btnSalir;

    public FrmPrincipal() {

        setTitle("Factorización de Derivadas");
        setSize(500, 220);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel panel = new JPanel(new GridLayout(3, 2, 5, 5));

        panel.add(new JLabel("Función:"));
        txtFuncion = new JTextField();
        panel.add(txtFuncion);

        panel.add(new JLabel("Resultado:"));
        txtDerivada = new JTextField();
        txtDerivada.setEditable(false);
        panel.add(txtDerivada);

        btnCalcular = new JButton("Calcular");
        btnLimpiar = new JButton("Limpiar");

        panel.add(btnCalcular);
        panel.add(btnLimpiar);

        add(panel, BorderLayout.CENTER);

        btnSalir = new JButton("Salir");
        add(btnSalir, BorderLayout.SOUTH);

        btnCalcular.addActionListener(e -> calcular());

        btnLimpiar.addActionListener(e -> {
            txtFuncion.setText("");
            txtDerivada.setText("");
            txtFuncion.requestFocus();
        });

        btnSalir.addActionListener(e -> System.exit(0));
    }

    private void calcular() {

        String funcion = txtFuncion.getText().trim();

        if (funcion.isEmpty()) {
            JOptionPane.showMessageDialog(
                    this,
                    "Ingrese una función.",
                    "Aviso",
                    JOptionPane.WARNING_MESSAGE
            );
            return;
        }

        CalculadoraDerivadas c = new CalculadoraDerivadas();

        String derivada = c.derivar(funcion);

        String factorizacion = c.factorizar(derivada);

        txtDerivada.setText(
                "Derivada: " + derivada +
                        "   |   Factorización: " + factorizacion
        );

        Derivada d = new Derivada();
        d.setFuncion(funcion);
        d.setDerivada(derivada);
        d.setFactorizacion(factorizacion);

        new DerivadaDAO().guardar(d);

        JOptionPane.showMessageDialog(
                this,
                "Información guardada correctamente."
        );
    }
}