package com.github.leventarican;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 
 * @author Levent
 */
public class DataTypes {
    
    Logger log = Logger.getLogger(DataTypes.class.getSimpleName());
    
    public void exec() {
        {   // arrays
            int[] numbers = new int[3];
            String[] programmingLang = {"java", "python"};

            for (int i = 0; i < numbers.length; i++) {
                numbers[i] = new Random().nextInt(10);
            }
            for (int number : numbers) {
                log.log(Level.INFO, "number: {0}", number);
            }
            
            for (String pl : programmingLang) {
                log.info(pl);
            }
            
            int[][] array2D = new int[2][2];
            for (int i = 0; i < array2D.length; i++) {
                for (int j = 0; j < array2D[array2D.length-1].length; j++) {
                    array2D[i][j] = new Random().nextInt(10);
                }
            }
            log.log(Level.INFO, "array2D[0][0]: {0}", array2D[0][0]);
            log.log(Level.INFO, "array2D[0][1]: {0}", array2D[0][1]);
            log.log(Level.INFO, "array2D[1][1]: {0}", array2D[1][1]);
        }
    }
}

