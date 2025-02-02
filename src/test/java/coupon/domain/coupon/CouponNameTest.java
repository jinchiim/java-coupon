package coupon.domain.coupon;

import coupon.common.ErrorConstant;
import coupon.common.exception.CouponException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CouponNameTest {

    @Test
    @DisplayName("이름이 없을 경우 에러를 발생한다.")
    void getName_WhenNameIsEmpty() {
        assertThatThrownBy(() -> new CouponName(null))
                .isInstanceOf(CouponException.class)
                .hasMessage(ErrorConstant.COUPON_NAME_IS_NULL_OR_EMPTY.getMessage());
    }

    @Test
    @DisplayName("이름의 길이가 기준보다 길경우 에러를 발생한다.")
    void getName_WhenNameIsLong() {
        assertThatThrownBy(() -> new CouponName("1111111111111111111111111111111111"))
                .isInstanceOf(CouponException.class)
                .hasMessage(ErrorConstant.COUPON_NAME_IS_NOT_IN_RANGE.getMessage());
    }
}
