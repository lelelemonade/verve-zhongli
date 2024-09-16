package com.verve.verve_zhongli.utils;

import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.filter.AbstractMatcherFilter;
import ch.qos.logback.core.spi.FilterReply;
import com.verve.verve_zhongli.service.IdCountFlushService;

// highly customizable logback filter to log id count flush log result to specific file
public class IdCountFlushLogFilter extends AbstractMatcherFilter<ILoggingEvent> {

    @Override
    public FilterReply decide(ILoggingEvent event) {
        if (!isStarted()) {
            return FilterReply.NEUTRAL;
        }

        if (event.getLoggerName().equals(IdCountFlushService.class.getName())) {
            return onMatch;
        } else {
            return onMismatch;
        }
    }
}
