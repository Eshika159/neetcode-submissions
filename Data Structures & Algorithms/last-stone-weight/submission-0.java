class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> heap = new PriorityQueue<>((a,b) -> b - a);
        for (int s : stones) {
            heap.add(s);
        }
        while(heap.size() > 1) {
            int first = heap.poll(); //largest
            int second = heap.poll(); //second largest
            if(first != second) {
                heap.add(first - second);
            }
        }

        return heap.size() == 1 ? heap.poll() : 0;
    }
}
