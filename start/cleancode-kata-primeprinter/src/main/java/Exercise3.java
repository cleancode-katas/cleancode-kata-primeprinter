public class Exercise3 {
    /**
     *
     * @param amount price
     * @param type   Account status (NotRegistered = 1, SimpleCustomer = 2,
     *               ValuableCustomer = 3, MostValuableCustomer = 4)
     * @param years  Time in years that the client is our customer
     * @return THE PRICE
     */
    public double calculate(double amount, int type, int years) {
        double result = 0;
        double disc = (years > 5) ? (double) 5 / 100 : (double) years / 100;

        // NotRegistered
        switch (type) {
            case 1:
                result = amount;
                return result;
            case 2:
                result = (amount - (0.1 * amount)) - disc * (amount - (0.1 * amount));
                return result;

            case 3:
                result = (0.7 * amount) - disc * (0.7 * amount);
                return result;

            case 4:
                result = (amount - (0.5 * amount)) - disc * (amount - (0.5 * amount));
                return result;

            default:
                break;
        }
        return result;
    }
}