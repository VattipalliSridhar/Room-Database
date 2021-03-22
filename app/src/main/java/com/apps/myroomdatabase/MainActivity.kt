package com.apps.myroomdatabase

import android.R
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.apps.myroomdatabase.databinding.ActivityMainBinding
import com.apps.myroomdatabase.db.User
import com.apps.myroomdatabase.viewmodel.UserViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var typeArray: ArrayList<String> =ArrayList()

    private lateinit var userViewModel: UserViewModel
    private lateinit var noteList: ArrayList<User>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)


        binding.clickView.setOnClickListener {
            startActivity(Intent(this@MainActivity, UserLoginActivity::class.java))
        }


        userViewModel = ViewModelProvider(this).get(UserViewModel::class.java)

        userViewModel.getUserData(this)?.observe(this, Observer {
            if (it.isNotEmpty()) {
                typeArray.clear()
                noteList = it as ArrayList<User>
                Log.e("msg", "" + (it.size))
                for (i in noteList.indices) {
                   typeArray.add(noteList[i].firstName)
                }
                val categoryAdapter: ArrayAdapter<String> = ArrayAdapter<String>(applicationContext, R.layout.simple_dropdown_item_1line, typeArray)
                binding.spinnerViolation.adapter = categoryAdapter
                //Log.e("msg", "" + (it[0].firstName))
            } else {
                Log.e("msg", "Nothing")
            }
        })

    }
}