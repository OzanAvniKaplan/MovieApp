package com.ozan.movieapp.data.response.details.tvdetail

import com.google.gson.annotations.SerializedName

data class CreatedByItem(

    @field:SerializedName("credit_id")
    val creditId: String? = null,

    @field:SerializedName("name")
    val name: String? = null,

    @field:SerializedName("profile_path")
    val profilePath: Any? = null,

    @field:SerializedName("id")
    val id: Int? = null
)