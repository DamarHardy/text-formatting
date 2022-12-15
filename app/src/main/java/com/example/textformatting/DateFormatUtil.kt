package com.example.textformatting

import android.content.Context
import android.text.format.DateFormat
import android.util.Log

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
     */
    fun parse(context : Context) {
        val dateString = "June 12th, 2022"
        val dateObj = DateFormat.getDateFormat(context).parse(dateString)
        Log.d("DateObje", dateObj.toString())
    }

}