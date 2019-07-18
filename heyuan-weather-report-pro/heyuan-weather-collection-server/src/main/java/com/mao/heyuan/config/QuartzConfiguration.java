package com.mao.heyuan.config;

import com.mao.heyuan.job.WeatherDataSyncJob;
import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class QuartzConfiguration {
    private static final int TIME = 1800;

    @Bean
    public JobDetail weatherDataSyncJobDetail() {
        //	return JobBuilder.newJob(WeatherDataSyncJob.class).withIdentity("weatherDataSyncJob")
        //		.storeDurably().build();
        return JobBuilder.newJob(WeatherDataSyncJob.class).withIdentity("weatherDataSyncJob").storeDurably().build();
    }

    @Bean
    public Trigger weatherDataSyncTrigger() {
        //	SimpleScheduleBuilder schedBuilder = SimpleScheduleBuilder.simpleSchedule()
        //				.withIntervalInSeconds(TIME).repeatForever();
        //
        //		return TriggerBuilder.newTrigger().forJob(weatherDataSyncJobDetail())
        //				.withIdentity("weatherDataSyncTrigger").withSchedule(schedBuilder).build();

        SimpleScheduleBuilder scheduleBuilder = SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(TIME).repeatForever();

        return TriggerBuilder.newTrigger().forJob(weatherDataSyncJobDetail()).withIdentity("weatherDataSyncTrigger").withSchedule(scheduleBuilder).build();
    }


}
