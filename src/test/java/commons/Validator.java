package commons;

public interface Validator<T> { // T -> 검증 할 수 있는 데이터 항목

    void check(T t);
}
