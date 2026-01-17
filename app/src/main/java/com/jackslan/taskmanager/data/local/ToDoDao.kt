package com.jackslan.taskmanager.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface ToDoDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTask(task: ToDoEntity)

    @Query("SELECT * FROM todoentity")
    fun getAllTasks(): Flow<List<ToDoEntity>>

    @Query("SELECT * FROM todoentity WHERE isCompleted = 0")
    fun getUncompletedTasks(): Flow<List<ToDoEntity>>

    @Query("SELECT * FROM todoentity WHERE isCompleted = 1")
    fun getCompletedTasks(): Flow<List<ToDoEntity>>

    @Update
    suspend fun updateTask(task: ToDoEntity)

    @Query("DELETE FROM todoentity WHERE id = :taskId")
    suspend fun deleteTask(taskId: Int)

    @Query("SELECT * FROM todoentity WHERE id = :taskId")
    suspend fun getTaskById(taskId: Int): ToDoEntity
}