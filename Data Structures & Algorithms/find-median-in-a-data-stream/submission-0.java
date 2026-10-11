class MedianFinder {
    private Queue<Integer> smallheap ;
    private Queue<Integer> largeheap;

    public MedianFinder() {
        smallheap = new PriorityQueue<>( (a,b) -> b - a); // max heap
        largeheap = new PriorityQueue<>( (a,b) -> a - b); // min heap
    }
    
    public void addNum(int num) {
        smallheap.add(num);
        if(smallheap.size() - largeheap.size() > 1 || !largeheap.isEmpty() && smallheap.peek() > largeheap.peek()){
            largeheap.add(smallheap.poll());
        }
        if(largeheap.size() - smallheap.size() > 1) {
            smallheap.add(largeheap.poll());
        }
        
    }
    
    public double findMedian() {
        if(smallheap.size() == largeheap.size()) {
            return (double) (largeheap.peek() + smallheap.peek())/2;
        } else if (smallheap.size() > largeheap.size()) {
            return (double)smallheap.peek();
        } else {
            return (double) largeheap.peek();
        }
        
    }
}
