package by.mark.myapplication

import com.google.gson.annotations.SerializedName

data class Product(
    @SerializedName("product_id") val id: String,
    val name: String,
    val price: String,
    @SerializedName("image") val imageUrl: String
)