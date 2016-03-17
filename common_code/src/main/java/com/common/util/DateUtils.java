package com.common.util;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import com.common.enumdata.DateEnum;
import com.cutom.exception.CustException;
import com.cutom.exception.ErrorCode;

public class DateUtils {
	
	public static TimeZone LOCAL_TZ = TimeZone.getTimeZone("GMT");
	
	public static Date parseDate(String dateString, String format) throws CustException {
		Date date = null;
		if (dateString == null || dateString.isEmpty()) {
			return null;
		}
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
		try {
			date = simpleDateFormat.parse(dateString);
		} catch (ParseException exception) {
			throw new CustException(exception, ErrorCode.DATE_PARSER_ERROR);
		}
		return date;
	}
	
	/**
	 * @param inputDate
	 * @param format
	 * @return
	 * @throws CustException
	 */
	public static Date buildDefaultFormatDate(Date inputDate) throws CustException {
		Date date = null;
		if (inputDate == null) {
			return null;
		}
		date = parseDate(formatDate(inputDate, null), DateEnum.DATE_FORMAT.getValue());
		return date;
	}
	
	

	/**
	 * @param intervalMonths
	 * @param intervalDays
	 * @param intervalYears
	 * @param fromDate
	 * @param future
	 * @return
	 */

	public static String formatDate(Date date, String format){
		String formattedDate = null;
		if (format == null) {
			format = DateEnum.DATE_FORMAT.getValue();
		}
		if (date == null) {
			return null;
		} else {
			SimpleDateFormat dateFormat = new SimpleDateFormat(format);
			formattedDate = dateFormat.format(date);
			return formattedDate;
		}
	}

	public static Long getDateDifference(Date fromDate, Date toDate){
		LocalDate fromLocalDate = fromDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		LocalDate toLocalDate = toDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		return ChronoUnit.DAYS.between(fromLocalDate, toLocalDate);
	}

	/**
	 * @param dateValue
	 *            is value of date
	 * @param noDays
	 *            is number of days by which we want get increment from
	 *            dateValue
	 * @return incremental date in object form
	 */
	public static Date incrementDay(Date dateValue, int noDays) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(dateValue);
		calendar.add(Calendar.DATE, noDays);
		return calendar.getTime();
	}

	/**
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	public static List<Date> getAllDatesInRange(Date startDate, Date endDate) {
		List<Date> rangeDates = new ArrayList<>();
		for (Date date = startDate; !date.after(endDate);) {
			rangeDates.add(date);
			date = DateUtils.incrementDay(date, 1);
			date = new Timestamp(date.getTime());
		}
		/*
		 * if (rangeDates.isEmpty() && startDate != null) {
		 * rangeDates.add(startDate); }
		 */
		return rangeDates;
	}
	
	public static Date addMinutes(Date date, int minutes) {
		Calendar now = Calendar.getInstance();
		now.setTime(date);
		now.add(Calendar.MINUTE, minutes);
		return now.getTime();

	}
	
	public static boolean compareTime(Date currentTime, Date expiryTime) {
		return (currentTime.before(expiryTime) || currentTime.equals(expiryTime));
	}
	
	/*public boolean isDatePast(Long deviceLong){
		Calendar deviceCal = Calendar.getInstance();
		deviceCal.setTimeInMillis(deviceLong);
		String pastSeconds=getMessage(HrConstants.DateConstant.CALENDER_PAST_SECONDS,null);
		String futureSeconds=getMessage(HrConstants.DateConstant.CALENDER_FUTURE_SECOND,null);
		Calendar serverCalAhead = Calendar.getInstance();
		serverCalAhead.add(Calendar.SECOND, Integer.parseInt(futureSeconds));
		
		Calendar serverCalPast = Calendar.getInstance();
		serverCalPast.add(Calendar.SECOND, Integer.parseInt(pastSeconds));
		
		if(deviceCal.before(serverCalPast) || deviceCal.after(serverCalAhead))
		{
			return true;
		}else{
			return false;
		}
	}*/
	
	
}
