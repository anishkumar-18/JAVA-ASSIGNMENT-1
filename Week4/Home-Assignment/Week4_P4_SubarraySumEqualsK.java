import java.util.HashMap;
import java.util.Map;

public class Week4_P4_SubarraySumEqualsK {

    public static int subarraySum(
            int[] nums,
            int k) {

        Map<Integer, Integer> frequency =
                new HashMap<>();

        frequency.put(0, 1);

        int prefixSum = 0;
        int count = 0;

        for (int num : nums) {
            prefixSum += num;

            count +=
                    frequency.getOrDefault(
                            prefixSum - k,
                            0
                    );

            frequency.put(
                    prefixSum,
                    frequency.getOrDefault(
                            prefixSum,
                            0
                    ) + 1
            );
        }

        return count;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1};

        System.out.println(
                subarraySum(nums, 2)
        );
    }
}
