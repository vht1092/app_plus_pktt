package routing;

import javax.servlet.http.HttpServletRequest;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

// Ä�Ã¢y lÃ  má»™t DataSource.
public class MyRoutingDataSource extends AbstractRoutingDataSource {

	@Override
	protected Object determineCurrentLookupKey() {

		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
				.getRequest();

		// Xem thÃªm: DataSourceInterceptor
		String keyDS = (String) request.getAttribute("keyDS");

		System.out.println("KeyDS = DW.WORLD");
		// System.out.println("KeyDS=" + keyDS);

		if (keyDS == null) {
			keyDS = "DW_DS";
		}

		return keyDS;
	}

}
