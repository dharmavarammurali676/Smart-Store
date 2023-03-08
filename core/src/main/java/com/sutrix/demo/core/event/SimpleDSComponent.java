package com.sutrix.demo.core.event;//package com.sutrix.demo.core.event;
//
//import org.apache.felix.scr.annotations.Component;
//import org.apache.felix.scr.annotations.Properties;
//import org.apache.felix.scr.annotations.Property;
//import org.apache.felix.scr.annotations.Service;
//import org.osgi.framework.BundleContext;
//import org.osgi.service.component.ComponentContext;
//import org.osgi.service.component.annotations.Component;
//import org.osgi.service.event.Event;
//import org.osgi.service.event.EventConstants;
//import org.osgi.service.event.EventHandler;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//import com.day.cq.replication.ReplicationAction;
//import com.day.cq.workflow.event.WorkflowEvent;
////Sling Imports
//
//
///**
// * Just a simple DS Component
// */
//@Component
//@Service
//@Properties({
//
//        @Property(
//                label = "Event Topics",
//                value = { ReplicationAction.EVENT_TOPIC },
//                description = "[Required] Event Topics this event handler will to respond to.",
//                name = EventConstants.EVENT_TOPIC,
//                propertyPrivate = true
//        ),
//        @Property(
//                label = "Event Filters",
//                value = "(" + ReplicationAction.PROPERTY_TYPE + "=ACTIVATE)",
//                description = "Replication action",
//                name = EventConstants.EVENT_FILTER,
//                propertyPrivate = true)
//})
//})
//public class SimpleDSComponent implements Runnable, EventHandler {
//
//    private Logger log = LoggerFactory.getLogger(this.getClass());
//
//
//
//    private BundleContext bundleContext;
//
//
//    public void handleEvent(Event event) {
//
//        String n[] = event.getPropertyNames();
//
//        log.info("");
//
//        log.info("Event occurred: {}", event.getProperty(WorkflowEvent.EVENT_TYPE));
//
//        log.info("Event properties: ");
//
//        for(String s : n) {
//
//            log.info(s + " = " + event.getProperty(s));
//
//        }
//
//
//
//        ReplicationAction action = ReplicationAction.fromEvent(event);
//
//        if(action != null) {
//
//            log.info("Replication action {} occured on {} ", action.getType().getName(), action.getPath());
//            log.info("Tushar Replication");
//
//        }
//
//        log.info("");
//
//    }
//
//
//    public void run() {
//        log.info("Running...");
//    }
//
//    protected void activate(ComponentContext ctx) {
//        this.bundleContext = ctx.getBundleContext();
//    }
//
//    protected void deactivate(ComponentContext ctx) {
//        this.bundleContext = null;
//    }
//
//}
