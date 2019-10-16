package com.litmus7.shopmate.profile.service;

import com.litmus7.shopmate.profile.dao.WishListServiceDao;
import com.litmus7.shopmate.profile.dto.WishListDto;
//import com.litmus7.shopmate.profile.repository.WishListRepository;
import com.litmus7.shopmate.profile.repositorydao.WishListRepositoryDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class WishListService implements WishListServiceDao {

    @Autowired
    private WishListRepositoryDao wishListRepositoryDao;

    @Override
    public WishListDto addToUserWishList(WishListDto wishListDto) {

        return wishListRepositoryDao.save(wishListDto);

    }

    @Override
    public List<Integer> fetchWishListByUserId(int profileId) {

        List<Integer> skuIds = new ArrayList<>();
        for (WishListDto wishlistItem : wishListRepositoryDao.findByProfileId(profileId)) {
            skuIds.add(wishlistItem.getSkuId());
        }

        return skuIds;

    }
}
