package com.techblue.roompoc.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Director(
    @PrimaryKey(autoGenerate = false)
    var directorName: String,

    @ColumnInfo(name = "schoolName")
    var schoolName: String
)