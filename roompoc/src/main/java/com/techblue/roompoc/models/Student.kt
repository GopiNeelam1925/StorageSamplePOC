package com.techblue.roompoc.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Student(
    @PrimaryKey(autoGenerate = false)
    var studentName: String,
    var schoolName: String
)
