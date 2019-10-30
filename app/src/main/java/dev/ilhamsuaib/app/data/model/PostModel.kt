package dev.ilhamsuaib.app.data.model

import com.google.gson.annotations.SerializedName

/**
 * Created by @ilhamsuaib on 2019-10-30.
 * github.com/ilhamsuaib
 */

data class PostModel(
    @field:SerializedName("id")
    val id: Int,
    @field:SerializedName("userId")
    val userId: Int,
    @field:SerializedName("title")
    val title: String,
    @field:SerializedName("body")
    val body: String
)