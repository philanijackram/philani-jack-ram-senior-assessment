package com.jackslan.taskmanager.di

import android.content.Context
import androidx.room.Room
import com.jackslan.taskmanager.R
import com.jackslan.taskmanager.data.local.AppDatabase
import com.jackslan.taskmanager.data.local.ToDoDao
import com.jackslan.taskmanager.data.remote.api.ApiService
import com.jackslan.taskmanager.data.repository.ToDoRepositoryImpl
import com.jackslan.taskmanager.data.repository.WeatherRepositoryImpl
import com.jackslan.taskmanager.domain.repository.ToDoRepository
import com.jackslan.taskmanager.domain.repository.WeatherRepository
import com.jackslan.taskmanager.domain.use_case.to_do.CreateNewTaskUseCase
import com.jackslan.taskmanager.domain.use_case.to_do.DeleteTaskUseCase
import com.jackslan.taskmanager.domain.use_case.to_do.GetAllTasksUseCase
import com.jackslan.taskmanager.domain.use_case.to_do.GetCompletedTasksUseCase
import com.jackslan.taskmanager.domain.use_case.to_do.GetIncompleteTasksUsesCase
import com.jackslan.taskmanager.domain.use_case.to_do.GetTaskByIdUseCase
import com.jackslan.taskmanager.domain.use_case.to_do.UpdateTaskStatusUseCase
import com.jackslan.taskmanager.domain.use_case.to_do.UpdateTaskUseCase
import com.jackslan.taskmanager.domain.use_case.weather.GetWeatherDataUseCase
import com.jackslan.taskmanager.utils.ImportantStrings
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    fun provideRetrofit(): Retrofit {
        return Retrofit
            .Builder()
            .baseUrl(ImportantStrings.WEATHER_API_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    fun provideWeatherApiService(retrofit: Retrofit): ApiService {
        return retrofit.create(ApiService::class.java)
    }

    @Provides
    fun provideDatabase(@ApplicationContext context: Context): AppDatabase {
        return Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            context.getString(R.string.app_db)
        ).build()
    }

    @Provides
    fun provideToDoDao(database: AppDatabase) = database.toDoDao()

    @Provides
    fun provideToDoRepository(toDoDao: ToDoDao): ToDoRepository {
        return ToDoRepositoryImpl(toDoDao)
    }

    @Provides
    fun provideWeatherRepository(apiService: ApiService): WeatherRepository {
        return WeatherRepositoryImpl(apiService)
    }

    //Use Cases

    @Provides
    fun provideCreateNewTaskUseCase(toDoRepository: ToDoRepository): CreateNewTaskUseCase {
        return CreateNewTaskUseCase(toDoRepository)
    }

    @Provides
    fun provideGetTaskByIdUseCase(toDoRepository: ToDoRepository): GetTaskByIdUseCase {
        return GetTaskByIdUseCase(toDoRepository)
    }

    @Provides
    fun provideGetAllTasksUseCase(toDoRepository: ToDoRepository): GetAllTasksUseCase {
        return GetAllTasksUseCase(toDoRepository)
    }

    @Provides
    fun provideGetIncompleteTasksUseCase(toDoRepository: ToDoRepository): GetIncompleteTasksUsesCase {
        return GetIncompleteTasksUsesCase(toDoRepository)
    }

    @Provides
    fun provideGetCompletedTasksUseCase(toDoRepository: ToDoRepository): GetCompletedTasksUseCase {
        return GetCompletedTasksUseCase(toDoRepository)
    }

    @Provides
    fun provideUpdateTaskUseCase(toDoRepository: ToDoRepository): UpdateTaskUseCase {
        return UpdateTaskUseCase(toDoRepository)
    }

    @Provides
    fun provideDeleteTaskUseCase(toDoRepository: ToDoRepository): DeleteTaskUseCase {
        return DeleteTaskUseCase(toDoRepository)
    }

    @Provides
    fun provideUpdateTaskStatusByIdUseCase(toDoRepository: ToDoRepository): UpdateTaskStatusUseCase {
        return UpdateTaskStatusUseCase(toDoRepository)
    }

    @Provides
    fun provideGetWeatherDataUseCase(weatherRepository: WeatherRepository): GetWeatherDataUseCase {
        return GetWeatherDataUseCase(weatherRepository)
    }

}