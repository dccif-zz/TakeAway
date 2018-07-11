package top.dccif.foodservice.util;

import java.util.ArrayList;
import java.util.List;

public class tools {

    public static <T> List<T> itToList(Iterable<T> iterable) {
        List<T> retList = new ArrayList<>();
        iterable.forEach(retList::add);
        return retList;
    }
}
