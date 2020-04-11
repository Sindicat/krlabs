package com.github.sindicat.lab5.measures

import java.math.BigDecimal

enum class EngMeasure(val value: String, override val meterValue: BigDecimal) : MeterMeasurementAware {

    LEAGUE("лиг", BigDecimal(4828.032)),
    NAUTICAL_MILE("морских миль", BigDecimal(1853.257)),
    CABLE("кабельтов", BigDecimal(185.3182)),
    FURLONG("фурлонгов", BigDecimal(201.168)),
    CHAIN("чейнов", BigDecimal(20.1168)),
    ROD("родов", BigDecimal(5.0292)),
    YARD("ярдов", BigDecimal(0.9144)),
    FOOT("футов", BigDecimal(0.3048)),
    HAND("хэндов", BigDecimal(0.1016)),
    BARLEYCORN("барликорнов", BigDecimal(0.0084667)),
    INCH("дюймов", BigDecimal(0.0254)),
    LINE("линий", BigDecimal(0.0021167)),
    POINT("точек", BigDecimal(0.000353)),
    MIL("мил", BigDecimal(0.0000254));

    companion object {
       private val meterValueByName:Map<String, EngMeasure> = values()
                .map { it.value to it }
                .toMap()

        fun getMeterValueByName(name: String): EngMeasure = meterValueByName[name] ?: error("Unknown enum name $name")
    }

}