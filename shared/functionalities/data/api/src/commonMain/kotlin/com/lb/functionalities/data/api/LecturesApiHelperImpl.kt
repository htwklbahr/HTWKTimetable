package com.lb.functionalities.data.api

import com.lb.functionalities.data.api.model.PlaceholderObject

internal class LecturesApiHelperImpl : ApiHelper {
    override suspend fun getPlaceholderData(): List<PlaceholderObject> {
        return LecturesApiService().getPlaceholderData()
    }
}