package com.wudy.domain.webparser;

import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringEscapeUtils;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

/**
 * @author : Jaden
 * @since : 01/07/2017
 */

@Component
@Slf4j
public class WebParsingFactory {

	@Setter
	private String urlPath;


	/**
	 * @return html full content
	 */
	private String getHtmlContent() {
		String pageContents;
		StringBuilder contents = new StringBuilder();

		try {

			URL url = new URL(urlPath);
			URLConnection con = (URLConnection) url.openConnection();
			InputStreamReader reader = new InputStreamReader(con.getInputStream(), "utf-8");

			BufferedReader buff = new BufferedReader(reader);

			while ((pageContents = buff.readLine()) != null) {
				contents.append(pageContents);
				contents.append("\r\n");
			}

			buff.close();

		} catch (Exception e) {
			log.error("An exception occurs!{}", e);
		}
		return contents.toString();
	}

	private String getContentWithoutTags(String target) {
		return target.replaceAll("<[^>]*>", "");
	}

	public String getBody() {
		String content = getHtmlContent().split("size5")[1].split("enter")[0];
		content = content.replaceAll("-->|enter", "").replace("/^ /gi", "");

		return refinedData(getContentWithoutTags(content));
	}

	public String getCreatedDate() {
		return getHtmlContent().split("기사입력<em>")[1].split("</em>")[0];
	}

	public String getModifiedDate() {
		return getHtmlContent().split("최종수정<em>")[1].split("</em>")[0];
	}


	/**
	 *
	 * @param data
	 * @return 정제된 HTML string
	 */
	private String refinedData(String data) {
		return StringEscapeUtils.unescapeHtml3(data);
	}

	public String getProperty(OpenGraphProperties openGraphProperties) throws Exception {
		OpenGraph openGraph = new OpenGraph(urlPath, true);
		return refinedData(openGraph.getContent(openGraphProperties.getValue()));
	}

}
