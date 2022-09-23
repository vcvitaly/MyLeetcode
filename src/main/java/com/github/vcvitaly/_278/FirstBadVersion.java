package com.github.vcvitaly._278;

/**
 * FirstBadVersion.
 *
 * @author Vitalii Chura
 */
public class FirstBadVersion extends VersionControl {

    public int firstBadVersion(int n) {
        if (n == 1) {
            return n;
        }

        int left = 1;
        int right = n;

        while (left <= right) {
            int mid = (right - left) / 2 + left;
            if (isBadVersion(mid)) {
                if (mid == 1 || !isBadVersion(mid - 1)) {
                    return mid;
                } else {
                    right = mid - 1;
                }
            } else {
                left = mid + 1;
            }
        }

        return -1;
    }
}
