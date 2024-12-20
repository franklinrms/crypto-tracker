package tech.reivax.cryptotracker

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import org.koin.androidx.compose.koinViewModel
import tech.reivax.cryptotracker.core.navigation.AdaptiveCoinListDetailPane
import tech.reivax.cryptotracker.core.presentation.util.ObserveAsEvents
import tech.reivax.cryptotracker.core.presentation.util.toString
import tech.reivax.cryptotracker.crypto.presentation.coin_detail.CoinDetailScreen
import tech.reivax.cryptotracker.crypto.presentation.coin_list.CoinListEvent
import tech.reivax.cryptotracker.crypto.presentation.coin_list.CoinListScreen
import tech.reivax.cryptotracker.crypto.presentation.coin_list.CoinListViewModel
import tech.reivax.cryptotracker.ui.theme.CryptoTrackerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CryptoTrackerTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    AdaptiveCoinListDetailPane(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}
