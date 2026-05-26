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
    private final List<Record> records = new ArrayList<Record>(
            Arrays.asList(
                    new Record("Take a shower", RecordStatus.ACTIVE),
                    new Record("Take a shower", RecordStatus.DONE),
                    new Record("Take a shower", RecordStatus.ACTIVE)
            )
    );

}
