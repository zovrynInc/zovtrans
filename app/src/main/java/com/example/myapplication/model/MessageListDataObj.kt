package com.example.myapplication.model

class MessageListDataObj(val uid: String,val lastMessage: String,val lastChecked: String) {

    constructor(): this("","","")

    override fun toString(): String {
        return "uid is $uid  lasmsg: $lastMessage  lastcheck: $lastChecked"
    }
}