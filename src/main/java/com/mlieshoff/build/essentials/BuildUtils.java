package com.mlieshoff.build.essentials;

import static com.mlieshoff.build.essentials.Utils.require;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class BuildUtils {

    public static String readFileToString(String filename) {
        require("filename", filename);
        File file = new File(filename);
        try (FileInputStream fileInputStream = new FileInputStream(file)) {
            return new String(fileInputStream.readAllBytes());
        } catch (IOException e) {
            throw new IllegalStateException("could not read file: " + filename);
        }
    }
}
