package ex016_EmptyInterface;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public enum Segment {
    TSX("TSX", "/download/issuedatafile/daily/csv?product_id=82&date="),
    CDX("CDX", "/download/tsxvissuedatafile/daily/csv?product_id=127&date=");

    private String excode;
    private String uriPath;

    Segment(String excode, String uriPath) {
        this.excode = excode;
        this.uriPath = uriPath;
    }
    public String getPath(LocalDate now) {
        return uriPath +  now.format(DateTimeFormatter.ISO_LOCAL_DATE);
    }

    public String getExcode() {
        return excode;
    }
}