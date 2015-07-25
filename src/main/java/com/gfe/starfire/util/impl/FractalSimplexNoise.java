package com.gfe.starfire.util.impl;

import java.util.Random;

import com.gfe.starfire.util.NoiseGenerator;

public class FractalSimplexNoise implements NoiseGenerator {
    private final SimplexNoise[] octaves;
    private final double[] frequencys;
    private final double[] amplitudes;

    private final double persistence;
    private final long seed;

    public FractalSimplexNoise(final int numberOfOctaves, final double persistence) {
        this(numberOfOctaves, persistence, new Random().nextLong());
    }

    /**
     * @param persistence
     *            1 = dynamic, 0 = flat
     * @param seed
     *            long seed value
     */
    public FractalSimplexNoise(final int numberOfOctaves, final double persistence,
            final long seed) {
        this.persistence = persistence;
        this.seed = seed;

        octaves = new SimplexNoise[numberOfOctaves];
        frequencys = new double[numberOfOctaves];
        amplitudes = new double[numberOfOctaves];

        final Random rnd = new Random(seed);

        for (int i = 0; i < numberOfOctaves; i++) {
            octaves[i] = new SimplexNoise(rnd.nextLong());

            // Pre-calculation of 2 dimensional frequency and amplitude
            frequencys[i] = Math.pow(2, i);
            amplitudes[i] = Math.pow(persistence, octaves.length - i);
        }
    }

    @Override
    public long getSeed() {
        return seed;
    }

    @Override
    public double noise(final double x, final double y) {
        double result = 0;

        for (int i = 0; i < octaves.length; i++) {
            // double frequency = Math.pow(2,i);
            // double amplitude = Math.pow(persistence,octaves.length-i);

            result = result
                    + octaves[i].noise(x / frequencys[i], y / frequencys[i]) * amplitudes[i];
        }

        return result / octaves.length;
    }

    @Override
    public double noise(final double x, final double y, final double z) {
        double result = 0;

        for (int i = 0; i < octaves.length; i++) {
            final double frequency = Math.pow(2, i);
            final double amplitude = Math.pow(persistence, octaves.length - i);

            result = result
                    + octaves[i].noise(x / frequency, y / frequency, z / frequency) * amplitude;
        }

        return result / octaves.length;
    }

    @Override
    public double noise(final double x, final double y, final double z, final double w) {
        double result = 0;

        for (int i = 0; i < octaves.length; i++) {
            final double frequency = Math.pow(2, i);
            final double amplitude = Math.pow(persistence, octaves.length - i);

            result = result
                    + octaves[i].noise(x / frequency, y / frequency, z / frequency, w / frequency)
                            * amplitude;
        }

        return result / octaves.length;
    }
}
