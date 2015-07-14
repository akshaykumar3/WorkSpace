import java.io.IOException;


public class EnumString {

	public enum Examples {
		Abc,abc,ABC,aBC
	}
	
	public static void main(String[] args) throws IOException
	{
		System.out.println(Examples.abc.toString());
		System.out.println(Examples.Abc.toString());
		System.out.println(Examples.ABC.toString());
		System.out.println(Examples.aBC.toString());
	}
}
