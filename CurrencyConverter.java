import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class CurrencyConverter {
    private JsonObject rates;

    public CurrencyConverter(String baseCurrency) throws Exception {
        String response = ApiClient.getExchangeRates(baseCurrency);
        JsonObject jsonResponse = JsonParser.parseString(response).getAsJsonObject();
        if (!"success".equalsIgnoreCase(jsonResponse.get("result").getAsString())) {
            throw new RuntimeException("Error fetching exchange rates");
        }
        this.rates = jsonResponse.getAsJsonObject("conversion_rates");
    }

    public double convert(String fromCurrency, String toCurrency, double amount) {
        if (!rates.has(fromCurrency) || !rates.has(toCurrency)) {
            throw new IllegalArgumentException("Moneda no válida");
        }
        double rateToBase = rates.get(fromCurrency).getAsDouble();
        double rateToTarget = rates.get(toCurrency).getAsDouble();
        return (amount / rateToBase) * rateToTarget;
    }
}

