package com.github.leventarican.network;

/**
 * Developer hub.
 *
 * @author levent
 */
public class Hub {

    private static final Developer[] developers;

    static {
        developers = Hub.generateData();
    }
    
    public static Developer[] getDevelopers() {
        return developers;
    }

    public static Developer[] generateData() {
        String[] namesList = {
            "foo", "bar", "mem", "cpu", "cod", "exc", "ram"
        };
        String[] languagesList = {
            "java", "cpp", "python", "dart", "go"
        };

        int amount = 50;
        Developer[] data = new Developer[amount];

        for (int i = 0; i < amount; i++) {
            data[i] = new Developer();
            data[i].id = i;
            data[i].name = namesList[(int) (Math.random() * namesList.length)] + namesList[(int) (Math.random() * namesList.length)];
            
            int languagesLength = (int) (Math.random() * languagesList.length);
            data[i].languages = new ProgrammingLanguage[languagesLength];
            for (int j = 0; j < languagesLength; j++) {
                data[i].languages[j] = new ProgrammingLanguage();
                data[i].languages[j].setName(languagesList[(int) (Math.random() * languagesList.length)]);
            }
        }

        return data;
    }
}
