import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);

            System.out.println("=== Conversor de Monedas ===");
            System.out.print("Ingrese la moneda base (ejemplo: USD): ");
            String baseCurrency = scanner.nextLine().toUpperCase();

            CurrencyConverter converter = new CurrencyConverter(baseCurrency);

            System.out.print("Ingrese la moneda de destino (ejemplo: EUR): ");
            String targetCurrency = scanner.nextLine().toUpperCase();

            System.out.print("Ingrese el monto a convertir: ");
            double amount = scanner.nextDouble();

            double result = converter.convert(baseCurrency, targetCurrency, amount);
            System.out.printf("El monto convertido es: %.2f %s%n", result, targetCurrency);

        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Ocurrió un error: " + e.getMessage());
        }
    }
}
