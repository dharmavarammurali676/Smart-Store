package com.sutrix.demo.core.workflow;

import com.adobe.granite.workflow.WorkflowException;
import com.adobe.granite.workflow.WorkflowSession;
import com.adobe.granite.workflow.exec.WorkItem;
import com.adobe.granite.workflow.exec.WorkflowProcess;
import com.adobe.granite.workflow.metadata.MetaDataMap;
import org.osgi.service.component.annotations.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Dharmavaram Murali
 */
@Component(service = WorkflowProcess.class, property = {"process.label = Custom Workflow Waiting"})
public class CustomWorkflow implements WorkflowProcess {


    private static final Logger log = LoggerFactory.getLogger(CustomWorkflow.class);

    @Override
    public void execute(WorkItem workItem, WorkflowSession workflowSession, MetaDataMap metaDataMap) throws WorkflowException {

        log.info("Executing the workflow");

        try {

            String textValue = metaDataMap.get("textValue", "empty");

            String dateValue = metaDataMap.get("dateValue", "empty");

            log.info("Text: {}", textValue);
            log.info("Date: {}", dateValue);

        } catch (Exception e) {

            log.error(e.getMessage(), e);
        }
    }

}