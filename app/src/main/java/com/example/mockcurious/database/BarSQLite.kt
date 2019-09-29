package com.example.mockcurious.database

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class BarSQLite(context: Context) : SQLiteOpenHelper(context, table, null, version) {

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL(String.format("DROP TABLE IF EXISTS %s", table))
        onCreate(db)
    }

    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL(createTableStatement)
    }

    companion object {
        const val table = "bars"
        const val version = 1

        const val ID = "id"
        const val NAME = "name"
        const val DATE_CREATED = "date_created"
        const val TIME_CREATED = "time_created"
        const val IMAGE = "image"
        const val ADDRESS = "address"
        const val CITY = "city"
        const val ZIPCODE = "zipcode"
        const val NEIGHBORHOOD = "neighborhood"
        const val FILTERS = "filters" // figure out the best way to design a data base with filters

        val createTableStatement = """
            CREATE TABLE $table(
            $ID STRING,
            $NAME STRING,
            $DATE_CREATED STRING,
            $TIME_CREATED STRING,
            $IMAGE STRING,
            $ADDRESS STRING,
            $CITY STRING,
            $ZIPCODE STRING,
            $NEIGHBORHOOD STRING,
            $FILTERS STRING)
        """.trimIndent()
    }

    private fun getContentValues(cap: Int, tokens: List<String>): ContentValues {
        return ContentValues(cap).apply {
            put(ID, tokens[0].trim())
            put(NAME, tokens[1].trim())
            put(DATE_CREATED, tokens[2].trim())
            put(TIME_CREATED, tokens[3].trim())
            put(IMAGE, tokens[4].trim())
            put(ADDRESS, tokens[5].trim())
            put(CITY, tokens[6].trim())
            put(ZIPCODE, tokens[7].trim())
            put(NEIGHBORHOOD, tokens[8].trim())
            put(FILTERS, tokens[9].trim())
        }
    }
}
