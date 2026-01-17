package com.jackslan.taskmanager.data.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class ToDoEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    @ColumnInfo(name = "title") val firstName: String?,
    @ColumnInfo(name = "description") val lastName: String?,
    @ColumnInfo(name = "isCompleted") val isCompleted: Boolean
)