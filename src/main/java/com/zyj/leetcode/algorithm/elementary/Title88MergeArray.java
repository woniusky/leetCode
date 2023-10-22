package com.zyj.leetcode.algorithm.elementary;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;

/**
 * @ProjectName: leetCode
 * @Package: com.zyj.leetcode.algorithm.elementary
 * @ClassName: Title88MergeArray
 * @Author: honor
 * @Description: 88题，合并两个有序数组
 * @Date: 2023/6/7 17:07
 * @Version: 1.0
 */
@Slf4j
public class Title88MergeArray {
    /**
     * 给你两个按非递减顺序 排列的整数数组nums1 和 nums2，另有两个整数 m 和 n ，分别表示 nums1 和 nums2 中的元素数目。
     * 请你 合并 nums2 到 nums1 中，使合并后的数组同样按 非递减顺序 排列。
     * 注意：最终，合并后数组不应由函数返回，而是存储在数组 nums1 中。为了应对这种情况，nums1 的初始长度为 m + n，其中前 m 个元素表示应合并的元素，后 n 个元素为 0 ，应忽略。nums2 的长度为 n 。
     * <p>
     * 示例 1：
     * 输入：nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
     * 输出：[1,2,2,3,5,6]
     * 解释：需要合并 [1,2,3] 和 [2,5,6] 。
     * 合并结果是 [1,2,2,3,5,6] ，其中斜体加粗标注的为 nums1 中的元素。
     * <p>
     * 示例 2：
     * 输入：nums1 = [1], m = 1, nums2 = [], n = 0
     * 输出：[1]
     * 解释：需要合并 [1] 和 [] 。
     * 合并结果是 [1] 。
     * <p>
     * 示例 3：
     * 输入：nums1 = [0], m = 0, nums2 = [1], n = 1
     * 输出：[1]
     * 解释：需要合并的数组是 [] 和 [1] 。
     * 合并结果是 [1] 。
     * 注意，因为 m = 0 ，所以 nums1 中没有元素。nums1 中仅存的 0 仅仅是为了确保合并结果可以顺利存放到 nums1 中。
     * <p>
     * 提示：
     * nums1.length == m + n
     * nums2.length == n
     * 0 <= m, n <= 200
     * 1 <= m + n <= 200
     * -109 <= nums1[i], nums2[j] <= 109
     */
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};
        int m = 3, n = 3;
        merge(nums1, m, nums2, n);
    }


    public static void merge(int[] nums1, int m, int[] nums2, int n) {
    /*
     1 2 4 5 5 7
     2 4 6 9
        9 > 7 => 1 2 4 5 5 7 9
        6 > 7 ? 否 -》 6 > 5 ？ 是 => 1 2 4 5 5 6 7 9
        4 >  5 ? > 4 ? > 2 ?
     */
        if (m == 0) {
            for (int i = 0; i < nums2.length; i++) {
                nums1[i] = nums2[i];
            }
            return;
        }
        if (n == 0) {
            return;
        }
        int[] copy1 = nums1;
        final int length1 = nums1.length;
        for (int i = n - 1; i >= 0; i--) {
            boolean lge = false;
            for (int j = m - 1; j >= 0; j--) {
                lge = nums2[i] >= nums1[j];
                if (lge) {
                    copy1[length1 - (n - i)] = nums2[i];
                    break;
                }
            }
        }
        System.arraycopy(copy1, 0, nums1, 0, nums1.length);
        log.info(JSON.toJSONString(nums1));
    }
}
