import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.FocusEvent;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.channels.UnsupportedAddressTypeException;

import javax.imageio.ImageIO;

public class Ventana extends JFrame {
    private JPanel panel;
    private JTextField email;
    private JPasswordField password;
    private BufferedImage fondo;
    private JTextArea alerta;

    public Ventana() {
        setSize(420, 650);
        setTitle("CHATBOT");
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        cargarFondo();  // Carga la imagen de fondo
    }
    private void cargarFondo() {
        try {
            fondo = ImageIO.read(new File("C:\\Users\\ALFONSO BARRENECHEA\\Desktop\\PROGRAMACIÓN ORIENTADA A OBJETOS - I\\semana 11\\CHATBOT\\img\\FonfoLogin.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void colocarPanel() {
        panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                if (fondo != null) {
                    g.drawImage(fondo, 0, 0, getWidth(), getHeight(), this);
                }
            }
        };
        panel.setLayout(null);
        this.getContentPane().add(panel);
        panel.setBorder(new LineBorder(Color.BLACK, 2));
    }
    private void colocarImagenes() {
        //Personita de login
        ImageIcon loginpersona = new ImageIcon("C:\\Users\\ALFONSO BARRENECHEA\\Desktop\\PROGRAMACIÓN ORIENTADA A OBJETOS - I\\semana 11\\CHATBOT\\img\\usser.png");
        JLabel persLog = new JLabel();
        persLog.setBounds(70, 320, 30,30);
        persLog.setIcon(new ImageIcon(loginpersona.getImage().getScaledInstance(persLog.getWidth(), persLog.getHeight(), Image.SCALE_SMOOTH)));
        panel.add(persLog);
        //Ojito de login
        ImageIcon logincontrasenia = new ImageIcon("C:\\Users\\ALFONSO BARRENECHEA\\Desktop\\PROGRAMACIÓN ORIENTADA A OBJETOS - I\\semana 11\\CHATBOT\\img\\contrasenia.png");
        JLabel contraLog = new JLabel();
        contraLog.setBounds(70, 380, 30,30);
        contraLog.setIcon(new ImageIcon(logincontrasenia.getImage().getScaledInstance(contraLog.getWidth(), contraLog.getHeight(), Image.SCALE_SMOOTH)));
        panel.add(contraLog);

    }
    private void colocarBotones() {
        JButton olvContra = new JButton("Olvide mi contraseña");
        olvContra.setBackground(new Color(0,0,0,0));
        olvContra.setOpaque(false);
        olvContra.setBounds(110, 440, 190, 30);
        olvContra.setFont(new Font("Arial Black", 1, 12));
        olvContra.setForeground(Color.white);
        olvContra.setBorder(null);
        panel.add(olvContra);

        JButton siguienteloging = new JButton("LOG IN");
        siguienteloging.setBounds(140, 480, 130, 30);
        siguienteloging.setBackground(new Color(0,0,0,0));
        siguienteloging.setFont(new Font("Arial Black", Font.BOLD, 18));
        siguienteloging.setOpaque(false);
        siguienteloging.setForeground(Color.ORANGE);
        siguienteloging.setBorder(null);
        panel.add(siguienteloging);


        ActionListener accion1 = new ActionListener(){ 
            @Override
            public void actionPerformed(ActionEvent ae) {   
                alerta = new JTextArea();
                alerta.setBounds(100, 290, 250, 90);
                alerta.setFont(new Font("Arial", 2, 25));
                alerta.setForeground(Color.BLACK);
                alerta.setBorder(new LineBorder(Color.BLACK, 3));
                alerta.setBackground(Color.CYAN);
                String correo = email.getText().toLowerCase();
                char [] contrasenia = password.getPassword();
                String contraseña = new String(contrasenia);
                if (correo.equals("omar.morales") && contraseña.equals("123")) {
                    alerta.setText("Bienvenido: \n" + email.getText());
                } else {
                    alerta.setText("ALGO ANDA MAL ");
                }
                panel.add(alerta);
            }   
        };
        
        siguienteloging.addActionListener(accion1);
        
    }
    private void colocarCajatexto(){
        //Texto de correo
        Border infNegro = new MatteBorder(0, 0, 2, 0, Color.BLACK);
        email = new JTextField("E-MAIL: ");
        email.setBounds(130, 320, 200, 30);
        email.setForeground(Color.WHITE);
        email.setFont(new Font("Arial Black", 1, 13));
        email.setOpaque(false);
        email.setBorder(infNegro);
       // email.setCaretColor(Color.CYAN);
        panel.add(email);
        
        //Texto de contrasenia
        password = new JPasswordField("CONTRASEÑA: ");
        password.setBounds(130,380,200,30);
        password.setFont(new Font("Arial Black", 1 , 13));
        password.setOpaque(false);
        //password.setBackground(new Color(7, 37, 109));
        password.setBorder(infNegro);
        password.setForeground(Color.WHITE);
        password.setEditable(true);
        password.setCaretColor(Color.BLACK);
        panel.add(password);
    }
    public void login() {
        colocarPanel();
        colocarImagenes();
        colocarBotones();
        colocarCajatexto();
    }
}