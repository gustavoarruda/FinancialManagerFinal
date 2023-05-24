class FinancialManager {
    private val assets: MutableList<FinancialAsset> = mutableListOf()
    private val transactions: MutableList<Transaction> = mutableListOf()
    private var balance: Double = 0.0

    fun addAsset(asset: FinancialAsset) {
        assets.add(asset)
    }

    fun addTransaction(transaction: Transaction) {
        transactions.add(transaction)
        balance += transaction.amount
    }

    fun getTransactions(): MutableList<Transaction> {
        return transactions
    }

    fun getAssets(): MutableList<FinancialAsset> {
        return assets
    }

    fun getAssetValue(type: String? = null): Double {
        var assetValue = 0.0
        for (asset in assets) {
            assetValue += asset.quantity * asset.price
        }
        return assetValue
    }

    fun getCurrentBalance(): Double {
        return balance
    }

    fun printSummary() {
        println("Resumo Financeiro:")
        println("Saldo: $${getCurrentBalance()}")
        println("Valores de Ativos: $${getAssetValue()}")
        println("Ativos:")
        for (asset in assets) {
            println("${asset.name} (${asset.type}): ${asset.quantity} * $${asset.price}")
        }
        println("Transação:")
        for (transaction in transactions) {
            println("${transaction.date}: ${transaction.asset.name} - $${transaction.amount}")
        }
    }

}