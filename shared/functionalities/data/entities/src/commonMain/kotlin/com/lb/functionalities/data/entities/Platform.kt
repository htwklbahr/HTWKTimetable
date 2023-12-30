package com.lb.functionalities.data.entities

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform