package base;
import static base.Right.*;

public class ContactBuffer 
{
	private static ContactBuffer buffer; 
	private Contact[] group = null;
	public static final int MAXSIZE = 100;

	public static ContactBuffer GetBuffer()
	{
		if(buffer == null)
		{
			buffer = new ContactBuffer();
		}

		return buffer;
	}

	public Contact[] GetGroup()
	{
		return group;
	}

	private ContactBuffer()
	{
		group = new Contact[MAXSIZE];
	}

	private static boolean InsertContact(Contact owner, Contact contact)
	{
		ContactBuffer buffer = ContactBuffer.GetBuffer();
		Contact[] group = buffer.GetGroup();

		if( (owner.GetRight() == ANONYMOUS) || (owner.GetRight() == ADMIN) )
		{
			for(int i=0; i<MAXSIZE; ++i)
			{
				if(group[i] != null)
				{
					Contact tempcontact = group[i];
					if(tempcontact.GetTelNum().equalsIgnoreCase(contact.GetTelNum()) ||
						tempcontact.GetName().equalsIgnoreCase(contact.GetName())	
					)
					{
						return false;
					}
				}
			}

			for(int i=0; i<MAXSIZE; ++i)
			{
				if(group[i] == null)
				{
					group[i] = contact;
					return true;
				}
			}
			return false;
		}
		else
		{
			return false;
		}

	}

	public static Contact IndexContact_TelNum(Contact owner, String telnum)
	{
		ContactBuffer buffer = ContactBuffer.GetBuffer();
		Contact[] group = buffer.GetGroup();

		if(owner.GetRight() == ANONYMOUS || 
			owner.GetRight() == ADMIN ||
				owner.GetTelNum().equalsIgnoreCase(telnum)	
		)
		{
			for(int i=0; i<MAXSIZE; ++i)
			{
				if(group[i] != null)
				{
					Contact tempcontact = group[i];
					if(tempcontact.GetTelNum().equalsIgnoreCase(telnum))
					{
						return tempcontact;
					}
				}
			}
			return null;
		}
		else
		{
			return null;
		}
	}

	public static Contact IndexContact_Name(Contact owner, String name)
	{
		ContactBuffer buffer = ContactBuffer.GetBuffer();
		Contact[] group = buffer.GetGroup();

		if(owner.GetRight() == ANONYMOUS || 
			owner.GetRight() == ADMIN ||
				owner.GetName().equalsIgnoreCase(name)	
		)
		{
			for(int i=0; i<MAXSIZE; ++i)
			{
				if(group[i] != null)
				{
					Contact tempcontact = group[i];
					if(tempcontact.GetName().equalsIgnoreCase(name))
					{
						return tempcontact;
					}
				}
			}
			return null;
		}
		else
		{
			return null;
		}
	}

	public static boolean Add(Contact owner, String telnum, String name, String passwd, Gender sex, String remark)
	{
		if(telnum == null)
		{
			return false;
		}

		if(telnum.length() != 11)
		{
			return false;
		}

		if(name == null)
		{
			return false;
		}

		if(name.length() < 6 || name.length() > 12)
		{
			return false;
		}

		if(passwd == null)
		{
			return false;
		}

		if(passwd.length() < 6 || passwd.length() > 12)
		{
			return false;
		}

		if(remark == null)
		{
			remark = "";
		}

		Contact contact = new Contact(telnum, name, passwd, sex, remark, USER);
		boolean result = ContactBuffer.InsertContact(owner, contact);
		return result;
	}

	public static boolean Login_TelNum(Contact owner, String telnum, String passwd)
	{
		Contact contact = ContactBuffer.IndexContact_TelNum(owner, telnum);
		if(contact == null)
		{
			return false;
		}

		if( contact.GetPasswd().equalsIgnoreCase(passwd) )
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	public static boolean Login_Name(Contact owner, String name, String passwd)
	{
		Contact contact = ContactBuffer.IndexContact_Name(owner, name);
		if(contact == null)
		{
			return false;
		}

		if( contact.GetPasswd().equalsIgnoreCase(passwd) )
		{
			return true;
		}
		else
		{
			return false;
		}
	}
}
