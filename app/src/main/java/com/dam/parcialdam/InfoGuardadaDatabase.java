package com.dam.parcialdam;

import androidx.room.Database;
import androidx.room.RoomDatabase;


@Database(entities = {InfoGuardada.class}, version = 3)
public abstract class InfoGuardadaDatabase extends RoomDatabase {
    public abstract InfoGuardadaDao InfoDao();
}