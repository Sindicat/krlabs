package com.github.sindicat

import org.junit.Assert
import org.junit.jupiter.api.Test


class CosFunctionTest {

    @Test
    fun test1() {
        Assert.assertTrue(kotlin.math.cos(1.0).round(3).compareTo(cos(1.0, 3)) == 0)
    }

    @Test
    fun test2() {
        Assert.assertTrue(kotlin.math.cos(5215324.42).round(3).compareTo(cos(5215324.42, 3)) == 0)
    }

    @Test
    fun test3() {
        Assert.assertTrue(kotlin.math.cos(-0.42).round(5).compareTo(cos(-0.42, 5)) == 0)
    }

    @Test
    fun test4() {
        Assert.assertTrue(kotlin.math.cos(0.0).round(1).compareTo(cos(0.0, 1)) == 0)
    }

    @Test
    fun test5() {
        Assert.assertTrue(kotlin.math.cos(Math.PI / 2 ).round(10).compareTo(cos(Math.PI / 2, 10)) == 0)
    }

    @Test
    fun test6() {
        Assert.assertTrue(kotlin.math.cos(Math.PI).round(10).compareTo(cos(Math.PI, 10)) == 0)
    }

    @Test
    fun test7() {
        Assert.assertTrue(kotlin.math.cos(1.5 * Math.PI).round(10).compareTo(cos(1.5 * Math.PI, 10)) == 0)
    }
}