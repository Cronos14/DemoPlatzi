package com.javatar.data.datasource.remote.response

import com.javatar.domain.models.TrapCard
import com.javatar.domain.value

class TrapCardResponse(
    override val id: String?,
    override val name: String?,
    override val type: String?,
    override val desc: String?,
    override val race: String?,
    override val images: List<ImageResponse>?,
) : CardResponse(id, name, type, desc, race, images)

fun TrapCardResponse.toTrapCard() = TrapCard(
    id = id.value(),
    name = name.value(),
    type = type.value(),
    desc = desc.value(),
    race = race.value(),
    images = images?.map { it.toImage() } ?: emptyList(),
)

