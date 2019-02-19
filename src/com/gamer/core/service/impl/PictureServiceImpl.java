package com.gamer.core.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gamer.core.dao.PictureDao;
import com.gamer.core.po.Picture;
import com.gamer.core.service.PictureService;

@Service("pictureService")
@Transactional
public class PictureServiceImpl implements PictureService {
	@Autowired
	private PictureDao pictureDao;

	/**
	 * 查找所有的图片
	 */
	@Override
	public List<Picture> findAllPicture() {
		List<Picture> lPicture = pictureDao.findAllPicture();
		return lPicture;
	}
	/**
	 * 通过Id查找图片
	 */
	@Override
	public Picture findPictureById(Integer id) {
		// TODO Auto-generated method stub
		Picture picture = pictureDao.findPictureById(id);
		
		return picture;
	}
	
	/**
	 * 返回随机未标注完图片数
	 */

	@Override
	public List<Picture> findDischeck(Integer id) {
		// TODO Auto-generated method stub
		List<Picture> lPicture  = pictureDao.findAllDischeck(id);
		int size = lPicture.size();
		System.out.println("Picture Read.");
		return lPicture;
	}
	
	/**
	 * 更新数据
	 */
	public boolean updatePicture(Picture p){
		int x = pictureDao.updatePicture(p);
		if(x > 0){
			return true;
		}else{
			return false;
		}
		
	}
	@Override
	public void addPicture(Picture p) {
		// TODO Auto-generated method stub
		pictureDao.addPicture(p);
	}
	@Override
	public List<Picture> findStudentPicture() {
		// TODO Auto-generated method stub
		return pictureDao.findStudentPicture();
	}
}
