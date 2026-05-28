package ru.codekitchen.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.codekitchen.dao.RecordDao;
import ru.codekitchen.entity.Record;
import ru.codekitchen.entity.RecordStatus;

import java.util.List;

@Service                        // Семантически отделяет бизнес логику(тоже-самое что и component)
public class RecordService {
    private final RecordDao recordDao;

    @Autowired
    public RecordService(RecordDao recordDao) {
        this.recordDao = recordDao;
    }

    public List<Record>findAllRecords(){
        return recordDao.findAllRecords();
    }

    public void saveRecord(String title){
        if(title !=null && !title.isBlank()){
            recordDao.saveRecord(new Record(title));
        }
    }

    public void updateRecordStatus(String title, RecordStatus newStatus){
        recordDao.updateRecordStatus(title,newStatus);
    }

    public void  deleteRecord(String title){
        recordDao.deleteRecord(title);
    }
}
