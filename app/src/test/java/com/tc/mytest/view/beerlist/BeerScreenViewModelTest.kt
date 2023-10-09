import com.tc.mytest.data.model.beer.BeerItemModel
import com.tc.mytest.data.remote.ApiRequest
import com.tc.mytest.data.repository.Repository
import com.tc.mytest.data.repository.RepositoryImpl
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runBlockingTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations

// ...

class BeerScreenViewModelTest {

    private lateinit var repository: Repository

    @Mock
    private lateinit var apiRequest: ApiRequest

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
        Dispatchers.setMain(Dispatchers.Unconfined)
        repository = RepositoryImpl(apiRequest)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun `test getBeers`() = runBlockingTest {
        // Mock data for testing
        val mockBeers = listOf(
            BeerItemModel(id = 1, name = "Beer 1"),
            BeerItemModel(id = 2, name = "Beer 2")
        )

        // Mock the repository call
        `when`(apiRequest.getBeers()).thenReturn(mockBeers)

        // Call the Repository function
        val result = repository.getBeers()

        // Assert the result
        assertEquals(mockBeers, result)
    }

    @Test
    fun `test getBeerItem`() = runBlockingTest {
        // Mock data for testing
        val beerId = 1
        val mockBeerItem = BeerItemModel(id = beerId, name = "Mock Beer")

        // Mock the repository call
        `when`(apiRequest.getBeerItem(beerId)).thenReturn(listOf(mockBeerItem))

        // Call the Repository function
        val result = repository.getBeerItem(beerId)

        // Assert the result
        assertEquals(listOf(mockBeerItem), result)
    }
}
