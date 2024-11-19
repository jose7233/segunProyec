package paneles;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Panel3 extends JFrame {
    private JButton privadoButton;
    private JButton publicoButton;
    private JPanel panel3;

    public Panel3() {
        super("Panel 3");
        setContentPane(panel3);
        setSize(400,400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        privadoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Panel1().setVisible(true);
                dispose();
            }
        });
        publicoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Panel2().setVisible(true);
                dispose();
            }
        });
    }
}
