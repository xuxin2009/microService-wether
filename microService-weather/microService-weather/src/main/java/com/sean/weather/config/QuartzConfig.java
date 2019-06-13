package com.sean.weather.config;

import com.sean.weather.Job.WeatherDataSyncJob;
import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Administrator on 2019/6/11.
 */
@Configuration
public class QuartzConfig {

    //需要两个方法jobdetail和Trigger

    @Bean
    public JobDetail weatherDataSyncJobDetail()
    {
        return JobBuilder.
                newJob(WeatherDataSyncJob.class).
                withIdentity("weatherDataSyncJobDetail").
                usingJobData("msg", "Hello Quartz").
                storeDurably().
                build();
    }

    @Bean
    public Trigger weatherDataSyncTrigger()
    {
        SimpleScheduleBuilder schedule = SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(60*60).repeatForever();
        return TriggerBuilder.
                newTrigger().
                forJob(weatherDataSyncJobDetail()).
                withSchedule(schedule).
                withIdentity("weatherDataSyncTrigger").
                build();
    }


}
