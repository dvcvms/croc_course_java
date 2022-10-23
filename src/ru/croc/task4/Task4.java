package ru.croc.task4;


public class Task4 {

    
    static class cl {
        String newStr;
        int i;
        boolean flaq;
    }
    
    static public void removeFirst(String str, cl obj) {
        for (int j = obj.i; j < str.length(); j++) {
            if (str.charAt(j) == '\n') {
                obj.i = j;
                break;
            } else if (j == (str.length() - 1)) {
                obj.i = j;
                obj.flaq = false;
                break;
            }
        }

    }

    static public void removeSecond(String str, cl obj) {
        int j;
        for (j = obj.i; j < str.length(); j++) {
            if (str.charAt(j) == '*' && str.charAt(j + 1) == '/') {
                obj.i = j + 2;
                break;
            }
        }
    }

    static public String removeComments(String str) {
        
        cl obj = new cl();
        obj.newStr = "";
        obj.i = 0;

        boolean flag = true;

        while (obj.i < str.length()) {

            if (str.charAt(obj.i) == '/') {
                if (str.charAt(obj.i + 1) == '/') {
                    removeFirst(str, obj); // to remove "//..." comment
                }
                else if (str.charAt(obj.i + 1) == '*') {
                    removeSecond(str, obj); // to remove "/* ... */" comment
                }
            }

            if (flag) {
                obj.newStr = obj.newStr + str.charAt(obj.i);
            }

            obj.i++;
        }

        return obj.newStr;
    }


    public static void main(String[] args) {

        String text = "/*\n" +
                " * My first ever program in Java!\n" +
                " */\n" +
                "class Hello { // class body starts here \n" +
                "  \n" +
                "  /* main method */\n" +
                "  public static void main(String[] args/* we put command line arguments here*/) {\n" +
                "    // this line prints my first greeting to the screen\n" +
                "    System.out.println(\"Hi!\"); // :)\n" +
                "  }\n" +
                "} // the end\n" +
                "// to be continued...\n";

        System.out.println(text); // TODO: delete after refactor code

        String textWithoutComment = removeComments(text);

        System.out.println(textWithoutComment);
    }
}
