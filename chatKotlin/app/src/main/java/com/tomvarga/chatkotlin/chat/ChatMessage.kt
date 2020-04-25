package com.tomvarga.chatkotlin.chat

import android.R.id
import android.icu.text.CaseMap.Title
import org.joda.time.DateTime
import org.joda.time.format.DateTimeFormat


class ChatMessage(_messageText: String?) {

    companion object {
        var idIncrement = 0
        var dateNow = DateTime.now().toString(DateTimeFormat.mediumDate())
    }

    var messageText: String? = _messageText
    var id: Int = idIncrement++
    var date = dateNow

}