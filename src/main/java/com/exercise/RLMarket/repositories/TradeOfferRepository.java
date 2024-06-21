package com.exercise.RLMarket.repositories;

import com.exercise.RLMarket.enteties.TradeOffer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TradeOfferRepository extends JpaRepository<TradeOffer, Integer> {
    @Query("SELECT t FROM TradeOffer t WHERE t.user.id = :userId")
    List<TradeOffer> findTradeOfferByUser(int userId);
}
