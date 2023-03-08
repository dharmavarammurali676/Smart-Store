package com.sutrix.demo.core.servlets;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sutrix.demo.core.dropdown.DropDownForAddEmail;
import com.sutrix.demo.core.dropdown.DropDownForEmployeeDetails;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.osgi.service.component.annotations.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Lists all districts via rest API.
 */
@Component(service = Servlet.class,
                      property = {
                                   "sling.servlet.methods=GET",
                                   "sling.servlet.paths=/bin/mydemo/dropdowns"
})
public class DropDownServlet extends SlingAllMethodsServlet {

    private static final long serialVersionUID = -7434298269108323345L;

    private static final Logger LOGGER = LoggerFactory.getLogger(DropDownServlet.class);

    private static final ObjectMapper objectMapper = new ObjectMapper();
    static {
        objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        objectMapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
    }

    @Override
    public void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response)
            throws IOException {

        try {

            List<DropDownForAddEmail> dropDownForAddEmails = new ArrayList<>();

            dropDownForAddEmails.add(new DropDownForAddEmail("dharmavarammurali@gmail.com"));
            dropDownForAddEmails.add(new DropDownForAddEmail("Krishna@gmail.com"));

            List<DropDownForEmployeeDetails> dropDownForEmployeeDetails = new ArrayList<>();

            dropDownForEmployeeDetails.add(new DropDownForEmployeeDetails("1","Murali","9100450554"));
            dropDownForEmployeeDetails.add(new DropDownForEmployeeDetails("2","Krishna","9100450554"));
            dropDownForEmployeeDetails.add(new DropDownForEmployeeDetails("3","Murari","9100450554"));


            response.setContentType("application/json; charset=UTF-8");
            response.getWriter().write(objectMapper.writeValueAsString(dropDownForAddEmails));
            response.getWriter().write(objectMapper.writeValueAsString(dropDownForEmployeeDetails));

        } catch (Exception ex) {
            LOGGER.error("error in getting districts list", ex);
        }
    }
    @Override
    protected void doPost(SlingHttpServletRequest request, SlingHttpServletResponse response) throws ServletException, IOException {
        try {

//            response.setContentType("text/html;charset-UTF-8");
//            PrintWriter out = response.getWriter();

            String AddEmails= request.getParameter("addemails");

            String EmployeeId = request.getParameter("employeeid");
            String EmployeeName = request.getParameter("employeename");
            String EmployeeMobileNo = request.getParameter("mobileno");

            response.setContentType("application/json; charset=UTF-8");
            response.getWriter().write(objectMapper.writeValueAsString(EmployeeId));
            response.getWriter().write(objectMapper.writeValueAsString(EmployeeName));
            response.getWriter().write(objectMapper.writeValueAsString(EmployeeMobileNo));

            response.getWriter().write("Employee Details Execute Successfully");

        } catch (Exception e) {
        }
    }
}