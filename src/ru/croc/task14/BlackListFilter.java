package ru.croc.task14;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;

public interface BlackListFilter<T> {

    /**
     * From the given list of comments removes ones
     * that contain words from the black list.
     *
     * @param comments  list of comments; every comment
     *                  is a sequence of words, separated
     *                  by spaces, punctuation or line breaks
     * @param blackList list of words that should not
     *                  be present in a comment
     */
    default List<T> filterComments(Iterable<T> comments, Predicate<T> blackList) {
        List<T> cleanedList = new ArrayList<>();
        for (T comment : comments) {
            if (!blackList.test(comment)) {
                cleanedList.add(comment);
            }
        }
        return cleanedList;
    }
}
