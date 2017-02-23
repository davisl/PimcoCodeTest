package myFolder;
public class ObjectTest implements IObjectTest{

	public boolean test(Object o){
	 return (o instanceof IObjectTest);
	}

}