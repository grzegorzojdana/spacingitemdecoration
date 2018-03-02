package com.grzegorzojdana.spacingitemdecoration

import org.junit.Test

class ItemOffsetsRequestBuilderTest_linearLayout: ItemOffsetsRequestBuilderTestBase() {

    @Test
    fun vertical() {
        val params = ItemOffsetsRequestBuilder.ItemOffsetsParams(
                spanIndex = 0, spanSize = 1,
                spanCount = 1, groupCount = 3,
                isLayoutVertical = true, isLayoutReverse = false)
        val expectedResult = ItemOffsetsCalculator.OffsetsRequest(
                spanSizeH = 1, spanSizeV = 1, rows = 3, cols = 1)

        test(params.apply { groupIndex = 0 }, expectedResult.apply { row = 0; col = 0 })
        test(params.apply { groupIndex = 1 }, expectedResult.apply { row = 1; col = 0 })
        test(params.apply { groupIndex = 2 }, expectedResult.apply { row = 2; col = 0 })
    }

    @Test
    fun horizontal() {
        val params = ItemOffsetsRequestBuilder.ItemOffsetsParams(
                spanIndex = 0, spanSize = 1,
                spanCount = 1, groupCount = 3,
                isLayoutVertical = false, isLayoutReverse = false)
        val expectedResult = ItemOffsetsCalculator.OffsetsRequest(
                spanSizeH = 1, spanSizeV = 1, rows = 1, cols = 3)

        test(params.apply { groupIndex = 0 }, expectedResult.apply { row = 0; col = 0 })
        test(params.apply { groupIndex = 1 }, expectedResult.apply { row = 0; col = 1 })
        test(params.apply { groupIndex = 2 }, expectedResult.apply { row = 0; col = 2 })
    }

    @Test
    fun verticalReverse() {
        val params = ItemOffsetsRequestBuilder.ItemOffsetsParams(
                spanIndex = 0, spanSize = 1,
                spanCount = 1, groupCount = 3,
                isLayoutVertical = true, isLayoutReverse = true)
        val expectedResult = ItemOffsetsCalculator.OffsetsRequest(
                spanSizeH = 1, spanSizeV = 1, rows = 3, cols = 1)

        test(params.apply { groupIndex = 0 }, expectedResult.apply { row = 2; col = 0 })
        test(params.apply { groupIndex = 1 }, expectedResult.apply { row = 1; col = 0 })
        test(params.apply { groupIndex = 2 }, expectedResult.apply { row = 0; col = 0 })
    }

    @Test
    fun horizontalReverse() {
        val params = ItemOffsetsRequestBuilder.ItemOffsetsParams(
                spanIndex = 0, spanSize = 1,
                spanCount = 1, groupCount = 3,
                isLayoutVertical = false, isLayoutReverse = true)
        val expectedResult = ItemOffsetsCalculator.OffsetsRequest(
                spanSizeH = 1, spanSizeV = 1, rows = 1, cols = 3)

        test(params.apply { groupIndex = 0 }, expectedResult.apply { row = 0; col = 2 })
        test(params.apply { groupIndex = 1 }, expectedResult.apply { row = 0; col = 1 })
        test(params.apply { groupIndex = 2 }, expectedResult.apply { row = 0; col = 0 })
    }

}