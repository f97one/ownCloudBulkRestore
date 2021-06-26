package net.formula97.owncloudbulkrestore.domain;

import jakarta.xml.bind.annotation.adapters.XmlAdapter;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class JavaTimestampAdapter extends XmlAdapter<String, ZonedDateTime> {

    @Override
    public ZonedDateTime unmarshal(String v) throws Exception {
        return ZonedDateTime.parse(v, DateTimeFormatter.RFC_1123_DATE_TIME);
    }

    @Override
    public String marshal(ZonedDateTime v) throws Exception {
        return v.format(DateTimeFormatter.RFC_1123_DATE_TIME);
    }
}
