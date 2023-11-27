package com.lb.htwktimetable

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform