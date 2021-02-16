package com.billennium.store.cart;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {
	
	@Query("select u from Cart u where u.id = :id")
	Cart findByCartId(@Param("id") Long id);
}
