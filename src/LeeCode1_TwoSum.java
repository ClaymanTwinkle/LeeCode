import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * 
 * Given an array of integers, find two numbers such that they add up to a specific target number.
 * The function twoSum should return indices of the two numbers such that they add up to the target, 
 * where index1 must be less than index2. 
 * Please note that your returned answers (both index1 and index2) are not zero-based.
 * You may assume that each input would have exactly one solution.
 * Input: numbers={2, 7, 11, 15}, target=9
 * Output: index1=1, index2=2
 * @author kesar
 *
 */
public class LeeCode1_TwoSum
{
	public static int[] twoSum(int[] nums, int target)
	{
		int[] results = { 0, 0 };
		if (nums == null || nums.length == 0)
		{
			return results;
		}
		HashMap<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
		for (int i = 0; i < nums.length; i++)
		{
			List<Integer> list = null;
			if (map.containsKey(nums[i]))
			{
				list = map.get(nums[i]);
				list.add(i);
			}
			else
			{
				list = new LinkedList<Integer>();
				list.add(i);
			}
			map.put(nums[i], list);
		}
		for (int i = 0; i < nums.length; i++)
		{
			int two = target - nums[i];
			if (map.containsKey(two))
			{
				List<Integer> list = map.get(two);
				if (target == two << 1)
				{
					if (list.size() != 1)
					{
						results[0] = list.get(0) + 1;
						results[1] = list.get(1) + 1;
						return results;
					}
				}
				else
				{
					int index = list.get(0);
					if (index > i)
					{
						results[0] = i + 1;
						results[1] = index + 1;
					}
					else
					{
						results[0] = index + 1;
						results[1] = i + 1;
					}
					return results;
				}
			}
		}
		return results;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		int[] nums = { 5, 2, 3, 7 };
		System.out.println(Arrays.toString(twoSum(nums, 5)));
	}

}
