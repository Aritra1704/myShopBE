/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.arpaul.myshop.repositories;

import io.arpaul.myshop.payload.schemas.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ARPaul
 */
@Repository
public interface CategoryRepository extends JpaRepository<Category, Long>{

}
