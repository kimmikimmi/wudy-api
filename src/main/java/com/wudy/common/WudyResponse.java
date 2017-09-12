package com.wudy.common;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * @author : Jaden
 * @since : 01/07/2017
 */
@Getter
@Setter
public class WudyResponse {
	public int code = 0;
	public String message;
	public Object result;
}
