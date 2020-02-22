package org.example.model;

import org.example.converter.PohlavieConverter;
import org.example.enumerators.Pohlavie;

import javax.persistence.*;

@Entity
public class Osoba {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Convert(converter = PohlavieConverter.class)
    //tato anotacia tam skonvertuje enum na znak, ktory ocakava databaza
    private Pohlavie pohlavie;

    public Osoba(Pohlavie pohlavie) {
        this.pohlavie = pohlavie;
    }

    public Osoba(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Pohlavie getPohlavie() {
        return pohlavie;
    }

    public void setPohlavie(Pohlavie pohlavie) {
        this.pohlavie = pohlavie;
    }
}
