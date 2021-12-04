package com.dam.parcialdam;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.UUID;

@Entity(tableName = "Informacion")
public class InfoGuardada {
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "id_Info")
    private String id;

    public InfoGuardada() {
        this.id = UUID.randomUUID().toString();
    }

    private String infoSelected;
    private String comentario;

    @NonNull
    public String getId() {
        return id;
    }

    public void setId(@NonNull String id) {
        this.id = id;
    }

    public String getInfoSelected() {
        return infoSelected;
    }

    public void setInfoSelected(String infoSelected) {
        this.infoSelected = infoSelected;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    @Override
    public String toString() {
        return "InfoGuardada{" +
                "infoSelected='" + infoSelected + '\'' +
                ", comentario='" + comentario + '\'' +
                '}';
    }
}
