package com.example.footballapp.data.remote

import okhttp3.Interceptor
import okhttp3.Response

class SupportInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        var request = chain.request()
        request = request.newBuilder()
            .addHeader("X-Auth-Token", API_KEY)
            .build()
        return chain.proceed(request)
    }

    companion object {
        const val API_KEY = "148d6e35f35240a886072de28eccb7dc"
    }
}