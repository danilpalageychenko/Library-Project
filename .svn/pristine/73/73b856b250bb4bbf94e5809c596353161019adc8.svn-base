package ua.org.oa._dani4_.service.impl;

import ua.org.oa._dani4_.dao.Dao;
import ua.org.oa._dani4_.dao.daoImpl.ReportDaoSqlImpl;
import ua.org.oa._dani4_.model.dto.ReportDTO;
import ua.org.oa._dani4_.model.elements.Report;
import ua.org.oa._dani4_.properties.PropertyUtils;
import ua.org.oa._dani4_.service.IReportService;
import ua.org.oa._dani4_.transform.Transformer;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * Created by Admin on 03.04.2016.
 */
public class ReportServiceImpl implements IReportService<ReportDTO> {

    private static ReportServiceImpl reportService;
    private Dao<Report> reportDAO = fetchDAO();
    private ReportServiceImpl() { }
    private Dao<Report> fetchDAO() {
        Dao<Report> reportDAO = null;
        Properties properties = PropertyUtils.getProperties();
        String value = properties.getProperty("DB");
        switch (value) {
            case "JDBC":
                reportDAO = new ReportDaoSqlImpl();
                break;
        }
        return reportDAO;
    }

    public synchronized static ReportServiceImpl getInstance() {
        if (reportService == null) {
            reportService = new ReportServiceImpl();
        }
        return reportService;
    }


    @Override
    public ReportDTO findById(int id) {
        Report reportById = reportDAO.read(id);
        return Transformer.transformReport(reportById);
    }

    @Override
    public int create(ReportDTO reportDTO) {
        Report report = Transformer.transformReportDTO(reportDTO);
        return reportDAO.create(report).getId();
    }

    @Override
    public boolean update (ReportDTO reportDTO) {
        Report report = Transformer.transformReportDTO(reportDTO);
        return reportDAO.update(reportDTO.getId(), report);
    }


    @Override
    public List<ReportDTO> getAll() {
        List<ReportDTO> reports = new ArrayList<>();
        for (Report report : reportDAO.getAll()) {
            reports.add(Transformer.transformReport(report));
        }
        return reports;
    }

    @Override
    public boolean delete(int id) {
        return reportDAO.delete(id);
    }

}
