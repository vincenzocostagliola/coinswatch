package dev.vincenzocostagliola.data.net.interceptor

import dev.vincenzocostagliola.data.net.NetHelper
import okhttp3.Interceptor
import okhttp3.Response
import java.io.IOException
import javax.inject.Inject

class ApiHeaderInterceptor @Inject constructor() : Interceptor {

    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        return chain.proceed(
            request.newBuilder()
                .addHeader("accept", "application/json")
                .addHeader("x-cg-demo-api-key", NetHelper.APIKEY)
                .build()
        )
    }
}
