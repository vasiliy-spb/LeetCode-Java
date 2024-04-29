package matrix.workingPeoplesImitation.task_2469_Convert_the_Temperature;

import java.util.function.Function;

public class Solution {
    // my solution
    public double[] convertTemperature(double celsius) {
        Function<Double, Double> convertToKelvin = a -> a + 273.15;
        Function<Double, Double> convertToFahrenheit = a -> a * 1.8 + 32;
        double kelvin = convertToKelvin.apply(celsius);
        double fahrenheit = convertToFahrenheit.apply(celsius);
        return new double[]{kelvin, fahrenheit};
    }
}
