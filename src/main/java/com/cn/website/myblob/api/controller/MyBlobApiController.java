package com.cn.website.myblob.api.controller;


import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cn.website.common.entity.MessageNotice;
import com.cn.website.common.entity.MessageObject;
import com.cn.website.common.util.DateUtil;
import com.cn.website.myblob.bean.BlobLinkme;
import com.cn.website.myblob.service.MyBlobService;


@RestController
@RequestMapping("api/myblob")
public class MyBlobApiController {
	
	@Autowired
	@Qualifier("myBlobServiceImpl")
	private MyBlobService myBlobServiceImpl;
	/**
	 * 保存联系方式
	 * @return
	 */
	@RequestMapping(value = "saveLink",method = RequestMethod.POST)
	private MessageNotice saveLink(@RequestBody BlobLinkme blobLinkme){
		MessageObject<Long> mnt = new MessageObject<Long>();
		mnt.setCode(1);
		blobLinkme.setAddTime(new Date(DateUtil.getCurrentDate().getTime()));
		mnt.setData(myBlobServiceImpl.saveBlobLink(blobLinkme));
		return mnt;
	}
}