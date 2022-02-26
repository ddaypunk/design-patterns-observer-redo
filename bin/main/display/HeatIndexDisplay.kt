package display

import Display
import Observer
import data.WeatherData
import kotlin.properties.Delegates

class HeatIndexDisplay(private val data: WeatherData) : Observer, Display {
    private var temperature by Delegates.notNull<Float>()
    private var humidity by Delegates.notNull<Float>()
    private var index by Delegates.notNull<Float>()

    init {
        data.registerObserver(this)
    }

    override fun update() {
        this.temperature = data.temperature
        this.humidity = data.humidity
        this.index = computeHeatIndex(this.temperature, this.humidity)
        display()
    }

    override fun display() {
        println("Heat index is $index")
    }

    private fun computeHeatIndex(temperature: Float, relativeHumidity: Float): Float {
        return (16.923 + 0.185212 * temperature + 5.37941 * relativeHumidity - 0.100254 * temperature * relativeHumidity +
                0.00941695 * (temperature * temperature) + 0.00728898 * (relativeHumidity * relativeHumidity) +
                0.000345372 * (temperature * temperature * relativeHumidity) - 0.000814971 * (temperature * relativeHumidity * relativeHumidity) +
                0.0000102102 * (temperature * temperature * relativeHumidity * relativeHumidity) - 0.000038646 * (temperature * temperature * temperature) + 0.0000291583 *
                (relativeHumidity * relativeHumidity * relativeHumidity) + 0.00000142721 * (temperature * temperature * temperature * relativeHumidity) +
                0.000000197483 * (temperature * relativeHumidity * relativeHumidity * relativeHumidity) - 0.0000000218429 * (temperature * temperature * temperature * relativeHumidity * relativeHumidity) +
                0.000000000843296 * (temperature * temperature * relativeHumidity * relativeHumidity * relativeHumidity) -
                0.0000000000481975 * (temperature * temperature * temperature * relativeHumidity * relativeHumidity * relativeHumidity)).toFloat()
    }
}