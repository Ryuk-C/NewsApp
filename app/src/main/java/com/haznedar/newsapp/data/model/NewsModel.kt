package com.haznedar.newsapp.data.model

import com.google.gson.annotations.SerializedName

data class NewsModel(
    @SerializedName("nextPage")
    val nextPage: Any?,
    @SerializedName("results")
    val results: List<Result?>?,
    @SerializedName("status")
    val status: String?,
    @SerializedName("totalResults")
    val totalResults: Int?
) {
    data class Result(
        @SerializedName("category")
        val category: List<String?>?,
        @SerializedName("content")
        val content: String?,
        @SerializedName("country")
        val country: List<String?>?,
        @SerializedName("creator")
        val creator: List<String?>?,
        @SerializedName("description")
        val description: String?,
        @SerializedName("image_url")
        val imageUrl: String?,
        @SerializedName("keywords")
        val keywords: List<String?>?,
        @SerializedName("language")
        val language: String?,
        @SerializedName("link")
        val link: String?,
        @SerializedName("pubDate")
        val pubDate: String?,
        @SerializedName("source_id")
        val sourceId: String?,
        @SerializedName("title")
        val title: String?,
        @SerializedName("video_url")
        val videoUrl: Any?
    )
}