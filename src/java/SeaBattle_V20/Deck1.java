package SeaBattle_V20;

import java.util.Map;

public class Deck1 extends Ships {
    /*private int [] deck1 - массив чисел, передаваемых в конструктор при создании объекта в классе Main,
    * содержит числа 111;  121;  131;  141. Эти числа выступают в качестве value в массиве battlefield
    * для определения однопалубного корабля
    *
    * private int limitDeck1 - число, передаваемое в конструктор при создании объекта Deck2 в классе Main,
    * содержит число 11;  12;  13;  14. Эти числа - выступает в качестве value в массиве battlefield для определения границы
    * однопалубного корабля
    */
    private int[] deck1;
    private int limitDeck1;

    /*
    * rightLimitNumberForLetter (leftLimitNumberForLetter) -  число (от 65 до 74), которое будет преобразовано
    * в букву через char, первая составляющая (т.к координата состоит из буквы и цифры) правой (левой)граничной
    * координаты корабля.
    *
    * topLimitNumber (bottomLimitNumber) - число ( от 1 до 10 ), вторая составляющая (т.к координата состоит
    * из буквы и цифры) верхней (нижней) граничной координаты корабля.
    */

    private int rightLimitNumberForLetter;
    private int leftLimitNumberForLetter;
    private int topLimitNumber;
    private int bottomLimitNumber;

    /* _(1-8)LimitCoordHor ( _(1-8LimitCoordVer ) - (1-я - 8-я) координата границы корабля. В игре существует 9 случаев
    * расположения корабля. От этого будет зависеть колличество координат. Отчет координат границы корабля всегда
    * идет по часовой стрелке.
    */

    private String _1LimitCoord;
    private String _2LimitCoord;
    private String _3LimitCoord;
    private String _4LimitCoord;
    private String _5LimitCoord;
    private String _6LimitCoord;
    private String _7LimitCoord;
    private String _8LimitCoord;

    /* private int firstRandomNumberForLetter - случайное число (в последствии будет преобразованно в букву)
     * для определения буквы (координата состоит из буквы и цифры) единственной координаты однопалубного корабля.
     *
     * private randomNumberForNumber - случайное число (координата состоит из буквы и цифры)единственной координаты
     * однопалубного корабля.
     */
    private int firstRandomNumberForLetter;

    private int randomNumberForNumber;

    /* private String firstCoordinate - кордината однопалубного корабля (например A1).
    */
    private String firstCoordinate;

    // Конструкторы
    public Deck1(int[] deck1, int limitDeck1 ) {

        this.deck1 = deck1;
        this.limitDeck1 = limitDeck1;
    }
    public Deck1 ( int limitDeck1 ) {

        this.limitDeck1 = limitDeck1;
    }

    // МЕТОД, который устанавливает координаты однопалубного корабля
    public Map<String, Integer> genCoordDeck1(Map battlefield) {

        //выбираем случайное число для единственной буквы. Это будут буква координаты однопалубного корабля
        firstRandomNumberForLetter = mFirstRandomNumberForLetter(); // число должно быть от 65 до 74

        // добавляем их в массив для генерации грациц корабля
        battlefield.put("firstRandomNumberForLetter_1deck", firstRandomNumberForLetter);

        // выбираем случайное число для координаты корабля
        randomNumberForNumber = mFirstRandomNumberForNumber(); // число должно быть от 1 до 10

        // добавляем его в массив
        battlefield.put("randomNumberForNumber_1deck", randomNumberForNumber);

        // соодиняем букву и цифру, получаем координаты корабля
        firstCoordinate = Character.toString((char) firstRandomNumberForLetter) + Integer.toString(randomNumberForNumber);

        // Вывод на экран сформировавшихся координат корабля ДО проверки
        System.out.println(firstCoordinate + " координаты корабля для отладки по горизонтали ДО проверки"); // координаты корабля для отладки

        // Выполним проверку, не совпали ли сформировавшиеся координаты с координатами уже установленных кораблей
        if (battlefield.get(firstCoordinate).equals(0)) {
        } else {
            return genCoordDeck1(battlefield);
        }

        // Вывод на экран сформировавшихся координат корабля ПОСЛЕ проверки
        System.out.println(firstCoordinate + " координаты корабля для отладки по горизонтали ПОСЛЕ проверки"); // координаты корабля для отладки

        /* добавляем в массив battlefield наш корабль, ему соответствуют числа 211,212;   221,222;   231,232.
         * Они в дальнейшем понадобяться для сравнения введенного игроком значения с содержимим координаты.
         * Числа и есть содержимое.
         */
        battlefield.replace(firstCoordinate, battlefield.get(firstCoordinate), deck1[0]);


        // добавляем в массив новые значения для генерации границ корабля в другом методе
        battlefield.put("firstCoord_1deck", firstCoordinate);



        return battlefield;
    }
    // МЕТОД, который устанавливает координаты границ однопалубного корабля
    public Map<String, Integer> genLimitCoordDeck1 (Map battlefield) {
        /* В зависимости от первой координаты однопалубного корабля выбираем один из 9 - ти случаев
        *  расположения корабля. Для этого из коллекции Map Battlefield получаем значение
        *  firstCoordinate по ключу firstCoord_1deck.
        */
        int b;
        if (battlefield.get("firstCoord_1deck").equals("A1")) {
            b = 0;
        } else if (battlefield.get("firstCoord_1deck").equals("B1")
                || battlefield.get("firstCoord_1deck").equals("C1")
                || battlefield.get("firstCoord_1deck").equals("D1")
                || battlefield.get("firstCoord_1deck").equals("E1")
                || battlefield.get("firstCoord_1deck").equals("F1")
                || battlefield.get("firstCoord_1deck").equals("G1")
                || battlefield.get("firstCoord_1deck").equals("H1")
                || battlefield.get("firstCoord_1deck").equals("I1")) {
            b = 1;
        } else if (battlefield.get("firstCoord_1deck").equals("J1")) {
            b = 2;
        } else if (battlefield.get("firstCoord_1deck").equals("J2")
                || battlefield.get("firstCoord_1deck").equals("J3")
                || battlefield.get("firstCoord_1deck").equals("J4")
                || battlefield.get("firstCoord_1deck").equals("J5")
                || battlefield.get("firstCoord_1deck").equals("J6")
                || battlefield.get("firstCoord_1deck").equals("J7")
                || battlefield.get("firstCoord_1deck").equals("J8")
                || battlefield.get("firstCoord_1deck").equals("J9")) {
            b = 3;
        } else if (battlefield.get("firstCoord_1deck").equals("J10")) {
            b = 4;
        } else if (battlefield.get("firstCoord_1deck").equals("B10")
                || battlefield.get("firstCoord_1deck").equals("C10")
                || battlefield.get("firstCoord_1deck").equals("D10")
                || battlefield.get("firstCoord_1deck").equals("E10")
                || battlefield.get("firstCoord_1deck").equals("F10")
                || battlefield.get("firstCoord_1deck").equals("G10")
                || battlefield.get("firstCoord_1deck").equals("H10")
                || battlefield.get("firstCoord_1deck").equals("I10")) {
            b = 5;
        } else if (battlefield.get("firstCoord_1deck").equals("A10")) {
            b = 6;
        } else if (battlefield.get("firstCoord_1deck").equals("A2")
                || battlefield.get("firstCoord_1deck").equals("A3")
                || battlefield.get("firstCoord_1deck").equals("A4")
                || battlefield.get("firstCoord_1deck").equals("A5")
                || battlefield.get("firstCoord_1deck").equals("A6")
                || battlefield.get("firstCoord_1deck").equals("A7")
                || battlefield.get("firstCoord_1deck").equals("A8")
                || battlefield.get("firstCoord_1deck").equals("A9")) {
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
                rightLimitNumberForLetter = ((int) battlefield.get("firstRandomNumberForLetter_1deck")) + 1;
                leftLimitNumberForLetter = ((int) battlefield.get("firstRandomNumberForLetter_1deck")) - 1;

                bottomLimitNumber = ((int) battlefield.get("randomNumberForNumber_1deck")) + 1;
                topLimitNumber = ((int) battlefield.get("randomNumberForNumber_1deck")) - 1;

                _1LimitCoord = Character.toString((char) rightLimitNumberForLetter) + ((int) battlefield.get("randomNumberForNumber_1deck"));
                _2LimitCoord = Character.toString((char) rightLimitNumberForLetter) + bottomLimitNumber;
                _3LimitCoord = Character.toString((char) ((int) battlefield.get("firstRandomNumberForLetter_1deck"))) + bottomLimitNumber;

                battlefield.replace(_1LimitCoord, battlefield.get(_1LimitCoord), limitDeck1);
                battlefield.replace(_2LimitCoord, battlefield.get(_2LimitCoord), limitDeck1);
                battlefield.replace(_3LimitCoord, battlefield.get(_3LimitCoord), limitDeck1);

                System.out.println(_1LimitCoord + " " + _2LimitCoord + " " + _3LimitCoord );

                break;
            case 1:
                rightLimitNumberForLetter = ((int) battlefield.get("firstRandomNumberForLetter_1deck")) + 1;
                leftLimitNumberForLetter = ((int) battlefield.get("firstRandomNumberForLetter_1deck")) - 1;
                bottomLimitNumber = ((int) battlefield.get("randomNumberForNumber_1deck")) + 1;

                _1LimitCoord = Character.toString((char) rightLimitNumberForLetter) + ((int) battlefield.get("randomNumberForNumber_1deck"));
                _2LimitCoord = Character.toString((char) rightLimitNumberForLetter) + bottomLimitNumber;
                _3LimitCoord = Character.toString((char) ((int) battlefield.get("firstRandomNumberForLetter_1deck"))) + bottomLimitNumber;
                _4LimitCoord = Character.toString((char) leftLimitNumberForLetter) + bottomLimitNumber;
                _5LimitCoord = Character.toString((char) leftLimitNumberForLetter) + ((int) battlefield.get("randomNumberForNumber_1deck"));

                battlefield.replace(_1LimitCoord, battlefield.get(_1LimitCoord), limitDeck1);
                battlefield.replace(_2LimitCoord, battlefield.get(_2LimitCoord), limitDeck1);
                battlefield.replace(_3LimitCoord, battlefield.get(_3LimitCoord), limitDeck1);
                battlefield.replace(_4LimitCoord, battlefield.get(_4LimitCoord), limitDeck1);
                battlefield.replace(_5LimitCoord, battlefield.get(_5LimitCoord), limitDeck1);

                System.out.println(_1LimitCoord + " " + _2LimitCoord + " " + _3LimitCoord + " " +_4LimitCoord + " " + _5LimitCoord);

                break;
            case 2:
                leftLimitNumberForLetter = ((int) battlefield.get("firstRandomNumberForLetter_1deck")) - 1;
                bottomLimitNumber = ((int) battlefield.get("randomNumberForNumber_1deck")) + 1;

                _1LimitCoord = Character.toString((char) ((int) battlefield.get("firstRandomNumberForLetter_1deck"))) + bottomLimitNumber;
                _2LimitCoord = Character.toString((char) leftLimitNumberForLetter) + bottomLimitNumber;
                _3LimitCoord = Character.toString((char) leftLimitNumberForLetter) + ((int) battlefield.get("randomNumberForNumber_1deck"));

                battlefield.replace(_1LimitCoord, battlefield.get(_1LimitCoord), limitDeck1);
                battlefield.replace(_2LimitCoord, battlefield.get(_2LimitCoord), limitDeck1);
                battlefield.replace(_3LimitCoord, battlefield.get(_3LimitCoord), limitDeck1);

                System.out.println(_1LimitCoord + " " + _2LimitCoord + " " + _3LimitCoord);

                break;
            case 3:
                leftLimitNumberForLetter = ((int) battlefield.get("firstRandomNumberForLetter_1deck")) - 1;
                bottomLimitNumber = ((int) battlefield.get("randomNumberForNumber_1deck")) + 1;
                topLimitNumber = ((int) battlefield.get("randomNumberForNumber_1deck")) - 1;

                _1LimitCoord = Character.toString((char) ((int) battlefield.get("firstRandomNumberForLetter_1deck"))) + bottomLimitNumber;
                _2LimitCoord = Character.toString((char) leftLimitNumberForLetter) + bottomLimitNumber;
                _3LimitCoord = Character.toString((char) leftLimitNumberForLetter) + ((int) battlefield.get("randomNumberForNumber_1deck"));
                _4LimitCoord = Character.toString((char) leftLimitNumberForLetter) + topLimitNumber;
                _5LimitCoord = Character.toString((char) ((int) battlefield.get("firstRandomNumberForLetter_1deck"))) + topLimitNumber;

                battlefield.replace(_1LimitCoord, battlefield.get(_1LimitCoord), limitDeck1);
                battlefield.replace(_2LimitCoord, battlefield.get(_2LimitCoord), limitDeck1);
                battlefield.replace(_3LimitCoord, battlefield.get(_3LimitCoord), limitDeck1);
                battlefield.replace(_4LimitCoord, battlefield.get(_4LimitCoord), limitDeck1);
                battlefield.replace(_5LimitCoord, battlefield.get(_5LimitCoord), limitDeck1);

                System.out.println(_1LimitCoord + " " + _2LimitCoord + " " + _3LimitCoord + " " + _4LimitCoord + " " + _5LimitCoord);

                break;
            case 4:
                leftLimitNumberForLetter = ((int) battlefield.get("firstRandomNumberForLetter_1deck")) - 1;
                topLimitNumber = ((int) battlefield.get("randomNumberForNumber_1deck")) - 1;

                _1LimitCoord = Character.toString((char) leftLimitNumberForLetter) + ((int) battlefield.get("randomNumberForNumber_1deck"));
                _2LimitCoord = Character.toString((char) leftLimitNumberForLetter) + topLimitNumber;
                _3LimitCoord = Character.toString((char) ((int) battlefield.get("firstRandomNumberForLetter_1deck"))) + topLimitNumber;

                battlefield.replace(_1LimitCoord, battlefield.get(_1LimitCoord), limitDeck1);
                battlefield.replace(_2LimitCoord, battlefield.get(_2LimitCoord), limitDeck1);
                battlefield.replace(_3LimitCoord, battlefield.get(_3LimitCoord), limitDeck1);

                System.out.println(_1LimitCoord + " " + _2LimitCoord + " " + _3LimitCoord);

                break;
            case 5:
                rightLimitNumberForLetter = ((int) battlefield.get("firstRandomNumberForLetter_1deck")) + 1;
                leftLimitNumberForLetter = ((int) battlefield.get("firstRandomNumberForLetter_1deck")) - 1;
                topLimitNumber = ((int) battlefield.get("randomNumberForNumber_1deck")) - 1;

                _1LimitCoord = Character.toString((char) leftLimitNumberForLetter) + ((int) battlefield.get("randomNumberForNumber_1deck"));
                _2LimitCoord = Character.toString((char) leftLimitNumberForLetter) + topLimitNumber;
                _3LimitCoord = Character.toString((char) ((int) battlefield.get("firstRandomNumberForLetter_1deck"))) + topLimitNumber;
                _4LimitCoord = Character.toString((char) rightLimitNumberForLetter) + topLimitNumber;
                _5LimitCoord = Character.toString((char) rightLimitNumberForLetter) + ((int) battlefield.get("randomNumberForNumber_1deck"));

                battlefield.replace(_1LimitCoord, battlefield.get(_1LimitCoord), limitDeck1);
                battlefield.replace(_2LimitCoord, battlefield.get(_2LimitCoord), limitDeck1);
                battlefield.replace(_3LimitCoord, battlefield.get(_3LimitCoord), limitDeck1);
                battlefield.replace(_4LimitCoord, battlefield.get(_4LimitCoord), limitDeck1);
                battlefield.replace(_5LimitCoord, battlefield.get(_5LimitCoord), limitDeck1);

                System.out.println(_1LimitCoord + " " + _2LimitCoord + " " + _3LimitCoord + " " + _4LimitCoord + " "+ _5LimitCoord);

                break;
            case 6:
                rightLimitNumberForLetter = ((int) battlefield.get("firstRandomNumberForLetter_1deck")) + 1;
                topLimitNumber = ((int) battlefield.get("randomNumberForNumber_1deck")) - 1;

                _1LimitCoord = Character.toString((char) ((int) battlefield.get("firstRandomNumberForLetter_1deck"))) + topLimitNumber;
                _2LimitCoord = Character.toString((char) rightLimitNumberForLetter) + topLimitNumber;
                _3LimitCoord = Character.toString((char) rightLimitNumberForLetter) + ((int) battlefield.get("randomNumberForNumber_1deck"));

                battlefield.replace(_1LimitCoord, battlefield.get(_1LimitCoord), limitDeck1);
                battlefield.replace(_2LimitCoord, battlefield.get(_2LimitCoord), limitDeck1);
                battlefield.replace(_3LimitCoord, battlefield.get(_3LimitCoord), limitDeck1);

                System.out.println(_1LimitCoord + " " + _2LimitCoord + " " + _3LimitCoord);

                break;
            case 7:
                rightLimitNumberForLetter = ((int) battlefield.get("firstRandomNumberForLetter_1deck")) + 1;
                bottomLimitNumber = ((int) battlefield.get("randomNumberForNumber_1deck")) + 1;
                topLimitNumber = ((int) battlefield.get("randomNumberForNumber_1deck")) - 1;

                _1LimitCoord = Character.toString((char) ((int) battlefield.get("firstRandomNumberForLetter_1deck"))) + topLimitNumber;
                _2LimitCoord = Character.toString((char) rightLimitNumberForLetter) + topLimitNumber;
                _3LimitCoord = Character.toString((char) rightLimitNumberForLetter) + ((int) battlefield.get("randomNumberForNumber_1deck"));
                _4LimitCoord = Character.toString((char) rightLimitNumberForLetter) + bottomLimitNumber;
                _5LimitCoord = Character.toString((char) ((int) battlefield.get("firstRandomNumberForLetter_1deck"))) + bottomLimitNumber;

                battlefield.replace(_1LimitCoord, battlefield.get(_1LimitCoord), limitDeck1);
                battlefield.replace(_2LimitCoord, battlefield.get(_2LimitCoord), limitDeck1);
                battlefield.replace(_3LimitCoord, battlefield.get(_3LimitCoord), limitDeck1);
                battlefield.replace(_4LimitCoord, battlefield.get(_4LimitCoord), limitDeck1);
                battlefield.replace(_5LimitCoord, battlefield.get(_5LimitCoord), limitDeck1);

                System.out.println(_1LimitCoord + " " + _2LimitCoord + " " + _3LimitCoord + " " + _4LimitCoord + " " + _5LimitCoord );

                break;
            case 8:
                rightLimitNumberForLetter = ((int) battlefield.get("firstRandomNumberForLetter_1deck")) + 1;
                leftLimitNumberForLetter = ((int) battlefield.get("firstRandomNumberForLetter_1deck")) - 1;

                bottomLimitNumber = ((int) battlefield.get("randomNumberForNumber_1deck")) + 1;
                topLimitNumber = ((int) battlefield.get("randomNumberForNumber_1deck")) - 1;

                _1LimitCoord = Character.toString((char) leftLimitNumberForLetter) + topLimitNumber;
                _2LimitCoord = Character.toString((char) ((int) battlefield.get("firstRandomNumberForLetter_1deck"))) + topLimitNumber;
                _3LimitCoord = Character.toString((char) rightLimitNumberForLetter) + topLimitNumber;
                _4LimitCoord = Character.toString((char) rightLimitNumberForLetter) + ((int) battlefield.get("randomNumberForNumber_1deck"));
                _5LimitCoord = Character.toString((char) rightLimitNumberForLetter) + bottomLimitNumber;
                _6LimitCoord = Character.toString((char) ((int) battlefield.get("firstRandomNumberForLetter_1deck"))) + bottomLimitNumber;
                _7LimitCoord = Character.toString((char) leftLimitNumberForLetter) + bottomLimitNumber;
                _8LimitCoord = Character.toString((char) leftLimitNumberForLetter) + ((int) battlefield.get("randomNumberForNumber_1deck"));

                battlefield.replace(_1LimitCoord, battlefield.get(_1LimitCoord), limitDeck1);
                battlefield.replace(_2LimitCoord, battlefield.get(_2LimitCoord), limitDeck1);
                battlefield.replace(_3LimitCoord, battlefield.get(_3LimitCoord), limitDeck1);
                battlefield.replace(_4LimitCoord, battlefield.get(_4LimitCoord), limitDeck1);
                battlefield.replace(_5LimitCoord, battlefield.get(_5LimitCoord), limitDeck1);
                battlefield.replace(_6LimitCoord, battlefield.get(_6LimitCoord), limitDeck1);
                battlefield.replace(_7LimitCoord, battlefield.get(_7LimitCoord), limitDeck1);
                battlefield.replace(_8LimitCoord, battlefield.get(_8LimitCoord), limitDeck1);

                System.out.println(_1LimitCoord + " " + _2LimitCoord + " " + _3LimitCoord + " " + _4LimitCoord
                        + " " + _5LimitCoord + " " + _6LimitCoord + " " + _7LimitCoord + " " + _8LimitCoord);
                break;
        }

        return battlefield;
    } // выход из метода, определяющий границы корабля
} // выход из класса

