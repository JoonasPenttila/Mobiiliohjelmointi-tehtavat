package fi.joonas.week1tasks.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import fi.joonas.week1tasks.data.model.TaskEntity

@Database(entities = [TaskEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun taskDao(): TaskDao
}
