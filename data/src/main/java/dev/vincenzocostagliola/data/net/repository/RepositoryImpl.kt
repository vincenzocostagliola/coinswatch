package dev.vincenzocostagliola.data.net.repository

import dev.vincenzocostagliola.data.net.service.CoinsService

internal class RepositoryImpl(
    private val coinsService: CoinsService
) : Repository {
}