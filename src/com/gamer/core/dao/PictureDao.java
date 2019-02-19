package com.gamer.core.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gamer.core.po.Picture;

public interface PictureDao {
	public List<Picture> findAllPicture();
	public Picture findPictureById(Integer id);
	public List<Picture> findAllDischeck(Integer id);
	public List<Picture> findStudentPicture();
	public int updatePicture(Picture p);
	public void addPicture(@Param("p")Picture p);
}
