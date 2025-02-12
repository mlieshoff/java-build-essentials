package com.mlieshoff.build.essentials;

import static com.mlieshoff.build.essentials.BuildUtils.readFileToString;
import static com.mlieshoff.build.essentials.Utils.require;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ReadmeVersionChecker {

    public static void main(String[] args) {
        if (args == null || args.length != 4) {
            throw new IllegalStateException(
                    "version filename, readme file name, readme group id and readme title are"
                            + " required!");
        }
        String versionFilename = args[0];
        require("versionFilename", versionFilename);
        String readMeFilename = args[1];
        require("readMeFilename", readMeFilename);
        String readMeGroupId = args[2];
        require("readMeGroupId", readMeGroupId);
        String readMeArtifactName = args[3];
        require("readMeTitle", readMeArtifactName);
        String versionTxt = readFileToString(versionFilename).substring(1);
        String readMe = readFileToString(readMeFilename);
        boolean success = true;
        String searchTitle = readMeArtifactName + " " + versionTxt;
        String searchMavenVersion = "<version>" + versionTxt + "</version>";
        String searchMavenGroupId = "<groupId>" + readMeGroupId + "</groupId>";
        String searchMavenArtifactId = "<artifactId>" + readMeArtifactName + "</artifactId>";
        String searchGradle =
                "group: '"
                        + readMeGroupId
                        + "', name: '"
                        + readMeArtifactName
                        + "', version: '"
                        + versionTxt
                        + "'";
        String reason = null;
        if (!readMe.contains(searchTitle)) {
            success = false;
            reason = "title != " + searchTitle;
        } else if (!readMe.contains(searchMavenVersion)) {
            success = false;
            reason = "mavenVersion != " + searchMavenVersion;
        } else if (!readMe.contains(searchMavenGroupId)) {
            success = false;
            reason = "mavenGroupId != " + searchMavenGroupId;
        } else if (!readMe.contains(searchMavenArtifactId)) {
            success = false;
            reason = "mavenArtifactId != " + searchMavenArtifactId;
        } else if (!readMe.contains(searchGradle)) {
            success = false;
            reason = "gradleVersion != " + searchGradle;
        }
        if (!success) {
            log.error("****************************************************");
            log.error("*** README VERSION DON'T MATCHES VERSION.TXT !!! ***");
            log.error("****************************************************");
            throw new IllegalStateException(
                    "Readme file '" + readMeFilename + "' contains problems, reason: " + reason);
        }
    }
}
