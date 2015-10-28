package SeaBattle_V20;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Map;

/**
 * Created by Роман on 15.10.2015.
 */
public class GamerInputAndOutput {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    ArrayList <Integer> usedDeck3_1 = new ArrayList<>();
    ArrayList <Integer> usedDeck3_2 = new ArrayList<>();
    ArrayList <Integer> usedDeck4 = new ArrayList<>();
    Battlefield b = new Battlefield();
    Battlefield ub = new Battlefield();
    //boolean a = true;
    int c;
    String nameShip = null;
    String gamerInput = null;
    int a = 0;
    
    Map usedBattlefield = ub.getUsedBattlefield(); // должен вернуть пустую коллекцию
    //Map battlefield = b.getBattlefield();
    
    public void setGamerInput (String GamerInput) {
        this.gamerInput = gamerInput;
    }
    
    public int getA (){
        return a;
    }

    public void gamerMove (Map battlefield) throws IOException {
        
        if (gamerInput.equals("Roma")) {
            a = 0;
        } else 
            a = 1;
        
/*
        System.out.println("Сделайте ваш ход: ");
        try{
            String gamerInput = reader.readLine();

            if (usedBattlefield.containsValue(111)
                && usedBattlefield.containsValue(121)
                && usedBattlefield.containsValue(131)
                && usedBattlefield.containsValue(141)
                && usedBattlefield.containsValue(211)
                && usedBattlefield.containsValue(212)
                && usedBattlefield.containsValue(221)
                && usedBattlefield.containsValue(222)
                && usedBattlefield.containsValue(231)
                && usedBattlefield.containsValue(232)
                    usedBattlefield.containsValue(311)
                            && usedBattlefield.containsValue(312)
                            && usedBattlefield.containsValue(313)
                            && usedBattlefield.containsValue(321)
                            && usedBattlefield.containsValue(322)
                            && usedBattlefield.containsValue(323)
                            && usedBattlefield.containsValue(411)
                            && usedBattlefield.containsValue(412)
                            && usedBattlefield.containsValue(413)
                            && usedBattlefield.containsValue(414)) {
                System.out.println("Игра закончена!");
                winner(usedBattlefield);
                System.out.println("проверка победителя пока не реализована");
            }

            if (usedBattlefield.containsKey(gamerInput)) {
                System.out.println("Вы уже проверяли эту координату");
                gamerMove(battlefield);
            }

            usedBattlefield.put(gamerInput, 2);
            c = (int) battlefield.get(gamerInput);
            if ( 0 <= c && c <= 41 ) {
                System.out.println("Мимо");
                gamerMove(battlefield);
                // передать ход компьютеру !!!!!!!!!!!!!!!!!
        } else if ( c == 111 ) {
            String nameShip = "Destroyer №1";
        } else if ( c == 121 ) {
            String nameShip = "Destroyer №2";
        } else if ( c == 131 ) {
            String nameShip = "Destroyer №3";
        } else if ( c == 141 ) {
            String nameShip = "Destroyer №4";
        } else if ( c == 211 || c == 212 ) {
            String nameShip = "LandingShip №1";
        } else if ( c == 221 || c == 222 ) {
            String nameShip = "LandingShip №2";
        } else if ( c == 231 || c == 232 ) {
            String nameShip = "LandingShip №3";
            } else if ( c == 311 || c == 312 || c == 313) {
                nameShip = "Сruiser №1"; // deck3_1
            } else if ( c == 321 || c == 322 || c == 323 ) {
                nameShip = "Сruiser №2"; //deck3_2
            } else if ( c == 411 || c == 412 || c == 413 || c == 414) {
                nameShip = "AircraftCarrier №1"; //deck4
            }

            switch (nameShip) {
                case "Destroyer №1":
                    break;
                case "Destroyer №2":
                    break;
                case "Destroyer №3":
                    break;
                case "Destroyer №4":
                    break;
                case "LandingShip №1":
                    break;
                case "LandingShip №2":
                    break;
                case "LandingShip №3":
                    break;
                case "Сruiser №1":
                    System.out.println("Обозначить попадание в эту координатув в html");
                    usedDeck3_1.add((Integer) battlefield.get(gamerInput));
                    // проверка потопил или ранил
                    if (usedDeck3_1.size() == 3) {
                        System.out.println("Десантный корабль №1 потоплен!");
                        System.out.println("Выводим границы корабля: ");
                        Deck3 deck3_1 = new Deck3(31);
                        battlefield = deck3_1.genLimitCoordDeck3(battlefield);

                        for (char i = 65; i < 75; i++) {
                            for (int j = 1; j <= 10; j++) {
                                String s = String.valueOf(i) + j;

                                if ((int) battlefield.get(s) == 31) {
                                    usedBattlefield.put(s, 2);
                                } else if ((int) battlefield.get(s) == 313 ) {
                                    usedBattlefield.put(s, 313);
                                }
                                //System.out.println(s + " вывод всех возможный ячеек");
                            }
                        }
                        System.out.println(usedBattlefield.values());
                        gamerMove(battlefield);
                    } else {
                        System.out.println("Десантный корабль №1 подбит!");
                        for (char i = 65; i < 75; i++) {
                            for (int j = 1; j <= 10; j++) {
                                String s = String.valueOf(i) + j;

                                if ((int) battlefield.get(s) == 311  && !usedBattlefield.containsValue(311)) {
                                    usedBattlefield.put(s, 311);
                                    gamerMove(battlefield);
                                } else if ((int) battlefield.get(s) == 312 && !usedBattlefield.containsValue(312)) {
                                    usedBattlefield.put(s, 312);
                                    gamerMove(battlefield);
                                }
                                //System.out.println(s + " вывод всех возможный ячеек");
                            }
                        }
                        System.out.println("Продолжает стрелять игрок.");
                    }
                    break;

                case "Сruiser №2":
                    System.out.println("Обозначить попадание в эту координатув в html");
                    usedDeck3_2.add((Integer) battlefield.get(gamerInput));
                    // проверка потопил или ранил
                    if (usedDeck3_2.size() == 3) {
                        System.out.println("Десантный корабль №2 потоплен!");
                        System.out.println("Выводим границы корабля: ");
                        Deck3 deck3_1 = new Deck3(32);
                        battlefield = deck3_1.genLimitCoordDeck3(battlefield);

                        for (char i = 65; i < 75; i++) {
                            for (int j = 1; j <= 10; j++) {
                                String s = String.valueOf(i) + j;

                                if ((int) battlefield.get(s) == 32) {
                                    usedBattlefield.put(s, 2);

                                } else if ((int) battlefield.get(s) == 323 ) {
                                    usedBattlefield.put(s, 323);

                                }
                                //System.out.println(s + " вывод всех возможный ячеек");
                            }
                        }
                        System.out.println(usedBattlefield.values());
                        gamerMove(battlefield);
                    } else {
                        System.out.println("Десантный корабль №2 подбит!");
                        for (char i = 65; i < 75; i++) {
                            for (int j = 1; j <= 10; j++) {
                                String s = String.valueOf(i) + j;

                                if ((int) battlefield.get(s) == 321  && !usedBattlefield.containsValue(321)) {
                                    usedBattlefield.put(s, 321);
                                    gamerMove(battlefield);
                                } else if ((int) battlefield.get(s) == 322  && !usedBattlefield.containsValue(322)) {
                                    usedBattlefield.put(s, 322);
                                    gamerMove(battlefield);
                                }
                                //System.out.println(s + " вывод всех возможный ячеек");
                            }
                        }
                        System.out.println("Продолжает стрелять игрок.");
                    }
                    break;
                case "AircraftCarrier №1":
                    System.out.println("Обозначить попадание в эту координатув в html");
                    usedDeck4.add((Integer) battlefield.get(gamerInput));
                    // проверка потопил или ранил
                    if (usedDeck4.size() == 4) {
                        System.out.println("Авианосец потоплен!");
                        System.out.println("Выводим границы корабля: ");
                        Deck4 deck4 = new Deck4(41);
                        battlefield = deck4.genLimitCoordDeck4(battlefield);

                        for (char i = 65; i < 75; i++) {
                            for (int j = 1; j <= 10; j++) {
                                String s = String.valueOf(i) + j;

                                if ((int) battlefield.get(s) == 41) {
                                    usedBattlefield.put(s, 2);
                                } else if ((int) battlefield.get(s) == 414 ) {
                                    usedBattlefield.put(s, 414);
                                }
                                //System.out.println(s + " вывод всех возможный ячеек");
                            }
                        }
                        System.out.println(usedBattlefield.values());
                        gamerMove(battlefield);
                    } else {
                        System.out.println("Авианосей подбит!");
                        for (char i = 65; i < 75; i++) {
                            for (int j = 1; j <= 10; j++) {
                                String s = String.valueOf(i) + j;

                                if ((int) battlefield.get(s) == 411 && !usedBattlefield.containsValue(411)) {
                                    usedBattlefield.put(s, 411);

                                    gamerMove(battlefield);
                                } else if ((int) battlefield.get(s) == 412 && !usedBattlefield.containsValue(412)) {
                                    usedBattlefield.put(s, 412);
                                    gamerMove(battlefield);
                                } else if ((int) battlefield.get(s) == 413 && !usedBattlefield.containsValue(413)) {
                                    usedBattlefield.put(s, 413);
                                    gamerMove(battlefield);
                                }
                                //System.out.println(s + " вывод всех возможный ячеек");
                            }
                        }
                        System.out.println("Продолжает стрелять игрок.");

                    }
                    break;
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
        }
            */
    }

    // Реализовать метод, определюящий победителя
    public void winner (Map usedBattlefield){
        
    }
    
    

}
