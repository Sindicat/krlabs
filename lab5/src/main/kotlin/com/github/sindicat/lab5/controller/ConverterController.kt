package com.github.sindicat.lab5.controller

import com.github.sindicat.lab5.measures.EngMeasure
import com.github.sindicat.lab5.measures.MeterMeasure
import com.github.sindicat.lab5.measures.MeterMeasurementAware
import com.github.sindicat.lab5.vo.ConversionResult
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.math.BigDecimal
import java.math.RoundingMode

@RestController
class ConverterController {

    @GetMapping("/convert/to/eng")
    fun convertToEng(
            @RequestParam(value = "inputValue") inputValue: String,
            @RequestParam(value = "inputMeasurement") inputMeasurement: String,
            @RequestParam(value = "outputMeasurement") outputMeasurement: String
    ): ConversionResult {
        val preProcessedInputValue = inputValue.replace(',','.')
        val inputMeasure: MeterMeasurementAware = MeterMeasure.getMeterValueByName(inputMeasurement)!!
        val outputMeasure: MeterMeasurementAware = EngMeasure.getMeterValueByName(outputMeasurement)

        val outputValue = countResult(BigDecimal(preProcessedInputValue), inputMeasure, outputMeasure)
        return ConversionResult(outputValue.toString())
    }

    @GetMapping("/convert/to/meterOrEng")
    fun convertToMeter(
            @RequestParam(value = "inputValue") inputValue: String,
            @RequestParam(value = "inputMeasurement") inputMeasurement: String,
            @RequestParam(value = "outputMeasurement") outputMeasurement: String
    ): ConversionResult {
        val preProcessedInputValue = inputValue.replace(',','.')
        val inputMeasure: MeterMeasurementAware = EngMeasure.getMeterValueByName(inputMeasurement)
        val outputMeasure: MeterMeasurementAware = MeterMeasure.getMeterValueByName(outputMeasurement) ?: EngMeasure.getMeterValueByName(outputMeasurement)

        val outputValue = countResult(BigDecimal(preProcessedInputValue), inputMeasure, outputMeasure)
        return ConversionResult(outputValue.toString())
    }

    private fun countResult(value: BigDecimal, inputMeasure: MeterMeasurementAware, outputMeasure: MeterMeasurementAware): BigDecimal {
        val inputValueInMeters = value * inputMeasure.meterValue
        val outputValue = inputValueInMeters.divide(outputMeasure.meterValue, 4, RoundingMode.HALF_UP)
        return outputValue.apply {
            setScale(4)
        }
    }
}