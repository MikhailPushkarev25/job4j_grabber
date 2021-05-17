package grabber;

import org.quartz.Scheduler;
import org.quartz.SchedulerException;

public interface Grab {

    @SuppressWarnings("checkstyle:EmptyLineSeparator")
    void init(html.Parse parse, Store store, Scheduler scheduler) throws SchedulerException;
}
