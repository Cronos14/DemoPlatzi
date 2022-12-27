package com.javatar.data.datasource.remote.response

import com.google.gson.annotations.SerializedName
import com.javatar.domain.models.Card
import com.javatar.domain.models.Image
import com.javatar.domain.value

open class CardResponse(
    open val id: String?,
    open val name: String?,
    open val type: String?,
    open val desc: String?,
    open val race: String?,
    @SerializedName("card_images")
    open val images: List<ImageResponse>?
) {
    open val archetype: String? = null
    open val atk: Int? = null
    open val def: Int? = null
    open val level: Int? = null
    open val attribute: String? = null
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

fun CardResponse.toMonsterResponse() = MonsterCardResponse(
    id = id,
    name = name,
    type = type,
    desc = desc,
    race = race,
    images = images,
    archetype = archetype,
    atk = atk,
    def = def,
    level = level,
    attribute = attribute
)

fun CardResponse.toSpellResponse() = SpellCardResponse(
    id = id,
    name = name,
    type = type,
    desc = desc,
    race = race,
    images = images,
    archetype = archetype,
)

fun CardResponse.toTrapResponse() = TrapCardResponse(
    id = id,
    name = name,
    type = type,
    desc = desc,
    race = race,
    images = images,
)