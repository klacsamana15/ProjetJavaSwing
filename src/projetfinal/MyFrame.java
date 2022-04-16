// Auteurs: Kriza Lacsamana et Sylvain Pouliot; Gr.427
package projetfinal;

import javax.swing.JFrame;

class MyFrame extends JFrame {

    IntroPanel introPanel;
    FormPanel formPanel;
    ActivitePanel activitePanel;
    ResultatPanel resultatPanel;
    EscaladeFrame escalade;
    Equitation equitation;
    Canot canot;

    MyFrame() {
        //setSize(835, 610);
        setSize(495, 620);
        setTitle("Projet Final: Kriza Lacsamana & Sylvain Pouliot");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setResizable(false);
        setLocationRelativeTo(null);

        introPanel = new IntroPanel();
        introPanel.setBounds(20, 0, 495, 250);
        add(introPanel);

        activitePanel = new ActivitePanel();
        activitePanel.setBounds(20, 270, 440, 110);
        add(activitePanel);

        formPanel = new FormPanel();
        formPanel.setBounds(20, 390, 440, 160);
        add(formPanel);

        formPanel.setFormListener(new FormListener() {
            @Override
            public void formEventOccurence(FormEvent e) {
                String nom = e.getNom();
                int nbJours = e.getNbJours();
                int nbPersonnes = e.getNbPersonnes();

                setSize(835, 610);
                resultatPanel.setVisible(true);
                if (canot.tarifCanot > 0.0 && equitation.tarifEquitation > 0.0 && escalade.tarifEscalade > 0.0) {
                    resultatPanel.taInfo.append("\nNom: " + nom + "\nNb de jours: " + nbJours + "\nNb de personnes: " + nbPersonnes + "\nTarif activités: " + (canot.tarifCanot + equitation.tarifEquitation + escalade.tarifEscalade) + "\nTarif séjour: " + formPanel.tarifSejour);
                } else if (canot.tarifCanot > 0.0 && equitation.tarifEquitation > 0.0) {
                    resultatPanel.taInfo.append("\nNom: " + nom + "\nNb de jours: " + nbJours + "\nNb de personnes: " + nbPersonnes + "\nTarif activités: " + (canot.tarifCanot + equitation.tarifEquitation) + "\nTarif séjour: " + formPanel.tarifSejour);
                } else if (canot.tarifCanot > 0.0 && escalade.tarifEscalade > 0.0) {
                    resultatPanel.taInfo.append("\nNom: " + nom + "\nNb de jours: " + nbJours + "\nNb de personnes: " + nbPersonnes + "\nTarif activités: " + (canot.tarifCanot + escalade.tarifEscalade) + "\nTarif séjour: " + formPanel.tarifSejour);
                } else if (equitation.tarifEquitation > 0.0 && escalade.tarifEscalade > 0.0) {
                    resultatPanel.taInfo.append("\nNom: " + nom + "\nNb de jours: " + nbJours + "\nNb de personnes: " + nbPersonnes + "\nTarif activités: " + (escalade.tarifEscalade + equitation.tarifEquitation + escalade.tarifEscalade) + "\nTarif séjour: " + formPanel.tarifSejour);
                } else if (canot.tarifCanot > 0.0) {
                    resultatPanel.taInfo.append("\nNom: " + nom + "\nNb de jours: " + nbJours + "\nNb de personnes: " + nbPersonnes + "\nTarif activité: " + canot.tarifCanot + "\nTarif séjour: " + formPanel.tarifSejour);
                } else if (equitation.tarifEquitation > 0.0) {
                    resultatPanel.taInfo.append("\nNom: " + nom + "\nNb de jours: " + nbJours + "\nNb de personnes: " + nbPersonnes + "\nTarif activité: " + equitation.tarifEquitation + "\nTarif séjour: " + formPanel.tarifSejour);
                } else if (escalade.tarifEscalade > 0.0) {
                    resultatPanel.taInfo.append("\nNom: " + nom + "\nNb de jours: " + nbJours + "\nNb de personnes: " + nbPersonnes + "\nTarif activité: " + escalade.tarifEscalade + "\nTarif séjour: " + formPanel.tarifSejour);
                } else {
                    resultatPanel.taInfo.append("\nNom: " + nom + "\nNb de jours: " + nbJours + "\nNb de personnes: " + nbPersonnes + "\nTarif total: " + formPanel.tarifSejour);
                }
            }
        });

        resultatPanel = new ResultatPanel();
        resultatPanel.setBounds(520, 20, 280, 530);
        add(resultatPanel);

        setVisible(true);
    }
}
