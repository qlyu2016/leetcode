class MinStack {
	List<Integer> store = new ArrayList<>();
	
    public void push(int x) {
        store.add(x);
    }

    public void pop() {
        store.remove(store.size() - 1);
    }

    public int top() {
        return store.get(store.size() - 1);
    }

    public int getMin() {
        int result = Integer.MAX_VALUE;
        
        for(int i = 0; i < store.size(); i ++){
        	if(store.get(i) < result){
        		result = store.get(i);
        	}
        }
        
        return result;
    }
}