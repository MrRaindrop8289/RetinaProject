package com.gamer.core.service.impl;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gamer.common.utils.DateFormat;
import com.gamer.core.dao.CollectionDao;
import com.gamer.core.dao.PictureDao;
import com.gamer.core.po.*;
import com.gamer.core.service.CollectionService;

@Service("CollectionService")
@Transactional
public class CollectionServiceImpl implements CollectionService {
	@Autowired
	private CollectionDao dao;
	@Autowired
	private PictureDao PDao;
	
	

	@Override
	public List<Picture> findAllCollection(Integer UserId) {
		// TODO Auto-generated method stub
		List<Collections> lPictureId = dao.findAllCollectionByPicture(UserId);
		List<Picture> lPicture = new ArrayList<Picture>();
		for (Collections i:lPictureId) {
			Picture p = this.PDao.findPictureById(i.getPicture_id());
			p.setDateS(DateFormat.Transform(i.getDate()));
			lPicture.add(p);
		}
		return lPicture;
	}

	@Override
	public void addCollection(Integer UserId, Integer PictureId) {
		// TODO Auto-generated method stub
		this.dao.addCollection(UserId, PictureId,new Date());
	}

	@Override
	public void removeCollection(Integer UserId, Integer PictureId) {
		// TODO Auto-generated method stub
		this.dao.removeCollection(UserId, PictureId);
	}

	@Override
	public List<Integer> findPictureByUserId(Integer userid) {
		// TODO Auto-generated method stub
		return dao.findPictureByUserId(userid);
	}

}
