package com.neuedu.his.common.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/**
 * 给病例数据生成主键
 */
public class CaseHistoryGenerator {

    //原子int
    private static AtomicInteger seq = new AtomicInteger(0);
    //dateform
    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
    //原子引用类型
    private static AtomicReference<String> strRef = new AtomicReference<>(sdf.format(new Date()));

    /**
     * 生成Id的方法
     */
    public static String genId() {
        updateTime();
        return strRef.get()+seq.getAndIncrement();
    }

    //判断当前时间是否和dateStr相等，不相等，就更新日期并且将seq设置为0
    private static void updateTime() {
        String curr = sdf.format(new Date());
        if(!curr.equals(strRef.get())){
            //更新时间
            strRef.set(curr);
            //重新建seq设置为0
            seq.set(0);
    }
    }
    //private static Date date= new Date();
//    private static String dateStr = null;
//    private static Integer seq = 0;
//    //时间戳+数字序列
//    public static synchronized String gen(){
//
//        //1、生成新的id时，seq+1 2、日期过了一天，dateStr需要变化，并且seq重新从0开始
//        //1、获得日期的前缀 dateStr
//        String id = genPrefix()+genSuffix();
//        return  id;
//    }
//
//    /**
//     * 生成后缀：给seq补0，同时给seq+1
//     * @return
//     */
//    private static String genSuffix(){
//        String suffix = String.format("%04d",seq);
//        seq += 1;
//        return suffix;
//    }
//    //生成前缀20180708
//    private static String genPrefix(){
//        Date current = new Date();
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
//        String currStr = sdf.format(current);
//
//        //currStr = 20190709    dateStr=20190708
//        if(!currStr.equals(dateStr)){
//            dateStr = currStr;
//            seq = 0 ;
//        }
//        return dateStr;

}
