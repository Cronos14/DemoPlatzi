package com.javatar.domain.models

data class MonsterCard(
    override val id: String,
    override val name: String,
    override val type: String,
    override val desc: String,
    override val race: String,
    override val images: List<Image>,
    val archetype: String,
    val atk: Int,
    val def: Int,
    val level: Int,
    val attribute: String
) : Card(id, name, type, desc, race, images)
