package module.crawler;

import edu.uci.ics.crawler4j.crawler.CrawlConfig;
import edu.uci.ics.crawler4j.crawler.CrawlController;
import edu.uci.ics.crawler4j.crawler.authentication.AuthInfo;
import edu.uci.ics.crawler4j.crawler.authentication.BasicAuthInfo;
import edu.uci.ics.crawler4j.crawler.authentication.FormAuthInfo;
import edu.uci.ics.crawler4j.fetcher.PageFetcher;
import edu.uci.ics.crawler4j.robotstxt.RobotstxtConfig;
import edu.uci.ics.crawler4j.robotstxt.RobotstxtServer;
import infra.Config;

public class Controller {
	private static final int maxDepthOfCrawling = 0;
	private static final String crawlStorageFolder = "/data/crawl/root";
	private static final int numberOfCrawlers = 7;
	private static final int socketTimeout = 5000;
	private static final int connectionTimeout = 5000;

	public static void crawl() throws Exception {

		CrawlConfig crawlConfig = new CrawlConfig();
		crawlConfig.setCrawlStorageFolder(crawlStorageFolder);
		crawlConfig.setMaxDepthOfCrawling(maxDepthOfCrawling);
		crawlConfig.setSocketTimeout(socketTimeout);
		crawlConfig.setConnectionTimeout(connectionTimeout);

		AuthInfo authInfo = new FormAuthInfo(
				Config.get("username"), Config.get("password")
				, Config.get("baseUrl") + Config.get("loginUrl")
				, Config.get("usernameFormStr"), Config.get("passwordFormStr"));
		authInfo.setPort(Integer.parseInt(Config.get("port")));
		crawlConfig.addAuthInfo(authInfo);

		/*
		 * Instantiate the controller for this crawl.
		 */
		PageFetcher pageFetcher = new PageFetcher(crawlConfig);
		RobotstxtConfig robotstxtConfig = new RobotstxtConfig();
		RobotstxtServer robotstxtServer = new RobotstxtServer(robotstxtConfig, pageFetcher);
		CrawlController controller = new CrawlController(crawlConfig, pageFetcher, robotstxtServer);

		/*
		 * For each crawl, you need to add some seed urls. These are the first
		 * URLs that are fetched and then the crawler starts following links
		 * which are found in these pages
		 */
		controller.addSeed(Config.get("baseUrl") + Config.get("lastUrl"));

		/*
		 * Start the crawl. This is a blocking operation, meaning that your code
		 * will reach the line after this only when crawling is finished.
		 */
		controller.start(Crawler.class, numberOfCrawlers);
		
		System.out.println("crawling is finished");
	}
}