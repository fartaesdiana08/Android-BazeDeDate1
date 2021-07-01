package com.example.bazededate1;


import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {PersonalMedical.class}, version = 1, exportSchema = false)
public abstract class PersonalDB extends RoomDatabase {

    public static final String DB_NAME = "personal.db";
    private static PersonalDB instanta;

    public static PersonalDB getInstanta(Context context)
    {
        if (instanta==null)
            instanta = Room.databaseBuilder(context, PersonalDB.class, DB_NAME)
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build();

        return instanta;
    }

    public abstract PersonalDAO getPersonalDao();
}
