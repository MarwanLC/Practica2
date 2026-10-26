package vista;

import modelo.Cliente;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;

public class Practica2 extends JFrame
{
    ArrayList <Cliente> listaClientes = new ArrayList<>(3); 
    
    private int posicionActual = 0;
    private void mostrarCliente(){
        
        Cliente clientes = listaClientes.get(posicionActual);
        
        numeroField.setText(String.valueOf(clientes.getNumero()));
        nombreField.setText((clientes.getNombre()));
        edadField.setText(String.valueOf(clientes.getEdad()));
        puntosField.setText(String.valueOf(clientes.getPuntos()));
        
    }
    
    private void actualizarBotones(){
        atrasButton.setEnabled(posicionActual > 0);
        adelanteButton.setEnabled(posicionActual < listaClientes.size() -1);
    }
    
    //Etiquetas para identificar los campos de texto
    private JLabel numeroLabel;
    private JLabel nombreLabel;
    private JLabel edadLabel;
    private JLabel puntosLabel;

//    //Cadenas para las etiquetas
//    private static String numeroString = "Número: ";
//    private static String dobleString = "El doble es: ";

    //Text fields para introducir números (ahora son de Swing: JTextField)
    private JTextField numeroField;
    private JTextField nombreField;
    private JTextField edadField;
    private JTextField puntosField;
    
    private JButton atrasButton;
    private JButton adelanteButton;

    public Practica2() {
        super("Datos");
        
        listaClientes.add(new Cliente(10, "Pepe", 24, 40.5));
        listaClientes.add(new Cliente(11, "Paco", 23, 4.5));
        listaClientes.add(new Cliente(12, "Pedro", 50, 2.14));

        //Lo que pasa si cerramos la ventana (sustituye al WindowListener
        //con windowClosing y System.exit(0) de la versión anterior).
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Crea las etiquetas.
        numeroLabel = new JLabel("Numero");
        nombreLabel = new JLabel("Nombre");
        edadLabel = new JLabel("Edad");
        puntosLabel = new JLabel("Puntos");

        //Campo donde vamos a introducir el número
        numeroField = new JTextField(10);
        numeroField.setEditable(false);

        //Campo que nos muestra el doble del numero introducido
        nombreField = new JTextField(10);
        nombreField.setEditable(false);
        nombreField.setForeground(Color.red);
        
        edadField = new JTextField(10);
        edadField.setEditable(false);
        edadField.setForeground(Color.blue);
        
        puntosField = new JTextField(10);
        puntosField.setEditable(false);
        puntosField.setForeground(Color.green);
        
        atrasButton = new JButton("Atras");
        atrasButton.addActionListener(new ActionListener() {  // Evento de boton.
            public void actionPerformed(ActionEvent e) {
                System.out.println("atras");
                if(posicionActual > 0){
                    posicionActual--;
                    mostrarCliente();
                    actualizarBotones();
                }
            }
        });
        
        adelanteButton = new JButton("Siguiente");
        adelanteButton.addActionListener(new ActionListener() {  // Evento de boton.
            public void actionPerformed(ActionEvent e) {
                System.out.println("siguiente");
                if(posicionActual < listaClientes.size()-1){
                    posicionActual++;
                    mostrarCliente();
                    actualizarBotones();
                }
                    
            }
        });

        //Dispone la geometría de las etiquetas en un panel
        JPanel labelPane = new JPanel();
        labelPane.setLayout(new GridLayout(0, 1));
        labelPane.add(numeroLabel);
        labelPane.add(nombreLabel);
        labelPane.add(edadLabel);
        labelPane.add(puntosLabel);

        //Dispone los campos de texto en otro panel
        JPanel fieldPane = new JPanel();
        fieldPane.setLayout(new GridLayout(0, 1));
        fieldPane.add(numeroField);
        fieldPane.add(nombreField);
        fieldPane.add(edadField);
        fieldPane.add(puntosField);
        
        JPanel buttonPane = new JPanel();
        buttonPane.setLayout(new GridLayout(1, 0));
        buttonPane.add(atrasButton);
        buttonPane.add(adelanteButton);

        //Incluye los dos paneles en otro panel,
        //etiquetas a la izquierda
        //y campos de texto a la derecha.
        JPanel contentPane = new JPanel();
        contentPane.setBorder(
               BorderFactory.createEmptyBorder(20, 20, 20, 20));
        contentPane.setLayout(new BorderLayout());
        contentPane.add(labelPane, BorderLayout.CENTER);
        contentPane.add(fieldPane, BorderLayout.EAST);
        contentPane.add(buttonPane, BorderLayout.SOUTH);
        setContentPane(contentPane);  //this.setContentPane(contentPane);
          // es set, o sea, machado el contenedor del objeto "Doble", hijo de JFrame
        mostrarCliente();
        actualizarBotones();
    }

    public static void main(String[] args) {

        // Toda la interfaz Swing se crea en el hilo de eventos (receta: se hace siempre así).
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                final Practica2 app = new Practica2();

                //Este WindowListener ya solo sirve para poner el foco.
                //(Para cerrar la ventana ya no hace falta: setDefaultCloseOperation.)
                app.pack();
                app.setVisible(true);
            }
        });
    }

}
