package com.lb.shared.functionalities.data

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform