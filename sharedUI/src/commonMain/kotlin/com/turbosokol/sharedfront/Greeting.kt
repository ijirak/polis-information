package com.turbosokol.sharedfront

class Greeting {
    private val platform: Platform = getPlatform()

    fun greet(): String {
        return "Hello, 