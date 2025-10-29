class Solution {
    public int[] asteroidCollision(int[] asteroids) {
	Stack<Integer> st = new Stack<>();
		st.push(asteroids[0]);
		for (int i = 1; i < asteroids.length; i++) {
			if (asteroids[i] > 0) {
				st.push(asteroids[i]);
			} else if (asteroids[i] < 0 && !st.isEmpty() && st.peek() > 0) {
				int temp = st.peek();
				while (temp < -(asteroids[i])) {
					st.pop();
					if (st.isEmpty()) {
						break;
					}
					temp = st.peek();
					if (temp < 0) {
						break;
					}
				}
				if (temp == -(asteroids[i])) {
					st.pop();
					continue;
				}
				if (asteroids[i] < 0 && (st.isEmpty() || st.peek() < 0)) {
					st.push(asteroids[i]);
				}
			} else {
				st.push(asteroids[i]);
			}
		}

		int arr[] = new int[st.size()];
		int j = 0;
		for (int i : st) {
			arr[j++] = i;
		}
        return  arr; 
    }
}

// int temp = 0;
// 		List<Integer> li = new ArrayList<>();
// 		for (int i = asteroids.length - 1; i >= 0; i--) {
// 			if (asteroids[i] < 0) {
// 				temp = asteroids[i];
// 			} else if (-(temp) < asteroids[i]) {
// 				li.add(asteroids[i]);
// 				temp = 0;
// 			} else if (temp == asteroids[i]) {
// 				temp = 0;
// 			}
// 		}
// 		//Aprotch first
// 		int tarr[] = new int[li.size()];//creating new arr
// 		int j = 0;
// 		//convert list to array and seve in reverse 
// 		for (int i = li.size() - 1; i >= 0; i--) {
// 			tarr[j++] = li.get(i);
// 		}