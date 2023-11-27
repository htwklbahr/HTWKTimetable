package com.lb.shared.utils.calendar

class Greeting {
    private val platform: Platform = getPlatform()

    fun greet(): String {
        return "Hello, ${platform.name}, my name is Luis!"
    }
}