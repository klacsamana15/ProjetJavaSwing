// Auteurs: Kriza Lacsamana et Sylvain Pouliot; Gr.427
package projetfinal;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

public class Canot extends JFrame {

    public static double tarifCanot;
    JButton retour, soumettre;
    JRadioButton rbSemaine, rbFinSemaine;
    JComboBox blocCombo;

    Canot() {

        //this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800, 600);
        this.setPreferredSize(new Dimension(800, 600));
        this.setResizable(false);
        this.setTitle("Canot");
        this.setBackground(Color.lightGray);

        this.setLayout(null);
        this.setLocationRelativeTo(null);

        ImageIcon canot = new ImageIcon("resources/canot.jpg");
        JLabel image = new JLabel();
        image.setIcon(canot);
        image.setSize(200, 200);
        image.setBounds(0, 0, 200, 200);
        add(image);

        JLabel lblTarif = new JLabel("Tarif pour le canot");
        lblTarif.setFont(new Font("Arial", Font.ITALIC, 40));
        lblTarif.setForeground(Color.RED);
        lblTarif.setBounds(280, 0, 400, 100);
        add(lblTarif);

        JLabel lblInfo = new JLabel("Tarifs pour le canot Été 2022");
        lblInfo.setForeground(Color.BLUE);
        lblInfo.setFont(new Font("Arial", Font.BOLD, 22));
        lblInfo.setBounds(310, 130, 400, 50);
        add(lblInfo);

        JLabel lblInfo1 = new JLabel("Les réservations se font par blocs de 2 heures");
        lblInfo1.setForeground(Color.BLUE);
        lblInfo1.setFont(new Font("Arial", Font.ITALIC, 16));
        lblInfo1.setBounds(290, 160, 400, 50);
        add(lblInfo1);

        JLabel lblInfo2 = new JLabel("Pour une embarcation            Semaine        Fin de semaine");
        lblInfo2.setFont(new Font("Arial", Font.BOLD, 18));
        lblInfo2.setBounds(240, 220, 600, 50);
        add(lblInfo2);

        JLabel lblInfo3 = new JLabel("Par bloc de 2 heures :              $15,25                 $18,25");
        lblInfo3.setFont(new Font("Arial", Font.BOLD, 18));
        lblInfo3.setBounds(240, 250, 500, 50);
        add(lblInfo3);

        JLabel lblBlocs = new JLabel("Nombre de blocs de 2 hr");
        lblBlocs.setForeground(Color.BLUE);
        lblBlocs.setFont(new Font("Arial", Font.BOLD, 22));
        lblBlocs.setBounds(240, 345, 400, 50);
        add(lblBlocs);

        blocCombo = new JComboBox();
        DefaultComboBoxModel modelCombo2 = new DefaultComboBoxModel();
        modelCombo2.addElement("1   bloc de 2hr");
        modelCombo2.addElement("2   blocs de 2hr");
        modelCombo2.addElement("3   blocs de 2hr");
        modelCombo2.addElement("4   blocs de 2hr");
        modelCombo2.addElement("5   blocs de 2hr");
        modelCombo2.addElement("6   blocs de 2hr");
        blocCombo.setModel(modelCombo2);
        blocCombo.setSelectedIndex(-1);
        blocCombo.setBounds(320, 400, 100, 30);
        add(blocCombo);

        JRadioButton rbSemaine = new JRadioButton("Jour de semaine");
        rbSemaine.setBounds(480, 390, 300, 30);
        add(rbSemaine);

        JRadioButton rbFinSemaine = new JRadioButton("Fin de semaine ou férié");
        rbFinSemaine.setBounds(480, 420, 300, 30);
        add(rbFinSemaine);
        
        ButtonGroup groupe = new ButtonGroup();
        groupe.add(rbSemaine);
        groupe.add(rbFinSemaine);

        retour = new JButton("Retour");
        retour.setSize(200, 50);
        retour.setFont(new java.awt.Font("Arial", 1, 28));
        retour.setPreferredSize(new Dimension(450, 50));
        retour.setBounds(180, 500, 200, 50);
        add(retour);
        retour.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource() == retour) 
                    dispose();
            }   
        });

        soumettre = new JButton("Soumettre");
        soumettre.setSize(200, 50);
        soumettre.setFont(new java.awt.Font("Arial", 1, 28));
        soumettre.setPreferredSize(new Dimension(450, 50));
        soumettre.setBounds(420, 500, 200, 50);
        add(soumettre);
        soumettre.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int nbBloc = (blocCombo.getSelectedIndex() + 1);
                double jour;
                if (blocCombo.getSelectedIndex() == -1 || (!rbSemaine.isSelected() && !rbFinSemaine.isSelected())) {
                    JOptionPane.showMessageDialog(null, "Erreur, il manque au moins une sélection!", "Avertissement", JOptionPane.WARNING_MESSAGE);
                } else {
                    if (rbSemaine.isSelected()) {
                        jour = 15.25;
                    } else {
                        jour = 18.25;
                    }
                    tarifCanot = jour * nbBloc;

                    JOptionPane.showMessageDialog(null, "Activité ajouté!", "Affirmation", JOptionPane.INFORMATION_MESSAGE);
                    dispose();
                }
            }
        });

        this.setVisible(true);
        this.pack();
    }
}
