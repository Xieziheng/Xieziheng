public class TestTotal 
{
	public static void main(String[] args) 
	{	
		int total = 0;

		for ( int i = 0; i < 4; i++ )
			{

			if ( i == 1) continue;

			if ( i == 2) break;                           

			total += i;

			}
		System.out.println(total);
	}
}
