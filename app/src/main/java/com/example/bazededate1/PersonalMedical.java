package com.example.bazededate1;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "personal")
public class PersonalMedical implements Serializable {

    @PrimaryKey(autoGenerate = true)
    private int id;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    private String nume;
    private String functie;
    private int nrOreLucrate; //seekbar
    private int oraTura; //timepick
    private boolean angajatVechi; //checkbox

    @Ignore
    public PersonalMedical(String nume, String functie, int nrOreLucrate, int oraTura, boolean angajatVechi) {
        this.nume = nume;
        this.functie = functie;
        this.nrOreLucrate = nrOreLucrate;
        this.oraTura = oraTura;
        this.angajatVechi = angajatVechi;
    }

    public PersonalMedical(int id, String nume, String functie, int nrOreLucrate, int oraTura, boolean angajatVechi) {
        this.id = id;
        this.nume = nume;
        this.functie = functie;
        this.nrOreLucrate = nrOreLucrate;
        this.oraTura = oraTura;
        this.angajatVechi = angajatVechi;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getFunctie() {
        return functie;
    }

    public void setFunctie(String functie) {
        this.functie = functie;
    }

    public int getNrOreLucrate() {
        return nrOreLucrate;
    }

    public void setNrOreLucrate(int nrOreLucrate) {
        this.nrOreLucrate = nrOreLucrate;
    }

    public int getOraTura() {
        return oraTura;
    }

    public void setOraTura(int oraTura) {
        this.oraTura = oraTura;
    }

    public boolean isAngajatVechi() {
        return angajatVechi;
    }

    public void setAngajatVechi(boolean angajatVechi) {
        this.angajatVechi = angajatVechi;
    }

    @Override
    public String toString() {
        return "PersonalMedical{" +
                "nume='" + nume + '\'' +
                ", functie='" + functie + '\'' +
                ", nrOreLucrate=" + nrOreLucrate +
                ", oraTura=" + oraTura +
                ", angajatVechi=" + angajatVechi +
                '}';
    }
}
