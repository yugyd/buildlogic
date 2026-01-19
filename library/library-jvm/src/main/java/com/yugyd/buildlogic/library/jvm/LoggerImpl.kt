package com.yugyd.buildlogic.library.jvm

class LoggerImpl : Logger {

    override fun log(msg: String) {
        println(msg)
    }
}
