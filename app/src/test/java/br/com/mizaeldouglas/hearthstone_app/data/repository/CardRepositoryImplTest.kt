package br.com.mizaeldouglas.hearthstone_app.data.repository

import br.com.mizaeldouglas.hearthstone_app.data.api.HeathstoneService
import br.com.mizaeldouglas.hearthstone_app.data.dto.CardDTO
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import okhttp3.ResponseBody
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config
import retrofit2.Response

@ExperimentalCoroutinesApi
@RunWith(RobolectricTestRunner::class)
@Config(sdk = [28], manifest = Config.NONE)
class CardRepositoryImplTest {

    @Mock
    private lateinit var heathstoneService: HeathstoneService
    private lateinit var cardRepositoryImpl: CardRepositoryImpl

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        cardRepositoryImpl = CardRepositoryImpl(heathstoneService)
    }

    @Test
    fun `getCards should return list of cards when API call is successful`() = runTest {
        val mockCards = listOf(CardDTO(1, "cardId", "cardSet", 1, "flavor", 1, "img", "name", "type"))
        `when`(heathstoneService.getCards("Journey to Un'Goro")).thenReturn(Response.success(mockCards))

        val result = cardRepositoryImpl.getCards()

        Assert.assertEquals(mockCards, result)
    }

    @Test
    fun `getCards should return empty list when API call is unsuccessful`() = runTest {
        `when`(heathstoneService.getCards("Journey to Un'Goro")).thenReturn(Response.error(404, ResponseBody.create(null, "")))

        val result = cardRepositoryImpl.getCards()

        Assert.assertTrue(result.isEmpty())
    }

    @Test
    fun `getCards should return empty list when API response body is null`() = runTest {
        `when`(heathstoneService.getCards("Journey to Un'Goro")).thenReturn(Response.success(null))

        val result = cardRepositoryImpl.getCards()

        Assert.assertTrue(result.isEmpty())
    }
}