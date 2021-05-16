package com.techblue.roompoc.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.techblue.roompoc.models.Director
import com.techblue.roompoc.models.School
import com.techblue.roompoc.models.SchoolAndDirector

@Dao
interface OneToOneDao {

    @Insert
    fun insert(school: School): Long

    @Insert
    fun insert(director: Director): Long

    @Query("SELECT * FROM school")
    fun getAllSchoolsWithDirector(): List<SchoolAndDirector>
}