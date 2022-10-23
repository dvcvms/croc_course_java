package ru.croc.task4;


public class Task4 {


    static class Comment {
        String str;
        String newStr;
        int i;
        boolean flag;
    }

    static public void removeFirst(Comment obj) {
        obj.i += 2; // TODO: add example for this solution

        for (int j = obj.i; j < obj.str.length(); j++)

            if (obj.str.charAt(j) == '\n') {
                obj.i = j;
                break;
            } else if (j == (obj.str.length() - 1)) { // TODO: add example for this solution
                obj.i = j;
                obj.flag = false;
                break;
            }
    }

    static public void removeSecond(Comment obj) {
        obj.i += 2; // TODO: add example for this solution

        for (int j = obj.i; j < obj.str.length(); j++)

            if (obj.str.charAt(j - 1) == '*' && obj.str.charAt(j) == '/') {
                obj.i = j + 1;
                break;
            }
    }

    static public String removeComments(Comment obj) {

        // initialization fields
        obj.newStr = "";
        obj.i = 0;
        obj.flag = true;

        while (obj.i < obj.str.length()) {

            if (obj.str.charAt(obj.i) == '/')

                if (obj.str.charAt(obj.i + 1) == '/')
                    removeFirst(obj); // to remove "//..." comment

                else if (obj.str.charAt(obj.i + 1) == '*')
                    removeSecond(obj); // to remove "/* ... */" comment

            if (obj.flag)
                obj.newStr = obj.newStr + obj.str.charAt(obj.i);

            obj.i++;
        }

        return obj.newStr;
    }


    public static void main(String[] args) {

        Comment obj = new Comment();

        obj.str = "/*\n" +
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


        // System.out.println(obj.str); // TODO: delete after refactor code

        removeComments(obj);

        System.out.println(obj.newStr);
    }
}
