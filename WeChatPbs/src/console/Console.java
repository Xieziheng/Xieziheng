package console;
import base.Contact;
import java.util.Scanner;

public class Console 
{
	private Contact owner = null;
	
	public Console(Contact logincontact)
	{
		owner = logincontact;
	}

	private static void ExecHelpCmd()
	{
		System.out.println("usage:");
		System.out.println("\tclear");
		System.out.println("\tquit");
		System.out.println("\thelp\n\n");
	}

	public void Main()
	{
		System.out.println(owner.GetName() + "@Pbs:~$");
		Scanner sc = new Scanner(System.in);
		sc.useDelimiter("\n");
		
		String cmdinfo = null;
		String[] commandset = {"clear", "quit", "help",};
		String[] paramset = null;

		while(sc.hasNext())
		{
			cmdinfo = sc.next();

			if(!cmdinfo.equals("\r"))
			{
				String cmdline = cmdinfo.substring(0, cmdinfo.length()-1);
				paramset = cmdline.split(" ");

				if(paramset != null)
				{
					int i = 0;
					for(; i < commandset.length; ++i)
					{
						if(paramset[0].equalsIgnoreCase(commandset[i]))
						{
							break;
						}
					}

					switch (i)
					{
						case 0:
							if(paramset.length == 1)
							{
								for(int j = 0; j < 30; ++j)
								{
									System.out.println("\n");
								}
							}
							else
							{
								System.out.println("enter a wrong command!!!");
							}
							break;
						case 1:
							if(paramset.length == 1)
							{
							
								return;
							}
							else
							{
								System.out.println("enter a wrong command!!!");
							}
							break;
						case 2:
							if(paramset.length == 1)
							{
								ExecHelpCmd();
							}
							else
							{
								System.out.println("enter a wrong command!!!");
							}
							break;
						default:
							System.out.println("enter a wrong command!!!");
							break;
					}
				}
				else
				{
					System.out.println("enter a wrong command!!!");
				}
			}

			System.out.print(owner.GetName() + "@Pbs:~$");
		}
	}
}
