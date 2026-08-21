package matrix.workingPeoplesImitation.task_93_Restore_IP_Addresses;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

// my solution
class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        backtrack(new IPAddress(), result, s.toCharArray(), 0, 0);
        return result;
    }

    private void backtrack(IPAddress current, List<String> result, char[] chars, int start, int end) {
        if (current.isPossible()) {
            if (end != chars.length) {
                return;
            }
            result.add(current.asString());
        }
        for (int i = end; i < chars.length; i++) {
            if (!current.isValidPart(chars, start, i)) {
                break;
            }
            current.add(chars, start, i);
            backtrack(IPAddress.of(current), result, chars, i + 1, i + 1);
            current.removeLast();
        }
    }

    static class IPAddress {
        private final List<String> parts;

        public IPAddress() {
            this.parts = new ArrayList<>();
        }

        private IPAddress(List<String> parts) {
            this.parts = parts;
        }

        public static IPAddress of(IPAddress other) {
            return new IPAddress(new ArrayList<>(other.parts));
        }

        public boolean isPossible() {
            return parts.size() == 4;
        }

        public String asString() {
            if (!isPossible()) {
                throw new IllegalStateException("IP address is not valid");
            }
            return parts.stream()
                    .map(String::valueOf)
                    .collect(Collectors.joining("."));
        }

        public boolean isValidPart(char[] chars, int start, int end) {
            StringBuilder builder = buildStringValue(chars, start, end);
            return isValidNumber(builder.toString());
        }

        private boolean isValidNumber(String value) {
            return (!value.startsWith("0") || value.length() == 1)
                   && Integer.parseInt(value) <= 255;
        }

        public void add(char[] chars, int start, int end) {
            StringBuilder builder = buildStringValue(chars, start, end);
            parts.add(builder.toString());
        }

        private StringBuilder buildStringValue(char[] chars, int start, int end) {
            StringBuilder builder = new StringBuilder();
            for (int i = start; i <= end; i++) {
                builder.append(chars[i]);
            }
            return builder;
        }

        public void removeLast() {
            parts.remove(parts.size() - 1);
        }
    }
}
