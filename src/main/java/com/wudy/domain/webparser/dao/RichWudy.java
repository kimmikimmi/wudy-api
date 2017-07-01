package com.wudy.domain.webparser.dao;

import java.util.List;

/**
 * @author : Jaden
 * @since : 01/07/2017
 */
public interface RichWudy {

	List<String> getUrlListInHorizontal(int size, Long timeStamp);

	List<String> getUrlListInVertical(String url, int size, Long timeStamp);
}
