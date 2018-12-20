package com.itheima.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author dxf
 * @Description  把date类型转为字符类型和把字符类型转为日期类型
*/
public class Date2String {

    public static String dateToStr(Date date,String patt){
        SimpleDateFormat sdf=new SimpleDateFormat(patt);
        String dateStr= sdf.format(date);
        return dateStr;

    }

    public static Date strToDate(String str,String patt) throws Exception {
        SimpleDateFormat sdf=new SimpleDateFormat(patt);
        Date date = sdf.parse(str);
        return date;

    }
}
