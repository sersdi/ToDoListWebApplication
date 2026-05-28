package ru.codekitchen.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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

    @RequestMapping("/")
    public String redirectToHomePage() {
        return "redirect:/home";
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

    @RequestMapping(value="/add-record", method = RequestMethod.POST)    //record name = Buy flowers
    public String addRecord(@RequestParam String title){
        recordService.saveRecord(title);
        return "redirect:/home";
    }

    @RequestMapping(value="/make-record-done", method = RequestMethod.POST)    //record name = Buy flowers
    public String makeRecordDone(@RequestParam String title){
        recordService.updateRecordStatus(title, RecordStatus.DONE);
        return "redirect:/home";
    }

    @RequestMapping(value="/delete-record", method = RequestMethod.POST)    //record name = Buy flowers
    public String deleteRecord(@RequestParam String title){
        recordService.deleteRecord(title);
        return "redirect:/home";
    }
}
