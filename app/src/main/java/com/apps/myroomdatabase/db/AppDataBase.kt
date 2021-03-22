package com.apps.myroomdatabase.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [User::class],version = 1,exportSchema = false)
abstract class AppDataBase : RoomDatabase() {

    abstract fun getDao():UserDao

    companion object{
        private const val DATABASE_NAME="AppDatabase.db"

        @Volatile
        var instance:AppDataBase?=null

        fun getInstance(context: Context):AppDataBase?
        {
            if(instance == null)
            {
                synchronized(AppDataBase::class.java)
                {
                    if(instance == null)
                    {
                        instance= Room.databaseBuilder(context,AppDataBase::class.java,
                            DATABASE_NAME).build()
                    }
                }
            }

            return instance
        }
    }
}