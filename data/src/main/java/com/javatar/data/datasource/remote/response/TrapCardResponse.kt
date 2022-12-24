package com.javatar.data.datasource.remote.response

import com.javatar.domain.models.TrapCard
import com.javatar.domain.value

class TrapCardResponse : CardResponse()

fun TrapCardResponse.toTrapCard() = TrapCard(
    id = id.value(),
    name = name.value(),
    type = type.value(),
    desc = desc.value(),
    race = race.value(),
    images = images?.map { it.toImage() } ?: emptyList(),
)

