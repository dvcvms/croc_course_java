package ru.croc.task9;

public class Normalization {

    private Normalization() {
        // access closed to create objects
    }

    public static String normalizePath(String path) {

        if (path.length() == 0) {
            return "";
        }

        String newPath = firstStageNormalization(path);

        return secondStageNormalization(newPath);
    }

    // remove single [./] symbols in path
    private static String firstStageNormalization(String path) {

        int start = 0, end = 0, i = 2;
        StringBuilder newStr = new StringBuilder();

        // if path started with [./] symbols:
        // ./otherDirectories/... -> otherDirectories/...
        if (path.charAt(0) == '.' && path.charAt(1) == '/')
            i = 3;

        while (i < path.length()) {
            if (path.charAt(i - 2) != '.' && path.charAt(i - 1) == '.' && path.charAt(i) == '/') {
                i = i + 2;
            } else {
                newStr.append(path.charAt(i - 1));
                i++;
            }
        }

        return newStr.toString();
    }

    // remove the [directory][../] constructions in path
    private static String secondStageNormalization(String path) {

        String currentAnswer = path, prevAnswer;

        do {
            prevAnswer = currentAnswer;

            currentAnswer = currentAnswer.replaceAll("[{0-9A-z_\\-}]+[/][.][.][/]", "");

        } while (prevAnswer.length() != currentAnswer.length());


        // .../lastDirectory/ -> .../lastDirectory
        if (currentAnswer.charAt(currentAnswer.length() - 1) == '/') {
            currentAnswer = currentAnswer.substring(0, currentAnswer.length() - 1);
        }

        return currentAnswer;
    }
}
