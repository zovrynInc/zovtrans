package com.example.myapplication.data

import com.example.myapplication.R
import com.example.myapplication.model.Affirmation
import com.example.myapplication.model.MessageListObj

class Datasource {

    fun loadAffirmations(): List<Affirmation> {
        return listOf<Affirmation>(
            Affirmation(R.string.affirmation1),
            Affirmation(R.string.affirmation2),
            Affirmation(R.string.affirmation3),
            Affirmation(R.string.affirmation4),
            Affirmation(R.string.affirmation5),
            Affirmation(R.string.affirmation6),
            Affirmation(R.string.affirmation7),
            Affirmation(R.string.affirmation8),
            Affirmation(R.string.affirmation9),
            Affirmation(R.string.affirmation10)
        )
    }

    fun loadMList(): List<MessageListObj> {
        return listOf<MessageListObj>(
            MessageListObj("sssss","aaaa","wwww,","wwwwedd"),
            MessageListObj("ddddd","aaaa","22wdd,","wwwwedd"),
            MessageListObj("qqqqq","ccccc","sksskksksk,","wwwwedd"),

        )
    }
}