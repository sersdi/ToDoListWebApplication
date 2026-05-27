package ru.codekitchen.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.codekitchen.entity.Record;
import ru.codekitchen.entity.RecordStatus;
import ru.codekitchen.service.RecordService;

import java.util.List;

@Controller
// @RequestMapping("/prefix")
public class CommonController {
    private final RecordService recordService;

    @Autowired
    public CommonController(RecordService recordService) {
        this.recordService = recordService;
    }

    @RequestMapping("/home")
    public String getMainPage(Model model) {        //model(Interface) под капотом мапа
        List<Record> records = recordService.findAllRecords();
        int numberOfDoneRecords = (int) records.stream().filter(record -> record.getStatus() == RecordStatus.DONE).count();
        int numberOfActiveRecords = (int) records.stream().filter(record -> record.getStatus() == RecordStatus.ACTIVE).count();
        model.addAttribute("records", records);
        model.addAttribute("numberOfDoneRecords",numberOfDoneRecords);
        model.addAttribute("numberOfActiveRecords",numberOfActiveRecords);
        return "main-page";
    }
}
