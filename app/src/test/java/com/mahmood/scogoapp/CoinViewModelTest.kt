//package com.mahmood.scogoapp
//
//import com.mahmood.scogoapp.repository.CoinRepository
//import com.mahmood.scogoapp.viewmodel.CoinViewModel
//import kotlinx.coroutines.runBlocking
//import org.junit.Before
//import org.junit.Test
//import androidx.arch.core.executor.testing.InstantTaskExecutorRule
//import org.junit.Assert.assertEquals
//import org.junit.Rule
//import org.mockito.junit.MockitoJUnitRunner
//import org.junit.runner.RunWith
//import org.mockito.Mockito.mock
//import org.mockito.kotlin.whenever
//
//@RunWith(MockitoJUnitRunner::class)
//class CoinViewModelTest {
//
//    @get:Rule
//    val instantTaskExecutorRule = InstantTaskExecutorRule()
//
//    private lateinit var repository: CoinRepository
//    private lateinit var viewModel: CoinViewModel
//
//    @Before
//    fun setUp() {
//        repository = mock()
//        viewModel = CoinViewModel(repository)
//    }
//
//    @Test
//    fun `fetchCoins success updates LiveData`() = runBlocking {
//        val sampleCoins = listOf(
//            coin(
//                id = "btc-bitcoin",
//                name = "Bitcoin",
//                symbol = "BTC",
//                rank = 1,
//                logo = "https://static.coinpaprika.com/coin/btc-bitcoin/logo.png"
//            ),
//            coin(
//                id = "eth-ethereum",
//                name = "Ethereum",
//                symbol = "ETH",
//                rank = 2,
//                logo = "https://static.coinpaprika.com/coin/eth-ethereum/logo.png"
//            )
//        )
//        whenever(repository.getCoins()).thenReturn(sampleCoins)
//
//        viewModel.fetchCoins()
//
//        assertEquals(sampleCoins, viewModel.coinList.value)
//    }
//
//
//    @Test
//    fun `fetchCoins failure logs error`() = runBlocking {
//        val errorMessage = "Error fetching coins"
//        whenever(repository.getCoins()).thenThrow(RuntimeException(errorMessage))
//
//        try {
//            viewModel.fetchCoins()
//        } catch (e: RuntimeException) {
//            assertEquals(errorMessage, e.message)
//        }
//
//    }
//}
//
