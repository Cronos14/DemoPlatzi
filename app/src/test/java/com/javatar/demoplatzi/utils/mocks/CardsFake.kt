package com.javatar.demoplatzi.utils.mocks

import com.javatar.demoplatzi.component.CardComponent
import com.javatar.demoplatzi.component.MonsterCardComponent
import com.javatar.demoplatzi.component.SpellCardComponent
import com.javatar.demoplatzi.component.TrapCardComponent
import com.javatar.domain.models.*

val cardFake = Card(
    "id",
    "name",
    "trap card",
    "description",
    "dark",
    listOf(Image("123", "https://www.google.com", "https://www.google.com")),
)

val cardComponentFake = CardComponent(
    "name",
    "description",
    "trap card",
    "description",
    "dark",
    "https://www.google.com",
    "https://www.google.com",
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

val monsterCardComponentFake = MonsterCardComponent(
    "12345",
    "name",
    "description",
    1000,
    500,
    2,
    "dark",
    "monster card",
    "123",
    "https://www.google.com",
    "https://www.google.com",
    "dark",
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

val spellCardComponentFake = SpellCardComponent(
    "name",
    "description",
    "spell card",
    "description",
    "dark",
    "123",
    "https://www.google.com",
    "https://www.google.com",
    "fire"
)

val trapCardFake = TrapCard(
    "id",
    "name",
    "trap card",
    "description",
    "dark",
    listOf(Image("123", "https://www.google.com", "https://www.google.com")),
)

val trapCardComponentFake = TrapCardComponent(
    "name",
    "description",
    "trap card",
    "description",
    "dark",
    "123",
    "https://www.google.com",
    "https://www.google.com"
)