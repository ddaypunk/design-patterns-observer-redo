package display

import Display
import Observer
import data.WeatherData

class StatisticsDisplay(private val data: WeatherData) : Observer, Display {
    private val temperatures: MutableList<Float> = mutableListOf()
    private var average: Float = 0F
    private var minimum: Float = 0F
    private var maximum: Float = 0F

    init {
        data.registerObserver(this)
    }

    override fun update() {
        temperatures.add(data.temperature)
        this.average = getAverage()
        this.minimum = getMinimum()
        this.maximum = getMaximum()

        display()
    }

    private fun getAverage(): Float {
        val numerator = temperatures.reduce { acc, temp -> acc + temp }
        return numerator / temperatures.size
    }

    private fun getMinimum(): Float {
        return temperatures.minOf { it }
    }

    private fun getMaximum(): Float {
        return temperatures.maxOf { it }
    }

    override fun display() {
        println(
            "Avg/Max/Min temperature = ${average}/${maximum}/${minimum}"
        )
    }
} 