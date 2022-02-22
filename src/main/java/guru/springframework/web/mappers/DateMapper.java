package guru.springframework.web.mappers;

import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;


@Component
public class DateMapper {

    public OffsetDateTime asOffsetDateDateTime(Timestamp timestamp){

        if (timestamp!= null){
            return OffsetDateTime.of(timestamp.toLocalDateTime().getYear(), timestamp.toLocalDateTime().getDayOfMonth(),
                    timestamp.toLocalDateTime().getDayOfMonth(),timestamp.toLocalDateTime().getHour(),timestamp.toLocalDateTime().getMinute(),
                    timestamp.toLocalDateTime().getSecond(), timestamp.toLocalDateTime().getNano(),
                    ZoneOffset.UTC);
        }else{
            return null;
        }

    }


    public Timestamp asTimeTamp(OffsetDateTime offsetDateTime){
        if (offsetDateTime!= null){
            return Timestamp.valueOf(offsetDateTime.atZoneSameInstant(ZoneOffset.UTC).toLocalDateTime());
        }else{
            return null;
        }
    }
}
