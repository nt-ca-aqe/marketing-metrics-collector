package info.novatec.metricscollector.github.collector;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import info.novatec.metricscollector.github.util.DataProvider;

import info.novatec.metricscollector.github.RestService;
import info.novatec.metricscollector.github.Metrics;


@RunWith(SpringRunner.class)
public class ClosedIssuesTest {

    @MockBean
    private RestService restService;

    @MockBean
    private ResponseEntity<String> response;

    private Metrics metrics;
  
    @Before
    public void init() {
        metrics = DataProvider.createEmptyMetrics();
    }

    @Test
    public void collectTest() {
        String mockedResponseBody = "[{},{},{}]";
        when(restService.sendRequest(DataProvider.getRestURL(metrics.getRepositoryName()) + "/issues/events")).thenReturn(response);
        when(response.getBody()).thenReturn(mockedResponseBody);

        ClosedIssues numberOfClosedIssues = new ClosedIssues(restService, metrics);
        numberOfClosedIssues.collect();
        assertThat(metrics.getClosedIssues()).isEqualTo(3);
    }
}