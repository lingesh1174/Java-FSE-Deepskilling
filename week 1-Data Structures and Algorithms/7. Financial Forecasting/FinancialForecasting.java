public class FinancialForecasting {
    public static void main(String[] args) {
        double presentValue = 10000.0;
        double growthRate = 0.08;
        int years = 5;
        double futureValue = Forecast.forecastValueRecursive(presentValue, growthRate, years);
        System.out.println("Future Value (Recursive): " + futureValue);
        double memoizedValue = Forecast.forecastValueMemoized(presentValue, growthRate, years, new double[years + 1]);
        System.out.println("Future Value (Memoized): " + memoizedValue);
    }
}

class Forecast {
    public static double forecastValueRecursive(double pv, double r, int n) {
        if (n==0)
            return pv;
        return (1+r) * forecastValueRecursive(pv, r, n-1);
    }
    public static double forecastValueMemoized(double pv, double r, int n, double[] memo) {
        if (n==0) 
            return pv;
        if (memo[n] != 0) 
            return memo[n];
        memo[n] = (1+r) * forecastValueMemoized(pv, r, n-1, memo);
        return memo[n];
    }
}