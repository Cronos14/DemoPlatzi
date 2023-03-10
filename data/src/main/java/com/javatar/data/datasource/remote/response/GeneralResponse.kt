package com.javatar.data.datasource.remote.response

import com.google.gson.annotations.SerializedName

data class GeneralResponse<T : CardResponse>(
    val data: List<T>?,
    val meta: MetaResponse?
)

data class MetaResponse(
    @SerializedName("next_page")
    val nextPage: String?,
    @SerializedName("next_page_offset")
    val nextPageOffset: Int?,
)