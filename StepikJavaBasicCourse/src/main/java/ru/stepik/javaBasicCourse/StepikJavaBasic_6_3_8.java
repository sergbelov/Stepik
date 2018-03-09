package ru.stepik.javaBasicCourse;

import java.util.Objects;
import java.util.function.Function;
import java.util.function.Predicate;

public class StepikJavaBasic_6_3_8 {

    public static void main(String[] args) {
        Predicate<Object> condition = Objects::isNull;
        Function<Object, Integer> ifTrue = obj -> 0;
        Function<CharSequence, Integer> ifFalse = CharSequence::length;
        Function<String, Integer> safeStringLength = ternaryOperator(condition, ifTrue, ifFalse);

        System.out.println(safeStringLength);
    }

    public static <T, U> Function<T, U> ternaryOperator(
            Predicate<? super T> condition,
            Function<? super T, ? extends U> ifTrue,
            Function<? super T, ? extends U> ifFalse) {

        return x -> condition.test(x) ? ifTrue.apply(x) : ifFalse.apply(x);
    }
}


/*
https://stepik.org/users/1647194 (Алексей Владыкин)


Метод ternaryOperator() должен вернуть экземпляр Function. Поскольку Function — функциональный интерфейс, есть следующие способы его инстанцировать:

создать экземпляр анонимного или именованного класса, реализующего интерфейс Function;
воспользоваться ссылкой на метод;
написать лямбда-выражение.
Компактнее всего будет решение через лямбда-выражение, именно его и ожидает проверяющая система. В итоге решение записывается в одну строку:

return x -> condition.test(x) ? ifTrue.apply(x) : ifFalse.apply(x);


Надо помнить, что condition, ifTrue и ifFalse — это обычные объекты, у них есть методы. Если забыли, какие у них методы, то можно воспользоваться подсказкой IDE или сходить в JavaDoc/исходники интерфейсов Predicate и Function. Нельзя просто взять и написать:

return condition(x) ? ifTrue(x) : ifFalse(x); // это не скомпилируется


В задаче был дополнительный вопрос про сигнатуру метода ternaryOperator(). Почему он объявлен именно так, а не более простым способом, без всяких <? super T> и <? extends U>? Можно ведь было объявить его так:

public static <T, U> Function<T, U> ternaryOperator(
            Predicate<T> condition,
            Function<T, U> ifTrue,
            Function<T, U> ifFalse)
Если метод ternaryOperator() объявить таким способом, то код из примера не скомпилируется. В Java типы Predicate<Object> и Predicate<String> несовместимы, поэтому нельзя передать Predicate<Object> в метод, ожидающий Predicate<String>.

Это касалось <? super T>. Если же вместо <? extends U> использовать <U>, то не скомпилируется следующий пример, т.к. несовместимыми являются типы Function<Object, String> и Function<Object, CharSequence>.

Predicate<Object> condition = Objects::isNull;
Function<Object, String> ifTrue = obj -> "null";
Function<Object, String> ifFalse = Object::toString;
Function<Object, CharSequence> objectToCharSequence =
        ternaryOperator(condition, ifTrue, ifFalse);
*/