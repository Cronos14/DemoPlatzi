package com.javatar.data.repository.utils.mocks

import com.javatar.data.datasource.local.card.MonsterCardEntity
import com.javatar.data.datasource.local.card.SpellCardEntity
import com.javatar.data.datasource.local.card.TrapCardEntity
import com.javatar.domain.models.*

val cardFake = Card(
    "id",
    "name",
    "trap card",
    "description",
    "dark",
    listOf(Image("123", "https://www.google.com", "https://www.google.com")),
)

val monsterCardFake = MonsterCard(
    "12345",
    "name",
    "monster card",
    "description",
    "dark",
    listOf(Image("123", "https://www.google.com", "https://www.google.com")),
    "fire",
    1000,
    500,
    2,
    "fire",
)

val monsterCardEntityFake = MonsterCardEntity(
    "12345",
    "name",
    "monster card",
    "description",
    "dark",
    "123",
    "https://www.google.com",
    "https://www.google.com",
    "fire",
    1000,
    500,
    2,
    "fire",
)

val spellCardFake = SpellCard(
    "id",
    "name",
    "spell card",
    "description",
    "dark",
    listOf(Image("123", "https://www.google.com", "https://www.google.com")),
    "fire",
)

val spellCardEntityFake = SpellCardEntity(
    "id",
    "name",
    "spell card",
    "description",
    "dark",
    "123",
    "https://www.google.com",
    "https://www.google.com",
    "fire",
)

val trapCardFake = TrapCard(
    "id",
    "name",
    "trap card",
    "description",
    "dark",
    listOf(Image("123", "https://www.google.com", "https://www.google.com")),
)

val trapCardEntityFake = TrapCardEntity(
    "id",
    "name",
    "trap card",
    "description",
    "dark",
    "123",
    "https://www.google.com",
    "https://www.google.com",
)