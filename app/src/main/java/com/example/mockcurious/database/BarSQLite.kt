package com.example.mockcurious.database

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.example.mockcurious.models.Bar
import com.example.mockcurious.models.Filters
import java.sql.Date
import java.time.LocalDateTime
import java.util.*

class BarSQLite(context: Context) : SQLiteOpenHelper(context, database_name, null, version) {

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL(String.format("DROP TABLE IF EXISTS %s", table))
        onCreate(db)
    }

    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL(createTableStatement)
    }

    fun getAllBars(): List<Bar> {
        val barList = arrayListOf<Bar>()
        val cursor = readableDatabase.rawQuery(String.format("SELECT * FROM $table"), null)

        if (cursor.moveToFirst()) {
            do {
                val bar = createBarFromTable(cursor)
                barList.add(bar)
            } while (cursor.moveToNext())
        }

        return barList
    }

    fun addBar(bar: Bar) {
        val values = getContentValues(bar)

        writableDatabase.insert(table, null, values)
        writableDatabase.close()
    }

    fun getBar(uuid: UUID) {

        // val cursor = readableDatabase.query(table, "")
    }

    fun updateBar(bar: Bar) {
        val uuidString = bar.uuid.toString()
        val values: ContentValues = getContentValues(bar)

        writableDatabase.execSQL(String.format(""))
        writableDatabase.update(table, values, "$ID = ?", arrayOf(uuidString))
    }

    companion object {
        const val database_name = "barManager"
        const val table = "bars"
        const val version = 1

        const val ID = "id"
        const val NAME = "name"
        const val DATE_CREATED = "date_created"
        const val DATE_EDITED = "date_edited"
        const val IMAGE = "image"
        const val ADDRESS = "address"
        const val CITY = "city"
        const val ZIPCODE = "zipcode"
        const val FILTERS = "filters" // figure out the best way to design a data base with filters

        val createTableStatement = """
            CREATE TABLE $table(
            $ID STRING,
            $NAME STRING,
            $DATE_CREATED STRING,
            $DATE_EDITED STRING,
            $IMAGE STRING,
            $ADDRESS STRING,
            $CITY STRING,
            $ZIPCODE STRING,
            $FILTERS STRING)
        """.trimIndent()
    }

    private fun createBarFromTable(cursor: Cursor): Bar {
        return Bar(
            UUID.fromString(cursor.getString(0)),
            cursor.getString(1),
            cursor.getString(2),
            cursor.getString(3),
            cursor.getString(4),
            cursor.getString(5),
            cursor.getString(6),
            toFilters(cursor.getString(7))
        )
    }

    // TODO create layer to Filters
    private fun toFilters(array: String): Filters? {
        return null
    }

    private fun getContentValues(bar: Bar): ContentValues {
        return ContentValues().apply {
            put(ID, bar.uuid.toString())
            put(NAME, bar.name.orEmpty())
            put(DATE_CREATED, LocalDateTime.now().toString())
            put(DATE_EDITED, LocalDateTime.now().toString())
            put(IMAGE, bar.image.orEmpty())
            put(ADDRESS, bar.address.orEmpty())
            put(CITY, bar.city.orEmpty())
            put(ZIPCODE, bar.zipcode.orEmpty())
            put(FILTERS, bar.barFilters.toString())
        }
    }

    private fun getContentValues(cap: Int, tokens: List<String>): ContentValues {
        return ContentValues(cap).apply {
            put(ID, tokens[0].trim())
            put(NAME, tokens[1].trim())
            put(DATE_CREATED, tokens[2].trim())
            put(DATE_EDITED, tokens[3].trim())
            put(IMAGE, tokens[4].trim())
            put(ADDRESS, tokens[5].trim())
            put(CITY, tokens[6].trim())
            put(ZIPCODE, tokens[7].trim())
            put(FILTERS, tokens[8].trim())
        }
    }
}
