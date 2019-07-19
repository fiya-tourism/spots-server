package com.fy.spotsserver.Util;


import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
@Data
public class PageUtils {

	/** 当前页 */
	private int page = 1;
	/** 每页条数 */
	private int rows = 3;
	/** 开始条数的下标 */
	private int startPos;
	
	/** 排序列 */
	private String sort;
	/** 排序方式 */
	private String order;

	// 条件
	private Integer userId; //景区id

	private String userName;
	@JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date userBir;  //结束时间



}
