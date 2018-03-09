package ru.stepik.javaBasicCourse;

public class StepikJavaBasic_3_5_8 {

    public static void main(String[] args) {
        byte[] data = {65, 66, 67, 68, 69};
        AsciiCharSequence acs = new AsciiCharSequence(data);
        System.out.println(acs);
        System.out.println(acs.length());
        System.out.println(acs.charAt(2));
        System.out.println(acs.subSequence(2, 4));
    }

    public static class AsciiCharSequence implements CharSequence{
        private byte[] arrByte;

        public AsciiCharSequence(byte[] arrByte) {
            this.arrByte = arrByte;
        }

        @Override
        public int length() {
            return arrByte.length;
        }

        @Override
        public char charAt(int index) {
            return (char) arrByte[index];
        }

        @Override
        public CharSequence subSequence(int start, int end) {
            byte[] arrNew = new byte[end - start];
            System.arraycopy(arrByte, start, arrNew, 0, arrNew.length);
            return new AsciiCharSequence(arrNew);
        }

        @Override
        public String toString() {
            return new String(arrByte);
        }
    }
}
