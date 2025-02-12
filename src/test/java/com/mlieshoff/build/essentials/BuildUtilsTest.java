package com.mlieshoff.build.essentials;

import static com.mlieshoff.build.essentials.BuildUtils.readFileToString;
import static com.mlieshoff.build.essentials.TestConstants.*;
import static com.mlieshoff.build.essentials.TestConstants.FILE;
import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BuildUtilsTest {

    @Test
    void main_whenWithNullFilename_thenThrowException() {

        assertThatIllegalArgumentException()
                .isThrownBy(() -> readFileToString(NULL_STRING))
                .withMessage("filename must be set! But was: null");
    }

    @Test
    void main_whenWithEmptyFilename_thenThrowException() {

        assertThatIllegalArgumentException()
                .isThrownBy(() -> readFileToString(EMPTY))
                .withMessage("filename must be set! But was: ");
    }

    @Test
    void main_whenWithNonExistingFilename_thenThrowException() {

        assertThatIllegalStateException()
                .isThrownBy(() -> readFileToString(NOT_EXISTING_FILE))
                .withMessage("could not read file: xxx.txt");
    }

    @Test
    void main_whenWithFilename_thenRead() {
        String expected = "hey ho";

        String actual = readFileToString(FILE);

        assertThat(actual).isEqualTo(expected);
    }
}
