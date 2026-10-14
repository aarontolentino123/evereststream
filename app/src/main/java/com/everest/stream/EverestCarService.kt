package com.everest.stream

import com.google.android.apps.auto.sdk.CarActivity
import com.google.android.apps.auto.sdk.CarActivityService

class EverestCarService : CarActivityService() {
    override fun getCarActivity(): Class<out CarActivity> {
        return EverestCarActivity::class.java
    }
}
