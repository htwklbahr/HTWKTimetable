package com.lb.shared.functionalities.lectures

import platform.UIKit.UIDevice

class IOSPlatform: Platform {
    override val name: String = UIDevice.currentDevice.systemName() + " " + UIDevice.currentDevice.systemVersion
}

actual fun getPlatformFuncLect(): Platform = IOSPlatform()