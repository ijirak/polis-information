
package com.turbosokol.sharedfront

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform