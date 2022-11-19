package ru.croc.task10;

public class Test {

    /* public static String[] getAllLists(String[] elements, int lengthOfList, String hashPassword) {
        //initialize our returned list with the number of elements calculated above
        String[] allLists = new String[(int) Math.pow(elements.length, lengthOfList)];

        //lists of length 1 are just the original elements
        if (lengthOfList == 1) return elements;
        else {
            //the recursion--get all lists of length 3, length 2, all the way up to 1
            String[] allSublists = getAllLists(elements, lengthOfList - 1, hashPassword);

            //append the sublists to each element
            int arrayIndex = 0;

            for (int i = 0; i < elements.length; i++) {
                for (int j = 0; j < allSublists.length; j++) {
                    //add the newly appended combination to the list
                    allLists[arrayIndex] = elements[i].toString() + allSublists[j].toString();
//                    if (Hash.test(elements[i] + allSublists[j]).equals(hashPassword)) {
//                        System.out.println("password: " + elements[i] + allSublists[j]);
//                        return null;
//                    }
                    arrayIndex++;
                }
            }

            return allLists;
        }
    } */

    /*public static String findPassword(String hashPassword) {

        StringBuilder str = new StringBuilder();
        for (char i = 'a'; i <= 'z'; i++)
            for (char j = 'a'; j <= 'z'; j++)
                for (char a = 'a'; a <= 'z'; a++)
                    for (char b = 'a'; b <= 'z'; b++)
                        for (char c = 'a'; c <= 'z'; c++)
                            for (char d = 'a'; d <= 'z'; d++)
                                for (char e = 'a'; e <= 'z'; e++) {

                                    str.append(i).append(j).append(a).append(b).append(c).append(d).append(e);

                                    if (Hash.test(str.toString()).equals(hashPassword)) {
                                        return str.toString();
                                    }

                                    str.setLength(0);
                                }
        return "";
    }*/


    public static void main(String[] args) {
//        String count = args[0];
//        String hashPassword = args[1];
       /* String[] passwords = {
                "aaaaaaa",
                "baaaaaa",
                "abaaaaa",
                "aabaaaa",
                "aaabaaa",
                "aaaabaa",
                "aaaaaba",
                "aaaaaza",
                "aazaaaa"
        };
        String[] hashPasswords = new String[passwords.length];

        for (int i = 0; i < passwords.length; i++)
            hashPasswords[i] = Hash.getHashOfPassword(passwords[i]);

        for (int i = 0; i < passwords.length; i++) {
            System.out.println("passwordReal: " + passwords[i]);
            System.out.println("hashPassword: " + hashPasswords[i]);
            long t0 = System.nanoTime();
            System.out.print("foundedPassword: " + newfind(hashPasswords[i]));
            long t1 = System.nanoTime() - t0;
            System.out.println(" Time: " + t1 / 1e9 + "c");
            System.out.println();
        }

//        String[] arr = new String['z' - 'a' + 1];
//        for (char c = 'a'; c <= 'z'; c++) {
//            arr[(int) (c - 'a')] = "" + c;
//        }*/
    }
}
