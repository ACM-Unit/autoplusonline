package ua.com.autoplus.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ua.com.autoplus.entity.Category;
import ua.com.autoplus.entity.Part;

import java.math.BigInteger;
import java.util.List;

@Repository
public interface PartRepository  extends JpaRepository<Part, Integer> {
    Page<Part> findByCategory(Category category, Pageable pageable);
    Page<Part> findByCategoryAndNameLike(Category category, String place, Pageable pageable);
    Page<Part> findByCategoryIn(List<Category> categoryList, Pageable pageable);
    Page<Part> findByCategoryInAndNameLike(List<Category> categoryList, String place, Pageable pageable);
    @Query(value = "SELECT * FROM ap_parts p WHERE MATCH(p.code, p.name, p.slug) AGAINST(?2 IN BOOLEAN MODE) AND p.parent_id in (?1)",
            countQuery = "SELECT * FROM ap_parts p WHERE MATCH(p.code, p.name, p.slug) AGAINST(?2 IN BOOLEAN MODE) AND p.parent_id in (?1)",
            nativeQuery = true)
    Page<Part> findByCategoryInAndFullTextSearch(List<BigInteger> categoryList, String place, Pageable pageable);
    @Query(value = "SELECT * FROM ap_parts p WHERE MATCH(p.code, p.name, p.slug) AGAINST(?1 IN BOOLEAN MODE) ORDER BY ?#{#pageable}",
            countQuery = "SELECT * FROM ap_parts p WHERE MATCH(p.code, p.name, p.slug) AGAINST(?1 IN BOOLEAN MODE)",
            nativeQuery = true)
    Page<Part> findByFullTextSearch(String place, Pageable pageable);
    @Query(value = "SELECT p FROM Part p WHERE MatchAgainst(p.code, p.name, p.slug, :place) > 0 and p.category in (:categoryList)")
    Page<Part> findByFullTextSearchAp(List<Category> categoryList, String place, Pageable pageable);

}
