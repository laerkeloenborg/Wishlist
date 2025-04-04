package org.example.wishlist.service;

import org.example.wishlist.model.User;
import org.example.wishlist.model.Wish;
import org.example.wishlist.model.Wishlist;
import org.example.wishlist.repository.UserRepository;
import org.example.wishlist.repository.WishRepository;
import org.example.wishlist.repository.WishlistRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WishService {
    private final WishRepository wishRepository;
    private final WishlistRepository wishlistRepository;
    private final UserRepository userRepository;

    public WishService(WishRepository wishRepository, WishlistRepository wishlistRepository, UserRepository userRepository) {
        this.wishRepository = wishRepository;
        this.wishlistRepository = wishlistRepository;
        this.userRepository = userRepository;
    }

    public List<Wishlist> getAllWishLists() {
        return wishlistRepository.getAllWishList();
    }

    public void updateWish(Wish wish) {
        wishRepository.updateWish(wish);
    }

    public void updateWishlist(Wishlist wishlist){
        wishlistRepository.updateWishlist(wishlist);
    }

    public boolean login(String uid, String pw) {
        User user = userRepository.getUser(uid);
        if (user != null) {
            // user found - check credentials
            return user.getPw().equals(pw);
        }
        // user not found
        return false;
    }

    public Wishlist getWishlistById(int id) {
        return wishlistRepository.getWishlistById(id);
    }

    public List<Wish> getWishById(int id) {
        return wishRepository.getWishById(id);
    }
}
