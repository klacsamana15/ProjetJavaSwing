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

public class Equitation extends JFrame {

    JButton btnRetour, btnSoumettre;
    JComboBox parcoursCombo, nombreCombo;
    JRadioButton rbSemaine, rbFinSemaine;
    FormListener formListener;
    public static double tarifEquitation;

    Equitation() {

        //this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800, 600);
        this.setPreferredSize(new Dimension(800, 600));
        this.setResizable(false);
        this.setTitle("Équitation");
        this.setBackground(Color.lightGray);

        this.setLayout(null);
        this.setLocationRelativeTo(null);

        ImageIcon horse = new ImageIcon("resources/horse.jpg");
        JLabel image = new JLabel();
        image.setIcon(horse);
        image.setSize(200, 200);
        image.setBounds(0, 0, 200, 200);
        add(image);

        JLabel lblTarif = new JLabel("Tarif pour l'équitation");
        lblTarif.setFont(new Font("Arial", Font.ITALIC, 40));
        lblTarif.setForeground(Color.RED);
        lblTarif.setBounds(260, 0, 400, 100);
        add(lblTarif);

        JLabel lblInfo = new JLabel("Tarif pour l'équitation Été 2022");
        lblInfo.setForeground(Color.BLUE);
        lblInfo.setFont(new Font("Arial", Font.BOLD, 22));

        lblInfo.setBounds(300, 130, 400, 50);
        add(lblInfo);

        JLabel lblParcours = new JLabel("Parcours choisi");
        lblParcours.setForeground(Color.BLUE);
        lblParcours.setFont(new Font("Arial", Font.BOLD, 22));
        lblParcours.setBounds(350, 345, 400, 50);
        add(lblParcours);

        JLabel lblPersonnes = new JLabel("Nombre de Personnes");
        lblPersonnes.setForeground(Color.BLUE);
        lblPersonnes.setFont(new Font("Arial", Font.BOLD, 22));
        lblPersonnes.setBounds(70, 345, 400, 50);
        add(lblPersonnes);

        JLabel lblPeriode = new JLabel("Période choisi");
        lblPeriode.setForeground(Color.BLUE);
        lblPeriode.setFont(new Font("Arial", Font.BOLD, 22));
        lblPeriode.setBounds(580, 345, 400, 50);
        add(lblPeriode);

        JLabel lblInfo2 = new JLabel("Par Personne:          Semaine        Fin de semaine");
        lblInfo2.setFont(new Font("Arial", Font.BOLD, 18));
        lblInfo2.setBounds(290, 180, 500, 50);
        add(lblInfo2);

        JLabel lblInfo3 = new JLabel("   Parcours 1 :              $15,25                 $18,25");
        lblInfo3.setFont(new Font("Arial", Font.BOLD, 18));
        lblInfo3.setBounds(280, 220, 500, 50);
        add(lblInfo3);

        JLabel lblInfo4 = new JLabel("   Parcours 2 :              $22,75                 $25,00");
        lblInfo4.setFont(new Font("Arial", Font.BOLD, 18));
        lblInfo4.setBounds(280, 250, 500, 50);
        add(lblInfo4);

        JLabel lblInfo5 = new JLabel("   Parcours 3 :              $25,25                 $27,75");
        lblInfo5.setFont(new Font("Arial", Font.BOLD, 18));
        lblInfo5.setBounds(280, 280, 500, 50);
        add(lblInfo5);

        btnRetour = new JButton("Retour");
        btnRetour.setSize(200, 50);
        btnRetour.setFont(new java.awt.Font("Arial", 1, 28));
        btnRetour.setPreferredSize(new Dimension(450, 50));
        btnRetour.setBounds(180, 500, 200, 50);
        add(btnRetour);

        btnSoumettre = new JButton("Soumettre");
        btnSoumettre.setSize(200, 50);
        btnSoumettre.setFont(new java.awt.Font("Arial", 1, 28));
        btnSoumettre.setPreferredSize(new Dimension(450, 50));
        btnSoumettre.setBounds(420, 500, 200, 50);
        add(btnSoumettre);

        parcoursCombo = new JComboBox();
        DefaultComboBoxModel modelCombo = new DefaultComboBoxModel();
        modelCombo.addElement("Parcours 1");
        modelCombo.addElement("Parcours 2");
        modelCombo.addElement("Parcours 3");
        parcoursCombo.setModel(modelCombo);
        parcoursCombo.setSelectedIndex(-1);
        parcoursCombo.setBounds(380, 400, 100, 30);
        add(parcoursCombo);

        nombreCombo = new JComboBox();
        DefaultComboBoxModel modelCombo1 = new DefaultComboBoxModel();
        modelCombo1.addElement("1 personne");
        modelCombo1.addElement("2 personnes");
        modelCombo1.addElement("3 personnes");
        modelCombo1.addElement("4 personnes");
        modelCombo1.addElement("5 personnes");
        modelCombo1.addElement("6 personnes");
        nombreCombo.setModel(modelCombo1);
        nombreCombo.setSelectedIndex(-1);
        nombreCombo.setBounds(130, 400, 100, 30);
        add(nombreCombo);

        JRadioButton rbSemaine = new JRadioButton("Jour de semaine");
        rbSemaine.setBounds(580, 390, 300, 30);
        add(rbSemaine);

        JRadioButton rbFinSemaine = new JRadioButton("Fin de semaine ou férié");
        rbFinSemaine.setBounds(580, 420, 300, 30);
        add(rbFinSemaine);

        ButtonGroup groupe = new ButtonGroup();
        groupe.add(rbFinSemaine);
        groupe.add(rbSemaine);

        btnRetour.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == btnRetour) {
                    dispose();
                }
            }
        });

        btnSoumettre.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int nbPersonnes = (nombreCombo.getSelectedIndex() + 1);
                int choix = (parcoursCombo.getSelectedIndex() + 1);

                if (nombreCombo.getSelectedIndex() == -1 || parcoursCombo.getSelectedIndex() == -1 || (!rbSemaine.isSelected() && !rbFinSemaine.isSelected())) {
                    JOptionPane.showMessageDialog(null, "Erreur, il manque au moins une sélection!", "Avertissement", JOptionPane.WARNING_MESSAGE);
                } else {
                    if (parcoursCombo.getSelectedIndex() == 0 && rbSemaine.isSelected()) {
                        tarifEquitation = 15.25 * nbPersonnes;
                    }
                    else if (parcoursCombo.getSelectedIndex() == 0 && rbFinSemaine.isSelected()) {
                        tarifEquitation = 18.25 * nbPersonnes;
                    }
                    else if (parcoursCombo.getSelectedIndex() == 1 && rbSemaine.isSelected()) {
                        tarifEquitation = 22.75 * nbPersonnes;
                    }
                    else if (parcoursCombo.getSelectedIndex() == 1 && rbFinSemaine.isSelected()) {
                        tarifEquitation = 25 * nbPersonnes;
                    }
                    else if (parcoursCombo.getSelectedIndex() == 2 && rbSemaine.isSelected()) {
                        tarifEquitation = 25.25 * nbPersonnes;
                    }
                    else if (parcoursCombo.getSelectedIndex() == 2 && rbFinSemaine.isSelected()) {
                        tarifEquitation = 27.75 * nbPersonnes;
                    }
                    JOptionPane.showMessageDialog(null, "Activité ajouté!", "Affirmation", JOptionPane.INFORMATION_MESSAGE);
                    dispose();
                }

            }
        }
        );

        this.setVisible(true);
        this.pack();
    }
}
