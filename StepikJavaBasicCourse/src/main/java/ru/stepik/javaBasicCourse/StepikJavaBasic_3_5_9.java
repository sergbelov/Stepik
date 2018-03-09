package ru.stepik.javaBasicCourse;

public class StepikJavaBasic_3_5_9 {

    public static void main(String[] args) {
        String[] bad_words = {"shit", "fack"};
        SpamAnalyzer spamAnalyzer = new SpamAnalyzer(bad_words);
        NegativeTextAnalyzer negativeTextAnalyzer = new NegativeTextAnalyzer();
        TooLongTextAnalyzer tooLongTextAnalyzer = new TooLongTextAnalyzer(20);
        TextAnalyzer[] textAnalyzers = {spamAnalyzer, negativeTextAnalyzer, tooLongTextAnalyzer};
        System.out.println(checkLabels(textAnalyzers, "Hello World !!!"));
        System.out.println(checkLabels(textAnalyzers, "shit. (Bad text)"));
        System.out.println(checkLabels(textAnalyzers, "=( (Bad text)"));
        System.out.println(checkLabels(textAnalyzers, "longer that twenty characters (Bad text)"));
    }

    interface TextAnalyzer {
        Label processText(String text);
    }

    enum Label {
        SPAM, NEGATIVE_TEXT, TOO_LONG, OK
    }
/*
в stepik.org убрать static
*/
    
    abstract static class KeywordAnalyzer implements TextAnalyzer {
        protected abstract String[] getKeywords();
        protected abstract Label getLabel();

        @Override
        public Label processText(String text) {
            String[] keywords = getKeywords();
            for (String keyword : keywords) {
                if (text.toLowerCase().contains(keyword.toLowerCase())) {
                    return getLabel();
                }
            }
            return Label.OK;
        }
    }

    static class TooLongTextAnalyzer implements TextAnalyzer {
        private int maxLength;

        public TooLongTextAnalyzer(int maxLenght) { this.maxLength = maxLenght;}

        @Override
        public Label processText(String text) {
            return (text.length() > this.maxLength) ? Label.TOO_LONG : Label.OK;
        }
    }

    static class NegativeTextAnalyzer extends KeywordAnalyzer implements TextAnalyzer {
        private String[] keywords = new String [] {":(",  "=(" , ":|"};

        public NegativeTextAnalyzer() {}

        @Override
        protected String[] getKeywords() { return keywords;}

        @Override
        protected Label getLabel() { return Label.NEGATIVE_TEXT;}
    }

    static class SpamAnalyzer extends KeywordAnalyzer implements TextAnalyzer {
        private String[] keywords;

        public SpamAnalyzer(String[] keywords) { this.keywords = keywords; }

        @Override
        protected String[] getKeywords() {return keywords; }

        @Override
        protected Label getLabel() {return Label.SPAM; }
    }

    public static Label checkLabels(TextAnalyzer[] analyzers, String text) {
        for (TextAnalyzer analyzer : analyzers) {
            Label res = analyzer.processText(text);
            if (res != Label.OK) {
                return res;
            }
        }
        return Label.OK;
    }
}
