package tech.reivax.cryptotracker.crypto.presentation.coin_list

import tech.reivax.cryptotracker.crypto.presentation.models.CoinUi

sealed interface CoinListAction {
    data class OnCoinClick(val coinUi: CoinUi): CoinListAction
}