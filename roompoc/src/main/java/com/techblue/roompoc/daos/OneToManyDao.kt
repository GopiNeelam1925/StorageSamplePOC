package com.techblue.roompoc.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.techblue.roompoc.models.SchoolWithStudents
import com.techblue.roompoc.models.Student

@Dao
interface OneToManyDao {

    @Insert
    fun insert(student: Student)

    @Query("SELECT * FROM School")
    fun getAllSchoolsWithAllStudents(): List<SchoolWithStudents>

    @Query("SELECT * FROM School WHERE schoolName = :schoolName")
    fun getSchoolWithAllStudents(schoolName: String): SchoolWithStudents
}