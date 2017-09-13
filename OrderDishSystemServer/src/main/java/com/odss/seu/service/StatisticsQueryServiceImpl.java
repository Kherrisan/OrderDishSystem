package com.odss.seu.service;


import com.odss.seu.mapper.OrderMapper;
import com.odss.seu.vo.OrderExample;
import com.odss.seu.vo.Statistics;
import org.springframework.beans.factory.annotation.Autowired;


import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class StatisticsQueryServiceImpl implements StatisticsQueryService{

    @Autowired
    private OrderMapper orderMapper;

    @Override
    public Statistics queryAllStatisticsByYear(Date startTime, Date endTime)
    {

        OrderExample example =new  OrderExample();
        OrderExample.Criteria criteria=example.createCriteria();


        List<Statistics> StatisticsList= new ArrayList<Statistics>();

        //         还需要处理一下得到的数据，将他们按照年份计算求和或求均值
        // ——startTime不变，endTime不变，income求和，sellNum求和，fantai求均值=求和+除去个数？=总共有的餐次数除去餐桌数除去天数
        Calendar StartTime=Calendar.getInstance();//先将data转为calendar
        StartTime.setTime((Date) startTime);
        Calendar EndTime=Calendar.getInstance();//先将data转为calendar
        StartTime.setTime((Date) endTime);

        int startYear=StartTime.get(Calendar.YEAR);
        int endYear=EndTime.get(Calendar.YEAR);
//        int startMonth=StartTime.get(Calendar.MONTH);
//        int endMonth=EndTime.get(Calendar.MONTH);
//        int startDay=StartTime.get(Calendar.DAY_OF_MONTH);
//        int endDay=EndTime.get(Calendar.DAY_OF_MONTH);


        int lengthOfGotList=0;
        List<Statistics> statisticsList=null;
        Statistics statistics=new Statistics();

        //        如果开始时间与结束时间在同一年，就只算这一年内的从开始时间到结束时间的经营情况
        if(endYear==startYear)
        {
//        开始时间比要求的开始时间晚或相当
            criteria.andTimeGreaterThanOrEqualTo(startTime);
//        结束时间比要求的结束时间早或相当
            criteria.andTimeLessThanOrEqualTo(endTime);
            statisticsList= orderMapper.selectByExample(example);
            lengthOfGotList=statisticsList.size();//所有信息的条目数

            statistics.setstartTime(startTime);
            statistics.setendTime(endTime);

            int  allIncome=0;
            int  allSellNum=0;
            int allFantai=0;
//            处理信息
            for(int i=0;i<lengthOfGotList;i++)
            {
                allIncome+= statisticsList.get(i).getIncome();
                allSellNum+=statisticsList.get(i).getSellNum();
                allFantai+=statisticsList.get(i).getFantai();
            }
            allFantai/=lengthOfGotList;
            statistics.setIncome(allIncome);
            statistics.setSellNum(allFantai);
            statistics.setFantai(allFantai);

            StatisticsList.add(statistics);
        }
        else
        {

//        根据日期，算出循环的年数，每一年算出各自一年的经营情况，
            int forTimes=endYear-startYear+1;

            Date startnow = null;
            Date endnow = null;
            int year=0;
            Calendar StartTimeForChange = null;

            for(int i=0;i<forTimes;i++)
            {
//        第一年按照开始时间到年末算，结尾一年按照年初到结束时间算
                if(i==0)//第一年
                {
                    //第一年按照开始时间到年末算
                    startnow=startTime;
                    criteria.andTimeGreaterThanOrEqualTo(startnow);
                    statistics.setstartTime(startnow);

                    //计算年末
                    StartTimeForChange=Calendar.getInstance();
                    StartTimeForChange.setTime((Date) startnow);//转换为calender
                    year=StartTimeForChange.get(Calendar.YEAR);
                    StartTimeForChange.set(year,12,31);
                    endnow=StartTimeForChange.getTime();

                    criteria.andTimeLessThanOrEqualTo(endnow);
                    statistics.setendTime(endnow);
                }
                else if(i==(forTimes-1) )//末尾一年，如果是末尾一轮，就用endTime作为结束
                {
                    StartTimeForChange.setTime((Date) endnow);
                    year=StartTimeForChange.get(Calendar.YEAR);
                    year+=1;
                    StartTimeForChange.set(year,1,1);
                    startnow=StartTimeForChange.getTime();
                    //        开始时间比要求的开始时间晚或相当
                    criteria.andTimeGreaterThanOrEqualTo(startnow);
                    statistics.setstartTime(startnow);


                    //        结束时间比要求的结束时间早或相当
                    criteria.andTimeLessThanOrEqualTo(endTime);
                    statistics.setendTime(endTime);
                }
                else//其余年
                {

                    StartTimeForChange.setTime((Date) endnow);
                    year=StartTimeForChange.get(Calendar.YEAR);
                    year+=1;
                    StartTimeForChange.set(year,1,1);
                    startnow=StartTimeForChange.getTime();
                    //        开始时间比要求的开始时间晚或相当
                    criteria.andTimeGreaterThanOrEqualTo(startnow);
                    statistics.setstartTime(startnow);

                    StartTimeForChange.set(year,12,31);
                    endnow=StartTimeForChange.getTime();
                    //        结束时间比要求的结束时间早或相当
                    criteria.andTimeLessThanOrEqualTo(endnow);
                    statistics.setendTime(endnow);
                }

               statisticsList= orderMapper.selectByExample(example);
                lengthOfGotList=statisticsList.size();

                int  allIncome=0;
                int  allSellNum=0;
                int allFantai=0;

//            处理信息
                for(int j=0;j<lengthOfGotList;j++)
                {
                    allIncome+= statisticsList.get(j).getIncome();
                    allSellNum+=statisticsList.get(j).getSellNum();
                    allFantai+=statisticsList.get(j).getFantai();
                }
                allFantai/=lengthOfGotList;
                statistics.setIncome(allIncome);
                statistics.setSellNum(allFantai);
                statistics.setFantai(allFantai);

                //        整理得到一条新的数据，最后汇总到一个新的list当中，最终输出
                StatisticsList.add(statistics);
                //
            }
        }

        return StatisticsList.get(0);
    }
//        if(statisticsList==null||statisticsList.size()==0)
//        {
//            throws new StatisticsNotFoundException();
//        }else if
//        {
//        }

//___________________________________________________________________________________________________________________________

    @Override
    public Statistics queryAllStatisticsByMonth(Date startTime, Date endTime) {

        OrderExample example =new  OrderExample();
        OrderExample.Criteria criteria=example.createCriteria();

        //最后的结果存放处
        List<Statistics> StatisticsList= new ArrayList<Statistics>();

        //         还需要处理一下得到的数据，将他们按照年份计算求和或求均值
        // ——startTime不变，endTime不变，income求和，sellNum求和，fantai求均值=求和+除去个数？=总共有的餐次数除去餐桌数除去天数
        Calendar StartTime=Calendar.getInstance();//先将data转为calendar
        StartTime.setTime((Date) startTime);
        Calendar EndTime=Calendar.getInstance();//先将data转为calendar
        StartTime.setTime((Date) endTime);

        int startYear=StartTime.get(Calendar.YEAR);
        int endYear=EndTime.get(Calendar.YEAR);
        int startMonth=StartTime.get(Calendar.MONTH);
        int endMonth=EndTime.get(Calendar.MONTH);
//        int startDay=StartTime.get(Calendar.DAY_OF_MONTH);
//        int endDay=EndTime.get(Calendar.DAY_OF_MONTH);

        int lengthOfGotList=0;
        List<Statistics> statisticsList=null;

        Statistics statistics=new Statistics();
        Date startnow = null;
        Date endnow = null;
        int year=0;
        int month=0;
        Calendar StartTimeForChange = null;
        int[] monthDay={0,31,28,31,30,31,30,31,31,30,31,30,31};

//        如果开始时间与结束时间在同一年，就只算这一年内的从开始时间到结束时间的经营情况
        if(endYear==startYear)
        {

            //        如果开始时间与结束时间在同一月，就只算这一月内的从开始时间到结束时间的经营情况
            if(endMonth==startMonth)
            {

//        开始时间比要求的开始时间晚或相当
                criteria.andTimeGreaterThanOrEqualTo(startTime);
//        结束时间比要求的结束时间早或相当
                criteria.andTimeLessThanOrEqualTo(endTime);

                statisticsList= orderMapper.selectByExample(example);
                lengthOfGotList=statisticsList.size();//所有信息的条目数

                statistics.setstartTime(startTime);
                statistics.setendTime(endTime);
                int  allIncome=0;
                int  allSellNum=0;
                int allFantai=0;

//            处理信息
                for(int i=0;i<lengthOfGotList;i++)
                {
                    allIncome+= statisticsList.get(i).getIncome();
                    allSellNum+=statisticsList.get(i).getSellNum();
                    allFantai+=statisticsList.get(i).getFantai();
                }
                allFantai/=lengthOfGotList;
                statistics.setIncome(allIncome);
                statistics.setSellNum(allFantai);
                statistics.setFantai(allFantai);

                StatisticsList.add(statistics);
            }
            else//同一年，不同月
            {
                for(int i=0;i<(endMonth-startMonth+1);i++)
                {

                    if(i==0)
                    {
                        //第一月按照开始时间到月末算
                        startnow=startTime;
                        criteria.andTimeGreaterThanOrEqualTo(startnow);
                        statistics.setstartTime(startnow);

                        //计算月末
                        StartTimeForChange=Calendar.getInstance();
                        StartTimeForChange.setTime((Date) startnow);//转换为calender
                        year=StartTimeForChange.get(Calendar.YEAR);
                        month=StartTimeForChange.get(Calendar.MONTH);
                        StartTimeForChange.set(year,month,monthDay[month]);
                        endnow=StartTimeForChange.getTime();

                        criteria.andTimeLessThanOrEqualTo(endnow);
                        statistics.setendTime(endnow);
                    }
                    else if(i==(endMonth-startMonth+1))
                    {
                        //最后一个月按照月初到结束时间
                        StartTimeForChange.setTime(endnow);
                        year=StartTimeForChange.get(Calendar.YEAR);
                        month=StartTimeForChange.get(Calendar.MONTH);
                        month+=1;
                        StartTimeForChange.set(year,month,1);
                        startnow=StartTimeForChange.getTime();
                        criteria.andTimeGreaterThanOrEqualTo(startnow);
                        statistics.setstartTime(startnow);

                        endnow=endTime;
                        criteria.andTimeLessThanOrEqualTo(endnow);
                        statistics.setendTime(endnow);

                    }
                    else
                    {
                        //其它月
                        //月初
                        StartTimeForChange.setTime(endnow);
                        year=StartTimeForChange.get(Calendar.YEAR);
                        month=StartTimeForChange.get(Calendar.MONTH);
                        month+=1;
                        StartTimeForChange.set(year,month,1);
                        startnow=StartTimeForChange.getTime();
                        criteria.andTimeGreaterThanOrEqualTo(startnow);
                        statistics.setstartTime(startnow);

                        //月末
                        StartTimeForChange.set(year,month,monthDay[month]);
                        endnow=StartTimeForChange.getTime();
                        criteria.andTimeLessThanOrEqualTo(endnow);
                        statistics.setendTime(endnow);

                    }

                    statisticsList= orderMapper.selectByExample(example);
                    lengthOfGotList=statisticsList.size();//所有信息的条目数

                    statistics.setstartTime(startTime);
                    statistics.setendTime(endTime);
                    int  allIncome=0;
                    int  allSellNum=0;
                    int allFantai=0;
//            处理信息
                    for(int j=0;j<lengthOfGotList;j++)
                    {
                        allIncome+= statisticsList.get(j).getIncome();
                        allSellNum+=statisticsList.get(j).getSellNum();
                        allFantai+=statisticsList.get(j).getFantai();
                    }
                    allFantai/=lengthOfGotList;
                    statistics.setIncome(allIncome);
                    statistics.setSellNum(allFantai);
                    statistics.setFantai(allFantai);

                    StatisticsList.add(statistics);
                }
            }

        }
        else
        {

//        开始时间与结束时间不在同一年，先根据日期，算出循环的年数，之后每一年算出各自一年的每月经营情况，
            int forTimes=endYear-startYear+1;
            int forTimesForMonth=0;
            for(int i=0;i<forTimes;i++)
            {
//        每一年
                if(i==0)//第一年
                {
                    forTimesForMonth=12-startMonth+1;
                    for(int j=0;j<forTimesForMonth;j++)
                    {
                        if(j==0)
                        {
                            //第一月按照开始时间到月末算
                            startnow=startTime;
                            criteria.andTimeGreaterThanOrEqualTo(startnow);
                            statistics.setstartTime(startnow);

                            //计算月末
                            StartTimeForChange=Calendar.getInstance();
                            StartTimeForChange.setTime((Date) startnow);//转换为calender
                            year=StartTimeForChange.get(Calendar.YEAR);
                            month=StartTimeForChange.get(Calendar.MONTH);
                            StartTimeForChange.set(year,month,monthDay[month]);
                            endnow=StartTimeForChange.getTime();

                            criteria.andTimeLessThanOrEqualTo(endnow);
                            statistics.setendTime(endnow);
                        }
                        else//普通月，以及年末也算在内
                        {
                            //月初
                            StartTimeForChange.setTime(endnow);
                            year=StartTimeForChange.get(Calendar.YEAR);
                            month=StartTimeForChange.get(Calendar.MONTH);
                            month+=1;
                            StartTimeForChange.set(year,month,1);
                            startnow=StartTimeForChange.getTime();
                            criteria.andTimeGreaterThanOrEqualTo(startnow);
                            statistics.setstartTime(startnow);

                            //月末
                            StartTimeForChange.set(year,month,monthDay[month]);
                            endnow=StartTimeForChange.getTime();
                            criteria.andTimeLessThanOrEqualTo(endnow);
                            statistics.setendTime(endnow);
                        }

                        statisticsList = orderMapper.selectByExample(example);
                        lengthOfGotList=statisticsList.size();//所有信息的条目数//

                        int allIncome = 0;
                        int allSellNum = 0;
                        int allFantai = 0;

//            处理信息
                        for (int k = 0; k < lengthOfGotList; k++)
                        {
                            allIncome += statisticsList.get(k).getIncome();
                            allSellNum += statisticsList.get(k).getSellNum();
                            allFantai += statisticsList.get(k).getFantai();
                        }
                        allFantai /= lengthOfGotList;
                        statistics.setIncome(allIncome);
                        statistics.setSellNum(allFantai);
                        statistics.setFantai(allFantai);

                        //        整理得到一条新的数据，最后汇总到一个新的list当中，最终输出
                        StatisticsList.add(statistics);
                    }
                }
                else if(i==(forTimes-1) )//末尾一年，如果是末尾一轮，就用endTime作为结束
                {
                    forTimesForMonth=endMonth;
                    year = StartTimeForChange.get(Calendar.YEAR);
                    year += 1;
                    month=1;
                    //末尾一年的每个月
                    for(int j=0;j<forTimesForMonth;j++)
                    {
                        //第一月
                        if(j==0)
                        {
//                            StartTimeForChange.setTime((Date) endnow);
                            StartTimeForChange.set(year, month, 1);
                            startnow = StartTimeForChange.getTime();
                            //        开始时间比要求的开始时间晚或相当
                            criteria.andTimeGreaterThanOrEqualTo(startnow);
                            statistics.setstartTime(startnow);

                            StartTimeForChange.set(year, month, monthDay[month]);
                            endnow = StartTimeForChange.getTime();
                            //        结束时间比要求的结束时间早或相当
                            criteria.andTimeLessThanOrEqualTo(endTime);
                            statistics.setendTime(endTime);
                        }
                        else  if (j==forTimesForMonth-1)
                        {
                            //末尾年末尾月
                            StartTimeForChange.setTime((Date) endnow);
                            year = StartTimeForChange.get(Calendar.YEAR);
                            month=StartTimeForChange.get(Calendar.MONTH);
                            month+=1;
                            StartTimeForChange.set(year, month, 1);
                            startnow = StartTimeForChange.getTime();
                            //        开始时间比要求的开始时间晚或相当
                            criteria.andTimeGreaterThanOrEqualTo(startnow);
                            statistics.setstartTime(startnow);

                            endnow = endTime;
                            //        结束时间比要求的结束时间早或相当
                            criteria.andTimeLessThanOrEqualTo(endTime);
                            statistics.setendTime(endTime);
                        }
                        else
                        {
                            //末尾年其它月
                            StartTimeForChange.setTime((Date) endnow);
                            year = StartTimeForChange.get(Calendar.YEAR);
                            month=StartTimeForChange.get(Calendar.MONTH);
                            month+=1;
                            StartTimeForChange.set(year, month, 1);
                            startnow = StartTimeForChange.getTime();
                            //        开始时间比要求的开始时间晚或相当
                            criteria.andTimeGreaterThanOrEqualTo(startnow);
                            statistics.setstartTime(startnow);

                            StartTimeForChange.set(year,month,monthDay[month]);
                            endnow=StartTimeForChange.getTime();
                            criteria.andTimeLessThanOrEqualTo(endnow);
                            statistics.setendTime(endnow);
                        }
                    }

                    statisticsList= orderMapper.selectByExample(example);
                    lengthOfGotList=statisticsList.size();

                    int  allIncome=0;
                    int  allSellNum=0;
                    int allFantai=0;

//            处理信息
                    for(int j=0;j<lengthOfGotList;j++)
                    {
                        allIncome+= statisticsList.get(i).getIncome();
                        allSellNum+=statisticsList.get(i).getSellNum();
                        allFantai+=statisticsList.get(i).getFantai();
                    }
                    allFantai/=lengthOfGotList;
                    statistics.setIncome(allIncome);
                    statistics.setSellNum(allFantai);
                    statistics.setFantai(allFantai);

//        整理得到一条新的数据，最后汇总到一个新的list当中，最终输出
                    StatisticsList.add(statistics);

                }
                else//其余年
                {

                    forTimesForMonth=12;
                    month=1;
                    StartTimeForChange.setTime(endnow);
                    year=StartTimeForChange.get(Calendar.YEAR);
                    year+=1;
                    StartTimeForChange.set(year,month,1);
                    startnow=StartTimeForChange.getTime();
                    StartTimeForChange.set(year,month,monthDay[month]);
                    endnow=StartTimeForChange.getTime();

                    for(int j=0;j<forTimesForMonth;j++) {


                        criteria.andTimeGreaterThanOrEqualTo(startnow);
                        statistics.setstartTime(startnow);
                        criteria.andTimeLessThanOrEqualTo(endnow);
                        statistics.setendTime(endnow);

                        statisticsList = orderMapper.selectByExample(example);
                        lengthOfGotList=statisticsList.size();//所有信息的条目数

                        int allIncome = 0;
                        int allSellNum = 0;
                        int allFantai = 0;
//            处理信息
                        for (int k = 0; k < lengthOfGotList; k++)
                        {
                            allIncome += statisticsList.get(k).getIncome();
                            allSellNum += statisticsList.get(k).getSellNum();
                            allFantai += statisticsList.get(k).getFantai();
                        }
                        allFantai /= lengthOfGotList;
                        statistics.setIncome(allIncome);
                        statistics.setSellNum(allFantai);
                        statistics.setFantai(allFantai);

//        整理得到一条新的数据，最后汇总到一个新的list当中，最终输出
                        StatisticsList.add(statistics);

                        //月初
                        StartTimeForChange.setTime(endnow);
                        year=StartTimeForChange.get(Calendar.YEAR);
                        month=StartTimeForChange.get(Calendar.MONTH);
                        month+=1;
                        StartTimeForChange.set(year,month,1);
                        startnow=StartTimeForChange.getTime();

                        //月末
                        StartTimeForChange.set(year,month,monthDay[month]);
                        endnow=StartTimeForChange.getTime();

                    }
                }

            }
        }

        return StatisticsList.get(0);
    }

    @Override
    public Statistics queryAllStatisticsByDay(Date startTime, Date endTime) {
        OrderExample example =new  OrderExample();
        OrderExample.Criteria criteria=example.createCriteria();

//        开始时间比要求的开始时间晚或相当
        criteria.andTimeGreaterThanOrEqualTo(startTime);
//        结束时间比要求的结束时间早或相当
        criteria.andTimeLessThanOrEqualTo(endTime);

        List<Statistics> statisticsList= orderMapper.selectByExample(example);

        return statisticsList.get(0);
    }


}