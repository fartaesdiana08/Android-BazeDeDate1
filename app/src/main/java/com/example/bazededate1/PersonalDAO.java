package com.example.bazededate1;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface PersonalDAO {

    @Insert
    public void insert(PersonalMedical personal);
    @Query("Select * from personal")
    public List<PersonalMedical> getAll();
    @Delete()
    public void delete(PersonalMedical pers);
}
