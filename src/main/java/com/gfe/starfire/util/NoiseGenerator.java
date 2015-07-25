package com.gfe.starfire.util;

public interface NoiseGenerator {
    long getSeed();

    double noise(double x, double y);

    double noise(double x, double y, double z);

    double noise(double x, double y, double z, double w);
}
