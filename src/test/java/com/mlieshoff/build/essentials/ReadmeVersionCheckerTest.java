package com.mlieshoff.build.essentials;

import static com.mlieshoff.build.essentials.ReadmeVersionChecker.main;
import static com.mlieshoff.build.essentials.TestConstants.*;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatIllegalStateException;

import org.junit.jupiter.api.Test;

class ReadmeVersionCheckerTest {

    @Test
    void main_whenWithNullArray_thenThrowException() {

        assertThatIllegalStateException()
                .isThrownBy(() -> main(null))
                .withMessage(
                        "version filename, readme file name, readme group id and readme title are"
                                + " required!");
    }

    @Test
    void main_whenWithEmptyArray_thenThrowException() {

        assertThatIllegalStateException()
                .isThrownBy(() -> main(new String[] {}))
                .withMessage(
                        "version filename, readme file name, readme group id and readme title are"
                                + " required!");
    }

    @Test
    void main_whenWithEmptyVersionFileParameter_thenThrowException() {

        assertThatIllegalArgumentException()
                .isThrownBy(
                        () ->
                                main(
                                        new String[] {
                                            EMPTY,
                                            README_CONSISTENT_FILENAME,
                                            README_GROUP_ID,
                                            README_TITLE
                                        }))
                .withMessage("versionFilename must be set! But was: ");
    }

    @Test
    void main_whenWithEmptyReadMeFileParameter_thenThrowException() {

        assertThatIllegalArgumentException()
                .isThrownBy(
                        () ->
                                main(
                                        new String[] {
                                            VERSION_100_FILENAME,
                                            EMPTY,
                                            README_GROUP_ID,
                                            README_TITLE
                                        }))
                .withMessage("readMeFilename must be set! But was: ");
    }

    @Test
    void main_whenWithEmptyReadMeTitleParameter_thenThrowException() {

        assertThatIllegalArgumentException()
                .isThrownBy(
                        () ->
                                main(
                                        new String[] {
                                            VERSION_100_FILENAME,
                                            README_CONSISTENT_FILENAME,
                                            README_GROUP_ID,
                                            EMPTY
                                        }))
                .withMessage("readMeTitle must be set! But was: ");
    }

    @Test
    void main_whenWithEmptyReadMeGroupIdParameter_thenThrowException() {

        assertThatIllegalArgumentException()
                .isThrownBy(
                        () ->
                                main(
                                        new String[] {
                                            VERSION_100_FILENAME,
                                            README_CONSISTENT_FILENAME,
                                            EMPTY,
                                            README_TITLE
                                        }))
                .withMessage("readMeGroupId must be set! But was: ");
    }

    @Test
    void main_whenWithReadMeInconsistentTitleName_thenThrowException() {

        assertThatIllegalStateException()
                .isThrownBy(
                        () ->
                                main(
                                        new String[] {
                                            VERSION_100_FILENAME,
                                            README_INCONSISTENT_TITLE_NAME,
                                            README_GROUP_ID,
                                            README_TITLE
                                        }))
                .withMessage(
                        "Readme file './src/test/resources/README_inconsistent_title_name.md'"
                                + " contains problems, reason: title != olala 1.0.0");
    }

    @Test
    void main_whenWithReadMeInconsistentTitleVersion_thenThrowException() {

        assertThatIllegalStateException()
                .isThrownBy(
                        () ->
                                main(
                                        new String[] {
                                            VERSION_100_FILENAME,
                                            README_INCONSISTENT_TITLE_VERSION,
                                            README_GROUP_ID,
                                            README_TITLE
                                        }))
                .withMessage(
                        "Readme file './src/test/resources/README_inconsistent_title_version.md'"
                                + " contains problems, reason: title != olala 1.0.0");
    }

    @Test
    void main_whenWithReadMeInconsistentGradleName_thenThrowException() {

        assertThatIllegalStateException()
                .isThrownBy(
                        () ->
                                main(
                                        new String[] {
                                            VERSION_100_FILENAME,
                                            README_INCONSISTENT_GRADLE_NAME,
                                            README_GROUP_ID,
                                            README_TITLE
                                        }))
                .withMessage(
                        "Readme file './src/test/resources/README_inconsistent_gradle_name.md'"
                            + " contains problems, reason: gradleVersion != group: 'com.example',"
                            + " name: 'olala', version: '1.0.0'");
    }

    @Test
    void main_whenWithReadMeInconsistentGradleGroup_thenThrowException() {

        assertThatIllegalStateException()
                .isThrownBy(
                        () ->
                                main(
                                        new String[] {
                                            VERSION_100_FILENAME,
                                            README_INCONSISTENT_GRADLE_GROUP,
                                            README_GROUP_ID,
                                            README_TITLE
                                        }))
                .withMessage(
                        "Readme file './src/test/resources/README_inconsistent_gradle_group.md'"
                            + " contains problems, reason: gradleVersion != group: 'com.example',"
                            + " name: 'olala', version: '1.0.0'");
    }

    @Test
    void main_whenWithReadMeInconsistentGradleVersion_thenThrowException() {

        assertThatIllegalStateException()
                .isThrownBy(
                        () ->
                                main(
                                        new String[] {
                                            VERSION_100_FILENAME,
                                            README_INCONSISTENT_GRADLE_VERSION,
                                            README_GROUP_ID,
                                            README_TITLE
                                        }))
                .withMessage(
                        "Readme file './src/test/resources/README_inconsistent_gradle_version.md'"
                            + " contains problems, reason: gradleVersion != group: 'com.example',"
                            + " name: 'olala', version: '1.0.0'");
    }

    @Test
    void main_whenWithReadMeInconsistentMavenVersion_thenThrowException() {

        assertThatIllegalStateException()
                .isThrownBy(
                        () ->
                                main(
                                        new String[] {
                                            VERSION_100_FILENAME,
                                            README_INCONSISTENT_MAVEN_VERSION,
                                            README_GROUP_ID,
                                            README_TITLE
                                        }))
                .withMessage(
                        "Readme file './src/test/resources/README_inconsistent_maven_version.md'"
                                + " contains problems, reason: mavenVersion !="
                                + " <version>1.0.0</version>");
    }

    @Test
    void main_whenWithSameVersionInVersionFileAndReadMe_thenDoNotThrowException() {

        main(
                new String[] {
                    VERSION_100_FILENAME, README_CONSISTENT_FILENAME, README_GROUP_ID, README_TITLE
                });
    }

    @Test
    void main_whenWithReadMeInconsistentMavenGroupId_thenThrowException() {

        assertThatIllegalStateException()
                .isThrownBy(
                        () ->
                                main(
                                        new String[] {
                                            VERSION_100_FILENAME,
                                            README_INCONSISTENT_MAVEN_GROUP_ID,
                                            README_GROUP_ID,
                                            README_TITLE
                                        }))
                .withMessage(
                        "Readme file './src/test/resources/README_inconsistent_maven_group_id.md'"
                                + " contains problems, reason: mavenGroupId !="
                                + " <groupId>com.example</groupId>");
    }

    @Test
    void main_whenWithReadMeInconsistentMavenArtifactId_thenThrowException() {

        assertThatIllegalStateException()
                .isThrownBy(
                        () ->
                                main(
                                        new String[] {
                                            VERSION_100_FILENAME,
                                            README_INCONSISTENT_MAVEN_ARTIFACT_ID,
                                            README_GROUP_ID,
                                            README_TITLE
                                        }))
                .withMessage(
                        "Readme file"
                                + " './src/test/resources/README_inconsistent_maven_artifact_id.md'"
                                + " contains problems, reason: mavenArtifactId !="
                                + " <artifactId>olala</artifactId>");
    }
}
