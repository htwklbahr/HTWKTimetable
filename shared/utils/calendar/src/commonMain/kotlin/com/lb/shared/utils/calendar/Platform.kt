package com.lb.shared.utils.calendar

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform