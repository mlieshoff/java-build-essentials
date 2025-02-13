package com.mlieshoff.build.essentials;

import static com.mlieshoff.build.essentials.Utils.require;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatNoException;

import org.junit.jupiter.api.Test;

class UtilsTest {

    private static final String EMPTY = "";
    private static final String KEY = "key";
    private static final String NOT_EMPTY = "not empty";

    @Test
    void require_whenEmptyString_thenThrowsException() {

        assertThatIllegalArgumentException()
                .isThrownBy(() -> require(KEY, EMPTY))
                .withMessage("key must be set! But was: ");
    }

    @Test
    void require_whenNonEmptyString_thenNoException() {

        assertThatNoException().isThrownBy(() -> require(KEY, NOT_EMPTY));
    }

    @Test
    void require_whenNullObject_thenThrowsException() {

        assertThatIllegalArgumentException()
                .isThrownBy(() -> require(KEY, (Object) null))
                .withMessage("key must be set!");
    }

    @Test
    void require_whenNonNullObject_thenNoException() {

        assertThatNoException().isThrownBy(() -> require(KEY, new Object()));
    }
}
