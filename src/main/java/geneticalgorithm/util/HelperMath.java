/**
 * Copyright (c) 2014 Saúl Piña <sauljabin@gmail.com>.
 * <p>
 * This file is part of GeneticAlgorithm.
 * <p>
 * GeneticAlgorithm is licensed under The MIT License.
 * For full copyright and license information please see the LICENSE file.
 */

package geneticalgorithm.util;

import java.util.Random;

public abstract class HelperMath {

    // RANDOM

    public static int random(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min + 1) + min;
    }

    public static long random(long min, long max) {
        return Math.round(random((double) min, (double) max));
    }

    public static float random(float min, float max) {
        Random random = new Random();
        return (random.nextFloat() * (max - min)) + min;
    }

    public static double random(double min, double max) {
        Random random = new Random();
        return (random.nextDouble() * (max - min)) + min;
    }

    public static double random() {
        Random random = new Random();
        return random.nextDouble();
    }

    public static int randomBinary() {
        Random random = new Random();
        return random.nextInt(2);
    }

    public static String randomBinary(int size) {
        String temp = "";
        for (int i = 0; i < size; i++) {
            temp += randomBinary();
        }
        return temp;
    }

    // POWER

    public static int pow(int base, int exp) {
        return exp == 0 ? 1 : pow(base, exp - 1) * base;
    }

    public static long pow(long base, int exp) {
        return exp == 0 ? 1 : pow(base, exp - 1) * base;
    }

    // BINARY INTEGER

    public static String integerToBinaryStringUnsigned(int value) {
        return Integer.toBinaryString(Math.abs(value));
    }

    public static String integerToBinaryStringUnsigned(int value, int size) {
        return String.format("%" + size + "s", Integer.toBinaryString(Math.abs(value))).replace(" ", "0");
    }

    public static String integerToBinaryString(int value) {
        return (value < 0 ? "1" : "0") + Integer.toBinaryString(Math.abs(value));
    }

    public static String integerToBinaryString(int value, int size) {
        return (value < 0 ? "1" : "0") + String.format("%" + (size - 1) + "s", Integer.toBinaryString(Math.abs(value))).replace(" ", "0");
    }

    public static int binaryStringToIntegerUnsigned(String value) {
        return Integer.parseInt(value, 2);
    }

    public static int binaryStringToInteger(String value) {
        return (value.charAt(0) == '1' ? -1 : 1) * Integer.parseInt(value.substring(1), 2);
    }

    // BINARY LONG

    public static String longToBinaryStringUnsigned(long value) {
        return Long.toBinaryString(Math.abs(value));
    }

    public static String longToBinaryStringUnsigned(long value, int size) {
        return String.format("%" + size + "s", Long.toBinaryString(Math.abs(value))).replace(" ", "0");
    }

    public static String longToBinaryString(long value) {
        return (value < 0 ? "1" : "0") + Long.toBinaryString(Math.abs(value));
    }

    public static String longToBinaryString(long value, int size) {
        return (value < 0 ? "1" : "0") + String.format("%" + (size - 1) + "s", Long.toBinaryString(Math.abs(value))).replace(" ", "0");
    }

    public static long binaryStringToLongUnsigned(String value) {
        return Long.parseLong(value, 2);
    }

    public static long binaryStringToLong(String value) {
        return (value.charAt(0) == '1' ? -1l : 1l) * Long.parseLong(value.substring(1), 2);
    }

    // BINARY FLOAT

    public static String floatToBinaryStringUnsigned(float value) {
        return Integer.toBinaryString(Float.floatToIntBits(Math.abs(value)));
    }

    public static String floatToBinaryString(float value) {
        return (value < 0 ? "1" : "0") + Integer.toBinaryString(Float.floatToIntBits(Math.abs(value)));
    }

    public static float binaryStringToFloatUnsigned(String value) {
        return Float.intBitsToFloat(Integer.parseInt(value, 2));
    }

    public static float binaryStringToFloat(String value) {
        return (value.charAt(0) == '1' ? -1f : 1f) * Float.intBitsToFloat(Integer.parseInt(value.substring(1), 2));
    }

    // BINARY DOUBLE

    public static String doubleToBinaryStringUnsigned(double value) {
        return Long.toBinaryString(Double.doubleToLongBits(Math.abs(value)));
    }

    public static String doubleToBinaryString(double value) {
        return (value < 0 ? "1" : "0") + Long.toBinaryString(Double.doubleToLongBits(Math.abs(value)));
    }

    public static double binaryStringToDoubleUnsigned(String value) {
        return Double.longBitsToDouble(Long.parseLong(value, 2));
    }

    public static double binaryStringToDouble(String value) {
        return (value.charAt(0) == '1' ? -1. : 1.) * Double.longBitsToDouble(Long.parseLong(value.substring(1), 2));
    }

}
