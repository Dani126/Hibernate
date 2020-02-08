package org.example.model;

import javax.persistence.*;
import java.util.Date;

@Entity
//entitou definujem ze sa budem pripajat k databaze(pouzije hibernate)
@Table(name = "Messages")
//takto definujem na ktoru tabulku sa bude pripajat
public class Message {

    @Id
    //anotacia pre parameter ktory sa bude inkrementovat, bude to jeho identifikator
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //Generovane ID podla databazy(IDENTITY)
//    @Column(name = "ID")
    //definovanie stlpca v databaze
    private Long id;

    @Column(name = "N_MESSAGE")
    private String message;

    @Column(name = "CREATE_DATE",insertable = false)
//    insertable = false pouzijem, nechcem vkladat danu hodnotu do databazy, lebo si ju
//      generuje databaza sama
    private java.util.Date createDate;
    //pridane len kvôli tomu ze sa to nachadza v databaze,
    //      ORM to sam rozozna a namapuje, databaza si uz hodnotu sama vygeneruje
    //dodatocne som zistil, ze ak mam generovanu hodnotu, lepsie to tam nedavat, preto zakomentovane

    public Message(){
    }

    public Message(String message){
        this.message = message;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}
