package ru.stepik.javaBasicCourse;

public class StepikJavaBasic_6_1_12 {

    public static void main(String[] args) {
        Pair<Integer, String> pair = Pair.of(1, "hello");
        Integer i = pair.getFirst(); // 1
        String s = pair.getSecond(); // "hello"

        Pair<Integer, String> pair2 = Pair.of(1, "hello");
        System.out.println(pair.equals(pair2)); // must be true!
        System.out.println(pair.hashCode() == pair2.hashCode());
    }

    static class Pair<N, S> {
        private final N valN;
        private final S valS;

        private Pair() {
            this.valN = null;
            this.valS = null;
        }

        private Pair(N valN, S valS) {
            this.valN = valN;
            this.valS = valS;
        }

        public static <N, S> Pair<N, S> of(N valN1, S valS1) {
            return new Pair<>(valN1, valS1);
        }

        public N getFirst() {
            return this.valN;
        }

        public S getSecond() {
            return this.valS;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == this) return true;
            if (obj == null) return false;
            Pair<N, S> pair2 = (Pair<N, S>) obj;
            if (valN != null ? !valN.equals(pair2.getFirst()) : pair2.getFirst() != null) return false;
            return !(valS != null ? !valS.equals(pair2.getSecond()) : pair2.getSecond() != null);
        }

        @Override
        public int hashCode() {
            return valN.hashCode() + valS.hashCode();
        }
    }
}
