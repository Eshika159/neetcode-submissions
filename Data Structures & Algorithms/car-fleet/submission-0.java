class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int[][] pair =new int[position.length][2]; // pos,speed
        Stack<Double> st = new Stack<>();
          for (int i = 0; i < position.length; i++) {
            pair[i][0] = position[i];
            pair[i][1] = speed[i];
        }

        Arrays.sort(pair,(a,b) -> Integer.compare(b[0] , a[0])); //dec order of position
        
        for(int i =0 ;i < pair.length; i++) {
        st.push( (double) (target-pair[i][0])/pair[i][1]);

        //top and second top element
        if(st.size() >=2 && st.peek() <= st.get(st.size()-2)) {
            //merge the car fleet
            st.pop();
        }

        }
        return st.size();

    }
}
