class Solution {
    public void sortColors(int[] nums) {
        int c0 = 0;
        int c1 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                c0++;
            } else if (nums[i] == 1) {
                c1++;
            }
        }
        int c2 = nums.length - (c0 + c1);
        for (int i = 0; i < nums.length; i++) {
            if (c0 > 0) {
                nums[i] = 0;
                c0--;
            } else if (c1 > 0) {
                nums[i] = 1;
                c1--;
            } else if (c2 > 0) {
                nums[i] = 2;
                c2--;
            }
        }
    }
}
//   public void sortColors(int[] nums) {
//         sort(nums, 0, nums.length - 1);
//         for (int v : nums) {
//             System.out.print(v + " ");
//         }
//     }

//     private void sort(int arr[], int left, int rite) {
//         while (left < rite) {
//             int pi = findPivatIndex(arr, left, rite);
//             sort(arr, left, pi - 1);
//             sort(arr, pi + 1, rite);
//         }
//     }

//     private int findPivatIndex(int arr[], int left, int right) {
//         int pivot = arr[right];
//         int i = left;
//         for (int j = left; j < right; j++) {
//             if (arr[j] <= pivot) {
//                 int temp = arr[i];
//                 arr[i] = arr[j];
//                 arr[j] = temp;
//             }
//         }
//         int temp = arr[right];
//         arr[right] = arr[i];
//         arr[i] = temp;
//         return i;
//     }