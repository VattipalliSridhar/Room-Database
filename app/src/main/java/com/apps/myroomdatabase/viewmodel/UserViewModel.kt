package com.apps.myroomdatabase.viewmodel

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.apps.myroomdatabase.db.User
import com.apps.myroomdatabase.repository.UserRepository

class UserViewModel : ViewModel() {


    fun insert(context: Context, user:User)
    {
        UserRepository.insert(context,user)
    }


    fun getUserData(context: Context): LiveData<List<User>>?
    {
        return UserRepository.getUserData(context)
    }
}