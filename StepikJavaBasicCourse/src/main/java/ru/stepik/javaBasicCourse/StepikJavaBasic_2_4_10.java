package ru.stepik.javaBasicCourse;

public class StepikJavaBasic_2_4_10 {

    public static void main(String[] args) {
        String[] roles = new String[]{
                "Городничий",
                "Аммос Федорович",
                "Артемий Филиппович",
                "Лука Лукич"};

        String[] textLines = new String[] {
                "Городничий: Я пригласил вас, господа, с тем, чтобы сообщить вам пренеприятное известие: к нам едет ревизор.",
                "Аммос Федорович: Как ревизор?",
                "Артемий Филиппович: Как ревизор?",
                "Городничий: Ревизор из Петербурга, инкогнито. И еще с секретным предписаньем.",
                "Аммос Федорович: Вот те на!",
                "Артемий Филиппович: Вот не было заботы, так подай!",
                "Лука Лукич: Господи боже! еще и с секретным предписаньем!"};

        System.out.println(printTextPerRole(roles, textLines));
    }

    private static String printTextPerRole(String[] roles, String[] textLines) {
        StringBuilder res = new StringBuilder();

        for (int r = 0; r < roles.length; r++) {
            res.append(roles[r]).append(":").append("\n");
            for (int t = 0; t < textLines.length; t++) {
                int p = textLines[t].indexOf(":");
                if (textLines[t].substring(0,p).equals(roles[r])){
                    res.append(t+1).append(")").append(textLines[t].substring(p+1)).append("\n");
                }
            }

            res.append("\n");
        }
        return res.toString();
    }
}
