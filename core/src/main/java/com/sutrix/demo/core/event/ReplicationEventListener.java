package com.sutrix.demo.core.event;
import com.day.cq.replication.ReplicationAction;
import com.day.cq.replication.ReplicationActionType;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.event.Event;
import org.osgi.service.event.EventConstants;
import org.osgi.service.event.EventHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component(service = EventHandler.class,
        immediate = true,
        property = {
                EventConstants.EVENT_TOPIC + "=" + ReplicationAction.EVENT_TOPIC,
        })
public class ReplicationEventListener implements EventHandler {

    private static final Logger LOG = LoggerFactory.getLogger(ReplicationEventListener.class);

    public void handleEvent(final Event event) {
        try {
            LOG.info("\n Event Type : {} ", event.getTopic());
            if (ReplicationAction.fromEvent(event).getType().equals(ReplicationActionType.ACTIVATE)) {

                LOG.info("\n Pages/Assets Activated (or) Publish :  {}", ReplicationAction.fromEvent(event).getPath());
            }
            if (ReplicationAction.fromEvent(event).getType().equals(ReplicationActionType.DEACTIVATE)) {
                LOG.info("\n Pages/Assets Deactivated (or) UnPublish :  {}", ReplicationAction.fromEvent(event).getPath());
            }

        }catch (Exception e){
            LOG.error("\n Error while Activating/Deactivating - {} " , e.getMessage());
        }
    }
}
