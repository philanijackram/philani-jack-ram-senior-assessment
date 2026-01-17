package com.jackslan.taskmanager.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface ToDoDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTask(task: TaskEntity)

    @Query("SELECT * FROM taskentity WHERE id = :taskId")
    suspend fun getTaskById(taskId: Int): TaskEntity?

    @Query("SELECT * FROM taskentity")
    fun getAllTasks(): Flow<List<TaskEntity>>

    @Query("SELECT * FROM taskentity WHERE isCompleted = 0")
    fun getIncompleteTasks(): Flow<List<TaskEntity>>

    @Query("SELECT * FROM taskentity WHERE isCompleted = 1")
    fun getCompletedTasks(): Flow<List<TaskEntity>>

    @Update
    suspend fun updateTask(task: TaskEntity)

    @Query("DELETE FROM taskentity WHERE id = :taskId")
    suspend fun deleteTask(taskId: Int)
}