package compañiasPri;
import javax.swing.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static prueba.conexion.conectar;

public class Panel4 extends JFrame {
    private JPanel panel4;
    private JList<String> list1;
    private DefaultListModel<String> listModel;

    public Panel4() {
        listModel = new DefaultListModel<>();
        list1.setModel(listModel);

        leerDato(0);

        add(panel4);
        setTitle("Panel4");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void leerDato(int offset) {
        String query = "SELECT idCompania, nombre FROM companias ORDER BY idCompania LIMIT 2 OFFSET " + offset;
        try {
            Connection con = conectar();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                String row = rs.getString("idCompania") + "." + " " +
                        rs.getString("nombre");
                listModel.addElement(row);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
