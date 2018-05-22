package com.example.dicoding.spektesting

import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.given
import org.jetbrains.spek.api.dsl.it
import org.jetbrains.spek.api.dsl.on
import org.junit.Assert.assertEquals
import org.junit.platform.runner.JUnitPlatform
import org.junit.runner.RunWith

@RunWith(JUnitPlatform::class)
class SampleTestSpek : Spek({

    given("Calkulator") {
        on("Multiply") {
            val result = 2 * 3
            it("result of multiply") {
                assertEquals(6, result)
            }
        }

        on("Add") {
            val result = 2 + 3
            it("result of add"){
                assertEquals(5 , result)
            }
        }
    }
})