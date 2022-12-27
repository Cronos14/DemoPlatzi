package com.javatar.domain.error

sealed class CardError(message: String)

class Empty(message: String = "") : CardError(message)
