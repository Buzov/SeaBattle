package SeaBattle_V20;


import java.io.IOException;
import java.util.Map;

/**
 * Created by Роман on 15.10.2015.
 */
public class Main {

    /*public static void main(String[] args) throws IOException {
        // запускаем метод, который создает поле битвы и расставляет корабли на поле
        preparationGame();
    }*/

    public static Map <String, Integer> preparationGamer() throws IOException {
        // - Приветствие игрока. Дать возможность ввести имя игрока.

        // ------------------------------   РАССТАНОВКА КОРАБЛЕЙ ДЛЯ ИГРОКА   ------------------------------
                // + Подготовка к игре. Создание поля для игры. Вывести сообщение об успешном завершении операции.
        Battlefield gamer = new Battlefield();
        Map battlefieldGamer = gamer.createOfBattlefield();
        System.out.println("Поле игры ИГРОКА сформировано.");
        System.out.println("");
        //------------------------------------------------------------------------------------------
        // + расставь на поле для игры 4-х палубный корабль. Вывести сообщение об успешном завершении операции.
        Deck4 deck4Gamer = new Deck4(new int[]{411, 412, 413, 414}, 41);
        battlefieldGamer = deck4Gamer.genCoordDeck4(battlefieldGamer); // установка координат корабля
        battlefieldGamer = deck4Gamer.genLimitCoordDeck4(battlefieldGamer); // установка координат границы корабля
        System.out.println("Информационное сообщение: 4-х палубный корабль ИГРОКА на своей позиции. Готов вести огонь!");
        System.out.println("");
        //------------------------------------------------------------------------------------------
        // + расставь на нем 3-х палубные корабли. Вывести сообщение об успешном завершении операции.
        Deck3 deck3_1Gamer = new Deck3(new int[]{311, 312, 313}, 31);
        deck3_1Gamer.genCoordDeck3(battlefieldGamer);
        deck3_1Gamer.genLimitCoordDeck3(battlefieldGamer);
        System.out.println("Информационное сообщение: первый 3-х палубный корабль ИГРОКА на своей позиции. Готов вести огонь!");
        System.out.println("");

        Deck3 deck3_2Gamer = new Deck3(new int[]{321, 322, 323}, 32);
        deck3_2Gamer.genCoordDeck3 (battlefieldGamer);
        deck3_2Gamer.genLimitCoordDeck3(battlefieldGamer);
        System.out.println("Информационное сообщение: второй 3-х палубный корабль ИГРОКА на своей позиции. Готов вести огонь!");
        System.out.println("");
        //------------------------------------------------------------------------------------------
        // + расставь на нем 2-х палубные корабли. Вывести сообщение об успешном завершении операции.
        Deck2 deck2_1Gamer = new Deck2(new int[]{211, 212}, 21);
        deck2_1Gamer.genCoordDeck2 (battlefieldGamer);
        deck2_1Gamer.genLimitCoordDeck2(battlefieldGamer);
        System.out.println("Информационное сообщение: первый 2-х палубный корабль ИГРОКА на своей позиции. Готов вести огонь!");
        System.out.println("");

        Deck2 deck2_2Gamer = new Deck2(new int[]{221, 222}, 22);
        deck2_2Gamer.genCoordDeck2 (battlefieldGamer);
        deck2_2Gamer.genLimitCoordDeck2(battlefieldGamer);
        System.out.println("Информационное сообщение: второй 2-х палубный корабль ИГРОКА на своей позиции. Готов вести огонь!");
        System.out.println("");

        Deck2 deck2_3Gamer = new Deck2(new int[]{231, 232}, 23);
        deck2_3Gamer.genCoordDeck2 (battlefieldGamer);
        deck2_3Gamer.genLimitCoordDeck2(battlefieldGamer);
        System.out.println("Информационное сообщение: третий 2-х палубный корабль ИГРОКА на своей позиции. Готов вести огонь!");
        System.out.println("");
        //------------------------------------------------------------------------------------------
        // + расставь на нем 1-оно палубные корабли. Вывести сообщение об успешном завершении операции.
        Deck1 deck1_1Gamer = new Deck1(new int[]{111}, 11);
        deck1_1Gamer.genCoordDeck1(battlefieldGamer);
        deck1_1Gamer.genLimitCoordDeck1(battlefieldGamer);
        System.out.println("Информационное сообщение: первый 1-но палубный корабль ИГРОКА на своей позиции. Готов вести огонь!");
        System.out.println("");

        Deck1 deck1_2Gamer = new Deck1(new int[]{121}, 12);
        deck1_2Gamer.genCoordDeck1 (battlefieldGamer);
        deck1_2Gamer.genLimitCoordDeck1(battlefieldGamer);
        System.out.println("Информационное сообщение: второй 1-но палубный корабль ИГРОКА на своей позиции. Готов вести огонь!");
        System.out.println("");

        Deck1 deck1_3Gamer = new Deck1(new int[]{131}, 13);
        deck1_3Gamer.genCoordDeck1 (battlefieldGamer);
        deck1_3Gamer.genLimitCoordDeck1(battlefieldGamer);
        System.out.println("Информационное сообщение: третий 1-но палубный корабль ИГРОКА на своей позиции. Готов вести огонь!");
        System.out.println("");

        Deck1 deck1_4Gamer = new Deck1(new int[]{141}, 14);
        deck1_4Gamer.genCoordDeck1 (battlefieldGamer);
        deck1_4Gamer.genLimitCoordDeck1(battlefieldGamer);
        System.out.println("Информационное сообщение: четрвертый 1-но палубный корабль ИГРОКА на своей позиции. Готов вести огонь!");
        System.out.println("");
        
        return battlefieldGamer;
    }
    
    public static Map <String, Integer> preparationComp() throws IOException {
        // ------------------------------   РАССТАНОВКА КОРАБЛЕЙ ДЛЯ КОМПЬЮТЕРА  ------------------------------
        // + Подготовка к игре. Создание поля для игры. Вывести сообщение об успешном завершении операции.
        Battlefield comp = new Battlefield();
        Map battlefieldComp = comp.createOfBattlefield();
        System.out.println("Поле игры ИГРОКА сформировано.");
        System.out.println("");

        //------------------------------------------------------------------------------------------
        // + расставь на поле для игры 4-х палубный корабль. Вывести сообщение об успешном завершении операции.
        Deck4 deck4Comp = new Deck4(new int[]{451, 452, 453, 454}, 45);
        battlefieldComp = deck4Comp.genCoordDeck4(battlefieldComp); // установка координат корабля
        battlefieldComp = deck4Comp.genLimitCoordDeck4(battlefieldComp); // установка координат границы корабля
        System.out.println("Информационное сообщение: 4-х палубный корабль ИГРОКА на своей позиции. Готов вести огонь!");
        System.out.println("");

        //------------------------------------------------------------------------------------------
        // + расставь на нем 3-х палубные корабли. Вывести сообщение об успешном завершении операции.
        Deck3 deck3_1Comp = new Deck3(new int[]{351, 352, 353}, 35);
        deck3_1Comp.genCoordDeck3(battlefieldComp);
        deck3_1Comp.genLimitCoordDeck3(battlefieldComp);
        System.out.println("Информационное сообщение: первый 3-х палубный корабль ИГРОКА на своей позиции. Готов вести огонь!");
        System.out.println("");

        Deck3 deck3_2Comp = new Deck3(new int[]{361, 362, 363}, 36);
        deck3_2Comp.genCoordDeck3 (battlefieldComp);
        deck3_2Comp.genLimitCoordDeck3(battlefieldComp);
        System.out.println("Информационное сообщение: второй 3-х палубный корабль ИГРОКА на своей позиции. Готов вести огонь!");
        System.out.println("");

        //------------------------------------------------------------------------------------------
        // + расставь на нем 2-х палубные корабли. Вывести сообщение об успешном завершении операции.
        Deck2 deck2_1Comp = new Deck2(new int[]{251, 252}, 25);
        deck2_1Comp.genCoordDeck2 (battlefieldComp);
        deck2_1Comp.genLimitCoordDeck2(battlefieldComp);
        System.out.println("Информационное сообщение: первый 2-х палубный корабль ИГРОКА на своей позиции. Готов вести огонь!");
        System.out.println("");

        Deck2 deck2_2Comp = new Deck2(new int[]{261, 262}, 26);
        deck2_2Comp.genCoordDeck2 (battlefieldComp);
        deck2_2Comp.genLimitCoordDeck2(battlefieldComp);
        System.out.println("Информационное сообщение: второй 2-х палубный корабль ИГРОКА на своей позиции. Готов вести огонь!");
        System.out.println("");

        Deck2 deck2_3Comp = new Deck2(new int[]{271, 272}, 27);
        deck2_3Comp.genCoordDeck2 (battlefieldComp);
        deck2_3Comp.genLimitCoordDeck2(battlefieldComp);
        System.out.println("Информационное сообщение: третий 2-х палубный корабль ИГРОКА на своей позиции. Готов вести огонь!");
        System.out.println("");

        //------------------------------------------------------------------------------------------
        // + расставь на нем 1-оно палубные корабли. Вывести сообщение об успешном завершении операции.
        Deck1 deck1_1Comp = new Deck1(new int[]{151}, 15);
        deck1_1Comp.genCoordDeck1(battlefieldComp);
        deck1_1Comp.genLimitCoordDeck1(battlefieldComp);
        System.out.println("Информационное сообщение: первый 1-но палубный корабль ИГРОКА на своей позиции. Готов вести огонь!");
        System.out.println("");

        Deck1 deck1_2Comp = new Deck1(new int[]{161}, 16);
        deck1_2Comp.genCoordDeck1 (battlefieldComp);
        deck1_2Comp.genLimitCoordDeck1(battlefieldComp);
        System.out.println("Информационное сообщение: второй 1-но палубный корабль ИГРОКА на своей позиции. Готов вести огонь!");
        System.out.println("");

        Deck1 deck1_3Comp = new Deck1(new int[]{171}, 17);
        deck1_3Comp.genCoordDeck1 (battlefieldComp);
        deck1_3Comp.genLimitCoordDeck1(battlefieldComp);
        System.out.println("Информационное сообщение: третий 1-но палубный корабль ИГРОКА на своей позиции. Готов вести огонь!");
        System.out.println("");

        Deck1 deck1_4Comp = new Deck1(new int[]{181}, 18);
        deck1_4Comp.genCoordDeck1 (battlefieldComp);
        deck1_4Comp.genLimitCoordDeck1(battlefieldComp);
        System.out.println("Информационное сообщение: четрвертый 1-но палубный корабль ИГРОКА на своей позиции. Готов вести огонь!");
        System.out.println("");

        // ------------------------------   РАССТАНОВКА КОРАБЛЕЙ ДЛЯ КОМПЬЮТЕРА  ------------------------------
        // - Игрок начинает расстреливать корабли (версия 22)
        //System.out.println("-----  НАЧАЛО ИГРЫ  -----");
        //GamerInputAndOutput gi = new GamerInputAndOutput();
        /*for (char i = 65; i < 75; i++) {
            for (int j = 1; j <= 10; j++) {
                String s = String.valueOf(i) + j;

                System.out.println(s + "  " + battlefield.get(s));
            }
        }*/
        //gi.gamerMove(battlefieldComp);
        
        return battlefieldComp;
    }
}