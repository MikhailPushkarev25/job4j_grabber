package quartz;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.io.InputStream;
import java.sql.*;
import java.util.*;

import static org.quartz.JobBuilder.newJob;
import static org.quartz.SimpleScheduleBuilder.simpleSchedule;
import static org.quartz.TriggerBuilder.newTrigger;

public class AlertRabbit {

    @SuppressWarnings({"checkstyle:LineLength", "checkstyle:OperatorWrap"})
    public static void main(String[] args) {

        Properties properties = new Properties();
            try (InputStream io = AlertRabbit.class.getClassLoader().
                    getResourceAsStream("postsql.properties")) {
                properties.load(io);
                if (io != null) {
                    io.close();
                }
                Class.forName(properties.getProperty("driver-class-name"));
                try (Connection connection = DriverManager.getConnection(
                        properties.getProperty("url"),
                        properties.getProperty("username"),
                        properties.getProperty("password")
                )) {
                    try (PreparedStatement statement = connection.
                            prepareStatement(
                            "CREATE TABLE IF NOT EXISTS rabbit "
                                    + "(id serial primary key, created_date timestamp);")) {
                        statement.executeUpdate();
                        statement.execute();
                        Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
                        scheduler.start();
                        JobDataMap data = new JobDataMap();
                        data.put("connection", connection);
                        JobDetail job = newJob(Rabbit.class)
                                .usingJobData(data)
                                .build();
                        SimpleScheduleBuilder times = simpleSchedule()
                                .withIntervalInSeconds(Integer
                                        .parseInt(properties.getProperty("rabbit.interval")))
                                .repeatForever();
                        SimpleTrigger trigger = newTrigger()
                                .startNow()
                                .withSchedule(times)
                                .build();
                        scheduler.scheduleJob(job, trigger);
                        Thread.sleep(10000);
                        scheduler.shutdown();
                    }

                }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static class Rabbit implements Job {

        public Rabbit() {
            System.out.println(hashCode());
        }

        @Override
        public void execute(JobExecutionContext context) {
            System.out.println("Rabbit runs here ...");
            Connection connection = (Connection) context.
                    getJobDetail().getJobDataMap().get("connect");

               try (PreparedStatement statement = connection.prepareStatement(
                        "INSERT INTO rabbit(created_date) values (?);"
                )) {
                statement.setTimestamp(1, new Timestamp(System.currentTimeMillis()));
                statement.executeUpdate();
            } catch (SQLException s) {
                s.printStackTrace();
            }
        }
    }
}
