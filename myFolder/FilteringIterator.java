package myFolder;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.NoSuchElementException;
public class FilteringIterator implements Iterator{
	
	 IObjectTest objectTest;
	 ArrayList<Object> internal_coll;
	 int lastIndex;
	
	public FilteringIterator(Iterator _iterator, IObjectTest _objectTest){
		objectTest = _objectTest;
		lastIndex = 0;
		internal_coll = new ArrayList<Object>();
		while(_iterator.hasNext()){
			internal_coll.add(_iterator.next());
		}
		
	}
	
	public IObjectTest next() throws NoSuchElementException{
		Object o = internal_coll.get(lastIndex-1);
		if (objectTest.test(o)){
			return (IObjectTest) o;	
		}
		throw new NoSuchElementException("Iterator has no instances of IObjectTest");
	}
	
	public boolean hasNext(){
		boolean hasNext = lastIndex < internal_coll.size()-1;
		Object o =  hasNext ? internal_coll.get(lastIndex) : null;
		lastIndex++;
		return hasNext && objectTest.test(o);
	}
	
	public void remove(){
		internal_coll.remove(lastIndex-1);
	}
	
}