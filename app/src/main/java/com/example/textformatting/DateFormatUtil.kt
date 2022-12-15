package com.example.textformatting

import android.content.Context
import android.text.format.DateFormat
import android.util.Log
import java.text.SimpleDateFormat
import java.util.*

class DateFormatUtil {
    /**
     * Formatting means Date -> Text
     * Parsing means Text -> Date
     *
     * Use static factory methods to get DateFormat object
     *
     * getDateFormat() return DateFormat with SHORT format (completely numerical)
     * example 12.13.52 or 3:30pm
     *
     * getMediumDateFormat() return DateFormat with MEDIUM format
     * example Jan 12, 1952
     *
     * getLongDateFormat() return DateFormat with LONG format
     * example January 12, 1952
     *
     * parse() method will throw ParseException if the String is Unparseable
     * to get current Format pattern we can cast DateFormat to SimpleDateFormat and use toPattern()
     */
    fun parse(context : Context) {
        val dateString = "12/15/2022"
        DateFormat.getDateFormat(context).apply {
            println((this as SimpleDateFormat).toPattern())
            println("DateFormat parse : ${parse(dateString)}")
        }

        DateFormat.getMediumDateFormat(context).apply {
            println((this as SimpleDateFormat).toPattern())
            println("DateFormatMedium parse : ${parse("Dec 15, 2022")}")
        }

        DateFormat.getLongDateFormat(context).apply {
            println((this as SimpleDateFormat).toPattern())
            println("DateFormatLong parse : ${parse("December 15, 2022")}")
        }

    }

    private fun println(string: String){
        Log.d("DateObj", string)
    }

}