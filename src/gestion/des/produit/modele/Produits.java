/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestion.des.produit.modele;

/**
 *
 * @author Lovasoa
 */
public class Produits {

    int N_prod;
    String designation;
    int qte_totale;

    public Produits() {
    }

    public Produits(int N_prod, String designation, int qte_totale) {
        this.N_prod = N_prod;
        this.designation = designation;
        this.qte_totale = qte_totale;
    }

    public Produits(String designation, int qte_totale) {
        this.designation = designation;
        this.qte_totale = qte_totale;
    }

    public int getN_prod() {
        return N_prod;
    }

    public void setN_prod(int N_prod) {
        this.N_prod = N_prod;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public int getQte_totale() {
        return qte_totale;
    }

    public void setQte_totale(int qte_totale) {
        this.qte_totale = qte_totale;
    }

    
}
