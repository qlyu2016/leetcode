public class WordDistance {
    private HashMap<String, List<Integer>> words = new HashMap<>();
	
    public WordDistance(String[] words) {
        for(int i = 0; i < words.length; i ++){
        	if(this.words.get(words[i]) == null){
        		List<Integer> temp = new ArrayList<>();
        		temp.add(i);
        		this.words.put(words[i], temp);
        	}else{
        		this.words.get(words[i]).add(i);
        	}
        }
    }

    public int shortest(String word1, String word2) {
        List<Integer> list1 = this.words.get(word1);
        List<Integer> list2 = this.words.get(word2);
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < list1.size(); i ++){
        	for(int j = 0; j < list2.size(); j ++){
        		if(Math.abs(list1.get(i) - list2.get(j)) < min){
        			min = Math.abs(list1.get(i) - list2.get(j));
        		}
        	}
        }
        
        return min;
    }
}

// Your WordDistance object will be instantiated and called as such:
// WordDistance wordDistance = new WordDistance(words);
// wordDistance.shortest("word1", "word2");
// wordDistance.shortest("anotherWord1", "anotherWord2");