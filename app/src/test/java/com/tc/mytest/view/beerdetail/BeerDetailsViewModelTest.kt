import androidx.lifecycle.Observer
import com.tc.mytest.data.model.beer.BeerItemModel
import com.tc.mytest.data.repository.Repository
import com.tc.mytest.view.beerdetail.BeerDetailsViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.TestCoroutineScope
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

@ExperimentalCoroutinesApi
class BeerDetailsViewModelTest {



    private lateinit var viewModel: BeerDetailsViewModel

    @Mock
    private lateinit var repository: Repository

    @Mock
    private lateinit var beerDetailsObserver: Observer<BeerItemModel>

    private val testDispatcher = TestCoroutineDispatcher()
    private val testScope = TestCoroutineScope(testDispatcher)

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
        viewModel = BeerDetailsViewModel(repository)
        viewModel.beerDetails.observeForever(beerDetailsObserver)
    }

    @Test
    fun `getBeerItem`() = testScope.runBlockingTest {
        // Define a mock beer item
        val mockBeerItem = BeerItemModel(
            // Define properties as needed
        )

        // Mock the behavior of the repository's getBeerItem function
        val beerId = 1
        Mockito.`when`(repository.getBeerItem(beerId)).thenReturn(listOf(mockBeerItem))

        // Call the function to be tested
        viewModel.getBeerItem(beerId)

        // Advance until all coroutines are done
        testDispatcher.advanceUntilIdle()

        // Verify the expected behavior

        // For example, you can assert that the LiveData in the ViewModel has been updated with the mock beer item
        Mockito.verify(beerDetailsObserver).onChanged(mockBeerItem)
    }
}
