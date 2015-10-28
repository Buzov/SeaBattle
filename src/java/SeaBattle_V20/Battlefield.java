package SeaBattle_V20;

import java.util.HashMap;
import java.util.Map;


public class Battlefield {
    private Map<String, Integer> battlefield = new HashMap<String, Integer>();
    private Map<String, Integer> usedBattlefield = new HashMap<String, Integer>();

    // создание поле битвы
    public Map<String, Integer> createOfBattlefield() {

        for (char i = 65; i < 75; i++) {
            for (int j = 1; j <= 10; j++) {
                String s = String.valueOf(i) + j;
                battlefield.put(s, 0);
                //System.out.println(s + " вывод всех возможный ячеек");
            }
        }
        return battlefield;
    }

    // для NetBeans
    public String createValueForTable (int i, int j) {
        String createValueForTable = Character.toString((char) i) + j;

        return createValueForTable;
    }

    public Map<String, Integer> getUsedBattlefield() {

        return usedBattlefield;
    }

    public Map<String, Integer> getBattlefield() {

        return battlefield;
    }
}

