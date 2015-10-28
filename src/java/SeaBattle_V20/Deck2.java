package SeaBattle_V20;

import java.util.Map;

public class Deck2 extends Ships {
    /*private int [] deck2 - массив чисел, передаваемых в конструктор при создании объекта в классе Main,
    * содержит числа 211,212;   221,222;   231,232. Эти числа выступают в качестве value в массиве battlefield
    * для определения двухпалубного корабля
    *
    * private int limitDeck2 - число, передаваемое в конструктор при создании объекта Deck2 в классе Main,
    * содержит число 21; 22; 23. Это число - выступает в качестве value в массиве battlefield для определения границы
    * двухпалубного корабля
    */
    private int[] deck2;
    private int limitDeck2;

    /*
    * rightLimitNumberForLetterHor (leftLimitNumberForLetterHor)-  число (от 65 до 74), которое будет преобразовано
    * в букву через char, первая составляющая (т.к координата состоит из буквы и цифры) правой (левой)граничной
    * координаты корабля для случая горизонтальной установки корабля (Hor).
    *
    * rightLimitNumberForLetterVer (leftLimitNumberForLetterVer)-  число (от 65 до 74), которое будет преобразовано
    * в букву через char, первая составляющая (т.к координата состоит из буквы и цифры) правой (левой)граничной
    * координаты корабля для случая вертикальной установки корабля (Ver).
    *
    * topLimitNumberHor (bottomLimitNumberHor) - число ( от 1 до 10 ), вторая составляющая (т.к координата состоит
    * из буквы и цифры) верхней (нижней) граничной координаты корабля для случая горизонтальной установки корабля (Hor)
    *
    * topLimitNumberVer (bottomLimitNumberVer) - число ( от 1 до 10 ), вторая составляющая (т.к координата состоит
    * из буквы и цифры) верхней (нижней) граничной координаты корабля для случая вертикальной установки корабля (Ver).
    */

    private int rightLimitNumberForLetterHor;
    private int leftLimitNumberForLetterHor;
    private int topLimitNumberHor;
    private int bottomLimitNumberHor;

    private int rightLimitNumberForLetterVer;
    private int leftLimitNumberForLetterVer;
    private int topLimitNumberVer;
    private int bottomLimitNumberVer;

    /* _(1-10)LimitCoordHor ( _(1-10LimitCoordVer ) - (1-я - 10-я) координата границы корабля для случая
    * горизонтальной (вертикальной) установки корабля. В игре существует 9 случаев горизонтального (вертикального)
    * расположения корабля. От этого будет зависеть колличество координат. Отчет координат границы корабля всегда
    * идет по часовой стрелке.
    */

    private String _1LimitCoordHor;
    private String _2LimitCoordHor;
    private String _3LimitCoordHor;
    private String _4LimitCoordHor;
    private String _5LimitCoordHor;
    private String _6LimitCoordHor;
    private String _7LimitCoordHor;
    private String _8LimitCoordHor;
    private String _9LimitCoordHor;
    private String _10LimitCoordHor;

    private String _1LimitCoordVer;
    private String _2LimitCoordVer;
    private String _3LimitCoordVer;
    private String _4LimitCoordVer;
    private String _5LimitCoordVer;
    private String _6LimitCoordVer;
    private String _7LimitCoordVer;
    private String _8LimitCoordVer;
    private String _9LimitCoordVer;
    private String _10LimitCoordVer;

    /* private int firstRandomNumberForLetterHor (secondRandomNumberForLetterHor) -
     * случайное число (в последствии будет преобразованно в букву)
     * для определения буквы (координата состоит из буквы и цифры) первой (второй, соответственно)
     * координаты двухпалубного корабля по горизонтали
     *
     * private randomNumberForNumberHor - случайное число (координата состоит из буквы и цифры)
     * первой, второй, соответственно координаты двухпалубного корабля по горизонтали.
     * Не забываем, корабль находить по горизонтали, поэтому число одно, а буквы 2.
     */
    private int firstRandomNumberForLetterHor;
    private int secondRandomNumberForLetterHor;

    private int randomNumberForNumberHor;

    /* private int firstRandomNumberForNumberVer (secondRandomNumberForNumberVer -
     * случайное число (координата состоит из буквы и цифры)
     * первой (второй, третьей соответственно) координаты двухпалубного корабля по вертикали
     *
     * private randomNumberForLetterVer - случайное число (в последствии будет преобразованно в букву)для
     * определения буквы (координата состоит из буквы и цифры) первой координаты двухпалубного корабля по вертикали
     * Не забываем, корабль находить по вертикали, поэтому буква одна (цифры, в последствии будут преобразованы в буквы),
     * а цифры три.
     */
    private int firstRandomNumberForNumberVer;
    private int secondRandomNumberForNumberVer;

    private int randomNumberForLetterVer;

    /* private String firstCoordinateHor (secondCoordinateHor ) - координаты двухпалубного корабля по горизонтали (например A1, B1)
    *
    * private String firstCoordinateVer (secondCoordinateVer) - координаты двухпалубного корабля по вертикали (например A1, A2)
    */
    private String firstCoordinateHor;
    private String secondCoordinateHor;

    private String firstCoordinateVer;
    private String secondCoordinateVer;

    // Конструкторы
    public Deck2(int[] deck2, int limitDeck2 ) {

        this.deck2 = deck2;
        this.limitDeck2 = limitDeck2;
    }
    public Deck2 ( int limitDeck2 ) {

        this.limitDeck2 = limitDeck2;
    }

    // МЕТОД, который устанавливает координаты 2-х палубного корабля
    public Map<String, Integer> genCoordDeck2(Map battlefield) {

        // вызываем метод, опередляющий положение корабля путем генерации числа 0 или 1 (горизонтально или вертикально)
        int verOrHorPositionOfSpips = verOrHorPositionOfSpips();

        // в зависимости от выбранного числа метод ветвиться на case 0,  case 1.
        switch (verOrHorPositionOfSpips) {
            case 0:
                //выбираем случайное число для первой буквы и генерируем еще 1 числ0. Это будут буквы координат2-х палубного корабля
                firstRandomNumberForLetterHor = (int) (Math.random() * 9 + 65); // число должно быть от 65 до 73
                secondRandomNumberForLetterHor = firstRandomNumberForLetterHor + 1;

                // добавляем их в массив для генерации грациц корабля
                battlefield.put("firstRandomNumberForLetter_2deck", firstRandomNumberForLetterHor);
                battlefield.put("secondRandomNumberForLetter_2deck", secondRandomNumberForLetterHor);

                // выбираем случайное число для координаты корабля
                randomNumberForNumberHor = mFirstRandomNumberForNumber(); // число должно быть от 1 до 10

                // добавляем его в массив
                battlefield.put("randomNumberForNumber_2deck", randomNumberForNumberHor);

                // соодиняем букву и цифру, получаем координаты корабля
                firstCoordinateHor = Character.toString((char) firstRandomNumberForLetterHor) + Integer.toString(randomNumberForNumberHor);
                secondCoordinateHor = Character.toString((char) secondRandomNumberForLetterHor) + Integer.toString(randomNumberForNumberHor);

                // Вывод на экран сформировавшихся координат корабля ДО проверки
                System.out.println(firstCoordinateHor + " " + secondCoordinateHor+
                        " координаты корабля для отладки по горизонтали ДО проверки"); // координаты корабля для отладки

                // Выполним проверку, не совпали ли сформировавшиеся координаты с координатами уже установленных кораблей
                if (battlefield.get(firstCoordinateHor).equals(0)
                        && battlefield.get(secondCoordinateHor).equals(0)) {
                } else {
                    return genCoordDeck2(battlefield);
                }

                // Вывод на экран сформировавшихся координат корабля ПОСЛЕ проверки
                System.out.println(firstCoordinateHor + " " + secondCoordinateHor +
                        " координаты корабля для отладки по горизонтали ПОСЛЕ проверки"); // координаты корабля для отладки

                /* добавляем в массив battlefield наш корабль, ему соответствуют числа 211,212;   221,222;   231,232.
                 * Они в дальнейшем понадобяться для сравнения введенного игроком значения с содержимим координаты.
                 * Числа и есть содержимое.
                 */
                battlefield.replace(firstCoordinateHor, battlefield.get(firstCoordinateHor), deck2[0]);
                battlefield.replace(secondCoordinateHor, battlefield.get(secondCoordinateHor), deck2[1]);

                // добавляем в массив новые значения для генерации границ корабля в другом методе
                battlefield.put("positionOfDeck2", verOrHorPositionOfSpips);
                battlefield.put("firstCoord_2deck", firstCoordinateHor);
                battlefield.put("secondCoord_2deck", secondCoordinateHor);

                break;

            case 1:
                //выбираем случайное число для буквы. Это будет единственная буква координат 2-х палубного корабля
                randomNumberForLetterVer = mFirstRandomNumberForLetter(); // число должно быть от 65 до 74

                // добавляем в массив для генерации границ корабля
                battlefield.put("randomNumberForLetter_2deck", randomNumberForLetterVer);

                // выбираем случайную цифру от 1 до 9, она будет показывать в каком ряде находиться первая координата корабля
                firstRandomNumberForNumberVer = (int) (Math.random() * 9 + 1); // число должно быть от 1 до 9
                secondRandomNumberForNumberVer = firstRandomNumberForNumberVer + 1;

                //добавляем в массив новые значения для генерации границ корабля в другом методе
                battlefield.put("firstRandomNumberForNumber_2deck", firstRandomNumberForNumberVer);
                battlefield.put("secondRandomNumberForNumber_2deck", secondRandomNumberForNumberVer);

                // соодиняем букву и цифру, получаем координаты корабля
                firstCoordinateVer = Character.toString((char) randomNumberForLetterVer) + Integer.toString(firstRandomNumberForNumberVer);
                secondCoordinateVer = Character.toString((char) randomNumberForLetterVer) + Integer.toString(secondRandomNumberForNumberVer);

                // Вывод на экран сформировавшихся координат корабля ДО проверки
                System.out.println(firstCoordinateVer + " " + secondCoordinateVer +
                        " координаты корабля для отладки по вертикали ДО проверки"); // координаты корабля для отладки

                // Выполним проверку, не совпали ли сформировавшиеся координаты с координатами уже установленных кораблей
                if (battlefield.get(firstCoordinateVer).equals(0)
                        && battlefield.get(secondCoordinateVer).equals(0)) {
                } else {
                    return genCoordDeck2(battlefield);
                }

                // Вывод на экран сформировавшихся координат корабля ПОСЛЕ проверки
                System.out.println(firstCoordinateVer + " " + secondCoordinateVer +
                        " координаты корабля для отладки по вертикали ПОСЛЕ проверки"); // координаты корабля для отладки

                /* добавляем в массив battlefield наш корабль, ему соответствуют числа 211,212;   221,222;   231,232.
                 * Они в дальнейшем понадобяться для сравнения введенного игроком значения с содержимим координаты.
                 * Числа и есть содержимое.
                 */
                battlefield.replace(firstCoordinateVer, battlefield.get(firstCoordinateVer), deck2[0]);
                battlefield.replace(secondCoordinateVer, battlefield.get(secondCoordinateVer), deck2[1]);

                // добавляем в массив новые значения для генерации границ корабля в другом методе
                battlefield.put("positionOfDeck2", verOrHorPositionOfSpips);
                battlefield.put("firstCoord_2deck", firstCoordinateVer);
                battlefield.put("secondCoord_2deck", secondCoordinateVer);

                System.out.println(firstCoordinateVer + " " + secondCoordinateVer
                        + " координаты корабля для отладки по вертикали"); // для отладки координаты корабля по вертикали


                break;
        } return battlefield;
    }
    // МЕТОД, который устанавливает координаты границ 2-х палубного корабля
    public Map<String, Integer> genLimitCoordDeck2 (Map battlefield) {

        /* В игре есть 9 вариантов расположения корабля ГОРИЗОНТАЛЬНО (case 0) и  9 вариантов расположения корабля
         * ВЕРТИКАЛЬНО (case 1) в контексте относительно границ поля игры.
         * Необходимо описать каждый из вариантов. Выбор между вариантами будет выполнен с помощью оператора switch.
         * Для этого в коллекции Map battlefield получаем значение (value) verOrHorPositionOfSpips по ключу
         * positionOfDeck2.
         */
        switch ((int) battlefield.get("positionOfDeck2")) {
            case 0:
                /* В зависимости от первой координаты двухпалубного корабля выбираем один из 9 - ти случаев
                 * ГОРИЗОНТАЛЬНОГО расположения корабля. Для этого из коллекции Map Battlefield получаем значение
                 * firstCoordinateHor по ключу firstCoord_2deck.
                 */
                int b;
                if (battlefield.get("firstCoord_2deck").equals("A1")) {
                    b = 0;
                } else if (battlefield.get("firstCoord_2deck").equals("B1")
                        || battlefield.get("firstCoord_2deck").equals("C1")
                        || battlefield.get("firstCoord_2deck").equals("D1")
                        || battlefield.get("firstCoord_2deck").equals("E1")
                        || battlefield.get("firstCoord_2deck").equals("F1")
                        || battlefield.get("firstCoord_2deck").equals("G1")
                        || battlefield.get("firstCoord_2deck").equals("H1")) {
                    b = 1;
                } else if (battlefield.get("firstCoord_2deck").equals("I1")) {
                    b = 2;
                } else if (battlefield.get("firstCoord_2deck").equals("I2")
                        || battlefield.get("firstCoord_2deck").equals("I3")
                        || battlefield.get("firstCoord_2deck").equals("I4")
                        || battlefield.get("firstCoord_2deck").equals("I5")
                        || battlefield.get("firstCoord_2deck").equals("I6")
                        || battlefield.get("firstCoord_2deck").equals("I7")
                        || battlefield.get("firstCoord_2deck").equals("I8")
                        || battlefield.get("firstCoord_2deck").equals("I9")) {
                    b = 3;
                } else if (battlefield.get("firstCoord_2deck").equals("I10")) {
                    b = 4;
                } else if (battlefield.get("firstCoord_2deck").equals("B10")
                        || battlefield.get("firstCoord_2deck").equals("C10")
                        || battlefield.get("firstCoord_2deck").equals("D10")
                        || battlefield.get("firstCoord_2deck").equals("E10")
                        || battlefield.get("firstCoord_2deck").equals("F10")
                        || battlefield.get("firstCoord_2deck").equals("G10")
                        || battlefield.get("firstCoord_2deck").equals("H10")) {
                    b = 5;
                } else if (battlefield.get("firstCoord_2deck").equals("A10")) {
                    b = 6;
                } else if (battlefield.get("firstCoord_2deck").equals("A2")
                        || battlefield.get("firstCoord_2deck").equals("A3")
                        || battlefield.get("firstCoord_2deck").equals("A4")
                        || battlefield.get("firstCoord_2deck").equals("A5")
                        || battlefield.get("firstCoord_2deck").equals("A6")
                        || battlefield.get("firstCoord_2deck").equals("A7")
                        || battlefield.get("firstCoord_2deck").equals("A8")
                        || battlefield.get("firstCoord_2deck").equals("A9")) {
                    b = 7;
                } else {
                    b = 8;
                }
                //System.out.println(b + " число для выбора switch"); // Для отладки программы

                /* Исходя из выбранного числа b выбираем один из девяти случаев расположения корабля и расставляем границы корабля
                 * Переменные описаны выше.
                 */
                switch (b) {
                    case 0:
                        rightLimitNumberForLetterHor = ((int) battlefield.get("secondRandomNumberForLetter_2deck")) + 1;
                        leftLimitNumberForLetterHor = ((int) battlefield.get("firstRandomNumberForLetter_2deck")) - 1;

                        bottomLimitNumberHor = ((int) battlefield.get("randomNumberForNumber_2deck")) + 1;
                        topLimitNumberHor = ((int) battlefield.get("randomNumberForNumber_2deck")) - 1;

                        _1LimitCoordHor = Character.toString((char) rightLimitNumberForLetterHor) + ((int) battlefield.get("randomNumberForNumber_2deck"));
                        _2LimitCoordHor = Character.toString((char) rightLimitNumberForLetterHor) + bottomLimitNumberHor;
                        _3LimitCoordHor = Character.toString((char) ((int) battlefield.get("secondRandomNumberForLetter_2deck"))) + bottomLimitNumberHor;
                        _4LimitCoordHor = Character.toString((char) ((int) battlefield.get("firstRandomNumberForLetter_2deck"))) + bottomLimitNumberHor;

                        battlefield.replace(_1LimitCoordHor, battlefield.get(_1LimitCoordHor), limitDeck2);
                        battlefield.replace(_2LimitCoordHor, battlefield.get(_2LimitCoordHor), limitDeck2);
                        battlefield.replace(_3LimitCoordHor, battlefield.get(_3LimitCoordHor), limitDeck2);
                        battlefield.replace(_4LimitCoordHor, battlefield.get(_4LimitCoordHor), limitDeck2);

                        System.out.println(_1LimitCoordHor + " " + _2LimitCoordHor + " " + _3LimitCoordHor + " " + _4LimitCoordHor);

                        break;
                    case 1:
                        rightLimitNumberForLetterHor = ((int) battlefield.get("secondRandomNumberForLetter_2deck")) + 1;
                        leftLimitNumberForLetterHor = ((int) battlefield.get("firstRandomNumberForLetter_2deck")) - 1;
                        bottomLimitNumberHor = ((int) battlefield.get("randomNumberForNumber_2deck")) + 1;

                        _1LimitCoordHor = Character.toString((char) rightLimitNumberForLetterHor) + ((int) battlefield.get("randomNumberForNumber_2deck"));
                        _2LimitCoordHor = Character.toString((char) rightLimitNumberForLetterHor) + bottomLimitNumberHor;
                        _3LimitCoordHor = Character.toString((char) ((int) battlefield.get("secondRandomNumberForLetter_2deck"))) + bottomLimitNumberHor;
                        _4LimitCoordHor = Character.toString((char) ((int) battlefield.get("firstRandomNumberForLetter_2deck"))) + bottomLimitNumberHor;
                        _5LimitCoordHor = Character.toString((char) leftLimitNumberForLetterHor) + bottomLimitNumberHor;
                        _6LimitCoordHor = Character.toString((char) leftLimitNumberForLetterHor) + ((int) battlefield.get("randomNumberForNumber_2deck"));

                        battlefield.replace(_1LimitCoordHor, battlefield.get(_1LimitCoordHor), limitDeck2);
                        battlefield.replace(_2LimitCoordHor, battlefield.get(_2LimitCoordHor), limitDeck2);
                        battlefield.replace(_3LimitCoordHor, battlefield.get(_3LimitCoordHor), limitDeck2);
                        battlefield.replace(_4LimitCoordHor, battlefield.get(_4LimitCoordHor), limitDeck2);
                        battlefield.replace(_5LimitCoordHor, battlefield.get(_5LimitCoordHor), limitDeck2);
                        battlefield.replace(_6LimitCoordHor, battlefield.get(_6LimitCoordHor), limitDeck2);

                        System.out.println(_1LimitCoordHor + " " + _2LimitCoordHor + " " + _3LimitCoordHor + " " +_4LimitCoordHor
                                + " " + _5LimitCoordHor + " " + _6LimitCoordHor);

                        break;
                    case 2:
                        leftLimitNumberForLetterHor = ((int) battlefield.get("firstRandomNumberForLetter_2deck")) - 1;
                        bottomLimitNumberHor = ((int) battlefield.get("randomNumberForNumber_2deck")) + 1;

                        _1LimitCoordHor = Character.toString((char) ((int) battlefield.get("secondRandomNumberForLetter_2deck"))) + bottomLimitNumberHor;
                        _2LimitCoordHor = Character.toString((char) ((int) battlefield.get("firstRandomNumberForLetter_2deck"))) + bottomLimitNumberHor;
                        _3LimitCoordHor = Character.toString((char) leftLimitNumberForLetterHor) + bottomLimitNumberHor;
                        _4LimitCoordHor = Character.toString((char) leftLimitNumberForLetterHor) + ((int) battlefield.get("randomNumberForNumber_2deck"));

                        battlefield.replace(_1LimitCoordHor, battlefield.get(_1LimitCoordHor), limitDeck2);
                        battlefield.replace(_2LimitCoordHor, battlefield.get(_2LimitCoordHor), limitDeck2);
                        battlefield.replace(_3LimitCoordHor, battlefield.get(_3LimitCoordHor), limitDeck2);
                        battlefield.replace(_4LimitCoordHor, battlefield.get(_4LimitCoordHor), limitDeck2);

                        System.out.println(_1LimitCoordHor + " " + _2LimitCoordHor + " " + _3LimitCoordHor + " " + _4LimitCoordHor);

                        break;
                    case 3:
                        leftLimitNumberForLetterHor = ((int) battlefield.get("firstRandomNumberForLetter_2deck")) - 1;
                        bottomLimitNumberHor = ((int) battlefield.get("randomNumberForNumber_2deck")) + 1;
                        topLimitNumberHor = ((int) battlefield.get("randomNumberForNumber_2deck")) - 1;

                        _1LimitCoordHor = Character.toString((char) ((int) battlefield.get("secondRandomNumberForLetter_2deck"))) + bottomLimitNumberHor;
                        _2LimitCoordHor = Character.toString((char) ((int) battlefield.get("firstRandomNumberForLetter_2deck"))) + bottomLimitNumberHor;
                        _3LimitCoordHor = Character.toString((char) leftLimitNumberForLetterHor) + bottomLimitNumberHor;
                        _4LimitCoordHor = Character.toString((char) leftLimitNumberForLetterHor) + ((int) battlefield.get("randomNumberForNumber_2deck"));
                        _5LimitCoordHor = Character.toString((char) leftLimitNumberForLetterHor) + topLimitNumberHor;
                        _6LimitCoordHor = Character.toString((char) ((int) battlefield.get("firstRandomNumberForLetter_2deck"))) + topLimitNumberHor;
                        _7LimitCoordHor = Character.toString((char) ((int) battlefield.get("secondRandomNumberForLetter_2deck"))) + topLimitNumberHor;

                        battlefield.replace(_1LimitCoordHor, battlefield.get(_1LimitCoordHor), limitDeck2);
                        battlefield.replace(_2LimitCoordHor, battlefield.get(_2LimitCoordHor), limitDeck2);
                        battlefield.replace(_3LimitCoordHor, battlefield.get(_3LimitCoordHor), limitDeck2);
                        battlefield.replace(_4LimitCoordHor, battlefield.get(_4LimitCoordHor), limitDeck2);
                        battlefield.replace(_5LimitCoordHor, battlefield.get(_5LimitCoordHor), limitDeck2);
                        battlefield.replace(_6LimitCoordHor, battlefield.get(_6LimitCoordHor), limitDeck2);
                        battlefield.replace(_7LimitCoordHor, battlefield.get(_7LimitCoordHor), limitDeck2);

                        System.out.println(_1LimitCoordHor + " " + _2LimitCoordHor + " " + _3LimitCoordHor + " " + _4LimitCoordHor
                                + " " + _5LimitCoordHor + " " + _6LimitCoordHor + " " + _7LimitCoordHor);

                        break;
                    case 4:
                        leftLimitNumberForLetterHor = ((int) battlefield.get("firstRandomNumberForLetter_2deck")) - 1;
                        topLimitNumberHor = ((int) battlefield.get("randomNumberForNumber_2deck")) - 1;

                        _1LimitCoordHor = Character.toString((char) leftLimitNumberForLetterHor) + ((int) battlefield.get("randomNumberForNumber_2deck"));
                        _2LimitCoordHor = Character.toString((char) leftLimitNumberForLetterHor) + topLimitNumberHor;
                        _3LimitCoordHor = Character.toString((char) ((int) battlefield.get("firstRandomNumberForLetter_2deck"))) + topLimitNumberHor;
                        _4LimitCoordHor = Character.toString((char) ((int) battlefield.get("secondRandomNumberForLetter_2deck"))) + topLimitNumberHor;

                        battlefield.replace(_1LimitCoordHor, battlefield.get(_1LimitCoordHor), limitDeck2);
                        battlefield.replace(_2LimitCoordHor, battlefield.get(_2LimitCoordHor), limitDeck2);
                        battlefield.replace(_3LimitCoordHor, battlefield.get(_3LimitCoordHor), limitDeck2);
                        battlefield.replace(_4LimitCoordHor, battlefield.get(_4LimitCoordHor), limitDeck2);

                        System.out.println(_1LimitCoordHor + " " + _2LimitCoordHor + " " + _3LimitCoordHor + " " + _4LimitCoordHor);

                        break;
                    case 5:
                        rightLimitNumberForLetterHor = ((int) battlefield.get("secondRandomNumberForLetter_2deck")) + 1;
                        leftLimitNumberForLetterHor = ((int) battlefield.get("firstRandomNumberForLetter_2deck")) - 1;
                        topLimitNumberHor = ((int) battlefield.get("randomNumberForNumber_2deck")) - 1;

                        _1LimitCoordHor = Character.toString((char) leftLimitNumberForLetterHor) + ((int) battlefield.get("randomNumberForNumber_2deck"));
                        _2LimitCoordHor = Character.toString((char) leftLimitNumberForLetterHor) + topLimitNumberHor;
                        _3LimitCoordHor = Character.toString((char) ((int) battlefield.get("secondRandomNumberForLetter_2deck"))) + topLimitNumberHor;
                        _4LimitCoordHor = Character.toString((char) ((int) battlefield.get("firstRandomNumberForLetter_2deck"))) + topLimitNumberHor;
                        _5LimitCoordHor = Character.toString((char) rightLimitNumberForLetterHor) + topLimitNumberHor;
                        _6LimitCoordHor = Character.toString((char) rightLimitNumberForLetterHor) + ((int) battlefield.get("randomNumberForNumber_2deck"));

                        battlefield.replace(_1LimitCoordHor, battlefield.get(_1LimitCoordHor), limitDeck2);
                        battlefield.replace(_2LimitCoordHor, battlefield.get(_2LimitCoordHor), limitDeck2);
                        battlefield.replace(_3LimitCoordHor, battlefield.get(_3LimitCoordHor), limitDeck2);
                        battlefield.replace(_4LimitCoordHor, battlefield.get(_4LimitCoordHor), limitDeck2);
                        battlefield.replace(_5LimitCoordHor, battlefield.get(_5LimitCoordHor), limitDeck2);
                        battlefield.replace(_6LimitCoordHor, battlefield.get(_6LimitCoordHor), limitDeck2);

                        System.out.println(_1LimitCoordHor + " " + _2LimitCoordHor + " " + _3LimitCoordHor + " " + _4LimitCoordHor
                                + " " + _5LimitCoordHor + " " + _6LimitCoordHor);

                        break;
                    case 6:
                        rightLimitNumberForLetterHor = ((int) battlefield.get("secondRandomNumberForLetter_2deck")) + 1;
                        topLimitNumberHor = ((int) battlefield.get("randomNumberForNumber_2deck")) - 1;

                        _1LimitCoordHor = Character.toString((char) ((int) battlefield.get("firstRandomNumberForLetter_2deck"))) + topLimitNumberHor;
                        _2LimitCoordHor = Character.toString((char) ((int) battlefield.get("secondRandomNumberForLetter_2deck"))) + topLimitNumberHor;
                        _3LimitCoordHor = Character.toString((char) rightLimitNumberForLetterHor) + topLimitNumberHor;
                        _4LimitCoordHor = Character.toString((char) rightLimitNumberForLetterHor) + ((int) battlefield.get("randomNumberForNumber_2deck"));

                        battlefield.replace(_1LimitCoordHor, battlefield.get(_1LimitCoordHor), limitDeck2);
                        battlefield.replace(_2LimitCoordHor, battlefield.get(_2LimitCoordHor), limitDeck2);
                        battlefield.replace(_3LimitCoordHor, battlefield.get(_3LimitCoordHor), limitDeck2);
                        battlefield.replace(_4LimitCoordHor, battlefield.get(_4LimitCoordHor), limitDeck2);

                        System.out.println(_1LimitCoordHor + " " + _2LimitCoordHor + " " + _3LimitCoordHor + " " + _4LimitCoordHor);

                        break;
                    case 7:
                        rightLimitNumberForLetterHor = ((int) battlefield.get("secondRandomNumberForLetter_2deck")) + 1;
                        bottomLimitNumberHor = ((int) battlefield.get("randomNumberForNumber_2deck")) + 1;
                        topLimitNumberHor = ((int) battlefield.get("randomNumberForNumber_2deck")) - 1;

                        _1LimitCoordHor = Character.toString((char) ((int) battlefield.get("firstRandomNumberForLetter_2deck"))) + topLimitNumberHor;
                        _2LimitCoordHor = Character.toString((char) ((int) battlefield.get("secondRandomNumberForLetter_2deck"))) + topLimitNumberHor;
                        _3LimitCoordHor = Character.toString((char) rightLimitNumberForLetterHor) + topLimitNumberHor;
                        _4LimitCoordHor = Character.toString((char) rightLimitNumberForLetterHor) + ((int) battlefield.get("randomNumberForNumber_2deck"));
                        _5LimitCoordHor = Character.toString((char) rightLimitNumberForLetterHor) + bottomLimitNumberHor;
                        _6LimitCoordHor = Character.toString((char) ((int) battlefield.get("secondRandomNumberForLetter_2deck"))) + bottomLimitNumberHor;
                        _7LimitCoordHor = Character.toString((char) ((int) battlefield.get("firstRandomNumberForLetter_2deck"))) + bottomLimitNumberHor;

                        battlefield.replace(_1LimitCoordHor, battlefield.get(_1LimitCoordHor), limitDeck2);
                        battlefield.replace(_2LimitCoordHor, battlefield.get(_2LimitCoordHor), limitDeck2);
                        battlefield.replace(_3LimitCoordHor, battlefield.get(_3LimitCoordHor), limitDeck2);
                        battlefield.replace(_4LimitCoordHor, battlefield.get(_4LimitCoordHor), limitDeck2);
                        battlefield.replace(_5LimitCoordHor, battlefield.get(_5LimitCoordHor), limitDeck2);
                        battlefield.replace(_6LimitCoordHor, battlefield.get(_6LimitCoordHor), limitDeck2);
                        battlefield.replace(_7LimitCoordHor, battlefield.get(_7LimitCoordHor), limitDeck2);

                        System.out.println(_1LimitCoordHor + " " + _2LimitCoordHor + " " + _3LimitCoordHor + " " + _4LimitCoordHor
                                + " " + _5LimitCoordHor + " " + _6LimitCoordHor + " " + _7LimitCoordHor);

                        break;
                    case 8:
                        rightLimitNumberForLetterHor = ((int) battlefield.get("secondRandomNumberForLetter_2deck")) + 1;
                        leftLimitNumberForLetterHor = ((int) battlefield.get("firstRandomNumberForLetter_2deck")) - 1;

                        bottomLimitNumberHor = ((int) battlefield.get("randomNumberForNumber_2deck")) + 1;
                        topLimitNumberHor = ((int) battlefield.get("randomNumberForNumber_2deck")) - 1;

                        _1LimitCoordHor = Character.toString((char) leftLimitNumberForLetterHor) + topLimitNumberHor;
                        _2LimitCoordHor = Character.toString((char) ((int) battlefield.get("firstRandomNumberForLetter_2deck"))) + topLimitNumberHor;
                        _3LimitCoordHor = Character.toString((char) ((int) battlefield.get("secondRandomNumberForLetter_2deck"))) + topLimitNumberHor;
                        _4LimitCoordHor = Character.toString((char) rightLimitNumberForLetterHor) + topLimitNumberHor;
                        _5LimitCoordHor = Character.toString((char) rightLimitNumberForLetterHor) + ((int) battlefield.get("randomNumberForNumber_2deck"));
                        _6LimitCoordHor = Character.toString((char) rightLimitNumberForLetterHor) + bottomLimitNumberHor;
                        _7LimitCoordHor = Character.toString((char) ((int) battlefield.get("secondRandomNumberForLetter_2deck"))) + bottomLimitNumberHor;
                        _8LimitCoordHor = Character.toString((char) ((int) battlefield.get("firstRandomNumberForLetter_2deck"))) + bottomLimitNumberHor;
                        _9LimitCoordHor = Character.toString((char) leftLimitNumberForLetterHor) + bottomLimitNumberHor;
                        _10LimitCoordHor = Character.toString((char) leftLimitNumberForLetterHor) + ((int) battlefield.get("randomNumberForNumber_2deck"));

                        battlefield.replace(_1LimitCoordHor, battlefield.get(_1LimitCoordHor), limitDeck2);
                        battlefield.replace(_2LimitCoordHor, battlefield.get(_2LimitCoordHor), limitDeck2);
                        battlefield.replace(_3LimitCoordHor, battlefield.get(_3LimitCoordHor), limitDeck2);
                        battlefield.replace(_4LimitCoordHor, battlefield.get(_4LimitCoordHor), limitDeck2);
                        battlefield.replace(_5LimitCoordHor, battlefield.get(_5LimitCoordHor), limitDeck2);
                        battlefield.replace(_6LimitCoordHor, battlefield.get(_6LimitCoordHor), limitDeck2);
                        battlefield.replace(_7LimitCoordHor, battlefield.get(_7LimitCoordHor), limitDeck2);
                        battlefield.replace(_8LimitCoordHor, battlefield.get(_8LimitCoordHor), limitDeck2);
                        battlefield.replace(_9LimitCoordHor, battlefield.get(_9LimitCoordHor), limitDeck2);
                        battlefield.replace(_10LimitCoordHor, battlefield.get(_10LimitCoordHor), limitDeck2);

                        System.out.println(_1LimitCoordHor + " " + _2LimitCoordHor + " " + _3LimitCoordHor + " " + _4LimitCoordHor
                                + " " + _5LimitCoordHor + " " + _6LimitCoordHor + " " + _7LimitCoordHor + " " + _8LimitCoordHor + " " +
                                _9LimitCoordHor + " " + _10LimitCoordHor);
                        break;
                } break;
            case 1:
                /* В зависимости от первой координаты двухпалубного корабля выбираем один из 9 - ти случаев
                 * ВЕРТИКАЛЬНО расположения корабля. Для этого из коллекции Map Battlefield получаем значение
                 * firstCoordinateVer по ключу firstCoord_2deck.
                 */
                int c = 0;
                if (battlefield.get("firstCoord_2deck").equals("A1")) {
                    c = 0;
                } else if (battlefield.get("firstCoord_2deck").equals("B1")
                        || battlefield.get("firstCoord_2deck").equals("C1")
                        || battlefield.get("firstCoord_2deck").equals("D1")
                        || battlefield.get("firstCoord_2deck").equals("E1")
                        || battlefield.get("firstCoord_2deck").equals("F1")
                        || battlefield.get("firstCoord_2deck").equals("G1")
                        || battlefield.get("firstCoord_2deck").equals("H1")
                        || battlefield.get("firstCoord_2deck").equals("I1")) {
                    c = 1;
                } else if (battlefield.get("firstCoord_2deck").equals("J1")) {
                    c = 2;
                } else if (battlefield.get("firstCoord_2deck").equals("J2")
                        || battlefield.get("firstCoord_2deck").equals("J3")
                        || battlefield.get("firstCoord_2deck").equals("J4")
                        || battlefield.get("firstCoord_2deck").equals("J5")
                        || battlefield.get("firstCoord_2deck").equals("J6")
                        || battlefield.get("firstCoord_2deck").equals("J7")
                        || battlefield.get("firstCoord_2deck").equals("J8")) {
                    c = 3;
                } else if (battlefield.get("firstCoord_2deck").equals("J9")) {
                    c = 4;
                } else if (battlefield.get("firstCoord_2deck").equals("B7")
                        || battlefield.get("firstCoord_2deck").equals("C7")
                        || battlefield.get("firstCoord_2deck").equals("D7")
                        || battlefield.get("firstCoord_2deck").equals("E7")
                        || battlefield.get("firstCoord_2deck").equals("F7")
                        || battlefield.get("firstCoord_2deck").equals("G7")
                        || battlefield.get("firstCoord_2deck").equals("H7")
                        || battlefield.get("firstCoord_2deck").equals("I7")) {
                    c = 5;
                } else if (battlefield.get("firstCoord_2deck").equals("A7")) {
                    c = 6;
                } else if (battlefield.get("firstCoord_2deck").equals("A2")
                        || battlefield.get("firstCoord_2deck").equals("A3")
                        || battlefield.get("firstCoord_2deck").equals("A4")
                        || battlefield.get("firstCoord_2deck").equals("A5")
                        || battlefield.get("firstCoord_2deck").equals("A6")
                        || battlefield.get("firstCoord_2deck").equals("A7")
                        || battlefield.get("firstCoord_2deck").equals("A8")) {
                    c = 7;
                } else {
                    c = 8;
                }
                //System.out.println(b + " число для выбора switch"); // Для отладки программы

                /* Исходя из выбранного числа b выбираем один из девяти случаев расположения корабля и расставляем границы корабля
                 * Переменные описаны выше.
                 */
                switch (c) {
                    case 0:
                        rightLimitNumberForLetterVer = ((int) battlefield.get("randomNumberForLetter_2deck")) + 1;
                        leftLimitNumberForLetterVer = ((int) battlefield.get("randomNumberForLetter_2deck")) - 1;

                        bottomLimitNumberVer = ((int) battlefield.get("secondRandomNumberForNumber_2deck")) + 1;
                        topLimitNumberVer = ((int) battlefield.get("firstRandomNumberForNumber_2deck")) - 1;

                        _1LimitCoordVer = Character.toString((char) rightLimitNumberForLetterVer) + ((int) battlefield.get("firstRandomNumberForNumber_2deck"));
                        _2LimitCoordVer = Character.toString((char) rightLimitNumberForLetterVer) + ((int) battlefield.get("secondRandomNumberForNumber_deck"));
                        _3LimitCoordVer = Character.toString((char) rightLimitNumberForLetterVer) + bottomLimitNumberVer;
                        _4LimitCoordVer = Character.toString((char) ((int) battlefield.get("randomNumberForLetter_2deck"))) + bottomLimitNumberVer;

                        battlefield.replace(_1LimitCoordVer, battlefield.get(_1LimitCoordVer), limitDeck2);
                        battlefield.replace(_2LimitCoordVer, battlefield.get(_2LimitCoordVer), limitDeck2);
                        battlefield.replace(_3LimitCoordVer, battlefield.get(_3LimitCoordVer), limitDeck2);
                        battlefield.replace(_4LimitCoordVer, battlefield.get(_4LimitCoordVer), limitDeck2);

                        System.out.println(_1LimitCoordVer + " " + _2LimitCoordVer + " " + _3LimitCoordVer + " " + _4LimitCoordVer);

                        break;
                    case 1:
                        rightLimitNumberForLetterVer = ((int) battlefield.get("randomNumberForLetter_2deck")) + 1;
                        leftLimitNumberForLetterVer = ((int) battlefield.get("randomNumberForLetter_2deck")) - 1;
                        bottomLimitNumberVer = ((int) battlefield.get("secondRandomNumberForNumber_2deck")) + 1;

                        _1LimitCoordVer = Character.toString((char) rightLimitNumberForLetterVer) + ((int) battlefield.get("firstRandomNumberForNumber_2deck"));
                        _2LimitCoordVer = Character.toString((char) rightLimitNumberForLetterVer) + ((int) battlefield.get("secondRandomNumberForNumber_2deck"));
                        _3LimitCoordVer = Character.toString((char) rightLimitNumberForLetterVer) + bottomLimitNumberVer;
                        _4LimitCoordVer = Character.toString((char) ((int) battlefield.get("randomNumberForLetter_2deck"))) + bottomLimitNumberVer;
                        _5LimitCoordVer = Character.toString((char) leftLimitNumberForLetterVer) + bottomLimitNumberVer;
                        _6LimitCoordVer = Character.toString((char) leftLimitNumberForLetterVer) + ((int) battlefield.get("secondRandomNumberForNumber_2deck"));
                        _7LimitCoordVer = Character.toString((char) leftLimitNumberForLetterVer) + ((int) battlefield.get("firstRandomNumberForNumber_2deck"));

                        battlefield.replace(_1LimitCoordVer, battlefield.get(_1LimitCoordVer), limitDeck2);
                        battlefield.replace(_2LimitCoordVer, battlefield.get(_2LimitCoordVer), limitDeck2);
                        battlefield.replace(_3LimitCoordVer, battlefield.get(_3LimitCoordVer), limitDeck2);
                        battlefield.replace(_4LimitCoordVer, battlefield.get(_4LimitCoordVer), limitDeck2);
                        battlefield.replace(_5LimitCoordVer, battlefield.get(_5LimitCoordVer), limitDeck2);
                        battlefield.replace(_6LimitCoordVer, battlefield.get(_6LimitCoordVer), limitDeck2);
                        battlefield.replace(_7LimitCoordVer, battlefield.get(_7LimitCoordVer), limitDeck2);

                        System.out.println(_1LimitCoordVer + " " + _2LimitCoordVer + " " + _3LimitCoordVer + " " + _4LimitCoordVer
                                + " " + _5LimitCoordVer + " " + _6LimitCoordVer + " " + _7LimitCoordVer);

                        break;
                    case 2:
                        leftLimitNumberForLetterVer = ((int) battlefield.get("randomNumberForLetter_2deck")) - 1;
                        bottomLimitNumberVer = ((int) battlefield.get("secondRandomNumberForNumber_2deck")) + 1;

                        _1LimitCoordVer = Character.toString((char) ((int) battlefield.get("randomNumberForLetter_2deck"))) + bottomLimitNumberVer;
                        _2LimitCoordVer = Character.toString((char) leftLimitNumberForLetterVer) + bottomLimitNumberVer;
                        _3LimitCoordVer = Character.toString((char) leftLimitNumberForLetterVer) + ((int) battlefield.get("secondRandomNumberForNumber_2deck"));
                        _4LimitCoordVer = Character.toString((char) leftLimitNumberForLetterVer) + ((int) battlefield.get("firstRandomNumberForNumber_2deck"));

                        battlefield.replace(_1LimitCoordVer, battlefield.get(_1LimitCoordVer), limitDeck2);
                        battlefield.replace(_2LimitCoordVer, battlefield.get(_2LimitCoordVer), limitDeck2);
                        battlefield.replace(_3LimitCoordVer, battlefield.get(_3LimitCoordVer), limitDeck2);
                        battlefield.replace(_4LimitCoordVer, battlefield.get(_4LimitCoordVer), limitDeck2);

                        System.out.println(_1LimitCoordVer + " " + _2LimitCoordVer + " " + _3LimitCoordVer + " " + _4LimitCoordVer);

                        break;
                    case 3:
                        leftLimitNumberForLetterVer = ((int) battlefield.get("randomNumberForLetter_2deck")) - 1;
                        bottomLimitNumberVer = ((int) battlefield.get("secondRandomNumberForNumber_2deck")) + 1;
                        topLimitNumberVer = ((int) battlefield.get("firstRandomNumberForNumber_2deck")) - 1;

                        _1LimitCoordVer = Character.toString((char) ((int) battlefield.get("randomNumberForLetter_2deck"))) + bottomLimitNumberVer;
                        _2LimitCoordVer = Character.toString((char) leftLimitNumberForLetterVer) + bottomLimitNumberVer;
                        _3LimitCoordVer = Character.toString((char) leftLimitNumberForLetterVer) + ((int) battlefield.get("secondRandomNumberForNumber_2deck"));
                        _4LimitCoordVer = Character.toString((char) leftLimitNumberForLetterVer) + ((int) battlefield.get("firstRandomNumberForNumber_2deck"));
                        _5LimitCoordVer = Character.toString((char) leftLimitNumberForLetterVer) + topLimitNumberVer;
                        _6LimitCoordVer = Character.toString((char) ((int) battlefield.get("randomNumberForLetter_2deck"))) + topLimitNumberVer;

                        battlefield.replace(_1LimitCoordVer, battlefield.get(_1LimitCoordVer), limitDeck2);
                        battlefield.replace(_2LimitCoordVer, battlefield.get(_2LimitCoordVer), limitDeck2);
                        battlefield.replace(_3LimitCoordVer, battlefield.get(_3LimitCoordVer), limitDeck2);
                        battlefield.replace(_4LimitCoordVer, battlefield.get(_4LimitCoordVer), limitDeck2);
                        battlefield.replace(_5LimitCoordVer, battlefield.get(_5LimitCoordVer), limitDeck2);
                        battlefield.replace(_6LimitCoordVer, battlefield.get(_6LimitCoordVer), limitDeck2);

                        System.out.println(_1LimitCoordVer + " " + _2LimitCoordVer + " " + _3LimitCoordVer + " " + _4LimitCoordVer
                                + " " + _5LimitCoordVer + " " + _6LimitCoordVer);

                        break;
                    case 4:
                        leftLimitNumberForLetterVer = ((int) battlefield.get("randomNumberForLetter_2deck")) - 1;
                        topLimitNumberVer = ((int) battlefield.get("firstRandomNumberForNumber_2deck")) - 1;

                        _1LimitCoordVer = Character.toString((char) leftLimitNumberForLetterVer) + ((int) battlefield.get("secondRandomNumberForNumber_2deck"));
                        _2LimitCoordVer = Character.toString((char) leftLimitNumberForLetterVer) + ((int) battlefield.get("firstRandomNumberForNumber_2deck"));
                        _3LimitCoordVer = Character.toString((char) leftLimitNumberForLetterVer) + topLimitNumberVer;
                        _4LimitCoordVer = Character.toString((char) ((int) battlefield.get("randomNumberForLetter_2deck"))) + topLimitNumberVer;

                        battlefield.replace(_1LimitCoordVer, battlefield.get(_1LimitCoordVer), limitDeck2);
                        battlefield.replace(_2LimitCoordVer, battlefield.get(_2LimitCoordVer), limitDeck2);
                        battlefield.replace(_3LimitCoordVer, battlefield.get(_3LimitCoordVer), limitDeck2);
                        battlefield.replace(_4LimitCoordVer, battlefield.get(_4LimitCoordVer), limitDeck2);

                        System.out.println(_1LimitCoordVer + " " + _2LimitCoordVer + " " + _3LimitCoordVer + " " + _4LimitCoordVer);

                        break;
                    case 5:
                        rightLimitNumberForLetterVer = ((int) battlefield.get("randomNumberForLetter_2deck")) + 1;
                        leftLimitNumberForLetterVer = ((int) battlefield.get("randomNumberForLetter_2deck")) - 1;
                        topLimitNumberVer = ((int) battlefield.get("firstRandomNumberForNumber_2deck")) - 1;

                        _1LimitCoordVer = Character.toString((char) leftLimitNumberForLetterVer) + ((int) battlefield.get("secondRandomNumberForNumber_2deck"));
                        _2LimitCoordVer = Character.toString((char) leftLimitNumberForLetterVer) + ((int) battlefield.get("firstRandomNumberForNumber_2deck"));
                        _3LimitCoordVer = Character.toString((char) leftLimitNumberForLetterVer) + topLimitNumberVer;
                        _4LimitCoordVer = Character.toString((char) ((int) battlefield.get("randomNumberForLetter_2deck"))) + topLimitNumberVer;
                        _5LimitCoordVer = Character.toString((char) rightLimitNumberForLetterVer) + topLimitNumberVer;
                        _6LimitCoordVer = Character.toString((char) rightLimitNumberForLetterVer) + ((int) battlefield.get("firstRandomNumberForNumber_2deck"));
                        _7LimitCoordVer = Character.toString((char) rightLimitNumberForLetterVer) + ((int) battlefield.get("secondRandomNumberForNumber_2deck"));

                        battlefield.replace(_1LimitCoordVer, battlefield.get(_1LimitCoordVer), limitDeck2);
                        battlefield.replace(_2LimitCoordVer, battlefield.get(_2LimitCoordVer), limitDeck2);
                        battlefield.replace(_3LimitCoordVer, battlefield.get(_3LimitCoordVer), limitDeck2);
                        battlefield.replace(_4LimitCoordVer, battlefield.get(_4LimitCoordVer), limitDeck2);
                        battlefield.replace(_5LimitCoordVer, battlefield.get(_5LimitCoordVer), limitDeck2);
                        battlefield.replace(_6LimitCoordVer, battlefield.get(_6LimitCoordVer), limitDeck2);
                        battlefield.replace(_7LimitCoordVer, battlefield.get(_7LimitCoordVer), limitDeck2);

                        System.out.println(_1LimitCoordVer + " " + _2LimitCoordVer + " " + _3LimitCoordVer + " " + _4LimitCoordVer
                                + " " + _5LimitCoordVer + " " + _6LimitCoordVer + " " + _7LimitCoordVer);

                        break;
                    case 6:
                        rightLimitNumberForLetterVer = ((int) battlefield.get("randomNumberForLetter_2deck")) + 1;
                        topLimitNumberVer = ((int) battlefield.get("firstRandomNumberForNumber_2deck")) - 1;

                        _1LimitCoordVer = Character.toString((char) ((int) battlefield.get("randomNumberForLetter_2deck"))) + topLimitNumberVer;
                        _2LimitCoordVer = Character.toString((char) rightLimitNumberForLetterVer) + topLimitNumberVer;
                        _3LimitCoordVer = Character.toString((char) rightLimitNumberForLetterVer) + ((int) battlefield.get("firstRandomNumberForNumber_2deck"));
                        _4LimitCoordVer = Character.toString((char) rightLimitNumberForLetterVer) + ((int) battlefield.get("secondRandomNumberForNumber_2deck"));

                        battlefield.replace(_1LimitCoordVer, battlefield.get(_1LimitCoordVer), limitDeck2);
                        battlefield.replace(_2LimitCoordVer, battlefield.get(_2LimitCoordVer), limitDeck2);
                        battlefield.replace(_3LimitCoordVer, battlefield.get(_3LimitCoordVer), limitDeck2);
                        battlefield.replace(_4LimitCoordVer, battlefield.get(_4LimitCoordVer), limitDeck2);

                        System.out.println(_1LimitCoordVer + " " + _2LimitCoordVer + " " + _3LimitCoordVer + " " + _4LimitCoordVer);

                        break;
                    case 7:
                        rightLimitNumberForLetterVer = ((int) battlefield.get("randomNumberForLetter_2deck")) + 1;
                        bottomLimitNumberVer = ((int) battlefield.get("secondRandomNumberForNumber_2deck")) + 1;
                        topLimitNumberVer = ((int) battlefield.get("firstRandomNumberForNumber_2deck")) - 1;

                        _1LimitCoordVer = Character.toString((char) ((int) battlefield.get("randomNumberForLetter_2deck"))) + topLimitNumberVer;
                        _2LimitCoordVer = Character.toString((char) rightLimitNumberForLetterVer) + topLimitNumberVer;
                        _3LimitCoordVer = Character.toString((char) rightLimitNumberForLetterVer) + ((int) battlefield.get("firstRandomNumberForNumber_2deck"));
                        _4LimitCoordVer = Character.toString((char) rightLimitNumberForLetterVer) + ((int) battlefield.get("secondRandomNumberForNumber_2deck"));
                        _5LimitCoordVer = Character.toString((char) rightLimitNumberForLetterVer) + bottomLimitNumberVer;
                        _6LimitCoordVer = Character.toString((char) ((int) battlefield.get("randomNumberForLetter_2deck"))) + bottomLimitNumberVer;

                        battlefield.replace(_1LimitCoordVer, battlefield.get(_1LimitCoordVer), limitDeck2);
                        battlefield.replace(_2LimitCoordVer, battlefield.get(_2LimitCoordVer), limitDeck2);
                        battlefield.replace(_3LimitCoordVer, battlefield.get(_3LimitCoordVer), limitDeck2);
                        battlefield.replace(_4LimitCoordVer, battlefield.get(_4LimitCoordVer), limitDeck2);
                        battlefield.replace(_5LimitCoordVer, battlefield.get(_5LimitCoordVer), limitDeck2);
                        battlefield.replace(_6LimitCoordVer, battlefield.get(_6LimitCoordVer), limitDeck2);

                        System.out.println(_1LimitCoordVer + " " + _2LimitCoordVer + " " + _3LimitCoordVer + " " + _4LimitCoordVer
                                + " " + _5LimitCoordVer + " " + _6LimitCoordVer);

                        break;
                    case 8:
                        rightLimitNumberForLetterVer = ((int) battlefield.get("randomNumberForLetter_2deck")) + 1;
                        leftLimitNumberForLetterVer = ((int) battlefield.get("randomNumberForLetter_2deck")) - 1;
                        bottomLimitNumberVer = ((int) battlefield.get("secondRandomNumberForNumber_2deck")) + 1;
                        topLimitNumberVer = ((int) battlefield.get("firstRandomNumberForNumber_2deck")) - 1;

                        _1LimitCoordVer = Character.toString((char) leftLimitNumberForLetterVer) + topLimitNumberVer;
                        _2LimitCoordVer = Character.toString((char) ((int) battlefield.get("randomNumberForLetter_2deck"))) + topLimitNumberVer;
                        _3LimitCoordVer = Character.toString((char) rightLimitNumberForLetterVer) + topLimitNumberVer;
                        _4LimitCoordVer = Character.toString((char) rightLimitNumberForLetterVer) + ((int) battlefield.get("firstRandomNumberForNumber_2deck"));
                        _5LimitCoordVer = Character.toString((char) rightLimitNumberForLetterVer) + ((int) battlefield.get("secondRandomNumberForNumber_2deck"));
                        _6LimitCoordVer = Character.toString((char) rightLimitNumberForLetterVer) + bottomLimitNumberVer;
                        _7LimitCoordVer = Character.toString((char) ((int) battlefield.get("randomNumberForLetter_2deck"))) + bottomLimitNumberVer;
                        _8LimitCoordVer = Character.toString((char) leftLimitNumberForLetterVer) + bottomLimitNumberVer;
                        _9LimitCoordVer = Character.toString((char) leftLimitNumberForLetterVer) + ((int) battlefield.get("secondRandomNumberForNumber_2deck"));
                        _10LimitCoordVer = Character.toString((char) leftLimitNumberForLetterVer) + ((int) battlefield.get("firstRandomNumberForNumber_2deck"));

                        battlefield.replace(_1LimitCoordVer, battlefield.get(_1LimitCoordVer), limitDeck2);
                        battlefield.replace(_2LimitCoordVer, battlefield.get(_2LimitCoordVer), limitDeck2);
                        battlefield.replace(_3LimitCoordVer, battlefield.get(_3LimitCoordVer), limitDeck2);
                        battlefield.replace(_4LimitCoordVer, battlefield.get(_4LimitCoordVer), limitDeck2);
                        battlefield.replace(_5LimitCoordVer, battlefield.get(_5LimitCoordVer), limitDeck2);
                        battlefield.replace(_6LimitCoordVer, battlefield.get(_6LimitCoordVer), limitDeck2);
                        battlefield.replace(_7LimitCoordVer, battlefield.get(_7LimitCoordVer), limitDeck2);
                        battlefield.replace(_8LimitCoordVer, battlefield.get(_8LimitCoordVer), limitDeck2);
                        battlefield.replace(_9LimitCoordVer, battlefield.get(_9LimitCoordVer), limitDeck2);
                        battlefield.replace(_10LimitCoordVer, battlefield.get(_10LimitCoordVer), limitDeck2);

                        System.out.println(_1LimitCoordVer + " " + _2LimitCoordVer + " " + _3LimitCoordVer + " " + _4LimitCoordVer
                                + " " + _5LimitCoordVer + " " + _6LimitCoordVer + " " + _7LimitCoordVer + " " + _8LimitCoordVer
                                + " " + _9LimitCoordVer + " " + _10LimitCoordVer);
                        break; // выход из case 8:
                }

                break; // выход из case 1
        } //конец switch ((int) battlefield.get("positionOfDeck2")) {
        return battlefield;
    } // выход из метода, определяющий границы корабля
} // выход из класса

