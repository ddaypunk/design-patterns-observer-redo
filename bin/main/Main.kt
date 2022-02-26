import data.WeatherData
import display.CurrentConditionsDisplay
import display.ForecastDisplay
import display.HeatIndexDisplay
import display.StatisticsDisplay

fun main(args: Array<String>) {
    val data = WeatherData()
    val current = CurrentConditionsDisplay(data)
    val statistics = StatisticsDisplay(data)
    val forecast = ForecastDisplay(data)
    val heatIndex = HeatIndexDisplay(data)

    data.setMeasurements(80F, 65F, 30.4F)
    data.setMeasurements(82F, 70F, 29.2F)
    data.setMeasurements(78F, 90F, 29.2F)
}