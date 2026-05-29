class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<>();
        List<String> line = new ArrayList<>();
        int length = 0, i = 0;

        while (i < words.length) {

        //If the current word can fit in line
        if(length + words[i].length() + line.size()<= maxWidth) {
            line.add(words[i]);
            length+= words[i].length();
            i++;
        } else {
            //line complete
            int extra_space = maxWidth - length;
            int space = extra_space / Math.max(1, line.size() - 1);
            int remainder = extra_space % Math.max(1,line.size() - 1);
            for(int j=0;j<Math.max(1,line.size()-1); j++) {
                line.set(j,line.get(j)+" ".repeat(space));
                if(remainder > 0){
                    line.set(j, line.get(j)+" ");
                    remainder--;
                }
            }
            res.add(String.join("",line));
            line.clear();
            length =0;
        }
        }
        //last line  - join each word in last line with " "
        String last = String.join(" ", line);
        int trail = maxWidth - last.length();
        res.add(last+" ".repeat(trail));
        return res;
    }
}