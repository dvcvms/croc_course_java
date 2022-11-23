package ru.croc.task12;


import java.util.List;
import java.util.Set;


public class FilterComment implements BlackListFilter {

    @Override
    public void filterComments(List<String> comments, Set<String> blackList) {

        int index = 0;
        while (index < comments.size()) {
            for (String blackComment : blackList) {
                var a = comments.get(index).toLowerCase();
                if (a.contains(blackComment.toLowerCase())) {
                    comments.remove(index);
                    index--;
                }
            }
            index++;
        }

    }

}
