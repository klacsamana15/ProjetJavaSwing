// Auteurs: Kriza Lacsamana et Sylvain Pouliot; Gr.427
package projetfinal;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class EscaladeFrame extends JFrame {
    
    JLabel lblEscalade;
    JPanel locationPanel, inputPanel;
    JLabel lblLocation, lblItem, lblPrix, lblNbPersonnes, lblNbHeures;
    JComboBox cbNbPersonnes, cbNbHeures;
    JCheckBox cbPrix;
    JButton btnRetour, btnSoumettre;
    MyFrame mainFrame;
    public static double tarifEscalade;
    
    EscaladeFrame() {
        setSize(495, 400);
        setTitle("Escalade");
        setResizable(false);
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setLocationRelativeTo(null);
        
        lblEscalade = new JLabel("ESCALADE");
        lblEscalade.setForeground(Color.RED);
        lblEscalade.setFont(new Font("Arial", Font.BOLD, 30));
        lblEscalade.setBounds(160, 0, 500, 80);
        add(lblEscalade);
        
        ImageIcon imageCamping = new ImageIcon("resources/escalade.png");
        JLabel image = new JLabel();
        image.setIcon(imageCamping);
        image.setBounds(20, 80, 200, 200);
        add(image);
        
        btnRetour = new JButton("Retour");
        btnRetour.setBounds(180, 320, 100, 20);
        btnRetour.setFocusable(false);
        add(btnRetour);
        btnRetour.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource() == btnRetour) 
                    dispose();
            }   
        });
        
        //////////////////////////////////////////////
        
        locationPanel = new JPanel();
        locationPanel.setLayout(null);
        locationPanel.setBounds(250, 60, 200, 200);
        
        lblLocation = new JLabel("Location: ");
        lblLocation.setForeground(Color.BLUE);
        lblLocation.setFont(new Font("Arial", Font.PLAIN, 20));
        lblLocation.setBounds(20, 0, 200, 50);
        locationPanel.add(lblLocation);
        
        lblItem = new JLabel("Casque, piolet et cordes: ");
        lblItem.setBounds(20, 50, 200, 20);
        locationPanel.add(lblItem);
        
        lblPrix = new JLabel("10$/heure par personne");
        lblPrix.setBounds(20, 70, 200, 20);
        locationPanel.add(lblPrix);
        
        
        inputPanel = new JPanel();
        inputPanel.setLayout(null);
        inputPanel.setBounds(250, 170, 210, 120);
        inputPanel.setBorder(BorderFactory.createLineBorder(Color.ORANGE));

        
        lblNbPersonnes = new JLabel("Nb de personnes: ");
        lblNbPersonnes.setBounds(20, 10, 140, 25);
        inputPanel.add(lblNbPersonnes);
        String[] nbPersonnes = {"1", "2", "3", "4", "5", "6"};
        cbNbPersonnes = new JComboBox(nbPersonnes);
        cbNbPersonnes.setSelectedIndex(-1);
        cbNbPersonnes.setBackground(Color.WHITE);
        cbNbPersonnes.setFocusable(false);
        cbNbPersonnes.setBounds(130, 10, 50, 25);
        inputPanel.add(cbNbPersonnes);
        
        lblNbHeures = new JLabel("Nb d'heures: ");
        lblNbHeures.setBounds(20, 40, 150, 25);
        inputPanel.add(lblNbHeures);
        String[] nbHeures = {"1", "2", "3", "4"};
        cbNbHeures = new JComboBox(nbHeures);
        cbNbHeures.setSelectedIndex(-1);
        cbNbHeures.setBackground(Color.WHITE);
        cbNbHeures.setFocusable(false);
        cbNbHeures.setBounds(130, 40, 50, 25);
        inputPanel.add(cbNbHeures);
              
        btnSoumettre = new JButton("Soumettre");
        btnSoumettre.setBounds(55, 90, 100, 20);
        btnSoumettre.setFocusable(false);
        inputPanel.add(btnSoumettre);
        btnSoumettre.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if((cbNbPersonnes.getSelectedIndex() != -1) && (cbNbHeures.getSelectedIndex() != -1))
                {
                    tarifEscalade = (cbNbPersonnes.getSelectedIndex()+1)*(cbNbHeures.getSelectedIndex()+1) * 10;
                    JOptionPane.showMessageDialog(null, "Activité ajouté!","Affirmation",JOptionPane.INFORMATION_MESSAGE);
                    dispose();
                }
                else
                   JOptionPane.showMessageDialog(null, "Erreur, il manque au moins une sélection!","Avertissement",JOptionPane.WARNING_MESSAGE);
            }
        });
        add(inputPanel);
        add(locationPanel);
        
        setVisible(true);
    }
    
}
