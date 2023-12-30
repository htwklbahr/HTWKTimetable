package com.lb.functionalities.data.database.di

import com.lb.functionalities.data.database.*

class DatabaseModule {

    private val factory by lazy { DatabaseDriverFactory() }
    val lecturesDataSource by lazy {
        SqlDelightDataSource(LecturesDatabase(factory.createDriver()))
    }

}