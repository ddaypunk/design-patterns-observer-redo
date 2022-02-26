package data

import Observer
import Subject
import kotlin.properties.Delegates

class WeatherData : Subject {
    private val observers: MutableList<Observer> = mutableListOf()

    var temperature: Float = 0F
    var humidity by Delegates.notNull<Float>()
    var pressure by Delegates.notNull<Float>()

    override fun registerObserver(o: Observer) {
        observers.add(o)
    }
    override fun removeObserver(o: Observer) {
        observers.remove(o)
    }

    override fun notifyObservers() {
        observers.forEach {
//            it.update(temperature, humidity, pressure) // prior to pg. 69 "push to pull" refactor
            it.update()
        }
    }

    fun setMeasurements(temperature: Float, humidity: Float, pressure: Float) {
        this.temperature = temperature
        this.humidity = humidity
        this.pressure = pressure
        measurementsChanged()
    }

    private fun measurementsChanged() {
        notifyObservers()
    }
}