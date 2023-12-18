package com.lb.shared.functionalities.lectures

interface Platform {
    val name: String
}

expect fun getPlatformFuncLect(): Platform