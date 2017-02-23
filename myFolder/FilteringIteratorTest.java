package myFolder;

import java.util.Iterator;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import org.junit.Test;
import junit.framework.Assert;

public class FilteringIteratorTest{

@Test
public void test(){

List<Object> collection = new ArrayList<Object>(Arrays.asList(new ObjectTest(), 1, "2", 3));
Iterator iter = collection.iterator();

FilteringIterator it = new FilteringIterator(iter, new ObjectTest());

ArrayList<IObjectTest> ret = new ArrayList<IObjectTest>();

while(it.hasNext()){
  Object o = it.next();
  ret.add((IObjectTest) o);
}

Assert.assertTrue(ret.size() == 1);

}





}