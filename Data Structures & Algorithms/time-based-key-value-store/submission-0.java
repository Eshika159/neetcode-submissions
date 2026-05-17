class TimeMap {

    private Map<String, List<Pair<Integer,String>>> keystore;

    public TimeMap() {
        keystore = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        keystore.computeIfAbsent(key, k -> new ArrayList<>()).add(new Pair<>(timestamp,value));
    }
    
    public String get(String key, int timestamp) {
        List<Pair<Integer,String>> values = keystore.getOrDefault(key, new ArrayList<>());

        int l =0, r = values.size() - 1;
        String res= "";

        while(l<=r){
            int m = l + (r-l)/2;
            if(values.get(m).getKey() <= timestamp) {
                res = values.get(m).getValue();
                l = m + 1;
            }
            else {
                r = m - 1;
            }
        }
        return res;
    }

    private static class Pair<K, V> {
       private final K key;
        private final V value;

        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }
        public V getValue(){
            return value;
        }

    }
}
