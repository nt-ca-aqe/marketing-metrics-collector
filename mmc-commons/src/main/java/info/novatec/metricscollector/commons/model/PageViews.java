package info.novatec.metricscollector.commons.model;

import lombok.Getter;


@Getter
public class PageViews {

    private String timestamp;

    private Integer totalVisits;

    private Integer uniqueVisits;

    public PageViews(String timestamp, Integer totalVisits, Integer uniqueVisits) {
        this.timestamp = timestamp;
        this.totalVisits = totalVisits;
        this.uniqueVisits = uniqueVisits;
    }

}
