package com.gamer.core.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gamer.core.po.Collections;
import com.gamer.core.po.Picture;

public interface CollectionDao {
	public List<Collections> findAllCollection(Integer UserId);
	public void addCollection(@Param("user")Integer UserId,@Param("picture")Integer PictureId,@Param("date")Date date);
	public void removeCollection(@Param("user")Integer UserId,@Param("picture")Integer PictureId);
	public List<Integer> findPictureByUserId(@Param("user")Integer UserId);
	public List<Collections> findAllCollectionByPicture(@Param("user")Integer UserId);
	
}
