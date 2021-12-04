package com.dam.parcialdam;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface InfoGuardadaDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void saveInfo(InfoGuardada info);

    @Query("SELECT * FROM Informacion")
    public List<InfoGuardada> loadInfo();
}
