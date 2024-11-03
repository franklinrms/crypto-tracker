package tech.reivax.cryptotracker.crypto.domain

import tech.reivax.cryptotracker.core.domain.util.NetworkError
import tech.reivax.cryptotracker.core.domain.util.Result

interface CoinDataSource {
    suspend fun getCoins(): Result<List<Coin>, NetworkError>
}