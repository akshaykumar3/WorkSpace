/**
 * 
 */

/**
 * @author kumaksha
 *
 */
public class InterfacTestClass implements TestInterface {

	/**
	 * 
	 */
	public InterfacTestClass() {
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see TestInterface#fn1()
	 */
	@Override
	public void fn1() {
		// TODO Auto-generated method stub
		System.out.println("inside fn1");
	}

	/* (non-Javadoc)
	 * @see TestInterface#fn2(int)
	 */
	@Override
	public void fn2(int inp) {
		// TODO Auto-generated method stub
		System.out.println("inside fn2 "+inp);
	}

}