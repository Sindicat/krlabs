package com.github.sindicat

import org.junit.Assert
import org.junit.Test

class CosFunctionTest {

    @Test
    fun test1(){
        Assert.assertTrue(kotlin.math.cos(0.05).round(5).compareTo(cos(0.05, 5)) == 0)
    }

    @Test
    fun test2(){
        Assert.assertTrue(kotlin.math.cos(5215324.42).round(3).compareTo(cos(5215324.42, 3)) == 0)    }
}