package ru.stepik.javaBasicCourse;

import java.util.*;

public class StepikJavaBasic_6_4_13 {

    public static void main(String[] args) {

        List<RepeatWord> listRepeatWord = new ArrayList<>();

        String words = "Мама мыла-мыла-мыла раму!";
//        String words = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed sodales consectetur purus at faucibus. Donec mi quam, tempor vel ipsum non, faucibus suscipit massa. Morbi lacinia velit blandit tincidunt efficitur. Vestibulum eget metus imperdiet sapien laoreet faucibus. Nunc eget vehicula mauris, ac auctor lorem. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer vel odio nec mi tempor dignissim.";

//        String words = "";
//        Scanner scanner = new Scanner(System.in, "UTF-8");
//        while (scanner.hasNext()) {
//            words = words + scanner.next() +" ";
//        }
        parseString(words, listRepeatWord);
    }


    static class RepeatWord {

        private String word;
        private Integer count = 0;

        public RepeatWord() {
        }

        public RepeatWord(String word) {
            this.word = word;
            this.count = 0;
        }

        public String getWord() {
            return word;
        }

        public void setWord(String word) {
            this.word = word;
        }

        public Integer getCount() {
            return count;
        }

        public void addCount() {
            this.count++;
        }
    }

    public static int findWord(String word, List<RepeatWord> repeatWords){
        int r = -1;
        word = word.toLowerCase();

        for (int i = 0; i < repeatWords.size(); i++){
            if (repeatWords.get(i).word.equals(word)){
                r = i;
                break;
            }
        }

        if (r == -1){
            repeatWords.add(new RepeatWord(word));
            r = repeatWords.size()-1;
        }

        repeatWords.get(r).addCount();
        return r;
    }


    public static void parseString(String words, List<RepeatWord> repeatWords){

//        String[] parts = (words + " ").split("\\p{P}?[ \\-\\t\\n\\r]+");
        String[] parts = (words).split("[^а-яА-ЯёЁa-zA-Z0-9]+");

        for (int i = 0; i < parts.length; i++){
//            System.out.println(parts[i]);
            findWord(parts[i], repeatWords);
        }

        repeatWords.stream()
            .sorted(new SortedByCount())
            .limit(10)

//            .map(RepeatWord::getWord)
//            .forEach(System.out::println);

            .forEach(o -> System.out.println(o.getWord() +" : "+ o.getCount()));
    }

    static class SortedByCount implements Comparator<RepeatWord> {

        public int compare(RepeatWord word1, RepeatWord word2) {
            int r = word2.getCount().compareTo(word1.getCount());
            if (r == 0){
                r = word1.getWord().compareTo(word2.getWord());
            }
            return r;
        }
    }

}