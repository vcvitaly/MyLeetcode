package com.github.vcvitaly._1732;

public class HighestAltitudeFinder {

    public int largestAltitude(int[] gain) {
        int highestAltitude = 0;
        int altitude = 0;
        for (int curGain : gain) {
            altitude += curGain;
            if (altitude > highestAltitude) {
                highestAltitude = altitude;
            }
        }
        return highestAltitude;
    }
}
