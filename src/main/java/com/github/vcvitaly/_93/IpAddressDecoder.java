package com.github.vcvitaly._93;

import java.util.ArrayList;
import java.util.List;

public class IpAddressDecoder {

    public List<String> restoreIpAddresses(String s) {
        if (s.length() < 4 || s.length() > 12) {
            return List.of();
        }

        return restoreNGroups(s, 0, 4);
    }

    private List<String> restoreNGroups(String s, int startIndex, int n) {
        if (n == 1) {
            if (s.length() - startIndex <= 3) {
                final String lastOctet = s.substring(startIndex);
                if (!validOctet(lastOctet)) {
                    return List.of();
                }
                return List.of(lastOctet);
            }
            return List.of();
        }


        final List<String> result = new ArrayList<>();
        for (int i = 1; i <= 3 && s.length() - (startIndex + i - 1) >= n; i++) {
            final String currentGroup;
            try {
                currentGroup = s.substring(startIndex, startIndex + i);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            if (!validOctet(currentGroup)) {
                break;
            }
            final List<String> restoredNGroups = restoreNGroups(s, startIndex + i, n - 1);
            if (!restoredNGroups.isEmpty()) {
                result.addAll(
                        restoredNGroups.stream()
                                .map(nGroup -> currentGroup + "." + nGroup)
                                .toList()
                );
            }
        }

        return result;
    }

    private boolean validOctet(String octet) {
        int asInt = Integer.parseInt(octet);
        return asInt <= 255 && !isZeroPadded(octet);
    }

    private boolean isZeroPadded(String currentGroup) {
        return currentGroup.length() > 1 && currentGroup.charAt(0) == '0';
    }
}
