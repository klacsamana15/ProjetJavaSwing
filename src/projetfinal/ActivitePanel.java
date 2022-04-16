// Auteurs: Kriza Lacsamana et Sylvain Pouliot; Gr.427
package projetfinal;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ActivitePanel extends JPanel {

    JLabel lblActivite;
    JButton btnEquitation, btnCanot, btnEscalade;
    EscaladeFrame escaladeFrame;
    Equitation equitation;
    Canot canot;

    ActivitePanel() {

        setPreferredSize(new Dimension(200, 200));
        setLayout(null);
        //setBorder(BorderFactory.createLineBorder(Color.RED));

        //setBackground(Color.WHITE);
        lblActivite = new JLabel("Choisir une activité: ");
        lblActivite.setForeground(Color.BLUE);
        lblActivite.setFont(new Font("Arial", Font.PLAIN, 20));
        lblActivite.setBounds(140, 0, 200, 50);
        add(lblActivite);

        btnEquitation = new JButton("Équitation");
        btnEquitation.setBounds(40, 50, 100, 20);
        btnEquitation.setFocusable(false);
        add(btnEquitation);
        btnEquitation.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource() == btnEquitation)
                    equitation = new Equitation();
            }
        } );
        

        btnCanot = new JButton("Canot");
        btnCanot.setBounds(170, 50, 100, 20);
        btnCanot.setFocusable(false);
        add(btnCanot);
        btnCanot.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource() == btnCanot)
                    canot = new Canot();
            }
        } );

        btnEscalade = new JButton("Escalade");
        btnEscalade.setBounds(300, 50, 100, 20);
        btnEscalade.setFocusable(false);
        add(btnEscalade);
        btnEscalade.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource() == btnEscalade) 
                    escaladeFrame = new EscaladeFrame();
            }   
        });

    }

}
