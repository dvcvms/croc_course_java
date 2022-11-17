package ru.croc.task9;

public class Task9 {

    public static void main(String[] args) {

        String[] tests = {
                "../../../CROC/work/src/../../../../../university/../../../../../../../memes/cats/1ph_oto01/../../../",
                "./././CROC/work/src/./././././university/./././././././memes/cats/1ph_oto01/./././",
                "CROC/work/src/university/memes/cats/1ph_oto01",
                "../CROC/work/src/../university/../memes/cats/1ph_oto01/../",
                "./CROC/work/src/./university/./memes/cats/1ph_oto01/./",
                "./../CROC/work/src/./../university/./../memes/cats/1ph_oto01/./../",
                ".././CROC/work/src/.././university/.././memes/cats/1ph_oto01/.././",
                "КРОК/работа/src/./../../универ/../../../мемы/котики",
                "../../../КРОК/работа/src/../../../../../university/../../../../../../../мемы/cats/1ph_oto01/../../../",
                "./././КРОК/работа/src/./././././универ/./././././././мемы/cats/1ph_oto01/./././",
                "КРОК/работа/src/универ/мемы/cats/1ph_oto01",
                "../КРОК/работа/src/../универ/../мемы/cats/1ph_oto01/../",
                "./КРОК/работа/src/./универ/./мемы/cats/1ph_oto01/./",
                "./../КРОК/работа/src/./../универ/./../мемы/cats/1ph_oto01/./../",
                ".././КРОК/работа/src/.././универ/.././мемы/cats/1ph_oto01/.././",
                "../КРОК/работа/src/./../../универ/мемы/котики"
        };

        String[] answers = {
                "../../../../../../../../../../../",
                "CROC/work/src/university/memes/cats/1ph_oto01",
                "CROC/work/src/university/memes/cats/1ph_oto01",
                "../CROC/work/memes/cats",
                "CROC/work/src/university/memes/cats/1ph_oto01",
                "../CROC/work/memes/cats",
                "../CROC/work/memes/cats",
                "../мемы/котики",
                "../../../../../../../../../../../",
                "КРОК/работа/src/универ/мемы/cats/1ph_oto01",
                "КРОК/работа/src/универ/мемы/cats/1ph_oto01",
                "../КРОК/работа/мемы/cats",
                "КРОК/работа/src/универ/мемы/cats/1ph_oto01",
                "../КРОК/работа/мемы/cats",
                "../КРОК/работа/мемы/cats",
                "../КРОК/универ/мемы/котики"
        };

        for (int i = 0; i < Math.min(tests.length, answers.length); i++) {
            String t = Normalization.normalizePath(tests[i]);
            boolean b = t.equals(answers[i]);

            if (!b) {
                System.out.print("Тест " + i + " = ");
                System.out.println("неправильный:");
                System.out.println(t);
                System.out.println(answers[i]);
                System.out.println();
            } else {
                System.out.println("Тест " + i + " - " + b);
            }
        }
    }
}
