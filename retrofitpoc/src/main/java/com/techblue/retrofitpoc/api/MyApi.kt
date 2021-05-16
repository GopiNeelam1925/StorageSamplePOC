package com.techblue.retrofitpoc.api

import com.techblue.retrofitpoc.models.Sample
import okhttp3.MultipartBody
import okhttp3.RequestBody
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.*

interface MyApi {

    @GET("getAllDocs")
    fun getAllDocs(): Call<List<String>>

    @GET("getDoc/{ docId }")
    fun getSingleDoc(@Path("dicId") docId: Int): Call<String>

    @GET("getAllDocs")
    fun getAllDocsWithFilter(@Query("filter") filter: String): Call<String>

    @POST("addNewDoc")
    fun addNewDoc(@Body sample: Sample): Call<ResponseBody>

    @Multipart
    @POST("upload")
    fun uploadImage(
        @Part("desc") description: RequestBody,
        @Part photo: MultipartBody.Part
    )
}