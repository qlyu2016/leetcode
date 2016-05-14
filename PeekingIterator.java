//Java Iterator interface reference:
//https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html
class PeekingIterator implements Iterator<Integer> {
    Iterator<Integer> iterator;
	
	public PeekingIterator(Iterator<Integer> iterator) {
	    // initialize any member here.
	    this.iterator = iterator;
	}

 // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
        List<Integer> temp = new ArrayList<>();
        
        while(iterator.hasNext()){
        	temp.add(iterator.next());
        }
        
        Integer result = null;
        if(temp.size() > 0){
            result = temp.get(0);
        }
        
        iterator = temp.iterator();
        return result;
	}

	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
	    return iterator.next();
	}

	@Override
	public boolean hasNext() {
	    return iterator.hasNext();
	}
}