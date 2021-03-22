package com.apps.myroomdatabase.db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_table")
data class User(

    val firstName: String,
    val lastName: String,
    val age: Int
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null
}
