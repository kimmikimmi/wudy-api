package com.wudy.domain.webparser.dao;

import com.google.common.collect.Lists;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author : Jaden
 * @since : 01/07/2017
 */
@Repository
public class RichWudyImpl implements RichWudy{

	@Override
	public List<String> getUrlListInHorizontal(int size, Long timeStamp) {
		return Lists.newArrayList();
	}

	@Override
	public List<String> getUrlListInVertical(String url, int size, Long timeStamp) {
		return Lists.newArrayList();
	}
}
