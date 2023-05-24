import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import java.time.LocalDate


class FinancialManagerTest {
    private lateinit var manager: FinancialManager

    @Before
    fun setUp() {
        manager = FinancialManager()
    }

    @Test
    fun testAddAsset() {
        val asset = FinancialAsset("PETR4", "RV", 10, 50.0)
        manager.addAsset(asset)
        assertEquals(1, manager.getAssets().size)
    }

    @Test
    fun testAddTransaction() {
        val asset = FinancialAsset("PETR4", "RV", 10, 50.0)
        val transaction = Transaction(LocalDate.now(), asset, 200.0)
        manager.addTransaction(transaction)
        assertEquals(1, manager.getTransactions().size)
        assertEquals(200.0, manager.getCurrentBalance(), 0.0)
    }

    @Test
    fun testGetAssetValue() {
        val asset1 = FinancialAsset("PETR4", "RV", 10, 50.0)
        val asset2 = FinancialAsset("GOOG", "RV", 5, 40.0)
        manager.addAsset(asset1)
        manager.addAsset(asset2)
        assertEquals(700.0, manager.getAssetValue(), 0.0)
    }

    @Test
    fun testGetCurrentBalance() {
        val asset = FinancialAsset("PETR4", "RV", 10, 50.0)
        val transaction = Transaction(LocalDate.now(), asset, 200.0)
        manager.addTransaction(transaction)
        assertEquals(200.0, manager.getCurrentBalance(), 0.0)
    }
}