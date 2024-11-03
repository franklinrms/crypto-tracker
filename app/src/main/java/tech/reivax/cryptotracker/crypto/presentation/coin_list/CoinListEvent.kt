package tech.reivax.cryptotracker.crypto.presentation.coin_list

import tech.reivax.cryptotracker.core.domain.util.NetworkError

sealed interface CoinListEvent {
    data class Error(val error: NetworkError): CoinListEvent
}