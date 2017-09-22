package com.cn.website.myblob.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cn.website.myblob.dao.MyBlobDao;
import com.cn.website.weixinpay.bean.BlobLinkme;

@Service("myBlobServiceImpl")
@Transactional(value ="txManager")
public class MyBlobServiceImpl implements MyBlobService {

	@Autowired
	@Qualifier("myBlobDaoImpl")
	private MyBlobDao myBlobDao;

	//保存联系方式
	public long saveBlobLink(BlobLinkme blobLinkme) {
		return (long) myBlobDao.save(blobLinkme);
	}
}
