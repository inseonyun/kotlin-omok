package omok.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class XCoordinateTest {
    @Test
    fun `x 좌표를 만들 수 있다`() {
        val xCoordinate = XCoordinate('A')
        assertThat(xCoordinate.value).isEqualTo('A')
    }

    @ParameterizedTest
    @ValueSource(chars = ['A', 'O'])
    fun `x 좌표는 A부터 O사이 다`(value: Char) {
        assertDoesNotThrow { XCoordinate(value) }
    }

    @Test
    fun `x 좌표는 A부터 O사이 이외는 에러가 발생한다`() {
        assertThrows<IllegalArgumentException> { XCoordinate('P') }
    }

    @Test
    fun `모든 X 좌표의 목록을 반환한다`() {
        val actual = XCoordinate.all().map { it.value }
        val expected = ('A'..'O').toList()
        assertThat(actual).isEqualTo(expected)
    }
}
