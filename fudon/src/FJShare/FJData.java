package FJShare;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FJData extends Object {
	private static double EARTH_RADIUS = 6378.137;//地球半径
	
	private static double rad(double d){
		return d * Math.PI / 180.0;
	}

	public static  double distanceByCoordinate(double lat1, double lng1, double lat2, double lng2){
		double radLat1 = rad(lat1);
		double radLat2 = rad(lat2);
		double a = radLat1 - radLat2;
		double b = rad(lng1) - rad(lng2);

		double s = 2 * Math.sin(Math.sqrt(Math.pow(Math.sin(a/2),2) +
		Math.cos(radLat1)*Math.cos(radLat2)*Math.pow(Math.sin(b/2),2)));
		s = s * EARTH_RADIUS;
		s = Math.round(s * 10000) / 10000;
		return s;
	}
	
	public static double countCreditTureRate(double yearRate,long month){
		return 2 * yearRate  * month /(month + 1);
	}
	
	public static int randomNumberWithDigit(int digit){
		long time = System.currentTimeMillis();
		String timeString = String.valueOf(time);
		timeString = timeString.substring(timeString.length() - 3);		
		long digitNumber = Integer.parseInt(timeString);
		digitNumber = digitNumber * digitNumber;
		String digitString = String.valueOf(digitNumber);
		timeString = timeString + digitString;
		timeString = timeString.substring(timeString.length() - digit);
		return Integer.parseInt(timeString);
	}
	
	public static int randomNumberByDigit(int digit){
		double random = Math.random() * Math.pow(10,digit);
		int value = (int)random;
		if(value < 100000){
			String valueString = Integer.toString(value);
			int cha = digit - valueString.length();
			value = (int) (value * Math.pow(10, cha));	
		}
		return value;
	}
	
	public static boolean isMobilePhone(String mobiles){  
		Pattern p = Pattern.compile("^((13[0-9])|(15[^4,\\D])|(17[0-9])|(18[0,5-9]))\\d{8}$");  
		Matcher m = p.matcher(mobiles);  
		return m.matches();  
	}  
	
}