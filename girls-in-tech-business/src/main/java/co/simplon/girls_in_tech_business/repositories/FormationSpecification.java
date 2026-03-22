package co.simplon.girls_in_tech_business.repositories;

import co.simplon.girls_in_tech_business.entities.Formation;
import org.springframework.data.jpa.domain.Specification;

public class FormationSpecification {

    public static Specification<Formation> formationNameContains(String formationName){
        return (root, query, criteriaBuilder) -> {
            if(formationName ==null || formationName.isEmpty()) return null;
            return criteriaBuilder.like(criteriaBuilder.lower(root.get("name")), "%" + formationName.toLowerCase() + "%");
        };
    }
    //root.get("name") no name is from Formation entity field

    public static Specification<Formation> schoolNameContains(String schoolName){
        return ((root, query, criteriaBuilder) -> {
           if(schoolName == null || schoolName.isEmpty()) return null;
           return criteriaBuilder.like(criteriaBuilder.lower(root.join("school").get("name")), "%" + schoolName.toLowerCase() + "%");
        });
    }

    public static Specification<Formation> diplomaNameContains(String diplomaName){
        return ((root, query, criteriaBuilder) -> {
            if(diplomaName == null || diplomaName.isEmpty()) return null;
            return criteriaBuilder.like(criteriaBuilder.lower(root.join("diploma").get("name")), "%" + diplomaName.toLowerCase() + "%");
        });
    }

    public static Specification<Formation> cityNameContains(String cityName){
        return ((root, query, criteriaBuilder) -> {
            if(cityName ==null || cityName.isEmpty()) return null;
            return criteriaBuilder.like(criteriaBuilder.lower(root.join("school").join("city").get("name")),"%" + cityName.toLowerCase() + "%");
        });
    }

    //SELECT f.*
    //FROM t_formations f
    //JOIN t_schools s ON f.school_id = s.id
    //JOIN t_diplomas d ON f.diploma_id = d.id
    //JOIN t_cities c ON s.city_id = c.id
    //WHERE
    //    (:courseName IS NULL OR LOWER(f.name) LIKE LOWER(CONCAT('%', :courseName, '%')))
    //    AND (:schoolName IS NULL OR LOWER(s.name) LIKE LOWER(CONCAT('%', :schoolName, '%')))
    //    AND (:diplomaName IS NULL OR LOWER(d.name) LIKE LOWER(CONCAT('%', :diplomaName, '%')))
    //    AND (:cityName IS NULL OR LOWER(c.name) LIKE LOWER(CONCAT('%', :cityName, '%')));
}
