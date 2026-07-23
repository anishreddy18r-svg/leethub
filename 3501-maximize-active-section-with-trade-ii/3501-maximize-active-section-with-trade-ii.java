import java.util.*;

class Solution {
    // Custom Pair class to bypass relying on external library pairs 
    static class Pair<K, V> {
        private K key;
        private V value;

        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() { return key; }
        public V getValue() { return value; }
    }

    // Group representation of contiguous '0' blocks
    static class Group {
        public int start;
        public int length;

        public Group(int start, int length) {
            this.start = start;
            this.length = length;
        }
    }

    // Sparse Table for O(1) Range Maximum Queries (RMQ)
    static class SparseTable {
        private final int n;
        private int[][] st;

        public SparseTable(int n, int[] nums) {
            this.n = n;
            if (n == 0) return;
            this.st = new int[bitLength(n) + 1][n];
            
            for (int i = 0; i < n; ++i)
                st[0][i] = nums[i];
                
            for (int i = 1; i <= bitLength(n); ++i)
                for (int j = 0; j + (1 << i) <= n; ++j)
                    st[i][j] = Math.max(st[i - 1][j], st[i - 1][j + (1 << (i - 1))]);
        }

        public int query(int l, int r) {
            if (l > r) return 0;
            final int i = bitLength(r - l + 1) - 1;
            return Math.max(st[i][l], st[i][r - (1 << i) + 1]);
        }

        private int bitLength(int n) {
            return 32 - Integer.numberOfLeadingZeros(n);
        }
    }

    public List<Integer> maxActiveSectionsAfterTrade(String s, int[][] queries) {
        List<Integer> ans = new ArrayList<>();
        int ones = 0;
        
        for (char c : s.toCharArray()) {
            if (c == '1') ones++;
        }

        Pair<List<Group>, int[]> zeroGroupsInfo = getZeroGroups(s);
        List<Group> zeroGroups = zeroGroupsInfo.getKey();
        int[] zeroGroupIndex = zeroGroupsInfo.getValue();

        if (zeroGroups.isEmpty()) {
            for (int i = 0; i < queries.length; i++) ans.add(ones);
            return ans;
        }

        int numPairs = Math.max(0, zeroGroups.size() - 1);
        int[] adjacentZeroGroupLengths = new int[numPairs];
        for (int i = 0; i < zeroGroups.size() - 1; ++i) {
            adjacentZeroGroupLengths[i] = zeroGroups.get(i).length + zeroGroups.get(i + 1).length;
        }

        SparseTable st = new SparseTable(adjacentZeroGroupLengths.length, adjacentZeroGroupLengths);

        for (int[] query : queries) {
            int l = query[0];
            int r = query[1];

            // Determine the partial '0' capacities if the query strictly splits a zero group on the ends
            int left = (s.charAt(l) == '1') ? -1 : zeroGroups.get(zeroGroupIndex[l]).length - (l - zeroGroups.get(zeroGroupIndex[l]).start);
            int right = (s.charAt(r) == '1') ? -1 : (r - zeroGroups.get(zeroGroupIndex[r]).start + 1);

            // [FIXED]: Accurate indices of zero groups completely bounded within [l, r]
            int startGrpIdx = (s.charAt(l) == '1') ? zeroGroupIndex[l] : zeroGroupIndex[l] + 1;
            int endGrpIdx = zeroGroupIndex[r] - 1;

            int startAdjacentGroupIndex = startGrpIdx;
            int endAdjacentGroupIndex = endGrpIdx - 1;

            int activeSections = ones;

            // Scenario 1: The query boundaries fall within adjacent zero groups 
            if (s.charAt(l) == '0' && s.charAt(r) == '0' && zeroGroupIndex[l] + 1 == zeroGroupIndex[r]) {
                activeSections = Math.max(activeSections, ones + left + right);
            } 
            // Scenario 2: The best trade merges two completely bound consecutive zero blocks 
            else if (startAdjacentGroupIndex <= endAdjacentGroupIndex) {
                activeSections = Math.max(activeSections, ones + st.query(startAdjacentGroupIndex, endAdjacentGroupIndex));
            }

            // Scenario 3: Combining the partial zero block at `l` with the subsequent full zero block
            if (s.charAt(l) == '0' && zeroGroupIndex[l] + 1 <= endGrpIdx) {
                activeSections = Math.max(activeSections, ones + left + zeroGroups.get(zeroGroupIndex[l] + 1).length);
            }

            // Scenario 4: Combining the preceding full zero block with the partial zero block bounded at `r`
            if (s.charAt(r) == '0' && startGrpIdx <= zeroGroupIndex[r] - 1) {
                activeSections = Math.max(activeSections, ones + right + zeroGroups.get(zeroGroupIndex[r] - 1).length);
            }

            ans.add(activeSections);
        }

        return ans;
    }

    private Pair<List<Group>, int[]> getZeroGroups(String s) {
        List<Group> zeroGroups = new ArrayList<>();
        int[] zeroGroupIndex = new int[s.length()];

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                if (i > 0 && s.charAt(i - 1) == '0') {
                    zeroGroups.get(zeroGroups.size() - 1).length++;
                } else {
                    zeroGroups.add(new Group(i, 1));
                }
            }
            zeroGroupIndex[i] = zeroGroups.isEmpty() ? 0 : zeroGroups.size() - (s.charAt(i) == '0' ? 1 : 0);
        }

        return new Pair<>(zeroGroups, zeroGroupIndex);
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna