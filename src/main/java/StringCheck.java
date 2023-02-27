import java.util.*;
import java.util.stream.Collectors;
/*
Написать функцию принимающую на вход String[]
Исходный массив менять нельзя!
Требуется найти строки содержащие одинаковый набор символов и вывести на консоль в виде: набор
символов(в любом порядке) = индексы строк в исходном массиве через запятую(в любом порядке).
Если у строки нет парной с ней строки с одинаковым набором символов - то печать её не надо.
Пример (форматирование может быть любое):
подаём на вход: {""qwe"",""wqe"",""qwee"",""a"",""a""};
вывод на консоль: a = 3, 4 eqw = 0, 1 набор символов QQ и Q - разный
Плюсом будет написание теста для тестирования функции.
*/
public class StringCheck {

    public static Map<String, List<Integer>> duplicateElementSeeker(String[] array) {
        Map<String, List<Integer>> duplicateElements = new HashMap<>();
        Set<String> nonDuplicateElements = new HashSet<>();
        List<String> deserializedArray = elementNameDeserializer(array);
        for (String str : deserializedArray) {
            if (!nonDuplicateElements.add(str)) {
                duplicateElements.put(str, getAllDuplicatedElementIndexes(str, deserializedArray));
            }
        }
        return duplicateElements;
    }

    private static List<Integer> getAllDuplicatedElementIndexes(String value, List<String> array) {
        List<Integer> indexes = new ArrayList<>();
        for (int i = 0; i < array.size(); i++) {
            if (array.get(i).equals(value)) {
                indexes.add(i);
            }
        }
        return indexes;
    }

    private static List<String> elementNameDeserializer(String[] array) {
        List<String> deserializedNameList = new ArrayList<>();
        List<Character> chars = new ArrayList<>();
        for (String name : array) {
            for (char ch : name.toCharArray()) {
                chars.add(ch);
            }
            deserializedNameList.add(chars.stream()
                    .sorted()
                    .map(String::valueOf)
                    .collect(Collectors.joining()));
            chars.clear();
        }
        return deserializedNameList;
    }

    public static void main(String[] args) {
        String[] strArray = {"qwe", "wqe", "qwee", "a", "a"};

        System.out.println(duplicateElementSeeker(strArray));
    }
}