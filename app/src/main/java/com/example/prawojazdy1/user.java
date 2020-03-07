package com.example.prawojazdy1;

import com.google.firebase.database.IgnoreExtraProperties;

@IgnoreExtraProperties
public class user {
   String  id;
   String name;
   String kategoria;
   int wynik;

   public user(){

    }

    public user(String id, String name, String kategoria, int wynik) {
        this.id = id;
        this.name = name;
        this.kategoria = kategoria;
        this.wynik =wynik;

    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getKategoria() {
        return kategoria;
    }
    public int getWynik() {
        return wynik;
    }


}
