package com.techblue.roompoc.models

import androidx.room.Embedded
import androidx.room.Relation

data class SchoolWithStudents(
    @Embedded
    var school: School,

    @Relation(
        parentColumn = "schoolName",
        entityColumn = "schoolName"
    )
    var student: List<Student>
)
