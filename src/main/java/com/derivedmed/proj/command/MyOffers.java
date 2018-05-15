package com.derivedmed.proj.command;

import com.derivedmed.proj.factory.ServiceFactory;
import com.derivedmed.proj.model.Report;
import com.derivedmed.proj.model.User;
import com.derivedmed.proj.services.ReportService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;

public class MyOffers implements ICommand {
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) {
        User user = (User) req.getSession().getAttribute("user");
        ReportService reportService = ServiceFactory.getReportService();
        HashMap<String, Report> reports = reportService.getReportsOfferedBySpeakerOrModer(user.getId(), true);
        req.setAttribute("reports", reports.entrySet());
        HashMap<String, Report> reportsByModer = reportService.getReportsOfferedBySpeakerOrModer(user.getId(), false);
        req.setAttribute("reportsByModer", reportsByModer.entrySet());
        if (req.getMethod().equals("GET")) {
            return "pages/myoffers.jsp";
        }
        reportService.confirmOffer(user.getId(), Integer.parseInt(req.getParameter("reportid")));
        return "pages/myoffers.jsp";
    }
}
