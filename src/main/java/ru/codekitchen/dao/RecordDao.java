package ru.codekitchen.dao;

import org.springframework.stereotype.Repository;
import ru.codekitchen.entity.Record;
import ru.codekitchen.entity.RecordStatus;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//   dao(data access object) - компонент, который является точкой доступа к данным
@Repository             // то же самое что и component
public class RecordDao {
    private final List<Record> records = new ArrayList<>(
            Arrays.asList(
                    new Record("Take a shower", RecordStatus.ACTIVE),
                    new Record("Buy flowers", RecordStatus.ACTIVE),
                    new Record("Go to the gym", RecordStatus.ACTIVE)
            )
    );

    public List<Record> findAllRecords(){
        return new ArrayList<>(records);
    }

}
