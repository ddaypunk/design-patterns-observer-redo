package display

import Display
import Observer
import data.WeatherData
import kotlin.properties.Delegates

class CurrentConditionsDisplay(private val data: WeatherData) : Observer, Display {
    private var temperature by Delegates.notNull<Float>()
    private var humidity by Delegates.notNull<Float>()

    init {
        data.registerObserver(this)
    }

    override fun update() {
        this.temperature = data.temperature
        this.humidity = data.humidity
        display()
    }

    override fun display() {
        println(
            "Current conditions: ${temperature}F degrees and ${humidity}% humidity"
        )
    }
} 