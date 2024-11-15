package br.com.mizaeldouglas.hearthstone_app.prensentation.viewModels
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import br.com.mizaeldouglas.hearthstone_app.data.dto.CardDTO
import br.com.mizaeldouglas.hearthstone_app.data.repository.ICardRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.*
import org.junit.*
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.junit.MockitoJUnitRunner

@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
class CardsViewModelTest {

    @get:Rule
    val instantExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var repository: ICardRepository

    private lateinit var viewModel: CardsViewModel

    private val testDispatcher = UnconfinedTestDispatcher()

    @Before
    fun setUp() {
        Dispatchers.setMain(testDispatcher)
        viewModel = CardsViewModel(repository)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun `getCards should update listCards`() = runTest {
        val cardList = listOf(
            CardDTO(1, "card1", "set1", 1, "flavor1", 1, "img1", "name1", "type1"),
            CardDTO(2, "card2", "set2", 2, "flavor2", 2, "img2", "name2", "type2"),
            CardDTO(3, "card3", "set3", 3, "flavor3", 3, "img3", "name3", "type3"),
        )
        `when`(repository.getCards()).thenReturn(cardList)

        val observer = mock(Observer::class.java) as Observer<List<CardDTO>>
        viewModel.listCards.observeForever(observer)

        viewModel.getCards()

        verify(observer).onChanged(cardList)
        Assert.assertEquals(cardList, viewModel.listCards.value)
    }

    @Test
    fun `isLoading should be true while fetching cards`() = runTest {
        val cardList = listOf(
            CardDTO(1, "card1", "set1", 1, "flavor1", 1, "img1", "name1", "type1")
        )
        `when`(repository.getCards()).thenReturn(cardList)

        val observer = mock(Observer::class.java) as Observer<Boolean>
        viewModel.isLoading.observeForever(observer)

        viewModel.getCards()

        verify(observer).onChanged(true)
        verify(observer).onChanged(false)
    }
}