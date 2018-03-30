package days_calculate;

public class DayCalculate {
	private int years;
	private int days;
	private int mon;
	private byte leap;
	final private int []arr;
	public DayCalculate(){
		mon = 0;
		// 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 
		// 0  闰年							 1   平年
		arr = new int[]{0,31,29,31,30,31,30,31,31,30,31,30,0,31,28,31,30,31,30,31,31,30,31,30,31};
	}
	
	public void isLeap(){
		if((years % 4 == 0 && years % 100 != 0)||(years % 400 == 0))
			leap = 0;
		else 
			leap = 13;
	}
	
	//设置第几天
	public void setDay(int years,int days){
		this.years = years;
		this.days = days;
	}
	
	//设置日期
	public void setDate(int years,int mon,int days){
		this.years = years;
		this.mon = mon;
		this.days = days;
	}
	
	//得到日期
	public void getDate(){
		isLeap();
		int sum = 0;
		for(int i = 0;i < 12; i++){
			sum += arr[i + leap];
			if(days - sum >= 0 && days - sum <= arr[i + leap+1]){
				System.out.println(years+"年的第 "+days+"天是 "+ (i+1) + "月 " + (days-sum) +"日");
				break;
			}
		}
	}
	
	//得到天数
	public void getDays(){
		isLeap();
		int sum = 0;
		for(int i = 0; i < mon-1; i++){
			sum += arr[i+leap];
		}
		System.out.println(years+"年 "+mon+"月 "+days+"日是第 "+(sum+days)+"天");
	}	
	
	public static void main(String[] args) {
		DayCalculate d = new DayCalculate();
		d.setDay(2008, 32);
		d.getDate();
		
		d.setDate(1998, 7, 30);
		d.getDays();
	}
}
