// Auteurs: Kriza Lacsamana et Sylvain Pouliot; Gr.427
package projetfinal;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class FormPanel extends JPanel {

    JLabel lblInfo, lblNom, lblNbJours, lblNbPersonnes;
    JTextField tfNom, tfNbJours;
    JComboBox cbNbPersonnes;
    JButton btnTarif;
    FormListener formListener;
    public static double tarifSejour;

    FormPanel() {

        setLayout(null);
        setBorder(BorderFactory.createLineBorder(Color.ORANGE));

        lblInfo = new JLabel("Informations: ");
        lblInfo.setForeground(Color.BLUE);
        lblInfo.setFont(new Font("Arial", Font.PLAIN, 20));
        lblInfo.setBounds(170, 0, 200, 40);
        add(lblInfo);

        lblNom = new JLabel("Nom: ");
        lblNom.setBounds(60, 50, 50, 25);
        add(lblNom);
        tfNom = new JTextField(10);
        tfNom.setBounds(100, 50, 270, 25);
        add(tfNom);

        lblNbJours = new JLabel("Nb de jours: ");
        lblNbJours.setBounds(60, 80, 80, 25);
        add(lblNbJours);
        tfNbJours = new JTextField(10);
        tfNbJours.setBounds(140, 80, 35, 25);
        add(tfNbJours);

        lblNbPersonnes = new JLabel("Nb de personnes: ");
        lblNbPersonnes.setBounds(210, 80, 150, 25);
        add(lblNbPersonnes);
        String[] nbPersonnes = {"1", "2", "3", "4", "5", "6"};
        cbNbPersonnes = new JComboBox(nbPersonnes);
        cbNbPersonnes.setSelectedIndex(-1);
        cbNbPersonnes.setBackground(Color.WHITE);
        cbNbPersonnes.setFocusable(false);
        cbNbPersonnes.setBounds(320, 80, 50, 25);
        add(cbNbPersonnes);

        btnTarif = new JButton("Réserver");
        btnTarif.setBounds(170, 130, 100, 20);
        btnTarif.setFocusable(false);
        add(btnTarif);

        btnTarif.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (tfNom.getText().isEmpty() || tfNbJours.getText().isEmpty() || (cbNbPersonnes.getSelectedIndex() == -1)) {
                    JOptionPane.showMessageDialog(null, "Erreur, il manque au moins une sélection!", "Avertissement", JOptionPane.WARNING_MESSAGE);
                } else {
                    if (!(tfNbJours.getText().matches("^[0-9]{1,3}+$"))){
                    JOptionPane.showMessageDialog(null, "Veuillez entrer que des chiffres.", "ERREUR", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    
                    String nom = tfNom.getText();
                    int nbJours = Integer.valueOf(tfNbJours.getText());
                    int nbPersonnes = Integer.valueOf((String) cbNbPersonnes.getSelectedItem());

                    if (!(nom.matches("^([A-Za-z])+$") && (nom.length() > 2))) {
                        JOptionPane.showMessageDialog(null, "Veuillez entrer que des lettres et plus de 2 charatères.", "ERREUR", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    
                    if (nbPersonnes == 1) {
                        tarifSejour = Double.valueOf(23.25 * nbJours);
                    }
                    if (nbPersonnes == 2) {
                        tarifSejour = Double.valueOf(44.15 * nbJours);
                    }
                    if (nbPersonnes == 3) {
                        tarifSejour = Double.valueOf((62.40) * nbJours);
                    }
                    if (nbPersonnes >= 4) {
                        tarifSejour = Double.valueOf((62.40) * nbJours + (16.25 * nbJours * (nbPersonnes - 3)));
                    }

                    try {
                        FormEvent fe = new FormEvent(this, nom, nbJours, nbPersonnes);

                        if (formListener != null) {
                            formListener.formEventOccurence(fe);
                        }
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, "Erreur, il manque au moins une sélection!", "Avertissement", JOptionPane.WARNING_MESSAGE);
                    }
                }

            }
        });

    }

    void setFormListener(FormListener formListener) {
        this.formListener = formListener;
    }

}
