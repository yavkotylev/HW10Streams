package streams;

/**
 * Created by Yaroslav on 20.09.16.
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * Created by Yaroslav on 19.09.16.
 */

public class Streams<T> {
    private final List<? extends T> list;

    private Streams(List<? extends T> list) {
        this.list = list;
    }

    public static <U> Streams<U> of(List<? extends U> list) {
        return new Streams(list);
    }

    public Streams<T> filter(Predicate<? super T> predicate) {
        List<T> resultList = new ArrayList<>();
        list.forEach(item -> {
            if (predicate.test(item)) {
                resultList.add(item);
            }
        });
        return new Streams<>(resultList);
    }

    public <T, R> Streams<R> transform(Function<T, R> function) {
        List<R> resultList = new ArrayList<>();
        list.forEach(item -> resultList.add(function.apply((T) item)));
        return new Streams<>(resultList);
    }

    public <U, K> Map toMap(Function<T, U> getKey, Function<T, K> getValue) {
        Map<U, K> map = new HashMap<>();
        list.forEach(p -> map.put(getKey.apply(p), getValue.apply(p)));
        return map;
    }
}