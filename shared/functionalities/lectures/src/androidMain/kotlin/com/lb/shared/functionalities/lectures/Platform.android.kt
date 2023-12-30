package com.lb.shared.functionalities.lectures

class AndroidPlatform : Platform {
    override val name: String = "Android ${android.os.Build.VERSION.SDK_INT}"
}

actual fun getPlatformFuncLect(): Platform = AndroidPlatform()