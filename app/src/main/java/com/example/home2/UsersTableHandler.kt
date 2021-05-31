package com.example.home2

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.example.home2.models.User

class UsersTableHandler (var context: Context): SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION){
    companion object{
        private val DATABASE_VERSION = 1
        private val DATABASE_NAME = "users_database"
        private val TABLE_NAME = "users"
        private val COL_ID = "id"
        private val COL_MOBILE_NUMBER = "mobileNumber"
        private val COL_BARANGAY = "barangay"
    }

    override fun onCreate(db: SQLiteDatabase?) {
//        TODO("Not yet implemented")
        val query = "CREATE TABLE "+TABLE_NAME+" ("+COL_ID+" INTEGER PRIMARY KEY, "+ COL_MOBILE_NUMBER+" DECIMAL(10,2), "+ COL_BARANGAY+" TEXT)"
        db?.execSQL(query)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
//        TODO("Not yet implemented")
        db!!.execSQL("DROP TABLE IF EXISTS" + TABLE_NAME)
        onCreate(db)
    }

    fun create(user: User):Boolean{
        val database = this.writableDatabase
        val contentValues = ContentValues()
        val convertedNum = String.format("%.2f", user.mobileNumber).toDouble()
        contentValues.put(COL_MOBILE_NUMBER, convertedNum)
        contentValues.put(COL_BARANGAY, user.barangay)
        //insert
        val result = database.insert(TABLE_NAME, null, contentValues)
        if (result == (0).toLong()){
            return true
        }
        return false
    }
}

