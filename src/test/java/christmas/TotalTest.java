package christmas;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

public class TotalTest extends NsTest {

    @Test
    @DisplayName("예시로 주어진 테스트 케이스")
    void 모든_정보_출력_할인_있는_버전() {
        assertSimpleTest(() -> {
            run("3", "티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1");
            assertThat(output()).contains(
                    "<주문 메뉴>",
                    "티본스테이크 1개",
                    "바비큐립 1개",
                    "초코케이크 2개",
                    "제로콜라 1개",
                    "<할인 전 총주문 금액>",
                    "142000원",
                    "<증정 메뉴>",
                    "샴페인 1개",
                    "<혜택 내역>",
                    "크리스마스 디데이 할인: -1200원",
                    "평일 할인: -4046원",
                    "특별 할인: -1000원",
                    "증정 이벤트: -25000원",
                    "<총혜택 금액>",
                    "-31246원",
                    "<할인 후 예상 결제 금액>",
                    "135754원",
                    "<12월 이벤트 배지>",
                    "산타"
            );
        });
    }

    @Test
    @DisplayName("예시로 주어진 테스트 케이스 2")
    void 모든_정보_출력_할인_없는_버전() {
        assertSimpleTest(() -> {
            run("26", "타파스-1,제로콜라-1");
            assertThat(output()).contains(
                    "<주문 메뉴>",
                    "타파스 1개",
                    "제로콜라 1개",
                    "<할인 전 총주문 금액>",
                    "8500원",
                    "<증정 메뉴>",
                    "없음",
                    "<혜택 내역>",
                    "없음",
                    "<총혜택 금액>",
                    "0원",
                    "<할인 후 예상 결제 금액>",
                    "8500원",
                    "<12월 이벤트 배지>",
                    "없음"
            );
        });
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
