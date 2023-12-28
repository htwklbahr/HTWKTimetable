package com.lb.shared.functionalities.lectures

class GreetingFuncLectures {
    private val platform: Platform = getPlatformFuncLect()

    fun greet(): String {
        return "Hello, ${platform.name}!"
    }
}