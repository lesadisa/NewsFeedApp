package com.example.feature.data.api.model

import com.google.gson.annotations.SerializedName

class ApiSourceModel(
    @SerializedName("id")
    val id: String?,

    @SerializedName("name")
    val name: String,

    )