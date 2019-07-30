package com.github.leventarican.neuronalnetwork;

import java.util.List;

/**
 * simple neuronal network: perceptron model.
 */
public class Perceptron {
    private int numberOfInput;
    private double[] inputs;
    private double[] weights;
    private double bias;

    public Perceptron(int numberOfInput) {
        this.numberOfInput = numberOfInput;
    }

    private double activationFunction(double s) {
        return s >= 1 ? 1 : 0;
    }

    public void setInputs(double[] inputs) {
        this.inputs = inputs;
    }

    public void setWeights(double[] weights) {
        this.weights = weights;
    }

    public void setBias(double value) {
        this.bias = value;
    }

    public double output() {
        double s = bias;
        for (int i = 0; i < inputs.length; i++) {
            s += inputs[i] * weights[i];
        }
        return activationFunction(s);
    }
}
