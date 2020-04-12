package com.github.sindicat.lab5.measures

import java.math.BigDecimal

enum class MeterMeasure(val value: String, override val meterValue: BigDecimal): MeterMeasurementAware {

    METER("метров", BigDecimal.ONE),
    CENTIMETER("сантиметров", BigDecimal(0.01)),
    KILOMETER("километров", BigDecimal(1000.0)),
    MILLIMETER("миллиметров", BigDecimal(0.001));

    companion object {
        private val METER_VALUE_BY_NAME:Map<String, MeterMeasure> = values()
                .map { it.value to it }
                .toMap()

        fun getMeterValueByName(name: String): MeterMeasure? = METER_VALUE_BY_NAME[name]
    }
}