package com.proj.pharm2022.personne;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ListeCompte {
    List<Compte> listeCompte = new ArrayList<Compte>();

    public ListeCompte() {
    }

    public ListeCompte(List<Compte> listeCompte) {
        this.listeCompte = listeCompte;
    }
    public void AjouterCompte(Compte compte){
        listeCompte.add(compte);
    }

    public List<Compte> getListeCompte() {
        return listeCompte;
    }

    public void setListeCompte(List<Compte> listeCompte) {
        this.listeCompte = listeCompte;
    }


}
