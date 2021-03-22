package com.apps.myroomdatabase.repository

import android.content.Context
import androidx.lifecycle.LiveData
import com.apps.myroomdatabase.db.AppDataBase
import com.apps.myroomdatabase.db.User
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

class UserRepository {

    companion object {
        private var noteDatabase: AppDataBase? = null
        private fun initialiseDB(context: Context): AppDataBase? {
            return AppDataBase.getInstance(context)
        }

        fun insert(context: Context, user: User) {
            noteDatabase = initialiseDB(context)
            CoroutineScope(IO).launch {
                noteDatabase?.getDao()?.insert(user)
            }
        }

        fun getUserData(context: Context): LiveData<List<User>>? {
            noteDatabase = initialiseDB(context)
            return noteDatabase?.getDao()?.getUserData()

        }
    }
}