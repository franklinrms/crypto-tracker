package tech.reivax.cryptotracker.crypto.data.mappers

import tech.reivax.cryptotracker.crypto.data.networking.dto.CoinDto
import tech.reivax.cryptotracker.crypto.data.networking.dto.CoinPriceDto
import tech.reivax.cryptotracker.crypto.domain.Coin
import tech.reivax.cryptotracker.crypto.domain.CoinPrice
import java.time.Instant
import java.time.ZoneId

fun CoinDto.toCoin(): Coin {
    return Coin(
        id = id,
        rank = rank,
        name = name,
        symbol = symbol,
        marketCapUsd = marketCapUsd,
        priceUsd = priceUsd,
        changePercent24Hr = changePercent24Hr
    )
}

fun CoinPriceDto.toCoinPrice(): CoinPrice {
    return CoinPrice(
        priceUsd = priceUsd,
        dateTime = Instant
            .ofEpochMilli(time)
            .atZone(ZoneId.of("UTC"))
    )
}