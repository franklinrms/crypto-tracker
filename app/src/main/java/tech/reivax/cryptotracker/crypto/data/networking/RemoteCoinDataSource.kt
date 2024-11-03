package tech.reivax.cryptotracker.crypto.data.networking

import io.ktor.client.HttpClient
import io.ktor.client.request.get
import tech.reivax.cryptotracker.core.data.networking.constructUrl
import tech.reivax.cryptotracker.core.data.networking.safeCall
import tech.reivax.cryptotracker.core.domain.util.NetworkError
import tech.reivax.cryptotracker.core.domain.util.Result
import tech.reivax.cryptotracker.core.domain.util.map
import tech.reivax.cryptotracker.crypto.data.mappers.toCoin
import tech.reivax.cryptotracker.crypto.data.networking.dto.CoinsResponseDto
import tech.reivax.cryptotracker.crypto.domain.Coin
import tech.reivax.cryptotracker.crypto.domain.CoinDataSource

class RemoteCoinDataSource(
    private val httpClient: HttpClient
): CoinDataSource {
    override suspend fun getCoins(): Result<List<Coin>, NetworkError> {
        return safeCall<CoinsResponseDto> {
            httpClient.get(
                urlString = constructUrl("/assets")
            )
        }.map { response ->
            response.data.map { it.toCoin() }
        }
    }

}