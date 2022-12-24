package com.javatar.data.datasource.local

data class CardLocalDatasourceFacade(
    val monsterCardLocalDatasource: MonsterCardLocalDataSource,
    val spellCardLocalDatasource: SpellCardLocalDataSource,
    val trapCardLocalDatasource: TrapCardLocalDataSource
)