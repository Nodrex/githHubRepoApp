package com.flatrocktech.nodrex.util

import android.util.Log
import com.flatrocktech.nodrex.config.AppConfig

class Util {

    companion object {
        fun log(text: String) = Log.d(AppConfig.LOG_TAG, text)
    }
}