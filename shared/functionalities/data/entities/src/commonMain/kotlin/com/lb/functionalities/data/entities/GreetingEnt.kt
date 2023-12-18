package com.lb.functionalities.data.entities

class GreetingEnt {
    private val platform: Platform = getPlatform()

    fun greet(): String {
        return "Hello, ${platform.name}!"
    }
}