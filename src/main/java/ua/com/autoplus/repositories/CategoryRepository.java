package ua.com.autoplus.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ua.com.autoplus.entity.Category;

import java.math.BigInteger;
import java.util.List;
@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
    List<Category> findByParentIdIsNull();
    Category findByReference(String reference);
    @Query(value = "with recursive cte (id, level, title, parent_id, reference) as (\n" +
            "  select     id,\n" +
            "             1 as level,\n" +
            "             title,\n" +
            "             parent_id,\n" +
            "             reference\n" +
            "  from       autoplus.category\n" +
            "  where      reference = ?\n" +
            "  union all\n" +
            "  select     p.id,\n" +
            "             cte.level + 1,\n" +
            "             p.title,\n" +
            "             p.parent_id,\n" +
            "             p.reference\n" +
            "  from       autoplus.category p\n" +
            "  inner join cte\n" +
            "          on p.parent_id = cte.id\n" +
            ")\n" +
            "select * from cte", nativeQuery = true)
    List<Category> findByLastLevelChildren(String reference);
    @Query(value = "with recursive cte (id) as (\n" +
            "  select     id\n" +
            "  from       autoplus.category\n" +
            "  where      reference = ?\n" +
            "  union all\n" +
            "  select     p.id\n" +
            "  from       autoplus.category p\n" +
            "  inner join cte\n" +
            "          on p.parent_id = cte.id\n" +
            ")\n" +
            "select id from cte", nativeQuery = true)
    List<BigInteger> findByLastLevelChildrenId(String reference);
}
