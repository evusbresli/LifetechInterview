package by.mark.myapplication

import retrofit2.http.GET

interface Api {

    @GET("developer-application-test/cart/list")
    suspend fun getProducts(): Products
}