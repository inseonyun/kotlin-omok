package omok.view

import omok.OmokPoint
import omok.state.BlackStoneState
import omok.state.StoneState
import omok.state.WhiteStoneState

class InputView {
    private fun StoneState.name(): String = when (this) {
        BlackStoneState -> STATE_BLACK_STONE
        WhiteStoneState -> STATE_WHITE_STONE
        else -> ""
    }

    fun inputPoint(stoneState: StoneState, omokPoint: OmokPoint?): OmokPoint {
        val lastLocation = omokPoint?.let { MESSAGE_LAST_STONE_POSITION.format(STANDARD_X_COORDINATE + it.x - 1, it.y) } ?: ""
        println(MESSAGE_TURN.format(stoneState.name()) + " $lastLocation")
        print(MESSAGE_POSITION)
        return getPoint()
    }

    private fun getPoint(): OmokPoint = runCatching {
        readln().let {
            val x: Int = it[0].uppercaseChar() - STANDARD_X_COORDINATE + 1
            val y: Int = it.substring(1).toInt()
            return OmokPoint(x, y)
        }
    }.onFailure { println(it.message) }
        .getOrElse { getPoint() }

    companion object {
        private const val STATE_BLACK_STONE = "흑"
        private const val STATE_WHITE_STONE = "백"
        private const val STANDARD_X_COORDINATE = 'A'
        private const val MESSAGE_LAST_STONE_POSITION = "(마지막 돌의 위치: %s%s)"
        private const val MESSAGE_TURN = "%s의 차례입니다."
        private const val MESSAGE_POSITION = "위치를 입력하세요: "
    }
}