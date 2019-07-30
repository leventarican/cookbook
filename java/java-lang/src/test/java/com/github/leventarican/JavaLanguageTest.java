package com.github.leventarican;

import static org.junit.Assert.assertTrue;

import com.github.leventarican.neuronalnetwork.Perceptron;
import org.junit.Test;

/**
 * TDD - like
 */
public class JavaLanguageTest {

    @Test
    public void neuronalNetworkLogicalOr() {
        Perceptron perceptron = new Perceptron(2);
        perceptron.setBias(0);
        double[] weights = {1, 1};
        perceptron.setWeights(weights);

        double output;

        // 0 & 0: 0
        double[] inputs = {0, 0};
        perceptron.setInputs(inputs);
        output = perceptron.output();
        assertTrue(0.0 == output);

        // 0 & 1: 1
        inputs[0] = 0;
        inputs[1] = 1;
        perceptron.setInputs(inputs);
        output = perceptron.output();
        assertTrue(1.0 == output);

        // 1 & 0: 1
        inputs[0] = 1;
        inputs[1] = 0;
        perceptron.setInputs(inputs);
        output = perceptron.output();
        assertTrue(1.0 == output);

        // 1 & 1: 1
        inputs[0] = 1;
        inputs[1] = 1;
        perceptron.setInputs(inputs);
        output = perceptron.output();
        assertTrue(1.0 == output);
    }
}
