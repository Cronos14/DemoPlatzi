package com.javatar.domain.models

data class TrapCard(
    override val id: String,
    override val name: String,
    override val type: String,
    override val desc: String,
    override val race: String,
    override val images: List<Image>,
) : Card(id, name, type, desc, race, images)
