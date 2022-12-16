package com.example.textformatting

import android.content.Context
import android.os.Build
import android.text.format.DateFormat
import android.util.Log
import java.text.SimpleDateFormat
import java.util.*
import java.time.*
import java.time.format.DateTimeFormatter

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
     * all of the static factor methods will return SimpleDateFormat object with specific pattern
     * so it's mostly save to cast it to SimpleDateFormat but just to be safe, put a try catch block when doing casting
     *
     * parse() method will throw ParseException if the String is Unparseable
     * to get current Format pattern we can cast DateFormat to SimpleDateFormat and use toPattern()
     *
     * Skeleton refers to pattern which will be used for parsing or format a particular Date object or String
     * These are some examples of pattern and how the String will be formatted
     * d/M/yy -> 12/15/2022
     * d MMM y -> 15 Dec 2022
     * d MMMM y -> 15 December 2022
     * h:mm a -> 9:40 AM (without trailing zero)
     *
     * FYI : Joda Time was the more preferred third-party library to handle Date and Calendar prior to Java SE 8
     * it's now included in Java 8.0 onward inside java.time package
     *
     * Joda Time provide a more efficient way to handle date and time.
     *
     * Calendar was the successor of Date which was buggy. DateFormat was introduced at the same time with Calendar
     * however it may introduce thread-safety issue
     */
    fun parse(context : Context) {
        val dateString = "12/15/2022"
        DateFormat.getDateFormat(context).apply {
            println((this as SimpleDateFormat).toPattern())
            println("DateFormat parse : ${parse(dateString)}")
        }

        DateFormat.getMediumDateFormat(context).apply {
            println((this as SimpleDateFormat).toPattern())
            println("DateFormatMedium parse : ${parse("15 Dec 2022")}")
        }

        DateFormat.getLongDateFormat(context).apply {
            println((this as SimpleDateFormat).toPattern())
            println("DateFormatLong parse : ${parse("15 December 2022")}")
        }

        DateFormat.getTimeFormat(context).apply {
            println((this as SimpleDateFormat).toPattern())
            println("TimeFormat parse : ${parse("09:40 PM")}")
        }

        localDate()
        localTime()
    }

    fun dateTest() {
        val date = Date((2022 - 1900), 12 - 1, 12)
    }

    fun localDate() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            LocalDate.now().apply {
                println("LocalDate without Zone : $this")
            }
            LocalDate.now(ZoneId.of("Asia/Jakarta")).apply {
                println("LocalDate with Zone : $this")
            }

            LocalDate.of(2022, 12, 16).apply {
                println("LocalDate with inserted date : $this")
            }

            LocalDate.parse("2022-12-16").apply {
                println("LocalDate with parsed date : $this")
            }
        }
    }

    fun localTime() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            LocalTime.now().apply {
                println("LocalTime without Zone : $this")
            }
            LocalTime.now(ZoneId.of("Asia/Jakarta")).apply {
                println("LocalTime with Zone : $this")
            }

            LocalTime.of(3, 40, 16).apply {
                println("LocalTime with inserted date : $this")
            }

            LocalTime.parse("03:40:35").apply {
                println("LocalDate with parsed date : $this")
            }

            LocalDateTime.now().apply {
                println("LocalDateTime now : $this")
            }

            LocalDateTime.parse("2022-12-16T03:40:49").apply {
                println("LocalDateTime parse : $this")
            }

            DateTimeFormatter.ofPattern("yyyy-MM-dd").format(LocalDateTime.ofEpochSecond(Instant.now().epochSecond, 0, ZoneOffset.ofHours(1))).apply {
                println("Formatter : $this")
            }


        }
    }

    fun calendar() {
        val calendar = Calendar.getInstance()
    }

    private fun println(string: String){
        Log.d("DateObj", string)
    }

}