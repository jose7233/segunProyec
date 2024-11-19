package paneles;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static prueba.conexion.conectar;

public class Panel2 extends JFrame {
    private JPanel panel2;
    private JList<String> list1;
    private JButton aceptarButton;
    private DefaultListModel<String> listModel;
    private JLabel label1;
    private int contador = 0;

    public Panel2() {

        listModel = new DefaultListModel<>();
        list1.setModel(listModel);

        leerDato();

        add(panel2);
        setTitle("Panel2");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        aceptarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                contador++;
                if (contador == 1) {
                    JOptionPane.showMessageDialog(Panel2.this, "Se ha seleccionado un elemento");
                } else if (contador == 2) {
                    int seleccion = list1.getSelectedIndex();
                    switch (seleccion) {
                        case 0:

                            break;
                        case 1:

                            break;
                        case 2:

                            break;
                        case 3:

                            break;
                        case 4:

                            break;
                        default:
                            JOptionPane.showMessageDialog(null, "No hay más paneles configurados.");
                            break;
                    }
                    contador = 0;
                    dispose();
                }
            }
        });
    }

    public void leerDato() {
        String query = "SELECT nombre, ciudad, pais FROM aeropuertos WHERE publico = 1 ";
        try {
            Connection con = conectar();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                String row =  rs.getString("nombre") + " " +
                        "(" + rs.getString("ciudad") + " " +
                        rs.getString("pais") + ")";
                listModel.addElement(row);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
