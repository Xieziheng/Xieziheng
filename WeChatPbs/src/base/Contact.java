package base;

public class Contact 
{
	private String telnum;
	private String name;
	private String passwd;
	private Gender sex;
	private String remark;
	private Right right;

	public void SetTelNum(String telnum)
	{
		this.telnum = telnum;
	}

	public String GetTelNum()
	{
		return telnum;
	}

	public void SetName(String name)
	{
		this.name = name;
	}

	public String GetName()
	{
		return name;
	}

	public void SetPasswd(String passwd)
	{
		this.passwd = passwd;
	}

	public String GetPasswd()
	{
		return passwd;
	}

	public void SetSex(Gender sex)
	{
		this.sex = sex;
	}

	public Gender GetSex()
	{
		return sex;
	}

	public void SetRemark(String remark)
	{
		this.remark = remark;
	}

	public String GetRemark()
	{
		return remark;
	}

	public void SetRight(Right right)
	{
		this.right = right;
	}

	public Right GetRight()
	{
		return right;
	}

	public Contact(String telnum, String name, String passwd, Gender sex, String remark, Right right)
	{
		this.telnum = telnum;
		this.name = name;
		this.passwd = passwd;
		this.sex = sex;
		this.remark = remark;
		this.right = right;
	}
}
