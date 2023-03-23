package omok.domain.gameState

import omok.OmokBoard
import omok.OmokPoint
import omok.gameState.BlackTurn
import omok.gameState.GameState
import omok.gameState.WhiteTurn
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class BlackTurnTest {
    @Test
    fun `돌을 놓을 수 있다`() {
        val omokBoard = OmokBoard()
        val point = OmokPoint(1, 1)
        val omokBoardState: GameState = BlackTurn(omokBoard).play(point)
        assertThat(omokBoardState).isInstanceOf(WhiteTurn::class.java)
    }

    @Test
    fun `게임 진행이 가능하다`() {
        assertThat(BlackTurn(OmokBoard()).isRunning).isTrue
    }
}