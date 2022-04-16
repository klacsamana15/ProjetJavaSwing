// Auteurs: Kriza Lacsamana et Sylvain Pouliot; Gr.427
package projetfinal;

import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class IntroPanel extends JPanel {

    JLabel lblCamping, lblLine;
    JPanel panelPrix;
    JLabel lblFrais, lblPersonne1, lblPersonne2, lblPersonne3, lblPersonne4;

    IntroPanel() {
        setLayout(null);

        
        lblCamping = new JLabel("LE CAMPING DE TANTE IRMA");
        lblCamping.setForeground(Color.RED);
        lblCamping.setFont(new Font("Arial", Font.BOLD, 30));
        lblCamping.setBounds(0, 0, 500, 80);
        add(lblCamping);
        
        lblLine = new JLabel("__________________________");
        lblLine.setForeground(Color.RED);
        lblLine.setFont(new Font("Arial", Font.BOLD, 30));
        lblLine.setBounds(0, 5, 500, 80);
        add(lblLine);

        ImageIcon imageCamping = new ImageIcon("resources/camping.png");
        JLabel image = new JLabel();
        image.setIcon(imageCamping);
        image.setBounds(0, 70, 200, 200);
        add(image);
        
        ///////////////////////////////////////////////
        
        panelPrix = new JPanel();
        //panelPrix.setBackground(Color.WHITE);
        panelPrix.setLayout(null);
        panelPrix.setBounds(250, 100, 200, 120);
        
        lblFrais = new JLabel("Frais de séjour:");
        lblFrais.setForeground(Color.BLUE);
        lblFrais.setFont(new Font("Arial", Font.PLAIN, 20));
        lblFrais.setBounds(0, 0, 200, 50);
        panelPrix.add(lblFrais);
        
        lblPersonne1 = new JLabel("Personne 1: 23.25$/jour");
        lblPersonne1.setBounds(0, 0, 200, 110);
        panelPrix.add(lblPersonne1);
        
        lblPersonne2 = new JLabel("Personne 2: 20.90$/jour");
        lblPersonne2.setBounds(0, 0, 200, 140);
        panelPrix.add(lblPersonne2);
        
        lblPersonne3 = new JLabel("Personne 3: 18.25$/jour");
        lblPersonne3.setBounds(0, 0, 200, 170);
        panelPrix.add(lblPersonne3);
        
        lblPersonne4 = new JLabel("Personne 4 et plus: 16.25$/jour");
        lblPersonne4.setBounds(0, 0, 200, 200);
        panelPrix.add(lblPersonne4);
        
        add(panelPrix);
        
        
    }
}
