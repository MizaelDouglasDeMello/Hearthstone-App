package br.com.mizaeldouglas.hearthstone_app.data.api

import br.com.mizaeldouglas.hearthstone_app.utils.Constants.KEY
import okhttp3.Interceptor
import okhttp3.Response

class BaseInterceptor: Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request().newBuilder()

        request.addHeader("x-rapidapi-key" , KEY)
        request.addHeader("x-rapidapi-host", "omgvamp-hearthstone-v1.p.rapidapi.com")

        return chain.proceed(request.build())
    }

}