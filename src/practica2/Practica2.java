package practica2;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class Practica2 extends JFrame
{

    //Etiquetas para identificar los campos de texto
    private JLabel numeroLabel;
    private JLabel nombreLabel;
    private JLabel edadLabel;

//    //Cadenas para las etiquetas
//    private static String numeroString = "Número: ";
//    private static String dobleString = "El doble es: ";

    //Text fields para introducir números (ahora son de Swing: JTextField)
    private JTextField numeroField;
    private JTextField nombreField;
    private JTextField edadField;
    
    private JButton atrasButton;
    private JButton adelanteButton;

    public Practica2() {
        super("Datos");

        //Lo que pasa si cerramos la ventana (sustituye al WindowListener
        //con windowClosing y System.exit(0) de la versión anterior).
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Crea las etiquetas.
        numeroLabel = new JLabel("Numero");
        nombreLabel = new JLabel("Nombre");
        edadLabel = new JLabel("Edad");

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
        
        atrasButton = new JButton("Atras");
        atrasButton.addActionListener(new ActionListener() {  // Evento de boton.
            public void actionPerformed(ActionEvent e) {
                System.out.println("atras");
            }
        });
        
        adelanteButton = new JButton("Siguiente");
        adelanteButton.addActionListener(new ActionListener() {  // Evento de boton.
            public void actionPerformed(ActionEvent e) {
                System.out.println("siguiente");
            }
        });

        //Dispone la geometría de las etiquetas en un panel
        JPanel labelPane = new JPanel();
        labelPane.setLayout(new GridLayout(0, 1));
        labelPane.add(numeroLabel);
        labelPane.add(nombreLabel);
        labelPane.add(edadLabel);

        //Dispone los campos de texto en otro panel
        JPanel fieldPane = new JPanel();
        fieldPane.setLayout(new GridLayout(0, 1));
        fieldPane.add(numeroField);
        fieldPane.add(nombreField);
        fieldPane.add(edadField);
        
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
