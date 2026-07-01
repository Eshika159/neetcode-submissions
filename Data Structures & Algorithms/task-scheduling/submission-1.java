class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] count = new int[26];
        for (char c : tasks) {
            count[c - 'A']++;
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int c : count) {
            if(c > 0) {
                pq.add(c);
            }
        }

        int curtime = 0;
        Queue<int[]> q = new LinkedList<>();
        while( !pq.isEmpty() || !q.isEmpty()) {
            curtime++;
            if( !pq.isEmpty()) {
                int cnt = pq.poll() - 1;
                if(cnt > 0) {
                     q.add(new int[] {cnt, curtime + n});
                }   
            } else {
                curtime = q.peek()[1];
            }
        
        if(!q.isEmpty() && q.peek()[1] == curtime) {
            pq.add(q.poll()[0]);
        }

    }
    return curtime;
}
}
