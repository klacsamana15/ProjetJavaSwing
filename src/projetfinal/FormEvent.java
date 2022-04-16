// Auteurs: Kriza Lacsamana et Sylvain Pouliot; Gr.427
package projetfinal;

import java.util.EventObject;


public class FormEvent extends EventObject{
    
    private String nom;
    private int nbJours;
    private int nbPersonnes;
    

public FormEvent (Object source, String nom, int nbJours, int nbPersonnes)
    {
    super (source); 
    this.nom = nom;
    this.nbJours = nbJours;
    this.nbPersonnes = nbPersonnes;
    }

    /**
     * @return the nom
     */
    public String getNom() {
        return nom;
    }

    /**
     * @param nom the nom to set
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * @return the nbJours
     */
    public int getNbJours() {
        return nbJours;
    }

    /**
     * @param nbJours the nbJours to set
     */
    public void setNbJours(int nbJours) {
        this.nbJours = nbJours;
    }

    /**
     * @return the nbPersonnes
     */
    public int getNbPersonnes() {
        return nbPersonnes;
    }

    /**
     * @param nbPersonnes the nbPersonnes to set
     */
    public void setNbPersonnes(int nbPersonnes) {
        this.nbPersonnes = nbPersonnes;
    }
}