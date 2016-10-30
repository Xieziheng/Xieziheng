import base.Contact;
import base.Gender;
import base.Right;
import static base.Gender.*;
import static base.Right.*;
import java.util.Scanner;

public class  WeChatPbs
{
	private static WeChatPbs pbs = null;
	private Contact owner;

	public static WeChatPbs GetPbs()
	{
		if(pbs == null)
		{
			pbs = new WeChatPbs();
		}

		return pbs;
	}

	public Contact GetOwner()
	{
		return owner;
	}

	private WeChatPbs()
	{
		owner = new Contact("00000000000","Anonymous", "000000", MALE, "Phone System Anoymous", ANONYMOUS);
	}

	private static void ExecHelpCmd()
	{
		System.out.println("usage:");
		System.out.println("\tcreate  -t <telnum> -n <name> -p <passwd> -c <confirm passwd> -g [male|female] -r [<remark>]");
		System.out.println("\tlogin   {-t <telnum> | -n <name>} -p <passwd>");
		System.out.println("\tclear");
		System.out.println("\tquit");
		System.out.println("\thelp\n\n");
		
		System.out.println("options:");
		System.out.println("\ttelnum:         all character is 0~9, length is 11, for example 15879127000");
		System.out.println("\tname:           length is between 6 and 12, for example WangMing");
		System.out.println("\tpasswd:         length is between 6 and 12");
		System.out.println("\tremark:         length isn't over 64\n\n");

		System.out.println("example:");
		System.out.println("\t> create -n WangMing -t 1587912700 -p 123456 -c 123456 -g male -r System Test        ...create a user");
		System.out.println("\t> login -n WangMing -p 123456                                                        ...login a user");
		System.out.println("\n\n");
	}

	private static boolean isLegalTelNum(String telnum)
	{
		if(telnum.length() != 11)
		{
			return false;
		}

		byte[] num = telnum.getBytes();
		for(int i=0; i<num.length; ++i)
		{
			if(num[i] < '0' ||  num[i] > '9')
			{
				return false;
			}
		}

		return true;
	}

	private static boolean ExecCreateCmd(String[] paramset)
	{
		String telnum = null;
		String name = null;
		String passwd = null;
		String confirmpasswd = null;
		Gender sex = UNKNOWN;
		String remark = null;

		int tflag = 0;
		int nflag = 0;
		int pflag = 0;
		int cflag = 0;
		int sflag = 0;
		int rflag = 0;
		
		if( (paramset.length%2 == 0) || (paramset.length > 13) || paramset.length < 9)
		{
			return false;
		}

		for(int i=1; i<paramset.length; i=i+2)
		{
			switch (paramset[i])
			{
				case "-t":
				case "-T":
					if(!isLegalTelNum(paramset[i+1]))
					{
						return false;
					}
					if(tflag == 1)
					{
						return false;
					}
					tflag = 1;
					telnum = paramset[i+1];
					break;
				case "-n":
				case "-N":
					break;
				case "-p":
				case "-P":
					break;
				case "-c":
				case "-C":
					break;
				case "-g":
				case "-G":
					break;
				case "-r":
				case "-R":
					break;
				default:
					return false;
			}
		}

		return true;
	}
	
	public static void main(String[] args) 
	{
		System.out.println("\n\t\t Welcome to WeChat Phone Book System\t\t");
		System.out.println("\t\t\t\t\t\t\t\t\t By Congrobot Inc");

		System.out.println("Anonymous@Pbs:~$");
		Scanner sc = new Scanner(System.in);
		sc.useDelimiter("\n");
		
		String cmdinfo = null;
		String[] commandset = {"create", "login", "clear", "quit", "help",};
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

					boolean result = false;
					switch (i)
					{
						case 0:
							result = ExecCreateCmd(paramset);
							if(result == true)
							{
								System.out.println("\t\t\tcreate a user successed!!!");
							}
							else
							{
								System.out.println("\t\t\tcreate a user failed!!!");
							}
							break;
						case 1:
							break;
						case 2:
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
						case 3:
							if(paramset.length == 1)
							{
							
								return;
							}
							else
							{
								System.out.println("enter a wrong command!!!");
							}
							break;
						case 4:
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
			
			System.out.print("Anonymous@Pbs:~$");
		}		


	}
}
