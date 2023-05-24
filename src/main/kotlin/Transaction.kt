import java.time.LocalDate

data class Transaction(val date: LocalDate, val asset: FinancialAsset, val amount: Double)