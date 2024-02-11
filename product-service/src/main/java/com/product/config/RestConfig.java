package com.product.config;

import com.product.entity.Product;
import com.product.entity.ProductCategory;
import jakarta.persistence.EntityManager;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

@Configuration
public class RestConfig implements RepositoryRestConfigurer {

    private EntityManager entityManager;

    public RestConfig(EntityManager theEntityManager) {
        entityManager = theEntityManager;
    }

    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {

//        Disable some methods on exposed API Endpoints via Spring Data Rest
        HttpMethod[] unsupportedMethods = {HttpMethod.PUT,HttpMethod.POST,HttpMethod.DELETE};
        disableHttpMethods(Product.class, config, unsupportedMethods);
        disableHttpMethods(ProductCategory.class, config, unsupportedMethods);

//        disableHttpMethods(Country.class,config, unsupportedmethods);
//        disableHttpMethods(State.class,config, unsupportedmethods);

//        exposeIds(config);
    }

    private void disableHttpMethods(Class theclass,RepositoryRestConfiguration config, HttpMethod[] unsupportedmethods) {
        config.getExposureConfiguration()
                .forDomainType(theclass)
                .withItemExposure((metadata, httpmethods) -> httpmethods.disable(unsupportedmethods))
                .withCollectionExposure((metadata, httpmethods) -> httpmethods.disable(unsupportedmethods));
    }

//    private void exposeIds(RepositoryRestConfiguration config) {
//
//        // expose entity ids
//        //
//
//        // - get a list of all entity classes from the entity manager
//        Set<EntityType<?>> entities = entityManager.getMetamodel().getEntities();
//
//        // - create an array of the entity types
//        List<Class> entityClasses = new ArrayList<>();
//
//        // - get the entity types for the entities
//        for (EntityType tempEntityType : entities) {
//            entityClasses.add(tempEntityType.getJavaType());
//        }
//
//        // - expose the entity ids for the array of entity/domain types
//        Class[] domainTypes = entityClasses.toArray(new Class[0]);
//        config.exposeIdsFor(domainTypes);
//    }


}
