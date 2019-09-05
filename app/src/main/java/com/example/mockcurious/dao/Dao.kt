package com.example.mockcurious.dao

import androidx.sqlite.db.SupportSQLiteDatabase

abstract class Dao(private val tableName: String) {

    abstract fun createTable(sqliteDatabase: SupportSQLiteDatabase)

    fun onUpgrade(sqliteDatabase: SupportSQLiteDatabase, oldVersion: Int, newVersion: Int) {
        sqliteDatabase.execSQL(String.format("DROP TABLE IF EXISTS %s", tableName))
        createTable(sqliteDatabase)
    }

    protected fun getDatabase(): SupportSQLiteDatabase = DaoM

}