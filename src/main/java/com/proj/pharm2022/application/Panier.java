package com.proj.pharm2022.application;

public class Panier {
    int mId,quantite,prix;
    String nom,marque;

    public Panier(int mId, int quantite, int prix, String nom, String marque) {
        this.mId = mId;
        this.quantite = quantite;
        this.prix = prix;
        this.nom = nom;
        this.marque = marque;
    }

    public int getmId() {
        return mId;
    }

    public void setmId(int mId) {
        this.mId = mId;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public int getPrix() {
        return prix;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }
}
