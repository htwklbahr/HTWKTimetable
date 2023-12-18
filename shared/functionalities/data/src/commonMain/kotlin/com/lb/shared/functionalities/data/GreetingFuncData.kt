package com.lb.shared.functionalities.data

class GreetingFuncData {
    private val platform: Platform = getPlatform()

    fun greet(): String {
        return "Hello, ${platform.name}!"
    }
}