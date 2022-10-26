package ru.croc.task4;


public class Task4 {

    static public void removeFirst(Comment obj) {

        // shift index position [some symbol] after "//" symbols: "[/]/A" -> "//[A]"
        obj.i += 2;

        int lengthStr = obj.getLengthStr();

        for (int j = obj.i; j < lengthStr; j++)

            if (obj.getCharAtStr(j) == '\n') {
                obj.i = j;
                break;
            }
            // we must work out the case, when "//..." comment
            // located in the end of text and '\n' is missed (//...'\n' - X)
            else if (j == (lengthStr - 1)) {
                obj.i = j;
                obj.flag = false; // to do signal for this situation
                break;
            }
    }

    static public void removeSecond(Comment obj) {

        // shift index position [some symbol] after "/*" symbols: "[/]*A" -> "/*[A]"
        obj.i += 2;

        int lengthStr = obj.getLengthStr();

        for (int j = obj.i; j < lengthStr; j++)

            if (obj.getCharAtStr(j) == '*' && obj.getCharAtStr(j + 1) == '/') {
                obj.i = j + 2;
                break;
            }

    }

    static public void removeComments(Comment obj) {

        int lengthStr = obj.getLengthStr();

        // if text is ""
        if (lengthStr == 0) {
            return;
        }

        while (obj.i < lengthStr) {

            if (obj.getCharAtStr(obj.i) == '/' && obj.getCharAtStr(obj.i + 1) == '/')
                removeFirst(obj); // to remove "//..." comment

            else if (obj.getCharAtStr(obj.i) == '/' && obj.getCharAtStr(obj.i + 1) == '*')
                removeSecond(obj); // to remove "/* ... */" comment

            else if (obj.flag) {
                obj.builder.append(obj.getCharAtStr(obj.i));
                obj.i++;
            }
        }

        obj.setNewStr(obj.builder);
    }

    public static void main(String[] args) {

        Comment obj = new Comment();

        String text = """
                /* */ /*
                 * My first ever program in Java!
                 */ // / ///// / / / / // / / 
                class Hello { // class body starts here\s
                 \s
                  /* main method *//**/
                  public static void main(String[] args/* we put command line arguments here*/) {
                    // this line prints my first greeting to the screen
                    System.out.println("Hi!"); // :)
                  }
                } //////*/*//// the end
                ////////// to be continued...\n
                """;

        obj.setStr(text);

        removeComments(obj);

        System.out.println(obj.getNewStr());
    }
}
