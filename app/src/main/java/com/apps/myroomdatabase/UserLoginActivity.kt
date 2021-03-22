package com.apps.myroomdatabase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.apps.myroomdatabase.db.User
import com.apps.myroomdatabase.viewmodel.UserViewModel

class UserLoginActivity : AppCompatActivity() {

    private lateinit var userViewModel: UserViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_login)


        userViewModel = UserViewModel()

        val user = User("Sridhar", "Vattipalli", 20)
        userViewModel.insert(applicationContext, user)
    }
}