package lesson2;

public class DecisionMakingStatements {
    public static void main(String[] args) {
        // if else
        /*
        if (условие){
            набор инструкций выполнится, если условие1 true
        } else if(условие2){
            набор инструкций выполнится, если условие1 false и условие2 true
        } else if(условие3){
            набор инструкций выполнится, если все пердыдущие условия false и условие3 true
        } else{
            набор инструкций выполнится, если ВСЕ предыдущие условия false
        }
        выполняется только один или ни одного набора инструкций
        */

        int state = 0;
        // 0 - вывксти на экран "Закрытие приложения"
        // 1 - вывксти на экран "Запуск приложения"
        // в остальных случях "Ошибка статуса"
        if (state == 0){
            System.out.println("Закрытие приложения");
        } else if (state == 1) System.out.println("Запyск приложения");
        else{
            System.out.println("Ошибка статуса");
//11 hours 17 minutes
        }

        // логические операторы. Результат - либо true либо false
        // && - "И"
        // || - "ИЛИ"
        // ! - "НЕ"
        // ^ - "Исключающее ИЛИ"
        /*int state = 1;
        int code = 60;
        (state == 0 && code > 100) // false
        int age = 30, exp = 10;
        (age > 30 && exp > 7) // false
        (age > 30 || exp > 7) // true
        !(age > 30 || exp > 7) // false
        boolean isClosed = false;
        !isClosed // true
        ((state == 0 ^ code > 100) || (age >90 && z > 0)) // false*/

        int count = 100;
        // 100 - 90 правильных ответов: 5
        // 89 - 60 правильных ответов: 4
        // 59 - 40 правильных ответов: 3
        // 39 - 0 правильных ответов: 2
        if (count > 100 || count < 0){
            System.out.println("Введена не венрая оценка");
        } else if (count >= 90){
            System.out.println("Оценка 5");
        } else if (count >= 60){
            System.out.println("Оценка 4");
        } else if (count >= 40){
            System.out.println("Оценка 3");
        } else{
            System.out.println("Оценка 2");
        }

        /*
        switch (выражение или переменная){
            case значение1/выражение1:
                инструкции;
                break;
            case значение2/выражение2:
            case значение3/выражение3:
                инструкции;
                break;
            case значение4/выражение4:
                инструкции;
                break;
            default:
                инструкции;
        }
        после совпадения значения переменной с условием case выполняются инструкции только до ближайшего break.
        Если совпадений не найдено, тогда выполняться инструкции блока default, если блока default нет,
        то ничего не выполниться.
        выражение или переменная могут быть:
        byte (Byte), short (Short), char (Character), int (Integer), String, enum (перечисление)
        */

        int sum = 10000;
        int code = 5111;
        // sum - сумма покупок
        // code - дисконтный код
        // 4653 - скидка 30%
        // 5698, 5111 - скидка 20%
        // 6922, 6113, 6099 - скидка 10%
        // в остальных случаях скидки нет
        // вывести сумму с учетом скидки
        switch (code){
            case 4653:
                System.out.println((int) sum * 0.7);
                break;
            case 5698:
            case 5111:
                System.out.println((int)sum * 0.8);
                break;
            case 6922:
            case 6113:
            case 6099:
                System.out.println((int)sum * 0.9);
                break;
            default:
                System.out.println(sum);
        }

    }
}
