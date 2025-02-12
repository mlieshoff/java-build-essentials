package com.mlieshoff.build.essentials;

import static com.mlieshoff.build.essentials.BuildUtils.readFileToString;
import static com.mlieshoff.build.essentials.Utils.require;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ChangeLogVersionChecker {

    public static void main(String[] args) {
        if (args == null || args.length != 2) {
            throw new IllegalStateException(
                    "version filename and changelog file name are required!");
        }
        String versionFilename = args[0];
        require("versionFilename", versionFilename);
        String changeLogFilename = args[1];
        require("changeLogFilename", changeLogFilename);
        String versionTxt = readFileToString(versionFilename).substring(1);
        String changeLog = readFileToString(changeLogFilename);
        boolean success = true;
        String searchTitleEntry = "## [" + versionTxt + "]";
        String searchHeadEntry = "v" + versionTxt + "...HEAD";
        String searchCurrentEntry = "[" + versionTxt + "]: https://";
        String reason = null;
        if (!changeLog.contains(searchTitleEntry)) {
            success = false;
            reason = "title";
        } else if (!changeLog.contains(searchHeadEntry)) {
            success = false;
            reason = "head";
        } else if (!changeLog.contains(searchCurrentEntry)) {
            success = false;
            reason = "tag";
        }
        if (!success) {
            log.error("*******************************************************");
            log.error("*** CHANGELOG VERSION DON'T MATCHES VERSION.TXT !!! ***");
            log.error("*******************************************************");
            throw new IllegalStateException(
                    "Versions in '" + changeLogFilename + "' are not matching, reason: " + reason);
        }
    }
}
