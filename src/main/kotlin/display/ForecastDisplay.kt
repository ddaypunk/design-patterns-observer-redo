package display

import Display
import Observer
import data.WeatherData

class ForecastDisplay(private val data: WeatherData) : Observer, Display {
    private var pressure: Float = 0F
    private var previous: Float = 0F

    init {
        data.registerObserver(this)
    }

    override fun update() {
        this.previous = this.pressure
        this.pressure = data.pressure
        display()
    }

    override fun display() {
        this.pressure.compareTo(previous).let {
            when {
                it == 0 -> println("Forecast: More of the same")
                it > 0 -> println("Forecast: Improving weather on the way!")
                else -> println("Forecast: Watch out for cooler, rainy weather...")
            }
        }
    }
} 