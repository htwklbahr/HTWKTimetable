package com.lb.htwktimetable.android.di

import android.app.Application
import app.cash.sqldelight.db.SqlDriver
import com.lb.functionalities.data.database.*
import dagger.*
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideSqlDriver(app: Application): SqlDriver {
        return DatabaseDriverFactory(app).createDriver()
    }

    @Provides
    @Singleton
    fun provideDataSource(driver: SqlDriver): LecturesDataSource {
        return SqlDelightDataSource(LecturesDatabase(driver))
    }
}