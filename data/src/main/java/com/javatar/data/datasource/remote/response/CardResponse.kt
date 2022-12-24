package com.javatar.data.datasource.remote.response

import com.google.gson.annotations.SerializedName
import com.javatar.domain.models.Card
import com.javatar.domain.models.Image
import com.javatar.domain.value

abstract class CardResponse {
    val id: String? = null
    val name: String? = null
    val type: String? = null
    val desc: String? = null
    val race: String? = null
    @SerializedName("card_images")
    val images: List<ImageResponse>? = null
}

data class ImageResponse(
    val id: String?,
    @SerializedName("image_url")
    val url: String?,
    @SerializedName("image_url_small")
    val urlSmall: String?
)

fun ImageResponse.toImage() = Image(
    id = id.value(),
    url = url.value(),
    urlSmall = urlSmall.value()
)

fun CardResponse.toCard() = Card(
    id = id.value(),
    name = name.value(),
    type = type.value(),
    desc = desc.value(),
    race = race.value(),
    images = images?.map { it.toImage() } ?: emptyList()
)