package com.gamer.core.service;

import java.util.List;

import com.gamer.core.po.Picture;

public interface PictureService {
	public List<Picture> findAllPicture();
	public Picture findPictureById(Integer id);
	public List<Picture> findDischeck(Integer id);
	public List<Picture> findStudentPicture();
	public boolean updatePicture(Picture p);
	public void addPicture(Picture p);
}
