package com.example.roomdbpractice

import android.content.Context
import androidx.lifecycle.ViewModelProvider.NewInstanceFactory.Companion.instance
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Profile::class], version = 1)
abstract class ProfileDatabase : RoomDatabase(){
    abstract fun profileDao() : ProfileDAO

    companion object{

        private var instance: ProfileDatabase? = null

        @Synchronized
        fun getInstance(context: Context) : ProfileDatabase? {
            if(instance == null){
                synchronized(ProfileDatabase::class){
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        ProfileDatabase::class.java,
                        "user-database"
                    ).build()
                }
            }
            return  instance
        }
    }
}