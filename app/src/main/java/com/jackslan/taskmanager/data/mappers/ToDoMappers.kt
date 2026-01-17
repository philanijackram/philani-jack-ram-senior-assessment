package com.jackslan.taskmanager.data.mappers

import com.jackslan.taskmanager.data.local.TaskEntity
import com.jackslan.taskmanager.domain.model.TaskItem

fun TaskItem.toEntity(): TaskEntity {
    return TaskEntity(
        title = title,
        description = description,
        isCompleted = isCompleted
    )
}

fun TaskEntity.toDomain(): TaskItem {
    return TaskItem(
        id = id,
        title = title ?: "",
        description = description
    )
}