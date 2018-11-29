package Objects;


public class Employee {
	
	public String name;
	public double charge;
	public double hourlyPay;
	public String pictureLocaitonPath;
	public String cardValue;
	
	public Employee() {
		this.name = "";
		this.charge = 0;
		this.hourlyPay = 0;
		this.pictureLocaitonPath = null;
		this.cardValue = "";
	}
	
	public Employee(String name, double charge, double hourlyPay, String pictureLocation, String cardValue) {
		this.name = name;
		this.charge = charge;
		this.hourlyPay = hourlyPay;
		this.pictureLocaitonPath = pictureLocation;
		this.cardValue = cardValue;
	}
	
	public String getName()
	{
	    return this.name;
	}
	
	public double getCharge()
	{
	    return this.charge;
	}
	
	public double getHourlyPay()
	{
	    return this.hourlyPay;
	}
	
	public String getPictureLocaitonPath()
	{
	    return this.pictureLocaitonPath;
	}
	
	public String getCardValue()
	{
	    return this.cardValue;
	}
	
	public void setName(String name)
	{
	     this.name = name;
	}
	
	public void setCharge(double charge)
	{
	     this.charge = charge;
	}
	
	public void setHourlyPay(double hourlyPay)
	{
	     this.hourlyPay = hourlyPay;
	}
	
	public void setPictureLocaitonPath(String pictureLocaitonPath)
	{
	     this.pictureLocaitonPath = pictureLocaitonPath;
	}
	
	public void setCardValue(String cardValue)
	{
	     this.cardValue = cardValue;
	}
}
