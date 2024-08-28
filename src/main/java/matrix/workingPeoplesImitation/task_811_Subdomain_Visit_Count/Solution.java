package matrix.workingPeoplesImitation.task_811_Subdomain_Visit_Count;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// my solution
public class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
        Map<String, Integer> frequency = new HashMap<>();
        for (String domain : cpdomains) {
            String[] data = domain.split(" ");
            int count = Integer.parseInt(data[0]);
            frequency.merge(data[1], count, Integer::sum);
            String[] parts = data[1].split("\\.");
            if (parts.length == 3) {
                frequency.merge(parts[1] + "." + parts[2], count, Integer::sum);
            }
            frequency.merge(parts[parts.length - 1], count, Integer::sum);
        }
        List<String> ans = new ArrayList<>();
        for (String key : frequency.keySet()) {
            ans.add(frequency.get(key) + " " + key);
        }
        return ans;
    }
}
