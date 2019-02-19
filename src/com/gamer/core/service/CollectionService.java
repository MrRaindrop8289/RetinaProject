package com.gamer.core.service;

import java.util.List;

import com.gamer.core.po.Picture;

public interface CollectionService {
	public List<Picture> findAllCollection(Integer UserId);
	public void addCollection(Integer UserId,Integer PictureId);
	public void removeCollection(Integer UserId,Integer PictureId);
	public List<Integer> findPictureByUserId(Integer userid);
}
