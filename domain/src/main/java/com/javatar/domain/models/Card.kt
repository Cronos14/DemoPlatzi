package com.javatar.domain.models

open class Card(
    open val id: String,
    open val name: String,
    open val type: String,
    open val desc: String,
    open val race: String,
    open val images: List<Image>
)